/**
 */
package rolemapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import roles.MultiplicityCollaboration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collaboration Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rolemapping.CollaborationMapping#getCollaboration <em>Collaboration</em>}</li>
 *   <li>{@link rolemapping.CollaborationMapping#getReferenceMetaClassPair <em>Reference Meta Class Pair</em>}</li>
 * </ul>
 * </p>
 *
 * @see rolemapping.RolemappingPackage#getCollaborationMapping()
 * @model
 * @generated
 */
public interface CollaborationMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaboration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaboration</em>' reference.
	 * @see #setCollaboration(MultiplicityCollaboration)
	 * @see rolemapping.RolemappingPackage#getCollaborationMapping_Collaboration()
	 * @model required="true"
	 * @generated
	 */
	MultiplicityCollaboration getCollaboration();

	/**
	 * Sets the value of the '{@link rolemapping.CollaborationMapping#getCollaboration <em>Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collaboration</em>' reference.
	 * @see #getCollaboration()
	 * @generated
	 */
	void setCollaboration(MultiplicityCollaboration value);

	/**
	 * Returns the value of the '<em><b>Reference Meta Class Pair</b></em>' containment reference list.
	 * The list contents are of type {@link rolemapping.ReferenceMetaClassPair}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Meta Class Pair</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Meta Class Pair</em>' containment reference list.
	 * @see rolemapping.RolemappingPackage#getCollaborationMapping_ReferenceMetaClassPair()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ReferenceMetaClassPair> getReferenceMetaClassPair();

} // CollaborationMapping
