/**
 */
package smell_model;

import ecore.EPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Smell Rolemapping Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smell_model.ModelSmell_Rolemapping_Mapping#getModelSmell <em>Model Smell</em>}</li>
 *   <li>{@link smell_model.ModelSmell_Rolemapping_Mapping#getRoleMapping <em>Role Mapping</em>}</li>
 *   <li>{@link smell_model.ModelSmell_Rolemapping_Mapping#getMappingConcretisation <em>Mapping Concretisation</em>}</li>
 *   <li>{@link smell_model.ModelSmell_Rolemapping_Mapping#getMetamodelSpecification <em>Metamodel Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping()
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
	 * @see smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_ModelSmell()
	 * @model required="true"
	 * @generated
	 */
	ModelSmell getModelSmell();

	/**
	 * Sets the value of the '{@link smell_model.ModelSmell_Rolemapping_Mapping#getModelSmell <em>Model Smell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Smell</em>' reference.
	 * @see #getModelSmell()
	 * @generated
	 */
	void setModelSmell(ModelSmell value);

	/**
	 * Returns the value of the '<em><b>Role Mapping</b></em>' reference list.
	 * The list contents are of type {@link rolemapping.RoleMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Mapping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Mapping</em>' reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_RoleMapping()
	 * @model required="true"
	 * @generated
	 */
	EList<RoleMapping> getRoleMapping();

	/**
	 * Returns the value of the '<em><b>Mapping Concretisation</b></em>' containment reference list.
	 * The list contents are of type {@link smell_model.MappingConcretisation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Concretisation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Concretisation</em>' containment reference list.
	 * @see smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_MappingConcretisation()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingConcretisation> getMappingConcretisation();

	/**
	 * Returns the value of the '<em><b>Metamodel Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Specification</em>' reference.
	 * @see #setMetamodelSpecification(EPackage)
	 * @see smell_model.Smell_modelPackage#getModelSmell_Rolemapping_Mapping_MetamodelSpecification()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetamodelSpecification();

	/**
	 * Sets the value of the '{@link smell_model.ModelSmell_Rolemapping_Mapping#getMetamodelSpecification <em>Metamodel Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Specification</em>' reference.
	 * @see #getMetamodelSpecification()
	 * @generated
	 */
	void setMetamodelSpecification(EPackage value);

} // ModelSmell_Rolemapping_Mapping
