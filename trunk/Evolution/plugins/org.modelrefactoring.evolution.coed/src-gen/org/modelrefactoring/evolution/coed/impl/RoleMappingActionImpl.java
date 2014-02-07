/**
 */
package org.modelrefactoring.evolution.coed.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.RoleMappingAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Mapping Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.RoleMappingActionImpl#getConcreteRefactoring <em>Concrete Refactoring</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.RoleMappingActionImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleMappingActionImpl extends ActionImpl implements RoleMappingAction {
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
	 * The default value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected static final String BINDING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected String binding = BINDING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleMappingActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CoedPackage.Literals.ROLE_MAPPING_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping getConcreteRefactoring() {
		if (concreteRefactoring != null && concreteRefactoring.eIsProxy()) {
			InternalEObject oldConcreteRefactoring = (InternalEObject)concreteRefactoring;
			concreteRefactoring = (RoleMapping)eResolveProxy(oldConcreteRefactoring);
			if (concreteRefactoring != oldConcreteRefactoring) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING, oldConcreteRefactoring, concreteRefactoring));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING, oldConcreteRefactoring, concreteRefactoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(String newBinding) {
		String oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.ROLE_MAPPING_ACTION__BINDING, oldBinding, binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING:
				if (resolve) return getConcreteRefactoring();
				return basicGetConcreteRefactoring();
			case CoedPackage.ROLE_MAPPING_ACTION__BINDING:
				return getBinding();
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
		switch (featureID) {
			case CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING:
				setConcreteRefactoring((RoleMapping)newValue);
				return;
			case CoedPackage.ROLE_MAPPING_ACTION__BINDING:
				setBinding((String)newValue);
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
			case CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING:
				setConcreteRefactoring((RoleMapping)null);
				return;
			case CoedPackage.ROLE_MAPPING_ACTION__BINDING:
				setBinding(BINDING_EDEFAULT);
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
			case CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING:
				return concreteRefactoring != null;
			case CoedPackage.ROLE_MAPPING_ACTION__BINDING:
				return BINDING_EDEFAULT == null ? binding != null : !BINDING_EDEFAULT.equals(binding);
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
		result.append(" (binding: ");
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} //RoleMappingActionImpl
