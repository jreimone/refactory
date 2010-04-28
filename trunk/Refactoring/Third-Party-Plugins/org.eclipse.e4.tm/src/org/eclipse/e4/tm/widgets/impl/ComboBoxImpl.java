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
 * $Id: ComboBoxImpl.java,v 1.3 2009/05/25 21:59:17 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets.impl;

import org.eclipse.e4.tm.widgets.ComboBox;
import org.eclipse.e4.tm.widgets.Text;
import org.eclipse.e4.tm.widgets.WidgetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combo Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ComboBoxImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ComboBoxImpl#getModify <em>Modify</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ComboBoxImpl#getKeyUp <em>Key Up</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ComboBoxImpl#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComboBoxImpl extends ListImpl implements ComboBox {
	/**
	 * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDITABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected boolean editable = EDITABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModify() <em>Modify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModify()
	 * @generated
	 * @ordered
	 */
	protected static final Object MODIFY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModify() <em>Modify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModify()
	 * @generated
	 * @ordered
	 */
	protected Object modify = MODIFY_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyUp() <em>Key Up</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyUp()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEY_UP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyUp() <em>Key Up</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyUp()
	 * @generated
	 * @ordered
	 */
	protected Object keyUp = KEY_UP_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComboBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WidgetsPackage.Literals.COMBO_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditable(boolean newEditable) {
		boolean oldEditable = editable;
		editable = newEditable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.COMBO_BOX__EDITABLE, oldEditable, editable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getModify() {
		return modify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModify(Object newModify) {
		Object oldModify = modify;
		modify = newModify;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.COMBO_BOX__MODIFY, oldModify, modify));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKeyUp() {
		return keyUp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyUp(Object newKeyUp) {
		Object oldKeyUp = keyUp;
		keyUp = newKeyUp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.COMBO_BOX__KEY_UP, oldKeyUp, keyUp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.COMBO_BOX__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WidgetsPackage.COMBO_BOX__EDITABLE:
				return isEditable();
			case WidgetsPackage.COMBO_BOX__MODIFY:
				return getModify();
			case WidgetsPackage.COMBO_BOX__KEY_UP:
				return getKeyUp();
			case WidgetsPackage.COMBO_BOX__TEXT:
				return getText();
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
			case WidgetsPackage.COMBO_BOX__EDITABLE:
				setEditable((Boolean)newValue);
				return;
			case WidgetsPackage.COMBO_BOX__MODIFY:
				setModify(newValue);
				return;
			case WidgetsPackage.COMBO_BOX__KEY_UP:
				setKeyUp(newValue);
				return;
			case WidgetsPackage.COMBO_BOX__TEXT:
				setText((String)newValue);
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
			case WidgetsPackage.COMBO_BOX__EDITABLE:
				setEditable(EDITABLE_EDEFAULT);
				return;
			case WidgetsPackage.COMBO_BOX__MODIFY:
				setModify(MODIFY_EDEFAULT);
				return;
			case WidgetsPackage.COMBO_BOX__KEY_UP:
				setKeyUp(KEY_UP_EDEFAULT);
				return;
			case WidgetsPackage.COMBO_BOX__TEXT:
				setText(TEXT_EDEFAULT);
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
			case WidgetsPackage.COMBO_BOX__EDITABLE:
				return editable != EDITABLE_EDEFAULT;
			case WidgetsPackage.COMBO_BOX__MODIFY:
				return MODIFY_EDEFAULT == null ? modify != null : !MODIFY_EDEFAULT.equals(modify);
			case WidgetsPackage.COMBO_BOX__KEY_UP:
				return KEY_UP_EDEFAULT == null ? keyUp != null : !KEY_UP_EDEFAULT.equals(keyUp);
			case WidgetsPackage.COMBO_BOX__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Text.class) {
			switch (derivedFeatureID) {
				case WidgetsPackage.COMBO_BOX__EDITABLE: return WidgetsPackage.TEXT__EDITABLE;
				case WidgetsPackage.COMBO_BOX__MODIFY: return WidgetsPackage.TEXT__MODIFY;
				case WidgetsPackage.COMBO_BOX__KEY_UP: return WidgetsPackage.TEXT__KEY_UP;
				case WidgetsPackage.COMBO_BOX__TEXT: return WidgetsPackage.TEXT__TEXT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Text.class) {
			switch (baseFeatureID) {
				case WidgetsPackage.TEXT__EDITABLE: return WidgetsPackage.COMBO_BOX__EDITABLE;
				case WidgetsPackage.TEXT__MODIFY: return WidgetsPackage.COMBO_BOX__MODIFY;
				case WidgetsPackage.TEXT__KEY_UP: return WidgetsPackage.COMBO_BOX__KEY_UP;
				case WidgetsPackage.TEXT__TEXT: return WidgetsPackage.COMBO_BOX__TEXT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (editable: ");
		result.append(editable);
		result.append(", modify: ");
		result.append(modify);
		result.append(", keyUp: ");
		result.append(keyUp);
		result.append(", text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //ComboBoxImpl
