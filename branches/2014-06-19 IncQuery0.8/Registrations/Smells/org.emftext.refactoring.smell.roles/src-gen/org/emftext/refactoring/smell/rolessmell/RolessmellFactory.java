/**
 */
package org.emftext.refactoring.smell.rolessmell;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.rolessmell.RolessmellPackage
 * @generated
 */
public interface RolessmellFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RolessmellFactory eINSTANCE = org.emftext.refactoring.smell.rolessmell.impl.RolessmellFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Distinct Role Names</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distinct Role Names</em>'.
	 * @generated
	 */
	DistinctRoleNames createDistinctRoleNames();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RolessmellPackage getRolessmellPackage();

} //RolessmellFactory
