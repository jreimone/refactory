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
 * $Id: LayoutsPackageImpl.java,v 1.2 2009/05/07 15:10:42 pwebster Exp $
 */
package org.eclipse.e4.tm.swt.layouts.impl;

import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.styles.StylesPackage;
import org.eclipse.e4.tm.swt.layouts.LayoutsFactory;
import org.eclipse.e4.tm.swt.layouts.LayoutsPackage;
import org.eclipse.e4.tm.swt.styles.impl.StylesPackageImpl;
import org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl;
import org.eclipse.e4.tm.widgets.WidgetsPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayoutsPackageImpl extends EPackageImpl implements LayoutsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rowLayoutDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gridLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gridLayoutDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fillLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formLayoutDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rowLayoutEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.e4.tm.swt.layouts.LayoutsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LayoutsPackageImpl() {
		super(eNS_URI, LayoutsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LayoutsPackage init() {
		if (isInited) return (LayoutsPackage)EPackage.Registry.INSTANCE.getEPackage(LayoutsPackage.eNS_URI);

		// Obtain or create and register package
		LayoutsPackageImpl theLayoutsPackage = (LayoutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof LayoutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new LayoutsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WidgetsPackage.eINSTANCE.eClass();
		StylesPackage.eINSTANCE.eClass();
		org.eclipse.e4.tm.layouts.LayoutsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StylesPackageImpl theStylesPackage_1 = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.styles.StylesPackage.eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.styles.StylesPackage.eNS_URI) : org.eclipse.e4.tm.swt.styles.StylesPackage.eINSTANCE);
		WidgetsPackageImpl theWidgetsPackage_1 = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.widgets.WidgetsPackage.eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.widgets.WidgetsPackage.eNS_URI) : org.eclipse.e4.tm.swt.widgets.WidgetsPackage.eINSTANCE);

		// Create package meta-data objects
		theLayoutsPackage.createPackageContents();
		theStylesPackage_1.createPackageContents();
		theWidgetsPackage_1.createPackageContents();

		// Initialize created meta-data
		theLayoutsPackage.initializePackageContents();
		theStylesPackage_1.initializePackageContents();
		theWidgetsPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLayoutsPackage.freeze();

		return theLayoutsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRowLayoutData() {
		return rowLayoutDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayoutData_Exclude() {
		return (EAttribute)rowLayoutDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGridLayout() {
		return gridLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_NumColumns() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MakeColumnsEqualWidth() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MarginWidth() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MarginHeight() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MarginLeft() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MarginTop() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MarginRight() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_MarginBottom() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_HorizontalSpacing() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayout_VerticalSpacing() {
		return (EAttribute)gridLayoutEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGridLayoutData() {
		return gridLayoutDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_VerticalAlignment() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_HorizontalAlignment() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_WidthHint() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_HeightHint() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_HorizontalIndent() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_VerticalIndent() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_HorizontalSpan() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_VerticalSpan() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_GrabExcessHorizontalSpace() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_GrabExcessVerticalSpace() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_MinimumWidth() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_MinimumHeight() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGridLayoutData_Exclude() {
		return (EAttribute)gridLayoutDataEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFillLayout() {
		return fillLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFillLayout_Type() {
		return (EAttribute)fillLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFillLayout_MarginWidth() {
		return (EAttribute)fillLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFillLayout_MarginHeight() {
		return (EAttribute)fillLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFillLayout_Spacing() {
		return (EAttribute)fillLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackLayout() {
		return stackLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackLayout_MarginWidth() {
		return (EAttribute)stackLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackLayout_MarginHeight() {
		return (EAttribute)stackLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackLayout_TopControl() {
		return (EReference)stackLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormLayout() {
		return formLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_MarginWidth() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_MarginHeight() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_MarginLeft() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_MarginTop() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_MarginRight() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_MarginBottom() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormLayout_Spacing() {
		return (EAttribute)formLayoutEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormLayoutData() {
		return formLayoutDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormLayoutData_Left() {
		return (EReference)formLayoutDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormLayoutData_Top() {
		return (EReference)formLayoutDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormLayoutData_Right() {
		return (EReference)formLayoutDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormLayoutData_Bottom() {
		return (EReference)formLayoutDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormAttachment() {
		return formAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormAttachment_Numerator() {
		return (EAttribute)formAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormAttachment_Denominator() {
		return (EAttribute)formAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormAttachment_Offset() {
		return (EAttribute)formAttachmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormAttachment_Control() {
		return (EReference)formAttachmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormAttachment_Alignment() {
		return (EAttribute)formAttachmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRowLayout() {
		return rowLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Type() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Center() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Fill() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Justify() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Pack() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Wrap() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_MarginWidth() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_MarginHeight() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_MarginTop() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_MarginLeft() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_MarginBottom() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_MarginRight() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRowLayout_Spacing() {
		return (EAttribute)rowLayoutEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsFactory getLayoutsFactory() {
		return (LayoutsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rowLayoutEClass = createEClass(ROW_LAYOUT);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__TYPE);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__CENTER);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__FILL);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__JUSTIFY);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__PACK);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__WRAP);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__MARGIN_WIDTH);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__MARGIN_HEIGHT);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__SPACING);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__MARGIN_LEFT);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__MARGIN_TOP);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__MARGIN_RIGHT);
		createEAttribute(rowLayoutEClass, ROW_LAYOUT__MARGIN_BOTTOM);

		rowLayoutDataEClass = createEClass(ROW_LAYOUT_DATA);
		createEAttribute(rowLayoutDataEClass, ROW_LAYOUT_DATA__EXCLUDE);

		gridLayoutEClass = createEClass(GRID_LAYOUT);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__NUM_COLUMNS);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MAKE_COLUMNS_EQUAL_WIDTH);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MARGIN_WIDTH);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MARGIN_HEIGHT);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MARGIN_LEFT);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MARGIN_TOP);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MARGIN_RIGHT);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__MARGIN_BOTTOM);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__HORIZONTAL_SPACING);
		createEAttribute(gridLayoutEClass, GRID_LAYOUT__VERTICAL_SPACING);

		gridLayoutDataEClass = createEClass(GRID_LAYOUT_DATA);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__VERTICAL_ALIGNMENT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__HORIZONTAL_ALIGNMENT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__WIDTH_HINT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__HEIGHT_HINT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__HORIZONTAL_INDENT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__VERTICAL_INDENT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__HORIZONTAL_SPAN);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__VERTICAL_SPAN);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__GRAB_EXCESS_HORIZONTAL_SPACE);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__GRAB_EXCESS_VERTICAL_SPACE);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__MINIMUM_WIDTH);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__MINIMUM_HEIGHT);
		createEAttribute(gridLayoutDataEClass, GRID_LAYOUT_DATA__EXCLUDE);

		fillLayoutEClass = createEClass(FILL_LAYOUT);
		createEAttribute(fillLayoutEClass, FILL_LAYOUT__TYPE);
		createEAttribute(fillLayoutEClass, FILL_LAYOUT__MARGIN_WIDTH);
		createEAttribute(fillLayoutEClass, FILL_LAYOUT__MARGIN_HEIGHT);
		createEAttribute(fillLayoutEClass, FILL_LAYOUT__SPACING);

		stackLayoutEClass = createEClass(STACK_LAYOUT);
		createEAttribute(stackLayoutEClass, STACK_LAYOUT__MARGIN_WIDTH);
		createEAttribute(stackLayoutEClass, STACK_LAYOUT__MARGIN_HEIGHT);
		createEReference(stackLayoutEClass, STACK_LAYOUT__TOP_CONTROL);

		formLayoutEClass = createEClass(FORM_LAYOUT);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__MARGIN_WIDTH);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__MARGIN_HEIGHT);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__MARGIN_LEFT);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__MARGIN_TOP);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__MARGIN_RIGHT);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__MARGIN_BOTTOM);
		createEAttribute(formLayoutEClass, FORM_LAYOUT__SPACING);

		formLayoutDataEClass = createEClass(FORM_LAYOUT_DATA);
		createEReference(formLayoutDataEClass, FORM_LAYOUT_DATA__LEFT);
		createEReference(formLayoutDataEClass, FORM_LAYOUT_DATA__TOP);
		createEReference(formLayoutDataEClass, FORM_LAYOUT_DATA__RIGHT);
		createEReference(formLayoutDataEClass, FORM_LAYOUT_DATA__BOTTOM);

		formAttachmentEClass = createEClass(FORM_ATTACHMENT);
		createEAttribute(formAttachmentEClass, FORM_ATTACHMENT__NUMERATOR);
		createEAttribute(formAttachmentEClass, FORM_ATTACHMENT__DENOMINATOR);
		createEAttribute(formAttachmentEClass, FORM_ATTACHMENT__OFFSET);
		createEReference(formAttachmentEClass, FORM_ATTACHMENT__CONTROL);
		createEAttribute(formAttachmentEClass, FORM_ATTACHMENT__ALIGNMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		org.eclipse.e4.tm.layouts.LayoutsPackage theLayoutsPackage_1 = (org.eclipse.e4.tm.layouts.LayoutsPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.layouts.LayoutsPackage.eNS_URI);
		org.eclipse.e4.tm.swt.styles.StylesPackage theStylesPackage_1 = (org.eclipse.e4.tm.swt.styles.StylesPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.styles.StylesPackage.eNS_URI);
		WidgetsPackage theWidgetsPackage = (WidgetsPackage)EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theLayoutsPackage_1.getLayout());
		EGenericType g2 = createEGenericType(this.getRowLayoutData());
		g1.getETypeArguments().add(g2);
		rowLayoutEClass.getEGenericSuperTypes().add(g1);
		rowLayoutDataEClass.getESuperTypes().add(theLayoutsPackage_1.getLayoutData());
		rowLayoutDataEClass.getESuperTypes().add(theLayoutsPackage_1.getDimension());
		g1 = createEGenericType(theLayoutsPackage_1.getLayout());
		g2 = createEGenericType(this.getGridLayoutData());
		g1.getETypeArguments().add(g2);
		gridLayoutEClass.getEGenericSuperTypes().add(g1);
		gridLayoutDataEClass.getESuperTypes().add(theLayoutsPackage_1.getLayoutData());
		fillLayoutEClass.getESuperTypes().add(theLayoutsPackage_1.getLayout());
		stackLayoutEClass.getESuperTypes().add(theLayoutsPackage_1.getLayout());
		g1 = createEGenericType(theLayoutsPackage_1.getLayout());
		g2 = createEGenericType(this.getFormLayoutData());
		g1.getETypeArguments().add(g2);
		formLayoutEClass.getEGenericSuperTypes().add(g1);
		formLayoutDataEClass.getESuperTypes().add(theLayoutsPackage_1.getLayoutData());
		formLayoutDataEClass.getESuperTypes().add(theLayoutsPackage_1.getDimension());

		// Initialize classes and features; add operations and parameters
		initEClass(rowLayoutEClass, null, "RowLayout", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRowLayout_Type(), theStylesPackage_1.getSwtConstant(), "type", "HORIZONTAL", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_Center(), ecorePackage.getEBoolean(), "center", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_Fill(), ecorePackage.getEBoolean(), "fill", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_Justify(), ecorePackage.getEBoolean(), "justify", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_Pack(), ecorePackage.getEBoolean(), "pack", "true", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_Wrap(), ecorePackage.getEBoolean(), "wrap", "true", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_MarginWidth(), ecorePackage.getEInt(), "marginWidth", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_MarginHeight(), ecorePackage.getEInt(), "marginHeight", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_Spacing(), ecorePackage.getEInt(), "spacing", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_MarginLeft(), ecorePackage.getEInt(), "marginLeft", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_MarginTop(), ecorePackage.getEInt(), "marginTop", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_MarginRight(), ecorePackage.getEInt(), "marginRight", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRowLayout_MarginBottom(), ecorePackage.getEInt(), "marginBottom", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rowLayoutDataEClass, null, "RowLayoutData", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRowLayoutData_Exclude(), ecorePackage.getEBoolean(), "exclude", null, 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gridLayoutEClass, null, "GridLayout", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGridLayout_NumColumns(), ecorePackage.getEInt(), "numColumns", "1", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MakeColumnsEqualWidth(), ecorePackage.getEBoolean(), "makeColumnsEqualWidth", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MarginWidth(), ecorePackage.getEInt(), "marginWidth", "5", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MarginHeight(), ecorePackage.getEInt(), "marginHeight", "5", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MarginLeft(), ecorePackage.getEInt(), "marginLeft", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MarginTop(), ecorePackage.getEInt(), "marginTop", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MarginRight(), ecorePackage.getEInt(), "marginRight", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_MarginBottom(), ecorePackage.getEInt(), "marginBottom", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_HorizontalSpacing(), ecorePackage.getEInt(), "horizontalSpacing", "5", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayout_VerticalSpacing(), ecorePackage.getEInt(), "verticalSpacing", "5", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gridLayoutDataEClass, null, "GridLayoutData", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGridLayoutData_VerticalAlignment(), theStylesPackage_1.getSwtConstant(), "verticalAlignment", "CENTER", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_HorizontalAlignment(), theStylesPackage_1.getSwtConstant(), "horizontalAlignment", "CENTER", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_WidthHint(), ecorePackage.getEInt(), "widthHint", "-1", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_HeightHint(), ecorePackage.getEInt(), "heightHint", "-1", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_HorizontalIndent(), ecorePackage.getEInt(), "horizontalIndent", "0", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_VerticalIndent(), ecorePackage.getEInt(), "verticalIndent", "0", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_HorizontalSpan(), ecorePackage.getEInt(), "horizontalSpan", "1", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_VerticalSpan(), ecorePackage.getEInt(), "verticalSpan", "1", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_GrabExcessHorizontalSpace(), ecorePackage.getEBoolean(), "grabExcessHorizontalSpace", "false", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_GrabExcessVerticalSpace(), ecorePackage.getEBoolean(), "grabExcessVerticalSpace", "false", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_MinimumWidth(), ecorePackage.getEInt(), "minimumWidth", "0", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_MinimumHeight(), ecorePackage.getEInt(), "minimumHeight", "0", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridLayoutData_Exclude(), ecorePackage.getEBoolean(), "exclude", "false", 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fillLayoutEClass, null, "FillLayout", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFillLayout_Type(), theStylesPackage_1.getSwtConstant(), "type", "HORIZONTAL", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFillLayout_MarginWidth(), ecorePackage.getEInt(), "marginWidth", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFillLayout_MarginHeight(), ecorePackage.getEInt(), "marginHeight", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFillLayout_Spacing(), ecorePackage.getEInt(), "spacing", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stackLayoutEClass, null, "StackLayout", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStackLayout_MarginWidth(), ecorePackage.getEInt(), "marginWidth", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackLayout_MarginHeight(), ecorePackage.getEInt(), "marginHeight", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStackLayout_TopControl(), theWidgetsPackage.getControl(), null, "topControl", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formLayoutEClass, null, "FormLayout", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormLayout_MarginWidth(), ecorePackage.getEInt(), "marginWidth", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormLayout_MarginHeight(), ecorePackage.getEInt(), "marginHeight", "0", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormLayout_MarginLeft(), ecorePackage.getEInt(), "marginLeft", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormLayout_MarginTop(), ecorePackage.getEInt(), "marginTop", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormLayout_MarginRight(), ecorePackage.getEInt(), "marginRight", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormLayout_MarginBottom(), ecorePackage.getEInt(), "marginBottom", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormLayout_Spacing(), ecorePackage.getEInt(), "spacing", "3", 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formLayoutDataEClass, null, "FormLayoutData", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormLayoutData_Left(), this.getFormAttachment(), null, "left", null, 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormLayoutData_Top(), this.getFormAttachment(), null, "top", null, 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormLayoutData_Right(), this.getFormAttachment(), null, "right", null, 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormLayoutData_Bottom(), this.getFormAttachment(), null, "bottom", null, 0, 1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formAttachmentEClass, null, "FormAttachment", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormAttachment_Numerator(), ecorePackage.getEInt(), "numerator", "0", 0, 1, EObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormAttachment_Denominator(), ecorePackage.getEInt(), "denominator", "0", 0, 1, EObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormAttachment_Offset(), ecorePackage.getEInt(), "offset", "0", 0, 1, EObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormAttachment_Control(), theWidgetsPackage.getControl(), null, "control", null, 0, 1, EObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormAttachment_Alignment(), theStylesPackage_1.getSwtConstant(), "alignment", "HORIZONTAL", 0, 1, EObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/swt.ecore
		createSwtAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/swt.ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSwtAnnotations() {
		String source = "http://www.eclipse.org/e4/swt.ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.layout"
		   });		
		addAnnotation
		  (getRowLayout_Type(), 
		   source, 
		   new String[] {
			 "literals", "HORIZONTAL VERTICAL"
		   });		
		addAnnotation
		  (rowLayoutDataEClass, 
		   source, 
		   new String[] {
			 "realName", "RowData"
		   });		
		addAnnotation
		  (gridLayoutDataEClass, 
		   source, 
		   new String[] {
			 "realName", "GridData"
		   });		
		addAnnotation
		  (getGridLayoutData_VerticalAlignment(), 
		   source, 
		   new String[] {
			 "literals", "BEGINNING CENTER END FILL"
		   });		
		addAnnotation
		  (getGridLayoutData_HorizontalAlignment(), 
		   source, 
		   new String[] {
			 "literals", "BEGINNING CENTER END FILL"
		   });		
		addAnnotation
		  (getFillLayout_Type(), 
		   source, 
		   new String[] {
			 "literals", "HORIZONTAL VERTICAL"
		   });		
		addAnnotation
		  (formLayoutDataEClass, 
		   source, 
		   new String[] {
			 "realName", "FormData"
		   });		
		addAnnotation
		  (formAttachmentEClass, 
		   source, 
		   new String[] {
			 "access", "field"
		   });		
		addAnnotation
		  (getFormAttachment_Alignment(), 
		   source, 
		   new String[] {
			 "literals", "LEFT TOP RIGHT BOTTOM CENTER"
		   });
	}

} //LayoutsPackageImpl
