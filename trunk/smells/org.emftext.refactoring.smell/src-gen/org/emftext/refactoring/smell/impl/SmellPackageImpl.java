/**
 */
package org.emftext.refactoring.smell.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.SmellPackage;

import org.emftext.refactoring.smell.calculation.CalculationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmellPackageImpl extends EPackageImpl implements SmellPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualitySmellModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualitySmellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteQualitySmellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityCalculationEClass = null;

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
	 * @see org.emftext.refactoring.smell.SmellPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SmellPackageImpl() {
		super(eNS_URI, SmellFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SmellPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SmellPackage init() {
		if (isInited) return (SmellPackage)EPackage.Registry.INSTANCE.getEPackage(SmellPackage.eNS_URI);

		// Obtain or create and register package
		SmellPackageImpl theSmellPackage = (SmellPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SmellPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SmellPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CalculationPackage.eINSTANCE.eClass();
		RolemappingPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSmellPackage.createPackageContents();

		// Initialize created meta-data
		theSmellPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSmellPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SmellPackage.eNS_URI, theSmellPackage);
		return theSmellPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualitySmellModel() {
		return qualitySmellModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualitySmellModel_Smells() {
		return (EReference)qualitySmellModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualitySmellModel_Qualities() {
		return (EReference)qualitySmellModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualitySmellModel_ConcreteSmells() {
		return (EReference)qualitySmellModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualitySmellModel_SmellingMetamodels() {
		return (EReference)qualitySmellModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuality() {
		return qualityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuality_Name() {
		return (EAttribute)qualityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuality_Calculations() {
		return (EReference)qualityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualitySmell() {
		return qualitySmellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualitySmell_Name() {
		return (EAttribute)qualitySmellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteQualitySmell() {
		return concreteQualitySmellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteQualitySmell_GenericSmell() {
		return (EReference)concreteQualitySmellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteQualitySmell_ConcreteName() {
		return (EAttribute)concreteQualitySmellEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteQualitySmell_QualityCalculations() {
		return (EReference)concreteQualitySmellEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteQualitySmell_Refactoring() {
		return (EReference)concreteQualitySmellEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityCalculation() {
		return qualityCalculationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityCalculation_ConcreteSmell() {
		return (EReference)qualityCalculationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityCalculation_Quality() {
		return (EReference)qualityCalculationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualityCalculation_Influence() {
		return (EAttribute)qualityCalculationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityCalculation_Calculation() {
		return (EReference)qualityCalculationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualityCalculation_Threshold() {
		return (EAttribute)qualityCalculationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmellFactory getSmellFactory() {
		return (SmellFactory)getEFactoryInstance();
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
		qualitySmellModelEClass = createEClass(QUALITY_SMELL_MODEL);
		createEReference(qualitySmellModelEClass, QUALITY_SMELL_MODEL__SMELLS);
		createEReference(qualitySmellModelEClass, QUALITY_SMELL_MODEL__QUALITIES);
		createEReference(qualitySmellModelEClass, QUALITY_SMELL_MODEL__CONCRETE_SMELLS);
		createEReference(qualitySmellModelEClass, QUALITY_SMELL_MODEL__SMELLING_METAMODELS);

		qualityEClass = createEClass(QUALITY);
		createEAttribute(qualityEClass, QUALITY__NAME);
		createEReference(qualityEClass, QUALITY__CALCULATIONS);

		qualitySmellEClass = createEClass(QUALITY_SMELL);
		createEAttribute(qualitySmellEClass, QUALITY_SMELL__NAME);

		concreteQualitySmellEClass = createEClass(CONCRETE_QUALITY_SMELL);
		createEReference(concreteQualitySmellEClass, CONCRETE_QUALITY_SMELL__GENERIC_SMELL);
		createEAttribute(concreteQualitySmellEClass, CONCRETE_QUALITY_SMELL__CONCRETE_NAME);
		createEReference(concreteQualitySmellEClass, CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS);
		createEReference(concreteQualitySmellEClass, CONCRETE_QUALITY_SMELL__REFACTORING);

		qualityCalculationEClass = createEClass(QUALITY_CALCULATION);
		createEReference(qualityCalculationEClass, QUALITY_CALCULATION__CONCRETE_SMELL);
		createEReference(qualityCalculationEClass, QUALITY_CALCULATION__QUALITY);
		createEAttribute(qualityCalculationEClass, QUALITY_CALCULATION__INFLUENCE);
		createEReference(qualityCalculationEClass, QUALITY_CALCULATION__CALCULATION);
		createEAttribute(qualityCalculationEClass, QUALITY_CALCULATION__THRESHOLD);
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
		RolemappingPackage theRolemappingPackage = (RolemappingPackage)EPackage.Registry.INSTANCE.getEPackage(RolemappingPackage.eNS_URI);
		CalculationPackage theCalculationPackage = (CalculationPackage)EPackage.Registry.INSTANCE.getEPackage(CalculationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(qualitySmellModelEClass, QualitySmellModel.class, "QualitySmellModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualitySmellModel_Smells(), this.getQualitySmell(), null, "smells", null, 0, -1, QualitySmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualitySmellModel_Qualities(), this.getQuality(), null, "qualities", null, 0, -1, QualitySmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualitySmellModel_ConcreteSmells(), this.getConcreteQualitySmell(), null, "concreteSmells", null, 0, -1, QualitySmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualitySmellModel_SmellingMetamodels(), theEcorePackage.getEPackage(), null, "smellingMetamodels", null, 0, -1, QualitySmellModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(qualitySmellModelEClass, this.getConcreteQualitySmell(), "getSmellsForMetamodel", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEPackage(), "metamodel", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(qualityEClass, Quality.class, "Quality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuality_Name(), ecorePackage.getEString(), "name", null, 1, 1, Quality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuality_Calculations(), this.getQualityCalculation(), this.getQualityCalculation_Quality(), "calculations", null, 0, -1, Quality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualitySmellEClass, QualitySmell.class, "QualitySmell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualitySmell_Name(), ecorePackage.getEString(), "name", null, 1, 1, QualitySmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteQualitySmellEClass, ConcreteQualitySmell.class, "ConcreteQualitySmell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcreteQualitySmell_GenericSmell(), this.getQualitySmell(), null, "genericSmell", null, 1, 1, ConcreteQualitySmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteQualitySmell_ConcreteName(), ecorePackage.getEString(), "concreteName", null, 1, 1, ConcreteQualitySmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteQualitySmell_QualityCalculations(), this.getQualityCalculation(), this.getQualityCalculation_ConcreteSmell(), "qualityCalculations", null, 1, -1, ConcreteQualitySmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteQualitySmell_Refactoring(), theRolemappingPackage.getRoleMapping(), null, "refactoring", null, 0, 1, ConcreteQualitySmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualityCalculationEClass, QualityCalculation.class, "QualityCalculation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualityCalculation_ConcreteSmell(), this.getConcreteQualitySmell(), this.getConcreteQualitySmell_QualityCalculations(), "concreteSmell", null, 1, 1, QualityCalculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualityCalculation_Quality(), this.getQuality(), this.getQuality_Calculations(), "quality", null, 1, 1, QualityCalculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQualityCalculation_Influence(), theEcorePackage.getEFloat(), "influence", null, 1, 1, QualityCalculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualityCalculation_Calculation(), theCalculationPackage.getCalculation(), null, "calculation", null, 0, 1, QualityCalculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getQualityCalculation_Calculation().getEKeys().add(theCalculationPackage.getCalculation_Name());
		initEAttribute(getQualityCalculation_Threshold(), theEcorePackage.getEFloat(), "threshold", null, 0, 1, QualityCalculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SmellPackageImpl
