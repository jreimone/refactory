/**
 */
package org.emftext.refactoring.smell.smell_model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.refactoring.smell.smell_model.Smell_modelPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Smell Rolemapping Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getModelSmell <em>Model Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getRoleMappings <em>Role Mappings</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getMetaModelSpecification <em>Meta Model Specification</em>}</li>
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
	 * The cached value of the '{@link #getRoleMappings() <em>Role Mappings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleMapping> roleMappings;

	/**
	 * The cached value of the '{@link #getMetaModelSpecification() <em>Meta Model Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelSpecification()
	 * @generated
	 * @ordered
	 */
	protected EPackage metaModelSpecification;

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
	public EList<RoleMapping> getRoleMappings() {
		if (roleMappings == null) {
			roleMappings = new EObjectResolvingEList<RoleMapping>(RoleMapping.class, this, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPINGS);
		}
		return roleMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getMetaModelSpecification() {
		if (metaModelSpecification != null && metaModelSpecification.eIsProxy()) {
			InternalEObject oldMetaModelSpecification = (InternalEObject)metaModelSpecification;
			metaModelSpecification = (EPackage)eResolveProxy(oldMetaModelSpecification);
			if (metaModelSpecification != oldMetaModelSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION, oldMetaModelSpecification, metaModelSpecification));
			}
		}
		return metaModelSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetaModelSpecification() {
		return metaModelSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelSpecification(EPackage newMetaModelSpecification) {
		EPackage oldMetaModelSpecification = metaModelSpecification;
		metaModelSpecification = newMetaModelSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION, oldMetaModelSpecification, metaModelSpecification));
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPINGS:
				return getRoleMappings();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION:
				if (resolve) return getMetaModelSpecification();
				return basicGetMetaModelSpecification();
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL:
				setModelSmell((ModelSmell)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPINGS:
				getRoleMappings().clear();
				getRoleMappings().addAll((Collection<? extends RoleMapping>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION:
				setMetaModelSpecification((EPackage)newValue);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPINGS:
				getRoleMappings().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION:
				setMetaModelSpecification((EPackage)null);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPINGS:
				return roleMappings != null && !roleMappings.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION:
				return metaModelSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelSmell_Rolemapping_MappingImpl
