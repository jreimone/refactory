/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constants Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.ConstantsReferenceImpl#getReferencedConstant <em>Referenced Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantsReferenceImpl extends ObjectReferenceImpl implements ConstantsReference
{
  /**
   * The default value of the '{@link #getReferencedConstant() <em>Referenced Constant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedConstant()
   * @generated
   * @ordered
   */
  protected static final Constants REFERENCED_CONSTANT_EDEFAULT = Constants.INPUT;

  /**
   * The cached value of the '{@link #getReferencedConstant() <em>Referenced Constant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedConstant()
   * @generated
   * @ordered
   */
  protected Constants referencedConstant = REFERENCED_CONSTANT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantsReferenceImpl()
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
    return RefactoringSpecificationPackage.Literals.CONSTANTS_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constants getReferencedConstant()
  {
    return referencedConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedConstant(Constants newReferencedConstant)
  {
    Constants oldReferencedConstant = referencedConstant;
    referencedConstant = newReferencedConstant == null ? REFERENCED_CONSTANT_EDEFAULT : newReferencedConstant;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT, oldReferencedConstant, referencedConstant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT:
        return getReferencedConstant();
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT:
        setReferencedConstant((Constants)newValue);
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT:
        setReferencedConstant(REFERENCED_CONSTANT_EDEFAULT);
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
    switch (featureID)
    {
      case RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT:
        return referencedConstant != REFERENCED_CONSTANT_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (referencedConstant: ");
    result.append(referencedConstant);
    result.append(')');
    return result.toString();
  }

} //ConstantsReferenceImpl
