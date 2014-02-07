/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.modelrefactoring.evolution.coed.CoedPackage
 * @generated
 */
public interface CoedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoedFactory eINSTANCE = org.modelrefactoring.evolution.coed.impl.CoedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Co Evolution Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Co Evolution Definition</em>'.
	 * @generated
	 */
	CoEvolutionDefinition createCoEvolutionDefinition();

	/**
	 * Returns a new object of class '<em>Role Mapping Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Mapping Event</em>'.
	 * @generated
	 */
	RoleMappingEvent createRoleMappingEvent();

	/**
	 * Returns a new object of class '<em>Plain Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plain Condition</em>'.
	 * @generated
	 */
	PlainCondition createPlainCondition();

	/**
	 * Returns a new object of class '<em>Role Mapping Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Mapping Action</em>'.
	 * @generated
	 */
	RoleMappingAction createRoleMappingAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CoedPackage getCoedPackage();

} //CoedFactory
