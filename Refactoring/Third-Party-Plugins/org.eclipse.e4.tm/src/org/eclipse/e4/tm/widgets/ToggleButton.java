/*******************************************************************************
 * Copyright (c) 2008 Hallvard Traetteberg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Hallvard Traetteberg - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id: ToggleButton.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Toggle Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.ToggleButton#isSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getToggleButton()
 * @model annotation="http://www.eclipse.org/e4/swt.ecore style='TOGGLE'"
 * @generated
 */
public interface ToggleButton extends Button {
	/**
	 * Returns the value of the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' attribute.
	 * @see #setSelection(boolean)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getToggleButton_Selection()
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore invalidatedBy='selectionEvent'"
	 * @generated
	 */
	boolean isSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.ToggleButton#isSelection <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' attribute.
	 * @see #isSelection()
	 * @generated
	 */
	void setSelection(boolean value);

} // ToggleButton
