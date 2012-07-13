/**
 */
package org.eclipse.emf.modelSmells.smell_model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality Model Smell Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getModelSmell <em>Model Smell</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getQuality <em>Quality</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping()
 * @model
 * @generated
 */
public interface Quality_ModelSmell_Mapping extends EObject {
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
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping_Factor()
	 * @model
	 * @generated
	 */
	float getFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(float value);

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
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping_ModelSmell()
	 * @model required="true"
	 * @generated
	 */
	ModelSmell getModelSmell();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getModelSmell <em>Model Smell</em>}' reference.
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
	 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage#getQuality_ModelSmell_Mapping_Quality()
	 * @model required="true"
	 * @generated
	 */
	Quality getQuality();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getQuality <em>Quality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality</em>' reference.
	 * @see #getQuality()
	 * @generated
	 */
	void setQuality(Quality value);

} // Quality_ModelSmell_Mapping
