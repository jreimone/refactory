/**
 */
package org.emftext.refactoring.smell.calculation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.CalculationResult#getCausingObjects <em>Causing Objects</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.CalculationResult#getResultingValue <em>Resulting Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculationResult()
 * @model
 * @generated
 */
public interface CalculationResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Causing Objects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Causing Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Causing Objects</em>' reference list.
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculationResult_CausingObjects()
	 * @model
	 * @generated
	 */
	EList<EObject> getCausingObjects();

	/**
	 * Returns the value of the '<em><b>Resulting Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resulting Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resulting Value</em>' attribute.
	 * @see #setResultingValue(float)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculationResult_ResultingValue()
	 * @model required="true"
	 * @generated
	 */
	float getResultingValue();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.CalculationResult#getResultingValue <em>Resulting Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resulting Value</em>' attribute.
	 * @see #getResultingValue()
	 * @generated
	 */
	void setResultingValue(float value);

} // CalculationResult
