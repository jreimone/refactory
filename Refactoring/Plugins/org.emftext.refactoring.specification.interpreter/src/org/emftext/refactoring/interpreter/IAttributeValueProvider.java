/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * This interface should be used for simple values to be provided by the user. Those
 * can for example be a name for a new class. If clients use this value provider, 
 * its visual presentation will only be added with others to one {@link Composite}.
 * 
 * @author Jan Reimann
 *
 */
public interface IAttributeValueProvider extends IValueProvider<EAttribute, Object> {


	/**
	 * Returns the attribute for which the value should be provided.
	 * @return
	 */
	public EAttribute getAttribute();
	
	/**
	 * Returns the owner of the attribute.
	 * @return
	 */
	public EObject getAttributeOwner();

	/**
	 * Returns whether the given <code>text</code> is valid for this attribute
	 * @param text 
	 * @return
	 */
	public boolean isValueValid(String text);
}
