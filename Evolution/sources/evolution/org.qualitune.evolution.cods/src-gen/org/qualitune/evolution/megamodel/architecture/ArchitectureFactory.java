/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage
 * @generated
 */
public interface ArchitectureFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	ArchitectureFactory eINSTANCE = org.qualitune.evolution.megamodel.architecture.impl.ArchitectureFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Terminal Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Terminal Model</em>'.
   * @generated
   */
	TerminalModel createTerminalModel();

	/**
   * Returns a new object of class '<em>Transformation Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Model</em>'.
   * @generated
   */
	TransformationModel createTransformationModel();

	/**
   * Returns a new object of class '<em>Meta Meta Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Meta Model</em>'.
   * @generated
   */
	MetaMetaModel createMetaMetaModel();

	/**
   * Returns a new object of class '<em>Meta Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Model</em>'.
   * @generated
   */
	MetaModel createMetaModel();

	/**
   * Returns a new object of class '<em>Instance Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Model</em>'.
   * @generated
   */
	InstanceModel createInstanceModel();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	ArchitecturePackage getArchitecturePackage();

} //ArchitectureFactory
