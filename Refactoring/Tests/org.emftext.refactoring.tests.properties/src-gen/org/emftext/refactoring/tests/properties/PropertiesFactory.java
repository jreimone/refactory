/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage
 * @generated
 */
public interface PropertiesFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PropertiesFactory eINSTANCE = org.emftext.refactoring.tests.properties.impl.PropertiesFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Property Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Model</em>'.
   * @generated
   */
	PropertyModel createPropertyModel();

	/**
   * Returns a new object of class '<em>Category</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Category</em>'.
   * @generated
   */
	Category createCategory();

	/**
   * Returns a new object of class '<em>Key Value Pair</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Value Pair</em>'.
   * @generated
   */
	KeyValuePair createKeyValuePair();

	/**
   * Returns a new object of class '<em>Key</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Key</em>'.
   * @generated
   */
	Key createKey();

	/**
   * Returns a new object of class '<em>EObject Reference Value</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>EObject Reference Value</em>'.
   * @generated
   */
	EObjectReferenceValue createEObjectReferenceValue();

	/**
   * Returns a new object of class '<em>String Value</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>String Value</em>'.
   * @generated
   */
	StringValue createStringValue();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	PropertiesPackage getPropertiesPackage();

} //PropertiesFactory
