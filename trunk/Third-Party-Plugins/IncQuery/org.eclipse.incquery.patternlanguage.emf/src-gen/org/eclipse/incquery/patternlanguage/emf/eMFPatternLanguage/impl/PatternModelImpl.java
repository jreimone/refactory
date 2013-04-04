/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ImportDeclaration;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;

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
   * The cached value of the '{@link #getImportPackages() <em>Import Packages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportPackages()
   * @generated
   * @ordered
   */
  protected EList<ImportDeclaration> importPackages;

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
  public EList<ImportDeclaration> getImportPackages()
  {
    if (importPackages == null)
    {
      importPackages = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this, EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES);
    }
    return importPackages;
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
        return ((InternalEList<?>)getImportPackages()).basicRemove(otherEnd, msgs);
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EMFPatternLanguagePackage.PATTERN_MODEL__IMPORT_PACKAGES:
        getImportPackages().clear();
        getImportPackages().addAll((Collection<? extends ImportDeclaration>)newValue);
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
        getImportPackages().clear();
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
        return importPackages != null && !importPackages.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PatternModelImpl
