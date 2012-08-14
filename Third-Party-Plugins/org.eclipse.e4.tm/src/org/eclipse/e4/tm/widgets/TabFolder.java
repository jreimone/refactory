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
 * $Id: TabFolder.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tab Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.TabFolder#getSelectionEvent <em>Selection Event</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.TabFolder#getSelectionIndex <em>Selection Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getTabFolder()
 * @model
 * @generated
 */
public interface TabFolder extends AbstractComposite<Tab> {

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
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getTabFolder_SelectionEvent()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore realName='Selection' access='event' invalidates='selectionIndex'"
	 * @generated
	 */
	Object getSelectionEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.TabFolder#getSelectionEvent <em>Selection Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Event</em>' attribute.
	 * @see #getSelectionEvent()
	 * @generated
	 */
	void setSelectionEvent(Object value);

	/**
	 * Returns the value of the '<em><b>Selection Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Index</em>' attribute.
	 * @see #setSelectionIndex(int)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getTabFolder_SelectionIndex()
	 * @model default="-1"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='getSelectionIndex setSelection(int)' invalidatedBy='selectionEvent'"
	 * @generated
	 */
	int getSelectionIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.TabFolder#getSelectionIndex <em>Selection Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Index</em>' attribute.
	 * @see #getSelectionIndex()
	 * @generated
	 */
	void setSelectionIndex(int value);
} // TabFolder
