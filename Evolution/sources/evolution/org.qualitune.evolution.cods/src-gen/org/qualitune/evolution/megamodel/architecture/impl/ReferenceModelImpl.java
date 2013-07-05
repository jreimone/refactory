/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;
import org.qualitune.evolution.megamodel.architecture.ReferenceModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.ReferenceModelImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReferenceModelImpl extends ModelImpl implements ReferenceModel {
	/**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
	protected EPackage package_;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ReferenceModelImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ArchitecturePackage.Literals.REFERENCE_MODEL;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EPackage getPackage() {
    if (package_ != null && package_.eIsProxy())
    {
      InternalEObject oldPackage = (InternalEObject)package_;
      package_ = (EPackage)eResolveProxy(oldPackage);
      if (package_ != oldPackage)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.REFERENCE_MODEL__PACKAGE, oldPackage, package_));
      }
    }
    return package_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EPackage basicGetPackage() {
    return package_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setPackage(EPackage newPackage) {
    EPackage oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.REFERENCE_MODEL__PACKAGE, oldPackage, package_));
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
      case ArchitecturePackage.REFERENCE_MODEL__PACKAGE:
        if (resolve) return getPackage();
        return basicGetPackage();
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
      case ArchitecturePackage.REFERENCE_MODEL__PACKAGE:
        setPackage((EPackage)newValue);
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
      case ArchitecturePackage.REFERENCE_MODEL__PACKAGE:
        setPackage((EPackage)null);
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
      case ArchitecturePackage.REFERENCE_MODEL__PACKAGE:
        return package_ != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceModelImpl
