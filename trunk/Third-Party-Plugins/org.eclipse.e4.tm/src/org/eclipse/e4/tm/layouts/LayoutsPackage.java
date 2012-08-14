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
 * $Id: LayoutsPackage.java,v 1.3 2009/06/24 20:22:06 htraetteb Exp $
 */
package org.eclipse.e4.tm.layouts;

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
 * @see org.eclipse.e4.tm.layouts.LayoutsFactory
 * @model kind="package"
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
	String eNS_URI = "http://www.eclipse.org/e4/tm/layouts.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tm.layouts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutsPackage eINSTANCE = org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.LayoutDataImpl <em>Layout Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutDataImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getLayoutData()
	 * @generated
	 */
	int LAYOUT_DATA = 0;

	/**
	 * The number of structural features of the '<em>Layout Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.LayoutImpl <em>Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 1;

	/**
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.RectangleLayoutImpl <em>Rectangle Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.RectangleLayoutImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getRectangleLayout()
	 * @generated
	 */
	int RECTANGLE_LAYOUT = 2;

	/**
	 * The feature id for the '<em><b>Default Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT__DEFAULT_LAYOUT_DATA = LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rectangle Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT_FEATURE_COUNT = LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.RectangleLayoutDataImpl <em>Rectangle Layout Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.RectangleLayoutDataImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getRectangleLayoutData()
	 * @generated
	 */
	int RECTANGLE_LAYOUT_DATA = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT_DATA__X = LAYOUT_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT_DATA__Y = LAYOUT_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT_DATA__WIDTH = LAYOUT_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT_DATA__HEIGHT = LAYOUT_DATA_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rectangle Layout Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_LAYOUT_DATA_FEATURE_COUNT = LAYOUT_DATA_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.PositionImpl <em>Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.PositionImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__Y = 1;

	/**
	 * The number of structural features of the '<em>Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.DimensionImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 5;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__HEIGHT = 1;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.e4.tm.layouts.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.tm.layouts.impl.RectangleImpl
	 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 6;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__X = POSITION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__Y = POSITION__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__WIDTH = POSITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__HEIGHT = POSITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = POSITION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.LayoutData <em>Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Data</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData
	 * @generated
	 */
	EClass getLayoutData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @generated
	 */
	EClass getLayout();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.Layout <em>Rectangle Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle Layout</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore javaPackage='org.eclipse.e4.tm.builder.swt' realName='RectangleLayoutImpl'"
	 * @generated
	 */
	EClass getRectangleLayout();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.e4.tm.layouts.Layout#getDefaultLayoutData <em>Default Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Layout Data</em>'.
	 * @see org.eclipse.e4.tm.layouts.Layout#getDefaultLayoutData()
	 * @see #getRectangleLayout()
	 * @generated
	 */
	EReference getRectangleLayout_DefaultLayoutData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.e4.tm.layouts.LayoutData <em>Rectangle Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle Layout Data</em>'.
	 * @see org.eclipse.e4.tm.layouts.LayoutData
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore javaPackage='org.eclipse.swt.graphics' realName='Rectangle'"
	 * @generated
	 */
	EClass getRectangleLayoutData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.EObject <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore javaPackage='org.eclipse.swt.graphics' realName='Point' access='field'"
	 * @generated
	 */
	EClass getPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getX()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getY()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.EObject <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @model
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getWidth()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.emf.ecore.EObject#getHeight()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.EObject <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore javaPackage='org.eclipse.swt.graphics' realName='Rectangle' access='field'"
	 * @generated
	 */
	EClass getRectangle();

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
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.LayoutDataImpl <em>Layout Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutDataImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getLayoutData()
		 * @generated
		 */
		EClass LAYOUT_DATA = eINSTANCE.getLayoutData();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.LayoutImpl <em>Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getLayout()
		 * @generated
		 */
		EClass LAYOUT = eINSTANCE.getLayout();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.RectangleLayoutImpl <em>Rectangle Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.RectangleLayoutImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getRectangleLayout()
		 * @generated
		 */
		EClass RECTANGLE_LAYOUT = eINSTANCE.getRectangleLayout();

		/**
		 * The meta object literal for the '<em><b>Default Layout Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE_LAYOUT__DEFAULT_LAYOUT_DATA = eINSTANCE.getRectangleLayout_DefaultLayoutData();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.RectangleLayoutDataImpl <em>Rectangle Layout Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.RectangleLayoutDataImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getRectangleLayoutData()
		 * @generated
		 */
		EClass RECTANGLE_LAYOUT_DATA = eINSTANCE.getRectangleLayoutData();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.PositionImpl <em>Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.PositionImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getPosition()
		 * @generated
		 */
		EClass POSITION = eINSTANCE.getPosition();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__X = eINSTANCE.getPosition_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__Y = eINSTANCE.getPosition_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.DimensionImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__WIDTH = eINSTANCE.getDimension_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__HEIGHT = eINSTANCE.getDimension_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.e4.tm.layouts.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.tm.layouts.impl.RectangleImpl
		 * @see org.eclipse.e4.tm.layouts.impl.LayoutsPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

	}

} //LayoutsPackage
