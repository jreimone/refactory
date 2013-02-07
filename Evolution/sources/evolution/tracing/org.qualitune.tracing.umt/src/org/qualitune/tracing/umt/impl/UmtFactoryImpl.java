/**
 */
package org.qualitune.tracing.umt.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.qualitune.tracing.umt.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmtFactoryImpl extends EFactoryImpl implements UmtFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UmtFactory init() {
		try {
			UmtFactory theUmtFactory = (UmtFactory)EPackage.Registry.INSTANCE.getEFactory("http://smt.inf.tu-dresden.de/fab/umt"); 
			if (theUmtFactory != null) {
				return theUmtFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmtFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmtFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UmtPackage.INSTRUCTION_BLOCK: return createInstructionBlock();
			case UmtPackage.SELECTION: return createSelection();
			case UmtPackage.VARIABLE_DECLARATION_INSTRUCTION: return createVariableDeclarationInstruction();
			case UmtPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
			case UmtPackage.FUNCTION: return createFunction();
			case UmtPackage.DEBUG: return createDebug();
			case UmtPackage.PROGRAM: return createProgram();
			case UmtPackage.LOOP: return createLoop();
			case UmtPackage.BRANCH: return createBranch();
			case UmtPackage.CALL: return createCall();
			case UmtPackage.ADD_TRACE_LINK: return createAddTraceLink();
			case UmtPackage.WRITE: return createWrite();
			case UmtPackage.DELETE: return createDelete();
			case UmtPackage.TYPE_FILTER: return createTypeFilter();
			case UmtPackage.LOGICAL_CONDITION: return createLogicalCondition();
			case UmtPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case UmtPackage.BLACK_BOX_INSTRUCTION: return createBlackBoxInstruction();
			case UmtPackage.INSTANCE_MODEL: return createInstanceModel();
			case UmtPackage.META_MODEL: return createMetaModel();
			case UmtPackage.COMMENT: return createComment();
			case UmtPackage.CFS_PUSH: return createCfsPush();
			case UmtPackage.CFS_POP: return createCfsPop();
			case UmtPackage.PRIMITIVE_VARIABLE: return createPrimitiveVariable();
			case UmtPackage.COLLECTION_VARIABLE: return createCollectionVariable();
			case UmtPackage.MODEL_VARIABLE: return createModelVariable();
			case UmtPackage.MODEL_TYPE: return createModelType();
			case UmtPackage.VARIABLE_RESET: return createVariableReset();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case UmtPackage.INTENTION_ENUM:
				return createIntentionEnumFromString(eDataType, initialValue);
			case UmtPackage.UNIVERSE_TYPE:
				return createUniverseTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case UmtPackage.INTENTION_ENUM:
				return convertIntentionEnumToString(eDataType, instanceValue);
			case UmtPackage.UNIVERSE_TYPE:
				return convertUniverseTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionBlock createInstructionBlock() {
		InstructionBlockImpl instructionBlock = new InstructionBlockImpl();
		return instructionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Selection createSelection() {
		SelectionImpl selection = new SelectionImpl();
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationInstruction createVariableDeclarationInstruction() {
		VariableDeclarationInstructionImpl variableDeclarationInstruction = new VariableDeclarationInstructionImpl();
		return variableDeclarationInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAssignment createVariableAssignment() {
		VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
		return variableAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Debug createDebug() {
		DebugImpl debug = new DebugImpl();
		return debug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Loop createLoop() {
		LoopImpl loop = new LoopImpl();
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranch() {
		BranchImpl branch = new BranchImpl();
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Call createCall() {
		CallImpl call = new CallImpl();
		return call;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddTraceLink createAddTraceLink() {
		AddTraceLinkImpl addTraceLink = new AddTraceLinkImpl();
		return addTraceLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Write createWrite() {
		WriteImpl write = new WriteImpl();
		return write;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete createDelete() {
		DeleteImpl delete = new DeleteImpl();
		return delete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeFilter createTypeFilter() {
		TypeFilterImpl typeFilter = new TypeFilterImpl();
		return typeFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalCondition createLogicalCondition() {
		LogicalConditionImpl logicalCondition = new LogicalConditionImpl();
		return logicalCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackBoxInstruction createBlackBoxInstruction() {
		BlackBoxInstructionImpl blackBoxInstruction = new BlackBoxInstructionImpl();
		return blackBoxInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceModel createInstanceModel() {
		InstanceModelImpl instanceModel = new InstanceModelImpl();
		return instanceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModel createMetaModel() {
		MetaModelImpl metaModel = new MetaModelImpl();
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CfsPush createCfsPush() {
		CfsPushImpl cfsPush = new CfsPushImpl();
		return cfsPush;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CfsPop createCfsPop() {
		CfsPopImpl cfsPop = new CfsPopImpl();
		return cfsPop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveVariable createPrimitiveVariable() {
		PrimitiveVariableImpl primitiveVariable = new PrimitiveVariableImpl();
		return primitiveVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionVariable createCollectionVariable() {
		CollectionVariableImpl collectionVariable = new CollectionVariableImpl();
		return collectionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelVariable createModelVariable() {
		ModelVariableImpl modelVariable = new ModelVariableImpl();
		return modelVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelType createModelType() {
		ModelTypeImpl modelType = new ModelTypeImpl();
		return modelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReset createVariableReset() {
		VariableResetImpl variableReset = new VariableResetImpl();
		return variableReset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionEnum createIntentionEnumFromString(EDataType eDataType, String initialValue) {
		IntentionEnum result = IntentionEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntentionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniverseType createUniverseTypeFromString(EDataType eDataType, String initialValue) {
		UniverseType result = UniverseType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUniverseTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmtPackage getUmtPackage() {
		return (UmtPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmtPackage getPackage() {
		return UmtPackage.eINSTANCE;
	}

} //UmtFactoryImpl
