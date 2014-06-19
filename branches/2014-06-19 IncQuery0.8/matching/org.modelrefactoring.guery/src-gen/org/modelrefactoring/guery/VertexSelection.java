/**
 */
package org.modelrefactoring.guery;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.guery.VertexSelection#getRoles <em>Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.guery.GueryPackage#getVertexSelection()
 * @model
 * @generated
 */
public interface VertexSelection extends Constrainable {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.modelrefactoring.guery.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.modelrefactoring.guery.GueryPackage#getVertexSelection_Roles()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Role> getRoles();

} // VertexSelection
