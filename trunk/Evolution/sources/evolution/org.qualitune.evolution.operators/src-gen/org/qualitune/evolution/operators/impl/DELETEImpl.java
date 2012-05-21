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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.operators.DELETE;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.util.OperatorsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DELETE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.DELETEImpl#getDeletion <em>Deletion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DELETEImpl extends OperatorImpl implements DELETE {
	/**
	 * The cached value of the '{@link #getDeletion() <em>Deletion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletion()
	 * @generated
	 * @ordered
	 */
	protected Referrable deletion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DELETEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.DELETE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getDeletion() {
		return deletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeletion(Referrable newDeletion, NotificationChain msgs) {
		Referrable oldDeletion = deletion;
		deletion = newDeletion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.DELETE__DELETION, oldDeletion, newDeletion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeletion(Referrable newDeletion) {
		if (newDeletion != deletion) {
			NotificationChain msgs = null;
			if (deletion != null)
				msgs = ((InternalEObject)deletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.DELETE__DELETION, null, msgs);
			if (newDeletion != null)
				msgs = ((InternalEObject)newDeletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.DELETE__DELETION, null, msgs);
			msgs = basicSetDeletion(newDeletion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.DELETE__DELETION, newDeletion, newDeletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.DELETE__DELETION:
				return basicSetDeletion(null, msgs);
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
			case OperatorsPackage.DELETE__DELETION:
				return getDeletion();
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
			case OperatorsPackage.DELETE__DELETION:
				setDeletion((Referrable)newValue);
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
			case OperatorsPackage.DELETE__DELETION:
				setDeletion((Referrable)null);
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
			case OperatorsPackage.DELETE__DELETION:
				return deletion != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void execute() {
		Referrable referrable = getDeletion();
		List<Diagnostic> errors = new BasicEList<Resource.Diagnostic>();
		EObject deletion = OperatorsUtil.getEObjectFromReferrable(referrable, errors);
		if(deletion == null){
			for (Diagnostic error : errors) {
				OperatorsUtil.addErrorToResourceOf(this, error);
				return;
			}
		} else {
			EcoreUtil.delete(deletion, true);
		}
		super.execute();
	}

} //DELETEImpl
