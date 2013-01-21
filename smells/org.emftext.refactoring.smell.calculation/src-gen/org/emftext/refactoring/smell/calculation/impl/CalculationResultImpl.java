/**
 */
package org.emftext.refactoring.smell.calculation.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.CalculationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CalculationResultImpl#getCausingObjects <em>Causing Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalculationResultImpl extends EObjectImpl implements CalculationResult {
	/**
	 * The cached value of the '{@link #getCausingObjects() <em>Causing Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausingObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> causingObjects;

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
	public EList<EObject> getCausingObjects() {
		if (causingObjects == null) {
			causingObjects = new EObjectResolvingEList<EObject>(EObject.class, this, CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS);
		}
		return causingObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS:
				return getCausingObjects();
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
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS:
				getCausingObjects().clear();
				getCausingObjects().addAll((Collection<? extends EObject>)newValue);
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
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS:
				getCausingObjects().clear();
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
			case CalculationPackage.CALCULATION_RESULT__CAUSING_OBJECTS:
				return causingObjects != null && !causingObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CalculationResultImpl
