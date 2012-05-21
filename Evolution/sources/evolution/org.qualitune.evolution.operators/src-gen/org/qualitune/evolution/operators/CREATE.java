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

import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CREATE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.CREATE#getNewInstanceVariable <em>New Instance Variable</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.CREATE#getParent <em>Parent</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.CREATE#getParentCompositeReference <em>Parent Composite Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getCREATE()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='containmentReference'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL containmentReference='self.parentCompositeReference.containment = true'"
 * @generated
 */
public interface CREATE extends Operator {
	/**
	 * Returns the value of the '<em><b>New Instance Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Instance Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Instance Variable</em>' containment reference.
	 * @see #setNewInstanceVariable(TypeVariable)
	 * @see org.qualitune.evolution.operators.OperatorsPackage#getCREATE_NewInstanceVariable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeVariable getNewInstanceVariable();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.operators.CREATE#getNewInstanceVariable <em>New Instance Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Instance Variable</em>' containment reference.
	 * @see #getNewInstanceVariable()
	 * @generated
	 */
	void setNewInstanceVariable(TypeVariable value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' containment reference.
	 * @see #setParent(Referrable)
	 * @see org.qualitune.evolution.operators.OperatorsPackage#getCREATE_Parent()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Referrable getParent();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.operators.CREATE#getParent <em>Parent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' containment reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Referrable value);

	/**
	 * Returns the value of the '<em><b>Parent Composite Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Composite Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Composite Reference</em>' reference.
	 * @see #setParentCompositeReference(EReference)
	 * @see org.qualitune.evolution.operators.OperatorsPackage#getCREATE_ParentCompositeReference()
	 * @model required="true"
	 * @generated
	 */
	EReference getParentCompositeReference();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.operators.CREATE#getParentCompositeReference <em>Parent Composite Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Composite Reference</em>' reference.
	 * @see #getParentCompositeReference()
	 * @generated
	 */
	void setParentCompositeReference(EReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute();

} // CREATE
