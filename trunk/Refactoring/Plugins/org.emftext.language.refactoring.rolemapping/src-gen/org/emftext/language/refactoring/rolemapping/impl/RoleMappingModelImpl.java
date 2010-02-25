/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl#getTargetMetamodel <em>Target Metamodel</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.RoleMappingModelImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleMappingModelImpl extends EObjectImpl implements RoleMappingModel {
	/**
   * The cached value of the '{@link #getTargetMetamodel() <em>Target Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTargetMetamodel()
   * @generated
   * @ordered
   */
	protected EPackage targetMetamodel;

	/**
   * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMappings()
   * @generated
   * @ordered
   */
	protected EList<Mapping> mappings;

	/**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected static final String NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected String name = NAME_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected RoleMappingModelImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RolemappingPackage.Literals.ROLE_MAPPING_MODEL;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EPackage getTargetMetamodel() {
    if (targetMetamodel != null && targetMetamodel.eIsProxy())
    {
      InternalEObject oldTargetMetamodel = (InternalEObject)targetMetamodel;
      targetMetamodel = (EPackage)eResolveProxy(oldTargetMetamodel);
      if (targetMetamodel != oldTargetMetamodel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL, oldTargetMetamodel, targetMetamodel));
      }
    }
    return targetMetamodel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EPackage basicGetTargetMetamodel() {
    return targetMetamodel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setTargetMetamodel(EPackage newTargetMetamodel) {
    EPackage oldTargetMetamodel = targetMetamodel;
    targetMetamodel = newTargetMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL, oldTargetMetamodel, targetMetamodel));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Mapping> getMappings() {
    if (mappings == null)
    {
      mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS);
    }
    return mappings;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ROLE_MAPPING_MODEL__NAME, oldName, name));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
        return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
        if (resolve) return getTargetMetamodel();
        return basicGetTargetMetamodel();
      case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
        return getMappings();
      case RolemappingPackage.ROLE_MAPPING_MODEL__NAME:
        return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
        setTargetMetamodel((EPackage)newValue);
        return;
      case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
        getMappings().clear();
        getMappings().addAll((Collection<? extends Mapping>)newValue);
        return;
      case RolemappingPackage.ROLE_MAPPING_MODEL__NAME:
        setName((String)newValue);
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
      case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
        setTargetMetamodel((EPackage)null);
        return;
      case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
        getMappings().clear();
        return;
      case RolemappingPackage.ROLE_MAPPING_MODEL__NAME:
        setName(NAME_EDEFAULT);
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
      case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
        return targetMetamodel != null;
      case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
        return mappings != null && !mappings.isEmpty();
      case RolemappingPackage.ROLE_MAPPING_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RoleMappingModelImpl
