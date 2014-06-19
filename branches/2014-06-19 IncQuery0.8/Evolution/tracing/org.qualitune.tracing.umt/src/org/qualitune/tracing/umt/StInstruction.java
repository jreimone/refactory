/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;
import org.qualitune.tracing.vapoditrace.TraceEntity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>St Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.StInstruction#getSymbols <em>Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getStInstruction()
 * @model abstract="true"
 * @generated
 */
public interface StInstruction extends VapodiInstruction {

	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' reference list.
	 * The list contents are of type {@link org.qualitune.tracing.umt.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getStInstruction_Symbols()
	 * @model required="true"
	 * @generated
	 */
	EList<Variable> getSymbols();
} // StInstruction
