/**
 */
package org.emftext.refactoring.smell.core;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ModelSmellModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getLoadedResourcePath <em>Loaded Resource Path</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQualityScale <em>Quality Scale</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getObserver <em>Observer</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getResult <em>Result</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmellDescription <em>Model Smell Description</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetricResultMap <em>Metric Result Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel()
 * @model
 * @generated
 */
public interface ModelSmellModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Smell role Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smell role Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smell role Mapping</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_ModelSmell_roleMapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelSmell_Rolemapping_Mapping> getModelSmell_roleMapping();

	/**
	 * Returns the value of the '<em><b>Quality model Smell</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality model Smell</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality model Smell</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_Quality_modelSmell()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Quality_ModelSmell_Mapping> getQuality_modelSmell();

	/**
	 * Returns the value of the '<em><b>Metric quality</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.core.Metric_Quality_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric quality</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric quality</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_Metric_quality()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Metric_Quality_Mapping> getMetric_quality();

	/**
	 * Returns the value of the '<em><b>Qualities</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.core.Quality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualities</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_Qualities()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Quality> getQualities();

	/**
	 * Returns the value of the '<em><b>Model Smells</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.core.ModelSmell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smells</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smells</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_ModelSmells()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelSmell> getModelSmells();

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.core.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_Metrics()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void calculate();

	String getLoadedResourcePath();

	void setLoadedResourcePath(String path);
	
	/**
	 * Returns the value of the '<em><b>Quality Scale</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Scale</em>' attribute.
	 * @see #setQualityScale(Map)
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_QualityScale()
	 * @model default="" transient="true"
	 * @generated
	 */
	Map<Quality, Float> getQualityScale();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQualityScale <em>Quality Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Scale</em>' attribute.
	 * @see #getQualityScale()
	 * @generated
	 */
	void setQualityScale(Map<Quality, Float> value);
	
	/**
	 * Returns the value of the '<em><b>Observer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observer</em>' attribute.
	 * @see #setObserver(EList)
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_Observer()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Observer> getObserver();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getObserver <em>Observer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observer</em>' attribute.
	 * @see #getObserver()
	 * @generated
	 */
	void setObserver(EList<Observer> value);

	/**
	 * @param quality
	 * @param factor
	 * @generated NOT
	 */
	void setQualityScale(Quality quality, Float factor);
	
	ModelSmellResult getResult();
	
	void setResult(ModelSmellResult result);
	
	Map<ModelSmell, String> getModelSmellDescription();
	
	void setModelSmellDescription(Map<ModelSmell, String> modelSmellDescription);
	
	/**
	 * Returns the value of the '<em><b>Metric Result Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Result Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Result Map</em>' attribute.
	 * @see #setMetricResultMap(Map)
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getModelSmellModel_MetricResultMap()
	 * @model transient="true"
	 * @generated
	 */
	Map<Metric, Map<EObject, Float>> getMetricResultMap();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetricResultMap <em>Metric Result Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Result Map</em>' attribute.
	 * @see #getMetricResultMap()
	 * @generated
	 */
	void setMetricResultMap(Map<Metric, Map<EObject, Float>> value);

	void register(Observer o);
	
	void unregister(Observer o);
	
	void inform();

} // ModelSmellModel
