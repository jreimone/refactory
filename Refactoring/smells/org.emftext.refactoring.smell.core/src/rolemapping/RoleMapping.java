/**
 */
package rolemapping;

import ecore.EClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import roles.Role;
import roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rolemapping.RoleMapping#getName <em>Name</em>}</li>
 *   <li>{@link rolemapping.RoleMapping#getMappedRoleModel <em>Mapped Role Model</em>}</li>
 *   <li>{@link rolemapping.RoleMapping#getRoleToMetaelement <em>Role To Metaelement</em>}</li>
 *   <li>{@link rolemapping.RoleMapping#getOwningMappingModel <em>Owning Mapping Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see rolemapping.RolemappingPackage#getRoleMapping()
 * @model
 * @generated
 */
public interface RoleMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see rolemapping.RolemappingPackage#getRoleMapping_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link rolemapping.RoleMapping#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mapped Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Role Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Role Model</em>' reference.
	 * @see #setMappedRoleModel(RoleModel)
	 * @see rolemapping.RolemappingPackage#getRoleMapping_MappedRoleModel()
	 * @model required="true"
	 * @generated
	 */
	RoleModel getMappedRoleModel();

	/**
	 * Sets the value of the '{@link rolemapping.RoleMapping#getMappedRoleModel <em>Mapped Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Role Model</em>' reference.
	 * @see #getMappedRoleModel()
	 * @generated
	 */
	void setMappedRoleModel(RoleModel value);

	/**
	 * Returns the value of the '<em><b>Role To Metaelement</b></em>' containment reference list.
	 * The list contents are of type {@link rolemapping.ConcreteMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role To Metaelement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role To Metaelement</em>' containment reference list.
	 * @see rolemapping.RolemappingPackage#getRoleMapping_RoleToMetaelement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConcreteMapping> getRoleToMetaelement();

	/**
	 * Returns the value of the '<em><b>Owning Mapping Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link rolemapping.RoleMappingModel#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Mapping Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Mapping Model</em>' container reference.
	 * @see #setOwningMappingModel(RoleMappingModel)
	 * @see rolemapping.RolemappingPackage#getRoleMapping_OwningMappingModel()
	 * @see rolemapping.RoleMappingModel#getMappings
	 * @model opposite="mappings" required="true" transient="false"
	 * @generated
	 */
	RoleMappingModel getOwningMappingModel();

	/**
	 * Sets the value of the '{@link rolemapping.RoleMapping#getOwningMappingModel <em>Owning Mapping Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping Model</em>' container reference.
	 * @see #getOwningMappingModel()
	 * @generated
	 */
	void setOwningMappingModel(RoleMappingModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.roles.Role > roles = new org.eclipse.emf.common.util.BasicEList < org.emftext.language.refactoring.roles.Role > ( ) ; \r\norg.eclipse.emf.common.util.EList < org.emftext.language.refactoring.rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; \r\nfor ( org.emftext.language.refactoring.rolemapping.ConcreteMapping concreteMapping : mappings ) { \r\n\troles .add ( concreteMapping .getRole ( ) ) ; \r\n} \r\nreturn roles ; \r\n'"
	 * @generated
	 */
	EList<Role> getAllMappedRoles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='java.util.Set < org.emftext.language.refactoring.roles.Role > roleSet = new java.util.LinkedHashSet < org.emftext.language.refactoring.roles.Role > ( ) ; \r\norg.eclipse.emf.ecore.EClass metaclass = object .eClass ( ) ; \r\norg.eclipse.emf.common.util.EList < org.emftext.language.refactoring.rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; \r\nfor ( org.emftext.language.refactoring.rolemapping.ConcreteMapping concreteMapping : mappings ) { \r\n\torg.emftext.language.refactoring.roles.Role mappedRole = concreteMapping .getRole ( ) ; \r\n\torg.eclipse.emf.ecore.EClass mappedClass = concreteMapping .getMetaclass ( ) ; \r\n\tif ( mappedClass .equals ( metaclass ) ) { \r\n\t\troleSet .add ( mappedRole ) ; \r\n\t} \r\n\tif ( mappedRole .getModifier ( ) .contains ( org.emftext.language.refactoring.roles.RoleModifier .SUPER ) ) { \r\n\t\tif ( mappedClass .isSuperTypeOf ( metaclass ) ) { \r\n\t\t\troleSet .add ( mappedRole ) ; \r\n\t\t} \r\n\t} \r\n} \r\norg.eclipse.emf.common.util.EList < org.emftext.language.refactoring.roles.Role > mappedRoles = new org.eclipse.emf.common.util.BasicEList < org.emftext.language.refactoring.roles.Role > ( ) ; \r\nfor ( org.emftext.language.refactoring.roles.Role role : roleSet ) { \r\n\tmappedRoles .add ( role ) ; \r\n} \r\nreturn mappedRoles ; \r\n'"
	 * @generated
	 */
	EList<Role> getMappedRolesForEObject(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; \r\nfor ( org.emftext.language.refactoring.rolemapping.ConcreteMapping mapping : mappings ) { \r\n\tif ( mapping .getRole ( ) .equals ( role ) ) { \r\n\t\treturn mapping .getMetaclass ( ) ; \r\n\t} \r\n} \r\nreturn null ; \r\n'"
	 * @generated
	 */
	EClass getEClassForRole(Role role);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; \r\nfor ( org.emftext.language.refactoring.rolemapping.ConcreteMapping mapping : mappings ) { \r\n\tif ( mapping .getRole ( ) .equals ( role ) ) { \r\n\t\treturn mapping ; \r\n\t} \r\n} \r\nreturn null ; \r\n'"
	 * @generated
	 */
	ConcreteMapping getConcreteMappingForRole(Role role);

} // RoleMapping
