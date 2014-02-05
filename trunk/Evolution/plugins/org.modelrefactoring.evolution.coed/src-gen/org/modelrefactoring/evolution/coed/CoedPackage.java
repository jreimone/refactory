/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.modelrefactoring.evolution.coed.CoedFactory
 * @model kind="package"
 * @generated
 */
public interface CoedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "coed";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.modelrefactoring.org/evolution/coed";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "coed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoedPackage eINSTANCE = org.modelrefactoring.evolution.coed.impl.CoedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl <em>Co Evolution Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl
	 * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getCoEvolutionDefinition()
	 * @generated
	 */
	int CO_EVOLUTION_DEFINITION = 0;

	/**
	 * The number of structural features of the '<em>Co Evolution Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_EVOLUTION_DEFINITION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Co Evolution Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CO_EVOLUTION_DEFINITION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition <em>Co Evolution Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Co Evolution Definition</em>'.
	 * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition
	 * @generated
	 */
	EClass getCoEvolutionDefinition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoedFactory getCoedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl <em>Co Evolution Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl
		 * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getCoEvolutionDefinition()
		 * @generated
		 */
		EClass CO_EVOLUTION_DEFINITION = eINSTANCE.getCoEvolutionDefinition();

	}

} //CoedPackage
