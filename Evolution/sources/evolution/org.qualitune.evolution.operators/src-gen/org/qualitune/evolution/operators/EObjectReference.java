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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.EObjectReference#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getEObjectReference()
 * @model
 * @generated
 */
public interface EObjectReference extends Result, Referrable {
	/**
   * Returns the value of the '<em><b>Element</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' reference list.
   * @see org.qualitune.evolution.operators.OperatorsPackage#getEObjectReference_Element()
   * @model required="true"
   * @generated
   */
	EList<EObject> getElement();

} // EObjectReference
