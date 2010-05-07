/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.TraceObject;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.TraceObjectImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.TraceObjectImpl#getAppliedRole <em>Applied Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceObjectImpl extends EObjectImpl implements TraceObject
{
  /**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
  protected EObject container;

  /**
	 * The cached value of the '{@link #getAppliedRole() <em>Applied Role</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAppliedRole()
	 * @generated
	 * @ordered
	 */
  protected Role appliedRole;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TraceObjectImpl()
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
		return RefactoringSpecificationPackage.Literals.TRACE_OBJECT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EObject getContainer()
  {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.TRACE_OBJECT__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EObject basicGetContainer()
  {
		return container;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setContainer(EObject newContainer)
  {
		EObject oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.TRACE_OBJECT__CONTAINER, oldContainer, container));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Role getAppliedRole()
  {
		if (appliedRole != null && appliedRole.eIsProxy()) {
			InternalEObject oldAppliedRole = (InternalEObject)appliedRole;
			appliedRole = (Role)eResolveProxy(oldAppliedRole);
			if (appliedRole != oldAppliedRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.TRACE_OBJECT__APPLIED_ROLE, oldAppliedRole, appliedRole));
			}
		}
		return appliedRole;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Role basicGetAppliedRole()
  {
		return appliedRole;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAppliedRole(Role newAppliedRole)
  {
		Role oldAppliedRole = appliedRole;
		appliedRole = newAppliedRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.TRACE_OBJECT__APPLIED_ROLE, oldAppliedRole, appliedRole));
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
			case RefactoringSpecificationPackage.TRACE_OBJECT__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case RefactoringSpecificationPackage.TRACE_OBJECT__APPLIED_ROLE:
				if (resolve) return getAppliedRole();
				return basicGetAppliedRole();
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
			case RefactoringSpecificationPackage.TRACE_OBJECT__CONTAINER:
				setContainer((EObject)newValue);
				return;
			case RefactoringSpecificationPackage.TRACE_OBJECT__APPLIED_ROLE:
				setAppliedRole((Role)newValue);
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
			case RefactoringSpecificationPackage.TRACE_OBJECT__CONTAINER:
				setContainer((EObject)null);
				return;
			case RefactoringSpecificationPackage.TRACE_OBJECT__APPLIED_ROLE:
				setAppliedRole((Role)null);
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
			case RefactoringSpecificationPackage.TRACE_OBJECT__CONTAINER:
				return container != null;
			case RefactoringSpecificationPackage.TRACE_OBJECT__APPLIED_ROLE:
				return appliedRole != null;
		}
		return super.eIsSet(featureID);
	}

} //TraceObjectImpl
