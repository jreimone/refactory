/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.VariableAssignment#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends VariableProcessingInstruction {
	/**
	 * Returns the value of the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #setAssignedExpression(Expression)
	 * @see org.qualitune.tracing.umt.UmtPackage#getVariableAssignment_AssignedExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getAssignedExpression();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.VariableAssignment#getAssignedExpression <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #getAssignedExpression()
	 * @generated
	 */
	void setAssignedExpression(Expression value);

} // VariableAssignment
