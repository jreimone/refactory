/**
 */
package org.emftext.language.refactoring.refactoringcomposition.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Role Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl#getNextMapping <em>Next Mapping</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl#getPreviousMapping <em>Previous Mapping</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl#getRoleMapping <em>Role Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundRoleMappingImpl extends MinimalEObjectImpl.Container implements BoundRoleMapping {
	/**
	 * The cached value of the '{@link #getNextMapping() <em>Next Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextMapping()
	 * @generated
	 * @ordered
	 */
	protected BoundRoleMapping nextMapping;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceTargetBinding> bindings;

	/**
	 * The cached value of the '{@link #getRoleMapping() <em>Role Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleMapping()
	 * @generated
	 * @ordered
	 */
	protected RoleMapping roleMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundRoleMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringcompositionPackage.Literals.BOUND_ROLE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundRoleMapping getNextMapping() {
		return nextMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextMapping(BoundRoleMapping newNextMapping, NotificationChain msgs) {
		BoundRoleMapping oldNextMapping = nextMapping;
		nextMapping = newNextMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING, oldNextMapping, newNextMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextMapping(BoundRoleMapping newNextMapping) {
		if (newNextMapping != nextMapping) {
			NotificationChain msgs = null;
			if (nextMapping != null)
				msgs = ((InternalEObject)nextMapping).eInverseRemove(this, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING, BoundRoleMapping.class, msgs);
			if (newNextMapping != null)
				msgs = ((InternalEObject)newNextMapping).eInverseAdd(this, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING, BoundRoleMapping.class, msgs);
			msgs = basicSetNextMapping(newNextMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING, newNextMapping, newNextMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundRoleMapping getPreviousMapping() {
		if (eContainerFeatureID() != RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING) return null;
		return (BoundRoleMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreviousMapping(BoundRoleMapping newPreviousMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPreviousMapping, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousMapping(BoundRoleMapping newPreviousMapping) {
		if (newPreviousMapping != eInternalContainer() || (eContainerFeatureID() != RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING && newPreviousMapping != null)) {
			if (EcoreUtil.isAncestor(this, newPreviousMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPreviousMapping != null)
				msgs = ((InternalEObject)newPreviousMapping).eInverseAdd(this, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING, BoundRoleMapping.class, msgs);
			msgs = basicSetPreviousMapping(newPreviousMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING, newPreviousMapping, newPreviousMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceTargetBinding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<SourceTargetBinding>(SourceTargetBinding.class, this, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping getRoleMapping() {
		if (roleMapping != null && roleMapping.eIsProxy()) {
			InternalEObject oldRoleMapping = (InternalEObject)roleMapping;
			roleMapping = (RoleMapping)eResolveProxy(oldRoleMapping);
			if (roleMapping != oldRoleMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING, oldRoleMapping, roleMapping));
			}
		}
		return roleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping basicGetRoleMapping() {
		return roleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleMapping(RoleMapping newRoleMapping) {
		RoleMapping oldRoleMapping = roleMapping;
		roleMapping = newRoleMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING, oldRoleMapping, roleMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING:
				if (nextMapping != null)
					msgs = ((InternalEObject)nextMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING, null, msgs);
				return basicSetNextMapping((BoundRoleMapping)otherEnd, msgs);
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPreviousMapping((BoundRoleMapping)otherEnd, msgs);
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
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING:
				return basicSetNextMapping(null, msgs);
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				return basicSetPreviousMapping(null, msgs);
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				return eInternalContainer().eInverseRemove(this, RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING, BoundRoleMapping.class, msgs);
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
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING:
				return getNextMapping();
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				return getPreviousMapping();
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS:
				return getBindings();
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING:
				if (resolve) return getRoleMapping();
				return basicGetRoleMapping();
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
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING:
				setNextMapping((BoundRoleMapping)newValue);
				return;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				setPreviousMapping((BoundRoleMapping)newValue);
				return;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends SourceTargetBinding>)newValue);
				return;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING:
				setRoleMapping((RoleMapping)newValue);
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
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING:
				setNextMapping((BoundRoleMapping)null);
				return;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				setPreviousMapping((BoundRoleMapping)null);
				return;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS:
				getBindings().clear();
				return;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING:
				setRoleMapping((RoleMapping)null);
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
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING:
				return nextMapping != null;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING:
				return getPreviousMapping() != null;
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING:
				return roleMapping != null;
		}
		return super.eIsSet(featureID);
	}

} //BoundRoleMappingImpl
