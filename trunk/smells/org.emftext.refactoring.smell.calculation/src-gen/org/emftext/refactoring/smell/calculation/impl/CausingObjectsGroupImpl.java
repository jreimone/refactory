/**
 */
package org.emftext.refactoring.smell.calculation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.emftext.refactoring.smell.calculation.CausingObjectsGroup;
import org.emftext.refactoring.smell.calculation.NamedCausingObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Causing Objects Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.calculation.impl.CausingObjectsGroupImpl#getNamedCausingObjects <em>Named Causing Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CausingObjectsGroupImpl extends EObjectImpl implements CausingObjectsGroup {
	/**
	 * The cached value of the '{@link #getNamedCausingObjects() <em>Named Causing Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedCausingObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedCausingObject> namedCausingObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CausingObjectsGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculationPackage.Literals.CAUSING_OBJECTS_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedCausingObject> getNamedCausingObjects() {
		if (namedCausingObjects == null) {
			namedCausingObjects = new EObjectContainmentEList<NamedCausingObject>(NamedCausingObject.class, this, CalculationPackage.CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS);
		}
		return namedCausingObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CalculationPackage.CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS:
				return ((InternalEList<?>)getNamedCausingObjects()).basicRemove(otherEnd, msgs);
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
			case CalculationPackage.CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS:
				return getNamedCausingObjects();
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
			case CalculationPackage.CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS:
				getNamedCausingObjects().clear();
				getNamedCausingObjects().addAll((Collection<? extends NamedCausingObject>)newValue);
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
			case CalculationPackage.CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS:
				getNamedCausingObjects().clear();
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
			case CalculationPackage.CAUSING_OBJECTS_GROUP__NAMED_CAUSING_OBJECTS:
				return namedCausingObjects != null && !namedCausingObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CausingObjectsGroupImpl
