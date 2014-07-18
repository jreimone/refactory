/**
 */
package org.emftext.refactoring.smell.calculation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.emftext.refactoring.smell.calculation.CalculationFactory
 * @model kind="package"
 * @generated
 */
public interface CalculationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "calculation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelrefactoring.org/smell/calculation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "calculation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CalculationPackage eINSTANCE = org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.CalculationModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationModelImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCalculationModel()
	 * @generated
	 */
	int CALCULATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Calculations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION_MODEL__CALCULATIONS = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.CalculationImpl <em>Calculation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCalculation()
	 * @generated
	 */
	int CALCULATION = 1;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION__MONOTONICITY = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION__SMELL_MESSAGE = 3;

	/**
	 * The number of structural features of the '<em>Calculation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCalculationResult()
	 * @generated
	 */
	int CALCULATION_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Resulting Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION_RESULT__RESULTING_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Causing Objects Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS = 1;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATION_RESULT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.StructureImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 3;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__MONOTONICITY = CALCULATION__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__DESCRIPTION = CALCULATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__NAME = CALCULATION__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__SMELL_MESSAGE = CALCULATION__SMELL_MESSAGE;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__PATTERN = CALCULATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = CALCULATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.MetricImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 4;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__MONOTONICITY = CALCULATION__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DESCRIPTION = CALCULATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = CALCULATION__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__SMELL_MESSAGE = CALCULATION__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = CALCULATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.CausingObjectsGroupImpl <em>Causing Objects Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.CausingObjectsGroupImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCausingObjectsGroup()
	 * @generated
	 */
	int CAUSING_OBJECTS_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Named Causing Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS = 0;

	/**
	 * The number of structural features of the '<em>Causing Objects Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAUSING_OBJECTS_GROUP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.impl.NamedCausingObjectImpl <em>Named Causing Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.impl.NamedCausingObjectImpl
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getNamedCausingObject()
	 * @generated
	 */
	int NAMED_CAUSING_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CAUSING_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Causing Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CAUSING_OBJECT__CAUSING_OBJECT = 1;

	/**
	 * The number of structural features of the '<em>Named Causing Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CAUSING_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.calculation.Monotonicity <em>Monotonicity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.calculation.Monotonicity
	 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getMonotonicity()
	 * @generated
	 */
	int MONOTONICITY = 7;


	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.CalculationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CalculationModel
	 * @generated
	 */
	EClass getCalculationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.calculation.CalculationModel#getCalculations <em>Calculations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Calculations</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CalculationModel#getCalculations()
	 * @see #getCalculationModel()
	 * @generated
	 */
	EReference getCalculationModel_Calculations();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.Calculation <em>Calculation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calculation</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Calculation
	 * @generated
	 */
	EClass getCalculation();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.calculation.Calculation#getMonotonicity <em>Monotonicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Monotonicity</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Calculation#getMonotonicity()
	 * @see #getCalculation()
	 * @generated
	 */
	EAttribute getCalculation_Monotonicity();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.calculation.Calculation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Calculation#getDescription()
	 * @see #getCalculation()
	 * @generated
	 */
	EAttribute getCalculation_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.calculation.Calculation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Calculation#getName()
	 * @see #getCalculation()
	 * @generated
	 */
	EAttribute getCalculation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.calculation.Calculation#getSmellMessage <em>Smell Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smell Message</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Calculation#getSmellMessage()
	 * @see #getCalculation()
	 * @generated
	 */
	EAttribute getCalculation_SmellMessage();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.CalculationResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CalculationResult
	 * @generated
	 */
	EClass getCalculationResult();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.calculation.CalculationResult#getResultingValue <em>Resulting Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resulting Value</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CalculationResult#getResultingValue()
	 * @see #getCalculationResult()
	 * @generated
	 */
	EAttribute getCalculationResult_ResultingValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.calculation.CalculationResult#getCausingObjectsGroups <em>Causing Objects Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Causing Objects Groups</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CalculationResult#getCausingObjectsGroups()
	 * @see #getCalculationResult()
	 * @generated
	 */
	EReference getCalculationResult_CausingObjectsGroups();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.calculation.Structure#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pattern</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Structure#getPattern()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Pattern();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.CausingObjectsGroup <em>Causing Objects Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Causing Objects Group</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CausingObjectsGroup
	 * @generated
	 */
	EClass getCausingObjectsGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.calculation.CausingObjectsGroup#getNamedCausingObjects <em>Named Causing Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Named Causing Objects</em>'.
	 * @see org.emftext.refactoring.smell.calculation.CausingObjectsGroup#getNamedCausingObjects()
	 * @see #getCausingObjectsGroup()
	 * @generated
	 */
	EReference getCausingObjectsGroup_NamedCausingObjects();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.calculation.NamedCausingObject <em>Named Causing Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Causing Object</em>'.
	 * @see org.emftext.refactoring.smell.calculation.NamedCausingObject
	 * @generated
	 */
	EClass getNamedCausingObject();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.calculation.NamedCausingObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.calculation.NamedCausingObject#getName()
	 * @see #getNamedCausingObject()
	 * @generated
	 */
	EAttribute getNamedCausingObject_Name();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.calculation.NamedCausingObject#getCausingObject <em>Causing Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Causing Object</em>'.
	 * @see org.emftext.refactoring.smell.calculation.NamedCausingObject#getCausingObject()
	 * @see #getNamedCausingObject()
	 * @generated
	 */
	EReference getNamedCausingObject_CausingObject();

	/**
	 * Returns the meta object for enum '{@link org.emftext.refactoring.smell.calculation.Monotonicity <em>Monotonicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Monotonicity</em>'.
	 * @see org.emftext.refactoring.smell.calculation.Monotonicity
	 * @generated
	 */
	EEnum getMonotonicity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CalculationFactory getCalculationFactory();

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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.CalculationModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationModelImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCalculationModel()
		 * @generated
		 */
		EClass CALCULATION_MODEL = eINSTANCE.getCalculationModel();

		/**
		 * The meta object literal for the '<em><b>Calculations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCULATION_MODEL__CALCULATIONS = eINSTANCE.getCalculationModel_Calculations();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.CalculationImpl <em>Calculation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCalculation()
		 * @generated
		 */
		EClass CALCULATION = eINSTANCE.getCalculation();

		/**
		 * The meta object literal for the '<em><b>Monotonicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCULATION__MONOTONICITY = eINSTANCE.getCalculation_Monotonicity();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCULATION__DESCRIPTION = eINSTANCE.getCalculation_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCULATION__NAME = eINSTANCE.getCalculation_Name();

		/**
		 * The meta object literal for the '<em><b>Smell Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCULATION__SMELL_MESSAGE = eINSTANCE.getCalculation_SmellMessage();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCalculationResult()
		 * @generated
		 */
		EClass CALCULATION_RESULT = eINSTANCE.getCalculationResult();

		/**
		 * The meta object literal for the '<em><b>Resulting Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCULATION_RESULT__RESULTING_VALUE = eINSTANCE.getCalculationResult_ResultingValue();

		/**
		 * The meta object literal for the '<em><b>Causing Objects Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS = eINSTANCE.getCalculationResult_CausingObjectsGroups();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.StructureImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__PATTERN = eINSTANCE.getStructure_Pattern();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.MetricImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.CausingObjectsGroupImpl <em>Causing Objects Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.CausingObjectsGroupImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getCausingObjectsGroup()
		 * @generated
		 */
		EClass CAUSING_OBJECTS_GROUP = eINSTANCE.getCausingObjectsGroup();

		/**
		 * The meta object literal for the '<em><b>Named Causing Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS = eINSTANCE.getCausingObjectsGroup_NamedCausingObjects();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.impl.NamedCausingObjectImpl <em>Named Causing Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.impl.NamedCausingObjectImpl
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getNamedCausingObject()
		 * @generated
		 */
		EClass NAMED_CAUSING_OBJECT = eINSTANCE.getNamedCausingObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_CAUSING_OBJECT__NAME = eINSTANCE.getNamedCausingObject_Name();

		/**
		 * The meta object literal for the '<em><b>Causing Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_CAUSING_OBJECT__CAUSING_OBJECT = eINSTANCE.getNamedCausingObject_CausingObject();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.calculation.Monotonicity <em>Monotonicity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.calculation.Monotonicity
		 * @see org.emftext.refactoring.smell.calculation.impl.CalculationPackageImpl#getMonotonicity()
		 * @generated
		 */
		EEnum MONOTONICITY = eINSTANCE.getMonotonicity();

	}

} //CalculationPackage
