/**
 */
package org.qualitune.tracing.umt;

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
 * @see org.qualitune.tracing.umt.UmtFactory
 * @model kind="package"
 * @generated
 */
public interface UmtPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "umt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://smt.inf.tu-dresden.de/fab/umt";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "umt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmtPackage eINSTANCE = org.qualitune.tracing.umt.impl.UmtPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.InstructionBlockImpl <em>Instruction Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.InstructionBlockImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getInstructionBlock()
	 * @generated
	 */
	int INSTRUCTION_BLOCK = 0;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_BLOCK__INSTRUCTIONS = 0;

	/**
	 * The number of structural features of the '<em>Instruction Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_BLOCK_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.Instruction <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.Instruction
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getInstruction()
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
	 * The meta object id for the '{@link org.qualitune.tracing.umt.NumerousKindsOfBranches <em>Numerous Kinds Of Branches</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.NumerousKindsOfBranches
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getNumerousKindsOfBranches()
	 * @generated
	 */
	int NUMEROUS_KINDS_OF_BRANCHES = 24;

	/**
	 * The feature id for the '<em><b>Opposite Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMEROUS_KINDS_OF_BRANCHES__OPPOSITE_BRANCH = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numerous Kinds Of Branches</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMEROUS_KINDS_OF_BRANCHES_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.SelectionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 2;

	/**
	 * The feature id for the '<em><b>Opposite Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__OPPOSITE_BRANCH = NUMEROUS_KINDS_OF_BRANCHES__OPPOSITE_BRANCH;

	/**
	 * The feature id for the '<em><b>Branches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__BRANCHES = NUMEROUS_KINDS_OF_BRANCHES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = NUMEROUS_KINDS_OF_BRANCHES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.VariableDeclarationInstructionImpl <em>Variable Declaration Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.VariableDeclarationInstructionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableDeclarationInstruction()
	 * @generated
	 */
	int VARIABLE_DECLARATION_INSTRUCTION = 3;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_INSTRUCTION__VARIABLES = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.VariableAssignmentImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 4;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__DESTINATION = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__SOURCE = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.VapodiInstruction <em>Vapodi Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.VapodiInstruction
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVapodiInstruction()
	 * @generated
	 */
	int VAPODI_INSTRUCTION = 18;

	/**
	 * The number of structural features of the '<em>Vapodi Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAPODI_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ModelModificationImpl <em>Model Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ModelModificationImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelModification()
	 * @generated
	 */
	int MODEL_MODIFICATION = 13;

	/**
	 * The number of structural features of the '<em>Model Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MODIFICATION_FEATURE_COUNT = VAPODI_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.WriteDestinationModel <em>Write Destination Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.WriteDestinationModel
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getWriteDestinationModel()
	 * @generated
	 */
	int WRITE_DESTINATION_MODEL = 5;

	/**
	 * The number of structural features of the '<em>Write Destination Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_DESTINATION_MODEL_FEATURE_COUNT = MODEL_MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.CfsInstructionImpl <em>Cfs Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.CfsInstructionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCfsInstruction()
	 * @generated
	 */
	int CFS_INSTRUCTION = 6;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_INSTRUCTION__CONDITIONS = VAPODI_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cfs Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_INSTRUCTION_FEATURE_COUNT = VAPODI_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.VariableDeclarationImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 23;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VARIABLES = 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.FunctionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 7;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__VARIABLES = VARIABLE_DECLARATION__VARIABLES;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__BODY = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__MAIN = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = VARIABLE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.VariableImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ConditionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 9;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__DEPENDENCIES = 0;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.DebugImpl <em>Debug</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.DebugImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getDebug()
	 * @generated
	 */
	int DEBUG = 10;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG__TEXT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Debug</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ProgramImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 11;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__VARIABLES = VARIABLE_DECLARATION__VARIABLES;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__FUNCTIONS = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__MODELS = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__NAME = VARIABLE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.LoopImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 12;

	/**
	 * The feature id for the '<em><b>Opposite Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__OPPOSITE_BRANCH = NUMEROUS_KINDS_OF_BRANCHES__OPPOSITE_BRANCH;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__BODY = NUMEROUS_KINDS_OF_BRANCHES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__INVARIANT = NUMEROUS_KINDS_OF_BRANCHES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = NUMEROUS_KINDS_OF_BRANCHES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.BranchImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 14;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__BODY = 1;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.CallImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 15;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__FUNCTION = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.Model <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.Model
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METAMODEL = 1;

	/**
	 * The feature id for the '<em><b>Urn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__URN = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.AddTraceLinkImpl <em>Add Trace Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.AddTraceLinkImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getAddTraceLink()
	 * @generated
	 */
	int ADD_TRACE_LINK = 17;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TRACE_LINK__DESTINATION = VAPODI_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Trace Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TRACE_LINK_FEATURE_COUNT = VAPODI_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.WriteImpl <em>Write</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.WriteImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getWrite()
	 * @generated
	 */
	int WRITE = 19;

	/**
	 * The number of structural features of the '<em>Write</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_FEATURE_COUNT = WRITE_DESTINATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.DeleteImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 20;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = WRITE_DESTINATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.TypeFilterImpl <em>Type Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.TypeFilterImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getTypeFilter()
	 * @generated
	 */
	int TYPE_FILTER = 21;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FILTER__DEPENDENCIES = CONDITION__DEPENDENCIES;

	/**
	 * The number of structural features of the '<em>Type Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FILTER_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.LogicalConditionImpl <em>Logical Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.LogicalConditionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getLogicalCondition()
	 * @generated
	 */
	int LOGICAL_CONDITION = 22;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_CONDITION__DEPENDENCIES = CONDITION__DEPENDENCIES;

	/**
	 * The number of structural features of the '<em>Logical Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.BlackBoxInstructionImpl <em>Black Box Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.BlackBoxInstructionImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getBlackBoxInstruction()
	 * @generated
	 */
	int BLACK_BOX_INSTRUCTION = 25;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACK_BOX_INSTRUCTION__PARAMETERS = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Black Box Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACK_BOX_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.InstanceModelImpl <em>Instance Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.InstanceModelImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getInstanceModel()
	 * @generated
	 */
	int INSTANCE_MODEL = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MODEL__NAME = MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MODEL__METAMODEL = MODEL__METAMODEL;

	/**
	 * The feature id for the '<em><b>Urn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MODEL__URN = MODEL__URN;

	/**
	 * The feature id for the '<em><b>Intention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MODEL__INTENTION = MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Universe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MODEL__UNIVERSE = MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MODEL_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.MetaModelImpl <em>Meta Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.MetaModelImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getMetaModel()
	 * @generated
	 */
	int META_MODEL = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__NAME = MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__METAMODEL = MODEL__METAMODEL;

	/**
	 * The feature id for the '<em><b>Urn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__URN = MODEL__URN;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__NS_URI = MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__NS_PREFIX = MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__TYPES = MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Meta Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_FEATURE_COUNT = MODEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.CommentImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 28;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TEXT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.CfsPushImpl <em>Cfs Push</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.CfsPushImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCfsPush()
	 * @generated
	 */
	int CFS_PUSH = 29;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_PUSH__CONDITIONS = CFS_INSTRUCTION__CONDITIONS;

	/**
	 * The number of structural features of the '<em>Cfs Push</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_PUSH_FEATURE_COUNT = CFS_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.CfsPopImpl <em>Cfs Pop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.CfsPopImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCfsPop()
	 * @generated
	 */
	int CFS_POP = 30;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_POP__CONDITIONS = CFS_INSTRUCTION__CONDITIONS;

	/**
	 * The number of structural features of the '<em>Cfs Pop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_POP_FEATURE_COUNT = CFS_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.PrimitiveVariableImpl <em>Primitive Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.PrimitiveVariableImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getPrimitiveVariable()
	 * @generated
	 */
	int PRIMITIVE_VARIABLE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The number of structural features of the '<em>Primitive Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.CollectionVariableImpl <em>Collection Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.CollectionVariableImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCollectionVariable()
	 * @generated
	 */
	int COLLECTION_VARIABLE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The number of structural features of the '<em>Collection Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ModelVariableImpl <em>Model Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ModelVariableImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelVariable()
	 * @generated
	 */
	int MODEL_VARIABLE = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLE__TYPE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLE__MODEL = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLE__ATTRIBUTES = VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ModelTypeImpl <em>Model Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ModelTypeImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelType()
	 * @generated
	 */
	int MODEL_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__MODEL = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__ATTRIBUTES = 2;

	/**
	 * The number of structural features of the '<em>Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.VariableResetImpl <em>Variable Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.VariableResetImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableReset()
	 * @generated
	 */
	int VARIABLE_RESET = 35;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_RESET__VARIABLES = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_RESET_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ModelTypeAttributeImpl <em>Model Type Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ModelTypeAttributeImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelTypeAttribute()
	 * @generated
	 */
	int MODEL_TYPE_ATTRIBUTE = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_ATTRIBUTE__PART_OF = 1;

	/**
	 * The number of structural features of the '<em>Model Type Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.impl.ModelAttributeVariableImpl <em>Model Attribute Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.impl.ModelAttributeVariableImpl
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelAttributeVariable()
	 * @generated
	 */
	int MODEL_ATTRIBUTE_VARIABLE = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ATTRIBUTE_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ATTRIBUTE_VARIABLE__PART_OF = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Attribute Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ATTRIBUTE_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.IntentionEnum <em>Intention Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.IntentionEnum
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getIntentionEnum()
	 * @generated
	 */
	int INTENTION_ENUM = 38;

	/**
	 * The meta object id for the '{@link org.qualitune.tracing.umt.UniverseType <em>Universe Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.tracing.umt.UniverseType
	 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getUniverseType()
	 * @generated
	 */
	int UNIVERSE_TYPE = 39;


	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.InstructionBlock <em>Instruction Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction Block</em>'.
	 * @see org.qualitune.tracing.umt.InstructionBlock
	 * @generated
	 */
	EClass getInstructionBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.InstructionBlock#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see org.qualitune.tracing.umt.InstructionBlock#getInstructions()
	 * @see #getInstructionBlock()
	 * @generated
	 */
	EReference getInstructionBlock_Instructions();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see org.qualitune.tracing.umt.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see org.qualitune.tracing.umt.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.Selection#getBranches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branches</em>'.
	 * @see org.qualitune.tracing.umt.Selection#getBranches()
	 * @see #getSelection()
	 * @generated
	 */
	EReference getSelection_Branches();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.VariableDeclarationInstruction <em>Variable Declaration Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration Instruction</em>'.
	 * @see org.qualitune.tracing.umt.VariableDeclarationInstruction
	 * @generated
	 */
	EClass getVariableDeclarationInstruction();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.VariableDeclarationInstruction#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.qualitune.tracing.umt.VariableDeclarationInstruction#getVariables()
	 * @see #getVariableDeclarationInstruction()
	 * @generated
	 */
	EReference getVariableDeclarationInstruction_Variables();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see org.qualitune.tracing.umt.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.VariableAssignment#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.qualitune.tracing.umt.VariableAssignment#getDestination()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Destination();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.VariableAssignment#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see org.qualitune.tracing.umt.VariableAssignment#getSource()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Source();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.WriteDestinationModel <em>Write Destination Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Destination Model</em>'.
	 * @see org.qualitune.tracing.umt.WriteDestinationModel
	 * @generated
	 */
	EClass getWriteDestinationModel();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.CfsInstruction <em>Cfs Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cfs Instruction</em>'.
	 * @see org.qualitune.tracing.umt.CfsInstruction
	 * @generated
	 */
	EClass getCfsInstruction();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.CfsInstruction#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conditions</em>'.
	 * @see org.qualitune.tracing.umt.CfsInstruction#getConditions()
	 * @see #getCfsInstruction()
	 * @generated
	 */
	EReference getCfsInstruction_Conditions();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.qualitune.tracing.umt.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.tracing.umt.Function#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.qualitune.tracing.umt.Function#getBody()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Function#isMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main</em>'.
	 * @see org.qualitune.tracing.umt.Function#isMain()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Main();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.tracing.umt.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.qualitune.tracing.umt.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.tracing.umt.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.qualitune.tracing.umt.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.Condition#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see org.qualitune.tracing.umt.Condition#getDependencies()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Dependencies();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Debug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug</em>'.
	 * @see org.qualitune.tracing.umt.Debug
	 * @generated
	 */
	EClass getDebug();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Debug#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.qualitune.tracing.umt.Debug#getText()
	 * @see #getDebug()
	 * @generated
	 */
	EAttribute getDebug_Text();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.qualitune.tracing.umt.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.Program#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see org.qualitune.tracing.umt.Program#getFunctions()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.Program#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.qualitune.tracing.umt.Program#getModels()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Models();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Program#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.tracing.umt.Program#getName()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Name();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see org.qualitune.tracing.umt.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.tracing.umt.Loop#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.qualitune.tracing.umt.Loop#getBody()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Body();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.Loop#getInvariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invariant</em>'.
	 * @see org.qualitune.tracing.umt.Loop#getInvariant()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Invariant();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.ModelModification <em>Model Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Modification</em>'.
	 * @see org.qualitune.tracing.umt.ModelModification
	 * @generated
	 */
	EClass getModelModification();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see org.qualitune.tracing.umt.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.tracing.umt.Branch#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.qualitune.tracing.umt.Branch#getCondition()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.tracing.umt.Branch#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.qualitune.tracing.umt.Branch#getBody()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_Body();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see org.qualitune.tracing.umt.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.Call#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.qualitune.tracing.umt.Call#getFunction()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Function();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.qualitune.tracing.umt.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Model#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.tracing.umt.Model#getName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Name();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.Model#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see org.qualitune.tracing.umt.Model#getMetamodel()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Metamodel();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Model#getUrn <em>Urn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Urn</em>'.
	 * @see org.qualitune.tracing.umt.Model#getUrn()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Urn();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.AddTraceLink <em>Add Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Trace Link</em>'.
	 * @see org.qualitune.tracing.umt.AddTraceLink
	 * @generated
	 */
	EClass getAddTraceLink();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.AddTraceLink#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination</em>'.
	 * @see org.qualitune.tracing.umt.AddTraceLink#getDestination()
	 * @see #getAddTraceLink()
	 * @generated
	 */
	EReference getAddTraceLink_Destination();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.VapodiInstruction <em>Vapodi Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vapodi Instruction</em>'.
	 * @see org.qualitune.tracing.umt.VapodiInstruction
	 * @generated
	 */
	EClass getVapodiInstruction();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Write <em>Write</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write</em>'.
	 * @see org.qualitune.tracing.umt.Write
	 * @generated
	 */
	EClass getWrite();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see org.qualitune.tracing.umt.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.TypeFilter <em>Type Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Filter</em>'.
	 * @see org.qualitune.tracing.umt.TypeFilter
	 * @generated
	 */
	EClass getTypeFilter();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.LogicalCondition <em>Logical Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Condition</em>'.
	 * @see org.qualitune.tracing.umt.LogicalCondition
	 * @generated
	 */
	EClass getLogicalCondition();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.qualitune.tracing.umt.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.VariableDeclaration#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.qualitune.tracing.umt.VariableDeclaration#getVariables()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Variables();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.NumerousKindsOfBranches <em>Numerous Kinds Of Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerous Kinds Of Branches</em>'.
	 * @see org.qualitune.tracing.umt.NumerousKindsOfBranches
	 * @generated
	 */
	EClass getNumerousKindsOfBranches();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.NumerousKindsOfBranches#getOppositeBranch <em>Opposite Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite Branch</em>'.
	 * @see org.qualitune.tracing.umt.NumerousKindsOfBranches#getOppositeBranch()
	 * @see #getNumerousKindsOfBranches()
	 * @generated
	 */
	EReference getNumerousKindsOfBranches_OppositeBranch();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.BlackBoxInstruction <em>Black Box Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Black Box Instruction</em>'.
	 * @see org.qualitune.tracing.umt.BlackBoxInstruction
	 * @generated
	 */
	EClass getBlackBoxInstruction();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.BlackBoxInstruction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.qualitune.tracing.umt.BlackBoxInstruction#getParameters()
	 * @see #getBlackBoxInstruction()
	 * @generated
	 */
	EReference getBlackBoxInstruction_Parameters();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.InstanceModel <em>Instance Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Model</em>'.
	 * @see org.qualitune.tracing.umt.InstanceModel
	 * @generated
	 */
	EClass getInstanceModel();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.InstanceModel#getIntention <em>Intention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intention</em>'.
	 * @see org.qualitune.tracing.umt.InstanceModel#getIntention()
	 * @see #getInstanceModel()
	 * @generated
	 */
	EAttribute getInstanceModel_Intention();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.InstanceModel#getUniverse <em>Universe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Universe</em>'.
	 * @see org.qualitune.tracing.umt.InstanceModel#getUniverse()
	 * @see #getInstanceModel()
	 * @generated
	 */
	EAttribute getInstanceModel_Universe();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.MetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Model</em>'.
	 * @see org.qualitune.tracing.umt.MetaModel
	 * @generated
	 */
	EClass getMetaModel();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.MetaModel#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.qualitune.tracing.umt.MetaModel#getNsURI()
	 * @see #getMetaModel()
	 * @generated
	 */
	EAttribute getMetaModel_NsURI();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.MetaModel#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.qualitune.tracing.umt.MetaModel#getNsPrefix()
	 * @see #getMetaModel()
	 * @generated
	 */
	EAttribute getMetaModel_NsPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.MetaModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.qualitune.tracing.umt.MetaModel#getTypes()
	 * @see #getMetaModel()
	 * @generated
	 */
	EReference getMetaModel_Types();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.qualitune.tracing.umt.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.Comment#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.qualitune.tracing.umt.Comment#getText()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Text();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.CfsPush <em>Cfs Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cfs Push</em>'.
	 * @see org.qualitune.tracing.umt.CfsPush
	 * @generated
	 */
	EClass getCfsPush();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.CfsPop <em>Cfs Pop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cfs Pop</em>'.
	 * @see org.qualitune.tracing.umt.CfsPop
	 * @generated
	 */
	EClass getCfsPop();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.PrimitiveVariable <em>Primitive Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Variable</em>'.
	 * @see org.qualitune.tracing.umt.PrimitiveVariable
	 * @generated
	 */
	EClass getPrimitiveVariable();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.CollectionVariable <em>Collection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Variable</em>'.
	 * @see org.qualitune.tracing.umt.CollectionVariable
	 * @generated
	 */
	EClass getCollectionVariable();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.ModelVariable <em>Model Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Variable</em>'.
	 * @see org.qualitune.tracing.umt.ModelVariable
	 * @generated
	 */
	EClass getModelVariable();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.ModelVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.qualitune.tracing.umt.ModelVariable#getType()
	 * @see #getModelVariable()
	 * @generated
	 */
	EReference getModelVariable_Type();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.ModelVariable#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.qualitune.tracing.umt.ModelVariable#getModel()
	 * @see #getModelVariable()
	 * @generated
	 */
	EReference getModelVariable_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.ModelVariable#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.qualitune.tracing.umt.ModelVariable#getAttributes()
	 * @see #getModelVariable()
	 * @generated
	 */
	EReference getModelVariable_Attributes();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.ModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type</em>'.
	 * @see org.qualitune.tracing.umt.ModelType
	 * @generated
	 */
	EClass getModelType();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.ModelType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.tracing.umt.ModelType#getName()
	 * @see #getModelType()
	 * @generated
	 */
	EAttribute getModelType_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.qualitune.tracing.umt.ModelType#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see org.qualitune.tracing.umt.ModelType#getModel()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.tracing.umt.ModelType#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.qualitune.tracing.umt.ModelType#getAttributes()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_Attributes();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.VariableReset <em>Variable Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reset</em>'.
	 * @see org.qualitune.tracing.umt.VariableReset
	 * @generated
	 */
	EClass getVariableReset();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.tracing.umt.VariableReset#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.qualitune.tracing.umt.VariableReset#getVariables()
	 * @see #getVariableReset()
	 * @generated
	 */
	EReference getVariableReset_Variables();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.ModelTypeAttribute <em>Model Type Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type Attribute</em>'.
	 * @see org.qualitune.tracing.umt.ModelTypeAttribute
	 * @generated
	 */
	EClass getModelTypeAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.tracing.umt.ModelTypeAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.tracing.umt.ModelTypeAttribute#getName()
	 * @see #getModelTypeAttribute()
	 * @generated
	 */
	EAttribute getModelTypeAttribute_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.qualitune.tracing.umt.ModelTypeAttribute#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Part Of</em>'.
	 * @see org.qualitune.tracing.umt.ModelTypeAttribute#getPartOf()
	 * @see #getModelTypeAttribute()
	 * @generated
	 */
	EReference getModelTypeAttribute_PartOf();

	/**
	 * Returns the meta object for class '{@link org.qualitune.tracing.umt.ModelAttributeVariable <em>Model Attribute Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Attribute Variable</em>'.
	 * @see org.qualitune.tracing.umt.ModelAttributeVariable
	 * @generated
	 */
	EClass getModelAttributeVariable();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.tracing.umt.ModelAttributeVariable#getInstanceOf <em>Instance Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Of</em>'.
	 * @see org.qualitune.tracing.umt.ModelAttributeVariable#getInstanceOf()
	 * @see #getModelAttributeVariable()
	 * @generated
	 */
	EReference getModelAttributeVariable_InstanceOf();

	/**
	 * Returns the meta object for the container reference '{@link org.qualitune.tracing.umt.ModelAttributeVariable#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Part Of</em>'.
	 * @see org.qualitune.tracing.umt.ModelAttributeVariable#getPartOf()
	 * @see #getModelAttributeVariable()
	 * @generated
	 */
	EReference getModelAttributeVariable_PartOf();

	/**
	 * Returns the meta object for enum '{@link org.qualitune.tracing.umt.IntentionEnum <em>Intention Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Intention Enum</em>'.
	 * @see org.qualitune.tracing.umt.IntentionEnum
	 * @generated
	 */
	EEnum getIntentionEnum();

	/**
	 * Returns the meta object for enum '{@link org.qualitune.tracing.umt.UniverseType <em>Universe Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Universe Type</em>'.
	 * @see org.qualitune.tracing.umt.UniverseType
	 * @generated
	 */
	EEnum getUniverseType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmtFactory getUmtFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.InstructionBlockImpl <em>Instruction Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.InstructionBlockImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getInstructionBlock()
		 * @generated
		 */
		EClass INSTRUCTION_BLOCK = eINSTANCE.getInstructionBlock();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_BLOCK__INSTRUCTIONS = eINSTANCE.getInstructionBlock_Instructions();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.Instruction <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.Instruction
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.SelectionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
		 * The meta object literal for the '<em><b>Branches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION__BRANCHES = eINSTANCE.getSelection_Branches();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.VariableDeclarationInstructionImpl <em>Variable Declaration Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.VariableDeclarationInstructionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableDeclarationInstruction()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION_INSTRUCTION = eINSTANCE.getVariableDeclarationInstruction();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_INSTRUCTION__VARIABLES = eINSTANCE.getVariableDeclarationInstruction_Variables();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.VariableAssignmentImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__DESTINATION = eINSTANCE.getVariableAssignment_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__SOURCE = eINSTANCE.getVariableAssignment_Source();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.WriteDestinationModel <em>Write Destination Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.WriteDestinationModel
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getWriteDestinationModel()
		 * @generated
		 */
		EClass WRITE_DESTINATION_MODEL = eINSTANCE.getWriteDestinationModel();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.CfsInstructionImpl <em>Cfs Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.CfsInstructionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCfsInstruction()
		 * @generated
		 */
		EClass CFS_INSTRUCTION = eINSTANCE.getCfsInstruction();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CFS_INSTRUCTION__CONDITIONS = eINSTANCE.getCfsInstruction_Conditions();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.FunctionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__BODY = eINSTANCE.getFunction_Body();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__MAIN = eINSTANCE.getFunction_Main();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.VariableImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariable()
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
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ConditionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__DEPENDENCIES = eINSTANCE.getCondition_Dependencies();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.DebugImpl <em>Debug</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.DebugImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getDebug()
		 * @generated
		 */
		EClass DEBUG = eINSTANCE.getDebug();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG__TEXT = eINSTANCE.getDebug_Text();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ProgramImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__FUNCTIONS = eINSTANCE.getProgram_Functions();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__MODELS = eINSTANCE.getProgram_Models();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__NAME = eINSTANCE.getProgram_Name();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.LoopImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__BODY = eINSTANCE.getLoop_Body();

		/**
		 * The meta object literal for the '<em><b>Invariant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__INVARIANT = eINSTANCE.getLoop_Invariant();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ModelModificationImpl <em>Model Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ModelModificationImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelModification()
		 * @generated
		 */
		EClass MODEL_MODIFICATION = eINSTANCE.getModelModification();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.BranchImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__CONDITION = eINSTANCE.getBranch_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__BODY = eINSTANCE.getBranch_Body();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.CallImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__FUNCTION = eINSTANCE.getCall_Function();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.Model <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.Model
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__METAMODEL = eINSTANCE.getModel_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Urn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__URN = eINSTANCE.getModel_Urn();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.AddTraceLinkImpl <em>Add Trace Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.AddTraceLinkImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getAddTraceLink()
		 * @generated
		 */
		EClass ADD_TRACE_LINK = eINSTANCE.getAddTraceLink();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_TRACE_LINK__DESTINATION = eINSTANCE.getAddTraceLink_Destination();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.VapodiInstruction <em>Vapodi Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.VapodiInstruction
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVapodiInstruction()
		 * @generated
		 */
		EClass VAPODI_INSTRUCTION = eINSTANCE.getVapodiInstruction();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.WriteImpl <em>Write</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.WriteImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getWrite()
		 * @generated
		 */
		EClass WRITE = eINSTANCE.getWrite();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.DeleteImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.TypeFilterImpl <em>Type Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.TypeFilterImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getTypeFilter()
		 * @generated
		 */
		EClass TYPE_FILTER = eINSTANCE.getTypeFilter();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.LogicalConditionImpl <em>Logical Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.LogicalConditionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getLogicalCondition()
		 * @generated
		 */
		EClass LOGICAL_CONDITION = eINSTANCE.getLogicalCondition();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.VariableDeclarationImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__VARIABLES = eINSTANCE.getVariableDeclaration_Variables();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.NumerousKindsOfBranches <em>Numerous Kinds Of Branches</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.NumerousKindsOfBranches
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getNumerousKindsOfBranches()
		 * @generated
		 */
		EClass NUMEROUS_KINDS_OF_BRANCHES = eINSTANCE.getNumerousKindsOfBranches();

		/**
		 * The meta object literal for the '<em><b>Opposite Branch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMEROUS_KINDS_OF_BRANCHES__OPPOSITE_BRANCH = eINSTANCE.getNumerousKindsOfBranches_OppositeBranch();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.BlackBoxInstructionImpl <em>Black Box Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.BlackBoxInstructionImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getBlackBoxInstruction()
		 * @generated
		 */
		EClass BLACK_BOX_INSTRUCTION = eINSTANCE.getBlackBoxInstruction();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLACK_BOX_INSTRUCTION__PARAMETERS = eINSTANCE.getBlackBoxInstruction_Parameters();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.InstanceModelImpl <em>Instance Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.InstanceModelImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getInstanceModel()
		 * @generated
		 */
		EClass INSTANCE_MODEL = eINSTANCE.getInstanceModel();

		/**
		 * The meta object literal for the '<em><b>Intention</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_MODEL__INTENTION = eINSTANCE.getInstanceModel_Intention();

		/**
		 * The meta object literal for the '<em><b>Universe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_MODEL__UNIVERSE = eINSTANCE.getInstanceModel_Universe();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.MetaModelImpl <em>Meta Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.MetaModelImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getMetaModel()
		 * @generated
		 */
		EClass META_MODEL = eINSTANCE.getMetaModel();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_MODEL__NS_URI = eINSTANCE.getMetaModel_NsURI();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_MODEL__NS_PREFIX = eINSTANCE.getMetaModel_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_MODEL__TYPES = eINSTANCE.getMetaModel_Types();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.CommentImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__TEXT = eINSTANCE.getComment_Text();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.CfsPushImpl <em>Cfs Push</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.CfsPushImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCfsPush()
		 * @generated
		 */
		EClass CFS_PUSH = eINSTANCE.getCfsPush();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.CfsPopImpl <em>Cfs Pop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.CfsPopImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCfsPop()
		 * @generated
		 */
		EClass CFS_POP = eINSTANCE.getCfsPop();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.PrimitiveVariableImpl <em>Primitive Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.PrimitiveVariableImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getPrimitiveVariable()
		 * @generated
		 */
		EClass PRIMITIVE_VARIABLE = eINSTANCE.getPrimitiveVariable();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.CollectionVariableImpl <em>Collection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.CollectionVariableImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getCollectionVariable()
		 * @generated
		 */
		EClass COLLECTION_VARIABLE = eINSTANCE.getCollectionVariable();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ModelVariableImpl <em>Model Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ModelVariableImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelVariable()
		 * @generated
		 */
		EClass MODEL_VARIABLE = eINSTANCE.getModelVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_VARIABLE__TYPE = eINSTANCE.getModelVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_VARIABLE__MODEL = eINSTANCE.getModelVariable_Model();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_VARIABLE__ATTRIBUTES = eINSTANCE.getModelVariable_Attributes();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ModelTypeImpl <em>Model Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ModelTypeImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelType()
		 * @generated
		 */
		EClass MODEL_TYPE = eINSTANCE.getModelType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE__NAME = eINSTANCE.getModelType_Name();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__MODEL = eINSTANCE.getModelType_Model();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__ATTRIBUTES = eINSTANCE.getModelType_Attributes();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.VariableResetImpl <em>Variable Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.VariableResetImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getVariableReset()
		 * @generated
		 */
		EClass VARIABLE_RESET = eINSTANCE.getVariableReset();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_RESET__VARIABLES = eINSTANCE.getVariableReset_Variables();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ModelTypeAttributeImpl <em>Model Type Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ModelTypeAttributeImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelTypeAttribute()
		 * @generated
		 */
		EClass MODEL_TYPE_ATTRIBUTE = eINSTANCE.getModelTypeAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE_ATTRIBUTE__NAME = eINSTANCE.getModelTypeAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Part Of</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_ATTRIBUTE__PART_OF = eINSTANCE.getModelTypeAttribute_PartOf();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.impl.ModelAttributeVariableImpl <em>Model Attribute Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.impl.ModelAttributeVariableImpl
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getModelAttributeVariable()
		 * @generated
		 */
		EClass MODEL_ATTRIBUTE_VARIABLE = eINSTANCE.getModelAttributeVariable();

		/**
		 * The meta object literal for the '<em><b>Instance Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF = eINSTANCE.getModelAttributeVariable_InstanceOf();

		/**
		 * The meta object literal for the '<em><b>Part Of</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ATTRIBUTE_VARIABLE__PART_OF = eINSTANCE.getModelAttributeVariable_PartOf();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.IntentionEnum <em>Intention Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.IntentionEnum
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getIntentionEnum()
		 * @generated
		 */
		EEnum INTENTION_ENUM = eINSTANCE.getIntentionEnum();

		/**
		 * The meta object literal for the '{@link org.qualitune.tracing.umt.UniverseType <em>Universe Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.tracing.umt.UniverseType
		 * @see org.qualitune.tracing.umt.impl.UmtPackageImpl#getUniverseType()
		 * @generated
		 */
		EEnum UNIVERSE_TYPE = eINSTANCE.getUniverseType();

	}

} //UmtPackage
