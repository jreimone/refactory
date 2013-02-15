/**
 */
package org.emftext.refactoring.smell.calculation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Metric;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CalculationPackageImpl extends EPackageImpl implements CalculationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum monotonicityEEnum = null;

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
	 * @see org.emftext.refactoring.smell.calculation.CalculationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CalculationPackageImpl() {
		super(eNS_URI, CalculationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CalculationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CalculationPackage init() {
		if (isInited) return (CalculationPackage)EPackage.Registry.INSTANCE.getEPackage(CalculationPackage.eNS_URI);

		// Obtain or create and register package
		CalculationPackageImpl theCalculationPackage = (CalculationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CalculationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CalculationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCalculationPackage.createPackageContents();

		// Initialize created meta-data
		theCalculationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCalculationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CalculationPackage.eNS_URI, theCalculationPackage);
		return theCalculationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalculationModel() {
		return calculationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalculationModel_Calculations() {
		return (EReference)calculationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalculation() {
		return calculationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculation_Monotonicity() {
		return (EAttribute)calculationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculation_Description() {
		return (EAttribute)calculationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculation_Name() {
		return (EAttribute)calculationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculation_SmellMessage() {
		return (EAttribute)calculationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculation_Threshold() {
		return (EAttribute)calculationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalculationResult() {
		return calculationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalculationResult_CausingObjects() {
		return (EReference)calculationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculationResult_ResultingValue() {
		return (EAttribute)calculationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMonotonicity() {
		return monotonicityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculationFactory getCalculationFactory() {
		return (CalculationFactory)getEFactoryInstance();
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
		calculationModelEClass = createEClass(CALCULATION_MODEL);
		createEReference(calculationModelEClass, CALCULATION_MODEL__CALCULATIONS);

		calculationEClass = createEClass(CALCULATION);
		createEAttribute(calculationEClass, CALCULATION__MONOTONICITY);
		createEAttribute(calculationEClass, CALCULATION__DESCRIPTION);
		createEAttribute(calculationEClass, CALCULATION__NAME);
		createEAttribute(calculationEClass, CALCULATION__SMELL_MESSAGE);
		createEAttribute(calculationEClass, CALCULATION__THRESHOLD);

		calculationResultEClass = createEClass(CALCULATION_RESULT);
		createEReference(calculationResultEClass, CALCULATION_RESULT__CAUSING_OBJECTS);
		createEAttribute(calculationResultEClass, CALCULATION_RESULT__RESULTING_VALUE);

		structureEClass = createEClass(STRUCTURE);

		metricEClass = createEClass(METRIC);

		// Create enums
		monotonicityEEnum = createEEnum(MONOTONICITY);
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
		structureEClass.getESuperTypes().add(this.getCalculation());
		metricEClass.getESuperTypes().add(this.getCalculation());

		// Initialize classes and features; add operations and parameters
		initEClass(calculationModelEClass, CalculationModel.class, "CalculationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCalculationModel_Calculations(), this.getCalculation(), null, "calculations", null, 0, -1, CalculationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(calculationEClass, Calculation.class, "Calculation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCalculation_Monotonicity(), this.getMonotonicity(), "monotonicity", null, 1, 1, Calculation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalculation_Description(), ecorePackage.getEString(), "description", "", 1, 1, Calculation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalculation_Name(), ecorePackage.getEString(), "name", "", 1, 1, Calculation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalculation_SmellMessage(), ecorePackage.getEString(), "smellMessage", "", 1, 1, Calculation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalculation_Threshold(), ecorePackage.getEFloat(), "threshold", null, 0, 1, Calculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(calculationEClass, this.getCalculationResult(), "calculate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(calculationResultEClass, CalculationResult.class, "CalculationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCalculationResult_CausingObjects(), ecorePackage.getEObject(), null, "causingObjects", null, 0, -1, CalculationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalculationResult_ResultingValue(), ecorePackage.getEFloat(), "resultingValue", null, 1, 1, CalculationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metricEClass, Metric.class, "Metric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(monotonicityEEnum, Monotonicity.class, "Monotonicity");
		addEEnumLiteral(monotonicityEEnum, Monotonicity.INCREASING);
		addEEnumLiteral(monotonicityEEnum, Monotonicity.DECREASING);

		// Create resource
		createResource(eNS_URI);
	}

} //CalculationPackageImpl
