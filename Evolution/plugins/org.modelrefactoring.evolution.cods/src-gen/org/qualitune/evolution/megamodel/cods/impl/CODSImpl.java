/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl;

import org.qualitune.evolution.megamodel.cods.CODS;
import org.qualitune.evolution.megamodel.cods.CodsPackage;
import org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CODS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.cods.impl.CODSImpl#getDSES <em>DSES</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CODSImpl extends MegaModelImpl implements CODS {
	/**
   * The cached value of the '{@link #getDSES() <em>DSES</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDSES()
   * @generated
   * @ordered
   */
	protected EList<DomainSpecificEvolutionSpecification> dses;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected CODSImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return CodsPackage.Literals.CODS;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<DomainSpecificEvolutionSpecification> getDSES() {
    if (dses == null)
    {
      dses = new EObjectContainmentEList<DomainSpecificEvolutionSpecification>(DomainSpecificEvolutionSpecification.class, this, CodsPackage.CODS__DSES);
    }
    return dses;
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
      case CodsPackage.CODS__DSES:
        return ((InternalEList<?>)getDSES()).basicRemove(otherEnd, msgs);
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
      case CodsPackage.CODS__DSES:
        return getDSES();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case CodsPackage.CODS__DSES:
        getDSES().clear();
        getDSES().addAll((Collection<? extends DomainSpecificEvolutionSpecification>)newValue);
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
      case CodsPackage.CODS__DSES:
        getDSES().clear();
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
      case CodsPackage.CODS__DSES:
        return dses != null && !dses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CODSImpl
