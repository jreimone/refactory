/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.ejava.test.ejavatest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.ejava.test.ejavatest.EjavatestPackage
 * @generated
 */
public interface EjavatestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EjavatestFactory eINSTANCE = org.emftext.ejava.test.ejavatest.impl.EjavatestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modifier User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modifier User</em>'.
	 * @generated
	 */
	ModifierUser createModifierUser();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EjavatestPackage getEjavatestPackage();

} //EjavatestFactory
