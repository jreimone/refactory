/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;
import org.qualitune.evolution.megamodel.architecture.Model;
import org.qualitune.evolution.megamodel.architecture.ReferenceModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.impl.ModelImpl#getConformsTo <em>Conforms To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelImpl extends EObjectImpl implements Model {
	/**
   * The cached value of the '{@link #getConformsTo() <em>Conforms To</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getConformsTo()
   * @generated
   * @ordered
   */
	protected ReferenceModel conformsTo;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ModelImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ArchitecturePackage.Literals.MODEL;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ReferenceModel getConformsTo() {
    if (conformsTo != null && conformsTo.eIsProxy())
    {
      InternalEObject oldConformsTo = (InternalEObject)conformsTo;
      conformsTo = (ReferenceModel)eResolveProxy(oldConformsTo);
      if (conformsTo != oldConformsTo)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.MODEL__CONFORMS_TO, oldConformsTo, conformsTo));
      }
    }
    return conformsTo;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ReferenceModel basicGetConformsTo() {
    return conformsTo;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setConformsTo(ReferenceModel newConformsTo) {
    ReferenceModel oldConformsTo = conformsTo;
    conformsTo = newConformsTo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MODEL__CONFORMS_TO, oldConformsTo, conformsTo));
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
      case ArchitecturePackage.MODEL__CONFORMS_TO:
        if (resolve) return getConformsTo();
        return basicGetConformsTo();
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
      case ArchitecturePackage.MODEL__CONFORMS_TO:
        setConformsTo((ReferenceModel)newValue);
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
      case ArchitecturePackage.MODEL__CONFORMS_TO:
        setConformsTo((ReferenceModel)null);
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
      case ArchitecturePackage.MODEL__CONFORMS_TO:
        return conformsTo != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
