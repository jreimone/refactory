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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Assignment Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectAssignmentCommandImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ObjectAssignmentCommandImpl extends EObjectImpl implements ObjectAssignmentCommand
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ObjectAssignmentCommandImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return RefactoringSpecificationPackage.Literals.OBJECT_ASSIGNMENT_COMMAND;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VariableAssignment getDeclaration()
  {
		if (eContainerFeatureID() != RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION) return null;
		return (VariableAssignment)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetDeclaration(VariableAssignment newDeclaration, NotificationChain msgs)
  {
		msgs = eBasicSetContainer((InternalEObject)newDeclaration, RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION, msgs);
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDeclaration(VariableAssignment newDeclaration)
  {
		if (newDeclaration != eInternalContainer() || (eContainerFeatureID() != RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION && newDeclaration != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION, newDeclaration, newDeclaration));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
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
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
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
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
		switch (eContainerFeatureID()) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
				return getDeclaration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
				setDeclaration((VariableAssignment)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
				setDeclaration((VariableAssignment)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND__DECLARATION:
				return getDeclaration() != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectAssignmentCommandImpl
