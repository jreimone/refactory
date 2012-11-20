/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.tracing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.tracing.TracingModel#getTraceLinks <em>Trace Links</em>}</li>
 *   <li>{@link org.qualitune.evolution.tracing.TracingModel#getSourceURIs <em>Source UR Is</em>}</li>
 *   <li>{@link org.qualitune.evolution.tracing.TracingModel#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.tracing.TracingPackage#getTracingModel()
 * @model
 * @generated
 */
public interface TracingModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Trace Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.evolution.tracing.TraceLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Links</em>' containment reference list.
	 * @see org.qualitune.evolution.tracing.TracingPackage#getTracingModel_TraceLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceLink> getTraceLinks();

	/**
	 * Returns the value of the '<em><b>Source UR Is</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source UR Is</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source UR Is</em>' attribute list.
	 * @see org.qualitune.evolution.tracing.TracingPackage#getTracingModel_SourceURIs()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getSourceURIs();

	/**
	 * Returns the value of the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target URI</em>' attribute.
	 * @see #setTargetURI(String)
	 * @see org.qualitune.evolution.tracing.TracingPackage#getTracingModel_TargetURI()
	 * @model required="true"
	 * @generated
	 */
	String getTargetURI();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.tracing.TracingModel#getTargetURI <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target URI</em>' attribute.
	 * @see #getTargetURI()
	 * @generated
	 */
	void setTargetURI(String value);

} // TracingModel
