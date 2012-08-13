/**
 */
package smell_model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rolemapping.RoleMapping;
import smell_model.MappingConcretisation;
import smell_model.ModelSmell;
import smell_model.ModelSmell_Rolemapping_Mapping;
import smell_model.Smell_modelPackage;
import ecore.EPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Smell Rolemapping Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getModelSmell <em>Model Smell</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getRoleMapping <em>Role Mapping</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getMappingConcretisation <em>Mapping Concretisation</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmell_Rolemapping_MappingImpl#getMetamodelSpecification <em>Metamodel Specification</em>}</li>
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
	 * The cached value of the '{@link #getRoleMapping() <em>Role Mapping</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleMapping> roleMapping;
	/**
	 * The cached value of the '{@link #getMappingConcretisation() <em>Mapping Concretisation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingConcretisation()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingConcretisation> mappingConcretisation;
	/**
	 * The cached value of the '{@link #getMetamodelSpecification() <em>Metamodel Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelSpecification()
	 * @generated
	 * @ordered
	 */
	protected EPackage metamodelSpecification;

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
	public EList<RoleMapping> getRoleMapping() {
		if (roleMapping == null) {
			roleMapping = new EObjectResolvingEList<RoleMapping>(RoleMapping.class, this, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING);
		}
		return roleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingConcretisation> getMappingConcretisation() {
		if (mappingConcretisation == null) {
			mappingConcretisation = new EObjectContainmentEList<MappingConcretisation>(MappingConcretisation.class, this, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION);
		}
		return mappingConcretisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getMetamodelSpecification() {
		if (metamodelSpecification != null && metamodelSpecification.eIsProxy()) {
			InternalEObject oldMetamodelSpecification = (InternalEObject)metamodelSpecification;
			metamodelSpecification = (EPackage)eResolveProxy(oldMetamodelSpecification);
			if (metamodelSpecification != oldMetamodelSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION, oldMetamodelSpecification, metamodelSpecification));
			}
		}
		return metamodelSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetamodelSpecification() {
		return metamodelSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodelSpecification(EPackage newMetamodelSpecification) {
		EPackage oldMetamodelSpecification = metamodelSpecification;
		metamodelSpecification = newMetamodelSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION, oldMetamodelSpecification, metamodelSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION:
				return ((InternalEList<?>)getMappingConcretisation()).basicRemove(otherEnd, msgs);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL:
				if (resolve) return getModelSmell();
				return basicGetModelSmell();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING:
				return getRoleMapping();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION:
				return getMappingConcretisation();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION:
				if (resolve) return getMetamodelSpecification();
				return basicGetMetamodelSpecification();
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING:
				getRoleMapping().clear();
				getRoleMapping().addAll((Collection<? extends RoleMapping>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION:
				getMappingConcretisation().clear();
				getMappingConcretisation().addAll((Collection<? extends MappingConcretisation>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION:
				setMetamodelSpecification((EPackage)newValue);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING:
				getRoleMapping().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION:
				getMappingConcretisation().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION:
				setMetamodelSpecification((EPackage)null);
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
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING:
				return roleMapping != null && !roleMapping.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION:
				return mappingConcretisation != null && !mappingConcretisation.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION:
				return metamodelSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelSmell_Rolemapping_MappingImpl
