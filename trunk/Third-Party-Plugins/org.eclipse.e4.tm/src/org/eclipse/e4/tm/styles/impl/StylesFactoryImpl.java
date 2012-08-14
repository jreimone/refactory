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
 * $Id: StylesFactoryImpl.java,v 1.2 2009/05/07 15:10:41 pwebster Exp $
 */
package org.eclipse.e4.tm.styles.impl;

import org.eclipse.e4.tm.styles.*;
import org.eclipse.e4.tm.styles.AbstractImage;
import org.eclipse.e4.tm.styles.ColorConstant;
import org.eclipse.e4.tm.styles.ColorStyleItem;
import org.eclipse.e4.tm.styles.ImageResource;
import org.eclipse.e4.tm.styles.RGBColor;
import org.eclipse.e4.tm.styles.Resource;
import org.eclipse.e4.tm.styles.Style;
import org.eclipse.e4.tm.styles.StyleItems;
import org.eclipse.e4.tm.styles.Styled;
import org.eclipse.e4.tm.styles.StylesFactory;
import org.eclipse.e4.tm.styles.StylesPackage;

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
public class StylesFactoryImpl extends EFactoryImpl implements StylesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StylesFactory init() {
		try {
			StylesFactory theStylesFactory = (StylesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/e4/tm/styles.ecore"); 
			if (theStylesFactory != null) {
				return theStylesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StylesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylesFactoryImpl() {
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
			case StylesPackage.STYLE_ITEMS: return createStyleItems();
			case StylesPackage.STYLE: return createStyle();
			case StylesPackage.STYLED: return createStyled();
			case StylesPackage.COLOR_CONSTANT: return createColorConstant();
			case StylesPackage.RGB_COLOR: return createRGBColor();
			case StylesPackage.ABSTRACT_IMAGE: return createAbstractImage();
			case StylesPackage.RESOURCE: return createResource();
			case StylesPackage.IMAGE_RESOURCE: return createImageResource();
			case StylesPackage.COLOR_STYLE_ITEM: return createColorStyleItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleItems createStyleItems() {
		StyleItemsImpl styleItems = new StyleItemsImpl();
		return styleItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style createStyle() {
		StyleImpl style = new StyleImpl();
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Styled createStyled() {
		StyledImpl styled = new StyledImpl();
		return styled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorConstant createColorConstant() {
		ColorConstantImpl colorConstant = new ColorConstantImpl();
		return colorConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RGBColor createRGBColor() {
		RGBColorImpl rgbColor = new RGBColorImpl();
		return rgbColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractImage createAbstractImage() {
		AbstractImageImpl abstractImage = new AbstractImageImpl();
		return abstractImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageResource createImageResource() {
		ImageResourceImpl imageResource = new ImageResourceImpl();
		return imageResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorStyleItem createColorStyleItem() {
		ColorStyleItemImpl colorStyleItem = new ColorStyleItemImpl();
		return colorStyleItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylesPackage getStylesPackage() {
		return (StylesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StylesPackage getPackage() {
		return StylesPackage.eINSTANCE;
	}

} //StylesFactoryImpl
