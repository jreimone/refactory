/**
 */
package rolemapping.impl;

import ecore.EcorePackage;

import ecore.impl.EcorePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;



import rolemapping.AttributeMapping;
import rolemapping.CollaborationMapping;
import rolemapping.ConcreteMapping;
import rolemapping.ReferenceMetaClassPair;
import rolemapping.RoleMapping;
import rolemapping.RoleMappingModel;
import rolemapping.RolemappingFactory;
import rolemapping.RolemappingPackage;

import roles.RolesPackage;

import roles.impl.RolesPackageImpl;
import smell_model.Smell_modelPackage;
import smell_model.impl.Smell_modelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RolemappingPackageImpl extends EPackageImpl implements RolemappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleMappingModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collaborationMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceMetaClassPairEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see rolemapping.RolemappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RolemappingPackageImpl() {
		super(eNS_URI, RolemappingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RolemappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RolemappingPackage init() {
		if (isInited) return (RolemappingPackage)EPackage.Registry.INSTANCE.getEPackage(RolemappingPackage.eNS_URI);

		// Obtain or create and register package
		RolemappingPackageImpl theRolemappingPackage = (RolemappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RolemappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RolemappingPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Smell_modelPackageImpl theSmell_modelPackage = (Smell_modelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Smell_modelPackage.eNS_URI) instanceof Smell_modelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Smell_modelPackage.eNS_URI) : Smell_modelPackage.eINSTANCE);
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) : EcorePackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theRolemappingPackage.createPackageContents();
		theSmell_modelPackage.createPackageContents();
		theEcorePackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theRolemappingPackage.initializePackageContents();
		theSmell_modelPackage.initializePackageContents();
		theEcorePackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRolemappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, theRolemappingPackage);
		return theRolemappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleMappingModel() {
		return roleMappingModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleMappingModel_TargetMetamodel() {
		return (EReference)roleMappingModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleMappingModel_Mappings() {
		return (EReference)roleMappingModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleMappingModel_Imports() {
		return (EReference)roleMappingModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleMapping() {
		return roleMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleMapping_Name() {
		return (EAttribute)roleMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleMapping_MappedRoleModel() {
		return (EReference)roleMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleMapping_RoleToMetaelement() {
		return (EReference)roleMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleMapping_OwningMappingModel() {
		return (EReference)roleMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteMapping() {
		return concreteMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteMapping_Role() {
		return (EReference)concreteMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteMapping_Metaclass() {
		return (EReference)concreteMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteMapping_CollaborationMappings() {
		return (EReference)concreteMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteMapping_AttributeMappings() {
		return (EReference)concreteMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollaborationMapping() {
		return collaborationMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaborationMapping_Collaboration() {
		return (EReference)collaborationMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaborationMapping_ReferenceMetaClassPair() {
		return (EReference)collaborationMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMapping() {
		return attributeMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_RoleAttribute() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_ClassAttribute() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceMetaClassPair() {
		return referenceMetaClassPairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceMetaClassPair_Reference() {
		return (EReference)referenceMetaClassPairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceMetaClassPair_MetaClass() {
		return (EReference)referenceMetaClassPairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolemappingFactory getRolemappingFactory() {
		return (RolemappingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		roleMappingModelEClass = createEClass(ROLE_MAPPING_MODEL);
		createEReference(roleMappingModelEClass, ROLE_MAPPING_MODEL__TARGET_METAMODEL);
		createEReference(roleMappingModelEClass, ROLE_MAPPING_MODEL__MAPPINGS);
		createEReference(roleMappingModelEClass, ROLE_MAPPING_MODEL__IMPORTS);

		roleMappingEClass = createEClass(ROLE_MAPPING);
		createEAttribute(roleMappingEClass, ROLE_MAPPING__NAME);
		createEReference(roleMappingEClass, ROLE_MAPPING__MAPPED_ROLE_MODEL);
		createEReference(roleMappingEClass, ROLE_MAPPING__ROLE_TO_METAELEMENT);
		createEReference(roleMappingEClass, ROLE_MAPPING__OWNING_MAPPING_MODEL);

		concreteMappingEClass = createEClass(CONCRETE_MAPPING);
		createEReference(concreteMappingEClass, CONCRETE_MAPPING__ROLE);
		createEReference(concreteMappingEClass, CONCRETE_MAPPING__METACLASS);
		createEReference(concreteMappingEClass, CONCRETE_MAPPING__COLLABORATION_MAPPINGS);
		createEReference(concreteMappingEClass, CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS);

		collaborationMappingEClass = createEClass(COLLABORATION_MAPPING);
		createEReference(collaborationMappingEClass, COLLABORATION_MAPPING__COLLABORATION);
		createEReference(collaborationMappingEClass, COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR);

		attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE);

		referenceMetaClassPairEClass = createEClass(REFERENCE_META_CLASS_PAIR);
		createEReference(referenceMetaClassPairEClass, REFERENCE_META_CLASS_PAIR__REFERENCE);
		createEReference(referenceMetaClassPairEClass, REFERENCE_META_CLASS_PAIR__META_CLASS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		RolesPackage theRolesPackage = (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(roleMappingModelEClass, RoleMappingModel.class, "RoleMappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleMappingModel_TargetMetamodel(), theEcorePackage.getEPackage(), null, "targetMetamodel", null, 1, 1, RoleMappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleMappingModel_Mappings(), this.getRoleMapping(), this.getRoleMapping_OwningMappingModel(), "mappings", null, 1, -1, RoleMappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleMappingModel_Imports(), theEcorePackage.getEPackage(), null, "imports", null, 0, -1, RoleMappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleMappingEClass, RoleMapping.class, "RoleMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoleMapping_Name(), theEcorePackage.getEString(), "name", null, 1, 1, RoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleMapping_MappedRoleModel(), theRolesPackage.getRoleModel(), null, "mappedRoleModel", null, 1, 1, RoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleMapping_RoleToMetaelement(), this.getConcreteMapping(), null, "roleToMetaelement", null, 1, -1, RoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleMapping_OwningMappingModel(), this.getRoleMappingModel(), this.getRoleMappingModel_Mappings(), "owningMappingModel", null, 1, 1, RoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(roleMappingEClass, theRolesPackage.getRole(), "getAllMappedRoles", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(roleMappingEClass, theRolesPackage.getRole(), "getMappedRolesForEObject", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roleMappingEClass, theEcorePackage.getEClass(), "getEClassForRole", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRole(), "role", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roleMappingEClass, this.getConcreteMapping(), "getConcreteMappingForRole", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRole(), "role", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(concreteMappingEClass, ConcreteMapping.class, "ConcreteMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcreteMapping_Role(), theRolesPackage.getRole(), null, "role", null, 1, 1, ConcreteMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteMapping_Metaclass(), theEcorePackage.getEClass(), null, "metaclass", null, 1, 1, ConcreteMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteMapping_CollaborationMappings(), this.getCollaborationMapping(), null, "collaborationMappings", null, 0, -1, ConcreteMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteMapping_AttributeMappings(), this.getAttributeMapping(), null, "attributeMappings", null, 0, -1, ConcreteMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(concreteMappingEClass, this.getCollaborationMapping(), "getCollaborationMappingForTargetRole", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRole(), "role", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteMappingEClass, this.getAttributeMapping(), "getAttributeMappingForAttribute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRoleAttribute(), "attribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteMappingEClass, this.getCollaborationMapping(), "getCollaborationMappingForCollaboration", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getMultiplicityCollaboration(), "collaboration", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteMappingEClass, this.getCollaborationMapping(), "getCollaborationMappingsForTargetRole", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRole(), "role", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(collaborationMappingEClass, CollaborationMapping.class, "CollaborationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollaborationMapping_Collaboration(), theRolesPackage.getMultiplicityCollaboration(), null, "collaboration", null, 1, 1, CollaborationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollaborationMapping_ReferenceMetaClassPair(), this.getReferenceMetaClassPair(), null, "referenceMetaClassPair", null, 1, -1, CollaborationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMapping_RoleAttribute(), theRolesPackage.getRoleAttribute(), null, "roleAttribute", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMapping_ClassAttribute(), theEcorePackage.getEAttribute(), null, "classAttribute", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceMetaClassPairEClass, ReferenceMetaClassPair.class, "ReferenceMetaClassPair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceMetaClassPair_Reference(), theEcorePackage.getEReference(), null, "reference", null, 1, 1, ReferenceMetaClassPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceMetaClassPair_MetaClass(), theEcorePackage.getEClass(), null, "metaClass", null, 0, 1, ReferenceMetaClassPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RolemappingPackageImpl
