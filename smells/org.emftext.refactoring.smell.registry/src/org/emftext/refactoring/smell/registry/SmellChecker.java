package org.emftext.refactoring.smell.registry;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;

public class SmellChecker implements IResourceChangeListener, IResourceDeltaVisitor {

	private QualitySmellModel smellModel;

	public SmellChecker(QualitySmellModel smellModel) {
		this.smellModel = smellModel;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		// only registered for IResourceChangeEvent.POST_CHANGE events
		try {
			event.getDelta().accept(this);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource res = delta.getResource();
		IFile file = (IFile) res.getAdapter(IFile.class);
		switch (delta.getKind()) {
		case IResourceDelta.ADDED:
			if(file != null){
				checkSmellsInFile(file);
			}
			break;
		case IResourceDelta.REMOVED:
			break;
		case IResourceDelta.CHANGED:
			if(file != null){
				checkSmellsInFile(file);
			}
			break;
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
						if(calculation != null){
							float threshold = qualityCalculation.getThreshold();
							// TODO distinguish between Metric and Structure
							CalculationResult result = calculation.calculate(model, threshold);
							float resultingValue = result.getResultingValue();
							Monotonicity monotonicity = calculation.getMonotonicity();
							switch (monotonicity) {
							case DECREASING: 
								// je größer der wert desto schlechter die qualität 
								// --> smell trifft zu wenn result >= threshold
								if(resultingValue >= threshold){
									addSmellAndQuickFix(file, model, result, roleMapping);
								}
								break;
							case INCREASING: 
								// je größer der wert desto besser die qualität
								// --> smell trifft zu wenn result <= threshold
								if(resultingValue <= threshold){
									addSmellAndQuickFix(file, model, result, roleMapping);
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
		IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
		if(activePage != null){
			try {
				IEditorPart editor = IDE.openEditor(activePage, file);
				return editor;
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private void addSmellAndQuickFix(IFile file, EObject model, CalculationResult result, RoleMapping roleMapping) {
		
	}
}

