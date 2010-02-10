/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.Role#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Role#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Role#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Role#isSelectOnRuntime <em>Select On Runtime</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Role#isInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.roles.RolesPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.roles.Relation}.
	 * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.roles.Relation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRole_Outgoing()
	 * @see org.emftext.language.refactoring.roles.Relation#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Relation> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.roles.Relation}.
	 * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.roles.Relation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRole_Incoming()
	 * @see org.emftext.language.refactoring.roles.Relation#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Relation> getIncoming();

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRole_Optional()
	 * @model
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Role#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Select On Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Select On Runtime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Select On Runtime</em>' attribute.
	 * @see #setSelectOnRuntime(boolean)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRole_SelectOnRuntime()
	 * @model
	 * @generated
	 */
	boolean isSelectOnRuntime();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Role#isSelectOnRuntime <em>Select On Runtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Select On Runtime</em>' attribute.
	 * @see #isSelectOnRuntime()
	 * @generated
	 */
	void setSelectOnRuntime(boolean value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(boolean)
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRole_Input()
	 * @model
	 * @generated
	 */
	boolean isInput();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.roles.Role#isInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #isInput()
	 * @generated
	 */
	void setInput(boolean value);

} // Role
