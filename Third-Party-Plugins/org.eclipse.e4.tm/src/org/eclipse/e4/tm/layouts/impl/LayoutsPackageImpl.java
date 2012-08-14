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
 * $Id: LayoutsPackageImpl.java,v 1.4 2009/06/24 20:22:06 htraetteb Exp $
 */
package org.eclipse.e4.tm.layouts.impl;

import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.layouts.LayoutsFactory;
import org.eclipse.e4.tm.layouts.LayoutsPackage;
import org.eclipse.e4.tm.layouts.util.LayoutsValidator;
import org.eclipse.e4.tm.styles.StylesPackage;
import org.eclipse.e4.tm.styles.impl.StylesPackageImpl;
import org.eclipse.e4.tm.util.UtilPackage;
import org.eclipse.e4.tm.util.impl.UtilPackageImpl;
import org.eclipse.e4.tm.widgets.WidgetsPackage;
import org.eclipse.e4.tm.widgets.impl.WidgetsPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
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
	private EClass layoutDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangleLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangleLayoutDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangleEClass = null;

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
	 * @see org.eclipse.e4.tm.layouts.LayoutsPackage#eNS_URI
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
		LayoutsPackageImpl theLayoutsPackage = (LayoutsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LayoutsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LayoutsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WidgetsPackageImpl theWidgetsPackage = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI) : WidgetsPackage.eINSTANCE);
		StylesPackageImpl theStylesPackage = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI) : StylesPackage.eINSTANCE);
		UtilPackageImpl theUtilPackage = (UtilPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);

		// Create package meta-data objects
		theLayoutsPackage.createPackageContents();
		theWidgetsPackage.createPackageContents();
		theStylesPackage.createPackageContents();
		theUtilPackage.createPackageContents();

		// Initialize created meta-data
		theLayoutsPackage.initializePackageContents();
		theWidgetsPackage.initializePackageContents();
		theStylesPackage.initializePackageContents();
		theUtilPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theLayoutsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return LayoutsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theLayoutsPackage.freeze();

		return theLayoutsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayoutData() {
		return layoutDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayout() {
		return layoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangleLayout() {
		return rectangleLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangleLayout_DefaultLayoutData() {
		return (EReference)rectangleLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangleLayoutData() {
		return rectangleLayoutDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPosition() {
		return positionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_X() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_Y() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimension() {
		return dimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Width() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Height() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangle() {
		return rectangleEClass;
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
		layoutDataEClass = createEClass(LAYOUT_DATA);

		layoutEClass = createEClass(LAYOUT);

		rectangleLayoutEClass = createEClass(RECTANGLE_LAYOUT);
		createEReference(rectangleLayoutEClass, RECTANGLE_LAYOUT__DEFAULT_LAYOUT_DATA);

		rectangleLayoutDataEClass = createEClass(RECTANGLE_LAYOUT_DATA);

		positionEClass = createEClass(POSITION);
		createEAttribute(positionEClass, POSITION__X);
		createEAttribute(positionEClass, POSITION__Y);

		dimensionEClass = createEClass(DIMENSION);
		createEAttribute(dimensionEClass, DIMENSION__WIDTH);
		createEAttribute(dimensionEClass, DIMENSION__HEIGHT);

		rectangleEClass = createEClass(RECTANGLE);
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
	 * @generated NOT
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter layoutEClass_T = addETypeParameter(layoutEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getLayoutData());
		layoutEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(this.getLayout());
		EGenericType g2 = createEGenericType(this.getRectangleLayoutData());
		g1.getETypeArguments().add(g2);
		rectangleLayoutEClass.getEGenericSuperTypes().add(g1);
		rectangleLayoutDataEClass.getESuperTypes().add(this.getLayoutData());
		rectangleLayoutDataEClass.getESuperTypes().add(this.getRectangle());
		rectangleEClass.getESuperTypes().add(this.getPosition());
		rectangleEClass.getESuperTypes().add(this.getDimension());

		// Initialize classes and features; add operations and parameters
		initEClass(layoutDataEClass, LayoutData.class, "LayoutData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(layoutEClass, Layout.class, "Layout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rectangleLayoutEClass, null, "RectangleLayout", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRectangleLayout_DefaultLayoutData(), this.getRectangleLayoutData(), null, "defaultLayoutData", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rectangleLayoutDataEClass, null, "RectangleLayoutData", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(positionEClass, null, "Position", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPosition_X(), ecorePackage.getEInt(), "x", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPosition_Y(), ecorePackage.getEInt(), "y", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionEClass, null, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimension_Width(), ecorePackage.getEInt(), "width", "-1", 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_Height(), ecorePackage.getEInt(), "height", "-1", 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rectangleEClass, null, "Rectangle", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/e4/swt.ecore
		createSwtAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/e4/swt.ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSwtAnnotations() {
		String source = "http://www.eclipse.org/e4/swt.ecore";		
		addAnnotation
		  (layoutDataEClass, 
		   source, 
		   new String[] {
			 "access", "field"
		   });		
		addAnnotation
		  (layoutEClass, 
		   source, 
		   new String[] {
			 "access", "field"
		   });			
		addAnnotation
		  (rectangleLayoutEClass, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.e4.tm.builder.swt",
			 "realName", "RectangleLayoutImpl"
		   });		
		addAnnotation
		  (rectangleLayoutDataEClass, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.graphics",
			 "realName", "Rectangle"
		   });		
		addAnnotation
		  (positionEClass, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.graphics",
			 "realName", "Point",
			 "access", "field"
		   });		
		addAnnotation
		  (rectangleEClass, 
		   source, 
		   new String[] {
			 "javaPackage", "org.eclipse.swt.graphics",
			 "realName", "Rectangle",
			 "access", "field"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";				
		addAnnotation
		  (layoutEClass, 
		   source, 
		   new String[] {
			 "constraints", "validLayoutData"
		   });				
	}

} //LayoutsPackageImpl
