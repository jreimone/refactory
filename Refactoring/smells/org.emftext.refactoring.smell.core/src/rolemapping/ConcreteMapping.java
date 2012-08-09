/**
 */
package rolemapping;

import ecore.EClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import roles.MultiplicityCollaboration;
import roles.Role;
import roles.RoleAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rolemapping.ConcreteMapping#getRole <em>Role</em>}</li>
 *   <li>{@link rolemapping.ConcreteMapping#getMetaclass <em>Metaclass</em>}</li>
 *   <li>{@link rolemapping.ConcreteMapping#getCollaborationMappings <em>Collaboration Mappings</em>}</li>
 *   <li>{@link rolemapping.ConcreteMapping#getAttributeMappings <em>Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see rolemapping.RolemappingPackage#getConcreteMapping()
 * @model
 * @generated
 */
public interface ConcreteMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(Role)
	 * @see rolemapping.RolemappingPackage#getConcreteMapping_Role()
	 * @model required="true"
	 * @generated
	 */
	Role getRole();

	/**
	 * Sets the value of the '{@link rolemapping.ConcreteMapping#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(Role value);

	/**
	 * Returns the value of the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaclass</em>' reference.
	 * @see #setMetaclass(EClass)
	 * @see rolemapping.RolemappingPackage#getConcreteMapping_Metaclass()
	 * @model required="true"
	 * @generated
	 */
	EClass getMetaclass();

	/**
	 * Sets the value of the '{@link rolemapping.ConcreteMapping#getMetaclass <em>Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metaclass</em>' reference.
	 * @see #getMetaclass()
	 * @generated
	 */
	void setMetaclass(EClass value);

	/**
	 * Returns the value of the '<em><b>Collaboration Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link rolemapping.CollaborationMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaboration Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaboration Mappings</em>' containment reference list.
	 * @see rolemapping.RolemappingPackage#getConcreteMapping_CollaborationMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<CollaborationMapping> getCollaborationMappings();

	/**
	 * Returns the value of the '<em><b>Attribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link rolemapping.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Mappings</em>' containment reference list.
	 * @see rolemapping.RolemappingPackage#getConcreteMapping_AttributeMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeMapping> getAttributeMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=' \r\n\t\t\t org.eclipse.emf.common.util.EList <  org.emftext.language.refactoring.rolemapping.CollaborationMapping > mappings = getCollaborationMappings ( ) ;\r\n \r\n\t\t\tfor (  org.emftext.language.refactoring.rolemapping.CollaborationMapping relationMapping : mappings ) { \r\n\t\t\t\t org.eclipse.emf.ecore.util.EcoreUtil .resolveAll ( relationMapping ) ; \r\n\t\t\t\t org.emftext.language.refactoring.roles.MultiplicityCollaboration collaboration = relationMapping .getCollaboration ( ) ; \r\n\t\t\t\tif ( collaboration .getTarget ( ) .equals ( role ) ) { \r\n\t\t\t\t\treturn relationMapping ; \r\n\t\t\t\t} \r\n\t\t\t}\r\n \r\n\t\t\treturn null ;\r\n'"
	 * @generated
	 */
	CollaborationMapping getCollaborationMappingForTargetRole(Role role);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=' \r\n\t\t\tif ( attribute == null ) { \r\n\t\t\t\treturn null ; \r\n\t\t\t}\r\n \r\n\t\t\t java.util.List <  org.emftext.language.refactoring.rolemapping.AttributeMapping > attributeMappings = getAttributeMappings ( ) ;\r\n \r\n\t\t\tfor (  org.emftext.language.refactoring.rolemapping.AttributeMapping attributeMapping : attributeMappings ) { \r\n\t\t\t\tif ( attributeMapping .getRoleAttribute ( ) .equals ( attribute ) ) { \r\n\t\t\t\t\treturn attributeMapping ; \r\n\t\t\t\t} \r\n\t\t\t}\r\n \r\n\t\t\treturn null ;\r\n'"
	 * @generated
	 */
	AttributeMapping getAttributeMappingForAttribute(RoleAttribute attribute);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=' \r\n\t\t\t java.util.List <  org.emftext.language.refactoring.rolemapping.CollaborationMapping > relationMappings = getCollaborationMappings ( ) ;\r\n \r\n\t\t\tfor (  org.emftext.language.refactoring.rolemapping.CollaborationMapping collaborationMapping : relationMappings ) { \r\n\t\t\t\t org.emftext.language.refactoring.roles.MultiplicityCollaboration mappedCollaboration = collaborationMapping .getCollaboration ( ) ; \r\n\t\t\t\tif ( mappedCollaboration .equals ( collaboration ) ) { \r\n\t\t\t\t\treturn collaborationMapping ; \r\n\t\t\t\t} \r\n\t\t\t}\r\n \r\n\t\t\treturn null ;\r\n'"
	 * @generated
	 */
	CollaborationMapping getCollaborationMappingForCollaboration(MultiplicityCollaboration collaboration);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=' \r\n\t\t\t org.eclipse.emf.common.util.EList <  org.emftext.language.refactoring.rolemapping.CollaborationMapping > mappings = getCollaborationMappings ( ) ;\r\n\r\n\t\t\t org.eclipse.emf.common.util.EList< org.emftext.language.refactoring.rolemapping.CollaborationMapping> targetMappings = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.refactoring.rolemapping.CollaborationMapping>();\r\n \r\n\t\t\tfor (  org.emftext.language.refactoring.rolemapping.CollaborationMapping relationMapping : mappings ) { \r\n\t\t\t\t org.eclipse.emf.ecore.util.EcoreUtil .resolveAll ( relationMapping ) ; \r\n\t\t\t\t org.emftext.language.refactoring.roles.MultiplicityCollaboration collaboration = relationMapping .getCollaboration ( ) ; \r\n\t\t\t\tif ( collaboration .getTarget ( ) .equals ( role ) ) { \r\n\t\t\t\t\ttargetMappings.add(relationMapping); \r\n\t\t\t\t} \r\n\t\t\t}\r\n \r\n\t\t\treturn targetMappings ;\r\n'"
	 * @generated
	 */
	EList<CollaborationMapping> getCollaborationMappingsForTargetRole(Role role);

} // ConcreteMapping
