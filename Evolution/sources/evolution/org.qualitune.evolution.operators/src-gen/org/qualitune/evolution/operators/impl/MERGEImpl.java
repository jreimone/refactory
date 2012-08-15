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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.evolution.operators.MERGE;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Referrable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MERGE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.MERGEImpl#getMergeObjects <em>Merge Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MERGEImpl extends OperatorImpl implements MERGE {
	/**
   * The cached value of the '{@link #getMergeObjects() <em>Merge Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMergeObjects()
   * @generated
   * @ordered
   */
	protected EList<Referrable> mergeObjects;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MERGEImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OperatorsPackage.Literals.MERGE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Referrable> getMergeObjects() {
    if (mergeObjects == null)
    {
      mergeObjects = new EObjectContainmentEList<Referrable>(Referrable.class, this, OperatorsPackage.MERGE__MERGE_OBJECTS);
    }
    return mergeObjects;
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
      case OperatorsPackage.MERGE__MERGE_OBJECTS:
        return ((InternalEList<?>)getMergeObjects()).basicRemove(otherEnd, msgs);
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
      case OperatorsPackage.MERGE__MERGE_OBJECTS:
        return getMergeObjects();
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
      case OperatorsPackage.MERGE__MERGE_OBJECTS:
        getMergeObjects().clear();
        getMergeObjects().addAll((Collection<? extends Referrable>)newValue);
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
      case OperatorsPackage.MERGE__MERGE_OBJECTS:
        getMergeObjects().clear();
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
      case OperatorsPackage.MERGE__MERGE_OBJECTS:
        return mergeObjects != null && !mergeObjects.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MERGEImpl
