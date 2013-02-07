/**
 */
package org.qualitune.tracing.umt.impl;

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

import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.NumerousKindsOfBranches;
import org.qualitune.tracing.umt.Selection;
import org.qualitune.tracing.umt.UmtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.SelectionImpl#getOppositeBranch <em>Opposite Branch</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.SelectionImpl#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionImpl extends EObjectImpl implements Selection {
	/**
	 * The cached value of the '{@link #getOppositeBranch() <em>Opposite Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeBranch()
	 * @generated
	 * @ordered
	 */
	protected NumerousKindsOfBranches oppositeBranch;

	/**
	 * The cached value of the '{@link #getBranches() <em>Branches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<Branch> branches;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumerousKindsOfBranches getOppositeBranch() {
		if (oppositeBranch != null && oppositeBranch.eIsProxy()) {
			InternalEObject oldOppositeBranch = (InternalEObject)oppositeBranch;
			oppositeBranch = (NumerousKindsOfBranches)eResolveProxy(oldOppositeBranch);
			if (oppositeBranch != oldOppositeBranch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmtPackage.SELECTION__OPPOSITE_BRANCH, oldOppositeBranch, oppositeBranch));
			}
		}
		return oppositeBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumerousKindsOfBranches basicGetOppositeBranch() {
		return oppositeBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeBranch(NumerousKindsOfBranches newOppositeBranch) {
		NumerousKindsOfBranches oldOppositeBranch = oppositeBranch;
		oppositeBranch = newOppositeBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.SELECTION__OPPOSITE_BRANCH, oldOppositeBranch, oppositeBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Branch> getBranches() {
		if (branches == null) {
			branches = new EObjectContainmentEList<Branch>(Branch.class, this, UmtPackage.SELECTION__BRANCHES);
		}
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmtPackage.SELECTION__BRANCHES:
				return ((InternalEList<?>)getBranches()).basicRemove(otherEnd, msgs);
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
			case UmtPackage.SELECTION__OPPOSITE_BRANCH:
				if (resolve) return getOppositeBranch();
				return basicGetOppositeBranch();
			case UmtPackage.SELECTION__BRANCHES:
				return getBranches();
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
			case UmtPackage.SELECTION__OPPOSITE_BRANCH:
				setOppositeBranch((NumerousKindsOfBranches)newValue);
				return;
			case UmtPackage.SELECTION__BRANCHES:
				getBranches().clear();
				getBranches().addAll((Collection<? extends Branch>)newValue);
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
			case UmtPackage.SELECTION__OPPOSITE_BRANCH:
				setOppositeBranch((NumerousKindsOfBranches)null);
				return;
			case UmtPackage.SELECTION__BRANCHES:
				getBranches().clear();
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
			case UmtPackage.SELECTION__OPPOSITE_BRANCH:
				return oppositeBranch != null;
			case UmtPackage.SELECTION__BRANCHES:
				return branches != null && !branches.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SelectionImpl
