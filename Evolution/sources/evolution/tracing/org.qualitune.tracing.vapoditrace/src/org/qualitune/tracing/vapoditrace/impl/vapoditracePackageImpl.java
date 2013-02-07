/**
 */
package org.qualitune.tracing.vapoditrace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.qualitune.tracing.vapoditrace.ConcernType;
import org.qualitune.tracing.vapoditrace.DynamicEntity;
import org.qualitune.tracing.vapoditrace.EEntity;
import org.qualitune.tracing.vapoditrace.StaticEntity;
import org.qualitune.tracing.vapoditrace.TraceCollection;
import org.qualitune.tracing.vapoditrace.TraceEntity;
import org.qualitune.tracing.vapoditrace.TraceLink;
import org.qualitune.tracing.vapoditrace.TraceType;
import org.qualitune.tracing.vapoditrace.UniverseType;
import org.qualitune.tracing.vapoditrace.vapoditraceFactory;
import org.qualitune.tracing.vapoditrace.vapoditracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class vapoditracePackageImpl extends EPackageImpl implements vapoditracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum traceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum concernTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum universeTypeEEnum = null;

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
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private vapoditracePackageImpl() {
		super(eNS_URI, vapoditraceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link vapoditracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static vapoditracePackage init() {
		if (isInited) return (vapoditracePackage)EPackage.Registry.INSTANCE.getEPackage(vapoditracePackage.eNS_URI);

		// Obtain or create and register package
		vapoditracePackageImpl thevapoditracePackage = (vapoditracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof vapoditracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new vapoditracePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thevapoditracePackage.createPackageContents();

		// Initialize created meta-data
		thevapoditracePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thevapoditracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(vapoditracePackage.eNS_URI, thevapoditracePackage);
		return thevapoditracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceLink() {
		return traceLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceLink_Destination() {
		return (EReference)traceLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceLink_Source() {
		return (EReference)traceLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceCollection() {
		return traceCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceCollection_TraceLinks() {
		return (EReference)traceCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceCollection_ShadowObjects() {
		return (EReference)traceCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceCollection_Trash() {
		return (EReference)traceCollectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEntity() {
		return eEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEEntity_AttributeName() {
		return (EAttribute)eEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEEntity_Concern() {
		return (EAttribute)eEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceEntity() {
		return traceEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEntity_Semantics() {
		return (EAttribute)traceEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEntity_Universe() {
		return (EAttribute)traceEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicEntity() {
		return dynamicEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicEntity_Attribute() {
		return (EReference)dynamicEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicEntity_Esf() {
		return (EReference)dynamicEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicEntity_Object() {
		return (EReference)dynamicEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticEntity() {
		return staticEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticEntity_ObjectName() {
		return (EAttribute)staticEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticEntity_Type() {
		return (EAttribute)staticEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTraceType() {
		return traceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConcernType() {
		return concernTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUniverseType() {
		return universeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public vapoditraceFactory getvapoditraceFactory() {
		return (vapoditraceFactory)getEFactoryInstance();
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
		traceLinkEClass = createEClass(TRACE_LINK);
		createEReference(traceLinkEClass, TRACE_LINK__DESTINATION);
		createEReference(traceLinkEClass, TRACE_LINK__SOURCE);

		traceCollectionEClass = createEClass(TRACE_COLLECTION);
		createEReference(traceCollectionEClass, TRACE_COLLECTION__TRACE_LINKS);
		createEReference(traceCollectionEClass, TRACE_COLLECTION__SHADOW_OBJECTS);
		createEReference(traceCollectionEClass, TRACE_COLLECTION__TRASH);

		eEntityEClass = createEClass(EENTITY);
		createEAttribute(eEntityEClass, EENTITY__ATTRIBUTE_NAME);
		createEAttribute(eEntityEClass, EENTITY__CONCERN);

		traceEntityEClass = createEClass(TRACE_ENTITY);
		createEAttribute(traceEntityEClass, TRACE_ENTITY__SEMANTICS);
		createEAttribute(traceEntityEClass, TRACE_ENTITY__UNIVERSE);

		dynamicEntityEClass = createEClass(DYNAMIC_ENTITY);
		createEReference(dynamicEntityEClass, DYNAMIC_ENTITY__ATTRIBUTE);
		createEReference(dynamicEntityEClass, DYNAMIC_ENTITY__ESF);
		createEReference(dynamicEntityEClass, DYNAMIC_ENTITY__OBJECT);

		staticEntityEClass = createEClass(STATIC_ENTITY);
		createEAttribute(staticEntityEClass, STATIC_ENTITY__OBJECT_NAME);
		createEAttribute(staticEntityEClass, STATIC_ENTITY__TYPE);

		// Create enums
		traceTypeEEnum = createEEnum(TRACE_TYPE);
		concernTypeEEnum = createEEnum(CONCERN_TYPE);
		universeTypeEEnum = createEEnum(UNIVERSE_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		traceEntityEClass.getESuperTypes().add(this.getEEntity());
		dynamicEntityEClass.getESuperTypes().add(this.getTraceEntity());
		staticEntityEClass.getESuperTypes().add(this.getTraceEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(traceLinkEClass, TraceLink.class, "TraceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceLink_Destination(), this.getTraceEntity(), null, "destination", null, 1, 1, TraceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceLink_Source(), this.getTraceEntity(), null, "source", null, 0, -1, TraceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceCollectionEClass, TraceCollection.class, "TraceCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceCollection_TraceLinks(), this.getTraceLink(), null, "traceLinks", null, 0, -1, TraceCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceCollection_ShadowObjects(), theEcorePackage.getEObject(), null, "shadowObjects", null, 0, -1, TraceCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceCollection_Trash(), this.getTraceLink(), null, "trash", null, 0, -1, TraceCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEntityEClass, EEntity.class, "EEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEEntity_AttributeName(), theEcorePackage.getEString(), "attributeName", null, 0, 1, EEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEntity_Concern(), this.getConcernType(), "concern", null, 1, 1, EEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceEntityEClass, TraceEntity.class, "TraceEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceEntity_Semantics(), this.getTraceType(), "semantics", null, 1, 1, TraceEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceEntity_Universe(), this.getUniverseType(), "universe", null, 1, 1, TraceEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicEntityEClass, DynamicEntity.class, "DynamicEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDynamicEntity_Attribute(), theEcorePackage.getEAttribute(), null, "attribute", null, 0, 1, DynamicEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicEntity_Esf(), theEcorePackage.getEStructuralFeature(), null, "esf", null, 0, 1, DynamicEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicEntity_Object(), theEcorePackage.getEObject(), null, "object", null, 0, 1, DynamicEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticEntityEClass, StaticEntity.class, "StaticEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticEntity_ObjectName(), theEcorePackage.getEString(), "objectName", null, 0, 1, StaticEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticEntity_Type(), theEcorePackage.getEString(), "type", null, 0, 1, StaticEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(traceTypeEEnum, TraceType.class, "TraceType");
		addEEnumLiteral(traceTypeEEnum, TraceType.OMITTED_TRACETYPE);
		addEEnumLiteral(traceTypeEEnum, TraceType.CREATE);
		addEEnumLiteral(traceTypeEEnum, TraceType.READ);
		addEEnumLiteral(traceTypeEEnum, TraceType.UPDATE);
		addEEnumLiteral(traceTypeEEnum, TraceType.DELETE);
		addEEnumLiteral(traceTypeEEnum, TraceType.WRITE);
		addEEnumLiteral(traceTypeEEnum, TraceType.EXISTENCE);

		initEEnum(concernTypeEEnum, ConcernType.class, "ConcernType");
		addEEnumLiteral(concernTypeEEnum, ConcernType.OMITTED_CONCERN);
		addEEnumLiteral(concernTypeEEnum, ConcernType.OBJECT);
		addEEnumLiteral(concernTypeEEnum, ConcernType.ATTRIBUTE);
		addEEnumLiteral(concernTypeEEnum, ConcernType.TYPE);

		initEEnum(universeTypeEEnum, UniverseType.class, "UniverseType");
		addEEnumLiteral(universeTypeEEnum, UniverseType.OMITTED_UNIVERSE);
		addEEnumLiteral(universeTypeEEnum, UniverseType.LIGHT_UNIVERSE);
		addEEnumLiteral(universeTypeEEnum, UniverseType.SHADOW_UNIVERSE);

		// Create resource
		createResource(eNS_URI);
	}

} //vapoditracePackageImpl
