package org.emftext.refactoring.smell.registry;


public interface IQualitySmellMarker {
	
	public static final String ID				= "org.emftext.refactoring.smell.problem";
	public static final String ROLEMAPPING	= "roleMapping";
	
	/**
	 * This attribute can be used to save the editor ID in the marker.
	 * It then can be used in the {@link SmellResolutionQuickFix#run(org.eclipse.core.resources.IMarker)}
	 * method to open the correct editor if several editors are registered agains
	 * the file extension (e.g. JDT and JaMoPP editor for *.java files).
	 * This attribute can be set in {@link SmellChecker#addSmellAndQuickFix(org.eclipse.core.resources.IFile, org.eclipse.emf.ecore.EObject, org.emftext.refactoring.smell.calculation.Calculation, org.emftext.refactoring.smell.calculation.CalculationResult, org.emftext.language.refactoring.rolemapping.RoleMapping, org.emftext.refactoring.editorconnector.IEditorConnector)}
	 * and added to the marker. 
	 */
	public static final String EDITOR_ID	= "EDITOR_ID_ATTR";
	
	/**
	 * This is the ID used in the markerSupport extension. And this, on the other side, is used to create
	 * a quality smells view.
	 */
	public static final String CONTENT_GENERATOR_ID	= "org.emftext.refactoring.smell.problem.contentgenerator";
}
