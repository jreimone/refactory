/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

import org.emftext.language.refactoring.roles.MultiplicityRelation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.RelationMappingImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.impl.RelationMappingImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationMappingImpl extends EObjectImpl implements RelationMapping {
	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityRelation relation;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolemappingPackage.Literals.RELATION_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityRelation getRelation() {
		if (relation != null && relation.eIsProxy()) {
			InternalEObject oldRelation = (InternalEObject)relation;
			relation = (MultiplicityRelation)eResolveProxy(oldRelation);
			if (relation != oldRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.RELATION_MAPPING__RELATION, oldRelation, relation));
			}
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityRelation basicGetRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(MultiplicityRelation newRelation) {
		MultiplicityRelation oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.RELATION_MAPPING__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getReferences() {
		if (references == null) {
			references = new EObjectResolvingEList<EReference>(EReference.class, this, RolemappingPackage.RELATION_MAPPING__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RolemappingPackage.RELATION_MAPPING__RELATION:
				if (resolve) return getRelation();
				return basicGetRelation();
			case RolemappingPackage.RELATION_MAPPING__REFERENCES:
				return getReferences();
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
			case RolemappingPackage.RELATION_MAPPING__RELATION:
				setRelation((MultiplicityRelation)newValue);
				return;
			case RolemappingPackage.RELATION_MAPPING__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends EReference>)newValue);
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
			case RolemappingPackage.RELATION_MAPPING__RELATION:
				setRelation((MultiplicityRelation)null);
				return;
			case RolemappingPackage.RELATION_MAPPING__REFERENCES:
				getReferences().clear();
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
			case RolemappingPackage.RELATION_MAPPING__RELATION:
				return relation != null;
			case RolemappingPackage.RELATION_MAPPING__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationMappingImpl
