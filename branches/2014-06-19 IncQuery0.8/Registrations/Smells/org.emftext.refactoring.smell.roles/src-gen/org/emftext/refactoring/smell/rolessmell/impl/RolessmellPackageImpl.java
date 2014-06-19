/**
 */
package org.emftext.refactoring.smell.rolessmell.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.refactoring.smell.calculation.CalculationPackage;

import org.emftext.refactoring.smell.rolessmell.DistinctRoleNames;
import org.emftext.refactoring.smell.rolessmell.RolessmellFactory;
import org.emftext.refactoring.smell.rolessmell.RolessmellPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RolessmellPackageImpl extends EPackageImpl implements RolessmellPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distinctRoleNamesEClass = null;

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
	 * @see org.emftext.refactoring.smell.rolessmell.RolessmellPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RolessmellPackageImpl() {
		super(eNS_URI, RolessmellFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RolessmellPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RolessmellPackage init() {
		if (isInited) return (RolessmellPackage)EPackage.Registry.INSTANCE.getEPackage(RolessmellPackage.eNS_URI);

		// Obtain or create and register package
		RolessmellPackageImpl theRolessmellPackage = (RolessmellPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RolessmellPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RolessmellPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CalculationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRolessmellPackage.createPackageContents();

		// Initialize created meta-data
		theRolessmellPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRolessmellPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RolessmellPackage.eNS_URI, theRolessmellPackage);
		return theRolessmellPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDistinctRoleNames() {
		return distinctRoleNamesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolessmellFactory getRolessmellFactory() {
		return (RolessmellFactory)getEFactoryInstance();
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
		distinctRoleNamesEClass = createEClass(DISTINCT_ROLE_NAMES);
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
		CalculationPackage theCalculationPackage = (CalculationPackage)EPackage.Registry.INSTANCE.getEPackage(CalculationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		distinctRoleNamesEClass.getESuperTypes().add(theCalculationPackage.getMetric());

		// Initialize classes and features; add operations and parameters
		initEClass(distinctRoleNamesEClass, DistinctRoleNames.class, "DistinctRoleNames", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RolessmellPackageImpl
