/**
 */
package org.qualitune.tracing.umt;

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
	 * Returns the value of the '<em><b>Destination</b></em>' reference list.
	 * The list contents are of type {@link org.qualitune.tracing.vapoditrace.DynamicEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getAddTraceLink_Destination()
	 * @model required="true"
	 * @generated
	 */
	EList<DynamicEntity> getDestination();

} // AddTraceLink
