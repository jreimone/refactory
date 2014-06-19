/**
 */
package org.emftext.refactoring.smell.rolessmell;

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
 * @see org.emftext.refactoring.smell.rolessmell.RolessmellFactory
 * @model kind="package"
 * @generated
 */
public interface RolessmellPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rolessmell";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelrefactoring.org/smell/calculation/roles";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rolessmell";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RolessmellPackage eINSTANCE = org.emftext.refactoring.smell.rolessmell.impl.RolessmellPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.rolessmell.impl.DistinctRoleNamesImpl <em>Distinct Role Names</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.rolessmell.impl.DistinctRoleNamesImpl
	 * @see org.emftext.refactoring.smell.rolessmell.impl.RolessmellPackageImpl#getDistinctRoleNames()
	 * @generated
	 */
	int DISTINCT_ROLE_NAMES = 0;

	/**
	 * The feature id for the '<em><b>Monotonicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_ROLE_NAMES__MONOTONICITY = CalculationPackage.METRIC__MONOTONICITY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_ROLE_NAMES__DESCRIPTION = CalculationPackage.METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_ROLE_NAMES__NAME = CalculationPackage.METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Smell Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_ROLE_NAMES__SMELL_MESSAGE = CalculationPackage.METRIC__SMELL_MESSAGE;

	/**
	 * The number of structural features of the '<em>Distinct Role Names</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_ROLE_NAMES_FEATURE_COUNT = CalculationPackage.METRIC_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.rolessmell.DistinctRoleNames <em>Distinct Role Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distinct Role Names</em>'.
	 * @see org.emftext.refactoring.smell.rolessmell.DistinctRoleNames
	 * @generated
	 */
	EClass getDistinctRoleNames();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RolessmellFactory getRolessmellFactory();

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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.rolessmell.impl.DistinctRoleNamesImpl <em>Distinct Role Names</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.rolessmell.impl.DistinctRoleNamesImpl
		 * @see org.emftext.refactoring.smell.rolessmell.impl.RolessmellPackageImpl#getDistinctRoleNames()
		 * @generated
		 */
		EClass DISTINCT_ROLE_NAMES = eINSTANCE.getDistinctRoleNames();

	}

} //RolessmellPackage
