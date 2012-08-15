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
 * A representation of the model object '<em><b>MERGE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.MERGE#getMergeObjects <em>Merge Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getMERGE()
 * @model
 * @generated
 */
public interface MERGE extends Operator {
	/**
   * Returns the value of the '<em><b>Merge Objects</b></em>' containment reference list.
   * The list contents are of type {@link org.qualitune.evolution.operators.Referrable}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Merge Objects</em>' containment reference list.
   * @see org.qualitune.evolution.operators.OperatorsPackage#getMERGE_MergeObjects()
   * @model containment="true" lower="2"
   * @generated
   */
	EList<Referrable> getMergeObjects();

} // MERGE
