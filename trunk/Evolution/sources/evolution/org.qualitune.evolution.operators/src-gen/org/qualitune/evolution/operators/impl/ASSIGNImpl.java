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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import org.qualitune.evolution.operators.ASSIGN;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.util.OperatorsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASSIGN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.ASSIGNImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.ASSIGNImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.ASSIGNImpl#getAttributeOwner <em>Attribute Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ASSIGNImpl extends OperatorImpl implements ASSIGN {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributeOwner() <em>Attribute Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeOwner()
	 * @generated
	 * @ordered
	 */
	protected Referrable attributeOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASSIGNImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.ASSIGN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.ASSIGN__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.ASSIGN__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.ASSIGN__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getAttributeOwner() {
		return attributeOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeOwner(Referrable newAttributeOwner, NotificationChain msgs) {
		Referrable oldAttributeOwner = attributeOwner;
		attributeOwner = newAttributeOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER, oldAttributeOwner, newAttributeOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeOwner(Referrable newAttributeOwner) {
		if (newAttributeOwner != attributeOwner) {
			NotificationChain msgs = null;
			if (attributeOwner != null)
				msgs = ((InternalEObject)attributeOwner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER, null, msgs);
			if (newAttributeOwner != null)
				msgs = ((InternalEObject)newAttributeOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER, null, msgs);
			msgs = basicSetAttributeOwner(newAttributeOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER, newAttributeOwner, newAttributeOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER:
				return basicSetAttributeOwner(null, msgs);
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
			case OperatorsPackage.ASSIGN__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case OperatorsPackage.ASSIGN__VALUE:
				return getValue();
			case OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER:
				return getAttributeOwner();
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
			case OperatorsPackage.ASSIGN__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
				return;
			case OperatorsPackage.ASSIGN__VALUE:
				setValue(newValue);
				return;
			case OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER:
				setAttributeOwner((Referrable)newValue);
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
			case OperatorsPackage.ASSIGN__ATTRIBUTE:
				setAttribute((EAttribute)null);
				return;
			case OperatorsPackage.ASSIGN__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER:
				setAttributeOwner((Referrable)null);
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
			case OperatorsPackage.ASSIGN__ATTRIBUTE:
				return attribute != null;
			case OperatorsPackage.ASSIGN__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER:
				return attributeOwner != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void execute() {
		Referrable attributeOwner = getAttributeOwner();
		List<Diagnostic> errors = new BasicEList<Diagnostic>();
		EObject owner = OperatorsUtil.getEObjectFromReferrable(attributeOwner, errors);
		if(owner == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		Object value = getValue();
		EAttribute attribute = getAttribute();
		EClassifier type = attribute.getEType();
		if(type.isInstance(value)){
			owner.eSet(attribute, value);
		} else {
			Diagnostic diagnostic = OperatorsUtil.createDiagnostic(this, "The type '" + type.getName() + "' is not compatible with the value '" + value + "'");
			OperatorsUtil.addErrorToResourceOf(this, diagnostic);
		}
		super.execute();
	}

} //ASSIGNImpl
