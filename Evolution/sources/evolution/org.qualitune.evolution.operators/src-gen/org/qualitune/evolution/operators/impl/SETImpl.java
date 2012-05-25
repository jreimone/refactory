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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.OperatorsFactory;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.SET;
import org.qualitune.evolution.operators.util.OperatorsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SET</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.SETImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.SETImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.SETImpl#getReferenceOwner <em>Reference Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SETImpl extends OperatorImpl implements SET {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Referrable value;

	/**
	 * The cached value of the '{@link #getReferenceOwner() <em>Reference Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceOwner()
	 * @generated
	 * @ordered
	 */
	protected Referrable referenceOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SETImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.SET__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.SET__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Referrable newValue, NotificationChain msgs) {
		Referrable oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.SET__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Referrable newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.SET__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.SET__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.SET__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getReferenceOwner() {
		return referenceOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferenceOwner(Referrable newReferenceOwner, NotificationChain msgs) {
		Referrable oldReferenceOwner = referenceOwner;
		referenceOwner = newReferenceOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.SET__REFERENCE_OWNER, oldReferenceOwner, newReferenceOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceOwner(Referrable newReferenceOwner) {
		if (newReferenceOwner != referenceOwner) {
			NotificationChain msgs = null;
			if (referenceOwner != null)
				msgs = ((InternalEObject)referenceOwner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.SET__REFERENCE_OWNER, null, msgs);
			if (newReferenceOwner != null)
				msgs = ((InternalEObject)newReferenceOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.SET__REFERENCE_OWNER, null, msgs);
			msgs = basicSetReferenceOwner(newReferenceOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.SET__REFERENCE_OWNER, newReferenceOwner, newReferenceOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.SET__VALUE:
				return basicSetValue(null, msgs);
			case OperatorsPackage.SET__REFERENCE_OWNER:
				return basicSetReferenceOwner(null, msgs);
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
			case OperatorsPackage.SET__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case OperatorsPackage.SET__VALUE:
				return getValue();
			case OperatorsPackage.SET__REFERENCE_OWNER:
				return getReferenceOwner();
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
			case OperatorsPackage.SET__REFERENCE:
				setReference((EReference)newValue);
				return;
			case OperatorsPackage.SET__VALUE:
				setValue((Referrable)newValue);
				return;
			case OperatorsPackage.SET__REFERENCE_OWNER:
				setReferenceOwner((Referrable)newValue);
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
			case OperatorsPackage.SET__REFERENCE:
				setReference((EReference)null);
				return;
			case OperatorsPackage.SET__VALUE:
				setValue((Referrable)null);
				return;
			case OperatorsPackage.SET__REFERENCE_OWNER:
				setReferenceOwner((Referrable)null);
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
			case OperatorsPackage.SET__REFERENCE:
				return reference != null;
			case OperatorsPackage.SET__VALUE:
				return value != null;
			case OperatorsPackage.SET__REFERENCE_OWNER:
				return referenceOwner != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void execute() {
		Referrable referenceOwner = getReferenceOwner();
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject owner = OperatorsUtil.getEObjectFromReferrable(referenceOwner, errors);
		if(owner == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		Referrable valueReferrable = getValue();
		EObject value = OperatorsUtil.getEObjectFromReferrable(valueReferrable, errors);
		if(value == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		EReference reference = getReference();
		if(reference == null){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The reference mustn't be null");
			return;
		}
		EClassifier type = reference.getEReferenceType();
		if(type.isInstance(value)){
			owner.eSet(reference, value);
		} else {
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The type '" + type.getName() + "' is not compatible with the value '" + value + "'");
			return;
		}
		EObjectReference result = OperatorsFactory.eINSTANCE.createEObjectReference();
		result.getElement().add(reference);
		setResult(result);
		super.execute();
	}

} //SETImpl
