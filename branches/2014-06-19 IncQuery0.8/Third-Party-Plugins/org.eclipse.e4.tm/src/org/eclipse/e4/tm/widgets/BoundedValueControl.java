/**
 * <copyright>
 * </copyright>
 *
 * $Id: BoundedValueControl.java,v 1.2 2009/05/07 15:10:40 pwebster Exp $
 */
package org.eclipse.e4.tm.widgets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounded Value Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getValueEvent <em>Value Event</em>}</li>
 *   <li>{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBoundedValueControl()
 * @model abstract="true"
 * @generated
 */
public interface BoundedValueControl<T> extends Control {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBoundedValueControl_Minimum()
	 * @model
	 * @generated
	 */
	T getMinimum();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(T value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBoundedValueControl_Maximum()
	 * @model
	 * @generated
	 */
	T getMaximum();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(T value);

	/**
	 * Returns the value of the '<em><b>Value Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Event</em>' attribute.
	 * @see #setValueEvent(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBoundedValueControl_ValueEvent()
	 * @model dataType="org.eclipse.e4.tm.widgets.RuntimeEvent" transient="true"
	 *        annotation="http://www.eclipse.org/e4/swt.ecore realName='Selection' access='event' invalidates='value'"
	 * @generated
	 */
	Object getValueEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getValueEvent <em>Value Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Event</em>' attribute.
	 * @see #getValueEvent()
	 * @generated
	 */
	void setValueEvent(Object value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.eclipse.e4.tm.widgets.WidgetsPackage#getBoundedValueControl_Value()
	 * @model annotation="http://www.eclipse.org/e4/swt.ecore realName='selection' invalidatedBy='selectionEvent'"
	 * @generated
	 */
	T getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.tm.widgets.BoundedValueControl#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(T value);

} // BoundedValueControl
