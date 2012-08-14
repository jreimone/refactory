/**
 */
package rolemapping.impl;

import ecore.EPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rolemapping.RoleMapping;
import rolemapping.RoleMappingModel;
import rolemapping.RolemappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rolemapping.impl.RoleMappingModelImpl#getTargetMetamodel <em>Target Metamodel</em>}</li>
 *   <li>{@link rolemapping.impl.RoleMappingModelImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link rolemapping.impl.RoleMappingModelImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleMappingModelImpl extends EObjectImpl implements RoleMappingModel {
	/**
	 * The cached value of the '{@link #getTargetMetamodel() <em>Target Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EPackage targetMetamodel;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleMapping> mappings;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> imports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleMappingModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolemappingPackage.Literals.ROLE_MAPPING_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getTargetMetamodel() {
		if (targetMetamodel != null && targetMetamodel.eIsProxy()) {
			InternalEObject oldTargetMetamodel = (InternalEObject)targetMetamodel;
			targetMetamodel = (EPackage)eResolveProxy(oldTargetMetamodel);
			if (targetMetamodel != oldTargetMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL, oldTargetMetamodel, targetMetamodel));
			}
		}
		return targetMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetTargetMetamodel() {
		return targetMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMetamodel(EPackage newTargetMetamodel) {
		EPackage oldTargetMetamodel = targetMetamodel;
		targetMetamodel = newTargetMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL, oldTargetMetamodel, targetMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoleMapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentWithInverseEList<RoleMapping>(RoleMapping.class, this, RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS, RolemappingPackage.ROLE_MAPPING__OWNING_MAPPING_MODEL);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<EPackage>(EPackage.class, this, RolemappingPackage.ROLE_MAPPING_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
			case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
				if (resolve) return getTargetMetamodel();
				return basicGetTargetMetamodel();
			case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
				return getMappings();
			case RolemappingPackage.ROLE_MAPPING_MODEL__IMPORTS:
				return getImports();
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
			case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
				setTargetMetamodel((EPackage)newValue);
				return;
			case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends RoleMapping>)newValue);
				return;
			case RolemappingPackage.ROLE_MAPPING_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends EPackage>)newValue);
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
			case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
				setTargetMetamodel((EPackage)null);
				return;
			case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
				getMappings().clear();
				return;
			case RolemappingPackage.ROLE_MAPPING_MODEL__IMPORTS:
				getImports().clear();
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
			case RolemappingPackage.ROLE_MAPPING_MODEL__TARGET_METAMODEL:
				return targetMetamodel != null;
			case RolemappingPackage.ROLE_MAPPING_MODEL__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case RolemappingPackage.ROLE_MAPPING_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleMappingModelImpl
