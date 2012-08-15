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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.SPLIT;
import org.qualitune.evolution.operators.StructuralFeatureSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPLIT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.SPLITImpl#getSplitSets <em>Split Sets</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.impl.SPLITImpl#getSplitObject <em>Split Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SPLITImpl extends OperatorImpl implements SPLIT {
	/**
   * The cached value of the '{@link #getSplitSets() <em>Split Sets</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSplitSets()
   * @generated
   * @ordered
   */
	protected EList<StructuralFeatureSet> splitSets;

	/**
   * The cached value of the '{@link #getSplitObject() <em>Split Object</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSplitObject()
   * @generated
   * @ordered
   */
	protected Referrable splitObject;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected SPLITImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OperatorsPackage.Literals.SPLIT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<StructuralFeatureSet> getSplitSets() {
    if (splitSets == null)
    {
      splitSets = new EObjectContainmentEList<StructuralFeatureSet>(StructuralFeatureSet.class, this, OperatorsPackage.SPLIT__SPLIT_SETS);
    }
    return splitSets;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Referrable getSplitObject() {
    return splitObject;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetSplitObject(Referrable newSplitObject, NotificationChain msgs) {
    Referrable oldSplitObject = splitObject;
    splitObject = newSplitObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.SPLIT__SPLIT_OBJECT, oldSplitObject, newSplitObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setSplitObject(Referrable newSplitObject) {
    if (newSplitObject != splitObject)
    {
      NotificationChain msgs = null;
      if (splitObject != null)
        msgs = ((InternalEObject)splitObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.SPLIT__SPLIT_OBJECT, null, msgs);
      if (newSplitObject != null)
        msgs = ((InternalEObject)newSplitObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.SPLIT__SPLIT_OBJECT, null, msgs);
      msgs = basicSetSplitObject(newSplitObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.SPLIT__SPLIT_OBJECT, newSplitObject, newSplitObject));
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
      case OperatorsPackage.SPLIT__SPLIT_SETS:
        return ((InternalEList<?>)getSplitSets()).basicRemove(otherEnd, msgs);
      case OperatorsPackage.SPLIT__SPLIT_OBJECT:
        return basicSetSplitObject(null, msgs);
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
      case OperatorsPackage.SPLIT__SPLIT_SETS:
        return getSplitSets();
      case OperatorsPackage.SPLIT__SPLIT_OBJECT:
        return getSplitObject();
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
    switch (featureID)
    {
      case OperatorsPackage.SPLIT__SPLIT_SETS:
        getSplitSets().clear();
        getSplitSets().addAll((Collection<? extends StructuralFeatureSet>)newValue);
        return;
      case OperatorsPackage.SPLIT__SPLIT_OBJECT:
        setSplitObject((Referrable)newValue);
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
      case OperatorsPackage.SPLIT__SPLIT_SETS:
        getSplitSets().clear();
        return;
      case OperatorsPackage.SPLIT__SPLIT_OBJECT:
        setSplitObject((Referrable)null);
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
      case OperatorsPackage.SPLIT__SPLIT_SETS:
        return splitSets != null && !splitSets.isEmpty();
      case OperatorsPackage.SPLIT__SPLIT_OBJECT:
        return splitObject != null;
    }
    return super.eIsSet(featureID);
  }

} //SPLITImpl
