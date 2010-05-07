/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory
 * @model kind="package"
 * @generated
 */
public interface RefactoringSpecificationPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "refactoring_specification";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.emftext.org/language/refactoring_specification";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "refspec";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  RefactoringSpecificationPackage eINSTANCE = org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl <em>Refactoring Specification</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRefactoringSpecification()
	 * @generated
	 */
  int REFACTORING_SPECIFICATION = 0;

  /**
	 * The feature id for the '<em><b>Used Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFACTORING_SPECIFICATION__USED_ROLE_MODEL = 0;

  /**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFACTORING_SPECIFICATION__INSTRUCTIONS = 1;

  /**
	 * The number of structural features of the '<em>Refactoring Specification</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFACTORING_SPECIFICATION_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.InstructionImpl <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.InstructionImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getInstruction()
	 * @generated
	 */
  int INSTRUCTION = 1;

  /**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSTRUCTION_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ContainmentCommandImpl <em>Containment Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ContainmentCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getContainmentCommand()
	 * @generated
	 */
  int CONTAINMENT_COMMAND = 2;

  /**
	 * The feature id for the '<em><b>Index</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONTAINMENT_COMMAND__INDEX = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Containment Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONTAINMENT_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl <em>CREATE</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getCREATE()
	 * @generated
	 */
  int CREATE = 3;

  /**
	 * The feature id for the '<em><b>Index</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CREATE__INDEX = CONTAINMENT_COMMAND__INDEX;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CREATE__VARIABLE = CONTAINMENT_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CREATE__SOURCE_ROLE = CONTAINMENT_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Target Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CREATE__TARGET_CONTEXT = CONTAINMENT_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>CREATE</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CREATE_FEATURE_COUNT = CONTAINMENT_COMMAND_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl <em>MOVE</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getMOVE()
	 * @generated
	 */
  int MOVE = 4;

  /**
	 * The feature id for the '<em><b>Index</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE__INDEX = CONTAINMENT_COMMAND__INDEX;

  /**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE__SOURCE = CONTAINMENT_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE__TARGET = CONTAINMENT_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Move Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE__MOVE_MODIFIER = CONTAINMENT_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>MOVE</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_FEATURE_COUNT = CONTAINMENT_COMMAND_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariable()
	 * @generated
	 */
  int VARIABLE = 5;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE__NAME = 0;

  /**
	 * The feature id for the '<em><b>Container Command</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE__CONTAINER_COMMAND = 1;

  /**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ContextImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getContext()
	 * @generated
	 */
  int CONTEXT = 20;

  /**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONTEXT_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.SourceContextImpl <em>Source Context</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.SourceContextImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getSourceContext()
	 * @generated
	 */
  int SOURCE_CONTEXT = 7;

  /**
	 * The number of structural features of the '<em>Source Context</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOURCE_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariableReference()
	 * @generated
	 */
  int VARIABLE_REFERENCE = 6;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_REFERENCE__VARIABLE = SOURCE_CONTEXT_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_REFERENCE_FEATURE_COUNT = SOURCE_CONTEXT_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectAssignmentCommandImpl <em>Object Assignment Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectAssignmentCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectAssignmentCommand()
	 * @generated
	 */
  int OBJECT_ASSIGNMENT_COMMAND = 27;

  /**
	 * The feature id for the '<em><b>Declaration</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_ASSIGNMENT_COMMAND__DECLARATION = 0;

  /**
	 * The number of structural features of the '<em>Object Assignment Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RoleReferenceImpl <em>Role Reference</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RoleReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRoleReference()
	 * @generated
	 */
  int ROLE_REFERENCE = 8;

  /**
	 * The feature id for the '<em><b>Declaration</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_REFERENCE__DECLARATION = OBJECT_ASSIGNMENT_COMMAND__DECLARATION;

  /**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_REFERENCE__ROLE = OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_REFERENCE__FROM = OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Role Reference</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_REFERENCE_FEATURE_COUNT = OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.CollaborationReferenceImpl <em>Collaboration Reference</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.CollaborationReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getCollaborationReference()
	 * @generated
	 */
  int COLLABORATION_REFERENCE = 9;

  /**
	 * The feature id for the '<em><b>Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COLLABORATION_REFERENCE__COLLABORATION = SOURCE_CONTEXT_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Collaboration Reference</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COLLABORATION_REFERENCE_FEATURE_COUNT = SOURCE_CONTEXT_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.TargetContextImpl <em>Target Context</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.TargetContextImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getTargetContext()
	 * @generated
	 */
  int TARGET_CONTEXT = 10;

  /**
	 * The number of structural features of the '<em>Target Context</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TARGET_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ReferenceCommandImpl <em>Reference Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ReferenceCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getReferenceCommand()
	 * @generated
	 */
  int REFERENCE_COMMAND = 11;

  /**
	 * The number of structural features of the '<em>Reference Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.SETImpl <em>SET</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.SETImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getSET()
	 * @generated
	 */
  int SET = 12;

  /**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET__SOURCE = REFERENCE_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET__TARGET = REFERENCE_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>SET</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_FEATURE_COUNT = REFERENCE_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.AttributeCommandImpl <em>Attribute Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.AttributeCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getAttributeCommand()
	 * @generated
	 */
  int ATTRIBUTE_COMMAND = 13;

  /**
	 * The number of structural features of the '<em>Attribute Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ATTRIBUTE_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ASSIGNImpl <em>ASSIGN</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ASSIGNImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getASSIGN()
	 * @generated
	 */
  int ASSIGN = 14;

  /**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGN__SOURCE_ATTRIBUTE = ATTRIBUTE_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGN__TARGET_ATTRIBUTE = ATTRIBUTE_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>ASSIGN</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGN_FEATURE_COUNT = ATTRIBUTE_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FromClauseImpl <em>From Clause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.FromClauseImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFromClause()
	 * @generated
	 */
  int FROM_CLAUSE = 15;

  /**
	 * The feature id for the '<em><b>Operator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FROM_CLAUSE__OPERATOR = 0;

  /**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FROM_CLAUSE__REFERENCE = 1;

  /**
	 * The number of structural features of the '<em>From Clause</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FROM_CLAUSE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FromOperatorImpl <em>From Operator</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.FromOperatorImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFromOperator()
	 * @generated
	 */
  int FROM_OPERATOR = 16;

  /**
	 * The number of structural features of the '<em>From Operator</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FROM_OPERATOR_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.UPTREEImpl <em>UPTREE</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.UPTREEImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getUPTREE()
	 * @generated
	 */
  int UPTREE = 17;

  /**
	 * The number of structural features of the '<em>UPTREE</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPTREE_FEATURE_COUNT = FROM_OPERATOR_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectRemovalImpl <em>Object Removal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectRemovalImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectRemoval()
	 * @generated
	 */
  int OBJECT_REMOVAL = 39;

  /**
	 * The number of structural features of the '<em>Object Removal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_REMOVAL_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectReference()
	 * @generated
	 */
  int OBJECT_REFERENCE = 19;

  /**
	 * The number of structural features of the '<em>Object Reference</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_REFERENCE_FEATURE_COUNT = OBJECT_REMOVAL_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ConstantsReferenceImpl <em>Constants Reference</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ConstantsReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getConstantsReference()
	 * @generated
	 */
  int CONSTANTS_REFERENCE = 18;

  /**
	 * The feature id for the '<em><b>Referenced Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTANTS_REFERENCE__REFERENCED_CONSTANT = OBJECT_REFERENCE_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Constants Reference</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTANTS_REFERENCE_FEATURE_COUNT = OBJECT_REFERENCE_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.IndexAssignmentCommandImpl <em>Index Assignment Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.IndexAssignmentCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getIndexAssignmentCommand()
	 * @generated
	 */
  int INDEX_ASSIGNMENT_COMMAND = 21;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_ASSIGNMENT_COMMAND__VARIABLE = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Index Assignment Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_ASSIGNMENT_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.IndexVariableImpl <em>Index Variable</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.IndexVariableImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getIndexVariable()
	 * @generated
	 */
  int INDEX_VARIABLE = 22;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_VARIABLE__NAME = 0;

  /**
	 * The feature id for the '<em><b>Index Command</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_VARIABLE__INDEX_COMMAND = 1;

  /**
	 * The number of structural features of the '<em>Index Variable</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_VARIABLE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ConcreteIndexImpl <em>Concrete Index</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ConcreteIndexImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getConcreteIndex()
	 * @generated
	 */
  int CONCRETE_INDEX = 23;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONCRETE_INDEX__VARIABLE = INDEX_ASSIGNMENT_COMMAND__VARIABLE;

  /**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONCRETE_INDEX__INDEX = INDEX_ASSIGNMENT_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Concrete Index</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONCRETE_INDEX_FEATURE_COUNT = INDEX_ASSIGNMENT_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceAssignmentImpl <em>Object Reference Assignment</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceAssignmentImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectReferenceAssignment()
	 * @generated
	 */
  int OBJECT_REFERENCE_ASSIGNMENT = 26;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_REFERENCE_ASSIGNMENT__VARIABLE = INDEX_ASSIGNMENT_COMMAND__VARIABLE;

  /**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_REFERENCE_ASSIGNMENT__REFERENCE = INDEX_ASSIGNMENT_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Object Reference Assignment</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OBJECT_REFERENCE_ASSIGNMENT_FEATURE_COUNT = INDEX_ASSIGNMENT_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FIRSTImpl <em>FIRST</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.FIRSTImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFIRST()
	 * @generated
	 */
  int FIRST = 24;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FIRST__VARIABLE = OBJECT_REFERENCE_ASSIGNMENT__VARIABLE;

  /**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FIRST__REFERENCE = OBJECT_REFERENCE_ASSIGNMENT__REFERENCE;

  /**
	 * The number of structural features of the '<em>FIRST</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FIRST_FEATURE_COUNT = OBJECT_REFERENCE_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.LASTImpl <em>LAST</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.LASTImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getLAST()
	 * @generated
	 */
  int LAST = 25;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LAST__VARIABLE = OBJECT_REFERENCE_ASSIGNMENT__VARIABLE;

  /**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LAST__REFERENCE = OBJECT_REFERENCE_ASSIGNMENT__REFERENCE;

  /**
	 * The number of structural features of the '<em>LAST</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LAST_FEATURE_COUNT = OBJECT_REFERENCE_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableDeclarationCommandImpl <em>Variable Declaration Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableDeclarationCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariableDeclarationCommand()
	 * @generated
	 */
  int VARIABLE_DECLARATION_COMMAND = 28;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_DECLARATION_COMMAND__VARIABLE = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Variable Declaration Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_DECLARATION_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.TRACEImpl <em>TRACE</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.TRACEImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getTRACE()
	 * @generated
	 */
  int TRACE = 29;

  /**
	 * The feature id for the '<em><b>Declaration</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE__DECLARATION = OBJECT_ASSIGNMENT_COMMAND__DECLARATION;

  /**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE__REFERENCE = OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE__ROLE = OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>TRACE</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE_FEATURE_COUNT = OBJECT_ASSIGNMENT_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.TraceObjectImpl <em>Trace Object</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.TraceObjectImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getTraceObject()
	 * @generated
	 */
  int TRACE_OBJECT = 30;

  /**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE_OBJECT__CONTAINER = 0;

  /**
	 * The feature id for the '<em><b>Applied Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE_OBJECT__APPLIED_ROLE = 1;

  /**
	 * The number of structural features of the '<em>Trace Object</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRACE_OBJECT_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableAssignmentImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariableAssignment()
	 * @generated
	 */
  int VARIABLE_ASSIGNMENT = 31;

  /**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_ASSIGNMENT__VARIABLE = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Assignment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_ASSIGNMENT__ASSIGNMENT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VARIABLE_ASSIGNMENT_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.PATHImpl <em>PATH</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.PATHImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getPATH()
	 * @generated
	 */
  int PATH = 32;

  /**
	 * The number of structural features of the '<em>PATH</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PATH_FEATURE_COUNT = FROM_OPERATOR_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FILTERImpl <em>FILTER</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.FILTERImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFILTER()
	 * @generated
	 */
  int FILTER = 33;

  /**
	 * The number of structural features of the '<em>FILTER</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FILTER_FEATURE_COUNT = FROM_OPERATOR_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ModifierImpl <em>Modifier</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.ModifierImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getModifier()
	 * @generated
	 */
  int MODIFIER = 34;

  /**
	 * The number of structural features of the '<em>Modifier</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MODIFIER_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.DISTINCTImpl <em>DISTINCT</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.DISTINCTImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getDISTINCT()
	 * @generated
	 */
  int DISTINCT = 35;

  /**
	 * The number of structural features of the '<em>DISTINCT</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DISTINCT_FEATURE_COUNT = MODIFIER_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.DeleteCommandImpl <em>Delete Command</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.DeleteCommandImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getDeleteCommand()
	 * @generated
	 */
  int DELETE_COMMAND = 36;

  /**
	 * The number of structural features of the '<em>Delete Command</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.UNSETImpl <em>UNSET</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.UNSETImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getUNSET()
	 * @generated
	 */
  int UNSET = 37;

  /**
	 * The number of structural features of the '<em>UNSET</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNSET_FEATURE_COUNT = REFERENCE_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl <em>REMOVE</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getREMOVE()
	 * @generated
	 */
  int REMOVE = 38;

  /**
	 * The feature id for the '<em><b>Index</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REMOVE__INDEX = DELETE_COMMAND_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Removal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REMOVE__REMOVAL = DELETE_COMMAND_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REMOVE__MODIFIER = DELETE_COMMAND_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>REMOVE</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REMOVE_FEATURE_COUNT = DELETE_COMMAND_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RoleRemovalImpl <em>Role Removal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RoleRemovalImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRoleRemoval()
	 * @generated
	 */
  int ROLE_REMOVAL = 40;

  /**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_REMOVAL__ROLE = OBJECT_REMOVAL_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Role Removal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_REMOVAL_FEATURE_COUNT = OBJECT_REMOVAL_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RemoveModifierImpl <em>Remove Modifier</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RemoveModifierImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRemoveModifier()
	 * @generated
	 */
  int REMOVE_MODIFIER = 41;

  /**
	 * The number of structural features of the '<em>Remove Modifier</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REMOVE_MODIFIER_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.UNUSEDImpl <em>UNUSED</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.UNUSEDImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getUNUSED()
	 * @generated
	 */
  int UNUSED = 42;

  /**
	 * The number of structural features of the '<em>UNUSED</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNUSED_FEATURE_COUNT = REMOVE_MODIFIER_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.EMPTYImpl <em>EMPTY</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.EMPTYImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getEMPTY()
	 * @generated
	 */
  int EMPTY = 43;

  /**
	 * The number of structural features of the '<em>EMPTY</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EMPTY_FEATURE_COUNT = REMOVE_MODIFIER_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.Constants <em>Constants</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.Constants
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getConstants()
	 * @generated
	 */
  int CONSTANTS = 44;


  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification <em>Refactoring Specification</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refactoring Specification</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification
	 * @generated
	 */
  EClass getRefactoringSpecification();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getUsedRoleModel <em>Used Role Model</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Role Model</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getUsedRoleModel()
	 * @see #getRefactoringSpecification()
	 * @generated
	 */
  EReference getRefactoringSpecification_UsedRoleModel();

  /**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getInstructions()
	 * @see #getRefactoringSpecification()
	 * @generated
	 */
  EReference getRefactoringSpecification_Instructions();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Instruction
	 * @generated
	 */
  EClass getInstruction();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ContainmentCommand <em>Containment Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containment Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ContainmentCommand
	 * @generated
	 */
  EClass getContainmentCommand();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.ContainmentCommand#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ContainmentCommand#getIndex()
	 * @see #getContainmentCommand()
	 * @generated
	 */
  EReference getContainmentCommand_Index();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.CREATE <em>CREATE</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CREATE</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE
	 * @generated
	 */
  EClass getCREATE();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRole <em>Source Role</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Role</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRole()
	 * @see #getCREATE()
	 * @generated
	 */
  EReference getCREATE_SourceRole();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getTargetContext <em>Target Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Context</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE#getTargetContext()
	 * @see #getCREATE()
	 * @generated
	 */
  EReference getCREATE_TargetContext();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.MOVE <em>MOVE</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MOVE</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.MOVE
	 * @generated
	 */
  EClass getMOVE();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.MOVE#getSource()
	 * @see #getMOVE()
	 * @generated
	 */
  EReference getMOVE_Source();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.MOVE#getTarget()
	 * @see #getMOVE()
	 * @generated
	 */
  EReference getMOVE_Target();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getMoveModifier <em>Move Modifier</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Move Modifier</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.MOVE#getMoveModifier()
	 * @see #getMOVE()
	 * @generated
	 */
  EReference getMOVE_MoveModifier();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Variable
	 * @generated
	 */
  EClass getVariable();

  /**
	 * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.refactoring_specification.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
  EAttribute getVariable_Name();

  /**
	 * Returns the meta object for the container reference '{@link org.emftext.language.refactoring.refactoring_specification.Variable#getContainerCommand <em>Container Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Variable#getContainerCommand()
	 * @see #getVariable()
	 * @generated
	 */
  EReference getVariable_ContainerCommand();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableReference
	 * @generated
	 */
  EClass getVariableReference();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.VariableReference#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableReference#getVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
  EReference getVariableReference_Variable();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.SourceContext <em>Source Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Context</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.SourceContext
	 * @generated
	 */
  EClass getSourceContext();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.RoleReference <em>Role Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleReference
	 * @generated
	 */
  EClass getRoleReference();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.RoleReference#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleReference#getRole()
	 * @see #getRoleReference()
	 * @generated
	 */
  EReference getRoleReference_Role();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.RoleReference#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleReference#getFrom()
	 * @see #getRoleReference()
	 * @generated
	 */
  EReference getRoleReference_From();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.CollaborationReference <em>Collaboration Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collaboration Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CollaborationReference
	 * @generated
	 */
  EClass getCollaborationReference();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.CollaborationReference#getCollaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collaboration</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CollaborationReference#getCollaboration()
	 * @see #getCollaborationReference()
	 * @generated
	 */
  EReference getCollaborationReference_Collaboration();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.TargetContext <em>Target Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Context</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TargetContext
	 * @generated
	 */
  EClass getTargetContext();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ReferenceCommand <em>Reference Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ReferenceCommand
	 * @generated
	 */
  EClass getReferenceCommand();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.SET <em>SET</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SET</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.SET
	 * @generated
	 */
  EClass getSET();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.SET#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.SET#getSource()
	 * @see #getSET()
	 * @generated
	 */
  EReference getSET_Source();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.SET#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.SET#getTarget()
	 * @see #getSET()
	 * @generated
	 */
  EReference getSET_Target();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.AttributeCommand <em>Attribute Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.AttributeCommand
	 * @generated
	 */
  EClass getAttributeCommand();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN <em>ASSIGN</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASSIGN</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ASSIGN
	 * @generated
	 */
  EClass getASSIGN();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN#getSourceAttribute <em>Source Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Attribute</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ASSIGN#getSourceAttribute()
	 * @see #getASSIGN()
	 * @generated
	 */
  EReference getASSIGN_SourceAttribute();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN#getTargetAttribute <em>Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Attribute</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ASSIGN#getTargetAttribute()
	 * @see #getASSIGN()
	 * @generated
	 */
  EReference getASSIGN_TargetAttribute();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.FromClause <em>From Clause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Clause</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.FromClause
	 * @generated
	 */
  EClass getFromClause();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.FromClause#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operator</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.FromClause#getOperator()
	 * @see #getFromClause()
	 * @generated
	 */
  EReference getFromClause_Operator();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.FromClause#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.FromClause#getReference()
	 * @see #getFromClause()
	 * @generated
	 */
  EReference getFromClause_Reference();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.FromOperator <em>From Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Operator</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.FromOperator
	 * @generated
	 */
  EClass getFromOperator();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.UPTREE <em>UPTREE</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UPTREE</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.UPTREE
	 * @generated
	 */
  EClass getUPTREE();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ConstantsReference <em>Constants Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constants Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ConstantsReference
	 * @generated
	 */
  EClass getConstantsReference();

  /**
	 * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.refactoring_specification.ConstantsReference#getReferencedConstant <em>Referenced Constant</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referenced Constant</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ConstantsReference#getReferencedConstant()
	 * @see #getConstantsReference()
	 * @generated
	 */
  EAttribute getConstantsReference_ReferencedConstant();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectReference <em>Object Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectReference
	 * @generated
	 */
  EClass getObjectReference();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Context
	 * @generated
	 */
  EClass getContext();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand <em>Index Assignment Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Assignment Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand
	 * @generated
	 */
  EClass getIndexAssignmentCommand();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand#getVariable()
	 * @see #getIndexAssignmentCommand()
	 * @generated
	 */
  EReference getIndexAssignmentCommand_Variable();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.IndexVariable <em>Index Variable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Variable</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexVariable
	 * @generated
	 */
  EClass getIndexVariable();

  /**
	 * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.refactoring_specification.IndexVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexVariable#getName()
	 * @see #getIndexVariable()
	 * @generated
	 */
  EAttribute getIndexVariable_Name();

  /**
	 * Returns the meta object for the container reference '{@link org.emftext.language.refactoring.refactoring_specification.IndexVariable#getIndexCommand <em>Index Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Index Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexVariable#getIndexCommand()
	 * @see #getIndexVariable()
	 * @generated
	 */
  EReference getIndexVariable_IndexCommand();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ConcreteIndex <em>Concrete Index</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Index</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ConcreteIndex
	 * @generated
	 */
  EClass getConcreteIndex();

  /**
	 * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.refactoring_specification.ConcreteIndex#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ConcreteIndex#getIndex()
	 * @see #getConcreteIndex()
	 * @generated
	 */
  EAttribute getConcreteIndex_Index();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.FIRST <em>FIRST</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FIRST</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.FIRST
	 * @generated
	 */
  EClass getFIRST();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.LAST <em>LAST</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LAST</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.LAST
	 * @generated
	 */
  EClass getLAST();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment <em>Object Reference Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Reference Assignment</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment
	 * @generated
	 */
  EClass getObjectReferenceAssignment();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment#getReference()
	 * @see #getObjectReferenceAssignment()
	 * @generated
	 */
  EReference getObjectReferenceAssignment_Reference();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand <em>Object Assignment Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Assignment Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand
	 * @generated
	 */
  EClass getObjectAssignmentCommand();

  /**
	 * Returns the meta object for the container reference '{@link org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaration</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand#getDeclaration()
	 * @see #getObjectAssignmentCommand()
	 * @generated
	 */
  EReference getObjectAssignmentCommand_Declaration();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand <em>Variable Declaration Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand
	 * @generated
	 */
  EClass getVariableDeclarationCommand();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand#getVariable()
	 * @see #getVariableDeclarationCommand()
	 * @generated
	 */
  EReference getVariableDeclarationCommand_Variable();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.TRACE <em>TRACE</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TRACE</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TRACE
	 * @generated
	 */
  EClass getTRACE();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.TRACE#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TRACE#getReference()
	 * @see #getTRACE()
	 * @generated
	 */
  EReference getTRACE_Reference();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.TRACE#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TRACE#getRole()
	 * @see #getTRACE()
	 * @generated
	 */
  EReference getTRACE_Role();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.TraceObject <em>Trace Object</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Object</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TraceObject
	 * @generated
	 */
  EClass getTraceObject();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.TraceObject#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TraceObject#getContainer()
	 * @see #getTraceObject()
	 * @generated
	 */
  EReference getTraceObject_Container();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.TraceObject#getAppliedRole <em>Applied Role</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Applied Role</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.TraceObject#getAppliedRole()
	 * @see #getTraceObject()
	 * @generated
	 */
  EReference getTraceObject_AppliedRole();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableAssignment
	 * @generated
	 */
  EClass getVariableAssignment();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.VariableAssignment#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assignment</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableAssignment#getAssignment()
	 * @see #getVariableAssignment()
	 * @generated
	 */
  EReference getVariableAssignment_Assignment();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.PATH <em>PATH</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PATH</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.PATH
	 * @generated
	 */
  EClass getPATH();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.FILTER <em>FILTER</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FILTER</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.FILTER
	 * @generated
	 */
  EClass getFILTER();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.Modifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifier</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Modifier
	 * @generated
	 */
  EClass getModifier();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.DISTINCT <em>DISTINCT</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DISTINCT</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.DISTINCT
	 * @generated
	 */
  EClass getDISTINCT();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.DeleteCommand <em>Delete Command</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.DeleteCommand
	 * @generated
	 */
  EClass getDeleteCommand();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.UNSET <em>UNSET</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UNSET</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.UNSET
	 * @generated
	 */
  EClass getUNSET();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.REMOVE <em>REMOVE</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>REMOVE</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.REMOVE
	 * @generated
	 */
  EClass getREMOVE();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.REMOVE#getRemoval <em>Removal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Removal</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.REMOVE#getRemoval()
	 * @see #getREMOVE()
	 * @generated
	 */
  EReference getREMOVE_Removal();

  /**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.REMOVE#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Modifier</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.REMOVE#getModifier()
	 * @see #getREMOVE()
	 * @generated
	 */
  EReference getREMOVE_Modifier();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectRemoval <em>Object Removal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Removal</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectRemoval
	 * @generated
	 */
  EClass getObjectRemoval();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.RoleRemoval <em>Role Removal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Removal</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleRemoval
	 * @generated
	 */
  EClass getRoleRemoval();

  /**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.RoleRemoval#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleRemoval#getRole()
	 * @see #getRoleRemoval()
	 * @generated
	 */
  EReference getRoleRemoval_Role();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.RemoveModifier <em>Remove Modifier</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Modifier</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RemoveModifier
	 * @generated
	 */
  EClass getRemoveModifier();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.UNUSED <em>UNUSED</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UNUSED</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.UNUSED
	 * @generated
	 */
  EClass getUNUSED();

  /**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.EMPTY <em>EMPTY</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMPTY</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.EMPTY
	 * @generated
	 */
  EClass getEMPTY();

  /**
	 * Returns the meta object for enum '{@link org.emftext.language.refactoring.refactoring_specification.Constants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Constants</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Constants
	 * @generated
	 */
  EEnum getConstants();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  RefactoringSpecificationFactory getRefactoringSpecificationFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl <em>Refactoring Specification</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRefactoringSpecification()
		 * @generated
		 */
    EClass REFACTORING_SPECIFICATION = eINSTANCE.getRefactoringSpecification();

    /**
		 * The meta object literal for the '<em><b>Used Role Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference REFACTORING_SPECIFICATION__USED_ROLE_MODEL = eINSTANCE.getRefactoringSpecification_UsedRoleModel();

    /**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference REFACTORING_SPECIFICATION__INSTRUCTIONS = eINSTANCE.getRefactoringSpecification_Instructions();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.InstructionImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getInstruction()
		 * @generated
		 */
    EClass INSTRUCTION = eINSTANCE.getInstruction();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ContainmentCommandImpl <em>Containment Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ContainmentCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getContainmentCommand()
		 * @generated
		 */
    EClass CONTAINMENT_COMMAND = eINSTANCE.getContainmentCommand();

    /**
		 * The meta object literal for the '<em><b>Index</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONTAINMENT_COMMAND__INDEX = eINSTANCE.getContainmentCommand_Index();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl <em>CREATE</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getCREATE()
		 * @generated
		 */
    EClass CREATE = eINSTANCE.getCREATE();

    /**
		 * The meta object literal for the '<em><b>Source Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CREATE__SOURCE_ROLE = eINSTANCE.getCREATE_SourceRole();

    /**
		 * The meta object literal for the '<em><b>Target Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CREATE__TARGET_CONTEXT = eINSTANCE.getCREATE_TargetContext();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl <em>MOVE</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getMOVE()
		 * @generated
		 */
    EClass MOVE = eINSTANCE.getMOVE();

    /**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MOVE__SOURCE = eINSTANCE.getMOVE_Source();

    /**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MOVE__TARGET = eINSTANCE.getMOVE_Target();

    /**
		 * The meta object literal for the '<em><b>Move Modifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MOVE__MOVE_MODIFIER = eINSTANCE.getMOVE_MoveModifier();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariable()
		 * @generated
		 */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
		 * The meta object literal for the '<em><b>Container Command</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VARIABLE__CONTAINER_COMMAND = eINSTANCE.getVariable_ContainerCommand();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableReferenceImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariableReference()
		 * @generated
		 */
    EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

    /**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.SourceContextImpl <em>Source Context</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.SourceContextImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getSourceContext()
		 * @generated
		 */
    EClass SOURCE_CONTEXT = eINSTANCE.getSourceContext();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RoleReferenceImpl <em>Role Reference</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RoleReferenceImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRoleReference()
		 * @generated
		 */
    EClass ROLE_REFERENCE = eINSTANCE.getRoleReference();

    /**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ROLE_REFERENCE__ROLE = eINSTANCE.getRoleReference_Role();

    /**
		 * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ROLE_REFERENCE__FROM = eINSTANCE.getRoleReference_From();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.CollaborationReferenceImpl <em>Collaboration Reference</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.CollaborationReferenceImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getCollaborationReference()
		 * @generated
		 */
    EClass COLLABORATION_REFERENCE = eINSTANCE.getCollaborationReference();

    /**
		 * The meta object literal for the '<em><b>Collaboration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference COLLABORATION_REFERENCE__COLLABORATION = eINSTANCE.getCollaborationReference_Collaboration();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.TargetContextImpl <em>Target Context</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.TargetContextImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getTargetContext()
		 * @generated
		 */
    EClass TARGET_CONTEXT = eINSTANCE.getTargetContext();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ReferenceCommandImpl <em>Reference Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ReferenceCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getReferenceCommand()
		 * @generated
		 */
    EClass REFERENCE_COMMAND = eINSTANCE.getReferenceCommand();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.SETImpl <em>SET</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.SETImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getSET()
		 * @generated
		 */
    EClass SET = eINSTANCE.getSET();

    /**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SET__SOURCE = eINSTANCE.getSET_Source();

    /**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SET__TARGET = eINSTANCE.getSET_Target();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.AttributeCommandImpl <em>Attribute Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.AttributeCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getAttributeCommand()
		 * @generated
		 */
    EClass ATTRIBUTE_COMMAND = eINSTANCE.getAttributeCommand();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ASSIGNImpl <em>ASSIGN</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ASSIGNImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getASSIGN()
		 * @generated
		 */
    EClass ASSIGN = eINSTANCE.getASSIGN();

    /**
		 * The meta object literal for the '<em><b>Source Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ASSIGN__SOURCE_ATTRIBUTE = eINSTANCE.getASSIGN_SourceAttribute();

    /**
		 * The meta object literal for the '<em><b>Target Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ASSIGN__TARGET_ATTRIBUTE = eINSTANCE.getASSIGN_TargetAttribute();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FromClauseImpl <em>From Clause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.FromClauseImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFromClause()
		 * @generated
		 */
    EClass FROM_CLAUSE = eINSTANCE.getFromClause();

    /**
		 * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FROM_CLAUSE__OPERATOR = eINSTANCE.getFromClause_Operator();

    /**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FROM_CLAUSE__REFERENCE = eINSTANCE.getFromClause_Reference();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FromOperatorImpl <em>From Operator</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.FromOperatorImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFromOperator()
		 * @generated
		 */
    EClass FROM_OPERATOR = eINSTANCE.getFromOperator();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.UPTREEImpl <em>UPTREE</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.UPTREEImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getUPTREE()
		 * @generated
		 */
    EClass UPTREE = eINSTANCE.getUPTREE();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ConstantsReferenceImpl <em>Constants Reference</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ConstantsReferenceImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getConstantsReference()
		 * @generated
		 */
    EClass CONSTANTS_REFERENCE = eINSTANCE.getConstantsReference();

    /**
		 * The meta object literal for the '<em><b>Referenced Constant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONSTANTS_REFERENCE__REFERENCED_CONSTANT = eINSTANCE.getConstantsReference_ReferencedConstant();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectReference()
		 * @generated
		 */
    EClass OBJECT_REFERENCE = eINSTANCE.getObjectReference();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ContextImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getContext()
		 * @generated
		 */
    EClass CONTEXT = eINSTANCE.getContext();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.IndexAssignmentCommandImpl <em>Index Assignment Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.IndexAssignmentCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getIndexAssignmentCommand()
		 * @generated
		 */
    EClass INDEX_ASSIGNMENT_COMMAND = eINSTANCE.getIndexAssignmentCommand();

    /**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INDEX_ASSIGNMENT_COMMAND__VARIABLE = eINSTANCE.getIndexAssignmentCommand_Variable();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.IndexVariableImpl <em>Index Variable</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.IndexVariableImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getIndexVariable()
		 * @generated
		 */
    EClass INDEX_VARIABLE = eINSTANCE.getIndexVariable();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute INDEX_VARIABLE__NAME = eINSTANCE.getIndexVariable_Name();

    /**
		 * The meta object literal for the '<em><b>Index Command</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INDEX_VARIABLE__INDEX_COMMAND = eINSTANCE.getIndexVariable_IndexCommand();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ConcreteIndexImpl <em>Concrete Index</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ConcreteIndexImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getConcreteIndex()
		 * @generated
		 */
    EClass CONCRETE_INDEX = eINSTANCE.getConcreteIndex();

    /**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONCRETE_INDEX__INDEX = eINSTANCE.getConcreteIndex_Index();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FIRSTImpl <em>FIRST</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.FIRSTImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFIRST()
		 * @generated
		 */
    EClass FIRST = eINSTANCE.getFIRST();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.LASTImpl <em>LAST</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.LASTImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getLAST()
		 * @generated
		 */
    EClass LAST = eINSTANCE.getLAST();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceAssignmentImpl <em>Object Reference Assignment</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectReferenceAssignmentImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectReferenceAssignment()
		 * @generated
		 */
    EClass OBJECT_REFERENCE_ASSIGNMENT = eINSTANCE.getObjectReferenceAssignment();

    /**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference OBJECT_REFERENCE_ASSIGNMENT__REFERENCE = eINSTANCE.getObjectReferenceAssignment_Reference();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectAssignmentCommandImpl <em>Object Assignment Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectAssignmentCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectAssignmentCommand()
		 * @generated
		 */
    EClass OBJECT_ASSIGNMENT_COMMAND = eINSTANCE.getObjectAssignmentCommand();

    /**
		 * The meta object literal for the '<em><b>Declaration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference OBJECT_ASSIGNMENT_COMMAND__DECLARATION = eINSTANCE.getObjectAssignmentCommand_Declaration();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableDeclarationCommandImpl <em>Variable Declaration Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableDeclarationCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariableDeclarationCommand()
		 * @generated
		 */
    EClass VARIABLE_DECLARATION_COMMAND = eINSTANCE.getVariableDeclarationCommand();

    /**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VARIABLE_DECLARATION_COMMAND__VARIABLE = eINSTANCE.getVariableDeclarationCommand_Variable();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.TRACEImpl <em>TRACE</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.TRACEImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getTRACE()
		 * @generated
		 */
    EClass TRACE = eINSTANCE.getTRACE();

    /**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRACE__REFERENCE = eINSTANCE.getTRACE_Reference();

    /**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRACE__ROLE = eINSTANCE.getTRACE_Role();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.TraceObjectImpl <em>Trace Object</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.TraceObjectImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getTraceObject()
		 * @generated
		 */
    EClass TRACE_OBJECT = eINSTANCE.getTraceObject();

    /**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRACE_OBJECT__CONTAINER = eINSTANCE.getTraceObject_Container();

    /**
		 * The meta object literal for the '<em><b>Applied Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRACE_OBJECT__APPLIED_ROLE = eINSTANCE.getTraceObject_AppliedRole();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.VariableAssignmentImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getVariableAssignment()
		 * @generated
		 */
    EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

    /**
		 * The meta object literal for the '<em><b>Assignment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VARIABLE_ASSIGNMENT__ASSIGNMENT = eINSTANCE.getVariableAssignment_Assignment();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.PATHImpl <em>PATH</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.PATHImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getPATH()
		 * @generated
		 */
    EClass PATH = eINSTANCE.getPATH();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.FILTERImpl <em>FILTER</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.FILTERImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getFILTER()
		 * @generated
		 */
    EClass FILTER = eINSTANCE.getFILTER();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ModifierImpl <em>Modifier</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ModifierImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getModifier()
		 * @generated
		 */
    EClass MODIFIER = eINSTANCE.getModifier();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.DISTINCTImpl <em>DISTINCT</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.DISTINCTImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getDISTINCT()
		 * @generated
		 */
    EClass DISTINCT = eINSTANCE.getDISTINCT();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.DeleteCommandImpl <em>Delete Command</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.DeleteCommandImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getDeleteCommand()
		 * @generated
		 */
    EClass DELETE_COMMAND = eINSTANCE.getDeleteCommand();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.UNSETImpl <em>UNSET</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.UNSETImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getUNSET()
		 * @generated
		 */
    EClass UNSET = eINSTANCE.getUNSET();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl <em>REMOVE</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getREMOVE()
		 * @generated
		 */
    EClass REMOVE = eINSTANCE.getREMOVE();

    /**
		 * The meta object literal for the '<em><b>Removal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference REMOVE__REMOVAL = eINSTANCE.getREMOVE_Removal();

    /**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference REMOVE__MODIFIER = eINSTANCE.getREMOVE_Modifier();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.ObjectRemovalImpl <em>Object Removal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.ObjectRemovalImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getObjectRemoval()
		 * @generated
		 */
    EClass OBJECT_REMOVAL = eINSTANCE.getObjectRemoval();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RoleRemovalImpl <em>Role Removal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RoleRemovalImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRoleRemoval()
		 * @generated
		 */
    EClass ROLE_REMOVAL = eINSTANCE.getRoleRemoval();

    /**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ROLE_REMOVAL__ROLE = eINSTANCE.getRoleRemoval_Role();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RemoveModifierImpl <em>Remove Modifier</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RemoveModifierImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRemoveModifier()
		 * @generated
		 */
    EClass REMOVE_MODIFIER = eINSTANCE.getRemoveModifier();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.UNUSEDImpl <em>UNUSED</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.UNUSEDImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getUNUSED()
		 * @generated
		 */
    EClass UNUSED = eINSTANCE.getUNUSED();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.EMPTYImpl <em>EMPTY</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.EMPTYImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getEMPTY()
		 * @generated
		 */
    EClass EMPTY = eINSTANCE.getEMPTY();

    /**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.Constants <em>Constants</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.Constants
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getConstants()
		 * @generated
		 */
    EEnum CONSTANTS = eINSTANCE.getConstants();

  }

} //RefactoringSpecificationPackage
