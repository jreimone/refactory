/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.refactoring.roles.Multiplicity;
import org.emftext.language.refactoring.roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.impl.MultiplicityImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.impl.MultiplicityImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityImpl extends EObjectImpl implements Multiplicity {
	/**
   * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
	protected static final int LOWER_BOUND_EDEFAULT = 0;

	/**
   * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
	protected int lowerBound = LOWER_BOUND_EDEFAULT;

	/**
   * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
	protected static final int UPPER_BOUND_EDEFAULT = 0;

	/**
   * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
	protected int upperBound = UPPER_BOUND_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MultiplicityImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RolesPackage.Literals.MULTIPLICITY;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getLowerBound() {
    return lowerBound;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setLowerBound(int newLowerBound) {
    int oldLowerBound = lowerBound;
    lowerBound = newLowerBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY__LOWER_BOUND, oldLowerBound, lowerBound));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getUpperBound() {
    return upperBound;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setUpperBound(int newUpperBound) {
    int oldUpperBound = upperBound;
    upperBound = newUpperBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY__UPPER_BOUND, oldUpperBound, upperBound));
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
      case RolesPackage.MULTIPLICITY__LOWER_BOUND:
        return getLowerBound();
      case RolesPackage.MULTIPLICITY__UPPER_BOUND:
        return getUpperBound();
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
      case RolesPackage.MULTIPLICITY__LOWER_BOUND:
        setLowerBound((Integer)newValue);
        return;
      case RolesPackage.MULTIPLICITY__UPPER_BOUND:
        setUpperBound((Integer)newValue);
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
      case RolesPackage.MULTIPLICITY__LOWER_BOUND:
        setLowerBound(LOWER_BOUND_EDEFAULT);
        return;
      case RolesPackage.MULTIPLICITY__UPPER_BOUND:
        setUpperBound(UPPER_BOUND_EDEFAULT);
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
      case RolesPackage.MULTIPLICITY__LOWER_BOUND:
        return lowerBound != LOWER_BOUND_EDEFAULT;
      case RolesPackage.MULTIPLICITY__UPPER_BOUND:
        return upperBound != UPPER_BOUND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (lowerBound: ");
    result.append(lowerBound);
    result.append(", upperBound: ");
    result.append(upperBound);
    result.append(')');
    return result.toString();
  }

} //MultiplicityImpl
