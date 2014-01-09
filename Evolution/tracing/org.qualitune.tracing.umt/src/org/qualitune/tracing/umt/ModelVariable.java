/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;


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
 *   <li>{@link org.qualitune.tracing.umt.ModelVariable#getAttributes <em>Attributes</em>}</li>
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
	 * @model required="true"
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
	 * It is bidirectional and its opposite is '{@link org.qualitune.tracing.umt.InstanceModel#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(InstanceModel)
	 * @see org.qualitune.tracing.umt.UmtPackage#getModelVariable_Model()
	 * @see org.qualitune.tracing.umt.InstanceModel#getVariables
	 * @model opposite="variables"
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

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.tracing.umt.ModelAttributeVariable}.
	 * It is bidirectional and its opposite is '{@link org.qualitune.tracing.umt.ModelAttributeVariable#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getModelVariable_Attributes()
	 * @see org.qualitune.tracing.umt.ModelAttributeVariable#getPartOf
	 * @model opposite="partOf" containment="true"
	 * @generated
	 */
	EList<ModelAttributeVariable> getAttributes();

} // ModelVariable
