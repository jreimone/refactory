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
 * A representation of the model object '<em><b>Applet Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.AppletTag#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getAppletTag()
 * @model
 * @generated
 */
public interface AppletTag extends Tag {
	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link html.Param}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see html.HtmlPackage#getAppletTag_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<Param> getParams();

} // AppletTag
