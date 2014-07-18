/**
 */
package org.emftext.refactoring.smell.calculation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.CausingObjectsGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl#getResultingValue <em>Resulting Value</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl#getCausingObjectsGroups <em>Causing Objects Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalculationResultImpl extends EObjectImpl implements CalculationResult {
	/**
	 * The default value of the '{@link #getResultingValue() <em>Resulting Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultingValue()
	 * @generated
	 * @ordered
	 */
	protected static final float RESULTING_VALUE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getResultingValue() <em>Resulting Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultingValue()
	 * @generated
	 * @ordered
	 */
	protected float resultingValue = RESULTING_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCausingObjectsGroups() <em>Causing Objects Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausingObjectsGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<CausingObjectsGroup> causingObjectsGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CalculationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculationPackage.Literals.CALCULATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getResultingValue() {
		return resultingValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultingValue(float newResultingValue) {
		float oldResultingValue = resultingValue;
		resultingValue = newResultingValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.CALCULATION_RESULT__RESULTING_VALUE, oldResultingValue, resultingValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CausingObjectsGroup> getCausingObjectsGroups() {
		if (causingObjectsGroups == null) {
			causingObjectsGroups = new EObjectContainmentEList<CausingObjectsGroup>(CausingObjectsGroup.class, this, CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS);
		}
		return causingObjectsGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS:
				return ((InternalEList<?>)getCausingObjectsGroups()).basicRemove(otherEnd, msgs);
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
			case CalculationPackage.CALCULATION_RESULT__RESULTING_VALUE:
				return getResultingValue();
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS:
				return getCausingObjectsGroups();
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
			case CalculationPackage.CALCULATION_RESULT__RESULTING_VALUE:
				setResultingValue((Float)newValue);
				return;
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS:
				getCausingObjectsGroups().clear();
				getCausingObjectsGroups().addAll((Collection<? extends CausingObjectsGroup>)newValue);
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
			case CalculationPackage.CALCULATION_RESULT__RESULTING_VALUE:
				setResultingValue(RESULTING_VALUE_EDEFAULT);
				return;
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS:
				getCausingObjectsGroups().clear();
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
			case CalculationPackage.CALCULATION_RESULT__RESULTING_VALUE:
				return resultingValue != RESULTING_VALUE_EDEFAULT;
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS_GROUPS:
				return causingObjectsGroups != null && !causingObjectsGroups.isEmpty();
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
		result.append(" (resultingValue: ");
		result.append(resultingValue);
		result.append(')');
		return result.toString();
	}

} //CalculationResultImpl
