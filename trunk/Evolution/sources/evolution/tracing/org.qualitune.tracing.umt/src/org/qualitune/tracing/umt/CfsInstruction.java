/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cfs Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.CfsInstruction#getConditions <em>Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getCfsInstruction()
 * @model abstract="true"
 * @generated
 */
public interface CfsInstruction extends VapodiInstruction {

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' reference list.
	 * The list contents are of type {@link org.qualitune.tracing.umt.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getCfsInstruction_Conditions()
	 * @model
	 * @generated
	 */
	EList<Condition> getConditions();
} // CfsInstruction
