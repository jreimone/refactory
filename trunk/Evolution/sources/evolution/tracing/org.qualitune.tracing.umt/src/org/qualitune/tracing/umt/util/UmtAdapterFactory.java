/**
 */
package org.qualitune.tracing.umt.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.qualitune.tracing.umt.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.umt.UmtPackage
 * @generated
 */
public class UmtAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmtPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmtAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmtPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UmtSwitch<Adapter> modelSwitch =
		new UmtSwitch<Adapter>() {
			@Override
			public Adapter caseInstructionBlock(InstructionBlock object) {
				return createInstructionBlockAdapter();
			}
			@Override
			public Adapter caseInstruction(Instruction object) {
				return createInstructionAdapter();
			}
			@Override
			public Adapter caseSelection(Selection object) {
				return createSelectionAdapter();
			}
			@Override
			public Adapter caseVariableDeclarationInstruction(VariableDeclarationInstruction object) {
				return createVariableDeclarationInstructionAdapter();
			}
			@Override
			public Adapter caseVariableAssignment(VariableAssignment object) {
				return createVariableAssignmentAdapter();
			}
			@Override
			public Adapter caseWriteDestinationModel(WriteDestinationModel object) {
				return createWriteDestinationModelAdapter();
			}
			@Override
			public Adapter caseCfsInstruction(CfsInstruction object) {
				return createCfsInstructionAdapter();
			}
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseDebug(Debug object) {
				return createDebugAdapter();
			}
			@Override
			public Adapter caseProgram(Program object) {
				return createProgramAdapter();
			}
			@Override
			public Adapter caseLoop(Loop object) {
				return createLoopAdapter();
			}
			@Override
			public Adapter caseModelModification(ModelModification object) {
				return createModelModificationAdapter();
			}
			@Override
			public Adapter caseBranch(Branch object) {
				return createBranchAdapter();
			}
			@Override
			public Adapter caseCallExpression(CallExpression object) {
				return createCallExpressionAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseAddTraceLink(AddTraceLink object) {
				return createAddTraceLinkAdapter();
			}
			@Override
			public Adapter caseVapodiInstruction(VapodiInstruction object) {
				return createVapodiInstructionAdapter();
			}
			@Override
			public Adapter caseWrite(Write object) {
				return createWriteAdapter();
			}
			@Override
			public Adapter caseDelete(Delete object) {
				return createDeleteAdapter();
			}
			@Override
			public Adapter caseTypeFilter(TypeFilter object) {
				return createTypeFilterAdapter();
			}
			@Override
			public Adapter caseLogicalCondition(LogicalCondition object) {
				return createLogicalConditionAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseNumerousKindsOfBranches(NumerousKindsOfBranches object) {
				return createNumerousKindsOfBranchesAdapter();
			}
			@Override
			public Adapter caseBlackBoxExpression(BlackBoxExpression object) {
				return createBlackBoxExpressionAdapter();
			}
			@Override
			public Adapter caseInstanceModel(InstanceModel object) {
				return createInstanceModelAdapter();
			}
			@Override
			public Adapter caseMetaModel(MetaModel object) {
				return createMetaModelAdapter();
			}
			@Override
			public Adapter caseComment(Comment object) {
				return createCommentAdapter();
			}
			@Override
			public Adapter caseCfsPush(CfsPush object) {
				return createCfsPushAdapter();
			}
			@Override
			public Adapter caseCfsPop(CfsPop object) {
				return createCfsPopAdapter();
			}
			@Override
			public Adapter casePrimitiveVariable(PrimitiveVariable object) {
				return createPrimitiveVariableAdapter();
			}
			@Override
			public Adapter caseCollectionVariable(CollectionVariable object) {
				return createCollectionVariableAdapter();
			}
			@Override
			public Adapter caseModelVariable(ModelVariable object) {
				return createModelVariableAdapter();
			}
			@Override
			public Adapter caseModelType(ModelType object) {
				return createModelTypeAdapter();
			}
			@Override
			public Adapter caseVariableReset(VariableReset object) {
				return createVariableResetAdapter();
			}
			@Override
			public Adapter caseModelTypeAttribute(ModelTypeAttribute object) {
				return createModelTypeAttributeAdapter();
			}
			@Override
			public Adapter caseModelAttributeVariable(ModelAttributeVariable object) {
				return createModelAttributeVariableAdapter();
			}
			@Override
			public Adapter caseStPut(StPut object) {
				return createStPutAdapter();
			}
			@Override
			public Adapter caseStDrop(StDrop object) {
				return createStDropAdapter();
			}
			@Override
			public Adapter caseStInstruction(StInstruction object) {
				return createStInstructionAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseCalculatedExpression(CalculatedExpression object) {
				return createCalculatedExpressionAdapter();
			}
			@Override
			public Adapter caseVariableProcessingInstruction(VariableProcessingInstruction object) {
				return createVariableProcessingInstructionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.InstructionBlock <em>Instruction Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.InstructionBlock
	 * @generated
	 */
	public Adapter createInstructionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Instruction
	 * @generated
	 */
	public Adapter createInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Selection
	 * @generated
	 */
	public Adapter createSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.VariableDeclarationInstruction <em>Variable Declaration Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.VariableDeclarationInstruction
	 * @generated
	 */
	public Adapter createVariableDeclarationInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.VariableAssignment
	 * @generated
	 */
	public Adapter createVariableAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.WriteDestinationModel <em>Write Destination Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.WriteDestinationModel
	 * @generated
	 */
	public Adapter createWriteDestinationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.CfsInstruction <em>Cfs Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.CfsInstruction
	 * @generated
	 */
	public Adapter createCfsInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Debug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Debug
	 * @generated
	 */
	public Adapter createDebugAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Loop
	 * @generated
	 */
	public Adapter createLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.ModelModification <em>Model Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.ModelModification
	 * @generated
	 */
	public Adapter createModelModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Branch
	 * @generated
	 */
	public Adapter createBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.CallExpression <em>Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.CallExpression
	 * @generated
	 */
	public Adapter createCallExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.AddTraceLink <em>Add Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.AddTraceLink
	 * @generated
	 */
	public Adapter createAddTraceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.VapodiInstruction <em>Vapodi Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.VapodiInstruction
	 * @generated
	 */
	public Adapter createVapodiInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Write <em>Write</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Write
	 * @generated
	 */
	public Adapter createWriteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Delete
	 * @generated
	 */
	public Adapter createDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.TypeFilter <em>Type Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.TypeFilter
	 * @generated
	 */
	public Adapter createTypeFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.LogicalCondition <em>Logical Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.LogicalCondition
	 * @generated
	 */
	public Adapter createLogicalConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.NumerousKindsOfBranches <em>Numerous Kinds Of Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.NumerousKindsOfBranches
	 * @generated
	 */
	public Adapter createNumerousKindsOfBranchesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.BlackBoxExpression <em>Black Box Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.BlackBoxExpression
	 * @generated
	 */
	public Adapter createBlackBoxExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.InstanceModel <em>Instance Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.InstanceModel
	 * @generated
	 */
	public Adapter createInstanceModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.MetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.MetaModel
	 * @generated
	 */
	public Adapter createMetaModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Comment
	 * @generated
	 */
	public Adapter createCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.CfsPush <em>Cfs Push</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.CfsPush
	 * @generated
	 */
	public Adapter createCfsPushAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.CfsPop <em>Cfs Pop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.CfsPop
	 * @generated
	 */
	public Adapter createCfsPopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.PrimitiveVariable <em>Primitive Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.PrimitiveVariable
	 * @generated
	 */
	public Adapter createPrimitiveVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.CollectionVariable <em>Collection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.CollectionVariable
	 * @generated
	 */
	public Adapter createCollectionVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.ModelVariable <em>Model Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.ModelVariable
	 * @generated
	 */
	public Adapter createModelVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.ModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.ModelType
	 * @generated
	 */
	public Adapter createModelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.VariableReset <em>Variable Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.VariableReset
	 * @generated
	 */
	public Adapter createVariableResetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.ModelTypeAttribute <em>Model Type Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.ModelTypeAttribute
	 * @generated
	 */
	public Adapter createModelTypeAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.ModelAttributeVariable <em>Model Attribute Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.ModelAttributeVariable
	 * @generated
	 */
	public Adapter createModelAttributeVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.StPut <em>St Put</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.StPut
	 * @generated
	 */
	public Adapter createStPutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.StDrop <em>St Drop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.StDrop
	 * @generated
	 */
	public Adapter createStDropAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.StInstruction <em>St Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.StInstruction
	 * @generated
	 */
	public Adapter createStInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.CalculatedExpression <em>Calculated Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.CalculatedExpression
	 * @generated
	 */
	public Adapter createCalculatedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.umt.VariableProcessingInstruction <em>Variable Processing Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.umt.VariableProcessingInstruction
	 * @generated
	 */
	public Adapter createVariableProcessingInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UmtAdapterFactory
