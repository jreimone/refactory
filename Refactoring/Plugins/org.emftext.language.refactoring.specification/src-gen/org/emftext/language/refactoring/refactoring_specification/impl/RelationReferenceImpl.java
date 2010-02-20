/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;

import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.roles.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl#getRelationRole <em>Relation Role</em>}</li>
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
	protected Relation relation;

	/**
	 * The cached value of the '{@link #getRelationRole() <em>Relation Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationRole()
	 * @generated
	 * @ordered
	 */
	protected RoleReference relationRole;

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
	public Relation getRelation() {
		if (relation != null && relation.eIsProxy()) {
			InternalEObject oldRelation = (InternalEObject)relation;
			relation = (Relation)eResolveProxy(oldRelation);
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
	public Relation basicGetRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(Relation newRelation) {
		Relation oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleReference getRelationRole() {
		return relationRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationRole(RoleReference newRelationRole, NotificationChain msgs) {
		RoleReference oldRelationRole = relationRole;
		relationRole = newRelationRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE, oldRelationRole, newRelationRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationRole(RoleReference newRelationRole) {
		if (newRelationRole != relationRole) {
			NotificationChain msgs = null;
			if (relationRole != null)
				msgs = ((InternalEObject)relationRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE, null, msgs);
			if (newRelationRole != null)
				msgs = ((InternalEObject)newRelationRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE, null, msgs);
			msgs = basicSetRelationRole(newRelationRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE, newRelationRole, newRelationRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE:
				return basicSetRelationRole(null, msgs);
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
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION:
				if (resolve) return getRelation();
				return basicGetRelation();
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE:
				return getRelationRole();
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
				setRelation((Relation)newValue);
				return;
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE:
				setRelationRole((RoleReference)newValue);
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
				setRelation((Relation)null);
				return;
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE:
				setRelationRole((RoleReference)null);
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
			case RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION_ROLE:
				return relationRole != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationReferenceImpl
