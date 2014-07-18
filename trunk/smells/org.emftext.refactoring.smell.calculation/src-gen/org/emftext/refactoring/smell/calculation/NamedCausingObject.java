/**
 */
package org.emftext.refactoring.smell.calculation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Causing Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.NamedCausingObject#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.NamedCausingObject#getCausingObject <em>Causing Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getNamedCausingObject()
 * @model
 * @generated
 */
public interface NamedCausingObject extends EObject {
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
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getNamedCausingObject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.NamedCausingObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Causing Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Causing Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Causing Object</em>' reference.
	 * @see #setCausingObject(EObject)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getNamedCausingObject_CausingObject()
	 * @model
	 * @generated
	 */
	EObject getCausingObject();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.NamedCausingObject#getCausingObject <em>Causing Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Causing Object</em>' reference.
	 * @see #getCausingObject()
	 * @generated
	 */
	void setCausingObject(EObject value);

} // NamedCausingObject
