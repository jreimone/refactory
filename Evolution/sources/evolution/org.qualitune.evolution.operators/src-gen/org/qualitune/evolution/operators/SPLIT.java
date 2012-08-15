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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPLIT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.SPLIT#getSplitSets <em>Split Sets</em>}</li>
 *   <li>{@link org.qualitune.evolution.operators.SPLIT#getSplitObject <em>Split Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getSPLIT()
 * @model
 * @generated
 */
public interface SPLIT extends Operator {
	/**
   * Returns the value of the '<em><b>Split Sets</b></em>' containment reference list.
   * The list contents are of type {@link org.qualitune.evolution.operators.StructuralFeatureSet}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Split Sets</em>' containment reference list.
   * @see org.qualitune.evolution.operators.OperatorsPackage#getSPLIT_SplitSets()
   * @model containment="true" required="true"
   * @generated
   */
	EList<StructuralFeatureSet> getSplitSets();

	/**
   * Returns the value of the '<em><b>Split Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Split Object</em>' containment reference.
   * @see #setSplitObject(Referrable)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getSPLIT_SplitObject()
   * @model containment="true" required="true"
   * @generated
   */
	Referrable getSplitObject();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.SPLIT#getSplitObject <em>Split Object</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Split Object</em>' containment reference.
   * @see #getSplitObject()
   * @generated
   */
	void setSplitObject(Referrable value);

} // SPLIT
