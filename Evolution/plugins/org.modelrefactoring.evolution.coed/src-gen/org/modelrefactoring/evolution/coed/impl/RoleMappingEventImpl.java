/**
 */
package org.modelrefactoring.evolution.coed.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.MetamodelImport;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Mapping Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.RoleMappingEventImpl#getConcreteRefactoring <em>Concrete Refactoring</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.RoleMappingEventImpl#getMetamodelImport <em>Metamodel Import</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleMappingEventImpl extends EventImpl implements RoleMappingEvent {
	/**
   * The cached value of the '{@link #getConcreteRefactoring() <em>Concrete Refactoring</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getConcreteRefactoring()
   * @generated
   * @ordered
   */
	protected RoleMapping concreteRefactoring;

	/**
   * The cached value of the '{@link #getMetamodelImport() <em>Metamodel Import</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelImport()
   * @generated
   * @ordered
   */
  protected MetamodelImport metamodelImport;

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected RoleMappingEventImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return CoedPackage.Literals.ROLE_MAPPING_EVENT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleMapping getConcreteRefactoring() {
    if (concreteRefactoring != null && concreteRefactoring.eIsProxy())
    {
      InternalEObject oldConcreteRefactoring = (InternalEObject)concreteRefactoring;
      concreteRefactoring = (RoleMapping)eResolveProxy(oldConcreteRefactoring);
      if (concreteRefactoring != oldConcreteRefactoring)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING, oldConcreteRefactoring, concreteRefactoring));
      }
    }
    return concreteRefactoring;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleMapping basicGetConcreteRefactoring() {
    return concreteRefactoring;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setConcreteRefactoring(RoleMapping newConcreteRefactoring) {
    RoleMapping oldConcreteRefactoring = concreteRefactoring;
    concreteRefactoring = newConcreteRefactoring;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING, oldConcreteRefactoring, concreteRefactoring));
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelImport getMetamodelImport()
  {
    if (metamodelImport != null && metamodelImport.eIsProxy())
    {
      InternalEObject oldMetamodelImport = (InternalEObject)metamodelImport;
      metamodelImport = (MetamodelImport)eResolveProxy(oldMetamodelImport);
      if (metamodelImport != oldMetamodelImport)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT, oldMetamodelImport, metamodelImport));
      }
    }
    return metamodelImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelImport basicGetMetamodelImport()
  {
    return metamodelImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodelImport(MetamodelImport newMetamodelImport)
  {
    MetamodelImport oldMetamodelImport = metamodelImport;
    metamodelImport = newMetamodelImport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT, oldMetamodelImport, metamodelImport));
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING:
        if (resolve) return getConcreteRefactoring();
        return basicGetConcreteRefactoring();
      case CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT:
        if (resolve) return getMetamodelImport();
        return basicGetMetamodelImport();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING:
        setConcreteRefactoring((RoleMapping)newValue);
        return;
      case CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT:
        setMetamodelImport((MetamodelImport)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING:
        setConcreteRefactoring((RoleMapping)null);
        return;
      case CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT:
        setMetamodelImport((MetamodelImport)null);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING:
        return concreteRefactoring != null;
      case CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT:
        return metamodelImport != null;
    }
    return super.eIsSet(featureID);
  }

} //RoleMappingEventImpl
