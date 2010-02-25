/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

import org.emftext.language.refactoring.roles.RoleAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.AttributeMappingImpl#getRoleAttribute <em>Role Attribute</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.AttributeMappingImpl#getClassAttribute <em>Class Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeMappingImpl extends EObjectImpl implements AttributeMapping {
	/**
   * The cached value of the '{@link #getRoleAttribute() <em>Role Attribute</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRoleAttribute()
   * @generated
   * @ordered
   */
	protected RoleAttribute roleAttribute;

	/**
   * The cached value of the '{@link #getClassAttribute() <em>Class Attribute</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getClassAttribute()
   * @generated
   * @ordered
   */
	protected EAttribute classAttribute;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AttributeMappingImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RolemappingPackage.Literals.ATTRIBUTE_MAPPING;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleAttribute getRoleAttribute() {
    if (roleAttribute != null && roleAttribute.eIsProxy())
    {
      InternalEObject oldRoleAttribute = (InternalEObject)roleAttribute;
      roleAttribute = (RoleAttribute)eResolveProxy(oldRoleAttribute);
      if (roleAttribute != oldRoleAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE, oldRoleAttribute, roleAttribute));
      }
    }
    return roleAttribute;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleAttribute basicGetRoleAttribute() {
    return roleAttribute;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setRoleAttribute(RoleAttribute newRoleAttribute) {
    RoleAttribute oldRoleAttribute = roleAttribute;
    roleAttribute = newRoleAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE, oldRoleAttribute, roleAttribute));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getClassAttribute() {
    if (classAttribute != null && classAttribute.eIsProxy())
    {
      InternalEObject oldClassAttribute = (InternalEObject)classAttribute;
      classAttribute = (EAttribute)eResolveProxy(oldClassAttribute);
      if (classAttribute != oldClassAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE, oldClassAttribute, classAttribute));
      }
    }
    return classAttribute;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute basicGetClassAttribute() {
    return classAttribute;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setClassAttribute(EAttribute newClassAttribute) {
    EAttribute oldClassAttribute = classAttribute;
    classAttribute = newClassAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE, oldClassAttribute, classAttribute));
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
      case RolemappingPackage.ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE:
        if (resolve) return getRoleAttribute();
        return basicGetRoleAttribute();
      case RolemappingPackage.ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE:
        if (resolve) return getClassAttribute();
        return basicGetClassAttribute();
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
      case RolemappingPackage.ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE:
        setRoleAttribute((RoleAttribute)newValue);
        return;
      case RolemappingPackage.ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE:
        setClassAttribute((EAttribute)newValue);
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
      case RolemappingPackage.ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE:
        setRoleAttribute((RoleAttribute)null);
        return;
      case RolemappingPackage.ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE:
        setClassAttribute((EAttribute)null);
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
      case RolemappingPackage.ATTRIBUTE_MAPPING__ROLE_ATTRIBUTE:
        return roleAttribute != null;
      case RolemappingPackage.ATTRIBUTE_MAPPING__CLASS_ATTRIBUTE:
        return classAttribute != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributeMappingImpl
