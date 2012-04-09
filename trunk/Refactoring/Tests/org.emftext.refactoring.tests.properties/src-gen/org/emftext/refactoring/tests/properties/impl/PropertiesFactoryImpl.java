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
package org.emftext.refactoring.tests.properties.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.refactoring.tests.properties.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertiesFactoryImpl extends EFactoryImpl implements PropertiesFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static PropertiesFactory init() {
    try
    {
      PropertiesFactory thePropertiesFactory = (PropertiesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/properties"); 
      if (thePropertiesFactory != null)
      {
        return thePropertiesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PropertiesFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PropertiesFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case PropertiesPackage.PROPERTY_MODEL: return createPropertyModel();
      case PropertiesPackage.CATEGORY: return createCategory();
      case PropertiesPackage.KEY_VALUE_PAIR: return createKeyValuePair();
      case PropertiesPackage.KEY: return createKey();
      case PropertiesPackage.EOBJECT_REFERENCE_VALUE: return createEObjectReferenceValue();
      case PropertiesPackage.STRING_VALUE: return createStringValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PropertyModel createPropertyModel() {
    PropertyModelImpl propertyModel = new PropertyModelImpl();
    return propertyModel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Category createCategory() {
    CategoryImpl category = new CategoryImpl();
    return category;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public KeyValuePair createKeyValuePair() {
    KeyValuePairImpl keyValuePair = new KeyValuePairImpl();
    return keyValuePair;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Key createKey() {
    KeyImpl key = new KeyImpl();
    return key;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EObjectReferenceValue createEObjectReferenceValue() {
    EObjectReferenceValueImpl eObjectReferenceValue = new EObjectReferenceValueImpl();
    return eObjectReferenceValue;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public StringValue createStringValue() {
    StringValueImpl stringValue = new StringValueImpl();
    return stringValue;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PropertiesPackage getPropertiesPackage() {
    return (PropertiesPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static PropertiesPackage getPackage() {
    return PropertiesPackage.eINSTANCE;
  }

} //PropertiesFactoryImpl
