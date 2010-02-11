/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.roles.RolesPackage
 * @generated
 */
public interface RolesFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	RolesFactory eINSTANCE = org.emftext.language.refactoring.roles.impl.RolesFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Role Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Model</em>'.
   * @generated
   */
	RoleModel createRoleModel();

	/**
   * Returns a new object of class '<em>Role</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role</em>'.
   * @generated
   */
	Role createRole();

	/**
   * Returns a new object of class '<em>Role Implication</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Implication</em>'.
   * @generated
   */
	RoleImplication createRoleImplication();

	/**
   * Returns a new object of class '<em>Role Prohibition</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Prohibition</em>'.
   * @generated
   */
	RoleProhibition createRoleProhibition();

	/**
   * Returns a new object of class '<em>Multiplicity</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity</em>'.
   * @generated
   */
	Multiplicity createMultiplicity();

	/**
   * Returns a new object of class '<em>Role Association</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Association</em>'.
   * @generated
   */
	RoleAssociation createRoleAssociation();

	/**
   * Returns a new object of class '<em>Role Composition</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Composition</em>'.
   * @generated
   */
	RoleComposition createRoleComposition();

	/**
   * Returns a new object of class '<em>Role Use</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Use</em>'.
   * @generated
   */
	RoleUse createRoleUse();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	RolesPackage getRolesPackage();

} //RolesFactory
