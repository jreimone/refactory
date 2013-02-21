/**
 */
package org.emftext.refactoring.smell.ecoresmells;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.emftext.refactoring.smell.calculation.CalculationPackage;

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
 * @see org.emftext.refactoring.smell.ecoresmells.EcoresmellsFactory
 * @model kind="package"
 * @generated
 */
public interface EcoresmellsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecoresmells";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelrefactoring.org/smell/calculation/ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecoresmells";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoresmellsPackage eINSTANCE = org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.CheckInterfaceSpecificationsImpl <em>Check Interface Specifications</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.CheckInterfaceSpecificationsImpl
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getCheckInterfaceSpecifications()
	 * @generated
	 */
	int CHECK_INTERFACE_SPECIFICATIONS = 0;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_INTERFACE_SPECIFICATIONS__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_INTERFACE_SPECIFICATIONS__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_INTERFACE_SPECIFICATIONS__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_INTERFACE_SPECIFICATIONS__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Check Interface Specifications</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_INTERFACE_SPECIFICATIONS_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.CompareNamesOfClassesImpl <em>Compare Names Of Classes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.CompareNamesOfClassesImpl
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getCompareNamesOfClasses()
	 * @generated
	 */
	int COMPARE_NAMES_OF_CLASSES = 1;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES_OF_CLASSES__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES_OF_CLASSES__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES_OF_CLASSES__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES_OF_CLASSES__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Compare Names Of Classes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES_OF_CLASSES_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.CountParametersOfMethodsImpl <em>Count Parameters Of Methods</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.CountParametersOfMethodsImpl
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getCountParametersOfMethods()
	 * @generated
	 */
	int COUNT_PARAMETERS_OF_METHODS = 2;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_PARAMETERS_OF_METHODS__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_PARAMETERS_OF_METHODS__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_PARAMETERS_OF_METHODS__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_PARAMETERS_OF_METHODS__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Count Parameters Of Methods</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_PARAMETERS_OF_METHODS_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.SearchEmptyClassesImpl <em>Search Empty Classes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.SearchEmptyClassesImpl
	 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getSearchEmptyClasses()
	 * @generated
	 */
	int SEARCH_EMPTY_CLASSES = 3;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Search Empty Classes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.ecoresmells.CheckInterfaceSpecifications <em>Check Interface Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Interface Specifications</em>'.
	 * @see org.emftext.refactoring.smell.ecoresmells.CheckInterfaceSpecifications
	 * @generated
	 */
	EClass getCheckInterfaceSpecifications();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.ecoresmells.CompareNamesOfClasses <em>Compare Names Of Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Names Of Classes</em>'.
	 * @see org.emftext.refactoring.smell.ecoresmells.CompareNamesOfClasses
	 * @generated
	 */
	EClass getCompareNamesOfClasses();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.ecoresmells.CountParametersOfMethods <em>Count Parameters Of Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Parameters Of Methods</em>'.
	 * @see org.emftext.refactoring.smell.ecoresmells.CountParametersOfMethods
	 * @generated
	 */
	EClass getCountParametersOfMethods();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.ecoresmells.SearchEmptyClasses <em>Search Empty Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Empty Classes</em>'.
	 * @see org.emftext.refactoring.smell.ecoresmells.SearchEmptyClasses
	 * @generated
	 */
	EClass getSearchEmptyClasses();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcoresmellsFactory getEcoresmellsFactory();

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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.CheckInterfaceSpecificationsImpl <em>Check Interface Specifications</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.CheckInterfaceSpecificationsImpl
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getCheckInterfaceSpecifications()
		 * @generated
		 */
		EClass CHECK_INTERFACE_SPECIFICATIONS = eINSTANCE.getCheckInterfaceSpecifications();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.CompareNamesOfClassesImpl <em>Compare Names Of Classes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.CompareNamesOfClassesImpl
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getCompareNamesOfClasses()
		 * @generated
		 */
		EClass COMPARE_NAMES_OF_CLASSES = eINSTANCE.getCompareNamesOfClasses();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.CountParametersOfMethodsImpl <em>Count Parameters Of Methods</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.CountParametersOfMethodsImpl
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getCountParametersOfMethods()
		 * @generated
		 */
		EClass COUNT_PARAMETERS_OF_METHODS = eINSTANCE.getCountParametersOfMethods();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.ecoresmells.impl.SearchEmptyClassesImpl <em>Search Empty Classes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.SearchEmptyClassesImpl
		 * @see org.emftext.refactoring.smell.ecoresmells.impl.EcoresmellsPackageImpl#getSearchEmptyClasses()
		 * @generated
		 */
		EClass SEARCH_EMPTY_CLASSES = eINSTANCE.getSearchEmptyClasses();

	}

} //EcoresmellsPackage
