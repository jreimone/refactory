/**
 */
package org.qualitune.tracing.umt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Attribute Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.ModelAttributeVariable#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.ModelAttributeVariable#getPartOf <em>Part Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getModelAttributeVariable()
 * @model
 * @generated
 */
public interface ModelAttributeVariable extends Variable {
	/**
	 * Returns the value of the '<em><b>Instance Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Of</em>' reference.
	 * @see #setInstanceOf(ModelTypeAttribute)
	 * @see org.qualitune.tracing.umt.UmtPackage#getModelAttributeVariable_InstanceOf()
	 * @model required="true"
	 * @generated
	 */
	ModelTypeAttribute getInstanceOf();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.ModelAttributeVariable#getInstanceOf <em>Instance Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Of</em>' reference.
	 * @see #getInstanceOf()
	 * @generated
	 */
	void setInstanceOf(ModelTypeAttribute value);

	/**
	 * Returns the value of the '<em><b>Part Of</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.qualitune.tracing.umt.ModelVariable#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of</em>' container reference.
	 * @see #setPartOf(ModelVariable)
	 * @see org.qualitune.tracing.umt.UmtPackage#getModelAttributeVariable_PartOf()
	 * @see org.qualitune.tracing.umt.ModelVariable#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
	ModelVariable getPartOf();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.ModelAttributeVariable#getPartOf <em>Part Of</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Of</em>' container reference.
	 * @see #getPartOf()
	 * @generated
	 */
	void setPartOf(ModelVariable value);

} // ModelAttributeVariable
