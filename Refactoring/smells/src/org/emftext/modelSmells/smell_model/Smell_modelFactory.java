/**
 */
package org.emftext.modelSmells.smell_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.modelSmells.smell_model.Smell_modelPackage
 * @generated
 */
public interface Smell_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Smell_modelFactory eINSTANCE = org.emftext.modelSmells.smell_model.impl.Smell_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Smell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Smell</em>'.
	 * @generated
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
	 * @generated
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
	 * Returns a new object of class '<em>Main</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Main</em>'.
	 * @generated
	 */
	Main createMain();

	/**
	 * Returns a new object of class '<em>GUI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GUI</em>'.
	 * @generated
	 */
	GUI createGUI();

	/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	Component createComponent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Smell_modelPackage getSmell_modelPackage();

} //Smell_modelFactory
