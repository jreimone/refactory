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
package org.eclipse.e4.tm.swt.widgets;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.e4.tm.swt.widgets.WidgetsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/swt.ecore javaPackage='org.eclipse.swt.widgets'"
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
	String eNS_URI = "http://www.eclipse.org/swt/widgets.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "swt.widgets";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WidgetsPackage eINSTANCE = org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.widgets.impl.SliderImpl <em>Slider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.widgets.impl.SliderImpl
	 * @see org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl#getSlider()
	 * @generated
	 */
	int SLIDER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__NAME = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__ROLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__STYLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__COMPOSITE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__ENABLED = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VISIBLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__LAYOUT_DATA = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__MINIMUM = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__MAXIMUM = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Value Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VALUE_EVENT = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VALUE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE;

	/**
	 * The number of structural features of the '<em>Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER_FEATURE_COUNT = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.widgets.impl.SpinnerImpl <em>Spinner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.widgets.impl.SpinnerImpl
	 * @see org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl#getSpinner()
	 * @generated
	 */
	int SPINNER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__NAME = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__ROLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__STYLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__COMPOSITE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__ENABLED = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__VISIBLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__LAYOUT_DATA = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__MINIMUM = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__MAXIMUM = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Value Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__VALUE_EVENT = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER__VALUE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE;

	/**
	 * The number of structural features of the '<em>Spinner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPINNER_FEATURE_COUNT = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.swt.widgets.impl.ScaleImpl <em>Scale</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.swt.widgets.impl.ScaleImpl
	 * @see org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl#getScale()
	 * @generated
	 */
	int SCALE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__NAME = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__ROLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__ROLE;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__STYLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__STYLE;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__COMPOSITE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__ENABLED = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__ENABLED;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__VISIBLE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VISIBLE;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__LAYOUT_DATA = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__LAYOUT_DATA;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__MINIMUM = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__MAXIMUM = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Value Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__VALUE_EVENT = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE__VALUE = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE;

	/**
	 * The number of structural features of the '<em>Scale</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_FEATURE_COUNT = org.eclipse.e4.tm.widgets.WidgetsPackage.BOUNDED_VALUE_CONTROL_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.swt.widgets.Slider <em>Slider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slider</em>'.
	 * @see org.eclipse.e4.tm.swt.widgets.Slider
	 * @generated
	 */
	EClass getSlider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.swt.widgets.Spinner <em>Spinner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spinner</em>'.
	 * @see org.eclipse.e4.tm.swt.widgets.Spinner
	 * @generated
	 */
	EClass getSpinner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.swt.widgets.Scale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scale</em>'.
	 * @see org.eclipse.e4.tm.swt.widgets.Scale
	 * @generated
	 */
	EClass getScale();

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
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.widgets.impl.SliderImpl <em>Slider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.widgets.impl.SliderImpl
		 * @see org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl#getSlider()
		 * @generated
		 */
		EClass SLIDER = eINSTANCE.getSlider();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.widgets.impl.SpinnerImpl <em>Spinner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.widgets.impl.SpinnerImpl
		 * @see org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl#getSpinner()
		 * @generated
		 */
		EClass SPINNER = eINSTANCE.getSpinner();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.swt.widgets.impl.ScaleImpl <em>Scale</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.swt.widgets.impl.ScaleImpl
		 * @see org.eclipse.e4.tm.swt.widgets.impl.WidgetsPackageImpl#getScale()
		 * @generated
		 */
		EClass SCALE = eINSTANCE.getScale();

	}

} //WidgetsPackage
