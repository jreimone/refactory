/**
 */
package org.emftext.refactoring.smell.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.core.Smell_modelPackage
 * @generated
 */
public interface Smell_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Smell_modelFactory eINSTANCE = org.emftext.refactoring.smell.core.impl.Smell_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Smell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Smell</em>'.
	 */
	ModelSmell createModelSmell();

	/**
	 * Returns a new object of class '<em>Model Smell Rolemapping Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Smell Rolemapping Mapping</em>'.
	 * @generated
	 */
	ModelSmell_Rolemapping_Mapping createModelSmell_Rolemapping_Mapping();

	/**
	 * Returns a new object of class '<em>Quality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality</em>'.
	 */
	Quality createQuality();

	/**
	 * Returns a new object of class '<em>Quality Model Smell Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Model Smell Mapping</em>'.
	 * @generated
	 */
	Quality_ModelSmell_Mapping createQuality_ModelSmell_Mapping();

	/**
	 * Returns a new object of class '<em>Metric Quality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Quality Mapping</em>'.
	 * @generated
	 */
	Metric_Quality_Mapping createMetric_Quality_Mapping();

	/**
	 * Returns a new object of class '<em>Model Smell Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Smell Model</em>'.
	 * @generated
	 */
	ModelSmellModel createModelSmellModel();

	/**
	 * Returns a new object of class '<em>Role Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Mapping</em>'.
	 * @generated
	 */
	RoleMapping createRoleMapping();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Mapping Concretisation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Concretisation</em>'.
	 * @generated
	 */
	MappingConcretisation createMappingConcretisation();

	/**
	 * Returns a new object of class '<em>Model Smell Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Smell Result</em>'.
	 * @generated
	 */
	ModelSmellResult createModelSmellResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Smell_modelPackage getSmell_modelPackage();

} //Smell_modelFactory
