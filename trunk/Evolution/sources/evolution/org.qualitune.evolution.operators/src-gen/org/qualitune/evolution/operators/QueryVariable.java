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

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.QueryVariable#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.QueryVariable#getStructuralFeature <em>Structural Feature</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.QueryVariable#getQueryObject <em>Query Object</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.QueryVariable#getQueryResult <em>Query Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getQueryVariable()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL operationFeatureXOR='self.operation = null xor self.structuralFeature = null' nameNotNull='not(self.name = null)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='operationFeatureXOR'"
 * @generated
 */
public interface QueryVariable extends Variable {
	/**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(EOperation)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getQueryVariable_Operation()
   * @model
   * @generated
   */
	EOperation getOperation();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.QueryVariable#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
	void setOperation(EOperation value);

	/**
   * Returns the value of the '<em><b>Structural Feature</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structural Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Structural Feature</em>' reference.
   * @see #setStructuralFeature(EStructuralFeature)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getQueryVariable_StructuralFeature()
   * @model
   * @generated
   */
	EStructuralFeature getStructuralFeature();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.QueryVariable#getStructuralFeature <em>Structural Feature</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structural Feature</em>' reference.
   * @see #getStructuralFeature()
   * @generated
   */
	void setStructuralFeature(EStructuralFeature value);

	/**
   * Returns the value of the '<em><b>Query Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Query Object</em>' containment reference.
   * @see #setQueryObject(Referrable)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getQueryVariable_QueryObject()
   * @model containment="true" required="true"
   * @generated
   */
	Referrable getQueryObject();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.QueryVariable#getQueryObject <em>Query Object</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query Object</em>' containment reference.
   * @see #getQueryObject()
   * @generated
   */
	void setQueryObject(Referrable value);

	/**
   * Returns the value of the '<em><b>Query Result</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Query Result</em>' reference.
   * @see #setQueryResult(Result)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getQueryVariable_QueryResult()
   * @model required="true"
   * @generated
   */
	Result getQueryResult();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.QueryVariable#getQueryResult <em>Query Result</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query Result</em>' reference.
   * @see #getQueryResult()
   * @generated
   */
	void setQueryResult(Result value);

} // QueryVariable
