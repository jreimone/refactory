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

import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;

import org.emftext.language.refactoring.roles.MultiplicityCollaboration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CollaborationReferenceImpl#getCollaboration <em>Collaboration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollaborationReferenceImpl extends SourceContextImpl implements CollaborationReference {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringSpecificationPackage.Literals.COLLABORATION_REFERENCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION, oldCollaboration, collaboration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION, oldCollaboration, collaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION:
				if (resolve) return getCollaboration();
				return basicGetCollaboration();
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION:
				setCollaboration((MultiplicityCollaboration)newValue);
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION:
				setCollaboration((MultiplicityCollaboration)null);
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION:
				return collaboration != null;
		}
		return super.eIsSet(featureID);
	}

} //CollaborationReferenceImpl
