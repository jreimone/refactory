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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.StructuralFeatureSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structural Feature Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.StructuralFeatureSetImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructuralFeatureSetImpl extends EObjectImpl implements StructuralFeatureSet {
	/**
   * The cached value of the '{@link #getStructuralFeatures() <em>Structural Features</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStructuralFeatures()
   * @generated
   * @ordered
   */
	protected EList<EStructuralFeature> structuralFeatures;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected StructuralFeatureSetImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OperatorsPackage.Literals.STRUCTURAL_FEATURE_SET;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<EStructuralFeature> getStructuralFeatures() {
    if (structuralFeatures == null)
    {
      structuralFeatures = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, OperatorsPackage.STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES);
    }
    return structuralFeatures;
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
      case OperatorsPackage.STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES:
        return getStructuralFeatures();
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
      case OperatorsPackage.STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES:
        getStructuralFeatures().clear();
        getStructuralFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
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
      case OperatorsPackage.STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES:
        getStructuralFeatures().clear();
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
      case OperatorsPackage.STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES:
        return structuralFeatures != null && !structuralFeatures.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StructuralFeatureSetImpl
