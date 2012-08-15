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
 * A representation of the model object '<em><b>MOVE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.MOVE#getNewParent <em>New Parent</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.MOVE#getParentReference <em>Parent Reference</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.MOVE#getMovee <em>Movee</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getMOVE()
 * @model
 * @generated
 */
public interface MOVE extends Operator {
	/**
   * Returns the value of the '<em><b>New Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Parent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>New Parent</em>' containment reference.
   * @see #setNewParent(Referrable)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getMOVE_NewParent()
   * @model containment="true" required="true"
   * @generated
   */
	Referrable getNewParent();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.MOVE#getNewParent <em>New Parent</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>New Parent</em>' containment reference.
   * @see #getNewParent()
   * @generated
   */
	void setNewParent(Referrable value);

	/**
   * Returns the value of the '<em><b>Parent Reference</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parent Reference</em>' reference.
   * @see #setParentReference(EReference)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getMOVE_ParentReference()
   * @model required="true"
   * @generated
   */
	EReference getParentReference();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.MOVE#getParentReference <em>Parent Reference</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Reference</em>' reference.
   * @see #getParentReference()
   * @generated
   */
	void setParentReference(EReference value);

	/**
   * Returns the value of the '<em><b>Movee</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movee</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Movee</em>' containment reference.
   * @see #setMovee(Referrable)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getMOVE_Movee()
   * @model containment="true" required="true"
   * @generated
   */
	Referrable getMovee();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.MOVE#getMovee <em>Movee</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Movee</em>' containment reference.
   * @see #getMovee()
   * @generated
   */
	void setMovee(Referrable value);

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model
   * @generated
   */
	void execute();

} // MOVE
