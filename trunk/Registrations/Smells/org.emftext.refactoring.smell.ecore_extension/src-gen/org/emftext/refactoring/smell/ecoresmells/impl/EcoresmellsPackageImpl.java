/**
 */
package org.emftext.refactoring.smell.ecoresmells.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.refactoring.smell.calculation.CalculationPackage;

import org.emftext.refactoring.smell.ecoresmells.CheckInterfaceSpecifications;
import org.emftext.refactoring.smell.ecoresmells.CompareNamesOfClasses;
import org.emftext.refactoring.smell.ecoresmells.CountParametersOfMethods;
import org.emftext.refactoring.smell.ecoresmells.EcoresmellsFactory;
import org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage;
import org.emftext.refactoring.smell.ecoresmells.SearchEmptyClasses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoresmellsPackageImpl extends EPackageImpl implements EcoresmellsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkInterfaceSpecificationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compareNamesOfClassesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countParametersOfMethodsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchEmptyClassesEClass = null;

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
	 * @see org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcoresmellsPackageImpl() {
		super(eNS_URI, EcoresmellsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcoresmellsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcoresmellsPackage init() {
		if (isInited) return (EcoresmellsPackage)EPackage.Registry.INSTANCE.getEPackage(EcoresmellsPackage.eNS_URI);

		// Obtain or create and register package
		EcoresmellsPackageImpl theEcoresmellsPackage = (EcoresmellsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcoresmellsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcoresmellsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CalculationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEcoresmellsPackage.createPackageContents();

		// Initialize created meta-data
		theEcoresmellsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcoresmellsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcoresmellsPackage.eNS_URI, theEcoresmellsPackage);
		return theEcoresmellsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckInterfaceSpecifications() {
		return checkInterfaceSpecificationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareNamesOfClasses() {
		return compareNamesOfClassesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountParametersOfMethods() {
		return countParametersOfMethodsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchEmptyClasses() {
		return searchEmptyClassesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoresmellsFactory getEcoresmellsFactory() {
		return (EcoresmellsFactory)getEFactoryInstance();
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
		checkInterfaceSpecificationsEClass = createEClass(CHECK_INTERFACE_SPECIFICATIONS);

		compareNamesOfClassesEClass = createEClass(COMPARE_NAMES_OF_CLASSES);

		countParametersOfMethodsEClass = createEClass(COUNT_PARAMETERS_OF_METHODS);

		searchEmptyClassesEClass = createEClass(SEARCH_EMPTY_CLASSES);
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
		checkInterfaceSpecificationsEClass.getESuperTypes().add(theCalculationPackage.getMetric());
		compareNamesOfClassesEClass.getESuperTypes().add(theCalculationPackage.getMetric());
		countParametersOfMethodsEClass.getESuperTypes().add(theCalculationPackage.getMetric());
		searchEmptyClassesEClass.getESuperTypes().add(theCalculationPackage.getMetric());

		// Initialize classes and features; add operations and parameters
		initEClass(checkInterfaceSpecificationsEClass, CheckInterfaceSpecifications.class, "CheckInterfaceSpecifications", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compareNamesOfClassesEClass, CompareNamesOfClasses.class, "CompareNamesOfClasses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(countParametersOfMethodsEClass, CountParametersOfMethods.class, "CountParametersOfMethods", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(searchEmptyClassesEClass, SearchEmptyClasses.class, "SearchEmptyClasses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EcoresmellsPackageImpl
