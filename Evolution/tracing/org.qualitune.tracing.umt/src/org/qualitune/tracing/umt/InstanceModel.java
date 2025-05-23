/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.InstanceModel#getIntention <em>Intention</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.InstanceModel#getUniverse <em>Universe</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.InstanceModel#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.tracing.umt.UmtPackage#getInstanceModel()
 * @model
 * @generated
 */
public interface InstanceModel extends Model {
	/**
	 * Returns the value of the '<em><b>Intention</b></em>' attribute.
	 * The literals are from the enumeration {@link org.qualitune.tracing.umt.IntentionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intention</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intention</em>' attribute.
	 * @see org.qualitune.tracing.umt.IntentionEnum
	 * @see #setIntention(IntentionEnum)
	 * @see org.qualitune.tracing.umt.UmtPackage#getInstanceModel_Intention()
	 * @model
	 * @generated
	 */
	IntentionEnum getIntention();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.InstanceModel#getIntention <em>Intention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intention</em>' attribute.
	 * @see org.qualitune.tracing.umt.IntentionEnum
	 * @see #getIntention()
	 * @generated
	 */
	void setIntention(IntentionEnum value);

	/**
	 * Returns the value of the '<em><b>Universe</b></em>' attribute.
	 * The literals are from the enumeration {@link org.qualitune.tracing.umt.UniverseType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Universe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Universe</em>' attribute.
	 * @see org.qualitune.tracing.umt.UniverseType
	 * @see #setUniverse(UniverseType)
	 * @see org.qualitune.tracing.umt.UmtPackage#getInstanceModel_Universe()
	 * @model
	 * @generated
	 */
	UniverseType getUniverse();

	/**
	 * Sets the value of the '{@link org.qualitune.tracing.umt.InstanceModel#getUniverse <em>Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Universe</em>' attribute.
	 * @see org.qualitune.tracing.umt.UniverseType
	 * @see #getUniverse()
	 * @generated
	 */
	void setUniverse(UniverseType value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.qualitune.tracing.umt.ModelVariable}.
	 * It is bidirectional and its opposite is '{@link org.qualitune.tracing.umt.ModelVariable#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.qualitune.tracing.umt.UmtPackage#getInstanceModel_Variables()
	 * @see org.qualitune.tracing.umt.ModelVariable#getModel
	 * @model opposite="model"
	 * @generated
	 */
	EList<ModelVariable> getVariables();

} // InstanceModel
