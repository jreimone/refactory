/**
 */
package smell_model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality Model Smell Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smell_model.Quality_ModelSmell_Mapping#getModelSmell <em>Model Smell</em>}</li>
 *   <li>{@link smell_model.Quality_ModelSmell_Mapping#getQuality <em>Quality</em>}</li>
 * </ul>
 * </p>
 *
 * @see smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping()
 * @model
 * @generated
 */
public interface Quality_ModelSmell_Mapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Model Smell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Smell</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Smell</em>' reference.
	 * @see #setModelSmell(ModelSmell)
	 * @see smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping_ModelSmell()
	 * @model required="true"
	 * @generated
	 */
	ModelSmell getModelSmell();

	/**
	 * Sets the value of the '{@link smell_model.Quality_ModelSmell_Mapping#getModelSmell <em>Model Smell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Smell</em>' reference.
	 * @see #getModelSmell()
	 * @generated
	 */
	void setModelSmell(ModelSmell value);

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
	 * @see smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping_Quality()
	 * @model required="true"
	 * @generated
	 */
	Quality getQuality();

	/**
	 * Sets the value of the '{@link smell_model.Quality_ModelSmell_Mapping#getQuality <em>Quality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality</em>' reference.
	 * @see #getQuality()
	 * @generated
	 */
	void setQuality(Quality value);

} // Quality_ModelSmell_Mapping
