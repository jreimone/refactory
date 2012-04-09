/*******************************************************************************
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
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.tests.properties.KeyValuePair#getValue <em>Value</em>}</li>
 *   <li>{@link org.emftext.refactoring.tests.properties.KeyValuePair#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getKeyValuePair()
 * @model
 * @generated
 */
public interface KeyValuePair extends EObject {
	/**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Value)
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getKeyValuePair_Value()
   * @model containment="true" required="true"
   * @generated
   */
	Value getValue();

	/**
   * Sets the value of the '{@link org.emftext.refactoring.tests.properties.KeyValuePair#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
	void setValue(Value value);

	/**
   * Returns the value of the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' containment reference.
   * @see #setKey(Key)
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getKeyValuePair_Key()
   * @model containment="true"
   * @generated
   */
	Key getKey();

	/**
   * Sets the value of the '{@link org.emftext.refactoring.tests.properties.KeyValuePair#getKey <em>Key</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' containment reference.
   * @see #getKey()
   * @generated
   */
	void setKey(Key value);

} // KeyValuePair
