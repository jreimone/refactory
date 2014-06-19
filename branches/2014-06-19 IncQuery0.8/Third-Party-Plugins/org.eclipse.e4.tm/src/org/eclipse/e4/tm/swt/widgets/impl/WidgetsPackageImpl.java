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
 * $Id: WidgetsPackageImpl.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.swt.widgets.impl;

import org.eclipse.e4.tm.layouts.LayoutsPackage;
import org.eclipse.e4.tm.styles.StylesPackage;
import org.eclipse.e4.tm.swt.layouts.impl.LayoutsPackageImpl;
import org.eclipse.e4.tm.swt.styles.impl.StylesPackageImpl;
import org.eclipse.e4.tm.swt.widgets.Scale;
import org.eclipse.e4.tm.swt.widgets.Slider;
import org.eclipse.e4.tm.swt.widgets.Spinner;
import org.eclipse.e4.tm.swt.widgets.WidgetsFactory;
import org.eclipse.e4.tm.swt.widgets.WidgetsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WidgetsPackageImpl extends EPackageImpl implements WidgetsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sliderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spinnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaleEClass = null;

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
	 * @see org.eclipse.e4.tm.swt.widgets.WidgetsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WidgetsPackageImpl() {
		super(eNS_URI, WidgetsFactory.eINSTANCE);
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
	public static WidgetsPackage init() {
		if (isInited) return (WidgetsPackage)EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI);

		// Obtain or create and register package
		WidgetsPackageImpl theWidgetsPackage = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WidgetsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		org.eclipse.e4.tm.widgets.WidgetsPackage.eINSTANCE.eClass();
		StylesPackage.eINSTANCE.eClass();
		LayoutsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		LayoutsPackageImpl theLayoutsPackage_1 = (LayoutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.layouts.LayoutsPackage.eNS_URI) instanceof LayoutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.layouts.LayoutsPackage.eNS_URI) : org.eclipse.e4.tm.swt.layouts.LayoutsPackage.eINSTANCE);
		StylesPackageImpl theStylesPackage_1 = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.styles.StylesPackage.eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.swt.styles.StylesPackage.eNS_URI) : org.eclipse.e4.tm.swt.styles.StylesPackage.eINSTANCE);

		// Create package meta-data objects
		theWidgetsPackage.createPackageContents();
		theLayoutsPackage_1.createPackageContents();
		theStylesPackage_1.createPackageContents();

		// Initialize created meta-data
		theWidgetsPackage.initializePackageContents();
		theLayoutsPackage_1.initializePackageContents();
		theStylesPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWidgetsPackage.freeze();

		return theWidgetsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlider() {
		return sliderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpinner() {
		return spinnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScale() {
		return scaleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetsFactory getWidgetsFactory() {
		return (WidgetsFactory)getEFactoryInstance();
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
		sliderEClass = createEClass(SLIDER);

		spinnerEClass = createEClass(SPINNER);

		scaleEClass = createEClass(SCALE);
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
		org.eclipse.e4.tm.widgets.WidgetsPackage theWidgetsPackage_1 = (org.eclipse.e4.tm.widgets.WidgetsPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.e4.tm.widgets.WidgetsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theWidgetsPackage_1.getBoundedValueControl());
		EGenericType g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		sliderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theWidgetsPackage_1.getBoundedValueControl());
		g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		spinnerEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theWidgetsPackage_1.getBoundedValueControl());
		g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		scaleEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(sliderEClass, Slider.class, "Slider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(spinnerEClass, Spinner.class, "Spinner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scaleEClass, Scale.class, "Scale", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		String source = "http://www.eclipse.org/swt.ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.widgets"
		   });
	}

} //WidgetsPackageImpl
