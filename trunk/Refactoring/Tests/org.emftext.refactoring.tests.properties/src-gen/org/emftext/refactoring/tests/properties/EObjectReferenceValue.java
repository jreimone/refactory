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
 * A representation of the model object '<em><b>EObject Reference Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue#getObjectReference <em>Object Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getEObjectReferenceValue()
 * @model
 * @generated
 */
public interface EObjectReferenceValue extends Value {
	/**
   * Returns the value of the '<em><b>Object Reference</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Object Reference</em>' reference.
   * @see #setObjectReference(EObject)
   * @see org.emftext.refactoring.tests.properties.PropertiesPackage#getEObjectReferenceValue_ObjectReference()
   * @model required="true"
   * @generated
   */
	EObject getObjectReference();

	/**
   * Sets the value of the '{@link org.emftext.refactoring.tests.properties.EObjectReferenceValue#getObjectReference <em>Object Reference</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Reference</em>' reference.
   * @see #getObjectReference()
   * @generated
   */
	void setObjectReference(EObject value);

} // EObjectReferenceValue
