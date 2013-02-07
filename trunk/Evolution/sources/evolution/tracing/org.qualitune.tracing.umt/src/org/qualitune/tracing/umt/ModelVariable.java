/**
 */
package org.qualitune.tracing.umt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.ModelVariable#getType <em>Type</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.ModelVariable#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getModelVariable()
 * @model
 * @generated
 */
public interface ModelVariable extends Variable {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ModelType)
	 * @see org.qualitune.tracing.umt.UmtPackage#getModelVariable_Type()
	 * @model
	 * @generated
	 */
	ModelType getType();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.ModelVariable#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ModelType value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(InstanceModel)
	 * @see org.qualitune.tracing.umt.UmtPackage#getModelVariable_Model()
	 * @model
	 * @generated
	 */
	InstanceModel getModel();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.ModelVariable#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(InstanceModel value);

} // ModelVariable
