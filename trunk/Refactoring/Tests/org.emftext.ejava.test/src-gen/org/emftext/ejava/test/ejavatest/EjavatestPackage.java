/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.ejava.test.ejavatest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.emftext.ejava.test.ejavatest.EjavatestFactory
 * @model kind="package"
 * @generated
 */
public interface EjavatestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ejavatest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/ejavatest";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ejavatest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EjavatestPackage eINSTANCE = org.emftext.ejava.test.ejavatest.impl.EjavatestPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.ejava.test.ejavatest.impl.ModifierUserImpl <em>Modifier User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.ejava.test.ejavatest.impl.ModifierUserImpl
	 * @see org.emftext.ejava.test.ejavatest.impl.EjavatestPackageImpl#getModifierUser()
	 * @generated
	 */
	int MODIFIER_USER = 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_USER__MODIFIER = 0;

	/**
	 * The number of structural features of the '<em>Modifier User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_USER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.ejava.test.ejavatest.ModifierEnum <em>Modifier Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.ejava.test.ejavatest.ModifierEnum
	 * @see org.emftext.ejava.test.ejavatest.impl.EjavatestPackageImpl#getModifierEnum()
	 * @generated
	 */
	int MODIFIER_ENUM = 1;


	/**
	 * Returns the meta object for class '{@link org.emftext.ejava.test.ejavatest.ModifierUser <em>Modifier User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifier User</em>'.
	 * @see org.emftext.ejava.test.ejavatest.ModifierUser
	 * @generated
	 */
	EClass getModifierUser();

	/**
	 * Returns the meta object for the attribute list '{@link org.emftext.ejava.test.ejavatest.ModifierUser#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifier</em>'.
	 * @see org.emftext.ejava.test.ejavatest.ModifierUser#getModifier()
	 * @see #getModifierUser()
	 * @generated
	 */
	EAttribute getModifierUser_Modifier();

	/**
	 * Returns the meta object for enum '{@link org.emftext.ejava.test.ejavatest.ModifierEnum <em>Modifier Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Modifier Enum</em>'.
	 * @see org.emftext.ejava.test.ejavatest.ModifierEnum
	 * @generated
	 */
	EEnum getModifierEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EjavatestFactory getEjavatestFactory();

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
		 * The meta object literal for the '{@link org.emftext.ejava.test.ejavatest.impl.ModifierUserImpl <em>Modifier User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.ejava.test.ejavatest.impl.ModifierUserImpl
		 * @see org.emftext.ejava.test.ejavatest.impl.EjavatestPackageImpl#getModifierUser()
		 * @generated
		 */
		EClass MODIFIER_USER = eINSTANCE.getModifierUser();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER_USER__MODIFIER = eINSTANCE.getModifierUser_Modifier();

		/**
		 * The meta object literal for the '{@link org.emftext.ejava.test.ejavatest.ModifierEnum <em>Modifier Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.ejava.test.ejavatest.ModifierEnum
		 * @see org.emftext.ejava.test.ejavatest.impl.EjavatestPackageImpl#getModifierEnum()
		 * @generated
		 */
		EEnum MODIFIER_ENUM = eINSTANCE.getModifierEnum();

	}

} //EjavatestPackage
