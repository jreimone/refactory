/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.LogicalCondition#getDependency <em>Dependency</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getLogicalCondition()
 * @model
 * @generated
 */
public interface LogicalCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' reference list.
	 * The list contents are of type {@link org.qualitune.tracing.umt.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getLogicalCondition_Dependency()
	 * @model
	 * @generated
	 */
	EList<Variable> getDependency();

} // LogicalCondition
