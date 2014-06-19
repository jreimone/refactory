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
 * $Id: StyleItems.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.styles;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style Items</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.styles.StyleItems#getStyleItems <em>Style Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.styles.StylesPackage#getStyleItems()
 * @model
 * @generated
 */
public interface StyleItems extends EObject {
	/**
	 * Returns the value of the '<em><b>Style Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.e4.tm.styles.StyleItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Items</em>' containment reference list.
	 * @see org.eclipse.e4.tm.styles.StylesPackage#getStyleItems_StyleItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<StyleItem> getStyleItems();

} // StyleItems
