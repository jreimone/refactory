/**
 */
package org.emftext.refactoring.smelltype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smelltype.SmelltypePackage
 * @generated
 */
public interface SmelltypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmelltypeFactory eINSTANCE = org.emftext.refactoring.smelltype.impl.SmelltypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Smell Type Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smell Type Model</em>'.
	 * @generated
	 */
	SmellTypeModel createSmellTypeModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SmelltypePackage getSmelltypePackage();

} //SmelltypeFactory
