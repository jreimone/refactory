/**
 */
package org.emftext.refactoring.smell.umlsmells;

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
 * @see org.emftext.refactoring.smell.umlsmells.UmlsmellsFactory
 * @model kind="package"
 * @generated
 */
public interface UmlsmellsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "umlsmells";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelrefactoring.org/smell/calculation/uml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "umlsmells";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlsmellsPackage eINSTANCE = org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.umlsmells.impl.CheckInterfaceSpecificationsImpl <em>Check Interface Specifications</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.umlsmells.impl.CheckInterfaceSpecificationsImpl
	 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getCheckInterfaceSpecifications()
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
	 * The meta object id for the '{@link org.emftext.refactoring.smell.umlsmells.impl.CompareNamesImpl <em>Compare Names</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.umlsmells.impl.CompareNamesImpl
	 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getCompareNames()
	 * @generated
	 */
	int COMPARE_NAMES = 1;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Compare Names</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NAMES_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.umlsmells.impl.CountParametersOfMethodsImpl <em>Count Parameters Of Methods</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.umlsmells.impl.CountParametersOfMethodsImpl
	 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getCountParametersOfMethods()
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
	 * The meta object id for the '{@link org.emftext.refactoring.smell.umlsmells.impl.SearchEmptyClassesAndInterfacesImpl <em>Search Empty Classes And Interfaces</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.umlsmells.impl.SearchEmptyClassesAndInterfacesImpl
	 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getSearchEmptyClassesAndInterfaces()
	 * @generated
	 */
	int SEARCH_EMPTY_CLASSES_AND_INTERFACES = 3;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES_AND_INTERFACES__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES_AND_INTERFACES__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES_AND_INTERFACES__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES_AND_INTERFACES__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Search Empty Classes And Interfaces</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_EMPTY_CLASSES_AND_INTERFACES_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.umlsmells.CheckInterfaceSpecifications <em>Check Interface Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Interface Specifications</em>'.
	 * @see org.emftext.refactoring.smell.umlsmells.CheckInterfaceSpecifications
	 * @generated
	 */
	EClass getCheckInterfaceSpecifications();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.umlsmells.CompareNames <em>Compare Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Names</em>'.
	 * @see org.emftext.refactoring.smell.umlsmells.CompareNames
	 * @generated
	 */
	EClass getCompareNames();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.umlsmells.CountParametersOfMethods <em>Count Parameters Of Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Parameters Of Methods</em>'.
	 * @see org.emftext.refactoring.smell.umlsmells.CountParametersOfMethods
	 * @generated
	 */
	EClass getCountParametersOfMethods();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.umlsmells.SearchEmptyClassesAndInterfaces <em>Search Empty Classes And Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Empty Classes And Interfaces</em>'.
	 * @see org.emftext.refactoring.smell.umlsmells.SearchEmptyClassesAndInterfaces
	 * @generated
	 */
	EClass getSearchEmptyClassesAndInterfaces();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlsmellsFactory getUmlsmellsFactory();

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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.umlsmells.impl.CheckInterfaceSpecificationsImpl <em>Check Interface Specifications</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.umlsmells.impl.CheckInterfaceSpecificationsImpl
		 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getCheckInterfaceSpecifications()
		 * @generated
		 */
		EClass CHECK_INTERFACE_SPECIFICATIONS = eINSTANCE.getCheckInterfaceSpecifications();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.umlsmells.impl.CompareNamesImpl <em>Compare Names</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.umlsmells.impl.CompareNamesImpl
		 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getCompareNames()
		 * @generated
		 */
		EClass COMPARE_NAMES = eINSTANCE.getCompareNames();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.umlsmells.impl.CountParametersOfMethodsImpl <em>Count Parameters Of Methods</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.umlsmells.impl.CountParametersOfMethodsImpl
		 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getCountParametersOfMethods()
		 * @generated
		 */
		EClass COUNT_PARAMETERS_OF_METHODS = eINSTANCE.getCountParametersOfMethods();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.umlsmells.impl.SearchEmptyClassesAndInterfacesImpl <em>Search Empty Classes And Interfaces</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.umlsmells.impl.SearchEmptyClassesAndInterfacesImpl
		 * @see org.emftext.refactoring.smell.umlsmells.impl.UmlsmellsPackageImpl#getSearchEmptyClassesAndInterfaces()
		 * @generated
		 */
		EClass SEARCH_EMPTY_CLASSES_AND_INTERFACES = eINSTANCE.getSearchEmptyClassesAndInterfaces();

	}

} //UmlsmellsPackage
