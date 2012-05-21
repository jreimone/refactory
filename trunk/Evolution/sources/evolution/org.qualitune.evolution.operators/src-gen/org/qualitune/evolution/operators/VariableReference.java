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
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.VariableReference#getReferencedVariable <em>Referenced Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends Referrable {
	/**
	 * Returns the value of the '<em><b>Referenced Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Variable</em>' reference.
	 * @see #setReferencedVariable(Variable)
	 * @see org.qualitune.evolution.operators.OperatorsPackage#getVariableReference_ReferencedVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getReferencedVariable();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.operators.VariableReference#getReferencedVariable <em>Referenced Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Variable</em>' reference.
	 * @see #getReferencedVariable()
	 * @generated
	 */
	void setReferencedVariable(Variable value);

} // VariableReference
