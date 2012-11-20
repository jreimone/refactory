/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.tracing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.qualitune.evolution.operators.Operator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.tracing.TraceLink#getSources <em>Sources</em>}</li>
 *   <li>{@link org.qualitune.evolution.tracing.TraceLink#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.qualitune.evolution.tracing.TraceLink#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.tracing.TracingPackage#getTraceLink()
 * @model
 * @generated
 */
public interface TraceLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.qualitune.evolution.tracing.TracingPackage#getTraceLink_Sources()
	 * @model required="true"
	 * @generated
	 */
	EList<EObject> getSources();

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(EObject)
	 * @see org.qualitune.evolution.tracing.TracingPackage#getTraceLink_Destination()
	 * @model required="true"
	 * @generated
	 */
	EObject getDestination();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.tracing.TraceLink#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Operator)
	 * @see org.qualitune.evolution.tracing.TracingPackage#getTraceLink_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operator getType();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.tracing.TraceLink#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Operator value);

} // TraceLink
