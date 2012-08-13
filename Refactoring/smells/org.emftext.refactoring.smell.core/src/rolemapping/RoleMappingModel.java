/**
 */
package rolemapping;

import ecore.EPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rolemapping.RoleMappingModel#getTargetMetamodel <em>Target Metamodel</em>}</li>
 *   <li>{@link rolemapping.RoleMappingModel#getMappings <em>Mappings</em>}</li>
 *   <li>{@link rolemapping.RoleMappingModel#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see rolemapping.RolemappingPackage#getRoleMappingModel()
 * @model
 * @generated
 */
public interface RoleMappingModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Metamodel</em>' reference.
	 * @see #setTargetMetamodel(EPackage)
	 * @see rolemapping.RolemappingPackage#getRoleMappingModel_TargetMetamodel()
	 * @model required="true"
	 * @generated
	 */
	EPackage getTargetMetamodel();

	/**
	 * Sets the value of the '{@link rolemapping.RoleMappingModel#getTargetMetamodel <em>Target Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Metamodel</em>' reference.
	 * @see #getTargetMetamodel()
	 * @generated
	 */
	void setTargetMetamodel(EPackage value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link rolemapping.RoleMapping}.
	 * It is bidirectional and its opposite is '{@link rolemapping.RoleMapping#getOwningMappingModel <em>Owning Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see rolemapping.RolemappingPackage#getRoleMappingModel_Mappings()
	 * @see rolemapping.RoleMapping#getOwningMappingModel
	 * @model opposite="owningMappingModel" containment="true" required="true"
	 * @generated
	 */
	EList<RoleMapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see rolemapping.RolemappingPackage#getRoleMappingModel_Imports()
	 * @model
	 * @generated
	 */
	EList<EPackage> getImports();

} // RoleMappingModel
