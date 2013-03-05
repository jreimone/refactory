/**
 */
package org.qualitune.tracing.umt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Processing Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.VariableProcessingInstruction#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getVariableProcessingInstruction()
 * @model abstract="true"
 * @generated
 */
public interface VariableProcessingInstruction extends Instruction {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(Variable)
	 * @see org.qualitune.tracing.umt.UmtPackage#getVariableProcessingInstruction_Destination()
	 * @model required="true"
	 * @generated
	 */
	Variable getDestination();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.VariableProcessingInstruction#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Variable value);

} // VariableProcessingInstruction
