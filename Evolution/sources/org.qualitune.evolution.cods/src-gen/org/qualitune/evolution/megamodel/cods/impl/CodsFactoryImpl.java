/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.qualitune.evolution.megamodel.cods.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodsFactoryImpl extends EFactoryImpl implements CodsFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static CodsFactory init() {
    try
    {
      CodsFactory theCodsFactory = (CodsFactory)EPackage.Registry.INSTANCE.getEFactory(CodsPackage.eNS_URI);
      if (theCodsFactory != null)
      {
        return theCodsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CodsFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CodsFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case CodsPackage.CODS: return createCODS();
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION: return createDomainSpecificEvolutionSpecification();
      case CodsPackage.EVOLUTION_DEFINITION: return createEvolutionDefinition();
      case CodsPackage.CO_EVOLUTION_DEFINITION: return createCoEvolutionDefinition();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CODS createCODS() {
    CODSImpl cods = new CODSImpl();
    return cods;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DomainSpecificEvolutionSpecification createDomainSpecificEvolutionSpecification() {
    DomainSpecificEvolutionSpecificationImpl domainSpecificEvolutionSpecification = new DomainSpecificEvolutionSpecificationImpl();
    return domainSpecificEvolutionSpecification;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EvolutionDefinition createEvolutionDefinition() {
    EvolutionDefinitionImpl evolutionDefinition = new EvolutionDefinitionImpl();
    return evolutionDefinition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CoEvolutionDefinition createCoEvolutionDefinition() {
    CoEvolutionDefinitionImpl coEvolutionDefinition = new CoEvolutionDefinitionImpl();
    return coEvolutionDefinition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CodsPackage getCodsPackage() {
    return (CodsPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static CodsPackage getPackage() {
    return CodsPackage.eINSTANCE;
  }

} //CodsFactoryImpl
