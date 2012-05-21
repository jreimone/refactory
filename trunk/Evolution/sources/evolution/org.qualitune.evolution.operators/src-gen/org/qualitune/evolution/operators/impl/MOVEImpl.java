/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 */
package org.qualitune.evolution.operators.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.qualitune.evolution.operators.MOVE;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MOVE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.MOVEImpl#getNewParent <em>New Parent</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.MOVEImpl#getParentReference <em>Parent Reference</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.MOVEImpl#getMovee <em>Movee</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MOVEImpl extends OperatorImpl implements MOVE {
	/**
	 * The cached value of the '{@link #getNewParent() <em>New Parent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewParent()
	 * @generated
	 * @ordered
	 */
	protected Referrable newParent;

	/**
	 * The cached value of the '{@link #getParentReference() <em>Parent Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentReference()
	 * @generated
	 * @ordered
	 */
	protected EReference parentReference;

	/**
	 * The cached value of the '{@link #getMovee() <em>Movee</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovee()
	 * @generated
	 * @ordered
	 */
	protected Referrable movee;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MOVEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.MOVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getNewParent() {
		return newParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewParent(Referrable newNewParent, NotificationChain msgs) {
		Referrable oldNewParent = newParent;
		newParent = newNewParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.MOVE__NEW_PARENT, oldNewParent, newNewParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewParent(Referrable newNewParent) {
		if (newNewParent != newParent) {
			NotificationChain msgs = null;
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.MOVE__NEW_PARENT, null, msgs);
			if (newNewParent != null)
				msgs = ((InternalEObject)newNewParent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.MOVE__NEW_PARENT, null, msgs);
			msgs = basicSetNewParent(newNewParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MOVE__NEW_PARENT, newNewParent, newNewParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentReference() {
		if (parentReference != null && parentReference.eIsProxy()) {
			InternalEObject oldParentReference = (InternalEObject)parentReference;
			parentReference = (EReference)eResolveProxy(oldParentReference);
			if (parentReference != oldParentReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.MOVE__PARENT_REFERENCE, oldParentReference, parentReference));
			}
		}
		return parentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetParentReference() {
		return parentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentReference(EReference newParentReference) {
		EReference oldParentReference = parentReference;
		parentReference = newParentReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MOVE__PARENT_REFERENCE, oldParentReference, parentReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getMovee() {
		return movee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMovee(Referrable newMovee, NotificationChain msgs) {
		Referrable oldMovee = movee;
		movee = newMovee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.MOVE__MOVEE, oldMovee, newMovee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMovee(Referrable newMovee) {
		if (newMovee != movee) {
			NotificationChain msgs = null;
			if (movee != null)
				msgs = ((InternalEObject)movee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.MOVE__MOVEE, null, msgs);
			if (newMovee != null)
				msgs = ((InternalEObject)newMovee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.MOVE__MOVEE, null, msgs);
			msgs = basicSetMovee(newMovee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.MOVE__MOVEE, newMovee, newMovee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.MOVE__NEW_PARENT:
				return basicSetNewParent(null, msgs);
			case OperatorsPackage.MOVE__MOVEE:
				return basicSetMovee(null, msgs);
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
			case OperatorsPackage.MOVE__NEW_PARENT:
				return getNewParent();
			case OperatorsPackage.MOVE__PARENT_REFERENCE:
				if (resolve) return getParentReference();
				return basicGetParentReference();
			case OperatorsPackage.MOVE__MOVEE:
				return getMovee();
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
			case OperatorsPackage.MOVE__NEW_PARENT:
				setNewParent((Referrable)newValue);
				return;
			case OperatorsPackage.MOVE__PARENT_REFERENCE:
				setParentReference((EReference)newValue);
				return;
			case OperatorsPackage.MOVE__MOVEE:
				setMovee((Referrable)newValue);
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
			case OperatorsPackage.MOVE__NEW_PARENT:
				setNewParent((Referrable)null);
				return;
			case OperatorsPackage.MOVE__PARENT_REFERENCE:
				setParentReference((EReference)null);
				return;
			case OperatorsPackage.MOVE__MOVEE:
				setMovee((Referrable)null);
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
			case OperatorsPackage.MOVE__NEW_PARENT:
				return newParent != null;
			case OperatorsPackage.MOVE__PARENT_REFERENCE:
				return parentReference != null;
			case OperatorsPackage.MOVE__MOVEE:
				return movee != null;
		}
		return super.eIsSet(featureID);
	}

} //MOVEImpl
