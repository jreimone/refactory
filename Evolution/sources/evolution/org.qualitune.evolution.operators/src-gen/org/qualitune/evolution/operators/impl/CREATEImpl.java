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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.operators.CREATE;
import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.OperatorsFactory;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.TypeVariable;
import org.qualitune.evolution.operators.util.OperatorsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CREATE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.CREATEImpl#getNewInstanceVariable <em>New Instance Variable</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.CREATEImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.CREATEImpl#getParentCompositeReference <em>Parent Composite Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CREATEImpl extends OperatorImpl implements CREATE {
	/**
	 * The cached value of the '{@link #getNewInstanceVariable() <em>New Instance Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewInstanceVariable()
	 * @generated
	 * @ordered
	 */
	protected TypeVariable newInstanceVariable;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Referrable parent;

	/**
	 * The cached value of the '{@link #getParentCompositeReference() <em>Parent Composite Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentCompositeReference()
	 * @generated
	 * @ordered
	 */
	protected EReference parentCompositeReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CREATEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.CREATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeVariable getNewInstanceVariable() {
		return newInstanceVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewInstanceVariable(TypeVariable newNewInstanceVariable, NotificationChain msgs) {
		TypeVariable oldNewInstanceVariable = newInstanceVariable;
		newInstanceVariable = newNewInstanceVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE, oldNewInstanceVariable, newNewInstanceVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewInstanceVariable(TypeVariable newNewInstanceVariable) {
		if (newNewInstanceVariable != newInstanceVariable) {
			NotificationChain msgs = null;
			if (newInstanceVariable != null)
				msgs = ((InternalEObject)newInstanceVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE, null, msgs);
			if (newNewInstanceVariable != null)
				msgs = ((InternalEObject)newNewInstanceVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE, null, msgs);
			msgs = basicSetNewInstanceVariable(newNewInstanceVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE, newNewInstanceVariable, newNewInstanceVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referrable getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Referrable newParent, NotificationChain msgs) {
		Referrable oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.CREATE__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Referrable newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.CREATE__PARENT, null, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.CREATE__PARENT, null, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.CREATE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentCompositeReference() {
		if (parentCompositeReference != null && parentCompositeReference.eIsProxy()) {
			InternalEObject oldParentCompositeReference = (InternalEObject)parentCompositeReference;
			parentCompositeReference = (EReference)eResolveProxy(oldParentCompositeReference);
			if (parentCompositeReference != oldParentCompositeReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE, oldParentCompositeReference, parentCompositeReference));
			}
		}
		return parentCompositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetParentCompositeReference() {
		return parentCompositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentCompositeReference(EReference newParentCompositeReference) {
		EReference oldParentCompositeReference = parentCompositeReference;
		parentCompositeReference = newParentCompositeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE, oldParentCompositeReference, parentCompositeReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE:
				return basicSetNewInstanceVariable(null, msgs);
			case OperatorsPackage.CREATE__PARENT:
				return basicSetParent(null, msgs);
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
			case OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE:
				return getNewInstanceVariable();
			case OperatorsPackage.CREATE__PARENT:
				return getParent();
			case OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE:
				if (resolve) return getParentCompositeReference();
				return basicGetParentCompositeReference();
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
			case OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE:
				setNewInstanceVariable((TypeVariable)newValue);
				return;
			case OperatorsPackage.CREATE__PARENT:
				setParent((Referrable)newValue);
				return;
			case OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE:
				setParentCompositeReference((EReference)newValue);
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
			case OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE:
				setNewInstanceVariable((TypeVariable)null);
				return;
			case OperatorsPackage.CREATE__PARENT:
				setParent((Referrable)null);
				return;
			case OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE:
				setParentCompositeReference((EReference)null);
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
			case OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE:
				return newInstanceVariable != null;
			case OperatorsPackage.CREATE__PARENT:
				return parent != null;
			case OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE:
				return parentCompositeReference != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void execute() {
		TypeVariable variable = getNewInstanceVariable();
		final EClass metaclass = variable.getType();
		EObjectReference result = OperatorsFactory.eINSTANCE.createEObjectReference();
		if(metaclass.isAbstract() || metaclass.isInterface()){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Metaclass " + metaclass.getName() + " must not be abstract");
			return;
		}
		EObject instance = EcoreUtil.create(metaclass);
		result.getElement().add(instance);
		variable.setValue(instance);
		EReference containmentReference = getParentCompositeReference();
		if(!containmentReference.isContainment()){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Reference " + containmentReference.getName() + " must be a containment reference");
			return;
		}
		if(!containmentReference.getEReferenceType().isInstance(instance)){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The type of reference '" + containmentReference.getName() + "' doesn't correspond to the referenced metaclass '" + metaclass.getName() + "'.");
			return;
		}
		Referrable parentReferrable = getParent();
		List<Resource.Diagnostic> errors = new BasicEList<Resource.Diagnostic>();
		EObject parent = OperatorsUtil.getEObjectFromReferrable(parentReferrable, errors);
		if(parent == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		if(containmentReference.isMany()){
			@SuppressWarnings("unchecked")
			List<EObject> referenceValueList = (List<EObject>) parent.eGet(containmentReference, true);
			referenceValueList.add(instance);
		} else {
			parent.eSet(containmentReference, instance);
		}
		setResult(result);
		super.execute();
	}

} //CREATEImpl
