/**
 */
package org.qualitune.tracing.umt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.qualitune.tracing.umt.Condition;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.Loop;
import org.qualitune.tracing.umt.NumerousKindsOfBranches;
import org.qualitune.tracing.umt.UmtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.LoopImpl#getOppositeBranch <em>Opposite Branch</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.LoopImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.LoopImpl#getInvariant <em>Invariant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends EObjectImpl implements Loop {
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
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected InstructionBlock body;

	/**
	 * The cached value of the '{@link #getInvariant() <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariant()
	 * @generated
	 * @ordered
	 */
	protected Condition invariant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.LOOP;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmtPackage.LOOP__OPPOSITE_BRANCH, oldOppositeBranch, oppositeBranch));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.LOOP__OPPOSITE_BRANCH, oldOppositeBranch, oppositeBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionBlock getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(InstructionBlock newBody, NotificationChain msgs) {
		InstructionBlock oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmtPackage.LOOP__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(InstructionBlock newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmtPackage.LOOP__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmtPackage.LOOP__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.LOOP__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getInvariant() {
		if (invariant != null && invariant.eIsProxy()) {
			InternalEObject oldInvariant = (InternalEObject)invariant;
			invariant = (Condition)eResolveProxy(oldInvariant);
			if (invariant != oldInvariant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmtPackage.LOOP__INVARIANT, oldInvariant, invariant));
			}
		}
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetInvariant() {
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvariant(Condition newInvariant) {
		Condition oldInvariant = invariant;
		invariant = newInvariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.LOOP__INVARIANT, oldInvariant, invariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmtPackage.LOOP__BODY:
				return basicSetBody(null, msgs);
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
			case UmtPackage.LOOP__OPPOSITE_BRANCH:
				if (resolve) return getOppositeBranch();
				return basicGetOppositeBranch();
			case UmtPackage.LOOP__BODY:
				return getBody();
			case UmtPackage.LOOP__INVARIANT:
				if (resolve) return getInvariant();
				return basicGetInvariant();
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
			case UmtPackage.LOOP__OPPOSITE_BRANCH:
				setOppositeBranch((NumerousKindsOfBranches)newValue);
				return;
			case UmtPackage.LOOP__BODY:
				setBody((InstructionBlock)newValue);
				return;
			case UmtPackage.LOOP__INVARIANT:
				setInvariant((Condition)newValue);
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
			case UmtPackage.LOOP__OPPOSITE_BRANCH:
				setOppositeBranch((NumerousKindsOfBranches)null);
				return;
			case UmtPackage.LOOP__BODY:
				setBody((InstructionBlock)null);
				return;
			case UmtPackage.LOOP__INVARIANT:
				setInvariant((Condition)null);
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
			case UmtPackage.LOOP__OPPOSITE_BRANCH:
				return oppositeBranch != null;
			case UmtPackage.LOOP__BODY:
				return body != null;
			case UmtPackage.LOOP__INVARIANT:
				return invariant != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl
