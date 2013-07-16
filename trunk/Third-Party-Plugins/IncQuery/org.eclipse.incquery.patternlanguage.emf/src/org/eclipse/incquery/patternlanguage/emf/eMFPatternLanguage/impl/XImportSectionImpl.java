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
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XImport Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.XImportSectionImpl#getPackageImport <em>Package Import</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XImportSectionImpl extends org.eclipse.xtext.xtype.impl.XImportSectionImpl implements XImportSection
{
  /**
   * The cached value of the '{@link #getPackageImport() <em>Package Import</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageImport()
   * @generated
   * @ordered
   */
  protected EList<PackageImport> packageImport;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XImportSectionImpl()
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
    return EMFPatternLanguagePackage.Literals.XIMPORT_SECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PackageImport> getPackageImport()
  {
    if (packageImport == null)
    {
      packageImport = new EObjectContainmentEList<PackageImport>(PackageImport.class, this, EMFPatternLanguagePackage.XIMPORT_SECTION__PACKAGE_IMPORT);
    }
    return packageImport;
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
      case EMFPatternLanguagePackage.XIMPORT_SECTION__PACKAGE_IMPORT:
        return ((InternalEList<?>)getPackageImport()).basicRemove(otherEnd, msgs);
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
      case EMFPatternLanguagePackage.XIMPORT_SECTION__PACKAGE_IMPORT:
        return getPackageImport();
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
      case EMFPatternLanguagePackage.XIMPORT_SECTION__PACKAGE_IMPORT:
        getPackageImport().clear();
        getPackageImport().addAll((Collection<? extends PackageImport>)newValue);
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
      case EMFPatternLanguagePackage.XIMPORT_SECTION__PACKAGE_IMPORT:
        getPackageImport().clear();
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
      case EMFPatternLanguagePackage.XIMPORT_SECTION__PACKAGE_IMPORT:
        return packageImport != null && !packageImport.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //XImportSectionImpl
