/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceMultiplicity <em>Source Multiplicity</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetMultiplicity <em>Target Multiplicity</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceName <em>Source Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetName <em>Target Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicityRelation()
 * @model abstract="true"
 * @generated
 */
public interface MultiplicityRelation extends Relation {
	/**
   * Returns the value of the '<em><b>Source Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Source Multiplicity</em>' containment reference.
   * @see #setSourceMultiplicity(Multiplicity)
   * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicityRelation_SourceMultiplicity()
   * @model containment="true" required="true"
   * @generated
   */
	Multiplicity getSourceMultiplicity();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceMultiplicity <em>Source Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Multiplicity</em>' containment reference.
   * @see #getSourceMultiplicity()
   * @generated
   */
	void setSourceMultiplicity(Multiplicity value);

	/**
   * Returns the value of the '<em><b>Target Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Target Multiplicity</em>' containment reference.
   * @see #setTargetMultiplicity(Multiplicity)
   * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicityRelation_TargetMultiplicity()
   * @model containment="true" required="true"
   * @generated
   */
	Multiplicity getTargetMultiplicity();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetMultiplicity <em>Target Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Multiplicity</em>' containment reference.
   * @see #getTargetMultiplicity()
   * @generated
   */
	void setTargetMultiplicity(Multiplicity value);

	/**
   * Returns the value of the '<em><b>Source Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Source Name</em>' attribute.
   * @see #setSourceName(String)
   * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicityRelation_SourceName()
   * @model
   * @generated
   */
	String getSourceName();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getSourceName <em>Source Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Name</em>' attribute.
   * @see #getSourceName()
   * @generated
   */
	void setSourceName(String value);

	/**
   * Returns the value of the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Target Name</em>' attribute.
   * @see #setTargetName(String)
   * @see org.emftext.language.refactoring.roles.RolesPackage#getMultiplicityRelation_TargetName()
   * @model
   * @generated
   */
	String getTargetName();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.roles.MultiplicityRelation#getTargetName <em>Target Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Name</em>' attribute.
   * @see #getTargetName()
   * @generated
   */
	void setTargetName(String value);

} // MultiplicityRelation
