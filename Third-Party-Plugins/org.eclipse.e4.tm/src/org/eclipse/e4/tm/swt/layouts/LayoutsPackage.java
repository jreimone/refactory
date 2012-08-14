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
 * $Id: LayoutsPackage.java,v 1.2 2009/05/07 15:10:41 pwebster Exp $
 */
package org.eclipse.e4.tm.swt.layouts;

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
 * @see org.eclipse.e4.tm.swt.layouts.LayoutsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/swt.ecore javaPackage='org.eclipse.swt.layout'"
 * @generated
 */
public interface LayoutsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layouts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/e4/swt/layouts.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "swt.layouts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutsPackage eINSTANCE = org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.RowLayoutDataImpl <em>Row Layout Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.RowLayoutDataImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getRowLayoutData()
	 * @generated
	 */
	int ROW_LAYOUT_DATA = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.GridLayoutImpl <em>Grid Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.GridLayoutImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getGridLayout()
	 * @generated
	 */
	int GRID_LAYOUT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.GridLayoutDataImpl <em>Grid Layout Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.GridLayoutDataImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getGridLayoutData()
	 * @generated
	 */
	int GRID_LAYOUT_DATA = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FillLayoutImpl <em>Fill Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.FillLayoutImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFillLayout()
	 * @generated
	 */
	int FILL_LAYOUT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.StackLayoutImpl <em>Stack Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.StackLayoutImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getStackLayout()
	 * @generated
	 */
	int STACK_LAYOUT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FormLayoutImpl <em>Form Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.FormLayoutImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFormLayout()
	 * @generated
	 */
	int FORM_LAYOUT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FormLayoutDataImpl <em>Form Layout Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.FormLayoutDataImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFormLayoutData()
	 * @generated
	 */
	int FORM_LAYOUT_DATA = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FormAttachmentImpl <em>Form Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.FormAttachmentImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFormAttachment()
	 * @generated
	 */
	int FORM_ATTACHMENT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.layouts.impl.RowLayoutImpl <em>Row Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.layouts.impl.RowLayoutImpl
	 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getRowLayout()
	 * @generated
	 */
	int ROW_LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__TYPE = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Center</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__CENTER = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__FILL = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Justify</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__JUSTIFY = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Pack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__PACK = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wrap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__WRAP = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Margin Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__MARGIN_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Margin Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__MARGIN_HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__SPACING = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Margin Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__MARGIN_LEFT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Margin Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__MARGIN_TOP = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Margin Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__MARGIN_RIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Margin Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT__MARGIN_BOTTOM = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Row Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT_DATA__WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT_DATA__HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exclude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT_DATA__EXCLUDE = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Row Layout Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_LAYOUT_DATA_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Num Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__NUM_COLUMNS = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Make Columns Equal Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MAKE_COLUMNS_EQUAL_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Margin Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MARGIN_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Margin Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MARGIN_HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Margin Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MARGIN_LEFT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Margin Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MARGIN_TOP = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Margin Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MARGIN_RIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Margin Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__MARGIN_BOTTOM = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Horizontal Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__HORIZONTAL_SPACING = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Vertical Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT__VERTICAL_SPACING = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Grid Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Vertical Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__VERTICAL_ALIGNMENT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Horizontal Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__HORIZONTAL_ALIGNMENT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__WIDTH_HINT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__HEIGHT_HINT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Horizontal Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__HORIZONTAL_INDENT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vertical Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__VERTICAL_INDENT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Horizontal Span</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__HORIZONTAL_SPAN = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Vertical Span</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__VERTICAL_SPAN = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Grab Excess Horizontal Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__GRAB_EXCESS_HORIZONTAL_SPACE = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Grab Excess Vertical Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__GRAB_EXCESS_VERTICAL_SPACE = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Minimum Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__MINIMUM_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Minimum Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__MINIMUM_HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Exclude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA__EXCLUDE = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Grid Layout Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRID_LAYOUT_DATA_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_LAYOUT__TYPE = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Margin Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_LAYOUT__MARGIN_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Margin Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_LAYOUT__MARGIN_HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_LAYOUT__SPACING = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fill Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_LAYOUT_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Margin Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_LAYOUT__MARGIN_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Margin Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_LAYOUT__MARGIN_HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Top Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_LAYOUT__TOP_CONTROL = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stack Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_LAYOUT_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Margin Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__MARGIN_WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Margin Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__MARGIN_HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Margin Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__MARGIN_LEFT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Margin Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__MARGIN_TOP = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Margin Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__MARGIN_RIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Margin Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__MARGIN_BOTTOM = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT__SPACING = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Form Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA__WIDTH = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA__HEIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA__LEFT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Top</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA__TOP = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA__RIGHT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bottom</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA__BOTTOM = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Form Layout Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_LAYOUT_DATA_FEATURE_COUNT = org.eclipse.e4.tm.layouts.LayoutsPackage.LAYOUT_DATA_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Numerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_ATTACHMENT__NUMERATOR = 0;

	/**
	 * The feature id for the '<em><b>Denominator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_ATTACHMENT__DENOMINATOR = 1;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_ATTACHMENT__OFFSET = 2;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_ATTACHMENT__CONTROL = 3;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_ATTACHMENT__ALIGNMENT = 4;

	/**
	 * The number of structural features of the '<em>Form Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_ATTACHMENT_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.LayoutData <em>Row Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row Layout Data</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData
	 * @model annotation="http://www.eclipse.org/swt.ecore realName='RowData'"
	 * @generated
	 */
	EClass getRowLayoutData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#isExclude <em>Exclude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exclude</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#isExclude()
	 * @see #getRowLayoutData()
	 * @generated
	 */
	EAttribute getRowLayoutData_Exclude();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Grid Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grid Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @model
	 * @generated
	 */
	EClass getGridLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getNumColumns <em>Num Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Columns</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getNumColumns()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_NumColumns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#isMakeColumnsEqualWidth <em>Make Columns Equal Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Make Columns Equal Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#isMakeColumnsEqualWidth()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MakeColumnsEqualWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginWidth <em>Margin Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginWidth()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MarginWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginHeight <em>Margin Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Height</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginHeight()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MarginHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginLeft <em>Margin Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Left</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginLeft()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MarginLeft();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginTop <em>Margin Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Top</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginTop()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MarginTop();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginRight <em>Margin Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Right</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginRight()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MarginRight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginBottom <em>Margin Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Bottom</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginBottom()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_MarginBottom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getHorizontalSpacing <em>Horizontal Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Spacing</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getHorizontalSpacing()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_HorizontalSpacing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getVerticalSpacing <em>Vertical Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Spacing</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getVerticalSpacing()
	 * @see #getGridLayout()
	 * @generated
	 */
	EAttribute getGridLayout_VerticalSpacing();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.LayoutData <em>Grid Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grid Layout Data</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData
	 * @model annotation="http://www.eclipse.org/swt.ecore realName='GridData'"
	 * @generated
	 */
	EClass getGridLayoutData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getVerticalAlignment <em>Vertical Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Alignment</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getVerticalAlignment()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_VerticalAlignment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getHorizontalAlignment <em>Horizontal Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Alignment</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getHorizontalAlignment()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_HorizontalAlignment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getWidthHint <em>Width Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width Hint</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getWidthHint()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_WidthHint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getHeightHint <em>Height Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height Hint</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getHeightHint()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_HeightHint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getHorizontalIndent <em>Horizontal Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Indent</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getHorizontalIndent()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_HorizontalIndent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getVerticalIndent <em>Vertical Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Indent</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getVerticalIndent()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_VerticalIndent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getHorizontalSpan <em>Horizontal Span</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Span</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getHorizontalSpan()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_HorizontalSpan();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getVerticalSpan <em>Vertical Span</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Span</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getVerticalSpan()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_VerticalSpan();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#isGrabExcessHorizontalSpace <em>Grab Excess Horizontal Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grab Excess Horizontal Space</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#isGrabExcessHorizontalSpace()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_GrabExcessHorizontalSpace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#isGrabExcessVerticalSpace <em>Grab Excess Vertical Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grab Excess Vertical Space</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#isGrabExcessVerticalSpace()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_GrabExcessVerticalSpace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getMinimumWidth <em>Minimum Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getMinimumWidth()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_MinimumWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#getMinimumHeight <em>Minimum Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Height</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getMinimumHeight()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_MinimumHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.LayoutData#isExclude <em>Exclude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exclude</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#isExclude()
	 * @see #getGridLayoutData()
	 * @generated
	 */
	EAttribute getGridLayoutData_Exclude();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Fill Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fill Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @model
	 * @generated
	 */
	EClass getFillLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getType()
	 * @see #getFillLayout()
	 * @generated
	 */
	EAttribute getFillLayout_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginWidth <em>Margin Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginWidth()
	 * @see #getFillLayout()
	 * @generated
	 */
	EAttribute getFillLayout_MarginWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginHeight <em>Margin Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Height</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginHeight()
	 * @see #getFillLayout()
	 * @generated
	 */
	EAttribute getFillLayout_MarginHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getSpacing <em>Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getSpacing()
	 * @see #getFillLayout()
	 * @generated
	 */
	EAttribute getFillLayout_Spacing();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Stack Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @model
	 * @generated
	 */
	EClass getStackLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginWidth <em>Margin Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginWidth()
	 * @see #getStackLayout()
	 * @generated
	 */
	EAttribute getStackLayout_MarginWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginHeight <em>Margin Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Height</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginHeight()
	 * @see #getStackLayout()
	 * @generated
	 */
	EAttribute getStackLayout_MarginHeight();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.e4.tm.layouts.Layout#getTopControl <em>Top Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Control</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getTopControl()
	 * @see #getStackLayout()
	 * @generated
	 */
	EReference getStackLayout_TopControl();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Form Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @model
	 * @generated
	 */
	EClass getFormLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginWidth <em>Margin Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginWidth()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_MarginWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginHeight <em>Margin Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Height</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginHeight()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_MarginHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginLeft <em>Margin Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Left</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginLeft()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_MarginLeft();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginTop <em>Margin Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Top</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginTop()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_MarginTop();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginRight <em>Margin Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Right</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginRight()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_MarginRight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginBottom <em>Margin Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Bottom</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginBottom()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_MarginBottom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getSpacing <em>Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getSpacing()
	 * @see #getFormLayout()
	 * @generated
	 */
	EAttribute getFormLayout_Spacing();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.LayoutData <em>Form Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Layout Data</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData
	 * @model annotation="http://www.eclipse.org/swt.ecore realName='FormData'"
	 * @generated
	 */
	EClass getFormLayoutData();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.layouts.LayoutData#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getLeft()
	 * @see #getFormLayoutData()
	 * @generated
	 */
	EReference getFormLayoutData_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.layouts.LayoutData#getTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Top</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getTop()
	 * @see #getFormLayoutData()
	 * @generated
	 */
	EReference getFormLayoutData_Top();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.layouts.LayoutData#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getRight()
	 * @see #getFormLayoutData()
	 * @generated
	 */
	EReference getFormLayoutData_Right();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.layouts.LayoutData#getBottom <em>Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData#getBottom()
	 * @see #getFormLayoutData()
	 * @generated
	 */
	EReference getFormLayoutData_Bottom();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.EObject <em>Form Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Attachment</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @model annotation="http://www.eclipse.org/swt.ecore access='field'"
	 * @generated
	 */
	EClass getFormAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getNumerator <em>Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numerator</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getNumerator()
	 * @see #getFormAttachment()
	 * @generated
	 */
	EAttribute getFormAttachment_Numerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getDenominator <em>Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Denominator</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getDenominator()
	 * @see #getFormAttachment()
	 * @generated
	 */
	EAttribute getFormAttachment_Denominator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getOffset()
	 * @see #getFormAttachment()
	 * @generated
	 */
	EAttribute getFormAttachment_Offset();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecore.EObject#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getControl()
	 * @see #getFormAttachment()
	 * @generated
	 */
	EReference getFormAttachment_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getAlignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getAlignment()
	 * @see #getFormAttachment()
	 * @generated
	 */
	EAttribute getFormAttachment_Alignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Row Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @model
	 * @generated
	 */
	EClass getRowLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getType()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#isCenter <em>Center</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Center</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#isCenter()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Center();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#isFill <em>Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#isFill()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Fill();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#isJustify <em>Justify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Justify</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#isJustify()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Justify();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#isPack <em>Pack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pack</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#isPack()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Pack();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#isWrap <em>Wrap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wrap</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#isWrap()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Wrap();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginWidth <em>Margin Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Width</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginWidth()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_MarginWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginHeight <em>Margin Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Height</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginHeight()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_MarginHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginTop <em>Margin Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Top</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginTop()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_MarginTop();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginLeft <em>Margin Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Left</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginLeft()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_MarginLeft();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginBottom <em>Margin Bottom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Bottom</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginBottom()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_MarginBottom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getMarginRight <em>Margin Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin Right</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getMarginRight()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_MarginRight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.layouts.Layout#getSpacing <em>Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spacing</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getSpacing()
	 * @see #getRowLayout()
	 * @generated
	 */
	EAttribute getRowLayout_Spacing();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayoutsFactory getLayoutsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.RowLayoutDataImpl <em>Row Layout Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.RowLayoutDataImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getRowLayoutData()
		 * @generated
		 */
		EClass ROW_LAYOUT_DATA = eINSTANCE.getRowLayoutData();

		/**
		 * The meta object literal for the '<em><b>Exclude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT_DATA__EXCLUDE = eINSTANCE.getRowLayoutData_Exclude();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.GridLayoutImpl <em>Grid Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.GridLayoutImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getGridLayout()
		 * @generated
		 */
		EClass GRID_LAYOUT = eINSTANCE.getGridLayout();

		/**
		 * The meta object literal for the '<em><b>Num Columns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__NUM_COLUMNS = eINSTANCE.getGridLayout_NumColumns();

		/**
		 * The meta object literal for the '<em><b>Make Columns Equal Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MAKE_COLUMNS_EQUAL_WIDTH = eINSTANCE.getGridLayout_MakeColumnsEqualWidth();

		/**
		 * The meta object literal for the '<em><b>Margin Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MARGIN_WIDTH = eINSTANCE.getGridLayout_MarginWidth();

		/**
		 * The meta object literal for the '<em><b>Margin Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MARGIN_HEIGHT = eINSTANCE.getGridLayout_MarginHeight();

		/**
		 * The meta object literal for the '<em><b>Margin Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MARGIN_LEFT = eINSTANCE.getGridLayout_MarginLeft();

		/**
		 * The meta object literal for the '<em><b>Margin Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MARGIN_TOP = eINSTANCE.getGridLayout_MarginTop();

		/**
		 * The meta object literal for the '<em><b>Margin Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MARGIN_RIGHT = eINSTANCE.getGridLayout_MarginRight();

		/**
		 * The meta object literal for the '<em><b>Margin Bottom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__MARGIN_BOTTOM = eINSTANCE.getGridLayout_MarginBottom();

		/**
		 * The meta object literal for the '<em><b>Horizontal Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__HORIZONTAL_SPACING = eINSTANCE.getGridLayout_HorizontalSpacing();

		/**
		 * The meta object literal for the '<em><b>Vertical Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT__VERTICAL_SPACING = eINSTANCE.getGridLayout_VerticalSpacing();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.GridLayoutDataImpl <em>Grid Layout Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.GridLayoutDataImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getGridLayoutData()
		 * @generated
		 */
		EClass GRID_LAYOUT_DATA = eINSTANCE.getGridLayoutData();

		/**
		 * The meta object literal for the '<em><b>Vertical Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__VERTICAL_ALIGNMENT = eINSTANCE.getGridLayoutData_VerticalAlignment();

		/**
		 * The meta object literal for the '<em><b>Horizontal Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__HORIZONTAL_ALIGNMENT = eINSTANCE.getGridLayoutData_HorizontalAlignment();

		/**
		 * The meta object literal for the '<em><b>Width Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__WIDTH_HINT = eINSTANCE.getGridLayoutData_WidthHint();

		/**
		 * The meta object literal for the '<em><b>Height Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__HEIGHT_HINT = eINSTANCE.getGridLayoutData_HeightHint();

		/**
		 * The meta object literal for the '<em><b>Horizontal Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__HORIZONTAL_INDENT = eINSTANCE.getGridLayoutData_HorizontalIndent();

		/**
		 * The meta object literal for the '<em><b>Vertical Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__VERTICAL_INDENT = eINSTANCE.getGridLayoutData_VerticalIndent();

		/**
		 * The meta object literal for the '<em><b>Horizontal Span</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__HORIZONTAL_SPAN = eINSTANCE.getGridLayoutData_HorizontalSpan();

		/**
		 * The meta object literal for the '<em><b>Vertical Span</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__VERTICAL_SPAN = eINSTANCE.getGridLayoutData_VerticalSpan();

		/**
		 * The meta object literal for the '<em><b>Grab Excess Horizontal Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__GRAB_EXCESS_HORIZONTAL_SPACE = eINSTANCE.getGridLayoutData_GrabExcessHorizontalSpace();

		/**
		 * The meta object literal for the '<em><b>Grab Excess Vertical Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__GRAB_EXCESS_VERTICAL_SPACE = eINSTANCE.getGridLayoutData_GrabExcessVerticalSpace();

		/**
		 * The meta object literal for the '<em><b>Minimum Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__MINIMUM_WIDTH = eINSTANCE.getGridLayoutData_MinimumWidth();

		/**
		 * The meta object literal for the '<em><b>Minimum Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__MINIMUM_HEIGHT = eINSTANCE.getGridLayoutData_MinimumHeight();

		/**
		 * The meta object literal for the '<em><b>Exclude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRID_LAYOUT_DATA__EXCLUDE = eINSTANCE.getGridLayoutData_Exclude();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FillLayoutImpl <em>Fill Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.FillLayoutImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFillLayout()
		 * @generated
		 */
		EClass FILL_LAYOUT = eINSTANCE.getFillLayout();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL_LAYOUT__TYPE = eINSTANCE.getFillLayout_Type();

		/**
		 * The meta object literal for the '<em><b>Margin Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL_LAYOUT__MARGIN_WIDTH = eINSTANCE.getFillLayout_MarginWidth();

		/**
		 * The meta object literal for the '<em><b>Margin Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL_LAYOUT__MARGIN_HEIGHT = eINSTANCE.getFillLayout_MarginHeight();

		/**
		 * The meta object literal for the '<em><b>Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL_LAYOUT__SPACING = eINSTANCE.getFillLayout_Spacing();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.StackLayoutImpl <em>Stack Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.StackLayoutImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getStackLayout()
		 * @generated
		 */
		EClass STACK_LAYOUT = eINSTANCE.getStackLayout();

		/**
		 * The meta object literal for the '<em><b>Margin Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_LAYOUT__MARGIN_WIDTH = eINSTANCE.getStackLayout_MarginWidth();

		/**
		 * The meta object literal for the '<em><b>Margin Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_LAYOUT__MARGIN_HEIGHT = eINSTANCE.getStackLayout_MarginHeight();

		/**
		 * The meta object literal for the '<em><b>Top Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_LAYOUT__TOP_CONTROL = eINSTANCE.getStackLayout_TopControl();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FormLayoutImpl <em>Form Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.FormLayoutImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFormLayout()
		 * @generated
		 */
		EClass FORM_LAYOUT = eINSTANCE.getFormLayout();

		/**
		 * The meta object literal for the '<em><b>Margin Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__MARGIN_WIDTH = eINSTANCE.getFormLayout_MarginWidth();

		/**
		 * The meta object literal for the '<em><b>Margin Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__MARGIN_HEIGHT = eINSTANCE.getFormLayout_MarginHeight();

		/**
		 * The meta object literal for the '<em><b>Margin Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__MARGIN_LEFT = eINSTANCE.getFormLayout_MarginLeft();

		/**
		 * The meta object literal for the '<em><b>Margin Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__MARGIN_TOP = eINSTANCE.getFormLayout_MarginTop();

		/**
		 * The meta object literal for the '<em><b>Margin Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__MARGIN_RIGHT = eINSTANCE.getFormLayout_MarginRight();

		/**
		 * The meta object literal for the '<em><b>Margin Bottom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__MARGIN_BOTTOM = eINSTANCE.getFormLayout_MarginBottom();

		/**
		 * The meta object literal for the '<em><b>Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_LAYOUT__SPACING = eINSTANCE.getFormLayout_Spacing();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FormLayoutDataImpl <em>Form Layout Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.FormLayoutDataImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFormLayoutData()
		 * @generated
		 */
		EClass FORM_LAYOUT_DATA = eINSTANCE.getFormLayoutData();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_LAYOUT_DATA__LEFT = eINSTANCE.getFormLayoutData_Left();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_LAYOUT_DATA__TOP = eINSTANCE.getFormLayoutData_Top();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_LAYOUT_DATA__RIGHT = eINSTANCE.getFormLayoutData_Right();

		/**
		 * The meta object literal for the '<em><b>Bottom</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_LAYOUT_DATA__BOTTOM = eINSTANCE.getFormLayoutData_Bottom();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.FormAttachmentImpl <em>Form Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.FormAttachmentImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getFormAttachment()
		 * @generated
		 */
		EClass FORM_ATTACHMENT = eINSTANCE.getFormAttachment();

		/**
		 * The meta object literal for the '<em><b>Numerator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_ATTACHMENT__NUMERATOR = eINSTANCE.getFormAttachment_Numerator();

		/**
		 * The meta object literal for the '<em><b>Denominator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_ATTACHMENT__DENOMINATOR = eINSTANCE.getFormAttachment_Denominator();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_ATTACHMENT__OFFSET = eINSTANCE.getFormAttachment_Offset();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_ATTACHMENT__CONTROL = eINSTANCE.getFormAttachment_Control();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_ATTACHMENT__ALIGNMENT = eINSTANCE.getFormAttachment_Alignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.layouts.impl.RowLayoutImpl <em>Row Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.layouts.impl.RowLayoutImpl
		 * @see org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl#getRowLayout()
		 * @generated
		 */
		EClass ROW_LAYOUT = eINSTANCE.getRowLayout();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__TYPE = eINSTANCE.getRowLayout_Type();

		/**
		 * The meta object literal for the '<em><b>Center</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__CENTER = eINSTANCE.getRowLayout_Center();

		/**
		 * The meta object literal for the '<em><b>Fill</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__FILL = eINSTANCE.getRowLayout_Fill();

		/**
		 * The meta object literal for the '<em><b>Justify</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__JUSTIFY = eINSTANCE.getRowLayout_Justify();

		/**
		 * The meta object literal for the '<em><b>Pack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__PACK = eINSTANCE.getRowLayout_Pack();

		/**
		 * The meta object literal for the '<em><b>Wrap</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__WRAP = eINSTANCE.getRowLayout_Wrap();

		/**
		 * The meta object literal for the '<em><b>Margin Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__MARGIN_WIDTH = eINSTANCE.getRowLayout_MarginWidth();

		/**
		 * The meta object literal for the '<em><b>Margin Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__MARGIN_HEIGHT = eINSTANCE.getRowLayout_MarginHeight();

		/**
		 * The meta object literal for the '<em><b>Margin Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__MARGIN_TOP = eINSTANCE.getRowLayout_MarginTop();

		/**
		 * The meta object literal for the '<em><b>Margin Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__MARGIN_LEFT = eINSTANCE.getRowLayout_MarginLeft();

		/**
		 * The meta object literal for the '<em><b>Margin Bottom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__MARGIN_BOTTOM = eINSTANCE.getRowLayout_MarginBottom();

		/**
		 * The meta object literal for the '<em><b>Margin Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__MARGIN_RIGHT = eINSTANCE.getRowLayout_MarginRight();

		/**
		 * The meta object literal for the '<em><b>Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_LAYOUT__SPACING = eINSTANCE.getRowLayout_Spacing();

	}

} //LayoutsPackage
