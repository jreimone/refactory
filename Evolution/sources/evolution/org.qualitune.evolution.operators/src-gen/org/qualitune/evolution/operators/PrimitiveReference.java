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
 * A representation of the model object '<em><b>Primitive Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.PrimitiveReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.operators.OperatorsPackage#getPrimitiveReference()
 * @model
 * @generated
 */
public interface PrimitiveReference extends Result {
	/**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(Object)
   * @see org.qualitune.evolution.operators.OperatorsPackage#getPrimitiveReference_Value()
   * @model required="true"
   * @generated
   */
	Object getValue();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.operators.PrimitiveReference#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
	void setValue(Object value);

} // PrimitiveReference
