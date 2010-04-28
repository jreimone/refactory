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
 * $Id: ControlImpl.java,v 1.3 2009/05/25 21:59:17 htraetteb Exp $
 */
package org.eclipse.e4.tm.widgets.impl;

import org.eclipse.e4.tm.layouts.LayoutData;
import org.eclipse.e4.tm.styles.impl.StyledImpl;
import org.eclipse.e4.tm.widgets.AbstractComposite;
import org.eclipse.e4.tm.widgets.Control;
import org.eclipse.e4.tm.widgets.Scripted;
import org.eclipse.e4.tm.widgets.WidgetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ControlImpl#getScriptSource <em>Script Source</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ControlImpl#getDataObject <em>Data Object</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ControlImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ControlImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ControlImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.ControlImpl#getLayoutData <em>Layout Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ControlImpl extends StyledImpl implements Control {
	/**
	 * The default value of the '{@link #getScriptSource() <em>Script Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScriptSource() <em>Script Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptSource()
	 * @generated
	 * @ordered
	 */
	protected String scriptSource = SCRIPT_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataObject() <em>Data Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataObject() <em>Data Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataObject()
	 * @generated
	 * @ordered
	 */
	protected Object dataObject = DATA_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLayoutData() <em>Layout Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutData()
	 * @generated
	 * @ordered
	 */
	protected LayoutData layoutData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WidgetsPackage.Literals.CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScriptSource() {
		return scriptSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptSource(String newScriptSource) {
		String oldScriptSource = scriptSource;
		scriptSource = newScriptSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__SCRIPT_SOURCE, oldScriptSource, scriptSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public AbstractComposite<Control> getComposite() {
		if (eContainerFeatureID() != WidgetsPackage.CONTROL__COMPOSITE) return null;
		return (AbstractComposite<Control>)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComposite(AbstractComposite<Control> newComposite, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComposite, WidgetsPackage.CONTROL__COMPOSITE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposite(AbstractComposite<Control> newComposite) {
		if (newComposite != eInternalContainer() || (eContainerFeatureID() != WidgetsPackage.CONTROL__COMPOSITE && newComposite != null)) {
			if (EcoreUtil.isAncestor(this, newComposite))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComposite != null)
				msgs = ((InternalEObject)newComposite).eInverseAdd(this, WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS, AbstractComposite.class, msgs);
			msgs = basicSetComposite(newComposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__COMPOSITE, newComposite, newComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__VISIBLE, oldVisible, visible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutData getLayoutData() {
		return layoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutData(LayoutData newLayoutData, NotificationChain msgs) {
		LayoutData oldLayoutData = layoutData;
		layoutData = newLayoutData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__LAYOUT_DATA, oldLayoutData, newLayoutData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutData(LayoutData newLayoutData) {
		if (newLayoutData != layoutData) {
			NotificationChain msgs = null;
			if (layoutData != null)
				msgs = ((InternalEObject)layoutData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WidgetsPackage.CONTROL__LAYOUT_DATA, null, msgs);
			if (newLayoutData != null)
				msgs = ((InternalEObject)newLayoutData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WidgetsPackage.CONTROL__LAYOUT_DATA, null, msgs);
			msgs = basicSetLayoutData(newLayoutData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__LAYOUT_DATA, newLayoutData, newLayoutData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDataObject() {
		return dataObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataObject(Object newDataObject) {
		Object oldDataObject = dataObject;
		dataObject = newDataObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.CONTROL__DATA_OBJECT, oldDataObject, dataObject));
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
			case WidgetsPackage.CONTROL__COMPOSITE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetComposite((AbstractComposite<Control>)otherEnd, msgs);
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
			case WidgetsPackage.CONTROL__COMPOSITE:
				return basicSetComposite(null, msgs);
			case WidgetsPackage.CONTROL__LAYOUT_DATA:
				return basicSetLayoutData(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case WidgetsPackage.CONTROL__COMPOSITE:
				return eInternalContainer().eInverseRemove(this, WidgetsPackage.ABSTRACT_COMPOSITE__CONTROLS, AbstractComposite.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WidgetsPackage.CONTROL__SCRIPT_SOURCE:
				return getScriptSource();
			case WidgetsPackage.CONTROL__DATA_OBJECT:
				return getDataObject();
			case WidgetsPackage.CONTROL__COMPOSITE:
				return getComposite();
			case WidgetsPackage.CONTROL__ENABLED:
				return isEnabled();
			case WidgetsPackage.CONTROL__VISIBLE:
				return isVisible();
			case WidgetsPackage.CONTROL__LAYOUT_DATA:
				return getLayoutData();
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
			case WidgetsPackage.CONTROL__SCRIPT_SOURCE:
				setScriptSource((String)newValue);
				return;
			case WidgetsPackage.CONTROL__DATA_OBJECT:
				setDataObject(newValue);
				return;
			case WidgetsPackage.CONTROL__COMPOSITE:
				setComposite((AbstractComposite<Control>)newValue);
				return;
			case WidgetsPackage.CONTROL__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case WidgetsPackage.CONTROL__VISIBLE:
				setVisible((Boolean)newValue);
				return;
			case WidgetsPackage.CONTROL__LAYOUT_DATA:
				setLayoutData((LayoutData)newValue);
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
			case WidgetsPackage.CONTROL__SCRIPT_SOURCE:
				setScriptSource(SCRIPT_SOURCE_EDEFAULT);
				return;
			case WidgetsPackage.CONTROL__DATA_OBJECT:
				setDataObject(DATA_OBJECT_EDEFAULT);
				return;
			case WidgetsPackage.CONTROL__COMPOSITE:
				setComposite((AbstractComposite<Control>)null);
				return;
			case WidgetsPackage.CONTROL__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case WidgetsPackage.CONTROL__VISIBLE:
				setVisible(VISIBLE_EDEFAULT);
				return;
			case WidgetsPackage.CONTROL__LAYOUT_DATA:
				setLayoutData((LayoutData)null);
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
			case WidgetsPackage.CONTROL__SCRIPT_SOURCE:
				return SCRIPT_SOURCE_EDEFAULT == null ? scriptSource != null : !SCRIPT_SOURCE_EDEFAULT.equals(scriptSource);
			case WidgetsPackage.CONTROL__DATA_OBJECT:
				return DATA_OBJECT_EDEFAULT == null ? dataObject != null : !DATA_OBJECT_EDEFAULT.equals(dataObject);
			case WidgetsPackage.CONTROL__COMPOSITE:
				return getComposite() != null;
			case WidgetsPackage.CONTROL__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case WidgetsPackage.CONTROL__VISIBLE:
				return visible != VISIBLE_EDEFAULT;
			case WidgetsPackage.CONTROL__LAYOUT_DATA:
				return layoutData != null;
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
		if (baseClass == Scripted.class) {
			switch (derivedFeatureID) {
				case WidgetsPackage.CONTROL__SCRIPT_SOURCE: return WidgetsPackage.SCRIPTED__SCRIPT_SOURCE;
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
		if (baseClass == Scripted.class) {
			switch (baseFeatureID) {
				case WidgetsPackage.SCRIPTED__SCRIPT_SOURCE: return WidgetsPackage.CONTROL__SCRIPT_SOURCE;
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
		result.append(" (scriptSource: ");
		result.append(scriptSource);
		result.append(", dataObject: ");
		result.append(dataObject);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", visible: ");
		result.append(visible);
		result.append(')');
		return result.toString();
	}

} //ControlImpl
