/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.Relation#getSource <em>Source</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Relation#getTarget <em>Target</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Relation#isTransitive <em>Transitive</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Relation#isReflexive <em>Reflexive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.roles.RolesPackage#getRelation()
 * @model abstract="true"
 * @generated
 */
public interface Relation extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.roles.Role#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Role)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRelation_Source()
	 * @see org.emftext.language.refactoring.roles.Role#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	Role getSource();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Relation#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Role value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.roles.Role#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Role)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRelation_Target()
	 * @see org.emftext.language.refactoring.roles.Role#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	Role getTarget();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Relation#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Role value);

	/**
	 * Returns the value of the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitive</em>' attribute.
	 * @see #setTransitive(boolean)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRelation_Transitive()
	 * @model
	 * @generated
	 */
	boolean isTransitive();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Relation#isTransitive <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transitive</em>' attribute.
	 * @see #isTransitive()
	 * @generated
	 */
	void setTransitive(boolean value);

	/**
	 * Returns the value of the '<em><b>Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflexive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflexive</em>' attribute.
	 * @see #setReflexive(boolean)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRelation_Reflexive()
	 * @model
	 * @generated
	 */
	boolean isReflexive();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Relation#isReflexive <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflexive</em>' attribute.
	 * @see #isReflexive()
	 * @generated
	 */
	void setReflexive(boolean value);

} // Relation
