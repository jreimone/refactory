/**
 */
package rolemapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rolemapping.CollaborationMapping;
import rolemapping.ReferenceMetaClassPair;
import rolemapping.RolemappingPackage;

import roles.MultiplicityCollaboration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rolemapping.impl.CollaborationMappingImpl#getCollaboration <em>Collaboration</em>}</li>
 *   <li>{@link rolemapping.impl.CollaborationMappingImpl#getReferenceMetaClassPair <em>Reference Meta Class Pair</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollaborationMappingImpl extends EObjectImpl implements CollaborationMapping {
	/**
	 * The cached value of the '{@link #getCollaboration() <em>Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollaboration()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityCollaboration collaboration;

	/**
	 * The cached value of the '{@link #getReferenceMetaClassPair() <em>Reference Meta Class Pair</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMetaClassPair()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceMetaClassPair> referenceMetaClassPair;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolemappingPackage.Literals.COLLABORATION_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityCollaboration getCollaboration() {
		if (collaboration != null && collaboration.eIsProxy()) {
			InternalEObject oldCollaboration = (InternalEObject)collaboration;
			collaboration = (MultiplicityCollaboration)eResolveProxy(oldCollaboration);
			if (collaboration != oldCollaboration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.COLLABORATION_MAPPING__COLLABORATION, oldCollaboration, collaboration));
			}
		}
		return collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityCollaboration basicGetCollaboration() {
		return collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollaboration(MultiplicityCollaboration newCollaboration) {
		MultiplicityCollaboration oldCollaboration = collaboration;
		collaboration = newCollaboration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.COLLABORATION_MAPPING__COLLABORATION, oldCollaboration, collaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceMetaClassPair> getReferenceMetaClassPair() {
		if (referenceMetaClassPair == null) {
			referenceMetaClassPair = new EObjectContainmentEList<ReferenceMetaClassPair>(ReferenceMetaClassPair.class, this, RolemappingPackage.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR);
		}
		return referenceMetaClassPair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolemappingPackage.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR:
				return ((InternalEList<?>)getReferenceMetaClassPair()).basicRemove(otherEnd, msgs);
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
			case RolemappingPackage.COLLABORATION_MAPPING__COLLABORATION:
				if (resolve) return getCollaboration();
				return basicGetCollaboration();
			case RolemappingPackage.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR:
				return getReferenceMetaClassPair();
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
			case RolemappingPackage.COLLABORATION_MAPPING__COLLABORATION:
				setCollaboration((MultiplicityCollaboration)newValue);
				return;
			case RolemappingPackage.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR:
				getReferenceMetaClassPair().clear();
				getReferenceMetaClassPair().addAll((Collection<? extends ReferenceMetaClassPair>)newValue);
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
			case RolemappingPackage.COLLABORATION_MAPPING__COLLABORATION:
				setCollaboration((MultiplicityCollaboration)null);
				return;
			case RolemappingPackage.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR:
				getReferenceMetaClassPair().clear();
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
			case RolemappingPackage.COLLABORATION_MAPPING__COLLABORATION:
				return collaboration != null;
			case RolemappingPackage.COLLABORATION_MAPPING__REFERENCE_META_CLASS_PAIR:
				return referenceMetaClassPair != null && !referenceMetaClassPair.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CollaborationMappingImpl
