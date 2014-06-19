/**
 */
package org.emftext.refactoring.smell;

import org.eclipse.emf.ecore.EObject;

import org.emftext.refactoring.smell.calculation.Calculation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality Calculation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.QualityCalculation#getConcreteSmell <em>Concrete Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.QualityCalculation#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.QualityCalculation#getInfluence <em>Influence</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.QualityCalculation#getCalculation <em>Calculation</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.QualityCalculation#getThreshold <em>Threshold</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.SmellPackage#getQualityCalculation()
 * @model
 * @generated
 */
public interface QualityCalculation extends EObject {
	/**
	 * Returns the value of the '<em><b>Concrete Smell</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getQualityCalculations <em>Quality Calculations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Smell</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Smell</em>' container reference.
	 * @see #setConcreteSmell(ConcreteQualitySmell)
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualityCalculation_ConcreteSmell()
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell#getQualityCalculations
	 * @model opposite="qualityCalculations" required="true" transient="false"
	 * @generated
	 */
	ConcreteQualitySmell getConcreteSmell();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.QualityCalculation#getConcreteSmell <em>Concrete Smell</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concrete Smell</em>' container reference.
	 * @see #getConcreteSmell()
	 * @generated
	 */
	void setConcreteSmell(ConcreteQualitySmell value);

	/**
	 * Returns the value of the '<em><b>Quality</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.refactoring.smell.Quality#getCalculations <em>Calculations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality</em>' reference.
	 * @see #setQuality(Quality)
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualityCalculation_Quality()
	 * @see org.emftext.refactoring.smell.Quality#getCalculations
	 * @model opposite="calculations" required="true"
	 * @generated
	 */
	Quality getQuality();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.QualityCalculation#getQuality <em>Quality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality</em>' reference.
	 * @see #getQuality()
	 * @generated
	 */
	void setQuality(Quality value);

	/**
	 * Returns the value of the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "influence" represents the percentual contribution of this quality to the overall concrete quality smell. The sum of the "influence" values of all quality calculations of a concrete quality smell must be exactly 1.0.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Influence</em>' attribute.
	 * @see #setInfluence(float)
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualityCalculation_Influence()
	 * @model required="true"
	 * @generated
	 */
	float getInfluence();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.QualityCalculation#getInfluence <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influence</em>' attribute.
	 * @see #getInfluence()
	 * @generated
	 */
	void setInfluence(float value);

	/**
	 * Returns the value of the '<em><b>Calculation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculation</em>' reference.
	 * @see #setCalculation(Calculation)
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualityCalculation_Calculation()
	 * @model keys="name"
	 * @generated
	 */
	Calculation getCalculation();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.QualityCalculation#getCalculation <em>Calculation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculation</em>' reference.
	 * @see #getCalculation()
	 * @generated
	 */
	void setCalculation(Calculation value);

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
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualityCalculation_Threshold()
	 * @model
	 * @generated
	 */
	float getThreshold();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.QualityCalculation#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(float value);

} // QualityCalculation
