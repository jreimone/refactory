/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;

import org.emftext.language.refactoring.roles.MultiplicityRelation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationReferenceImpl extends SourceContextImpl implements RelationReference {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringSpecificationPackage.Literals.RELATION_REFERENCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION, oldRelation, relation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION:
				if (resolve) return getRelation();
				return basicGetRelation();
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
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION:
				setRelation((MultiplicityRelation)newValue);
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
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION:
				setRelation((MultiplicityRelation)null);
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
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION:
				return relation != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationReferenceImpl
