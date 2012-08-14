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
 * $Id: List.java,v 1.3 2009/05/25 21:59:17 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.List#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.List#getSelectionEvent <em>Selection Event</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.List#getSelectionIndex <em>Selection Index</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.List#getSelectionIndices <em>Selection Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getList()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/e4/swt.ecore javaClass='List'"
 * @generated
 */
public interface List extends Control {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' attribute list.
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getList_Items()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getItems();

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
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getList_SelectionEvent()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore realName='Selection' access='event' invalidates='selectionIndex selectionIndices'"
	 * @generated
	 */
	Object getSelectionEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.List#getSelectionEvent <em>Selection Event</em>}' attribute.
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
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getList_SelectionIndex()
	 * @model default="-1"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='getSelectionIndex setSelection(int)' invalidatedBy='selectionEvent'"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore#ComboBox access='getSelectionIndex select(int)'"
	 * @generated
	 */
	int getSelectionIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.List#getSelectionIndex <em>Selection Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Index</em>' attribute.
	 * @see #getSelectionIndex()
	 * @generated
	 */
	void setSelectionIndex(int value);

	/**
	 * Returns the value of the '<em><b>Selection Indices</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Indices</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Indices</em>' attribute list.
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getList_SelectionIndices()
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore access='getSelectionIndices setSelection(int[])' invalidatedBy='selection'"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore#ComboBox access=''"
	 * @generated
	 */
	EList<Integer> getSelectionIndices();

} // List
