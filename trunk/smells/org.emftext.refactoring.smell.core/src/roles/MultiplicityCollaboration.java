/**
 */
package roles;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Collaboration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link roles.MultiplicityCollaboration#getSourceMultiplicity <em>Source Multiplicity</em>}</li>
 *   <li>{@link roles.MultiplicityCollaboration#getTargetMultiplicity <em>Target Multiplicity</em>}</li>
 *   <li>{@link roles.MultiplicityCollaboration#getSourceName <em>Source Name</em>}</li>
 *   <li>{@link roles.MultiplicityCollaboration#getTargetName <em>Target Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see roles.RolesPackage#getMultiplicityCollaboration()
 * @model abstract="true"
 * @generated
 */
public interface MultiplicityCollaboration extends Collaboration {
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
	 * @see roles.RolesPackage#getMultiplicityCollaboration_SourceMultiplicity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Multiplicity getSourceMultiplicity();

	/**
	 * Sets the value of the '{@link roles.MultiplicityCollaboration#getSourceMultiplicity <em>Source Multiplicity</em>}' containment reference.
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
	 * @see roles.RolesPackage#getMultiplicityCollaboration_TargetMultiplicity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Multiplicity getTargetMultiplicity();

	/**
	 * Sets the value of the '{@link roles.MultiplicityCollaboration#getTargetMultiplicity <em>Target Multiplicity</em>}' containment reference.
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
	 * @see roles.RolesPackage#getMultiplicityCollaboration_SourceName()
	 * @model
	 * @generated
	 */
	String getSourceName();

	/**
	 * Sets the value of the '{@link roles.MultiplicityCollaboration#getSourceName <em>Source Name</em>}' attribute.
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
	 * @see roles.RolesPackage#getMultiplicityCollaboration_TargetName()
	 * @model
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link roles.MultiplicityCollaboration#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);

} // MultiplicityCollaboration
