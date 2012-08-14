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
 * $Id: StylesPackageImpl.java,v 1.2 2009/05/07 15:10:41 pwebster Exp $
 */
package org.eclipse.e4.tm.swt.styles.impl;

import org.eclipse.e4.tm.layouts.LayoutsPackage;
import org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl;
import org.eclipse.e4.tm.swt.styles.StylesFactory;
import org.eclipse.e4.tm.swt.styles.StylesPackage;
import org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl;
import org.eclipse.e4.tm.widgets.WidgetsPackage;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StylesPackageImpl extends EPackageImpl implements StylesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType swtConstantEDataType = null;

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
	 * @see org.org.eclipse.e4.tm.swt.styles.StylesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StylesPackageImpl() {
		super(eNS_URI, StylesFactory.eINSTANCE);
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
	public static StylesPackage init() {
		if (isInited) return (StylesPackage)EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI);

		// Obtain or create and register package
		StylesPackageImpl theStylesPackage = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StylesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WidgetsPackage.eINSTANCE.eClass();
		org.eclipse.e4.tm.styles.StylesPackage.eINSTANCE.eClass();
		LayoutsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		LayoutsPackageImpl theLayoutsPackage_1 = (LayoutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.layouts.LayoutsPackage.eNS_URI) instanceof LayoutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.layouts.LayoutsPackage.eNS_URI) : org.eclipse.e4.tm.swt.layouts.LayoutsPackage.eINSTANCE);
		WidgetsPackageImpl theWidgetsPackage_1 = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.widgets.WidgetsPackage.eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.widgets.WidgetsPackage.eNS_URI) : org.eclipse.e4.tm.swt.widgets.WidgetsPackage.eINSTANCE);

		// Create package meta-data objects
		theStylesPackage.createPackageContents();
		theLayoutsPackage_1.createPackageContents();
		theWidgetsPackage_1.createPackageContents();

		// Initialize created meta-data
		theStylesPackage.initializePackageContents();
		theLayoutsPackage_1.initializePackageContents();
		theWidgetsPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStylesPackage.freeze();

		return theStylesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSwtConstant() {
		return swtConstantEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylesFactory getStylesFactory() {
		return (StylesFactory)getEFactoryInstance();
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

		// Create data types
		swtConstantEDataType = createEDataType(SWT_CONSTANT);
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

		// Initialize data types
		initEDataType(swtConstantEDataType, String.class, "SwtConstant", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //StylesPackageImpl
