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
 * $Id: LayoutsFactoryImpl.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.layouts.impl;

import org.eclipse.e4.tm.layouts.*;
import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.layouts.LayoutsFactory;
import org.eclipse.e4.tm.layouts.LayoutsPackage;

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
			LayoutsFactory theLayoutsFactory = (LayoutsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/e4/tm/layouts.ecore"); 
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
			case LayoutsPackage.LAYOUT_DATA: return createLayoutData();
			case LayoutsPackage.LAYOUT: return createLayout();
			case LayoutsPackage.RECTANGLE_LAYOUT: return createRectangleLayout();
			case LayoutsPackage.RECTANGLE_LAYOUT_DATA: return createRectangleLayoutData();
			case LayoutsPackage.POSITION: return createPosition();
			case LayoutsPackage.DIMENSION: return createDimension();
			case LayoutsPackage.RECTANGLE: return createRectangle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutData createLayoutData() {
		LayoutDataImpl layoutData = new LayoutDataImpl();
		return layoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends LayoutData> Layout<T> createLayout() {
		LayoutImpl<T> layout = new LayoutImpl<T>();
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createRectangleLayout() {
		Layout rectangleLayout = (Layout)super.create(LayoutsPackage.Literals.RECTANGLE_LAYOUT);
		return rectangleLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutData createRectangleLayoutData() {
		LayoutData rectangleLayoutData = (LayoutData)super.create(LayoutsPackage.Literals.RECTANGLE_LAYOUT_DATA);
		return rectangleLayoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject createPosition() {
		EObject position = super.create(LayoutsPackage.Literals.POSITION);
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject createDimension() {
		EObject dimension = super.create(LayoutsPackage.Literals.DIMENSION);
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject createRectangle() {
		EObject rectangle = super.create(LayoutsPackage.Literals.RECTANGLE);
		return rectangle;
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
