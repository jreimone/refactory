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
 * $Id: WidgetsPackage.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets;

import org.eclipse.e4.tm.styles.StylesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.e4.tm.widgets.WidgetsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/e4/swt.ecore javaPackage='org.eclipse.swt.widgets'"
 * @generated
 */
public interface WidgetsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "widgets";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/e4/tm/widgets.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tm.widgets";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WidgetsPackage eINSTANCE = org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ControlImpl <em>Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ControlImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getControl()
	 * @generated
	 */
	int CONTROL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__NAME = StylesPackage.STYLED__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__ROLE = StylesPackage.STYLED__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__STYLE = StylesPackage.STYLED__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__SCRIPT_SOURCE = StylesPackage.STYLED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__DATA_OBJECT = StylesPackage.STYLED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__COMPOSITE = StylesPackage.STYLED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__ENABLED = StylesPackage.STYLED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__VISIBLE = StylesPackage.STYLED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__LAYOUT_DATA = StylesPackage.STYLED_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FEATURE_COUNT = StylesPackage.STYLED_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.LabeledImpl <em>Labeled</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.LabeledImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getLabeled()
	 * @generated
	 */
	int LABELED = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Labeled</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.LabelImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__TEXT = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.TextImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__EDITABLE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modify</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__MODIFY = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key Up</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__KEY_UP = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TEXT = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ListImpl <em>List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ListImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getList()
	 * @generated
	 */
	int LIST = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Items</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__ITEMS = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__SELECTION_EVENT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selection Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__SELECTION_INDEX = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selection Indices</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__SELECTION_INDICES = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.SingleSelectionListImpl <em>Single Selection List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.SingleSelectionListImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getSingleSelectionList()
	 * @generated
	 */
	int SINGLE_SELECTION_LIST = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__NAME = LIST__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__ROLE = LIST__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__STYLE = LIST__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__SCRIPT_SOURCE = LIST__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__DATA_OBJECT = LIST__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__COMPOSITE = LIST__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__ENABLED = LIST__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__VISIBLE = LIST__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__LAYOUT_DATA = LIST__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Items</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__ITEMS = LIST__ITEMS;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__SELECTION_EVENT = LIST__SELECTION_EVENT;

	/**
	 * The feature id for the '<em><b>Selection Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__SELECTION_INDEX = LIST__SELECTION_INDEX;

	/**
	 * The feature id for the '<em><b>Selection Indices</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST__SELECTION_INDICES = LIST__SELECTION_INDICES;

	/**
	 * The number of structural features of the '<em>Single Selection List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_SELECTION_LIST_FEATURE_COUNT = LIST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ComboBoxImpl <em>Combo Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ComboBoxImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getComboBox()
	 * @generated
	 */
	int COMBO_BOX = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__NAME = LIST__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__ROLE = LIST__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__STYLE = LIST__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__SCRIPT_SOURCE = LIST__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__DATA_OBJECT = LIST__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__COMPOSITE = LIST__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__ENABLED = LIST__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__VISIBLE = LIST__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__LAYOUT_DATA = LIST__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Items</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__ITEMS = LIST__ITEMS;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__SELECTION_EVENT = LIST__SELECTION_EVENT;

	/**
	 * The feature id for the '<em><b>Selection Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__SELECTION_INDEX = LIST__SELECTION_INDEX;

	/**
	 * The feature id for the '<em><b>Selection Indices</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__SELECTION_INDICES = LIST__SELECTION_INDICES;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__EDITABLE = LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modify</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__MODIFY = LIST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key Up</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__KEY_UP = LIST_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX__TEXT = LIST_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Combo Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_BOX_FEATURE_COUNT = LIST_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.MultipleSelectionListImpl <em>Multiple Selection List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.MultipleSelectionListImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getMultipleSelectionList()
	 * @generated
	 */
	int MULTIPLE_SELECTION_LIST = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__NAME = LIST__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__ROLE = LIST__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__STYLE = LIST__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__SCRIPT_SOURCE = LIST__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__DATA_OBJECT = LIST__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__COMPOSITE = LIST__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__ENABLED = LIST__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__VISIBLE = LIST__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__LAYOUT_DATA = LIST__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Items</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__ITEMS = LIST__ITEMS;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__SELECTION_EVENT = LIST__SELECTION_EVENT;

	/**
	 * The feature id for the '<em><b>Selection Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__SELECTION_INDEX = LIST__SELECTION_INDEX;

	/**
	 * The feature id for the '<em><b>Selection Indices</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST__SELECTION_INDICES = LIST__SELECTION_INDICES;

	/**
	 * The number of structural features of the '<em>Multiple Selection List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_SELECTION_LIST_FEATURE_COUNT = LIST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.BrowserImpl <em>Browser</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.BrowserImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getBrowser()
	 * @generated
	 */
	int BROWSER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__LOCATION = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__URL = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__TEXT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Browser</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ButtonImpl <em>Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ButtonImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__TEXT = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__SELECTION_EVENT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.PushButtonImpl <em>Push Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.PushButtonImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getPushButton()
	 * @generated
	 */
	int PUSH_BUTTON = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__NAME = BUTTON__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__ROLE = BUTTON__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__STYLE = BUTTON__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__SCRIPT_SOURCE = BUTTON__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__DATA_OBJECT = BUTTON__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__COMPOSITE = BUTTON__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__ENABLED = BUTTON__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__VISIBLE = BUTTON__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__LAYOUT_DATA = BUTTON__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__TEXT = BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON__SELECTION_EVENT = BUTTON__SELECTION_EVENT;

	/**
	 * The number of structural features of the '<em>Push Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUTTON_FEATURE_COUNT = BUTTON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.CheckBoxImpl <em>Check Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.CheckBoxImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getCheckBox()
	 * @generated
	 */
	int CHECK_BOX = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__NAME = BUTTON__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__ROLE = BUTTON__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__STYLE = BUTTON__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__SCRIPT_SOURCE = BUTTON__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__DATA_OBJECT = BUTTON__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__COMPOSITE = BUTTON__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__ENABLED = BUTTON__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__VISIBLE = BUTTON__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__LAYOUT_DATA = BUTTON__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__TEXT = BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__SELECTION_EVENT = BUTTON__SELECTION_EVENT;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX__SELECTION = BUTTON_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_BOX_FEATURE_COUNT = BUTTON_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ToggleButtonImpl <em>Toggle Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ToggleButtonImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getToggleButton()
	 * @generated
	 */
	int TOGGLE_BUTTON = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__NAME = BUTTON__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__ROLE = BUTTON__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__STYLE = BUTTON__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__SCRIPT_SOURCE = BUTTON__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__DATA_OBJECT = BUTTON__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__COMPOSITE = BUTTON__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__ENABLED = BUTTON__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__VISIBLE = BUTTON__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__LAYOUT_DATA = BUTTON__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__TEXT = BUTTON__TEXT;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__SELECTION_EVENT = BUTTON__SELECTION_EVENT;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON__SELECTION = BUTTON_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Toggle Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOGGLE_BUTTON_FEATURE_COUNT = BUTTON_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl <em>Bounded Value Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getBoundedValueControl()
	 * @generated
	 */
	int BOUNDED_VALUE_CONTROL = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__MINIMUM = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__MAXIMUM = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__VALUE_EVENT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL__VALUE = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bounded Value Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_VALUE_CONTROL_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl <em>Abstract Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getAbstractComposite()
	 * @generated
	 */
	int ABSTRACT_COMPOSITE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__NAME = CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__ROLE = CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__STYLE = CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__SCRIPT_SOURCE = CONTROL__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__DATA_OBJECT = CONTROL__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__COMPOSITE = CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__ENABLED = CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__VISIBLE = CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__LAYOUT_DATA = CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__CONTROLS = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__STYLES = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE__LAYOUT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.CompositeImpl <em>Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.CompositeImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__NAME = ABSTRACT_COMPOSITE__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__ROLE = ABSTRACT_COMPOSITE__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__STYLE = ABSTRACT_COMPOSITE__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__SCRIPT_SOURCE = ABSTRACT_COMPOSITE__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__DATA_OBJECT = ABSTRACT_COMPOSITE__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__COMPOSITE = ABSTRACT_COMPOSITE__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__ENABLED = ABSTRACT_COMPOSITE__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__VISIBLE = ABSTRACT_COMPOSITE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__LAYOUT_DATA = ABSTRACT_COMPOSITE__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__CONTROLS = ABSTRACT_COMPOSITE__CONTROLS;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__STYLES = ABSTRACT_COMPOSITE__STYLES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__LAYOUT = ABSTRACT_COMPOSITE__LAYOUT;

	/**
	 * The number of structural features of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FEATURE_COUNT = ABSTRACT_COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.GroupBoxImpl <em>Group Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.GroupBoxImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getGroupBox()
	 * @generated
	 */
	int GROUP_BOX = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__NAME = ABSTRACT_COMPOSITE__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__ROLE = ABSTRACT_COMPOSITE__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__STYLE = ABSTRACT_COMPOSITE__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__SCRIPT_SOURCE = ABSTRACT_COMPOSITE__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__DATA_OBJECT = ABSTRACT_COMPOSITE__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__COMPOSITE = ABSTRACT_COMPOSITE__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__ENABLED = ABSTRACT_COMPOSITE__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__VISIBLE = ABSTRACT_COMPOSITE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__LAYOUT_DATA = ABSTRACT_COMPOSITE__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__CONTROLS = ABSTRACT_COMPOSITE__CONTROLS;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__STYLES = ABSTRACT_COMPOSITE__STYLES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__LAYOUT = ABSTRACT_COMPOSITE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX__TEXT = ABSTRACT_COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Group Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_BOX_FEATURE_COUNT = ABSTRACT_COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.TabFolderImpl <em>Tab Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.TabFolderImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getTabFolder()
	 * @generated
	 */
	int TAB_FOLDER = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__NAME = ABSTRACT_COMPOSITE__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__ROLE = ABSTRACT_COMPOSITE__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__STYLE = ABSTRACT_COMPOSITE__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__SCRIPT_SOURCE = ABSTRACT_COMPOSITE__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__DATA_OBJECT = ABSTRACT_COMPOSITE__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__COMPOSITE = ABSTRACT_COMPOSITE__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__ENABLED = ABSTRACT_COMPOSITE__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__VISIBLE = ABSTRACT_COMPOSITE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__LAYOUT_DATA = ABSTRACT_COMPOSITE__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__CONTROLS = ABSTRACT_COMPOSITE__CONTROLS;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__STYLES = ABSTRACT_COMPOSITE__STYLES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__LAYOUT = ABSTRACT_COMPOSITE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Selection Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__SELECTION_EVENT = ABSTRACT_COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selection Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__SELECTION_INDEX = ABSTRACT_COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tab Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER_FEATURE_COUNT = ABSTRACT_COMPOSITE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.TabImpl <em>Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.TabImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getTab()
	 * @generated
	 */
	int TAB = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__NAME = COMPOSITE__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__ROLE = COMPOSITE__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__STYLE = COMPOSITE__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__SCRIPT_SOURCE = COMPOSITE__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__DATA_OBJECT = COMPOSITE__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__COMPOSITE = COMPOSITE__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__ENABLED = COMPOSITE__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__VISIBLE = COMPOSITE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__LAYOUT_DATA = COMPOSITE__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__CONTROLS = COMPOSITE__CONTROLS;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__STYLES = COMPOSITE__STYLES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__LAYOUT = COMPOSITE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__TEXT = COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FEATURE_COUNT = COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ShellImpl <em>Shell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ShellImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getShell()
	 * @generated
	 */
	int SHELL = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__NAME = ABSTRACT_COMPOSITE__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__ROLE = ABSTRACT_COMPOSITE__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__STYLE = ABSTRACT_COMPOSITE__STYLE;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__SCRIPT_SOURCE = ABSTRACT_COMPOSITE__SCRIPT_SOURCE;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__DATA_OBJECT = ABSTRACT_COMPOSITE__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__COMPOSITE = ABSTRACT_COMPOSITE__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__ENABLED = ABSTRACT_COMPOSITE__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__VISIBLE = ABSTRACT_COMPOSITE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__LAYOUT_DATA = ABSTRACT_COMPOSITE__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__CONTROLS = ABSTRACT_COMPOSITE__CONTROLS;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__STYLES = ABSTRACT_COMPOSITE__STYLES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL__LAYOUT = ABSTRACT_COMPOSITE__LAYOUT;

	/**
	 * The number of structural features of the '<em>Shell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_FEATURE_COUNT = ABSTRACT_COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.widgets.impl.ScriptedImpl <em>Scripted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.widgets.impl.ScriptedImpl
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getScripted()
	 * @generated
	 */
	int SCRIPTED = 20;

	/**
	 * The feature id for the '<em><b>Script Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPTED__SCRIPT_SOURCE = 0;

	/**
	 * The number of structural features of the '<em>Scripted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPTED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>Runtime Event</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getRuntimeEvent()
	 * @generated
	 */
	int RUNTIME_EVENT = 21;


	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Control <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control</em>'.
	 * @see org.eclipse.e4.tm.widgets.Control
	 * @generated
	 */
	EClass getControl();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.e4.tm.widgets.Control#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Composite</em>'.
	 * @see org.eclipse.e4.tm.widgets.Control#getComposite()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_Composite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Control#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.e4.tm.widgets.Control#isEnabled()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Control#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see org.eclipse.e4.tm.widgets.Control#isVisible()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_Visible();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.widgets.Control#getLayoutData <em>Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout Data</em>'.
	 * @see org.eclipse.e4.tm.widgets.Control#getLayoutData()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_LayoutData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Control#getDataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Object</em>'.
	 * @see org.eclipse.e4.tm.widgets.Control#getDataObject()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_DataObject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Labeled <em>Labeled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled</em>'.
	 * @see org.eclipse.e4.tm.widgets.Labeled
	 * @generated
	 */
	EClass getLabeled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Labeled#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.e4.tm.widgets.Labeled#getText()
	 * @see #getLabeled()
	 * @generated
	 */
	EAttribute getLabeled_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.eclipse.e4.tm.widgets.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.eclipse.e4.tm.widgets.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Text#isEditable <em>Editable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editable</em>'.
	 * @see org.eclipse.e4.tm.widgets.Text#isEditable()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Editable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Text#getModify <em>Modify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modify</em>'.
	 * @see org.eclipse.e4.tm.widgets.Text#getModify()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Modify();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Text#getKeyUp <em>Key Up</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Up</em>'.
	 * @see org.eclipse.e4.tm.widgets.Text#getKeyUp()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_KeyUp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Text#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.e4.tm.widgets.Text#getText()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List</em>'.
	 * @see org.eclipse.e4.tm.widgets.List
	 * @generated
	 */
	EClass getList();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.e4.tm.widgets.List#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Items</em>'.
	 * @see org.eclipse.e4.tm.widgets.List#getItems()
	 * @see #getList()
	 * @generated
	 */
	EAttribute getList_Items();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.List#getSelectionEvent <em>Selection Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Event</em>'.
	 * @see org.eclipse.e4.tm.widgets.List#getSelectionEvent()
	 * @see #getList()
	 * @generated
	 */
	EAttribute getList_SelectionEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.List#getSelectionIndex <em>Selection Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Index</em>'.
	 * @see org.eclipse.e4.tm.widgets.List#getSelectionIndex()
	 * @see #getList()
	 * @generated
	 */
	EAttribute getList_SelectionIndex();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.e4.tm.widgets.List#getSelectionIndices <em>Selection Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Selection Indices</em>'.
	 * @see org.eclipse.e4.tm.widgets.List#getSelectionIndices()
	 * @see #getList()
	 * @generated
	 */
	EAttribute getList_SelectionIndices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.SingleSelectionList <em>Single Selection List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Selection List</em>'.
	 * @see org.eclipse.e4.tm.widgets.SingleSelectionList
	 * @generated
	 */
	EClass getSingleSelectionList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.ComboBox <em>Combo Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combo Box</em>'.
	 * @see org.eclipse.e4.tm.widgets.ComboBox
	 * @generated
	 */
	EClass getComboBox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.MultipleSelectionList <em>Multiple Selection List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Selection List</em>'.
	 * @see org.eclipse.e4.tm.widgets.MultipleSelectionList
	 * @generated
	 */
	EClass getMultipleSelectionList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Browser <em>Browser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Browser</em>'.
	 * @see org.eclipse.e4.tm.widgets.Browser
	 * @generated
	 */
	EClass getBrowser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Browser#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.e4.tm.widgets.Browser#getLocation()
	 * @see #getBrowser()
	 * @generated
	 */
	EAttribute getBrowser_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Browser#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.e4.tm.widgets.Browser#getUrl()
	 * @see #getBrowser()
	 * @generated
	 */
	EAttribute getBrowser_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Browser#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.e4.tm.widgets.Browser#getText()
	 * @see #getBrowser()
	 * @generated
	 */
	EAttribute getBrowser_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see org.eclipse.e4.tm.widgets.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Button#getSelectionEvent <em>Selection Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Event</em>'.
	 * @see org.eclipse.e4.tm.widgets.Button#getSelectionEvent()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_SelectionEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.PushButton <em>Push Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Button</em>'.
	 * @see org.eclipse.e4.tm.widgets.PushButton
	 * @generated
	 */
	EClass getPushButton();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.CheckBox <em>Check Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Box</em>'.
	 * @see org.eclipse.e4.tm.widgets.CheckBox
	 * @generated
	 */
	EClass getCheckBox();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.CheckBox#isSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.eclipse.e4.tm.widgets.CheckBox#isSelection()
	 * @see #getCheckBox()
	 * @generated
	 */
	EAttribute getCheckBox_Selection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.ToggleButton <em>Toggle Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Toggle Button</em>'.
	 * @see org.eclipse.e4.tm.widgets.ToggleButton
	 * @generated
	 */
	EClass getToggleButton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.ToggleButton#isSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.eclipse.e4.tm.widgets.ToggleButton#isSelection()
	 * @see #getToggleButton()
	 * @generated
	 */
	EAttribute getToggleButton_Selection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.BoundedValueControl <em>Bounded Value Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Value Control</em>'.
	 * @see org.eclipse.e4.tm.widgets.BoundedValueControl
	 * @generated
	 */
	EClass getBoundedValueControl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see org.eclipse.e4.tm.widgets.BoundedValueControl#getMinimum()
	 * @see #getBoundedValueControl()
	 * @generated
	 */
	EAttribute getBoundedValueControl_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see org.eclipse.e4.tm.widgets.BoundedValueControl#getMaximum()
	 * @see #getBoundedValueControl()
	 * @generated
	 */
	EAttribute getBoundedValueControl_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getValueEvent <em>Value Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Event</em>'.
	 * @see org.eclipse.e4.tm.widgets.BoundedValueControl#getValueEvent()
	 * @see #getBoundedValueControl()
	 * @generated
	 */
	EAttribute getBoundedValueControl_ValueEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.e4.tm.widgets.BoundedValueControl#getValue()
	 * @see #getBoundedValueControl()
	 * @generated
	 */
	EAttribute getBoundedValueControl_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.AbstractComposite <em>Abstract Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Composite</em>'.
	 * @see org.eclipse.e4.tm.widgets.AbstractComposite
	 * @generated
	 */
	EClass getAbstractComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.e4.tm.widgets.AbstractComposite#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.eclipse.e4.tm.widgets.AbstractComposite#getControls()
	 * @see #getAbstractComposite()
	 * @generated
	 */
	EReference getAbstractComposite_Controls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.e4.tm.widgets.AbstractComposite#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Styles</em>'.
	 * @see org.eclipse.e4.tm.widgets.AbstractComposite#getStyles()
	 * @see #getAbstractComposite()
	 * @generated
	 */
	EReference getAbstractComposite_Styles();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.widgets.AbstractComposite#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.e4.tm.widgets.AbstractComposite#getLayout()
	 * @see #getAbstractComposite()
	 * @generated
	 */
	EReference getAbstractComposite_Layout();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see org.eclipse.e4.tm.widgets.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.GroupBox <em>Group Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Box</em>'.
	 * @see org.eclipse.e4.tm.widgets.GroupBox
	 * @generated
	 */
	EClass getGroupBox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.TabFolder <em>Tab Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab Folder</em>'.
	 * @see org.eclipse.e4.tm.widgets.TabFolder
	 * @generated
	 */
	EClass getTabFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.TabFolder#getSelectionEvent <em>Selection Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Event</em>'.
	 * @see org.eclipse.e4.tm.widgets.TabFolder#getSelectionEvent()
	 * @see #getTabFolder()
	 * @generated
	 */
	EAttribute getTabFolder_SelectionEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.TabFolder#getSelectionIndex <em>Selection Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Index</em>'.
	 * @see org.eclipse.e4.tm.widgets.TabFolder#getSelectionIndex()
	 * @see #getTabFolder()
	 * @generated
	 */
	EAttribute getTabFolder_SelectionIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Tab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab</em>'.
	 * @see org.eclipse.e4.tm.widgets.Tab
	 * @generated
	 */
	EClass getTab();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Shell <em>Shell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shell</em>'.
	 * @see org.eclipse.e4.tm.widgets.Shell
	 * @generated
	 */
	EClass getShell();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.widgets.Scripted <em>Scripted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scripted</em>'.
	 * @see org.eclipse.e4.tm.widgets.Scripted
	 * @generated
	 */
	EClass getScripted();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.e4.tm.widgets.Scripted#getScriptSource <em>Script Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Source</em>'.
	 * @see org.eclipse.e4.tm.widgets.Scripted#getScriptSource()
	 * @see #getScripted()
	 * @generated
	 */
	EAttribute getScripted_ScriptSource();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Runtime Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Runtime Event</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getRuntimeEvent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WidgetsFactory getWidgetsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ControlImpl <em>Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ControlImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getControl()
		 * @generated
		 */
		EClass CONTROL = eINSTANCE.getControl();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__COMPOSITE = eINSTANCE.getControl_Composite();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__ENABLED = eINSTANCE.getControl_Enabled();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__VISIBLE = eINSTANCE.getControl_Visible();

		/**
		 * The meta object literal for the '<em><b>Layout Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__LAYOUT_DATA = eINSTANCE.getControl_LayoutData();

		/**
		 * The meta object literal for the '<em><b>Data Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__DATA_OBJECT = eINSTANCE.getControl_DataObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.LabeledImpl <em>Labeled</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.LabeledImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getLabeled()
		 * @generated
		 */
		EClass LABELED = eINSTANCE.getLabeled();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED__TEXT = eINSTANCE.getLabeled_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.LabelImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.TextImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Editable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__EDITABLE = eINSTANCE.getText_Editable();

		/**
		 * The meta object literal for the '<em><b>Modify</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__MODIFY = eINSTANCE.getText_Modify();

		/**
		 * The meta object literal for the '<em><b>Key Up</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__KEY_UP = eINSTANCE.getText_KeyUp();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__TEXT = eINSTANCE.getText_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ListImpl <em>List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ListImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getList()
		 * @generated
		 */
		EClass LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST__ITEMS = eINSTANCE.getList_Items();

		/**
		 * The meta object literal for the '<em><b>Selection Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST__SELECTION_EVENT = eINSTANCE.getList_SelectionEvent();

		/**
		 * The meta object literal for the '<em><b>Selection Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST__SELECTION_INDEX = eINSTANCE.getList_SelectionIndex();

		/**
		 * The meta object literal for the '<em><b>Selection Indices</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST__SELECTION_INDICES = eINSTANCE.getList_SelectionIndices();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.SingleSelectionListImpl <em>Single Selection List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.SingleSelectionListImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getSingleSelectionList()
		 * @generated
		 */
		EClass SINGLE_SELECTION_LIST = eINSTANCE.getSingleSelectionList();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ComboBoxImpl <em>Combo Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ComboBoxImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getComboBox()
		 * @generated
		 */
		EClass COMBO_BOX = eINSTANCE.getComboBox();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.MultipleSelectionListImpl <em>Multiple Selection List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.MultipleSelectionListImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getMultipleSelectionList()
		 * @generated
		 */
		EClass MULTIPLE_SELECTION_LIST = eINSTANCE.getMultipleSelectionList();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.BrowserImpl <em>Browser</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.BrowserImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getBrowser()
		 * @generated
		 */
		EClass BROWSER = eINSTANCE.getBrowser();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BROWSER__LOCATION = eINSTANCE.getBrowser_Location();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BROWSER__URL = eINSTANCE.getBrowser_Url();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BROWSER__TEXT = eINSTANCE.getBrowser_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ButtonImpl <em>Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ButtonImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '<em><b>Selection Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__SELECTION_EVENT = eINSTANCE.getButton_SelectionEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.PushButtonImpl <em>Push Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.PushButtonImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getPushButton()
		 * @generated
		 */
		EClass PUSH_BUTTON = eINSTANCE.getPushButton();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.CheckBoxImpl <em>Check Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.CheckBoxImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getCheckBox()
		 * @generated
		 */
		EClass CHECK_BOX = eINSTANCE.getCheckBox();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_BOX__SELECTION = eINSTANCE.getCheckBox_Selection();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ToggleButtonImpl <em>Toggle Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ToggleButtonImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getToggleButton()
		 * @generated
		 */
		EClass TOGGLE_BUTTON = eINSTANCE.getToggleButton();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOGGLE_BUTTON__SELECTION = eINSTANCE.getToggleButton_Selection();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl <em>Bounded Value Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getBoundedValueControl()
		 * @generated
		 */
		EClass BOUNDED_VALUE_CONTROL = eINSTANCE.getBoundedValueControl();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_VALUE_CONTROL__MINIMUM = eINSTANCE.getBoundedValueControl_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_VALUE_CONTROL__MAXIMUM = eINSTANCE.getBoundedValueControl_Maximum();

		/**
		 * The meta object literal for the '<em><b>Value Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_VALUE_CONTROL__VALUE_EVENT = eINSTANCE.getBoundedValueControl_ValueEvent();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_VALUE_CONTROL__VALUE = eINSTANCE.getBoundedValueControl_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl <em>Abstract Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getAbstractComposite()
		 * @generated
		 */
		EClass ABSTRACT_COMPOSITE = eINSTANCE.getAbstractComposite();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPOSITE__CONTROLS = eINSTANCE.getAbstractComposite_Controls();

		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPOSITE__STYLES = eINSTANCE.getAbstractComposite_Styles();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPOSITE__LAYOUT = eINSTANCE.getAbstractComposite_Layout();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.CompositeImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getComposite()
		 * @generated
		 */
		EClass COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.GroupBoxImpl <em>Group Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.GroupBoxImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getGroupBox()
		 * @generated
		 */
		EClass GROUP_BOX = eINSTANCE.getGroupBox();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.TabFolderImpl <em>Tab Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.TabFolderImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getTabFolder()
		 * @generated
		 */
		EClass TAB_FOLDER = eINSTANCE.getTabFolder();

		/**
		 * The meta object literal for the '<em><b>Selection Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB_FOLDER__SELECTION_EVENT = eINSTANCE.getTabFolder_SelectionEvent();

		/**
		 * The meta object literal for the '<em><b>Selection Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB_FOLDER__SELECTION_INDEX = eINSTANCE.getTabFolder_SelectionIndex();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.TabImpl <em>Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.TabImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getTab()
		 * @generated
		 */
		EClass TAB = eINSTANCE.getTab();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ShellImpl <em>Shell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ShellImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getShell()
		 * @generated
		 */
		EClass SHELL = eINSTANCE.getShell();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.widgets.impl.ScriptedImpl <em>Scripted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.widgets.impl.ScriptedImpl
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getScripted()
		 * @generated
		 */
		EClass SCRIPTED = eINSTANCE.getScripted();

		/**
		 * The meta object literal for the '<em><b>Script Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPTED__SCRIPT_SOURCE = eINSTANCE.getScripted_ScriptSource();

		/**
		 * The meta object literal for the '<em>Runtime Event</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl#getRuntimeEvent()
		 * @generated
		 */
		EDataType RUNTIME_EVENT = eINSTANCE.getRuntimeEvent();

	}

} //WidgetsPackage
