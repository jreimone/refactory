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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl#getMetaclass <em>Metaclass</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl#getOutgoingRelationMappings <em>Outgoing Relation Mappings</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.ConcreteMappingImpl#getAttributeMappings <em>Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteMappingImpl extends EObjectImpl implements ConcreteMapping {
	/**
   * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
	protected Role role;

	/**
   * The cached value of the '{@link #getMetaclass() <em>Metaclass</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMetaclass()
   * @generated
   * @ordered
   */
	protected EClass metaclass;

	/**
   * The cached value of the '{@link #getOutgoingRelationMappings() <em>Outgoing Relation Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOutgoingRelationMappings()
   * @generated
   * @ordered
   */
	protected EList<RelationMapping> outgoingRelationMappings;

	/**
   * The cached value of the '{@link #getAttributeMappings() <em>Attribute Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAttributeMappings()
   * @generated
   * @ordered
   */
	protected EList<AttributeMapping> attributeMappings;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ConcreteMappingImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RolemappingPackage.Literals.CONCRETE_MAPPING;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Role getRole() {
    if (role != null && role.eIsProxy())
    {
      InternalEObject oldRole = (InternalEObject)role;
      role = (Role)eResolveProxy(oldRole);
      if (role != oldRole)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.CONCRETE_MAPPING__ROLE, oldRole, role));
      }
    }
    return role;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Role basicGetRole() {
    return role;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setRole(Role newRole) {
    Role oldRole = role;
    role = newRole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.CONCRETE_MAPPING__ROLE, oldRole, role));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getMetaclass() {
    if (metaclass != null && metaclass.eIsProxy())
    {
      InternalEObject oldMetaclass = (InternalEObject)metaclass;
      metaclass = (EClass)eResolveProxy(oldMetaclass);
      if (metaclass != oldMetaclass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.CONCRETE_MAPPING__METACLASS, oldMetaclass, metaclass));
      }
    }
    return metaclass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass basicGetMetaclass() {
    return metaclass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setMetaclass(EClass newMetaclass) {
    EClass oldMetaclass = metaclass;
    metaclass = newMetaclass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.CONCRETE_MAPPING__METACLASS, oldMetaclass, metaclass));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<RelationMapping> getOutgoingRelationMappings() {
    if (outgoingRelationMappings == null)
    {
      outgoingRelationMappings = new EObjectContainmentEList<RelationMapping>(RelationMapping.class, this, RolemappingPackage.CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS);
    }
    return outgoingRelationMappings;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<AttributeMapping> getAttributeMappings() {
    if (attributeMappings == null)
    {
      attributeMappings = new EObjectContainmentEList<AttributeMapping>(AttributeMapping.class, this, RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS);
    }
    return attributeMappings;
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
      case RolemappingPackage.CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS:
        return ((InternalEList<?>)getOutgoingRelationMappings()).basicRemove(otherEnd, msgs);
      case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
        return ((InternalEList<?>)getAttributeMappings()).basicRemove(otherEnd, msgs);
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
      case RolemappingPackage.CONCRETE_MAPPING__ROLE:
        if (resolve) return getRole();
        return basicGetRole();
      case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
        if (resolve) return getMetaclass();
        return basicGetMetaclass();
      case RolemappingPackage.CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS:
        return getOutgoingRelationMappings();
      case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
        return getAttributeMappings();
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
      case RolemappingPackage.CONCRETE_MAPPING__ROLE:
        setRole((Role)newValue);
        return;
      case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
        setMetaclass((EClass)newValue);
        return;
      case RolemappingPackage.CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS:
        getOutgoingRelationMappings().clear();
        getOutgoingRelationMappings().addAll((Collection<? extends RelationMapping>)newValue);
        return;
      case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
        getAttributeMappings().clear();
        getAttributeMappings().addAll((Collection<? extends AttributeMapping>)newValue);
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
      case RolemappingPackage.CONCRETE_MAPPING__ROLE:
        setRole((Role)null);
        return;
      case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
        setMetaclass((EClass)null);
        return;
      case RolemappingPackage.CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS:
        getOutgoingRelationMappings().clear();
        return;
      case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
        getAttributeMappings().clear();
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
      case RolemappingPackage.CONCRETE_MAPPING__ROLE:
        return role != null;
      case RolemappingPackage.CONCRETE_MAPPING__METACLASS:
        return metaclass != null;
      case RolemappingPackage.CONCRETE_MAPPING__OUTGOING_RELATION_MAPPINGS:
        return outgoingRelationMappings != null && !outgoingRelationMappings.isEmpty();
      case RolemappingPackage.CONCRETE_MAPPING__ATTRIBUTE_MAPPINGS:
        return attributeMappings != null && !attributeMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConcreteMappingImpl
