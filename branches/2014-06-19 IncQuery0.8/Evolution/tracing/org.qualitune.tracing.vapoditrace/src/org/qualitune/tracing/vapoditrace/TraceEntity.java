/**
 */
package org.qualitune.tracing.vapoditrace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceEntity#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceEntity#getUniverse <em>Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceEntity()
 * @model abstract="true"
 * @generated
 */
public interface TraceEntity extends EEntity {
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
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceEntity_Semantics()
	 * @model required="true"
	 * @generated
	 */
	TraceType getSemantics();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.TraceEntity#getSemantics <em>Semantics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantics</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.TraceType
	 * @see #getSemantics()
	 * @generated
	 */
	void setSemantics(TraceType value);

	/**
	 * Returns the value of the '<em><b>Universe</b></em>' attribute.
	 * The literals are from the enumeration {@link org.qualitune.tracing.vapoditrace.UniverseType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Universe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Universe</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.UniverseType
	 * @see #setUniverse(UniverseType)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceEntity_Universe()
	 * @model required="true"
	 * @generated
	 */
	UniverseType getUniverse();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.TraceEntity#getUniverse <em>Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Universe</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.UniverseType
	 * @see #getUniverse()
	 * @generated
	 */
	void setUniverse(UniverseType value);

} // TraceEntity
