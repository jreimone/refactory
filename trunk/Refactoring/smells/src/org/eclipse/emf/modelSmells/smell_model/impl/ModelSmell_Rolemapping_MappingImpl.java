/**
 */
package org.eclipse.emf.modelSmells.smell_model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.modelSmells.smell_model.ModelSmell;
import org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping;
import org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Smell Rolemapping Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getModelSmell <em>Model Smell</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelSmell_Rolemapping_MappingImpl extends EObjectImpl implements ModelSmell_Rolemapping_Mapping {
	/**
	 * The cached value of the '{@link #getModelSmell() <em>Model Smell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmell()
	 * @generated
	 * @ordered
	 */
	protected ModelSmell modelSmell;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSmell_Rolemapping_MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.MODEL_SMELL_ROLEMAPPING_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSmell getModelSmell() {
		if (modelSmell != null && modelSmell.eIsProxy()) {
			InternalEObject oldModelSmell = (InternalEObject)modelSmell;
			modelSmell = (ModelSmell)eResolveProxy(oldModelSmell);
			if (modelSmell != oldModelSmell) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL, oldModelSmell, modelSmell));
			}
		}
		return modelSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSmell basicGetModelSmell() {
		return modelSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelSmell(ModelSmell newModelSmell) {
		ModelSmell oldModelSmell = modelSmell;
		modelSmell = newModelSmell;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL, oldModelSmell, modelSmell));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL:
				if (resolve) return getModelSmell();
				return basicGetModelSmell();
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL:
				setModelSmell((ModelSmell)newValue);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL:
				setModelSmell((ModelSmell)null);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL:
				return modelSmell != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelSmell_Rolemapping_MappingImpl
