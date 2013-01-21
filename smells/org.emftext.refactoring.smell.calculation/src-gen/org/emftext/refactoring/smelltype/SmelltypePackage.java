/**
 */
package org.emftext.refactoring.smelltype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.emftext.refactoring.smelltype.SmelltypeFactory
 * @model kind="package"
 * @generated
 */
public interface SmelltypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "smelltype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelrefactoring.org/smell/type";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "smelltype";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmelltypePackage eINSTANCE = org.emftext.refactoring.smelltype.impl.SmelltypePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smelltype.impl.SmellTypeImpl <em>Smell Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smelltype.impl.SmellTypeImpl
	 * @see org.emftext.refactoring.smelltype.impl.SmelltypePackageImpl#getSmellType()
	 * @generated
	 */
	int SMELL_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE__LOWER_BOUND = 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE__UPPER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE__INCREMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Smell Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smelltype.impl.SmellTypeModelImpl <em>Smell Type Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smelltype.impl.SmellTypeModelImpl
	 * @see org.emftext.refactoring.smelltype.impl.SmelltypePackageImpl#getSmellTypeModel()
	 * @generated
	 */
	int SMELL_TYPE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE_MODEL__TYPES = 0;

	/**
	 * The number of structural features of the '<em>Smell Type Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMELL_TYPE_MODEL_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smelltype.SmellType <em>Smell Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smell Type</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellType
	 * @generated
	 */
	EClass getSmellType();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smelltype.SmellType#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellType#getLowerBound()
	 * @see #getSmellType()
	 * @generated
	 */
	EAttribute getSmellType_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smelltype.SmellType#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellType#getUpperBound()
	 * @see #getSmellType()
	 * @generated
	 */
	EAttribute getSmellType_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smelltype.SmellType#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increment</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellType#getIncrement()
	 * @see #getSmellType()
	 * @generated
	 */
	EAttribute getSmellType_Increment();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smelltype.SmellType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellType#getName()
	 * @see #getSmellType()
	 * @generated
	 */
	EAttribute getSmellType_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smelltype.SmellTypeModel <em>Smell Type Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smell Type Model</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellTypeModel
	 * @generated
	 */
	EClass getSmellTypeModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smelltype.SmellTypeModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.emftext.refactoring.smelltype.SmellTypeModel#getTypes()
	 * @see #getSmellTypeModel()
	 * @generated
	 */
	EReference getSmellTypeModel_Types();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SmelltypeFactory getSmelltypeFactory();

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
		 * The meta object literal for the '{@link org.emftext.refactoring.smelltype.impl.SmellTypeImpl <em>Smell Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smelltype.impl.SmellTypeImpl
		 * @see org.emftext.refactoring.smelltype.impl.SmelltypePackageImpl#getSmellType()
		 * @generated
		 */
		EClass SMELL_TYPE = eINSTANCE.getSmellType();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMELL_TYPE__LOWER_BOUND = eINSTANCE.getSmellType_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMELL_TYPE__UPPER_BOUND = eINSTANCE.getSmellType_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMELL_TYPE__INCREMENT = eINSTANCE.getSmellType_Increment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMELL_TYPE__NAME = eINSTANCE.getSmellType_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smelltype.impl.SmellTypeModelImpl <em>Smell Type Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smelltype.impl.SmellTypeModelImpl
		 * @see org.emftext.refactoring.smelltype.impl.SmelltypePackageImpl#getSmellTypeModel()
		 * @generated
		 */
		EClass SMELL_TYPE_MODEL = eINSTANCE.getSmellTypeModel();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMELL_TYPE_MODEL__TYPES = eINSTANCE.getSmellTypeModel_Types();

	}

} //SmelltypePackage
