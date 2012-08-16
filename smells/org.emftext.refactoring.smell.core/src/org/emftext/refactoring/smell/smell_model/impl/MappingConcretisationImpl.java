/**
 */
package org.emftext.refactoring.smell.smell_model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.emftext.refactoring.smell.smell_model.Mapping;
import org.emftext.refactoring.smell.smell_model.MappingConcretisation;
import org.emftext.refactoring.smell.smell_model.Smell_modelPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Concretisation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.MappingConcretisationImpl#getNewFactor <em>New Factor</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.MappingConcretisationImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingConcretisationImpl extends EObjectImpl implements MappingConcretisation {
	/**
	 * The default value of the '{@link #getNewFactor() <em>New Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewFactor()
	 * @generated
	 * @ordered
	 */
	protected static final Float NEW_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewFactor() <em>New Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewFactor()
	 * @generated
	 * @ordered
	 */
	protected Float newFactor = NEW_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping mapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingConcretisationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.MAPPING_CONCRETISATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getNewFactor() {
		return newFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewFactor(Float newNewFactor) {
		Float oldNewFactor = newFactor;
		newFactor = newNewFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MAPPING_CONCRETISATION__NEW_FACTOR, oldNewFactor, newFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMapping() {
		if (mapping != null && mapping.eIsProxy()) {
			InternalEObject oldMapping = (InternalEObject)mapping;
			mapping = (Mapping)eResolveProxy(oldMapping);
			if (mapping != oldMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.MAPPING_CONCRETISATION__MAPPING, oldMapping, mapping));
			}
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(Mapping newMapping) {
		Mapping oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MAPPING_CONCRETISATION__MAPPING, oldMapping, mapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Smell_modelPackage.MAPPING_CONCRETISATION__NEW_FACTOR:
				return getNewFactor();
			case Smell_modelPackage.MAPPING_CONCRETISATION__MAPPING:
				if (resolve) return getMapping();
				return basicGetMapping();
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
			case Smell_modelPackage.MAPPING_CONCRETISATION__NEW_FACTOR:
				setNewFactor((Float)newValue);
				return;
			case Smell_modelPackage.MAPPING_CONCRETISATION__MAPPING:
				setMapping((Mapping)newValue);
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
			case Smell_modelPackage.MAPPING_CONCRETISATION__NEW_FACTOR:
				setNewFactor(NEW_FACTOR_EDEFAULT);
				return;
			case Smell_modelPackage.MAPPING_CONCRETISATION__MAPPING:
				setMapping((Mapping)null);
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
			case Smell_modelPackage.MAPPING_CONCRETISATION__NEW_FACTOR:
				return NEW_FACTOR_EDEFAULT == null ? newFactor != null : !NEW_FACTOR_EDEFAULT.equals(newFactor);
			case Smell_modelPackage.MAPPING_CONCRETISATION__MAPPING:
				return mapping != null;
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
		result.append(" (newFactor: ");
		result.append(newFactor);
		result.append(')');
		return result.toString();
	}

} //MappingConcretisationImpl
