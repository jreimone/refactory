/**
 */
package org.emftext.refactoring.smell.calculation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calculation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Calculations are registered at the extension point 'org.emftext.refactoring.smell.calculation'.  When extending, provide a subclass either of 'Structure' or of 'Metric'!
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getMonotonicity <em>Monotonicity</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation()
 * @model abstract="true"
 * @generated
 */
public interface Calculation extends EObject {
	/**
	 * Returns the value of the '<em><b>Monotonicity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.refactoring.smell.calculation.Monotonicity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monotonicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monotonicity</em>' attribute.
	 * @see org.emftext.refactoring.smell.calculation.Monotonicity
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Monotonicity()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	Monotonicity getMonotonicity();

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Threshold is the specific value representing the limit from when the calculation should be considered as a "smell". Values less than the threshold are not considered as a "smell". "Less than" regarding the calculation refers to the monotonicity. I.e., if it's increasing the smell is satisfied when the value is less than the threshold, and if it's decreasing the smell is satisfied when the value is greater than the threshold.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(float)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Threshold()
	 * @model required="true"
	 * @generated
	 */
	float getThreshold();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.Calculation#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(float value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Description()
	 * @model default="" required="true" changeable="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	CalculationResult calculate(EObject model);

} // Calculation
