package org.emftext.refactoring.smell.registry;

import org.eclipse.ui.ide.IDE;
import org.emftext.refactoring.smell.calculation.CausingObjectsGroup;


public interface IQualitySmellMarker {
	
	/**
	 * The id of this kind of marker.
	 */
	public static final String ID			= "org.emftext.refactoring.smell.problem";
	
	/**
	 * Identifier of the rolemapping attribute of the quality smell marker.
	 */
	public static final String ROLEMAPPING	= "roleMapping";
	
	/**
	 * This attribute can be used to save the editor ID in the marker.
	 * It then can be used in the {@link SmellResolutionQuickFix#run(org.eclipse.core.resources.IMarker)}
	 * method to open the correct editor if several editors are registered agains
	 * the file extension (e.g. JDT and JaMoPP editor for *.java files).
	 * This attribute can be set in {@link SmellChecker#addSmellAndQuickFix(org.eclipse.core.resources.IFile, org.eclipse.emf.ecore.EObject, org.emftext.refactoring.smell.calculation.Calculation, org.emftext.refactoring.smell.calculation.CalculationResult, org.emftext.language.refactoring.rolemapping.RoleMapping, org.emftext.refactoring.editorconnector.IEditorConnector)}
	 * and added to the marker. 
	 */
	public static final String EDITOR_ID	= IDE.EDITOR_ID_ATTR;
	
	/**
	 * Identifier of the bindings attribute of the quality smell marker. Here additional causing elements, belonging to the same {@link CausingObjectsGroup} are referred.
	 */
	public static final String BINDINGS	= "bindings";

	/**
	 * Identifier of the quality attribute of the quality smell marker. It is used to communicate the quality which was affected by this quality smell marker.
	 */
	public static final String QUALITY = "quality";
	
	/**
	 * This is the ID used in the markerSupport extension. And this, on the other side, is used to create
	 * a quality smells view.
	 */
	public static final String CONTENT_GENERATOR_ID	= "org.emftext.refactoring.smell.problem.contentgenerator";

	/**
	 * These strings is used to split the different element uris in the bindings attribute of a marker.
	 */
	public static final String BINDINGS_SPLIT_STRING		= ")(";
	public static final String BINDINGS_NAME_SPLIT_STRING	= ":=";
}
