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
 * $Id: AbstractCompositeImpl.java,v 1.2 2009/05/07 15:10:39 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets.impl;

import java.util.Collection;

import org.eclipse.e4.tm.layouts.Layout;
import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.styles.Style;
import org.eclipse.e4.tm.widgets.AbstractComposite;
import org.eclipse.e4.tm.widgets.Control;
import org.eclipse.e4.tm.widgets.WidgetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl#getControls <em>Controls</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.AbstractCompositeImpl#getLayout <em>Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractCompositeImpl<T extends Control> extends ControlImpl implements AbstractComposite<T> {
	/**
	 * The cached value of the '{@link #getControls() <em>Controls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControls()
	 * @generated
	 * @ordered
	 */
	protected EList<T> controls;

	/**
	 * The cached value of the '{@link #getStyles() <em>Styles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<Style> styles;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected Layout<LayoutData> layout;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractCompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WidgetsPackage.Literals.ABSTRACT_COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<T> getControls() {
		if (controls == null) {
			controls = new EObjectContainmentWithInverseEList<T>(Control.class, this, WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS, WidgetsPackage.CONTROL__COMPOSITE);
		}
		return controls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Style> getStyles() {
		if (styles == null) {
			styles = new EObjectContainmentEList<Style>(Style.class, this, WidgetsPackage.ABSTRACT_COMPOSITE__STYLES);
		}
		return styles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout<LayoutData> getLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayout(Layout<LayoutData> newLayout, NotificationChain msgs) {
		Layout<LayoutData> oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT, oldLayout, newLayout);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(Layout<LayoutData> newLayout) {
		if (newLayout != layout) {
			NotificationChain msgs = null;
			if (layout != null)
				msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT, null, msgs);
			if (newLayout != null)
				msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT, null, msgs);
			msgs = basicSetLayout(newLayout, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT, newLayout, newLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getControls()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS:
				return ((InternalEList<?>)getControls()).basicRemove(otherEnd, msgs);
			case WidgetsPackage.ABSTRACT_COMPOSITE__STYLES:
				return ((InternalEList<?>)getStyles()).basicRemove(otherEnd, msgs);
			case WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT:
				return basicSetLayout(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS:
				return getControls();
			case WidgetsPackage.ABSTRACT_COMPOSITE__STYLES:
				return getStyles();
			case WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT:
				return getLayout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS:
				getControls().clear();
				getControls().addAll((Collection<? extends T>)newValue);
				return;
			case WidgetsPackage.ABSTRACT_COMPOSITE__STYLES:
				getStyles().clear();
				getStyles().addAll((Collection<? extends Style>)newValue);
				return;
			case WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT:
				setLayout((Layout<LayoutData>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS:
				getControls().clear();
				return;
			case WidgetsPackage.ABSTRACT_COMPOSITE__STYLES:
				getStyles().clear();
				return;
			case WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT:
				setLayout((Layout<LayoutData>)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS:
				return controls != null && !controls.isEmpty();
			case WidgetsPackage.ABSTRACT_COMPOSITE__STYLES:
				return styles != null && !styles.isEmpty();
			case WidgetsPackage.ABSTRACT_COMPOSITE__LAYOUT:
				return layout != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractCompositeImpl
