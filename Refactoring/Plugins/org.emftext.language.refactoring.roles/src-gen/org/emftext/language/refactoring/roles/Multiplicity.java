/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.Multiplicity#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.Multiplicity#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicity()
 * @model
 * @generated
 */
public interface Multiplicity extends EObject {
	/**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(int)
   * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicity_LowerBound()
   * @model required="true"
   * @generated
   */
	int getLowerBound();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.roles.Multiplicity#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
	void setLowerBound(int value);

	/**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(int)
   * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicity_UpperBound()
   * @model required="true"
   * @generated
   */
	int getUpperBound();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.roles.Multiplicity#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
	void setUpperBound(int value);

} // Multiplicity
