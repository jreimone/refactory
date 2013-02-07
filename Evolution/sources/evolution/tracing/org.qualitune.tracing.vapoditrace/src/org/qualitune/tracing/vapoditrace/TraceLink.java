/**
 */
package org.qualitune.tracing.vapoditrace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceLink#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceLink#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceLink()
 * @model
 * @generated
 */
public interface TraceLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' containment reference.
	 * @see #setDestination(TraceEntity)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceLink_Destination()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TraceEntity getDestination();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.TraceLink#getDestination <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' containment reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(TraceEntity value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.tracing.vapoditrace.TraceEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference list.
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceLink_Source()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceEntity> getSource();

} // TraceLink
