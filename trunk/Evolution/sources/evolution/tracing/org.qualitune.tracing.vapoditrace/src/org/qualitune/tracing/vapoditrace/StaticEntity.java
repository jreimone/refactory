/**
 */
package org.qualitune.tracing.vapoditrace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.StaticEntity#getObjectName <em>Object Name</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.StaticEntity#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getStaticEntity()
 * @model
 * @generated
 */
public interface StaticEntity extends TraceEntity {
	/**
	 * Returns the value of the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Name</em>' attribute.
	 * @see #setObjectName(String)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getStaticEntity_ObjectName()
	 * @model
	 * @generated
	 */
	String getObjectName();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.StaticEntity#getObjectName <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Name</em>' attribute.
	 * @see #getObjectName()
	 * @generated
	 */
	void setObjectName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getStaticEntity_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.StaticEntity#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // StaticEntity
