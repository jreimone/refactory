/**
 */
package org.emftext.refactoring.smell.smell_model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Quality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getMetric_Quality_Mapping()
 * @model
 * @generated
 */
public interface Metric_Quality_Mapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Quality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality</em>' reference.
	 * @see #setQuality(Quality)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getMetric_Quality_Mapping_Quality()
	 * @model required="true"
	 * @generated
	 */
	Quality getQuality();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping#getQuality <em>Quality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality</em>' reference.
	 * @see #getQuality()
	 * @generated
	 */
	void setQuality(Quality value);

	/**
	 * Returns the value of the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' reference.
	 * @see #setMetric(ModelMetric)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getMetric_Quality_Mapping_Metric()
	 * @model required="true"
	 * @generated
	 */
	ModelMetric getMetric();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping#getMetric <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(ModelMetric value);

} // Metric_Quality_Mapping
