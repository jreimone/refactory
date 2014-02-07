/**
 */
package org.modelrefactoring.evolution.coed.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.MetamodelImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metamodel Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.MetamodelImportImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.MetamodelImportImpl#getShortcut <em>Shortcut</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetamodelImportImpl extends MinimalEObjectImpl.Container implements MetamodelImport
{
  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected EPackage metamodel;

  /**
   * The default value of the '{@link #getShortcut() <em>Shortcut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortcut()
   * @generated
   * @ordered
   */
  protected static final String SHORTCUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortcut() <em>Shortcut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortcut()
   * @generated
   * @ordered
   */
  protected String shortcut = SHORTCUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MetamodelImportImpl()
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
    return CoedPackage.Literals.METAMODEL_IMPORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage getMetamodel()
  {
    if (metamodel != null && metamodel.eIsProxy())
    {
      InternalEObject oldMetamodel = (InternalEObject)metamodel;
      metamodel = (EPackage)eResolveProxy(oldMetamodel);
      if (metamodel != oldMetamodel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoedPackage.METAMODEL_IMPORT__METAMODEL, oldMetamodel, metamodel));
      }
    }
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage basicGetMetamodel()
  {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodel(EPackage newMetamodel)
  {
    EPackage oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.METAMODEL_IMPORT__METAMODEL, oldMetamodel, metamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShortcut()
  {
    return shortcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortcut(String newShortcut)
  {
    String oldShortcut = shortcut;
    shortcut = newShortcut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.METAMODEL_IMPORT__SHORTCUT, oldShortcut, shortcut));
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
      case CoedPackage.METAMODEL_IMPORT__METAMODEL:
        if (resolve) return getMetamodel();
        return basicGetMetamodel();
      case CoedPackage.METAMODEL_IMPORT__SHORTCUT:
        return getShortcut();
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
      case CoedPackage.METAMODEL_IMPORT__METAMODEL:
        setMetamodel((EPackage)newValue);
        return;
      case CoedPackage.METAMODEL_IMPORT__SHORTCUT:
        setShortcut((String)newValue);
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
      case CoedPackage.METAMODEL_IMPORT__METAMODEL:
        setMetamodel((EPackage)null);
        return;
      case CoedPackage.METAMODEL_IMPORT__SHORTCUT:
        setShortcut(SHORTCUT_EDEFAULT);
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
      case CoedPackage.METAMODEL_IMPORT__METAMODEL:
        return metamodel != null;
      case CoedPackage.METAMODEL_IMPORT__SHORTCUT:
        return SHORTCUT_EDEFAULT == null ? shortcut != null : !SHORTCUT_EDEFAULT.equals(shortcut);
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
    result.append(" (shortcut: ");
    result.append(shortcut);
    result.append(')');
    return result.toString();
  }

} //MetamodelImportImpl
