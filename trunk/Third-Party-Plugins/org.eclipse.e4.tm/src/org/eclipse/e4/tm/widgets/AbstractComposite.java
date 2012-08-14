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
 * $Id: AbstractComposite.java,v 1.3 2009/05/25 21:59:17 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets;

import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.styles.Style;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.AbstractComposite#getControls <em>Controls</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.AbstractComposite#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.AbstractComposite#getLayout <em>Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getAbstractComposite()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='validControls'"
 * @generated
 */
public interface AbstractComposite<T extends Control> extends Control {
	/**
	 * Returns the value of the '<em><b>Controls</b></em>' containment reference list.
	 * The list contents are of type {@link T}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.e4.tm.widgets.Control#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' containment reference list.
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getAbstractComposite_Controls()
	 * @see org.eclipse.e4.tm.widgets.Control#getComposite
	 * @model opposite="composite" containment="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='binder'"
	 * @generated
	 */
	EList<T> getControls();

	/**
	 * Returns the value of the '<em><b>Styles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.e4.tm.styles.Style}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styles</em>' containment reference list.
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getAbstractComposite_Styles()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore access='binder'"
	 * @generated
	 */
	EList<Style> getStyles();

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' containment reference.
	 * @see #setLayout(Layout)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getAbstractComposite_Layout()
	 * @model containment="true"
	 * @generated
	 */
	Layout<LayoutData> getLayout();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.AbstractComposite#getLayout <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' containment reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(Layout<LayoutData> value);

} // AbstractComposite
