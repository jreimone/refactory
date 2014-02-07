/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.MetamodelImport#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.MetamodelImport#getShortcut <em>Shortcut</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.coed.CoedPackage#getMetamodelImport()
 * @model
 * @generated
 */
public interface MetamodelImport extends EObject
{
  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' reference.
   * @see #setMetamodel(EPackage)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getMetamodelImport_Metamodel()
   * @model required="true"
   * @generated
   */
  EPackage getMetamodel();

  /**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.MetamodelImport#getMetamodel <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' reference.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(EPackage value);

  /**
   * Returns the value of the '<em><b>Shortcut</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shortcut</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shortcut</em>' attribute.
   * @see #setShortcut(String)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getMetamodelImport_Shortcut()
   * @model required="true"
   * @generated
   */
  String getShortcut();

  /**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.MetamodelImport#getShortcut <em>Shortcut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Shortcut</em>' attribute.
   * @see #getShortcut()
   * @generated
   */
  void setShortcut(String value);

} // MetamodelImport
