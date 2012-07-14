/**
 */
package org.eclipse.emf.modelSmells.smell_model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Quality Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMetric_Quality_Mapping()
 * @model
 * @generated
 */
public interface Metric_Quality_Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor</em>' attribute.
	 * @see #setFactor(float)
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMetric_Quality_Mapping_Factor()
	 * @model
	 * @generated
	 */
	int getFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(int value);

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
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMetric_Quality_Mapping_Quality()
	 * @model required="true"
	 * @generated
	 */
	Quality getQuality();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getQuality <em>Quality</em>}' reference.
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
	 * @see #setMetric(Metric)
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMetric_Quality_Mapping_Metric()
	 * @model required="true"
	 * @generated
	 */
	Metric getMetric();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getMetric <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(Metric value);

} // Metric_Quality_Mapping
