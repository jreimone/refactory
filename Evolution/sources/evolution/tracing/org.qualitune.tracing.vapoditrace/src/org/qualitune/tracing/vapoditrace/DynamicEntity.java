/**
 */
package org.qualitune.tracing.vapoditrace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getEsf <em>Esf</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getDynamicEntity()
 * @model
 * @generated
 */
public interface DynamicEntity extends TraceEntity {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getDynamicEntity_Attribute()
	 * @model
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Esf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Esf</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Esf</em>' reference.
	 * @see #setEsf(EStructuralFeature)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getDynamicEntity_Esf()
	 * @model
	 * @generated
	 */
	EStructuralFeature getEsf();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getEsf <em>Esf</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Esf</em>' reference.
	 * @see #getEsf()
	 * @generated
	 */
	void setEsf(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage#getDynamicEntity_Object()
	 * @model
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.vapoditrace.DynamicEntity#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

} // DynamicEntity
