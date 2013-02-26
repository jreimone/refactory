/**
 */
package org.emftext.refactoring.smell.ecoresmells;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage
 * @generated
 */
public interface EcoresmellsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoresmellsFactory eINSTANCE = org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Check Interface Specifications</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Interface Specifications</em>'.
	 * @generated
	 */
	CheckInterfaceSpecifications createCheckInterfaceSpecifications();

	/**
	 * Returns a new object of class '<em>Compare Names Of Classes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Names Of Classes</em>'.
	 * @generated
	 */
	CompareNamesOfClasses createCompareNamesOfClasses();

	/**
	 * Returns a new object of class '<em>Count Parameters Of Methods</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Parameters Of Methods</em>'.
	 * @generated
	 */
	CountParametersOfMethods createCountParametersOfMethods();

	/**
	 * Returns a new object of class '<em>Search Empty Classes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Search Empty Classes</em>'.
	 * @generated
	 */
	SearchEmptyClasses createSearchEmptyClasses();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcoresmellsPackage getEcoresmellsPackage();

} //EcoresmellsFactory
