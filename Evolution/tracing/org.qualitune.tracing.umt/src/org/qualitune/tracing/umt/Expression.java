/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.Expression#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends VariableProcessingInstruction {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.qualitune.tracing.umt.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getExpression_Parameters()
	 * @model
	 * @generated
	 */
	EList<Variable> getParameters();

} // Expression
