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
 * $Id: Browser.java,v 1.3 2009/05/19 07:29:07 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Browser</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.Browser#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.Browser#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.Browser#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBrowser()
 * @model annotation="http://www.eclipse.org/e4/swt.ecore javaPackage='org.eclipse.swt.browser'"
 * @generated
 */
public interface Browser extends Control {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBrowser_Location()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='event' invalidates='url text'"
	 * @generated
	 */
	Object getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Browser#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Object value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBrowser_Url()
	 * @model dataType="org.eclipse.e4.tm.util.LimitedString"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='property' invalidatedBy='location'"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Browser#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBrowser_Text()
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore access='property' invalidatedBy='location'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.Browser#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Browser
