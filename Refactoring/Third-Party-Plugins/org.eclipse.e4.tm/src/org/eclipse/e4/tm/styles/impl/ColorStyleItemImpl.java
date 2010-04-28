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
 * $Id: ColorStyleItemImpl.java,v 1.2 2009/05/07 15:10:41 pwebster Exp $
 */
package org.eclipse.e4.tm.styles.impl;

import org.eclipse.e4.tm.styles.AbstractColor;
import org.eclipse.e4.tm.styles.ColorStyleItem;
import org.eclipse.e4.tm.styles.StylesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Style Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.styles.impl.ColorStyleItemImpl#getTextColor <em>Text Color</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColorStyleItemImpl extends StyleItemImpl implements ColorStyleItem {
	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected AbstractColor backgroundColor;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected AbstractColor foregroundColor;

	/**
	 * The cached value of the '{@link #getTextColor() <em>Text Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextColor()
	 * @generated
	 * @ordered
	 */
	protected AbstractColor textColor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorStyleItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylesPackage.Literals.COLOR_STYLE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractColor getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackgroundColor(AbstractColor newBackgroundColor, NotificationChain msgs) {
		AbstractColor oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(AbstractColor newBackgroundColor) {
		if (newBackgroundColor != backgroundColor) {
			NotificationChain msgs = null;
			if (backgroundColor != null)
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractColor getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForegroundColor(AbstractColor newForegroundColor, NotificationChain msgs) {
		AbstractColor oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(AbstractColor newForegroundColor) {
		if (newForegroundColor != foregroundColor) {
			NotificationChain msgs = null;
			if (foregroundColor != null)
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractColor getTextColor() {
		return textColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTextColor(AbstractColor newTextColor, NotificationChain msgs) {
		AbstractColor oldTextColor = textColor;
		textColor = newTextColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR, oldTextColor, newTextColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextColor(AbstractColor newTextColor) {
		if (newTextColor != textColor) {
			NotificationChain msgs = null;
			if (textColor != null)
				msgs = ((InternalEObject)textColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR, null, msgs);
			if (newTextColor != null)
				msgs = ((InternalEObject)newTextColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR, null, msgs);
			msgs = basicSetTextColor(newTextColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR, newTextColor, newTextColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR:
				return basicSetTextColor(null, msgs);
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
			case StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR:
				return getBackgroundColor();
			case StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR:
				return getForegroundColor();
			case StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR:
				return getTextColor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((AbstractColor)newValue);
				return;
			case StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR:
				setForegroundColor((AbstractColor)newValue);
				return;
			case StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR:
				setTextColor((AbstractColor)newValue);
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
			case StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((AbstractColor)null);
				return;
			case StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR:
				setForegroundColor((AbstractColor)null);
				return;
			case StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR:
				setTextColor((AbstractColor)null);
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
			case StylesPackage.COLOR_STYLE_ITEM__BACKGROUND_COLOR:
				return backgroundColor != null;
			case StylesPackage.COLOR_STYLE_ITEM__FOREGROUND_COLOR:
				return foregroundColor != null;
			case StylesPackage.COLOR_STYLE_ITEM__TEXT_COLOR:
				return textColor != null;
		}
		return super.eIsSet(featureID);
	}

} //ColorStyleItemImpl
