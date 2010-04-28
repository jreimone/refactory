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
 * $Id: Button.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.Button#getSelectionEvent <em>Selection Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getButton()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/e4/swt.ecore javaClass='Button'"
 * @generated
 */
public interface Button extends Control, Labeled {
	/**
	 * Returns the value of the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Event</em>' attribute.
	 * @see #setSelectionEvent(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getButton_SelectionEvent()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore realName='Selection' access='event' invalidates='selection'"
	 * @generated
	 */
	Object getSelectionEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Button#getSelectionEvent <em>Selection Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Event</em>' attribute.
	 * @see #getSelectionEvent()
	 * @generated
	 */
	void setSelectionEvent(Object value);

} // Button
