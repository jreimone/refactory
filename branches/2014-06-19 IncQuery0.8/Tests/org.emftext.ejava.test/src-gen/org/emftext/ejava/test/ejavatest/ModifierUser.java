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
package org.emftext.ejava.test.ejavatest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifier User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.ejava.test.ejavatest.ModifierUser#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.ejava.test.ejavatest.EjavatestPackage#getModifierUser()
 * @model
 * @generated
 */
public interface ModifierUser extends EObject {
	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' attribute list.
	 * The list contents are of type {@link org.emftext.ejava.test.ejavatest.ModifierEnum}.
	 * The literals are from the enumeration {@link org.emftext.ejava.test.ejavatest.ModifierEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' attribute list.
	 * @see org.emftext.ejava.test.ejavatest.ModifierEnum
	 * @see org.emftext.ejava.test.ejavatest.EjavatestPackage#getModifierUser_Modifier()
	 * @model unique="false"
	 * @generated
	 */
	EList<ModifierEnum> getModifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ModifierEnum> getTheModifiers();

} // ModifierUser
