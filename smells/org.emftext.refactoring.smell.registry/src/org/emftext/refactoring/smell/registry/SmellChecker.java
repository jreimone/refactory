package org.emftext.refactoring.smell.registry;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;

public class SmellChecker implements IResourceChangeListener, IResourceDeltaVisitor {

	private QualitySmellModel smellModel;
	private CalculationModel calculationModel;

	public SmellChecker(QualitySmellModel smellModel, CalculationModel calculationModel) {
		this.smellModel = smellModel;
		this.calculationModel = calculationModel;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		// only registered for IResourceChangeEvent.POST_CHANGE events
		//		if (event.getType() == IResourceChangeEvent.POST_CHANGE && getChangedResource(delta).getMarkerDeltas().length <= 0){
		try {
			IResourceDelta delta = event.getDelta();
			if(delta.getAffectedChildren() != null && delta.getAffectedChildren().length > 0 && delta.getMarkerDeltas().length == 0){
				delta.accept(this);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource res = delta.getResource();
		IMarkerDelta[] markerDeltas = delta.getMarkerDeltas();
		boolean ownMarkersChanged = false;
		if(markerDeltas.length > 0){
			for (IMarkerDelta markerDelta : markerDeltas) {
				if(markerDelta.getType().equals(IQualitySmellMarker.ID)){
					ownMarkersChanged = true;
					break;
				}
			}
		}
		IFile file = (IFile) res.getAdapter(IFile.class);
		if(file != null && !ownMarkersChanged){
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				checkSmellsInFile(file);
				break;
			case IResourceDelta.CHANGED:
				checkSmellsInFile(file);
				break;
			case IResourceDelta.REMOVED:
				break;
			}
		}
		return true; // visit the children
	}

	private void checkSmellsInFile(IFile file) {
		URI uri = null;
		if(file.isLinked()){
			uri = URI.createFileURI(file.getLocation().toString());
		} else {
			uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		}
		Resource resource = null;
		try {
			ResourceSet rs = new ResourceSetImpl();
			resource = rs.getResource(uri, true);
		} catch (Exception e) {
			// just do nothing
		}
		if(resource != null){
			IEditorPart editorPart = getEditorPartForFile(file);
			IEditorConnector editorConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(editorPart);
			EObject model = null;
			if(editorConnector != null){
				model = editorConnector.getModel();
			} else {
				model = resource.getContents().get(0);
			}
			if(model != null){
				EPackage metamodel = model.eClass().getEPackage();
				List<ConcreteQualitySmell> smells = smellModel.getSmellsForMetamodel(metamodel);
				for (ConcreteQualitySmell qualitySmell : smells) {
					RoleMapping roleMapping = qualitySmell.getRefactoring();
					List<QualityCalculation> qualityCalculations = qualitySmell.getQualityCalculations();
					for (QualityCalculation qualityCalculation : qualityCalculations) {
						Calculation calculation = qualityCalculation.getCalculation();
						if(calculation.eIsProxy()){
							EcoreUtil.resolveAll(calculation);
							ResourceSet resourceSet = calculationModel.eResource().getResourceSet();
							calculation = (Calculation) EcoreUtil.resolve(calculation, resourceSet);
							calculation = (Calculation) EcoreUtil.resolve(calculation, calculationModel.eResource());
						}
						if(calculation != null && !calculation.eIsProxy()){
							float threshold = qualityCalculation.getThreshold();
							CalculationResult result = calculation.calculate(model, threshold);
							float resultingValue = result.getResultingValue();
							Monotonicity monotonicity = calculation.getMonotonicity();
							switch (monotonicity) {
							case DECREASING: 
								// je größer der wert desto schlechter die qualität 
								// --> smell trifft zu wenn result >= threshold
								if(resultingValue >= threshold){
									addSmellAndQuickFix(file, model, calculation, result, roleMapping, editorConnector);
								}
								break;
							case INCREASING: 
								// je größer der wert desto besser die qualität
								// --> smell trifft zu wenn result <= threshold
								if(resultingValue <= threshold){
									addSmellAndQuickFix(file, model, calculation, result, roleMapping, editorConnector);
								}
								break;
							}
						}
					}
				}
			}
		}
	}

	private IEditorPart getEditorPartForFile(IFile file) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null){
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if(activePage != null){
				try {
					IEditorPart editor = IDE.openEditor(activePage, file);
					return editor;
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	protected void addSmellAndQuickFix(final IFile file, final EObject model, final Calculation calculation, final CalculationResult result, final RoleMapping roleMapping, final IEditorConnector editorConnector) {
		WorkspaceJob job = new WorkspaceJob("Creating markers for bad smells") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
//					IMarker[] markers = file.findMarkers(IQualitySmellMarker.ID, true, IResource.DEPTH_INFINITE);
//					for (IMarker marker : markers) {
//						marker.delete();
//					}
					String smellMessage = calculation.getSmellMessage();
					List<EObject> causingObjects = result.getCausingObjects();
					for (EObject element : causingObjects) {
						IMarker marker = file.createMarker(IQualitySmellMarker.ID);
						marker.setAttribute(IMarker.LOCATION, EcoreUtil.getURI(element).toString());
						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
						marker.setAttribute(IMarker.MESSAGE, smellMessage);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						marker.setAttribute(IMarker.LINE_NUMBER, 0);
						if(editorConnector != null){
							editorConnector.setMarkingForEObject(element, marker);
						}
						marker.setAttribute(IQualitySmellMarker.ROLEMAPPING, EcoreUtil.getURI(roleMapping).toString());
						//TODO jreimann: determine different registered editors and select the most appropriate one.
						//TODO jreimann: set marker.setAttribute(IQualitySmellMarker.EDITOR_ID, editorID); 
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
		System.out.println("marker created");
	}
}

