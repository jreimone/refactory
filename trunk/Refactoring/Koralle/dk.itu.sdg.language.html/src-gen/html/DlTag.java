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
 * A representation of the model object '<em><b>Dl Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.DlTag#getDefItems <em>Def Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getDlTag()
 * @model
 * @generated
 */
public interface DlTag extends Tag {
	/**
	 * Returns the value of the '<em><b>Def Items</b></em>' containment reference list.
	 * The list contents are of type {@link html.DefItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Def Items</em>' containment reference list.
	 * @see html.HtmlPackage#getDlTag_DefItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<DefItem> getDefItems();

} // DlTag
