/**
 */
package org.qualitune.tracing.vapoditrace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEntity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.EEntity#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.EEntity#getConcern <em>Concern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getEEntity()
 * @model abstract="true"
 * @generated
 */
public interface EEntity extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getEEntity_AttributeName()
	 * @model
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.EEntity#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Concern</b></em>' attribute.
	 * The literals are from the enumeration {@link org.qualitune.tracing.vapoditrace.ConcernType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concern</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.ConcernType
	 * @see #setConcern(ConcernType)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getEEntity_Concern()
	 * @model required="true"
	 * @generated
	 */
	ConcernType getConcern();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.EEntity#getConcern <em>Concern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concern</em>' attribute.
	 * @see org.qualitune.tracing.vapoditrace.ConcernType
	 * @see #getConcern()
	 * @generated
	 */
	void setConcern(ConcernType value);

} // EEntity
