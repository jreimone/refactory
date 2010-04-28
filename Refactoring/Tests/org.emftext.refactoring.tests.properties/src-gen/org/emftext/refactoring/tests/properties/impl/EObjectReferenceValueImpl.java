/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.refactoring.tests.properties.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.refactoring.tests.properties.EObjectReferenceValue;
import org.emftext.refactoring.tests.properties.PropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Reference Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.tests.properties.impl.EObjectReferenceValueImpl#getObjectReference <em>Object Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectReferenceValueImpl extends ValueImpl implements EObjectReferenceValue {
	/**
   * The cached value of the '{@link #getObjectReference() <em>Object Reference</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getObjectReference()
   * @generated
   * @ordered
   */
	protected EObject objectReference;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected EObjectReferenceValueImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PropertiesPackage.Literals.EOBJECT_REFERENCE_VALUE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EObject getObjectReference() {
    if (objectReference != null && objectReference.eIsProxy())
    {
      InternalEObject oldObjectReference = (InternalEObject)objectReference;
      objectReference = eResolveProxy(oldObjectReference);
      if (objectReference != oldObjectReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE, oldObjectReference, objectReference));
      }
    }
    return objectReference;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EObject basicGetObjectReference() {
    return objectReference;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setObjectReference(EObject newObjectReference) {
    EObject oldObjectReference = objectReference;
    objectReference = newObjectReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE, oldObjectReference, objectReference));
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
      case PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE:
        if (resolve) return getObjectReference();
        return basicGetObjectReference();
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
      case PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE:
        setObjectReference((EObject)newValue);
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
      case PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE:
        setObjectReference((EObject)null);
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
      case PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE:
        return objectReference != null;
    }
    return super.eIsSet(featureID);
  }

} //EObjectReferenceValueImpl
