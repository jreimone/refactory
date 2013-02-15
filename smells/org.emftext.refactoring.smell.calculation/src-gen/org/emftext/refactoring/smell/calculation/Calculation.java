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
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getSmellMessage <em>Smell Message</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.Calculation#getThreshold <em>Threshold</em>}</li>
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Name()
	 * @model default="" required="true" changeable="false"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Smell Message</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smell Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smell Message</em>' attribute.
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_SmellMessage()
	 * @model default="" required="true" changeable="false"
	 * @generated
	 */
	String getSmellMessage();

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(float)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Threshold()
	 * @model
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	CalculationResult calculate(EObject model);

} // Calculation
