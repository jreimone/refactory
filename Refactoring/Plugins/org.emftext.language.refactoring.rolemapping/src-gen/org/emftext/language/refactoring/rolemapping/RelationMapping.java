/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.emftext.language.refactoring.roles.MultiplicityRelation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.RelationMapping#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.RelationMapping#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRelationMapping()
 * @model
 * @generated
 */
public interface RelationMapping extends EObject {
	/**
   * Returns the value of the '<em><b>Relation</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Relation</em>' reference.
   * @see #setRelation(MultiplicityRelation)
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRelationMapping_Relation()
   * @model required="true"
   * @generated
   */
	MultiplicityRelation getRelation();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.RelationMapping#getRelation <em>Relation</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation</em>' reference.
   * @see #getRelation()
   * @generated
   */
	void setRelation(MultiplicityRelation value);

	/**
   * Returns the value of the '<em><b>References</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>References</em>' reference list.
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getRelationMapping_References()
   * @model required="true"
   * @generated
   */
	EList<EReference> getReferences();

} // RelationMapping
