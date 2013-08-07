/**
 */
package org.modelrefactoring.guery.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.modelrefactoring.guery.GueryPackage;
import org.modelrefactoring.guery.PreProcessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pre Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelrefactoring.guery.impl.PreProcessorImpl#getProcessorClassName <em>Processor Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreProcessorImpl extends EObjectImpl implements PreProcessor {
	/**
	 * The default value of the '{@link #getProcessorClassName() <em>Processor Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESSOR_CLASS_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProcessorClassName() <em>Processor Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorClassName()
	 * @generated
	 * @ordered
	 */
	protected String processorClassName = PROCESSOR_CLASS_NAME_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GueryPackage.Literals.PRE_PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessorClassName() {
		return processorClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessorClassName(String newProcessorClassName) {
		String oldProcessorClassName = processorClassName;
		processorClassName = newProcessorClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GueryPackage.PRE_PROCESSOR__PROCESSOR_CLASS_NAME, oldProcessorClassName, processorClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GueryPackage.PRE_PROCESSOR__PROCESSOR_CLASS_NAME:
				return getProcessorClassName();
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
			case GueryPackage.PRE_PROCESSOR__PROCESSOR_CLASS_NAME:
				setProcessorClassName((String)newValue);
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
			case GueryPackage.PRE_PROCESSOR__PROCESSOR_CLASS_NAME:
				setProcessorClassName(PROCESSOR_CLASS_NAME_EDEFAULT);
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
			case GueryPackage.PRE_PROCESSOR__PROCESSOR_CLASS_NAME:
				return PROCESSOR_CLASS_NAME_EDEFAULT == null ? processorClassName != null : !PROCESSOR_CLASS_NAME_EDEFAULT.equals(processorClassName);
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
		result.append(" (processorClassName: ");
		result.append(processorClassName);
		result.append(')');
		return result.toString();
	}

} //PreProcessorImpl
