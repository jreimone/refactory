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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.QueryVariable;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.Result;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.QueryVariableImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.QueryVariableImpl#getStructuralFeature <em>Structural Feature</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.QueryVariableImpl#getQueryObject <em>Query Object</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.QueryVariableImpl#getQueryResult <em>Query Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryVariableImpl extends VariableImpl implements QueryVariable {
	/**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
	protected EOperation operation;

	/**
   * The cached value of the '{@link #getStructuralFeature() <em>Structural Feature</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStructuralFeature()
   * @generated
   * @ordered
   */
	protected EStructuralFeature structuralFeature;

	/**
   * The cached value of the '{@link #getQueryObject() <em>Query Object</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getQueryObject()
   * @generated
   * @ordered
   */
	protected Referrable queryObject;

	/**
   * The cached value of the '{@link #getQueryResult() <em>Query Result</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getQueryResult()
   * @generated
   * @ordered
   */
	protected Result queryResult;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected QueryVariableImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OperatorsPackage.Literals.QUERY_VARIABLE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EOperation getOperation() {
    if (operation != null && operation.eIsProxy())
    {
      InternalEObject oldOperation = (InternalEObject)operation;
      operation = (EOperation)eResolveProxy(oldOperation);
      if (operation != oldOperation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.QUERY_VARIABLE__OPERATION, oldOperation, operation));
      }
    }
    return operation;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EOperation basicGetOperation() {
    return operation;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOperation(EOperation newOperation) {
    EOperation oldOperation = operation;
    operation = newOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.QUERY_VARIABLE__OPERATION, oldOperation, operation));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EStructuralFeature getStructuralFeature() {
    if (structuralFeature != null && structuralFeature.eIsProxy())
    {
      InternalEObject oldStructuralFeature = (InternalEObject)structuralFeature;
      structuralFeature = (EStructuralFeature)eResolveProxy(oldStructuralFeature);
      if (structuralFeature != oldStructuralFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.QUERY_VARIABLE__STRUCTURAL_FEATURE, oldStructuralFeature, structuralFeature));
      }
    }
    return structuralFeature;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EStructuralFeature basicGetStructuralFeature() {
    return structuralFeature;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setStructuralFeature(EStructuralFeature newStructuralFeature) {
    EStructuralFeature oldStructuralFeature = structuralFeature;
    structuralFeature = newStructuralFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.QUERY_VARIABLE__STRUCTURAL_FEATURE, oldStructuralFeature, structuralFeature));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Referrable getQueryObject() {
    return queryObject;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetQueryObject(Referrable newQueryObject, NotificationChain msgs) {
    Referrable oldQueryObject = queryObject;
    queryObject = newQueryObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT, oldQueryObject, newQueryObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setQueryObject(Referrable newQueryObject) {
    if (newQueryObject != queryObject)
    {
      NotificationChain msgs = null;
      if (queryObject != null)
        msgs = ((InternalEObject)queryObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT, null, msgs);
      if (newQueryObject != null)
        msgs = ((InternalEObject)newQueryObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT, null, msgs);
      msgs = basicSetQueryObject(newQueryObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT, newQueryObject, newQueryObject));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Result getQueryResult() {
    if (queryResult != null && queryResult.eIsProxy())
    {
      InternalEObject oldQueryResult = (InternalEObject)queryResult;
      queryResult = (Result)eResolveProxy(oldQueryResult);
      if (queryResult != oldQueryResult)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT, oldQueryResult, queryResult));
      }
    }
    return queryResult;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Result basicGetQueryResult() {
    return queryResult;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setQueryResult(Result newQueryResult) {
    Result oldQueryResult = queryResult;
    queryResult = newQueryResult;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT, oldQueryResult, queryResult));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT:
        return basicSetQueryObject(null, msgs);
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
    switch (featureID)
    {
      case OperatorsPackage.QUERY_VARIABLE__OPERATION:
        if (resolve) return getOperation();
        return basicGetOperation();
      case OperatorsPackage.QUERY_VARIABLE__STRUCTURAL_FEATURE:
        if (resolve) return getStructuralFeature();
        return basicGetStructuralFeature();
      case OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT:
        return getQueryObject();
      case OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT:
        if (resolve) return getQueryResult();
        return basicGetQueryResult();
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
    switch (featureID)
    {
      case OperatorsPackage.QUERY_VARIABLE__OPERATION:
        setOperation((EOperation)newValue);
        return;
      case OperatorsPackage.QUERY_VARIABLE__STRUCTURAL_FEATURE:
        setStructuralFeature((EStructuralFeature)newValue);
        return;
      case OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT:
        setQueryObject((Referrable)newValue);
        return;
      case OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT:
        setQueryResult((Result)newValue);
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
    switch (featureID)
    {
      case OperatorsPackage.QUERY_VARIABLE__OPERATION:
        setOperation((EOperation)null);
        return;
      case OperatorsPackage.QUERY_VARIABLE__STRUCTURAL_FEATURE:
        setStructuralFeature((EStructuralFeature)null);
        return;
      case OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT:
        setQueryObject((Referrable)null);
        return;
      case OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT:
        setQueryResult((Result)null);
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
    switch (featureID)
    {
      case OperatorsPackage.QUERY_VARIABLE__OPERATION:
        return operation != null;
      case OperatorsPackage.QUERY_VARIABLE__STRUCTURAL_FEATURE:
        return structuralFeature != null;
      case OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT:
        return queryObject != null;
      case OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT:
        return queryResult != null;
    }
    return super.eIsSet(featureID);
  }

} //QueryVariableImpl
