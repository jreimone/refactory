/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.tests.properties.Category#getPairs <em>Pairs</em>}</li>
 *   <li>{@link org.emftext.refactoring.tests.properties.Category#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject {
	/**
   * Returns the value of the '<em><b>Pairs</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.refactoring.tests.properties.KeyValuePair}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pairs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Pairs</em>' containment reference list.
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getCategory_Pairs()
   * @model containment="true"
   * @generated
   */
	EList<KeyValuePair> getPairs();

	/**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getCategory_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.emftext.refactoring.tests.properties.Category#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

} // Category
