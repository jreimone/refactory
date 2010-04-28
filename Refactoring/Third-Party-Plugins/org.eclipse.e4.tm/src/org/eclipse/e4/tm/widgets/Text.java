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
 * $Id: Text.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.Text#isEditable <em>Editable</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.Text#getModify <em>Modify</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.Text#getKeyUp <em>Key Up</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.Text#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getText()
 * @model
 * @generated
 */
public interface Text extends Control {
	/**
	 * Returns the value of the '<em><b>Editable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editable</em>' attribute.
	 * @see #setEditable(boolean)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getText_Editable()
	 * @model default="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore#ComboBox access=''"
	 * @generated
	 */
	boolean isEditable();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Text#isEditable <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editable</em>' attribute.
	 * @see #isEditable()
	 * @generated
	 */
	void setEditable(boolean value);

	/**
	 * Returns the value of the '<em><b>Modify</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modify</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modify</em>' attribute.
	 * @see #setModify(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getText_Modify()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='event' invalidates='text' realName='Modify'"
	 * @generated
	 */
	Object getModify();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Text#getModify <em>Modify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modify</em>' attribute.
	 * @see #getModify()
	 * @generated
	 */
	void setModify(Object value);

	/**
	 * Returns the value of the '<em><b>Key Up</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Up</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Up</em>' attribute.
	 * @see #setKeyUp(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getText_KeyUp()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='event'"
	 * @generated
	 */
	Object getKeyUp();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Text#getKeyUp <em>Key Up</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Up</em>' attribute.
	 * @see #getKeyUp()
	 * @generated
	 */
	void setKeyUp(Object value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getText_Text()
	 * @model default=""
	 *        annotation="http://www.eclipse.org/e4/swt.ecore invalidatedBy='modify'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Text#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Text
