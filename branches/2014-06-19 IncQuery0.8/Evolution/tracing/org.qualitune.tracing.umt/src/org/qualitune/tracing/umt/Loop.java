/**
 */
package org.qualitune.tracing.umt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.Loop#getBody <em>Body</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.Loop#getInvariant <em>Invariant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends NumerousKindsOfBranches {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(InstructionBlock)
	 * @see org.qualitune.tracing.umt.UmtPackage#getLoop_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InstructionBlock getBody();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.Loop#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(InstructionBlock value);

	/**
	 * Returns the value of the '<em><b>Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant</em>' reference.
	 * @see #setInvariant(Condition)
	 * @see org.qualitune.tracing.umt.UmtPackage#getLoop_Invariant()
	 * @model
	 * @generated
	 */
	Condition getInvariant();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.Loop#getInvariant <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invariant</em>' reference.
	 * @see #getInvariant()
	 * @generated
	 */
	void setInvariant(Condition value);

} // Loop
