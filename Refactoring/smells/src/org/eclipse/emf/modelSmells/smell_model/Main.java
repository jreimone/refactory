/**
 */
package org.eclipse.emf.modelSmells.smell_model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Main#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Main#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Main#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Main#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Main#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Main#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain()
 * @model
 * @generated
 */
public interface Main extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Smell role Mapping</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smell role Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smell role Mapping</em>' reference list.
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain_ModelSmell_roleMapping()
	 * @model required="true"
	 * @generated
	 */
	EList<ModelSmell_Rolemapping_Mapping> getModelSmell_roleMapping();

	/**
	 * Returns the value of the '<em><b>Quality model Smell</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality model Smell</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality model Smell</em>' reference list.
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain_Quality_modelSmell()
	 * @model required="true"
	 * @generated
	 */
	EList<Quality_ModelSmell_Mapping> getQuality_modelSmell();

	/**
	 * Returns the value of the '<em><b>Metric quality</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric quality</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric quality</em>' reference list.
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain_Metric_quality()
	 * @model required="true"
	 * @generated
	 */
	EList<Metric_Quality_Mapping> getMetric_quality();

	/**
	 * Returns the value of the '<em><b>Qualities</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.modelSmells.smell_model.Quality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualities</em>' reference list.
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain_Qualities()
	 * @model required="true"
	 * @generated
	 */
	EList<Quality> getQualities();

	/**
	 * Returns the value of the '<em><b>Model Smells</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.modelSmells.smell_model.ModelSmell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smells</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smells</em>' reference list.
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain_ModelSmells()
	 * @model required="true"
	 * @generated
	 */
	EList<ModelSmell> getModelSmells();

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.modelSmells.smell_model.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' reference list.
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getMain_Metrics()
	 * @model required="true"
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerMetric(Metric metric);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void refactor();
	
	String getLoadedResourcePath();

	void setLoadedResourcePath(String path);

} // Main
