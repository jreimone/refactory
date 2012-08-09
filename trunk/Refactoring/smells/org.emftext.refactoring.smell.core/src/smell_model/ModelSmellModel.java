/**
 */
package smell_model;

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
 *   <li>{@link smell_model.ModelSmellModel#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getQualities <em>Qualities</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getConfigStrings <em>Config Strings</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getLoadedResourcePath <em>Loaded Resource Path</em>}</li>
 *   <li>{@link smell_model.ModelSmellModel#getQualityScale <em>Quality Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @see smell_model.Smell_modelPackage#getModelSmellModel()
 * @model
 * @generated
 */
public interface ModelSmellModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Smell role Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.ModelSmell_Rolemapping_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smell role Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smell role Mapping</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_ModelSmell_roleMapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelSmell_Rolemapping_Mapping> getModelSmell_roleMapping();

	/**
	 * Returns the value of the '<em><b>Quality model Smell</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.Quality_ModelSmell_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality model Smell</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality model Smell</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_Quality_modelSmell()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Quality_ModelSmell_Mapping> getQuality_modelSmell();

	/**
	 * Returns the value of the '<em><b>Metric quality</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.Metric_Quality_Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric quality</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric quality</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_Metric_quality()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Metric_Quality_Mapping> getMetric_quality();

	/**
	 * Returns the value of the '<em><b>Qualities</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.Quality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualities</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_Qualities()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Quality> getQualities();

	/**
	 * Returns the value of the '<em><b>Model Smells</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.ModelSmell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smells</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smells</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_ModelSmells()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelSmell> getModelSmells();

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_Metrics()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * Returns the value of the '<em><b>Config Strings</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Strings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Strings</em>' attribute.
	 * @see #setConfigStrings(EList)
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_ConfigStrings()
	 * @model default="" many="false" transient="true"
	 * @generated
	 */
	EList<String> getConfigStrings();

	/**
	 * Sets the value of the '{@link smell_model.ModelSmellModel#getConfigStrings <em>Config Strings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config Strings</em>' attribute.
	 * @see #getConfigStrings()
	 * @generated
	 */
	void setConfigStrings(EList<String> value);

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
	 * @see smell_model.Smell_modelPackage#getModelSmellModel_QualityScale()
	 * @model default="" transient="true"
	 *        extendedMetaData="wildcards='' name=''"
	 * @generated
	 */
	Map<Quality, Float> getQualityScale();

	/**
	 * Sets the value of the '{@link smell_model.ModelSmellModel#getQualityScale <em>Quality Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Scale</em>' attribute.
	 * @see #getQualityScale()
	 * @generated
	 */
	void setQualityScale(Map<Quality, Float> value);
	
	/**
	 * @param quality
	 * @param factor
	 * @generated NOT
	 */
	void setQualityScale(Quality quality, Float factor);
	
	void register(Observer o);
	
	void unregister(Observer o);
	
	void inform();

} // ModelSmellModel
