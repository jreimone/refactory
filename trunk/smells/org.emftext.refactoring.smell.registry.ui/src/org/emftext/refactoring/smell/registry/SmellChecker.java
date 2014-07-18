package org.emftext.refactoring.smell.registry;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.CausingObjectsGroup;
import org.emftext.refactoring.smell.calculation.NamedCausingObject;
import org.emftext.refactoring.smell.registry.util.Triple;
import org.osgi.framework.FrameworkUtil;

public class SmellChecker {

	public static void checkSmellsInFile(IEditorConnector editorConnector, IFile file) {
		if(editorConnector == null){
			return;
		}
		EObject model = editorConnector.getModel();
		Resource resource = model.eResource();
		List<Triple<CalculationResult,Calculation,QualityCalculation>> matchingCalculations = IQualitySmellRegistry.INSTANCE.getMatchingSmellCalculationsForResource(resource);
		for (Triple<CalculationResult, Calculation, QualityCalculation> triple : matchingCalculations) {
			CalculationResult result = triple.getFirst();
			Calculation calculation = triple.getSecond();
			QualityCalculation qualityCalculation = triple.getThird();
			Quality quality = qualityCalculation.getQuality();
			ConcreteQualitySmell concreteSmell = qualityCalculation.getConcreteSmell();
			List<RoleMapping> refactorings = concreteSmell.getRefactoring();
			if(refactorings == null || refactorings.size() == 0){
				addSmellAndQuickFix(file, calculation, result, null, editorConnector, quality);
			} else {
				for (RoleMapping roleMapping : refactorings) {
					addSmellAndQuickFix(file, calculation, result, roleMapping, editorConnector, quality);
				}
			}
		}
	}

	public static void removeAllMarkers(final IFile file) {
		if(file == null || !file.exists()){
			return;
		}
		WorkspaceJob runnable = new WorkspaceJob("Cleaning Quality Smell markers") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					IMarker[] markers = file.findMarkers(IQualitySmellMarker.ID, true, IResource.DEPTH_INFINITE);
					for (IMarker marker : markers) {
						marker.delete();
					}
				} catch (CoreException e) {
					e.printStackTrace();
					return new Status(IStatus.WARNING, FrameworkUtil.getBundle(getClass()).getSymbolicName(), "Quality Smell markers couldn't be deleted for " + file.getLocation().toString());
				}
				return Status.OK_STATUS;
			}
		};
		runnable.schedule();
	}

	private static void addSmellAndQuickFix(final IFile file, final Calculation calculation, final CalculationResult result, final RoleMapping roleMapping, final IEditorConnector editorConnector, final Quality quality) {
		WorkspaceJob job = new WorkspaceJob("Creating markers for quality smells") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					String smellMessage = calculation.getSmellMessage();
					List<CausingObjectsGroup> causingObjectsGroups = result.getCausingObjectsGroups();
					for (CausingObjectsGroup causingObjectsGroup : causingObjectsGroups) {
						List<NamedCausingObject> namedCausingObjects = causingObjectsGroup.getNamedCausingObjects();
						NamedCausingObject firstElement = namedCausingObjects.get(0);
						IMarker marker = file.createMarker(IQualitySmellMarker.ID);
						System.out.println("marker created");
						URI elementUri = EcoreUtil.getURI(firstElement);
						marker.setAttribute(IMarker.LOCATION, elementUri.toString());
						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
						marker.setAttribute(IMarker.MESSAGE, smellMessage);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						marker.setAttribute(IMarker.LINE_NUMBER, 0);
						String editorID = null;
						if(editorConnector != null){
							editorConnector.setMarkingForEObject(firstElement.getCausingObject(), marker);
							editorID = editorConnector.getEditor().getEditorSite().getId();
						}
						if(roleMapping != null){
							URI uri = EcoreUtil.getURI(roleMapping);
							marker.setAttribute(IQualitySmellMarker.ROLEMAPPING, uri.toString());
						}
						if(editorID != null){
							marker.setAttribute(IQualitySmellMarker.EDITOR_ID, editorID);
						}
						marker.setAttribute(IQualitySmellMarker.QUALITY, quality.getName());
						int causingObjectsCount = namedCausingObjects.size();
						String bindingsString = "";
						for (NamedCausingObject namedCausingObject : namedCausingObjects) {
							String name = namedCausingObject.getName();
							if(name != null && !"".equals(name)){
								bindingsString += name + IQualitySmellMarker.BINDINGS_NAME_SPLIT_STRING;
							}
							EObject causingObject = namedCausingObject.getCausingObject();
							// name:=uri)(name:=ri)(name:=uri
							elementUri = EcoreUtil.getURI(causingObject);
							bindingsString += elementUri.toString();
							if(namedCausingObjects.indexOf(namedCausingObject) < causingObjectsCount - 1){
								bindingsString += IQualitySmellMarker.BINDINGS_SPLIT_STRING;
							}
						}
						marker.setAttribute(IQualitySmellMarker.BINDINGS, bindingsString);
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
}

