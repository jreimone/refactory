/**
 */
package org.modelrefactoring.guery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.guery.Connection#getTo <em>To</em>}</li>
 *   <li>{@link org.modelrefactoring.guery.Connection#getFrom <em>From</em>}</li>
 *   <li>{@link org.modelrefactoring.guery.Connection#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link org.modelrefactoring.guery.Connection#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link org.modelrefactoring.guery.Connection#isComputeAll <em>Compute All</em>}</li>
 *   <li>{@link org.modelrefactoring.guery.Connection#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.guery.GueryPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Role)
	 * @see org.modelrefactoring.guery.GueryPackage#getConnection_To()
	 * @model required="true"
	 * @generated
	 */
	Role getTo();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.Connection#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Role value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Role)
	 * @see org.modelrefactoring.guery.GueryPackage#getConnection_From()
	 * @model required="true"
	 * @generated
	 */
	Role getFrom();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.Connection#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Role value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(int)
	 * @see org.modelrefactoring.guery.GueryPackage#getConnection_MinLength()
	 * @model default="1"
	 * @generated
	 */
	int getMinLength();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.Connection#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(int value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(int)
	 * @see org.modelrefactoring.guery.GueryPackage#getConnection_MaxLength()
	 * @model default="-1"
	 * @generated
	 */
	int getMaxLength();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.Connection#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(int value);

	/**
	 * Returns the value of the '<em><b>Compute All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compute All</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compute All</em>' attribute.
	 * @see #setComputeAll(boolean)
	 * @see org.modelrefactoring.guery.GueryPackage#getConnection_ComputeAll()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isComputeAll();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.Connection#isComputeAll <em>Compute All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compute All</em>' attribute.
	 * @see #isComputeAll()
	 * @generated
	 */
	void setComputeAll(boolean value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.modelrefactoring.guery.GueryPackage#getConnection_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.Connection#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // Connection
