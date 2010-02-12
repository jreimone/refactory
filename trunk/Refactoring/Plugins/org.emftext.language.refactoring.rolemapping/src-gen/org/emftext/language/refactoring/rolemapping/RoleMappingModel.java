/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getTargetMetamodel <em>Target Metamodel</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRoleMappingModel()
 * @model
 * @generated
 */
public interface RoleMappingModel extends EObject {
	/**
   * Returns the value of the '<em><b>Target Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Target Metamodel</em>' reference.
   * @see #setTargetMetamodel(EPackage)
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRoleMappingModel_TargetMetamodel()
   * @model required="true"
   * @generated
   */
	EPackage getTargetMetamodel();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getTargetMetamodel <em>Target Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Metamodel</em>' reference.
   * @see #getTargetMetamodel()
   * @generated
   */
	void setTargetMetamodel(EPackage value);

	/**
   * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.refactoring.rolemapping.Mapping}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Mappings</em>' containment reference list.
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRoleMappingModel_Mappings()
   * @model containment="true" required="true"
   * @generated
   */
	EList<Mapping> getMappings();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRoleMappingModel_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.RoleMappingModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // RoleMappingModel
