/**
 */
package org.emftext.refactoring.smell.umlsmells.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.refactoring.smell.calculation.CalculationPackage;

import org.emftext.refactoring.smell.umlsmells.CheckInterfaceSpecifications;
import org.emftext.refactoring.smell.umlsmells.CompareNames;
import org.emftext.refactoring.smell.umlsmells.CountParametersOfMethods;
import org.emftext.refactoring.smell.umlsmells.SearchEmptyClassesAndInterfaces;
import org.emftext.refactoring.smell.umlsmells.UmlsmellsFactory;
import org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlsmellsPackageImpl extends EPackageImpl implements UmlsmellsPackage {
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
	private EClass compareNamesEClass = null;

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
	private EClass searchEmptyClassesAndInterfacesEClass = null;

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
	 * @see org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlsmellsPackageImpl() {
		super(eNS_URI, UmlsmellsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UmlsmellsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlsmellsPackage init() {
		if (isInited) return (UmlsmellsPackage)EPackage.Registry.INSTANCE.getEPackage(UmlsmellsPackage.eNS_URI);

		// Obtain or create and register package
		UmlsmellsPackageImpl theUmlsmellsPackage = (UmlsmellsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlsmellsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlsmellsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CalculationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlsmellsPackage.createPackageContents();

		// Initialize created meta-data
		theUmlsmellsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlsmellsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlsmellsPackage.eNS_URI, theUmlsmellsPackage);
		return theUmlsmellsPackage;
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
	public EClass getCompareNames() {
		return compareNamesEClass;
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
	public EClass getSearchEmptyClassesAndInterfaces() {
		return searchEmptyClassesAndInterfacesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlsmellsFactory getUmlsmellsFactory() {
		return (UmlsmellsFactory)getEFactoryInstance();
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

		compareNamesEClass = createEClass(COMPARE_NAMES);

		countParametersOfMethodsEClass = createEClass(COUNT_PARAMETERS_OF_METHODS);

		searchEmptyClassesAndInterfacesEClass = createEClass(SEARCH_EMPTY_CLASSES_AND_INTERFACES);
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
		compareNamesEClass.getESuperTypes().add(theCalculationPackage.getMetric());
		countParametersOfMethodsEClass.getESuperTypes().add(theCalculationPackage.getMetric());
		searchEmptyClassesAndInterfacesEClass.getESuperTypes().add(theCalculationPackage.getMetric());

		// Initialize classes and features; add operations and parameters
		initEClass(checkInterfaceSpecificationsEClass, CheckInterfaceSpecifications.class, "CheckInterfaceSpecifications", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compareNamesEClass, CompareNames.class, "CompareNames", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(countParametersOfMethodsEClass, CountParametersOfMethods.class, "CountParametersOfMethods", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(searchEmptyClassesAndInterfacesEClass, SearchEmptyClassesAndInterfaces.class, "SearchEmptyClassesAndInterfaces", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //UmlsmellsPackageImpl
