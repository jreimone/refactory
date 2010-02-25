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
public class RefactoringSpecificationSwitch<T> {
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
	public RefactoringSpecificationSwitch() {
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
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
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
	protected T doSwitch(int classifierID, EObject theEObject) {
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
				if (result == null) result = caseInstruction(containmentCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.CREATE: {
				CREATE create = (CREATE)theEObject;
				T result = caseCREATE(create);
				if (result == null) result = caseContainmentCommand(create);
				if (result == null) result = caseInstruction(create);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.MOVE: {
				MOVE move = (MOVE)theEObject;
				T result = caseMOVE(move);
				if (result == null) result = caseContainmentCommand(move);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.SOURCE_CONTEXT: {
				SourceContext sourceContext = (SourceContext)theEObject;
				T result = caseSourceContext(sourceContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.ROLE_REFERENCE: {
				RoleReference roleReference = (RoleReference)theEObject;
				T result = caseRoleReference(roleReference);
				if (result == null) result = caseSourceContext(roleReference);
				if (result == null) result = caseTargetContext(roleReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.RELATION_REFERENCE: {
				RelationReference relationReference = (RelationReference)theEObject;
				T result = caseRelationReference(relationReference);
				if (result == null) result = caseSourceContext(relationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RefactoringSpecificationPackage.TARGET_CONTEXT: {
				TargetContext targetContext = (TargetContext)theEObject;
				T result = caseTargetContext(targetContext);
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
	public T caseRefactoringSpecification(RefactoringSpecification object) {
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
	public T caseInstruction(Instruction object) {
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
	public T caseContainmentCommand(ContainmentCommand object) {
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
	public T caseCREATE(CREATE object) {
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
	public T caseMOVE(MOVE object) {
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
	public T caseVariable(Variable object) {
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
	public T caseVariableReference(VariableReference object) {
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
	public T caseSourceContext(SourceContext object) {
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
	public T caseRoleReference(RoleReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationReference(RelationReference object) {
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
	public T caseTargetContext(TargetContext object) {
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
	public T caseReferenceCommand(ReferenceCommand object) {
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
	public T caseSET(SET object) {
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
	public T caseAttributeCommand(AttributeCommand object) {
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
	public T caseASSIGN(ASSIGN object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //RefactoringSpecificationSwitch
