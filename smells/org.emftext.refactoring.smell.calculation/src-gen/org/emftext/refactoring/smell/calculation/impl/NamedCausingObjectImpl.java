/**
 */
package org.emftext.refactoring.smell.calculation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.NamedCausingObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Causing Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.NamedCausingObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.NamedCausingObjectImpl#getCausingObject <em>Causing Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedCausingObjectImpl extends EObjectImpl implements NamedCausingObject {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCausingObject() <em>Causing Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausingObject()
	 * @generated
	 * @ordered
	 */
	protected EObject causingObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedCausingObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculationPackage.Literals.NAMED_CAUSING_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.NAMED_CAUSING_OBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getCausingObject() {
		if (causingObject != null && causingObject.eIsProxy()) {
			InternalEObject oldCausingObject = (InternalEObject)causingObject;
			causingObject = eResolveProxy(oldCausingObject);
			if (causingObject != oldCausingObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CalculationPackage.NAMED_CAUSING_OBJECT__CAUSING_OBJECT, oldCausingObject, causingObject));
			}
		}
		return causingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetCausingObject() {
		return causingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCausingObject(EObject newCausingObject) {
		EObject oldCausingObject = causingObject;
		causingObject = newCausingObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculationPackage.NAMED_CAUSING_OBJECT__CAUSING_OBJECT, oldCausingObject, causingObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CalculationPackage.NAMED_CAUSING_OBJECT__NAME:
				return getName();
			case CalculationPackage.NAMED_CAUSING_OBJECT__CAUSING_OBJECT:
				if (resolve) return getCausingObject();
				return basicGetCausingObject();
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
			case CalculationPackage.NAMED_CAUSING_OBJECT__NAME:
				setName((String)newValue);
				return;
			case CalculationPackage.NAMED_CAUSING_OBJECT__CAUSING_OBJECT:
				setCausingObject((EObject)newValue);
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
			case CalculationPackage.NAMED_CAUSING_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CalculationPackage.NAMED_CAUSING_OBJECT__CAUSING_OBJECT:
				setCausingObject((EObject)null);
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
			case CalculationPackage.NAMED_CAUSING_OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CalculationPackage.NAMED_CAUSING_OBJECT__CAUSING_OBJECT:
				return causingObject != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NamedCausingObjectImpl
