/**
 */
package org.emftext.refactoring.smell.smell_model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Smell Rolemapping Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping#getModelSmell <em>Model Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping#getRoleMappings <em>Role Mappings</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping#getMetaModelSpecification <em>Meta Model Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping()
 * @model
 * @generated
 */
public interface ModelSmell_Rolemapping_Mapping extends EObject {
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
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_ModelSmell()
	 * @model required="true"
	 * @generated
	 */
	ModelSmell getModelSmell();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping#getModelSmell <em>Model Smell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Smell</em>' reference.
	 * @see #getModelSmell()
	 * @generated
	 */
	void setModelSmell(ModelSmell value);

	/**
	 * Returns the value of the '<em><b>Role Mappings</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.rolemapping.RoleMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Mappings</em>' reference list.
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_RoleMappings()
	 * @model required="true"
	 * @generated
	 */
	EList<RoleMapping> getRoleMappings();

	/**
	 * Returns the value of the '<em><b>Meta Model Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Specification</em>' reference.
	 * @see #setMetaModelSpecification(EPackage)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_MetaModelSpecification()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetaModelSpecification();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping#getMetaModelSpecification <em>Meta Model Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Specification</em>' reference.
	 * @see #getMetaModelSpecification()
	 * @generated
	 */
	void setMetaModelSpecification(EPackage value);

} // ModelSmell_Rolemapping_Mapping
