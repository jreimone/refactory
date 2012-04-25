/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.SelectTag#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getSelectTag()
 * @model
 * @generated
 */
public interface SelectTag extends Tag {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link html.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see html.HtmlPackage#getSelectTag_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<Option> getOptions();

} // SelectTag
