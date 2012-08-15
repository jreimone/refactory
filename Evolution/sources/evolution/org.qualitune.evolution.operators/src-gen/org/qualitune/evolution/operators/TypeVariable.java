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
package org.qualitune.evolution.operators;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.TypeVariable#getType <em>Type</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.TypeVariable#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getTypeVariable()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL typeMustBeConcrete='not(self.type.abstract = true)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='typeMustBeConcrete'"
 * @generated
 */
public interface TypeVariable extends Variable {
	/**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getTypeVariable_Type()
   * @model required="true"
   * @generated
   */
	EClass getType();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.TypeVariable#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
	void setType(EClass value);

	/**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(EObject)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getTypeVariable_Value()
   * @model required="true"
   * @generated
   */
	EObject getValue();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.TypeVariable#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
	void setValue(EObject value);

} // TypeVariable
