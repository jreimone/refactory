/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.tests.properties.StringValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getStringValue()
 * @model
 * @generated
 */
public interface StringValue extends Value {
	/**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getStringValue_Value()
   * @model required="true"
   * @generated
   */
	String getValue();

	/**
   * Sets the value of the '{@link org.emftext.refactoring.tests.properties.StringValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
	void setValue(String value);

} // StringValue
