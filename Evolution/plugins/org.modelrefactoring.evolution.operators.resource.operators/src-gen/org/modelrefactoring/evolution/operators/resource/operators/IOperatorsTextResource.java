/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended resource that can hold information about the exact positions of
 * each element of its content in a text file. This can be used to give more
 * detailed error feedback.
 */
public interface IOperatorsTextResource extends Resource, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResourcePluginPart {
	
	/**
	 * Returns the raw contents of this resource. This method must be used by
	 * generated classes only. It is not intended to be used by clients.
	 */
	public EList<EObject> getContentsInternal();
	
	/**
	 * Try to load the content of this resource from the given stream. If loading
	 * fails, the state of this resource is kept. If loading is successful, the
	 * content of this resource is replaced with the new content.
	 * This method can be used to try loading erroneous files, as e.g., needed during
	 * background parsing in the editor.
	 * 
	 * @param stream the stream to read from
	 * @param options the load options to use
	 * 
	 * @throws IOException thrown if the stream can not be read
	 */
	public void reload(InputStream stream, Map<?,?> options) throws IOException;
	
	/**
	 * Returns a map containing information about the location of model elements in
	 * the text.
	 * 
	 * @return the model element to text location mapping
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap getLocationMap();
	
	/**
	 * Adds an error that should be displayed at the position of the given element.
	 */
	public void addProblem(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsProblem problem, EObject element);
	
	/**
	 * Adds an error to be displayed at the indicated position.
	 */
	public void addProblem(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsProblem problem, int column, int line, int charStart, int charEnd);
	
	/**
	 * Internal method used by the parser to register a context dependent proxy object
	 * for later resolution.
	 * 
	 * @param container
	 * @param reference
	 * @param position
	 * @param id
	 * @param proxyElement
	 */
	public <ContainerType extends EObject, ReferenceType extends EObject> void registerContextDependentProxy(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, EReference reference, String id, EObject proxyElement, int position);
	
	@Deprecated
	public void addWarning(String message, EObject cause);
	
	/**
	 * Attaches a warning with the given message to object 'cause'.
	 */
	public void addWarning(String message, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType type, EObject cause);
	
	@Deprecated
	public void addError(String message, EObject cause);
	
	/**
	 * Attaches an error with the given message to object 'cause'.
	 */
	public void addError(String message, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType type, EObject cause);
	
	/**
	 * Returns the quick fix for the given context. This method is used by the
	 * MarkerResolutionGenerator to retrieve fixes for problem that are associated
	 * with this resource.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix getQuickFix(String quickFixContext);
	
}
