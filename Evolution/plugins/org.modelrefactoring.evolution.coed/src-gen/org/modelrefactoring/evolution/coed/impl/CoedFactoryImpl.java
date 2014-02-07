/**
 */
package org.modelrefactoring.evolution.coed.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.modelrefactoring.evolution.coed.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoedFactoryImpl extends EFactoryImpl implements CoedFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static CoedFactory init() {
    try
    {
      CoedFactory theCoedFactory = (CoedFactory)EPackage.Registry.INSTANCE.getEFactory(CoedPackage.eNS_URI);
      if (theCoedFactory != null)
      {
        return theCoedFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CoedFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CoedFactoryImpl() {
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
      case CoedPackage.CO_EVOLUTION_DEFINITION: return createCoEvolutionDefinition();
      case CoedPackage.ROLE_MAPPING_EVENT: return createRoleMappingEvent();
      case CoedPackage.PLAIN_CONDITION: return createPlainCondition();
      case CoedPackage.ROLE_MAPPING_ACTION: return createRoleMappingAction();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
	public RoleMappingEvent createRoleMappingEvent() {
    RoleMappingEventImpl roleMappingEvent = new RoleMappingEventImpl();
    return roleMappingEvent;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PlainCondition createPlainCondition() {
    PlainConditionImpl plainCondition = new PlainConditionImpl();
    return plainCondition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleMappingAction createRoleMappingAction() {
    RoleMappingActionImpl roleMappingAction = new RoleMappingActionImpl();
    return roleMappingAction;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CoedPackage getCoedPackage() {
    return (CoedPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static CoedPackage getPackage() {
    return CoedPackage.eINSTANCE;
  }

} //CoedFactoryImpl
