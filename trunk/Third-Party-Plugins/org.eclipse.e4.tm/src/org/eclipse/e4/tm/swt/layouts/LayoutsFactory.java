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
 * $Id: LayoutsFactory.java,v 1.2 2009/05/07 15:10:41 pwebster Exp $
 */
package org.eclipse.e4.tm.swt.layouts;

import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.e4.tm.swt.layouts.LayoutsPackage
 * @generated
 */
public interface LayoutsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutsFactory eINSTANCE = org.eclipse.e4.tm.swt.layouts.impl.LayoutsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Row Layout Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Row Layout Data</em>'.
	 * @generated
	 */
	LayoutData createRowLayoutData();

	/**
	 * Returns a new object of class '<em>Grid Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grid Layout</em>'.
	 * @generated
	 */
	Layout createGridLayout();

	/**
	 * Returns a new object of class '<em>Grid Layout Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grid Layout Data</em>'.
	 * @generated
	 */
	LayoutData createGridLayoutData();

	/**
	 * Returns a new object of class '<em>Fill Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill Layout</em>'.
	 * @generated
	 */
	Layout createFillLayout();

	/**
	 * Returns a new object of class '<em>Stack Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack Layout</em>'.
	 * @generated
	 */
	Layout createStackLayout();

	/**
	 * Returns a new object of class '<em>Form Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Layout</em>'.
	 * @generated
	 */
	Layout createFormLayout();

	/**
	 * Returns a new object of class '<em>Form Layout Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Layout Data</em>'.
	 * @generated
	 */
	LayoutData createFormLayoutData();

	/**
	 * Returns a new object of class '<em>Form Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Attachment</em>'.
	 * @generated
	 */
	EObject createFormAttachment();

	/**
	 * Returns a new object of class '<em>Row Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Row Layout</em>'.
	 * @generated
	 */
	Layout createRowLayout();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LayoutsPackage getLayoutsPackage();

} //LayoutsFactory
