/**
 */
package org.qualitune.tracing.umt;

import org.qualitune.tracing.vapoditrace.TraceType;
import org.eclipse.emf.common.util.EList;

import org.qualitune.tracing.vapoditrace.DynamicEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Trace Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.AddTraceLink#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.AddTraceLink#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getAddTraceLink()
 * @model
 * @generated
 */
public interface AddTraceLink extends VapodiInstruction {
	/**
	 * Returns the value of the '<em><b>Semantics</b></em>' attribute.
	 * The literals are from the enumeration {@link org.qualitune.tracing.vapoditrace.TraceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantics</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.TraceType
	 * @see #setSemantics(TraceType)
	 * @see org.qualitune.tracing.umt.UmtPackage#getAddTraceLink_Semantics()
	 * @model required="true"
	 * @generated
	 */
	TraceType getSemantics();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.AddTraceLink#getSemantics <em>Semantics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantics</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.TraceType
	 * @see #getSemantics()
	 * @generated
	 */
	void setSemantics(TraceType value);

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
	 * @see org.qualitune.tracing.umt.UmtPackage#getAddTraceLink_Destination()
	 * @model required="true"
	 * @generated
	 */
	Variable getDestination();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.AddTraceLink#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Variable value);

} // AddTraceLink
