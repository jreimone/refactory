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
 * $Id: LayoutsFactoryImpl.java,v 1.2 2009/05/07 15:10:42 pwebster Exp $
 */
package org.eclipse.e4.tm.swt.layouts.impl;

import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.swt.layouts.LayoutsFactory;
import org.eclipse.e4.tm.swt.layouts.LayoutsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayoutsFactoryImpl extends EFactoryImpl implements LayoutsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayoutsFactory init() {
		try {
			LayoutsFactory theLayoutsFactory = (LayoutsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/swt/layouts.ecore"); 
			if (theLayoutsFactory != null) {
				return theLayoutsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayoutsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LayoutsPackage.ROW_LAYOUT: return createRowLayout();
			case LayoutsPackage.ROW_LAYOUT_DATA: return createRowLayoutData();
			case LayoutsPackage.GRID_LAYOUT: return createGridLayout();
			case LayoutsPackage.GRID_LAYOUT_DATA: return createGridLayoutData();
			case LayoutsPackage.FILL_LAYOUT: return createFillLayout();
			case LayoutsPackage.STACK_LAYOUT: return createStackLayout();
			case LayoutsPackage.FORM_LAYOUT: return createFormLayout();
			case LayoutsPackage.FORM_LAYOUT_DATA: return createFormLayoutData();
			case LayoutsPackage.FORM_ATTACHMENT: return createFormAttachment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutData createRowLayoutData() {
		LayoutData rowLayoutData = (LayoutData)super.create(LayoutsPackage.Literals.ROW_LAYOUT_DATA);
		return rowLayoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createGridLayout() {
		Layout gridLayout = (Layout)super.create(LayoutsPackage.Literals.GRID_LAYOUT);
		return gridLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutData createGridLayoutData() {
		LayoutData gridLayoutData = (LayoutData)super.create(LayoutsPackage.Literals.GRID_LAYOUT_DATA);
		return gridLayoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createFillLayout() {
		Layout fillLayout = (Layout)super.create(LayoutsPackage.Literals.FILL_LAYOUT);
		return fillLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createStackLayout() {
		Layout stackLayout = (Layout)super.create(LayoutsPackage.Literals.STACK_LAYOUT);
		return stackLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createFormLayout() {
		Layout formLayout = (Layout)super.create(LayoutsPackage.Literals.FORM_LAYOUT);
		return formLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutData createFormLayoutData() {
		LayoutData formLayoutData = (LayoutData)super.create(LayoutsPackage.Literals.FORM_LAYOUT_DATA);
		return formLayoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject createFormAttachment() {
		EObject formAttachment = super.create(LayoutsPackage.Literals.FORM_ATTACHMENT);
		return formAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createRowLayout() {
		Layout rowLayout = (Layout)super.create(LayoutsPackage.Literals.ROW_LAYOUT);
		return rowLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsPackage getLayoutsPackage() {
		return (LayoutsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayoutsPackage getPackage() {
		return LayoutsPackage.eINSTANCE;
	}

} //LayoutsFactoryImpl
