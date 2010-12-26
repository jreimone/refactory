/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.emftext.language.refactoring.roles.MultiplicityCollaboration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collaboration Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.CollaborationReference#getCollaboration <em>Collaboration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCollaborationReference()
 * @model
 * @generated
 */
public interface CollaborationReference extends SourceContext, TargetContext, ObjectRemoval, ObjectAssignmentCommand {
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
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCollaborationReference_Collaboration()
   * @model required="true"
   * @generated
   */
	MultiplicityCollaboration getCollaboration();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.CollaborationReference#getCollaboration <em>Collaboration</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collaboration</em>' reference.
   * @see #getCollaboration()
   * @generated
   */
	void setCollaboration(MultiplicityCollaboration value);

} // CollaborationReference
