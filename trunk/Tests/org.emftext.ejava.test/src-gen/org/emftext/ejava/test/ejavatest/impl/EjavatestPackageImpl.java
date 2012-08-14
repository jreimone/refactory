/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.ejava.test.ejavatest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.ejava.test.ejavatest.EjavatestFactory;
import org.emftext.ejava.test.ejavatest.EjavatestPackage;
import org.emftext.ejava.test.ejavatest.ModifierEnum;
import org.emftext.ejava.test.ejavatest.ModifierUser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EjavatestPackageImpl extends EPackageImpl implements EjavatestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modifierEnumEEnum = null;

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
	 * @see org.emftext.ejava.test.ejavatest.EjavatestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EjavatestPackageImpl() {
		super(eNS_URI, EjavatestFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EjavatestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EjavatestPackage init() {
		if (isInited) return (EjavatestPackage)EPackage.Registry.INSTANCE.getEPackage(EjavatestPackage.eNS_URI);

		// Obtain or create and register package
		EjavatestPackageImpl theEjavatestPackage = (EjavatestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EjavatestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EjavatestPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEjavatestPackage.createPackageContents();

		// Initialize created meta-data
		theEjavatestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEjavatestPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EjavatestPackage.eNS_URI, theEjavatestPackage);
		return theEjavatestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifierUser() {
		return modifierUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifierUser_Modifier() {
		return (EAttribute)modifierUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModifierEnum() {
		return modifierEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EjavatestFactory getEjavatestFactory() {
		return (EjavatestFactory)getEFactoryInstance();
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
		modifierUserEClass = createEClass(MODIFIER_USER);
		createEAttribute(modifierUserEClass, MODIFIER_USER__MODIFIER);

		// Create enums
		modifierEnumEEnum = createEEnum(MODIFIER_ENUM);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(modifierUserEClass, ModifierUser.class, "ModifierUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModifierUser_Modifier(), this.getModifierEnum(), "modifier", null, 0, -1, ModifierUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(modifierUserEClass, this.getModifierEnum(), "getTheModifiers", 0, -1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(modifierEnumEEnum, ModifierEnum.class, "ModifierEnum");
		addEEnumLiteral(modifierEnumEEnum, ModifierEnum.OPTIONAL);
		addEEnumLiteral(modifierEnumEEnum, ModifierEnum.SUPER);
		addEEnumLiteral(modifierEnumEEnum, ModifierEnum.INPUT);

		// Create resource
		createResource(eNS_URI);
	}

} //EjavatestPackageImpl
