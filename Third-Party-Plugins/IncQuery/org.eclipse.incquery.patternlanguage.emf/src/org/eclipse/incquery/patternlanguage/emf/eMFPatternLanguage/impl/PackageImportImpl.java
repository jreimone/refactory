/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PackageImportImpl#getEPackage <em>EPackage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImportImpl extends MinimalEObjectImpl.Container implements PackageImport
{
  /**
   * The cached value of the '{@link #getEPackage() <em>EPackage</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEPackage()
   * @generated
   * @ordered
   */
  protected EPackage ePackage;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageImportImpl()
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
    return EMFPatternLanguagePackage.Literals.PACKAGE_IMPORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage getEPackage()
  {
    if (ePackage != null && ePackage.eIsProxy())
    {
      InternalEObject oldEPackage = (InternalEObject)ePackage;
      ePackage = (EPackage)eResolveProxy(oldEPackage);
      if (ePackage != oldEPackage)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMFPatternLanguagePackage.PACKAGE_IMPORT__EPACKAGE, oldEPackage, ePackage));
      }
    }
    return ePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage basicGetEPackage()
  {
    return ePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEPackage(EPackage newEPackage)
  {
    EPackage oldEPackage = ePackage;
    ePackage = newEPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.PACKAGE_IMPORT__EPACKAGE, oldEPackage, ePackage));
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
      case EMFPatternLanguagePackage.PACKAGE_IMPORT__EPACKAGE:
        if (resolve) return getEPackage();
        return basicGetEPackage();
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
      case EMFPatternLanguagePackage.PACKAGE_IMPORT__EPACKAGE:
        setEPackage((EPackage)newValue);
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
      case EMFPatternLanguagePackage.PACKAGE_IMPORT__EPACKAGE:
        setEPackage((EPackage)null);
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
      case EMFPatternLanguagePackage.PACKAGE_IMPORT__EPACKAGE:
        return ePackage != null;
    }
    return super.eIsSet(featureID);
  }

} //PackageImportImpl
