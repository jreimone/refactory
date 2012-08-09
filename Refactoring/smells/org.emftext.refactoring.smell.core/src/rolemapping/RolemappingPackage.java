/**
 */
package rolemapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see rolemapping.RolemappingFactory
 * @model kind="package"
 * @generated
 */
public interface RolemappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rolemapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/rolemapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rolemapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RolemappingPackage eINSTANCE = rolemapping.impl.RolemappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link rolemapping.impl.RoleMappingModelImpl <em>Role Mapping Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rolemapping.impl.RoleMappingModelImpl
	 * @see rolemapping.impl.RolemappingPackageImpl#getRoleMappingModel()
	 * @generated
	 */
	int ROLE_MAPPING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Target Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING_MODEL__TARGET_METAMODEL = 0;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING_MODEL__MAPPINGS = 1;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING_MODEL__IMPORTS = 2;

	/**
	 * The number of structural features of the '<em>Role Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link rolemapping.impl.RoleMappingImpl <em>Role Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rolemapping.impl.RoleMappingImpl
	 * @see rolemapping.impl.RolemappingPackageImpl#getRoleMapping()
	 * @generated
	 */
	int ROLE_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING__NAME = 0;

	/**
	 * The feature id for the '<em><b>Mapped Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING__MAPPED_ROLE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Role To Metaelement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING__ROLE_TO_METAELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Owning Mapping Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING__OWNING_MAPPING_MODEL = 3;

	/**
	 * The number of structural features of the '<em>Role Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link rolemapping.impl.ConcreteMappingImpl <em>Concrete Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rolemapping.impl.ConcreteMappingImpl
	 * @see rolemapping.impl.RolemappingPackageImpl#getConcreteMapping()
	 * @generated
	 */
	int CONCRETE_MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_MAPPING__ROLE = 0;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_MAPPING__METACLASS = 1;

	/**
	 * The feature id for the '<em><b>Collaboration Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_MAPPING__COLLABORATION_MAPPINGS = 2;

	/**
	 * The feature id for the '<em><b>Attribute Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS = 3;

	/**
	 * The number of structural features of the '<em>Concrete Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link rolemapping.impl.CollaborationMappingImpl <em>Collaboration Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rolemapping.impl.CollaborationMappingImpl
	 * @see rolemapping.impl.RolemappingPackageImpl#getCollaborationMapping()
	 * @generated
	 */
	int COLLABORATION_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_MAPPING__COLLABORATION = 0;

	/**
	 * The feature id for the '<em><b>Reference Meta Class Pair</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR = 1;

	/**
	 * The number of structural features of the '<em>Collaboration Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link rolemapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rolemapping.impl.AttributeMappingImpl
	 * @see rolemapping.impl.RolemappingPackageImpl#getAttributeMapping()
	 * @generated
	 */
	int ATTRIBUTE_MAPPING = 4;

	/**
	 * The feature id for the '<em><b>Role Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Class Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Attribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link rolemapping.impl.ReferenceMetaClassPairImpl <em>Reference Meta Class Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rolemapping.impl.ReferenceMetaClassPairImpl
	 * @see rolemapping.impl.RolemappingPackageImpl#getReferenceMetaClassPair()
	 * @generated
	 */
	int REFERENCE_META_CLASS_PAIR = 5;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_META_CLASS_PAIR__REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_META_CLASS_PAIR__META_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Reference Meta Class Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_META_CLASS_PAIR_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link rolemapping.RoleMappingModel <em>Role Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Mapping Model</em>'.
	 * @see rolemapping.RoleMappingModel
	 * @generated
	 */
	EClass getRoleMappingModel();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.RoleMappingModel#getTargetMetamodel <em>Target Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Metamodel</em>'.
	 * @see rolemapping.RoleMappingModel#getTargetMetamodel()
	 * @see #getRoleMappingModel()
	 * @generated
	 */
	EReference getRoleMappingModel_TargetMetamodel();

	/**
	 * Returns the meta object for the containment reference list '{@link rolemapping.RoleMappingModel#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see rolemapping.RoleMappingModel#getMappings()
	 * @see #getRoleMappingModel()
	 * @generated
	 */
	EReference getRoleMappingModel_Mappings();

	/**
	 * Returns the meta object for the reference list '{@link rolemapping.RoleMappingModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see rolemapping.RoleMappingModel#getImports()
	 * @see #getRoleMappingModel()
	 * @generated
	 */
	EReference getRoleMappingModel_Imports();

	/**
	 * Returns the meta object for class '{@link rolemapping.RoleMapping <em>Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Mapping</em>'.
	 * @see rolemapping.RoleMapping
	 * @generated
	 */
	EClass getRoleMapping();

	/**
	 * Returns the meta object for the attribute '{@link rolemapping.RoleMapping#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see rolemapping.RoleMapping#getName()
	 * @see #getRoleMapping()
	 * @generated
	 */
	EAttribute getRoleMapping_Name();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.RoleMapping#getMappedRoleModel <em>Mapped Role Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapped Role Model</em>'.
	 * @see rolemapping.RoleMapping#getMappedRoleModel()
	 * @see #getRoleMapping()
	 * @generated
	 */
	EReference getRoleMapping_MappedRoleModel();

	/**
	 * Returns the meta object for the containment reference list '{@link rolemapping.RoleMapping#getRoleToMetaelement <em>Role To Metaelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role To Metaelement</em>'.
	 * @see rolemapping.RoleMapping#getRoleToMetaelement()
	 * @see #getRoleMapping()
	 * @generated
	 */
	EReference getRoleMapping_RoleToMetaelement();

	/**
	 * Returns the meta object for the container reference '{@link rolemapping.RoleMapping#getOwningMappingModel <em>Owning Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Model</em>'.
	 * @see rolemapping.RoleMapping#getOwningMappingModel()
	 * @see #getRoleMapping()
	 * @generated
	 */
	EReference getRoleMapping_OwningMappingModel();

	/**
	 * Returns the meta object for class '{@link rolemapping.ConcreteMapping <em>Concrete Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Mapping</em>'.
	 * @see rolemapping.ConcreteMapping
	 * @generated
	 */
	EClass getConcreteMapping();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.ConcreteMapping#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see rolemapping.ConcreteMapping#getRole()
	 * @see #getConcreteMapping()
	 * @generated
	 */
	EReference getConcreteMapping_Role();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.ConcreteMapping#getMetaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metaclass</em>'.
	 * @see rolemapping.ConcreteMapping#getMetaclass()
	 * @see #getConcreteMapping()
	 * @generated
	 */
	EReference getConcreteMapping_Metaclass();

	/**
	 * Returns the meta object for the containment reference list '{@link rolemapping.ConcreteMapping#getCollaborationMappings <em>Collaboration Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collaboration Mappings</em>'.
	 * @see rolemapping.ConcreteMapping#getCollaborationMappings()
	 * @see #getConcreteMapping()
	 * @generated
	 */
	EReference getConcreteMapping_CollaborationMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link rolemapping.ConcreteMapping#getAttributeMappings <em>Attribute Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Mappings</em>'.
	 * @see rolemapping.ConcreteMapping#getAttributeMappings()
	 * @see #getConcreteMapping()
	 * @generated
	 */
	EReference getConcreteMapping_AttributeMappings();

	/**
	 * Returns the meta object for class '{@link rolemapping.CollaborationMapping <em>Collaboration Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collaboration Mapping</em>'.
	 * @see rolemapping.CollaborationMapping
	 * @generated
	 */
	EClass getCollaborationMapping();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.CollaborationMapping#getCollaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collaboration</em>'.
	 * @see rolemapping.CollaborationMapping#getCollaboration()
	 * @see #getCollaborationMapping()
	 * @generated
	 */
	EReference getCollaborationMapping_Collaboration();

	/**
	 * Returns the meta object for the containment reference list '{@link rolemapping.CollaborationMapping#getReferenceMetaClassPair <em>Reference Meta Class Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Meta Class Pair</em>'.
	 * @see rolemapping.CollaborationMapping#getReferenceMetaClassPair()
	 * @see #getCollaborationMapping()
	 * @generated
	 */
	EReference getCollaborationMapping_ReferenceMetaClassPair();

	/**
	 * Returns the meta object for class '{@link rolemapping.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Mapping</em>'.
	 * @see rolemapping.AttributeMapping
	 * @generated
	 */
	EClass getAttributeMapping();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.AttributeMapping#getRoleAttribute <em>Role Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role Attribute</em>'.
	 * @see rolemapping.AttributeMapping#getRoleAttribute()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_RoleAttribute();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.AttributeMapping#getClassAttribute <em>Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Attribute</em>'.
	 * @see rolemapping.AttributeMapping#getClassAttribute()
	 * @see #getAttributeMapping()
	 * @generated
	 */
	EReference getAttributeMapping_ClassAttribute();

	/**
	 * Returns the meta object for class '{@link rolemapping.ReferenceMetaClassPair <em>Reference Meta Class Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Meta Class Pair</em>'.
	 * @see rolemapping.ReferenceMetaClassPair
	 * @generated
	 */
	EClass getReferenceMetaClassPair();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.ReferenceMetaClassPair#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see rolemapping.ReferenceMetaClassPair#getReference()
	 * @see #getReferenceMetaClassPair()
	 * @generated
	 */
	EReference getReferenceMetaClassPair_Reference();

	/**
	 * Returns the meta object for the reference '{@link rolemapping.ReferenceMetaClassPair#getMetaClass <em>Meta Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Class</em>'.
	 * @see rolemapping.ReferenceMetaClassPair#getMetaClass()
	 * @see #getReferenceMetaClassPair()
	 * @generated
	 */
	EReference getReferenceMetaClassPair_MetaClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RolemappingFactory getRolemappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link rolemapping.impl.RoleMappingModelImpl <em>Role Mapping Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rolemapping.impl.RoleMappingModelImpl
		 * @see rolemapping.impl.RolemappingPackageImpl#getRoleMappingModel()
		 * @generated
		 */
		EClass ROLE_MAPPING_MODEL = eINSTANCE.getRoleMappingModel();

		/**
		 * The meta object literal for the '<em><b>Target Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MAPPING_MODEL__TARGET_METAMODEL = eINSTANCE.getRoleMappingModel_TargetMetamodel();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MAPPING_MODEL__MAPPINGS = eINSTANCE.getRoleMappingModel_Mappings();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MAPPING_MODEL__IMPORTS = eINSTANCE.getRoleMappingModel_Imports();

		/**
		 * The meta object literal for the '{@link rolemapping.impl.RoleMappingImpl <em>Role Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rolemapping.impl.RoleMappingImpl
		 * @see rolemapping.impl.RolemappingPackageImpl#getRoleMapping()
		 * @generated
		 */
		EClass ROLE_MAPPING = eINSTANCE.getRoleMapping();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_MAPPING__NAME = eINSTANCE.getRoleMapping_Name();

		/**
		 * The meta object literal for the '<em><b>Mapped Role Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MAPPING__MAPPED_ROLE_MODEL = eINSTANCE.getRoleMapping_MappedRoleModel();

		/**
		 * The meta object literal for the '<em><b>Role To Metaelement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MAPPING__ROLE_TO_METAELEMENT = eINSTANCE.getRoleMapping_RoleToMetaelement();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_MAPPING__OWNING_MAPPING_MODEL = eINSTANCE.getRoleMapping_OwningMappingModel();

		/**
		 * The meta object literal for the '{@link rolemapping.impl.ConcreteMappingImpl <em>Concrete Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rolemapping.impl.ConcreteMappingImpl
		 * @see rolemapping.impl.RolemappingPackageImpl#getConcreteMapping()
		 * @generated
		 */
		EClass CONCRETE_MAPPING = eINSTANCE.getConcreteMapping();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_MAPPING__ROLE = eINSTANCE.getConcreteMapping_Role();

		/**
		 * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_MAPPING__METACLASS = eINSTANCE.getConcreteMapping_Metaclass();

		/**
		 * The meta object literal for the '<em><b>Collaboration Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_MAPPING__COLLABORATION_MAPPINGS = eINSTANCE.getConcreteMapping_CollaborationMappings();

		/**
		 * The meta object literal for the '<em><b>Attribute Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS = eINSTANCE.getConcreteMapping_AttributeMappings();

		/**
		 * The meta object literal for the '{@link rolemapping.impl.CollaborationMappingImpl <em>Collaboration Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rolemapping.impl.CollaborationMappingImpl
		 * @see rolemapping.impl.RolemappingPackageImpl#getCollaborationMapping()
		 * @generated
		 */
		EClass COLLABORATION_MAPPING = eINSTANCE.getCollaborationMapping();

		/**
		 * The meta object literal for the '<em><b>Collaboration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION_MAPPING__COLLABORATION = eINSTANCE.getCollaborationMapping_Collaboration();

		/**
		 * The meta object literal for the '<em><b>Reference Meta Class Pair</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR = eINSTANCE.getCollaborationMapping_ReferenceMetaClassPair();

		/**
		 * The meta object literal for the '{@link rolemapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rolemapping.impl.AttributeMappingImpl
		 * @see rolemapping.impl.RolemappingPackageImpl#getAttributeMapping()
		 * @generated
		 */
		EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

		/**
		 * The meta object literal for the '<em><b>Role Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE = eINSTANCE.getAttributeMapping_RoleAttribute();

		/**
		 * The meta object literal for the '<em><b>Class Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE = eINSTANCE.getAttributeMapping_ClassAttribute();

		/**
		 * The meta object literal for the '{@link rolemapping.impl.ReferenceMetaClassPairImpl <em>Reference Meta Class Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rolemapping.impl.ReferenceMetaClassPairImpl
		 * @see rolemapping.impl.RolemappingPackageImpl#getReferenceMetaClassPair()
		 * @generated
		 */
		EClass REFERENCE_META_CLASS_PAIR = eINSTANCE.getReferenceMetaClassPair();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_META_CLASS_PAIR__REFERENCE = eINSTANCE.getReferenceMetaClassPair_Reference();

		/**
		 * The meta object literal for the '<em><b>Meta Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_META_CLASS_PAIR__META_CLASS = eINSTANCE.getReferenceMetaClassPair_MetaClass();

	}

} //RolemappingPackage
