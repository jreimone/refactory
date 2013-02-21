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
	 * @see #setMonotonicity(Monotonicity)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Monotonicity()
	 * @model required="true"
	 * @generated
	 */
	Monotonicity getMonotonicity();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.Calculation#getMonotonicity <em>Monotonicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monotonicity</em>' attribute.
	 * @see org.emftext.refactoring.smell.calculation.Monotonicity
	 * @see #getMonotonicity()
	 * @generated
	 */
	void setMonotonicity(Monotonicity value);

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
	 * @see #setDescription(String)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Description()
	 * @model default="" required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.Calculation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see #setName(String)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.Calculation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see #setSmellMessage(String)
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#getCalculation_SmellMessage()
	 * @model default="" required="true"
	 * @generated
	 */
	String getSmellMessage();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.calculation.Calculation#getSmellMessage <em>Smell Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smell Message</em>' attribute.
	 * @see #getSmellMessage()
	 * @generated
	 */
	void setSmellMessage(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	CalculationResult calculate(EObject model, float threshold);

} // Calculation
