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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DELETE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.DELETE#getDeletion <em>Deletion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getDELETE()
 * @model
 * @generated
 */
public interface DELETE extends Operator {
	/**
	 * Returns the value of the '<em><b>Deletion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deletion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deletion</em>' containment reference.
	 * @see #setDeletion(Referrable)
	 * @see org.qualitune.evolution.operators.OperatorsPackage#getDELETE_Deletion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Referrable getDeletion();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.operators.DELETE#getDeletion <em>Deletion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deletion</em>' containment reference.
	 * @see #getDeletion()
	 * @generated
	 */
	void setDeletion(Referrable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute();

} // DELETE