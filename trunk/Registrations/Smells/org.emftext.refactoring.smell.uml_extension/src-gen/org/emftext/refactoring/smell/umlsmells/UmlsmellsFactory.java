/**
 */
package org.emftext.refactoring.smell.umlsmells;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage
 * @generated
 */
public interface UmlsmellsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlsmellsFactory eINSTANCE = org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Check Interface Specifications</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Interface Specifications</em>'.
	 * @generated
	 */
	CheckInterfaceSpecifications createCheckInterfaceSpecifications();

	/**
	 * Returns a new object of class '<em>Compare Names</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Names</em>'.
	 * @generated
	 */
	CompareNames createCompareNames();

	/**
	 * Returns a new object of class '<em>Count Parameters Of Methods</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Parameters Of Methods</em>'.
	 * @generated
	 */
	CountParametersOfMethods createCountParametersOfMethods();

	/**
	 * Returns a new object of class '<em>Search Empty Classes And Interfaces</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Search Empty Classes And Interfaces</em>'.
	 * @generated
	 */
	SearchEmptyClassesAndInterfaces createSearchEmptyClassesAndInterfaces();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlsmellsPackage getUmlsmellsPackage();

} //UmlsmellsFactory
