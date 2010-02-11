/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.refactoring.roles.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RolesFactoryImpl extends EFactoryImpl implements RolesFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static RolesFactory init() {
    try
    {
      RolesFactory theRolesFactory = (RolesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/roles"); 
      if (theRolesFactory != null)
      {
        return theRolesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RolesFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RolesFactoryImpl() {
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
      case RolesPackage.ROLE: return createRole();
      case RolesPackage.ROLE_MODEL: return createRoleModel();
      case RolesPackage.MULTIPLICITY: return createMultiplicity();
      case RolesPackage.ROLE_USE: return createRoleUse();
      case RolesPackage.ROLE_PROHIBITION: return createRoleProhibition();
      case RolesPackage.ROLE_ASSOCIATION: return createRoleAssociation();
      case RolesPackage.ROLE_COMPOSITION: return createRoleComposition();
      case RolesPackage.ROLE_IMPLICATION: return createRoleImplication();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleModel createRoleModel() {
    RoleModelImpl roleModel = new RoleModelImpl();
    return roleModel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Role createRole() {
    RoleImpl role = new RoleImpl();
    return role;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleImplication createRoleImplication() {
    RoleImplicationImpl roleImplication = new RoleImplicationImpl();
    return roleImplication;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleProhibition createRoleProhibition() {
    RoleProhibitionImpl roleProhibition = new RoleProhibitionImpl();
    return roleProhibition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Multiplicity createMultiplicity() {
    MultiplicityImpl multiplicity = new MultiplicityImpl();
    return multiplicity;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleAssociation createRoleAssociation() {
    RoleAssociationImpl roleAssociation = new RoleAssociationImpl();
    return roleAssociation;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleComposition createRoleComposition() {
    RoleCompositionImpl roleComposition = new RoleCompositionImpl();
    return roleComposition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleUse createRoleUse() {
    RoleUseImpl roleUse = new RoleUseImpl();
    return roleUse;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RolesPackage getRolesPackage() {
    return (RolesPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static RolesPackage getPackage() {
    return RolesPackage.eINSTANCE;
  }

} //RolesFactoryImpl
