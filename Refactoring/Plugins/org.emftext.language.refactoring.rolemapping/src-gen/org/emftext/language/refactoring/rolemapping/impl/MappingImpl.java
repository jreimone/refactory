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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.MappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.MappingImpl#getMappedRoleModel <em>Mapped Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.MappingImpl#getRoleToMetaelement <em>Role To Metaelement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends EObjectImpl implements Mapping {
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
   * The cached value of the '{@link #getMappedRoleModel() <em>Mapped Role Model</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMappedRoleModel()
   * @generated
   * @ordered
   */
	protected RoleModel mappedRoleModel;

	/**
   * The cached value of the '{@link #getRoleToMetaelement() <em>Role To Metaelement</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRoleToMetaelement()
   * @generated
   * @ordered
   */
	protected EList<ConcreteMapping> roleToMetaelement;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MappingImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RolemappingPackage.Literals.MAPPING;
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
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.MAPPING__NAME, oldName, name));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleModel getMappedRoleModel() {
    if (mappedRoleModel != null && mappedRoleModel.eIsProxy())
    {
      InternalEObject oldMappedRoleModel = (InternalEObject)mappedRoleModel;
      mappedRoleModel = (RoleModel)eResolveProxy(oldMappedRoleModel);
      if (mappedRoleModel != oldMappedRoleModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.MAPPING__MAPPED_ROLE_MODEL, oldMappedRoleModel, mappedRoleModel));
      }
    }
    return mappedRoleModel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RoleModel basicGetMappedRoleModel() {
    return mappedRoleModel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setMappedRoleModel(RoleModel newMappedRoleModel) {
    RoleModel oldMappedRoleModel = mappedRoleModel;
    mappedRoleModel = newMappedRoleModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.MAPPING__MAPPED_ROLE_MODEL, oldMappedRoleModel, mappedRoleModel));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<ConcreteMapping> getRoleToMetaelement() {
    if (roleToMetaelement == null)
    {
      roleToMetaelement = new EObjectContainmentEList<ConcreteMapping>(ConcreteMapping.class, this, RolemappingPackage.MAPPING__ROLE_TO_METAELEMENT);
    }
    return roleToMetaelement;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated NOT
   */
	public EList<Role> getAllMappedRoles() {
		EList<Role> roles = new BasicEList<Role>();
		EList<ConcreteMapping> mappings = getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : mappings) {
			roles.add(concreteMapping.getRole());
		}
		return roles;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated NOT
   */
	public EList<Role> getMappedRolesForEObject(EObject object) {
		EList<Role> mappedRoles = new BasicEList<Role>();
		EClass metaclass = object.eClass();
		EList<ConcreteMapping> mappings = getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : mappings) {
			EClass mappedClass = concreteMapping.getMetaclass();
			if(mappedClass.equals(metaclass)){
				mappedRoles.add(concreteMapping.getRole());
			}
		}
		return mappedRoles;
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
      case RolemappingPackage.MAPPING__ROLE_TO_METAELEMENT:
        return ((InternalEList<?>)getRoleToMetaelement()).basicRemove(otherEnd, msgs);
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
      case RolemappingPackage.MAPPING__NAME:
        return getName();
      case RolemappingPackage.MAPPING__MAPPED_ROLE_MODEL:
        if (resolve) return getMappedRoleModel();
        return basicGetMappedRoleModel();
      case RolemappingPackage.MAPPING__ROLE_TO_METAELEMENT:
        return getRoleToMetaelement();
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
      case RolemappingPackage.MAPPING__NAME:
        setName((String)newValue);
        return;
      case RolemappingPackage.MAPPING__MAPPED_ROLE_MODEL:
        setMappedRoleModel((RoleModel)newValue);
        return;
      case RolemappingPackage.MAPPING__ROLE_TO_METAELEMENT:
        getRoleToMetaelement().clear();
        getRoleToMetaelement().addAll((Collection<? extends ConcreteMapping>)newValue);
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
      case RolemappingPackage.MAPPING__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RolemappingPackage.MAPPING__MAPPED_ROLE_MODEL:
        setMappedRoleModel((RoleModel)null);
        return;
      case RolemappingPackage.MAPPING__ROLE_TO_METAELEMENT:
        getRoleToMetaelement().clear();
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
      case RolemappingPackage.MAPPING__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RolemappingPackage.MAPPING__MAPPED_ROLE_MODEL:
        return mappedRoleModel != null;
      case RolemappingPackage.MAPPING__ROLE_TO_METAELEMENT:
        return roleToMetaelement != null && !roleToMetaelement.isEmpty();
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

} //MappingImpl
