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

import org.emftext.language.refactoring.refactoring_specification.ObjectReference;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.TRACE;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TRACE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.TRACEImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.TRACEImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TRACEImpl extends ObjectAssignmentCommandImpl implements TRACE {
	/**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
	protected ObjectReference reference;

	/**
   * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
	protected Role role;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TRACEImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RefactoringSpecificationPackage.Literals.TRACE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ObjectReference getReference() {
    return reference;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetReference(ObjectReference newReference, NotificationChain msgs) {
    ObjectReference oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.TRACE__REFERENCE, oldReference, newReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setReference(ObjectReference newReference) {
    if (newReference != reference)
    {
      NotificationChain msgs = null;
      if (reference != null)
        msgs = ((InternalEObject)reference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.TRACE__REFERENCE, null, msgs);
      if (newReference != null)
        msgs = ((InternalEObject)newReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.TRACE__REFERENCE, null, msgs);
      msgs = basicSetReference(newReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.TRACE__REFERENCE, newReference, newReference));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Role getRole() {
    if (role != null && role.eIsProxy())
    {
      InternalEObject oldRole = (InternalEObject)role;
      role = (Role)eResolveProxy(oldRole);
      if (role != oldRole)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.TRACE__ROLE, oldRole, role));
      }
    }
    return role;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Role basicGetRole() {
    return role;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setRole(Role newRole) {
    Role oldRole = role;
    role = newRole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.TRACE__ROLE, oldRole, role));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.TRACE__REFERENCE:
        return basicSetReference(null, msgs);
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.TRACE__REFERENCE:
        return getReference();
      case RefactoringSpecificationPackage.TRACE__ROLE:
        if (resolve) return getRole();
        return basicGetRole();
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.TRACE__REFERENCE:
        setReference((ObjectReference)newValue);
        return;
      case RefactoringSpecificationPackage.TRACE__ROLE:
        setRole((Role)newValue);
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.TRACE__REFERENCE:
        setReference((ObjectReference)null);
        return;
      case RefactoringSpecificationPackage.TRACE__ROLE:
        setRole((Role)null);
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.TRACE__REFERENCE:
        return reference != null;
      case RefactoringSpecificationPackage.TRACE__ROLE:
        return role != null;
    }
    return super.eIsSet(featureID);
  }

} //TRACEImpl
