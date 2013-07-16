/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.EntityTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ClassTypeImpl#getClassname <em>Classname</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassTypeImpl extends EntityTypeImpl implements ClassType
{
  /**
   * The cached value of the '{@link #getClassname() <em>Classname</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassname()
   * @generated
   * @ordered
   */
  protected EClassifier classname;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassTypeImpl()
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
    return EMFPatternLanguagePackage.Literals.CLASS_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier getClassname()
  {
    if (classname != null && classname.eIsProxy())
    {
      InternalEObject oldClassname = (InternalEObject)classname;
      classname = (EClassifier)eResolveProxy(oldClassname);
      if (classname != oldClassname)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMFPatternLanguagePackage.CLASS_TYPE__CLASSNAME, oldClassname, classname));
      }
    }
    return classname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetClassname()
  {
    return classname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassname(EClassifier newClassname)
  {
    EClassifier oldClassname = classname;
    classname = newClassname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.CLASS_TYPE__CLASSNAME, oldClassname, classname));
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
      case EMFPatternLanguagePackage.CLASS_TYPE__CLASSNAME:
        if (resolve) return getClassname();
        return basicGetClassname();
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
      case EMFPatternLanguagePackage.CLASS_TYPE__CLASSNAME:
        setClassname((EClassifier)newValue);
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
      case EMFPatternLanguagePackage.CLASS_TYPE__CLASSNAME:
        setClassname((EClassifier)null);
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
      case EMFPatternLanguagePackage.CLASS_TYPE__CLASSNAME:
        return classname != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassTypeImpl
