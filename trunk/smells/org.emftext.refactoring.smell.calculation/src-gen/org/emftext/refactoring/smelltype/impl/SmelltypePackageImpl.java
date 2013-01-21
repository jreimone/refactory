/**
 */
package org.emftext.refactoring.smelltype.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.refactoring.smelltype.SmellType;
import org.emftext.refactoring.smelltype.SmellTypeModel;
import org.emftext.refactoring.smelltype.SmelltypeFactory;
import org.emftext.refactoring.smelltype.SmelltypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmelltypePackageImpl extends EPackageImpl implements SmelltypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smellTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smellTypeModelEClass = null;

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
	 * @see org.emftext.refactoring.smelltype.SmelltypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SmelltypePackageImpl() {
		super(eNS_URI, SmelltypeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SmelltypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SmelltypePackage init() {
		if (isInited) return (SmelltypePackage)EPackage.Registry.INSTANCE.getEPackage(SmelltypePackage.eNS_URI);

		// Obtain or create and register package
		SmelltypePackageImpl theSmelltypePackage = (SmelltypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SmelltypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SmelltypePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSmelltypePackage.createPackageContents();

		// Initialize created meta-data
		theSmelltypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSmelltypePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SmelltypePackage.eNS_URI, theSmelltypePackage);
		return theSmelltypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmellType() {
		return smellTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmellType_LowerBound() {
		return (EAttribute)smellTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmellType_UpperBound() {
		return (EAttribute)smellTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmellType_Increment() {
		return (EAttribute)smellTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmellType_Name() {
		return (EAttribute)smellTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmellTypeModel() {
		return smellTypeModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmellTypeModel_Types() {
		return (EReference)smellTypeModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmelltypeFactory getSmelltypeFactory() {
		return (SmelltypeFactory)getEFactoryInstance();
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
		smellTypeEClass = createEClass(SMELL_TYPE);
		createEAttribute(smellTypeEClass, SMELL_TYPE__LOWER_BOUND);
		createEAttribute(smellTypeEClass, SMELL_TYPE__UPPER_BOUND);
		createEAttribute(smellTypeEClass, SMELL_TYPE__INCREMENT);
		createEAttribute(smellTypeEClass, SMELL_TYPE__NAME);

		smellTypeModelEClass = createEClass(SMELL_TYPE_MODEL);
		createEReference(smellTypeModelEClass, SMELL_TYPE_MODEL__TYPES);
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

		// Initialize classes and features; add operations and parameters
		initEClass(smellTypeEClass, SmellType.class, "SmellType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSmellType_LowerBound(), ecorePackage.getEFloat(), "lowerBound", null, 1, 1, SmellType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmellType_UpperBound(), ecorePackage.getEFloat(), "upperBound", null, 1, 1, SmellType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmellType_Increment(), ecorePackage.getEFloat(), "increment", null, 1, 1, SmellType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmellType_Name(), ecorePackage.getEString(), "name", null, 1, 1, SmellType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smellTypeModelEClass, SmellTypeModel.class, "SmellTypeModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmellTypeModel_Types(), this.getSmellType(), null, "types", null, 0, -1, SmellTypeModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SmelltypePackageImpl
