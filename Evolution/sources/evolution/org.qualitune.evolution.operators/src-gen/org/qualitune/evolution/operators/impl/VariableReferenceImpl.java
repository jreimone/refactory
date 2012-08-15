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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.Variable;
import org.qualitune.evolution.operators.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.VariableReferenceImpl#getReferencedVariable <em>Referenced Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableReferenceImpl extends ReferrableImpl implements VariableReference {
	/**
   * The cached value of the '{@link #getReferencedVariable() <em>Referenced Variable</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getReferencedVariable()
   * @generated
   * @ordered
   */
	protected Variable referencedVariable;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected VariableReferenceImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OperatorsPackage.Literals.VARIABLE_REFERENCE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Variable getReferencedVariable() {
    if (referencedVariable != null && referencedVariable.eIsProxy())
    {
      InternalEObject oldReferencedVariable = (InternalEObject)referencedVariable;
      referencedVariable = (Variable)eResolveProxy(oldReferencedVariable);
      if (referencedVariable != oldReferencedVariable)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE, oldReferencedVariable, referencedVariable));
      }
    }
    return referencedVariable;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Variable basicGetReferencedVariable() {
    return referencedVariable;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setReferencedVariable(Variable newReferencedVariable) {
    Variable oldReferencedVariable = referencedVariable;
    referencedVariable = newReferencedVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE, oldReferencedVariable, referencedVariable));
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
      case OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE:
        if (resolve) return getReferencedVariable();
        return basicGetReferencedVariable();
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
      case OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE:
        setReferencedVariable((Variable)newValue);
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
      case OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE:
        setReferencedVariable((Variable)null);
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
      case OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE:
        return referencedVariable != null;
    }
    return super.eIsSet(featureID);
  }

} //VariableReferenceImpl
