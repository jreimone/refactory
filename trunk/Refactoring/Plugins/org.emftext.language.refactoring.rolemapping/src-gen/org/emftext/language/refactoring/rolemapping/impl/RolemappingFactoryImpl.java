/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.refactoring.rolemapping.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RolemappingFactoryImpl extends EFactoryImpl implements RolemappingFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static RolemappingFactory init() {
    try
    {
      RolemappingFactory theRolemappingFactory = (RolemappingFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/rolemapping"); 
      if (theRolemappingFactory != null)
      {
        return theRolemappingFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RolemappingFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RolemappingFactoryImpl() {
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
      case RolemappingPackage.ROLE_MAPPING_MODEL: return createRoleMappingModel();
      case RolemappingPackage.MAPPING: return createMapping();
      case RolemappingPackage.CONCRETE_MAPPING: return createConcreteMapping();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleMappingModel createRoleMappingModel() {
    RoleMappingModelImpl roleMappingModel = new RoleMappingModelImpl();
    return roleMappingModel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Mapping createMapping() {
    MappingImpl mapping = new MappingImpl();
    return mapping;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConcreteMapping createConcreteMapping() {
    ConcreteMappingImpl concreteMapping = new ConcreteMappingImpl();
    return concreteMapping;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RolemappingPackage getRolemappingPackage() {
    return (RolemappingPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static RolemappingPackage getPackage() {
    return RolemappingPackage.eINSTANCE;
  }

} //RolemappingFactoryImpl
