/**
 */
package org.qualitune.tracing.umt.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.qualitune.tracing.umt.*;

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
 * @see org.qualitune.tracing.umt.UmtPackage
 * @generated
 */
public class UmtSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmtPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmtSwitch() {
		if (modelPackage == null) {
			modelPackage = UmtPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UmtPackage.INSTRUCTION_BLOCK: {
				InstructionBlock instructionBlock = (InstructionBlock)theEObject;
				T result = caseInstructionBlock(instructionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.INSTRUCTION: {
				Instruction instruction = (Instruction)theEObject;
				T result = caseInstruction(instruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.SELECTION: {
				Selection selection = (Selection)theEObject;
				T result = caseSelection(selection);
				if (result == null) result = caseNumerousKindsOfBranches(selection);
				if (result == null) result = caseInstruction(selection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VARIABLE_DECLARATION_INSTRUCTION: {
				VariableDeclarationInstruction variableDeclarationInstruction = (VariableDeclarationInstruction)theEObject;
				T result = caseVariableDeclarationInstruction(variableDeclarationInstruction);
				if (result == null) result = caseVariableProcessingInstruction(variableDeclarationInstruction);
				if (result == null) result = caseInstruction(variableDeclarationInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VARIABLE_ASSIGNMENT: {
				VariableAssignment variableAssignment = (VariableAssignment)theEObject;
				T result = caseVariableAssignment(variableAssignment);
				if (result == null) result = caseVariableProcessingInstruction(variableAssignment);
				if (result == null) result = caseInstruction(variableAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.WRITE_DESTINATION_MODEL: {
				WriteDestinationModel writeDestinationModel = (WriteDestinationModel)theEObject;
				T result = caseWriteDestinationModel(writeDestinationModel);
				if (result == null) result = caseModelModification(writeDestinationModel);
				if (result == null) result = caseVapodiInstruction(writeDestinationModel);
				if (result == null) result = caseInstruction(writeDestinationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.CFS_INSTRUCTION: {
				CfsInstruction cfsInstruction = (CfsInstruction)theEObject;
				T result = caseCfsInstruction(cfsInstruction);
				if (result == null) result = caseVapodiInstruction(cfsInstruction);
				if (result == null) result = caseInstruction(cfsInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = caseVariableDeclaration(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.DEBUG: {
				Debug debug = (Debug)theEObject;
				T result = caseDebug(debug);
				if (result == null) result = caseInstruction(debug);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.PROGRAM: {
				Program program = (Program)theEObject;
				T result = caseProgram(program);
				if (result == null) result = caseVariableDeclaration(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				T result = caseLoop(loop);
				if (result == null) result = caseNumerousKindsOfBranches(loop);
				if (result == null) result = caseInstruction(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.MODEL_MODIFICATION: {
				ModelModification modelModification = (ModelModification)theEObject;
				T result = caseModelModification(modelModification);
				if (result == null) result = caseVapodiInstruction(modelModification);
				if (result == null) result = caseInstruction(modelModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.BRANCH: {
				Branch branch = (Branch)theEObject;
				T result = caseBranch(branch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.CALL_EXPRESSION: {
				CallExpression callExpression = (CallExpression)theEObject;
				T result = caseCallExpression(callExpression);
				if (result == null) result = caseExpression(callExpression);
				if (result == null) result = caseVariableProcessingInstruction(callExpression);
				if (result == null) result = caseInstruction(callExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.ADD_TRACE_LINK: {
				AddTraceLink addTraceLink = (AddTraceLink)theEObject;
				T result = caseAddTraceLink(addTraceLink);
				if (result == null) result = caseVapodiInstruction(addTraceLink);
				if (result == null) result = caseInstruction(addTraceLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VAPODI_INSTRUCTION: {
				VapodiInstruction vapodiInstruction = (VapodiInstruction)theEObject;
				T result = caseVapodiInstruction(vapodiInstruction);
				if (result == null) result = caseInstruction(vapodiInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.WRITE: {
				Write write = (Write)theEObject;
				T result = caseWrite(write);
				if (result == null) result = caseWriteDestinationModel(write);
				if (result == null) result = caseModelModification(write);
				if (result == null) result = caseVapodiInstruction(write);
				if (result == null) result = caseInstruction(write);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.DELETE: {
				Delete delete = (Delete)theEObject;
				T result = caseDelete(delete);
				if (result == null) result = caseWriteDestinationModel(delete);
				if (result == null) result = caseModelModification(delete);
				if (result == null) result = caseVapodiInstruction(delete);
				if (result == null) result = caseInstruction(delete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.TYPE_FILTER: {
				TypeFilter typeFilter = (TypeFilter)theEObject;
				T result = caseTypeFilter(typeFilter);
				if (result == null) result = caseCondition(typeFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.LOGICAL_CONDITION: {
				LogicalCondition logicalCondition = (LogicalCondition)theEObject;
				T result = caseLogicalCondition(logicalCondition);
				if (result == null) result = caseCondition(logicalCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.NUMEROUS_KINDS_OF_BRANCHES: {
				NumerousKindsOfBranches numerousKindsOfBranches = (NumerousKindsOfBranches)theEObject;
				T result = caseNumerousKindsOfBranches(numerousKindsOfBranches);
				if (result == null) result = caseInstruction(numerousKindsOfBranches);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.BLACK_BOX_EXPRESSION: {
				BlackBoxExpression blackBoxExpression = (BlackBoxExpression)theEObject;
				T result = caseBlackBoxExpression(blackBoxExpression);
				if (result == null) result = caseExpression(blackBoxExpression);
				if (result == null) result = caseVariableProcessingInstruction(blackBoxExpression);
				if (result == null) result = caseInstruction(blackBoxExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.INSTANCE_MODEL: {
				InstanceModel instanceModel = (InstanceModel)theEObject;
				T result = caseInstanceModel(instanceModel);
				if (result == null) result = caseModel(instanceModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.META_MODEL: {
				MetaModel metaModel = (MetaModel)theEObject;
				T result = caseMetaModel(metaModel);
				if (result == null) result = caseModel(metaModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseInstruction(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.CFS_PUSH: {
				CfsPush cfsPush = (CfsPush)theEObject;
				T result = caseCfsPush(cfsPush);
				if (result == null) result = caseCfsInstruction(cfsPush);
				if (result == null) result = caseVapodiInstruction(cfsPush);
				if (result == null) result = caseInstruction(cfsPush);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.CFS_POP: {
				CfsPop cfsPop = (CfsPop)theEObject;
				T result = caseCfsPop(cfsPop);
				if (result == null) result = caseCfsInstruction(cfsPop);
				if (result == null) result = caseVapodiInstruction(cfsPop);
				if (result == null) result = caseInstruction(cfsPop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.PRIMITIVE_VARIABLE: {
				PrimitiveVariable primitiveVariable = (PrimitiveVariable)theEObject;
				T result = casePrimitiveVariable(primitiveVariable);
				if (result == null) result = caseVariable(primitiveVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.COLLECTION_VARIABLE: {
				CollectionVariable collectionVariable = (CollectionVariable)theEObject;
				T result = caseCollectionVariable(collectionVariable);
				if (result == null) result = caseVariable(collectionVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.MODEL_VARIABLE: {
				ModelVariable modelVariable = (ModelVariable)theEObject;
				T result = caseModelVariable(modelVariable);
				if (result == null) result = caseVariable(modelVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.MODEL_TYPE: {
				ModelType modelType = (ModelType)theEObject;
				T result = caseModelType(modelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VARIABLE_RESET: {
				VariableReset variableReset = (VariableReset)theEObject;
				T result = caseVariableReset(variableReset);
				if (result == null) result = caseVariableProcessingInstruction(variableReset);
				if (result == null) result = caseInstruction(variableReset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.MODEL_TYPE_ATTRIBUTE: {
				ModelTypeAttribute modelTypeAttribute = (ModelTypeAttribute)theEObject;
				T result = caseModelTypeAttribute(modelTypeAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE: {
				ModelAttributeVariable modelAttributeVariable = (ModelAttributeVariable)theEObject;
				T result = caseModelAttributeVariable(modelAttributeVariable);
				if (result == null) result = caseVariable(modelAttributeVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.ST_PUT: {
				StPut stPut = (StPut)theEObject;
				T result = caseStPut(stPut);
				if (result == null) result = caseStInstruction(stPut);
				if (result == null) result = caseVapodiInstruction(stPut);
				if (result == null) result = caseInstruction(stPut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.ST_DROP: {
				StDrop stDrop = (StDrop)theEObject;
				T result = caseStDrop(stDrop);
				if (result == null) result = caseStInstruction(stDrop);
				if (result == null) result = caseVapodiInstruction(stDrop);
				if (result == null) result = caseInstruction(stDrop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.ST_INSTRUCTION: {
				StInstruction stInstruction = (StInstruction)theEObject;
				T result = caseStInstruction(stInstruction);
				if (result == null) result = caseVapodiInstruction(stInstruction);
				if (result == null) result = caseInstruction(stInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseVariableProcessingInstruction(expression);
				if (result == null) result = caseInstruction(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.CALCULATED_EXPRESSION: {
				CalculatedExpression calculatedExpression = (CalculatedExpression)theEObject;
				T result = caseCalculatedExpression(calculatedExpression);
				if (result == null) result = caseExpression(calculatedExpression);
				if (result == null) result = caseVariableProcessingInstruction(calculatedExpression);
				if (result == null) result = caseInstruction(calculatedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmtPackage.VARIABLE_PROCESSING_INSTRUCTION: {
				VariableProcessingInstruction variableProcessingInstruction = (VariableProcessingInstruction)theEObject;
				T result = caseVariableProcessingInstruction(variableProcessingInstruction);
				if (result == null) result = caseInstruction(variableProcessingInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstructionBlock(InstructionBlock object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelection(Selection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclarationInstruction(VariableDeclarationInstruction object) {
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
	public T caseVariableAssignment(VariableAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Write Destination Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Write Destination Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWriteDestinationModel(WriteDestinationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cfs Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cfs Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCfsInstruction(CfsInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Debug</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Debug</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDebug(Debug object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelModification(ModelModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranch(Branch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpression(CallExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Trace Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Trace Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddTraceLink(AddTraceLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vapodi Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vapodi Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVapodiInstruction(VapodiInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Write</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Write</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWrite(Write object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelete(Delete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeFilter(TypeFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalCondition(LogicalCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numerous Kinds Of Branches</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numerous Kinds Of Branches</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumerousKindsOfBranches(NumerousKindsOfBranches object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Black Box Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Black Box Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlackBoxExpression(BlackBoxExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceModel(InstanceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaModel(MetaModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cfs Push</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cfs Push</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCfsPush(CfsPush object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cfs Pop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cfs Pop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCfsPop(CfsPop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveVariable(PrimitiveVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionVariable(CollectionVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelVariable(ModelVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelType(ModelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableReset(VariableReset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelTypeAttribute(ModelTypeAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Attribute Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Attribute Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelAttributeVariable(ModelAttributeVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>St Put</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>St Put</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStPut(StPut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>St Drop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>St Drop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStDrop(StDrop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>St Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>St Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStInstruction(StInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calculated Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calculated Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalculatedExpression(CalculatedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Processing Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Processing Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableProcessingInstruction(VariableProcessingInstruction object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UmtSwitch
