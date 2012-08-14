/**
 * <copyright>
 * </copyright>
 *
 * $Id: BoundedValueControlImpl.java,v 1.2 2009/05/07 15:10:39 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets.impl;

import org.eclipse.e4.tm.widgets.BoundedValueControl;
import org.eclipse.e4.tm.widgets.WidgetsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bounded Value Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl#getValueEvent <em>Value Event</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.impl.BoundedValueControlImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BoundedValueControlImpl<T> extends ControlImpl implements BoundedValueControl<T> {
	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected T minimum;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected T maximum;

	/**
	 * The default value of the '{@link #getValueEvent() <em>Value Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueEvent()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueEvent() <em>Value Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueEvent()
	 * @generated
	 * @ordered
	 */
	protected Object valueEvent = VALUE_EVENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected T value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundedValueControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WidgetsPackage.Literals.BOUNDED_VALUE_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(T newMinimum) {
		T oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(T newMaximum) {
		T oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValueEvent() {
		return valueEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueEvent(Object newValueEvent) {
		Object oldValueEvent = valueEvent;
		valueEvent = newValueEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT, oldValueEvent, valueEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(T newValue) {
		T oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM:
				return getMinimum();
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM:
				return getMaximum();
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT:
				return getValueEvent();
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE:
				return getValue();
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
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM:
				setMinimum((T)newValue);
				return;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM:
				setMaximum((T)newValue);
				return;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT:
				setValueEvent(newValue);
				return;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE:
				setValue((T)newValue);
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
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM:
				setMinimum((T)null);
				return;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM:
				setMaximum((T)null);
				return;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT:
				setValueEvent(VALUE_EVENT_EDEFAULT);
				return;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE:
				setValue((T)null);
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
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MINIMUM:
				return minimum != null;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__MAXIMUM:
				return maximum != null;
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE_EVENT:
				return VALUE_EVENT_EDEFAULT == null ? valueEvent != null : !VALUE_EVENT_EDEFAULT.equals(valueEvent);
			case WidgetsPackage.BOUNDED_VALUE_CONTROL__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (minimum: ");
		result.append(minimum);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", valueEvent: ");
		result.append(valueEvent);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //BoundedValueControlImpl
