/**
 */
package org.emftext.refactoring.smell;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.SmellPackage
 * @generated
 */
public interface SmellFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmellFactory eINSTANCE = org.emftext.refactoring.smell.impl.SmellFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Quality Smell Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Smell Model</em>'.
	 * @generated
	 */
	QualitySmellModel createQualitySmellModel();

	/**
	 * Returns a new object of class '<em>Quality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality</em>'.
	 * @generated
	 */
	Quality createQuality();

	/**
	 * Returns a new object of class '<em>Quality Smell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Smell</em>'.
	 * @generated
	 */
	QualitySmell createQualitySmell();

	/**
	 * Returns a new object of class '<em>Concrete Quality Smell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Quality Smell</em>'.
	 * @generated
	 */
	ConcreteQualitySmell createConcreteQualitySmell();

	/**
	 * Returns a new object of class '<em>Quality Calculation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Calculation</em>'.
	 * @generated
	 */
	QualityCalculation createQualityCalculation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SmellPackage getSmellPackage();

} //SmellFactory
