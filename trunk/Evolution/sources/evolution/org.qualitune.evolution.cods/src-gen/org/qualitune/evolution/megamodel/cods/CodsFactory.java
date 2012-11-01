/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.megamodel.cods.CodsPackage
 * @generated
 */
public interface CodsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodsFactory eINSTANCE = org.qualitune.evolution.megamodel.cods.impl.CodsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CODS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CODS</em>'.
	 * @generated
	 */
	CODS createCODS();

	/**
	 * Returns a new object of class '<em>Domain Specific Evolution Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Specific Evolution Specification</em>'.
	 * @generated
	 */
	DomainSpecificEvolutionSpecification createDomainSpecificEvolutionSpecification();

	/**
	 * Returns a new object of class '<em>Evolution Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evolution Definition</em>'.
	 * @generated
	 */
	EvolutionDefinition createEvolutionDefinition();

	/**
	 * Returns a new object of class '<em>Co Evolution Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Co Evolution Definition</em>'.
	 * @generated
	 */
	CoEvolutionDefinition createCoEvolutionDefinition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CodsPackage getCodsPackage();

} //CodsFactory
