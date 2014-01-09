/**
 */
package org.qualitune.tracing.umt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.Function#getBody <em>Body</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.Function#isMain <em>Main</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.Function#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(InstructionBlock)
	 * @see org.qualitune.tracing.umt.UmtPackage#getFunction_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InstructionBlock getBody();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.Function#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(InstructionBlock value);

	/**
	 * Returns the value of the '<em><b>Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main</em>' attribute.
	 * @see #setMain(boolean)
	 * @see org.qualitune.tracing.umt.UmtPackage#getFunction_Main()
	 * @model required="true"
	 * @generated
	 */
	boolean isMain();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.Function#isMain <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' attribute.
	 * @see #isMain()
	 * @generated
	 */
	void setMain(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.qualitune.tracing.umt.UmtPackage#getFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.Function#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Function
