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
 * $Id: StylesPackage.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.styles;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.e4.tm.styles.StylesFactory
 * @model kind="package"
 * @generated
 */
public interface StylesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "styles";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/e4/tm/styles.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tm.styles";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StylesPackage eINSTANCE = org.eclipse.e4.tm.styles.impl.StylesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.StyleItemImpl <em>Style Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.StyleItemImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyleItem()
	 * @generated
	 */
	int STYLE_ITEM = 0;

	/**
	 * The number of structural features of the '<em>Style Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_ITEM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.StyleItemsImpl <em>Style Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.StyleItemsImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyleItems()
	 * @generated
	 */
	int STYLE_ITEMS = 1;

	/**
	 * The feature id for the '<em><b>Style Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_ITEMS__STYLE_ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Style Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_ITEMS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.StyleImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 2;

	/**
	 * The feature id for the '<em><b>Style Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__STYLE_ITEMS = STYLE_ITEMS__STYLE_ITEMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__NAME = STYLE_ITEMS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = STYLE_ITEMS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.StyledImpl <em>Styled</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.StyledImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyled()
	 * @generated
	 */
	int STYLED = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED__NAME = 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED__ROLE = 1;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED__STYLE = 2;

	/**
	 * The number of structural features of the '<em>Styled</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLED_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.AbstractColorImpl <em>Abstract Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.AbstractColorImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getAbstractColor()
	 * @generated
	 */
	int ABSTRACT_COLOR = 4;

	/**
	 * The number of structural features of the '<em>Abstract Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COLOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.ColorConstantImpl <em>Color Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.ColorConstantImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getColorConstant()
	 * @generated
	 */
	int COLOR_CONSTANT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CONSTANT__NAME = ABSTRACT_COLOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CONSTANT_FEATURE_COUNT = ABSTRACT_COLOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.RGBColorImpl <em>RGB Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.RGBColorImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getRGBColor()
	 * @generated
	 */
	int RGB_COLOR = 6;

	/**
	 * The feature id for the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RGB_COLOR__RED = ABSTRACT_COLOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RGB_COLOR__GREEN = ABSTRACT_COLOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RGB_COLOR__BLUE = ABSTRACT_COLOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>RGB Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RGB_COLOR_FEATURE_COUNT = ABSTRACT_COLOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.AbstractImageImpl <em>Abstract Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.AbstractImageImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getAbstractImage()
	 * @generated
	 */
	int ABSTRACT_IMAGE = 7;

	/**
	 * The number of structural features of the '<em>Abstract Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.ResourceImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__URI = 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.ImageResourceImpl <em>Image Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.ImageResourceImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getImageResource()
	 * @generated
	 */
	int IMAGE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_RESOURCE__URI = ABSTRACT_IMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_RESOURCE_FEATURE_COUNT = ABSTRACT_IMAGE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl <em>Color Style Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl
	 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getColorStyleItem()
	 * @generated
	 */
	int COLOR_STYLE_ITEM = 10;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_STYLE_ITEM__BACKGROUND_COLOR = STYLE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_STYLE_ITEM__FOREGROUND_COLOR = STYLE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_STYLE_ITEM__TEXT_COLOR = STYLE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Color Style Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_STYLE_ITEM_FEATURE_COUNT = STYLE_ITEM_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.StyleItem <em>Style Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style Item</em>'.
	 * @see org.eclipse.e4.tm.styles.StyleItem
	 * @generated
	 */
	EClass getStyleItem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.StyleItems <em>Style Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style Items</em>'.
	 * @see org.eclipse.e4.tm.styles.StyleItems
	 * @generated
	 */
	EClass getStyleItems();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.e4.tm.styles.StyleItems#getStyleItems <em>Style Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Style Items</em>'.
	 * @see org.eclipse.e4.tm.styles.StyleItems#getStyleItems()
	 * @see #getStyleItems()
	 * @generated
	 */
	EReference getStyleItems_StyleItems();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see org.eclipse.e4.tm.styles.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.Style#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.e4.tm.styles.Style#getName()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.Styled <em>Styled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Styled</em>'.
	 * @see org.eclipse.e4.tm.styles.Styled
	 * @generated
	 */
	EClass getStyled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.Styled#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.e4.tm.styles.Styled#getName()
	 * @see #getStyled()
	 * @generated
	 */
	EAttribute getStyled_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.Styled#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see org.eclipse.e4.tm.styles.Styled#getRole()
	 * @see #getStyled()
	 * @generated
	 */
	EAttribute getStyled_Role();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.styles.Styled#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Style</em>'.
	 * @see org.eclipse.e4.tm.styles.Styled#getStyle()
	 * @see #getStyled()
	 * @generated
	 */
	EReference getStyled_Style();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.AbstractColor <em>Abstract Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Color</em>'.
	 * @see org.eclipse.e4.tm.styles.AbstractColor
	 * @generated
	 */
	EClass getAbstractColor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.ColorConstant <em>Color Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Constant</em>'.
	 * @see org.eclipse.e4.tm.styles.ColorConstant
	 * @generated
	 */
	EClass getColorConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.ColorConstant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.e4.tm.styles.ColorConstant#getName()
	 * @see #getColorConstant()
	 * @generated
	 */
	EAttribute getColorConstant_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.RGBColor <em>RGB Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RGB Color</em>'.
	 * @see org.eclipse.e4.tm.styles.RGBColor
	 * @generated
	 */
	EClass getRGBColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.RGBColor#getRed <em>Red</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red</em>'.
	 * @see org.eclipse.e4.tm.styles.RGBColor#getRed()
	 * @see #getRGBColor()
	 * @generated
	 */
	EAttribute getRGBColor_Red();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.RGBColor#getGreen <em>Green</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green</em>'.
	 * @see org.eclipse.e4.tm.styles.RGBColor#getGreen()
	 * @see #getRGBColor()
	 * @generated
	 */
	EAttribute getRGBColor_Green();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.RGBColor#getBlue <em>Blue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue</em>'.
	 * @see org.eclipse.e4.tm.styles.RGBColor#getBlue()
	 * @see #getRGBColor()
	 * @generated
	 */
	EAttribute getRGBColor_Blue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.AbstractImage <em>Abstract Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Image</em>'.
	 * @see org.eclipse.e4.tm.styles.AbstractImage
	 * @generated
	 */
	EClass getAbstractImage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.e4.tm.styles.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.styles.Resource#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.e4.tm.styles.Resource#getUri()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.ImageResource <em>Image Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Resource</em>'.
	 * @see org.eclipse.e4.tm.styles.ImageResource
	 * @generated
	 */
	EClass getImageResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.styles.ColorStyleItem <em>Color Style Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Style Item</em>'.
	 * @see org.eclipse.e4.tm.styles.ColorStyleItem
	 * @generated
	 */
	EClass getColorStyleItem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.styles.ColorStyleItem#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.e4.tm.styles.ColorStyleItem#getBackgroundColor()
	 * @see #getColorStyleItem()
	 * @generated
	 */
	EReference getColorStyleItem_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.styles.ColorStyleItem#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.e4.tm.styles.ColorStyleItem#getForegroundColor()
	 * @see #getColorStyleItem()
	 * @generated
	 */
	EReference getColorStyleItem_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.styles.ColorStyleItem#getTextColor <em>Text Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text Color</em>'.
	 * @see org.eclipse.e4.tm.styles.ColorStyleItem#getTextColor()
	 * @see #getColorStyleItem()
	 * @generated
	 */
	EReference getColorStyleItem_TextColor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StylesFactory getStylesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.StyleItemImpl <em>Style Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.StyleItemImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyleItem()
		 * @generated
		 */
		EClass STYLE_ITEM = eINSTANCE.getStyleItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.StyleItemsImpl <em>Style Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.StyleItemsImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyleItems()
		 * @generated
		 */
		EClass STYLE_ITEMS = eINSTANCE.getStyleItems();

		/**
		 * The meta object literal for the '<em><b>Style Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_ITEMS__STYLE_ITEMS = eINSTANCE.getStyleItems_StyleItems();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.StyleImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__NAME = eINSTANCE.getStyle_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.StyledImpl <em>Styled</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.StyledImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getStyled()
		 * @generated
		 */
		EClass STYLED = eINSTANCE.getStyled();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLED__NAME = eINSTANCE.getStyled_Name();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLED__ROLE = eINSTANCE.getStyled_Role();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLED__STYLE = eINSTANCE.getStyled_Style();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.AbstractColorImpl <em>Abstract Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.AbstractColorImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getAbstractColor()
		 * @generated
		 */
		EClass ABSTRACT_COLOR = eINSTANCE.getAbstractColor();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.ColorConstantImpl <em>Color Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.ColorConstantImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getColorConstant()
		 * @generated
		 */
		EClass COLOR_CONSTANT = eINSTANCE.getColorConstant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_CONSTANT__NAME = eINSTANCE.getColorConstant_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.RGBColorImpl <em>RGB Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.RGBColorImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getRGBColor()
		 * @generated
		 */
		EClass RGB_COLOR = eINSTANCE.getRGBColor();

		/**
		 * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RGB_COLOR__RED = eINSTANCE.getRGBColor_Red();

		/**
		 * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RGB_COLOR__GREEN = eINSTANCE.getRGBColor_Green();

		/**
		 * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RGB_COLOR__BLUE = eINSTANCE.getRGBColor_Blue();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.AbstractImageImpl <em>Abstract Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.AbstractImageImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getAbstractImage()
		 * @generated
		 */
		EClass ABSTRACT_IMAGE = eINSTANCE.getAbstractImage();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.ResourceImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__URI = eINSTANCE.getResource_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.ImageResourceImpl <em>Image Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.ImageResourceImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getImageResource()
		 * @generated
		 */
		EClass IMAGE_RESOURCE = eINSTANCE.getImageResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl <em>Color Style Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl
		 * @see org.eclipse.e4.tm.styles.impl.StylesPackageImpl#getColorStyleItem()
		 * @generated
		 */
		EClass COLOR_STYLE_ITEM = eINSTANCE.getColorStyleItem();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLOR_STYLE_ITEM__BACKGROUND_COLOR = eINSTANCE.getColorStyleItem_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLOR_STYLE_ITEM__FOREGROUND_COLOR = eINSTANCE.getColorStyleItem_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Text Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLOR_STYLE_ITEM__TEXT_COLOR = eINSTANCE.getColorStyleItem_TextColor();

	}

} //StylesPackage
