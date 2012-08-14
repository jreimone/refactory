/**
 */
package roles;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collaboration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link roles.Collaboration#getSource <em>Source</em>}</li>
 *   <li>{@link roles.Collaboration#getTarget <em>Target</em>}</li>
 *   <li>{@link roles.Collaboration#getModifier <em>Modifier</em>}</li>
 *   <li>{@link roles.Collaboration#getInterpretationContext <em>Interpretation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see roles.RolesPackage#getCollaboration()
 * @model abstract="true"
 * @generated
 */
public interface Collaboration extends RoleFeature {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link roles.Role#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Role)
	 * @see roles.RolesPackage#getCollaboration_Source()
	 * @see roles.Role#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	Role getSource();

	/**
	 * Sets the value of the '{@link roles.Collaboration#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Role value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link roles.Role#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Role)
	 * @see roles.RolesPackage#getCollaboration_Target()
	 * @see roles.Role#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	Role getTarget();

	/**
	 * Sets the value of the '{@link roles.Collaboration#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Role value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' attribute list.
	 * The list contents are of type {@link roles.CollaborationModifier}.
	 * The literals are from the enumeration {@link roles.CollaborationModifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' attribute list.
	 * @see roles.CollaborationModifier
	 * @see roles.RolesPackage#getCollaboration_Modifier()
	 * @model unique="false"
	 * @generated
	 */
	EList<CollaborationModifier> getModifier();

	/**
	 * Returns the value of the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpretation Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpretation Context</em>' reference.
	 * @see #setInterpretationContext(EObject)
	 * @see roles.RolesPackage#getCollaboration_InterpretationContext()
	 * @model
	 * @generated
	 */
	EObject getInterpretationContext();

	/**
	 * Sets the value of the '{@link roles.Collaboration#getInterpretationContext <em>Interpretation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpretation Context</em>' reference.
	 * @see #getInterpretationContext()
	 * @generated
	 */
	void setInterpretationContext(EObject value);

} // Collaboration
