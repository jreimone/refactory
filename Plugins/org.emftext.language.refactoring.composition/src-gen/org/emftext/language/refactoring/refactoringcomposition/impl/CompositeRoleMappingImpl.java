/**
 */
package org.emftext.language.refactoring.refactoringcomposition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Role Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl#getTargetMetamodel <em>Target Metamodel</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeRoleMappingImpl extends MinimalEObjectImpl.Container implements CompositeRoleMapping {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

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
	 * The cached value of the '{@link #getTargetMetamodel() <em>Target Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EPackage targetMetamodel;

	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected RoleMapping first;

	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundRoleMapping> sequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeRoleMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringcompositionPackage.Literals.COMPOSITE_ROLE_MAPPING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getTargetMetamodel() {
		if (targetMetamodel != null && targetMetamodel.eIsProxy()) {
			InternalEObject oldTargetMetamodel = (InternalEObject)targetMetamodel;
			targetMetamodel = (EPackage)eResolveProxy(oldTargetMetamodel);
			if (targetMetamodel != oldTargetMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL, oldTargetMetamodel, targetMetamodel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL, oldTargetMetamodel, targetMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping getFirst() {
		if (first != null && first.eIsProxy()) {
			InternalEObject oldFirst = (InternalEObject)first;
			first = (RoleMapping)eResolveProxy(oldFirst);
			if (first != oldFirst) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST, oldFirst, first));
			}
		}
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleMapping basicGetFirst() {
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirst(RoleMapping newFirst) {
		RoleMapping oldFirst = first;
		first = newFirst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST, oldFirst, first));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundRoleMapping> getSequence() {
		if (sequence == null) {
			sequence = new EObjectContainmentEList<BoundRoleMapping>(BoundRoleMapping.class, this, RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE);
		}
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE:
				return ((InternalEList<?>)getSequence()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME:
				return getName();
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL:
				if (resolve) return getTargetMetamodel();
				return basicGetTargetMetamodel();
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST:
				if (resolve) return getFirst();
				return basicGetFirst();
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE:
				return getSequence();
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
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME:
				setName((String)newValue);
				return;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL:
				setTargetMetamodel((EPackage)newValue);
				return;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST:
				setFirst((RoleMapping)newValue);
				return;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE:
				getSequence().clear();
				getSequence().addAll((Collection<? extends BoundRoleMapping>)newValue);
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
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL:
				setTargetMetamodel((EPackage)null);
				return;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST:
				setFirst((RoleMapping)null);
				return;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE:
				getSequence().clear();
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
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL:
				return targetMetamodel != null;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST:
				return first != null;
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE:
				return sequence != null && !sequence.isEmpty();
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

} //CompositeRoleMappingImpl
