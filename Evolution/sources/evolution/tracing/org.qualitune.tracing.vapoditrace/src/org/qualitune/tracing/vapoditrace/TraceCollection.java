/**
 */
package org.qualitune.tracing.vapoditrace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceCollection#getTraceLinks <em>Trace Links</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceCollection#getShadowObjects <em>Shadow Objects</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.TraceCollection#getTrash <em>Trash</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceCollection()
 * @model
 * @generated
 */
public interface TraceCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Trace Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.tracing.vapoditrace.TraceLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Links</em>' containment reference list.
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceCollection_TraceLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceLink> getTraceLinks();

	/**
	 * Returns the value of the '<em><b>Shadow Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shadow Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shadow Objects</em>' containment reference list.
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceCollection_ShadowObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getShadowObjects();

	/**
	 * Returns the value of the '<em><b>Trash</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.tracing.vapoditrace.TraceLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trash</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trash</em>' containment reference list.
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getTraceCollection_Trash()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceLink> getTrash();

} // TraceCollection
