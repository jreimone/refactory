/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.refactoring_specification.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage
 * @generated
 */
public class RefactoringSpecificationSwitch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static RefactoringSpecificationPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RefactoringSpecificationSwitch()
  {
		if (modelPackage == null) {
			modelPackage = RefactoringSpecificationPackage.eINSTANCE;
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  public T doSwitch(EObject theEObject)
  {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID) {
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION: {
				RefactoringSpecification refactoringSpecification = (RefactoringSpecification)theEObject;
				T result = caseRefactoringSpecification(refactoringSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.INSTRUCTION: {
				Instruction instruction = (Instruction)theEObject;
				T result = caseInstruction(instruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.CONTAINMENT_COMMAND: {
				ContainmentCommand containmentCommand = (ContainmentCommand)theEObject;
				T result = caseContainmentCommand(containmentCommand);
				if (result == null) result = caseReferenceCommand(containmentCommand);
				if (result == null) result = caseInstruction(containmentCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.CREATE: {
				CREATE create = (CREATE)theEObject;
				T result = caseCREATE(create);
				if (result == null) result = caseContainmentCommand(create);
				if (result == null) result = caseVariableDeclarationCommand(create);
				if (result == null) result = caseReferenceCommand(create);
				if (result == null) result = caseInstruction(create);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.MOVE: {
				MOVE move = (MOVE)theEObject;
				T result = caseMOVE(move);
				if (result == null) result = caseContainmentCommand(move);
				if (result == null) result = caseReferenceCommand(move);
				if (result == null) result = caseInstruction(move);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null) result = caseSourceContext(variableReference);
				if (result == null) result = caseTargetContext(variableReference);
				if (result == null) result = caseObjectReference(variableReference);
				if (result == null) result = caseContext(variableReference);
				if (result == null) result = caseObjectRemoval(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.SOURCE_CONTEXT: {
				SourceContext sourceContext = (SourceContext)theEObject;
				T result = caseSourceContext(sourceContext);
				if (result == null) result = caseContext(sourceContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.ROLE_REFERENCE: {
				RoleReference roleReference = (RoleReference)theEObject;
				T result = caseRoleReference(roleReference);
				if (result == null) result = caseObjectAssignmentCommand(roleReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE: {
				CollaborationReference collaborationReference = (CollaborationReference)theEObject;
				T result = caseCollaborationReference(collaborationReference);
				if (result == null) result = caseSourceContext(collaborationReference);
				if (result == null) result = caseTargetContext(collaborationReference);
				if (result == null) result = caseObjectRemoval(collaborationReference);
				if (result == null) result = caseContext(collaborationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.TARGET_CONTEXT: {
				TargetContext targetContext = (TargetContext)theEObject;
				T result = caseTargetContext(targetContext);
				if (result == null) result = caseContext(targetContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.REFERENCE_COMMAND: {
				ReferenceCommand referenceCommand = (ReferenceCommand)theEObject;
				T result = caseReferenceCommand(referenceCommand);
				if (result == null) result = caseInstruction(referenceCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.SET: {
				SET set = (SET)theEObject;
				T result = caseSET(set);
				if (result == null) result = caseReferenceCommand(set);
				if (result == null) result = caseInstruction(set);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.ATTRIBUTE_COMMAND: {
				AttributeCommand attributeCommand = (AttributeCommand)theEObject;
				T result = caseAttributeCommand(attributeCommand);
				if (result == null) result = caseInstruction(attributeCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.ASSIGN: {
				ASSIGN assign = (ASSIGN)theEObject;
				T result = caseASSIGN(assign);
				if (result == null) result = caseAttributeCommand(assign);
				if (result == null) result = caseInstruction(assign);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.FROM_CLAUSE: {
				FromClause fromClause = (FromClause)theEObject;
				T result = caseFromClause(fromClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.FROM_OPERATOR: {
				FromOperator fromOperator = (FromOperator)theEObject;
				T result = caseFromOperator(fromOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.UPTREE: {
				UPTREE uptree = (UPTREE)theEObject;
				T result = caseUPTREE(uptree);
				if (result == null) result = caseFromOperator(uptree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.CONSTANTS_REFERENCE: {
				ConstantsReference constantsReference = (ConstantsReference)theEObject;
				T result = caseConstantsReference(constantsReference);
				if (result == null) result = caseObjectReference(constantsReference);
				if (result == null) result = caseSourceContext(constantsReference);
				if (result == null) result = caseObjectRemoval(constantsReference);
				if (result == null) result = caseContext(constantsReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.OBJECT_REFERENCE: {
				ObjectReference objectReference = (ObjectReference)theEObject;
				T result = caseObjectReference(objectReference);
				if (result == null) result = caseObjectRemoval(objectReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.CONTEXT: {
				Context context = (Context)theEObject;
				T result = caseContext(context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.INDEX_ASSIGNMENT_COMMAND: {
				IndexAssignmentCommand indexAssignmentCommand = (IndexAssignmentCommand)theEObject;
				T result = caseIndexAssignmentCommand(indexAssignmentCommand);
				if (result == null) result = caseInstruction(indexAssignmentCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.INDEX_VARIABLE: {
				IndexVariable indexVariable = (IndexVariable)theEObject;
				T result = caseIndexVariable(indexVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.CONCRETE_INDEX: {
				ConcreteIndex concreteIndex = (ConcreteIndex)theEObject;
				T result = caseConcreteIndex(concreteIndex);
				if (result == null) result = caseIndexAssignmentCommand(concreteIndex);
				if (result == null) result = caseInstruction(concreteIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.FIRST: {
				FIRST first = (FIRST)theEObject;
				T result = caseFIRST(first);
				if (result == null) result = caseObjectReferenceAssignment(first);
				if (result == null) result = caseIndexAssignmentCommand(first);
				if (result == null) result = caseInstruction(first);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.LAST: {
				LAST last = (LAST)theEObject;
				T result = caseLAST(last);
				if (result == null) result = caseObjectReferenceAssignment(last);
				if (result == null) result = caseIndexAssignmentCommand(last);
				if (result == null) result = caseInstruction(last);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.OBJECT_REFERENCE_ASSIGNMENT: {
				ObjectReferenceAssignment objectReferenceAssignment = (ObjectReferenceAssignment)theEObject;
				T result = caseObjectReferenceAssignment(objectReferenceAssignment);
				if (result == null) result = caseIndexAssignmentCommand(objectReferenceAssignment);
				if (result == null) result = caseInstruction(objectReferenceAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.OBJECT_ASSIGNMENT_COMMAND: {
				ObjectAssignmentCommand objectAssignmentCommand = (ObjectAssignmentCommand)theEObject;
				T result = caseObjectAssignmentCommand(objectAssignmentCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.VARIABLE_DECLARATION_COMMAND: {
				VariableDeclarationCommand variableDeclarationCommand = (VariableDeclarationCommand)theEObject;
				T result = caseVariableDeclarationCommand(variableDeclarationCommand);
				if (result == null) result = caseInstruction(variableDeclarationCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.TRACE: {
				TRACE trace = (TRACE)theEObject;
				T result = caseTRACE(trace);
				if (result == null) result = caseObjectAssignmentCommand(trace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.TRACE_OBJECT: {
				TraceObject traceObject = (TraceObject)theEObject;
				T result = caseTraceObject(traceObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT: {
				VariableAssignment variableAssignment = (VariableAssignment)theEObject;
				T result = caseVariableAssignment(variableAssignment);
				if (result == null) result = caseVariableDeclarationCommand(variableAssignment);
				if (result == null) result = caseInstruction(variableAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.PATH: {
				PATH path = (PATH)theEObject;
				T result = casePATH(path);
				if (result == null) result = caseFromOperator(path);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.FILTER: {
				FILTER filter = (FILTER)theEObject;
				T result = caseFILTER(filter);
				if (result == null) result = caseFromOperator(filter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.MODIFIER: {
				Modifier modifier = (Modifier)theEObject;
				T result = caseModifier(modifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.DISTINCT: {
				DISTINCT distinct = (DISTINCT)theEObject;
				T result = caseDISTINCT(distinct);
				if (result == null) result = caseModifier(distinct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.DELETE_COMMAND: {
				DeleteCommand deleteCommand = (DeleteCommand)theEObject;
				T result = caseDeleteCommand(deleteCommand);
				if (result == null) result = caseInstruction(deleteCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.UNSET: {
				UNSET unset = (UNSET)theEObject;
				T result = caseUNSET(unset);
				if (result == null) result = caseReferenceCommand(unset);
				if (result == null) result = caseDeleteCommand(unset);
				if (result == null) result = caseInstruction(unset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.REMOVE: {
				REMOVE remove = (REMOVE)theEObject;
				T result = caseREMOVE(remove);
				if (result == null) result = caseDeleteCommand(remove);
				if (result == null) result = caseContainmentCommand(remove);
				if (result == null) result = caseReferenceCommand(remove);
				if (result == null) result = caseInstruction(remove);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.OBJECT_REMOVAL: {
				ObjectRemoval objectRemoval = (ObjectRemoval)theEObject;
				T result = caseObjectRemoval(objectRemoval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.ROLE_REMOVAL: {
				RoleRemoval roleRemoval = (RoleRemoval)theEObject;
				T result = caseRoleRemoval(roleRemoval);
				if (result == null) result = caseObjectRemoval(roleRemoval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.REMOVE_MODIFIER: {
				RemoveModifier removeModifier = (RemoveModifier)theEObject;
				T result = caseRemoveModifier(removeModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.UNUSED: {
				UNUSED unused = (UNUSED)theEObject;
				T result = caseUNUSED(unused);
				if (result == null) result = caseRemoveModifier(unused);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.EMPTY: {
				EMPTY empty = (EMPTY)theEObject;
				T result = caseEMPTY(empty);
				if (result == null) result = caseRemoveModifier(empty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Refactoring Specification</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refactoring Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRefactoringSpecification(RefactoringSpecification object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInstruction(Instruction object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseContainmentCommand(ContainmentCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>CREATE</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CREATE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCREATE(CREATE object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>MOVE</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MOVE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMOVE(MOVE object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariable(Variable object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariableReference(VariableReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Source Context</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSourceContext(SourceContext object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Role Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRoleReference(RoleReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Collaboration Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collaboration Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCollaborationReference(CollaborationReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Target Context</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTargetContext(TargetContext object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseReferenceCommand(ReferenceCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>SET</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SET</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSET(SET object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAttributeCommand(AttributeCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ASSIGN</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ASSIGN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseASSIGN(ASSIGN object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>From Clause</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFromClause(FromClause object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>From Operator</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFromOperator(FromOperator object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>UPTREE</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UPTREE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUPTREE(UPTREE object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Constants Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constants Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConstantsReference(ConstantsReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Object Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseObjectReference(ObjectReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseContext(Context object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Index Assignment Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Assignment Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIndexAssignmentCommand(IndexAssignmentCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Index Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIndexVariable(IndexVariable object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Index</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConcreteIndex(ConcreteIndex object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>FIRST</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FIRST</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFIRST(FIRST object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>LAST</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LAST</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLAST(LAST object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Object Reference Assignment</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Reference Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseObjectReferenceAssignment(ObjectReferenceAssignment object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Object Assignment Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Assignment Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseObjectAssignmentCommand(ObjectAssignmentCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariableDeclarationCommand(VariableDeclarationCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TRACE</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TRACE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTRACE(TRACE object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Object</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTraceObject(TraceObject object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariableAssignment(VariableAssignment object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PATH</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PATH</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePATH(PATH object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>FILTER</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FILTER</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFILTER(FILTER object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseModifier(Modifier object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>DISTINCT</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DISTINCT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDISTINCT(DISTINCT object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Command</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDeleteCommand(DeleteCommand object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>UNSET</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UNSET</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUNSET(UNSET object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>REMOVE</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>REMOVE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseREMOVE(REMOVE object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Object Removal</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Removal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseObjectRemoval(ObjectRemoval object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Role Removal</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Removal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRoleRemoval(RoleRemoval object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Modifier</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRemoveModifier(RemoveModifier object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>UNUSED</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UNUSED</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUNUSED(UNUSED object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EMPTY</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMPTY</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseEMPTY(EMPTY object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  public T defaultCase(EObject object)
  {
		return null;
	}

} //RefactoringSpecificationSwitch
