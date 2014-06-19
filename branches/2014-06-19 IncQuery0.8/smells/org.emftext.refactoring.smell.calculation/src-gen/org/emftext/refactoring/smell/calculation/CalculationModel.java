/**
 */
package org.emftext.refactoring.smell.calculation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.CalculationModel#getCalculations <em>Calculations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculationModel()
 * @model
 * @generated
 */
public interface CalculationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Calculations</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.calculation.Calculation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculations</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculationModel_Calculations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Calculation> getCalculations();

} // CalculationModel
