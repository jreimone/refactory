/**
 */
package org.emftext.refactoring.smell.smell_model;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Smell Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.ModelSmellResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.ModelSmellResult#getThreshold <em>Threshold</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmellResult()
 * @model
 * @generated
 */
public interface ModelSmellResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(Map)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmellResult_Result()
	 * @model transient="true"
	 * @generated
	 */
	Map<ModelSmell, Map<EObject, Float>> getResult();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.ModelSmellResult#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Map<ModelSmell, Map<EObject, Float>> value);

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(Float)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmellResult_Threshold()
	 * @model
	 * @generated
	 */
	Float getThreshold();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.ModelSmellResult#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(Float value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model metric_qualityMany="false" quality_modelSmellMany="false"
	 * @generated
	 */
	void calculate(EList<Metric_Quality_Mapping> metric_quality, EList<Quality_ModelSmell_Mapping> quality_modelSmell, Map<Metric, Map<EObject, Float>> metricResultMap, Map<Quality, Float> qualityScale);

} // ModelSmellResult
