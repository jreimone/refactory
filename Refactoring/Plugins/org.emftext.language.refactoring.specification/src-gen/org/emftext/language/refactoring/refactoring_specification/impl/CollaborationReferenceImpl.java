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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.ObjectReference;
import org.emftext.language.refactoring.refactoring_specification.ObjectRemoval;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;

import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CollaborationReferenceImpl#getDeclaration <em>Declaration</em>}</li>
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
	public VariableAssignment getDeclaration() {
		if (eContainerFeatureID() != RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION) return null;
		return (VariableAssignment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(VariableAssignment newDeclaration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclaration, RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(VariableAssignment newDeclaration) {
		if (newDeclaration != eInternalContainer() || (eContainerFeatureID() != RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION && newDeclaration != null)) {
			if (EcoreUtil.isAncestor(this, newDeclaration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT, VariableAssignment.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION, newDeclaration, newDeclaration));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaration((VariableAssignment)otherEnd, msgs);
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				return basicSetDeclaration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				return eInternalContainer().eInverseRemove(this, RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT, VariableAssignment.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				return getDeclaration();
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				setDeclaration((VariableAssignment)newValue);
				return;
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				setDeclaration((VariableAssignment)null);
				return;
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
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION:
				return getDeclaration() != null;
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__COLLABORATION:
				return collaboration != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TargetContext.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObjectRemoval.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObjectAssignmentCommand.class) {
			switch (derivedFeatureID) {
				case RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION: return RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TargetContext.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObjectRemoval.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObjectAssignmentCommand.class) {
			switch (baseFeatureID) {
				case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION: return RefactoringSpecificationPackage.COLLABORATION_REFERENCE__DECLARATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CollaborationReferenceImpl
