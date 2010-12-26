/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refactoring Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getUsedRoleModel <em>Used Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification()
 * @model
 * @generated
 */
public interface RefactoringSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Used Role Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Used Role Model</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Used Role Model</em>' reference.
   * @see #setUsedRoleModel(RoleModel)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification_UsedRoleModel()
   * @model required="true"
   * @generated
   */
  RoleModel getUsedRoleModel();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getUsedRoleModel <em>Used Role Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Used Role Model</em>' reference.
   * @see #getUsedRoleModel()
   * @generated
   */
  void setUsedRoleModel(RoleModel value);

  /**
   * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.refactoring.refactoring_specification.Instruction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instructions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructions</em>' containment reference list.
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification_Instructions()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Instruction> getInstructions();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * 
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.refactoring_specification.Variable > variables = new org.eclipse.emf.common.util.BasicEList < org.emftext.language.refactoring.refactoring_specification.Variable > ( ) ; \r\norg.eclipse.emf.common.util.EList < org.emftext.language.refactoring.refactoring_specification.Instruction > instructions = getInstructions ( ) ; \r\nfor ( org.emftext.language.refactoring.refactoring_specification.Instruction instruction : instructions ) { \r\n\tif ( instruction instanceof org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand ) { \r\n\t\torg.emftext.language.refactoring.refactoring_specification.Variable var = ( ( org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand ) instruction ) .getVariable ( ) ; \r\n\t\tif ( var != null ) { \r\n\t\t\tvariables .add ( var ) ; \r\n\t\t} \r\n\t} \r\n} \r\nreturn variables ; \r\n'"
   * @generated
   */
  EList<Variable> getDeclaredVariables();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * 
   * <!-- end-model-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.refactoring_specification.Variable > variables = getDeclaredVariables ( ) ; \r\nfor ( org.emftext.language.refactoring.refactoring_specification.Variable variable : variables ) { \r\n\tif ( variable .getName ( ) .equals ( name ) ) { \r\n\t\treturn variable ; \r\n\t} \r\n} \r\nreturn null ; \r\n'"
   * @generated
   */
  Variable getVariableByName(String name);

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Returns all instructions which do work with the given <code>role</code>.
   * <!-- end-model-doc -->
   * @model
   * @generated
   */
	EList<Instruction> getInstructionsReferencingRole(Role referencedRole);

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
	boolean isRoleReferencedByObject(Role referencedRole, EObject eObject);

} // RefactoringSpecification
