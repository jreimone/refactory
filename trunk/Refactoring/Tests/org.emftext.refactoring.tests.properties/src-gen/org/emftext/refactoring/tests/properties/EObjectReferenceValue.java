/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Reference Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue#getObjectReference <em>Object Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getEObjectReferenceValue()
 * @model
 * @generated
 */
public interface EObjectReferenceValue extends Value {
	/**
   * Returns the value of the '<em><b>Object Reference</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Object Reference</em>' reference.
   * @see #setObjectReference(EObject)
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getEObjectReferenceValue_ObjectReference()
   * @model required="true"
   * @generated
   */
	EObject getObjectReference();

	/**
   * Sets the value of the '{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue#getObjectReference <em>Object Reference</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Reference</em>' reference.
   * @see #getObjectReference()
   * @generated
   */
	void setObjectReference(EObject value);

} // EObjectReferenceValue
