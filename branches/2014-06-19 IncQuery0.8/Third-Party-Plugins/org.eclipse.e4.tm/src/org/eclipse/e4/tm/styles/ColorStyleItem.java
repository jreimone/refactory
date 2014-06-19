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
 * $Id: ColorStyleItem.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.styles;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Style Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.styles.ColorStyleItem#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.styles.ColorStyleItem#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.styles.ColorStyleItem#getTextColor <em>Text Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.styles.StylesPackage#getColorStyleItem()
 * @model
 * @generated
 */
public interface ColorStyleItem extends StyleItem {
	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' containment reference.
	 * @see #setBackgroundColor(AbstractColor)
	 * @see org.eclipse.e4.tm.styles.StylesPackage#getColorStyleItem_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	AbstractColor getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.styles.ColorStyleItem#getBackgroundColor <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' containment reference.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(AbstractColor value);

	/**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color</em>' containment reference.
	 * @see #setForegroundColor(AbstractColor)
	 * @see org.eclipse.e4.tm.styles.StylesPackage#getColorStyleItem_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	AbstractColor getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.styles.ColorStyleItem#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(AbstractColor value);

	/**
	 * Returns the value of the '<em><b>Text Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Color</em>' containment reference.
	 * @see #setTextColor(AbstractColor)
	 * @see org.eclipse.e4.tm.styles.StylesPackage#getColorStyleItem_TextColor()
	 * @model containment="true"
	 * @generated
	 */
	AbstractColor getTextColor();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.styles.ColorStyleItem#getTextColor <em>Text Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Color</em>' containment reference.
	 * @see #getTextColor()
	 * @generated
	 */
	void setTextColor(AbstractColor value);

} // ColorStyleItem
