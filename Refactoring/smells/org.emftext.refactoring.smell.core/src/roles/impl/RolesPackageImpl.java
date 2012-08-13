/**
 */
package roles.impl;

import ecore.EcorePackage;

import ecore.impl.EcorePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;



import rolemapping.RolemappingPackage;

import rolemapping.impl.RolemappingPackageImpl;

import roles.Collaboration;
import roles.CollaborationModifier;
import roles.Commentable;
import roles.Multiplicity;
import roles.MultiplicityCollaboration;
import roles.NamedElement;
import roles.Role;
import roles.RoleAssociation;
import roles.RoleAttribute;
import roles.RoleComposition;
import roles.RoleFeature;
import roles.RoleImplication;
import roles.RoleModel;
import roles.RoleModifier;
import roles.RoleProhibition;
import roles.RolesFactory;
import roles.RolesPackage;
import smell_model.Smell_modelPackage;
import smell_model.impl.Smell_modelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RolesPackageImpl extends EPackageImpl implements RolesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collaborationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityCollaborationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleProhibitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleCompositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleImplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum roleModifierEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collaborationModifierEEnum = null;

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
	 * @see roles.RolesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RolesPackageImpl() {
		super(eNS_URI, RolesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RolesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RolesPackage init() {
		if (isInited) return (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);

		// Obtain or create and register package
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RolesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Smell_modelPackageImpl theSmell_modelPackage = (Smell_modelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Smell_modelPackage.eNS_URI) instanceof Smell_modelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Smell_modelPackage.eNS_URI) : Smell_modelPackage.eINSTANCE);
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) : EcorePackage.eINSTANCE);
		RolemappingPackageImpl theRolemappingPackage = (RolemappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolemappingPackage.eNS_URI) instanceof RolemappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolemappingPackage.eNS_URI) : RolemappingPackage.eINSTANCE);

		// Create package meta-data objects
		theRolesPackage.createPackageContents();
		theSmell_modelPackage.createPackageContents();
		theEcorePackage.createPackageContents();
		theRolemappingPackage.createPackageContents();

		// Initialize created meta-data
		theRolesPackage.initializePackageContents();
		theSmell_modelPackage.initializePackageContents();
		theEcorePackage.initializePackageContents();
		theRolemappingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRolesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, theRolesPackage);
		return theRolesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollaboration() {
		return collaborationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_Source() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_Target() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollaboration_Modifier() {
		return (EAttribute)collaborationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_InterpretationContext() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Outgoing() {
		return (EReference)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Incoming() {
		return (EReference)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Modifier() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Attributes() {
		return (EReference)roleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleModel() {
		return roleModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleModel_Roles() {
		return (EReference)roleModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleModel_Collaborations() {
		return (EReference)roleModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicity() {
		return multiplicityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_LowerBound() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_UpperBound() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityCollaboration() {
		return multiplicityCollaborationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityCollaboration_SourceMultiplicity() {
		return (EReference)multiplicityCollaborationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityCollaboration_TargetMultiplicity() {
		return (EReference)multiplicityCollaborationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityCollaboration_SourceName() {
		return (EAttribute)multiplicityCollaborationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityCollaboration_TargetName() {
		return (EAttribute)multiplicityCollaborationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleProhibition() {
		return roleProhibitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleAssociation() {
		return roleAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleComposition() {
		return roleCompositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleImplication() {
		return roleImplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleAttribute() {
		return roleAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleAttribute_Modifier() {
		return (EAttribute)roleAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleAttribute_AttributeRole() {
		return (EReference)roleAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleAttribute_InterpretationContext() {
		return (EReference)roleAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleFeature() {
		return roleFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommentable() {
		return commentableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommentable_Comment() {
		return (EAttribute)commentableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRoleModifier() {
		return roleModifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCollaborationModifier() {
		return collaborationModifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolesFactory getRolesFactory() {
		return (RolesFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		collaborationEClass = createEClass(COLLABORATION);
		createEReference(collaborationEClass, COLLABORATION__SOURCE);
		createEReference(collaborationEClass, COLLABORATION__TARGET);
		createEAttribute(collaborationEClass, COLLABORATION__MODIFIER);
		createEReference(collaborationEClass, COLLABORATION__INTERPRETATION_CONTEXT);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__OUTGOING);
		createEReference(roleEClass, ROLE__INCOMING);
		createEAttribute(roleEClass, ROLE__MODIFIER);
		createEReference(roleEClass, ROLE__ATTRIBUTES);

		roleModelEClass = createEClass(ROLE_MODEL);
		createEReference(roleModelEClass, ROLE_MODEL__ROLES);
		createEReference(roleModelEClass, ROLE_MODEL__COLLABORATIONS);

		multiplicityEClass = createEClass(MULTIPLICITY);
		createEAttribute(multiplicityEClass, MULTIPLICITY__LOWER_BOUND);
		createEAttribute(multiplicityEClass, MULTIPLICITY__UPPER_BOUND);

		multiplicityCollaborationEClass = createEClass(MULTIPLICITY_COLLABORATION);
		createEReference(multiplicityCollaborationEClass, MULTIPLICITY_COLLABORATION__SOURCE_MULTIPLICITY);
		createEReference(multiplicityCollaborationEClass, MULTIPLICITY_COLLABORATION__TARGET_MULTIPLICITY);
		createEAttribute(multiplicityCollaborationEClass, MULTIPLICITY_COLLABORATION__SOURCE_NAME);
		createEAttribute(multiplicityCollaborationEClass, MULTIPLICITY_COLLABORATION__TARGET_NAME);

		roleProhibitionEClass = createEClass(ROLE_PROHIBITION);

		roleAssociationEClass = createEClass(ROLE_ASSOCIATION);

		roleCompositionEClass = createEClass(ROLE_COMPOSITION);

		roleImplicationEClass = createEClass(ROLE_IMPLICATION);

		roleAttributeEClass = createEClass(ROLE_ATTRIBUTE);
		createEAttribute(roleAttributeEClass, ROLE_ATTRIBUTE__MODIFIER);
		createEReference(roleAttributeEClass, ROLE_ATTRIBUTE__ATTRIBUTE_ROLE);
		createEReference(roleAttributeEClass, ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT);

		roleFeatureEClass = createEClass(ROLE_FEATURE);

		commentableEClass = createEClass(COMMENTABLE);
		createEAttribute(commentableEClass, COMMENTABLE__COMMENT);

		// Create enums
		roleModifierEEnum = createEEnum(ROLE_MODIFIER);
		collaborationModifierEEnum = createEEnum(COLLABORATION_MODIFIER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedElementEClass.getESuperTypes().add(this.getCommentable());
		collaborationEClass.getESuperTypes().add(this.getRoleFeature());
		roleEClass.getESuperTypes().add(this.getNamedElement());
		roleModelEClass.getESuperTypes().add(this.getNamedElement());
		multiplicityCollaborationEClass.getESuperTypes().add(this.getCollaboration());
		roleProhibitionEClass.getESuperTypes().add(this.getCollaboration());
		roleAssociationEClass.getESuperTypes().add(this.getMultiplicityCollaboration());
		roleCompositionEClass.getESuperTypes().add(this.getMultiplicityCollaboration());
		roleImplicationEClass.getESuperTypes().add(this.getCollaboration());
		roleAttributeEClass.getESuperTypes().add(this.getNamedElement());
		roleAttributeEClass.getESuperTypes().add(this.getRoleFeature());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", "", 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collaborationEClass, Collaboration.class, "Collaboration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollaboration_Source(), this.getRole(), this.getRole_Outgoing(), "source", null, 1, 1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollaboration_Target(), this.getRole(), this.getRole_Incoming(), "target", null, 1, 1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollaboration_Modifier(), this.getCollaborationModifier(), "modifier", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollaboration_InterpretationContext(), ecorePackage.getEObject(), null, "interpretationContext", null, 0, 1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_Outgoing(), this.getCollaboration(), this.getCollaboration_Source(), "outgoing", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Incoming(), this.getCollaboration(), this.getCollaboration_Target(), "incoming", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Modifier(), this.getRoleModifier(), "modifier", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Attributes(), this.getRoleAttribute(), this.getRoleAttribute_AttributeRole(), "attributes", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleModelEClass, RoleModel.class, "RoleModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleModel_Roles(), this.getRole(), null, "roles", null, 0, -1, RoleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getRoleModel_Roles().getEKeys().add(this.getNamedElement_Name());
		initEReference(getRoleModel_Collaborations(), this.getCollaboration(), null, "collaborations", null, 0, -1, RoleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityEClass, Multiplicity.class, "Multiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicity_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicity_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityCollaborationEClass, MultiplicityCollaboration.class, "MultiplicityCollaboration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicityCollaboration_SourceMultiplicity(), this.getMultiplicity(), null, "sourceMultiplicity", null, 1, 1, MultiplicityCollaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicityCollaboration_TargetMultiplicity(), this.getMultiplicity(), null, "targetMultiplicity", null, 1, 1, MultiplicityCollaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicityCollaboration_SourceName(), ecorePackage.getEString(), "sourceName", null, 0, 1, MultiplicityCollaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicityCollaboration_TargetName(), ecorePackage.getEString(), "targetName", null, 0, 1, MultiplicityCollaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleProhibitionEClass, RoleProhibition.class, "RoleProhibition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleAssociationEClass, RoleAssociation.class, "RoleAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleCompositionEClass, RoleComposition.class, "RoleComposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleImplicationEClass, RoleImplication.class, "RoleImplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleAttributeEClass, RoleAttribute.class, "RoleAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoleAttribute_Modifier(), this.getRoleModifier(), "modifier", null, 0, -1, RoleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleAttribute_AttributeRole(), this.getRole(), this.getRole_Attributes(), "attributeRole", null, 1, 1, RoleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleAttribute_InterpretationContext(), ecorePackage.getEObject(), null, "interpretationContext", null, 0, 1, RoleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleFeatureEClass, RoleFeature.class, "RoleFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commentableEClass, Commentable.class, "Commentable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommentable_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Commentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(roleModifierEEnum, RoleModifier.class, "RoleModifier");
		addEEnumLiteral(roleModifierEEnum, RoleModifier.OPTIONAL);
		addEEnumLiteral(roleModifierEEnum, RoleModifier.INPUT);
		addEEnumLiteral(roleModifierEEnum, RoleModifier.SUPER);

		initEEnum(collaborationModifierEEnum, CollaborationModifier.class, "CollaborationModifier");
		addEEnumLiteral(collaborationModifierEEnum, CollaborationModifier.TRANSITIVE);
		addEEnumLiteral(collaborationModifierEEnum, CollaborationModifier.REFLEXIVE);

		// Create resource
		createResource(eNS_URI);
	}

} //RolesPackageImpl
