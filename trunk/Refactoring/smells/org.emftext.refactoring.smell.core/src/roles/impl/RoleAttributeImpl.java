/**
 */
package roles.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import roles.Role;
import roles.RoleAttribute;
import roles.RoleModifier;
import roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link roles.impl.RoleAttributeImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link roles.impl.RoleAttributeImpl#getAttributeRole <em>Attribute Role</em>}</li>
 *   <li>{@link roles.impl.RoleAttributeImpl#getInterpretationContext <em>Interpretation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleAttributeImpl extends NamedElementImpl implements RoleAttribute {
	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleModifier> modifier;

	/**
	 * The cached value of the '{@link #getInterpretationContext() <em>Interpretation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretationContext()
	 * @generated
	 * @ordered
	 */
	protected EObject interpretationContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.ROLE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoleModifier> getModifier() {
		if (modifier == null) {
			modifier = new EDataTypeEList<RoleModifier>(RoleModifier.class, this, RolesPackage.ROLE_ATTRIBUTE__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getAttributeRole() {
		if (eContainerFeatureID() != RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE) return null;
		return (Role)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeRole(Role newAttributeRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAttributeRole, RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeRole(Role newAttributeRole) {
		if (newAttributeRole != eInternalContainer() || (eContainerFeatureID() != RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE && newAttributeRole != null)) {
			if (EcoreUtil.isAncestor(this, newAttributeRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAttributeRole != null)
				msgs = ((InternalEObject)newAttributeRole).eInverseAdd(this, RolesPackage.ROLE__ATTRIBUTES, Role.class, msgs);
			msgs = basicSetAttributeRole(newAttributeRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE, newAttributeRole, newAttributeRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getInterpretationContext() {
		if (interpretationContext != null && interpretationContext.eIsProxy()) {
			InternalEObject oldInterpretationContext = (InternalEObject)interpretationContext;
			interpretationContext = eResolveProxy(oldInterpretationContext);
			if (interpretationContext != oldInterpretationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolesPackage.ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT, oldInterpretationContext, interpretationContext));
			}
		}
		return interpretationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetInterpretationContext() {
		return interpretationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpretationContext(EObject newInterpretationContext) {
		EObject oldInterpretationContext = interpretationContext;
		interpretationContext = newInterpretationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT, oldInterpretationContext, interpretationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAttributeRole((Role)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				return basicSetAttributeRole(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				return eInternalContainer().eInverseRemove(this, RolesPackage.ROLE__ATTRIBUTES, Role.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RolesPackage.ROLE_ATTRIBUTE__MODIFIER:
				return getModifier();
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				return getAttributeRole();
			case RolesPackage.ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT:
				if (resolve) return getInterpretationContext();
				return basicGetInterpretationContext();
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
		switch (featureID) {
			case RolesPackage.ROLE_ATTRIBUTE__MODIFIER:
				getModifier().clear();
				getModifier().addAll((Collection<? extends RoleModifier>)newValue);
				return;
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				setAttributeRole((Role)newValue);
				return;
			case RolesPackage.ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT:
				setInterpretationContext((EObject)newValue);
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
		switch (featureID) {
			case RolesPackage.ROLE_ATTRIBUTE__MODIFIER:
				getModifier().clear();
				return;
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				setAttributeRole((Role)null);
				return;
			case RolesPackage.ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT:
				setInterpretationContext((EObject)null);
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
		switch (featureID) {
			case RolesPackage.ROLE_ATTRIBUTE__MODIFIER:
				return modifier != null && !modifier.isEmpty();
			case RolesPackage.ROLE_ATTRIBUTE__ATTRIBUTE_ROLE:
				return getAttributeRole() != null;
			case RolesPackage.ROLE_ATTRIBUTE__INTERPRETATION_CONTEXT:
				return interpretationContext != null;
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
		result.append(" (modifier: ");
		result.append(modifier);
		result.append(')');
		return result.toString();
	}

} //RoleAttributeImpl
