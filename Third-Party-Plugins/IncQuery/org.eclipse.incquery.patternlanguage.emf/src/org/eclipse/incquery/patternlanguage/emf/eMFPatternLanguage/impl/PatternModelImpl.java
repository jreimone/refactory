/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PatternModelImpl#getImportPackages <em>Import Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternModelImpl extends org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl implements PatternModel
{
  /**
   * The cached value of the '{@link #getImportPackages() <em>Import Packages</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportPackages()
   * @generated
   * @ordered
   */
  protected XImportSection importPackages;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternModelImpl()
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
    return EMFPatternLanguagePackage.Literals.PATTERN_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XImportSection getImportPackages()
  {
    return importPackages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImportPackages(XImportSection newImportPackages, NotificationChain msgs)
  {
    XImportSection oldImportPackages = importPackages;
    importPackages = newImportPackages;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES, oldImportPackages, newImportPackages);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportPackages(XImportSection newImportPackages)
  {
    if (newImportPackages != importPackages)
    {
      NotificationChain msgs = null;
      if (importPackages != null)
        msgs = ((InternalEObject)importPackages).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES, null, msgs);
      if (newImportPackages != null)
        msgs = ((InternalEObject)newImportPackages).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES, null, msgs);
      msgs = basicSetImportPackages(newImportPackages, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES, newImportPackages, newImportPackages));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES:
        return basicSetImportPackages(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES:
        return getImportPackages();
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
      case EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES:
        setImportPackages((XImportSection)newValue);
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
      case EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES:
        setImportPackages((XImportSection)null);
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
      case EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES:
        return importPackages != null;
    }
    return super.eIsSet(featureID);
  }

} //PatternModelImpl
