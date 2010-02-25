/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public interface RefactoringSpecificationPackage extends EPackage {
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SPECIFICATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SPECIFICATION__INSTRUCTIONS = 2;

	/**
	 * The number of structural features of the '<em>Refactoring Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SPECIFICATION_FEATURE_COUNT = 3;

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
	 * The number of structural features of the '<em>Containment Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_COMMAND_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__VAR_DECLARATION = CONTAINMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Role Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__SOURCE_ROLE_REFERENCE = CONTAINMENT_COMMAND_FEATURE_COUNT + 1;

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
	 * The number of structural features of the '<em>MOVE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FEATURE_COUNT = CONTAINMENT_COMMAND_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Create Command</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CREATE_COMMAND = 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 2;

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
	int SOURCE_CONTEXT_FEATURE_COUNT = 0;

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
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RoleReferenceImpl <em>Role Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RoleReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRoleReference()
	 * @generated
	 */
	int ROLE_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REFERENCE__ROLE = SOURCE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Role Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_REFERENCE_FEATURE_COUNT = SOURCE_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl <em>Relation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl
	 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRelationReference()
	 * @generated
	 */
	int RELATION_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_REFERENCE__RELATION = SOURCE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Relation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_REFERENCE_FEATURE_COUNT = SOURCE_CONTEXT_FEATURE_COUNT + 1;

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
	int TARGET_CONTEXT_FEATURE_COUNT = 0;

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
	 * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getName()
	 * @see #getRefactoringSpecification()
	 * @generated
	 */
	EAttribute getRefactoringSpecification_Name();

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
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.CREATE <em>CREATE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CREATE</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE
	 * @generated
	 */
	EClass getCREATE();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var Declaration</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE#getVarDeclaration()
	 * @see #getCREATE()
	 * @generated
	 */
	EReference getCREATE_VarDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRoleReference <em>Source Role Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Role Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRoleReference()
	 * @see #getCREATE()
	 * @generated
	 */
	EReference getCREATE_SourceRoleReference();

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
	 * Returns the meta object for the container reference '{@link org.emftext.language.refactoring.refactoring_specification.Variable#getCreateCommand <em>Create Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Create Command</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.Variable#getCreateCommand()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_CreateCommand();

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
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoring_specification.RelationReference <em>Relation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Reference</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RelationReference
	 * @generated
	 */
	EClass getRelationReference();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoring_specification.RelationReference#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relation</em>'.
	 * @see org.emftext.language.refactoring.refactoring_specification.RelationReference#getRelation()
	 * @see #getRelationReference()
	 * @generated
	 */
	EReference getRelationReference_Relation();

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
	interface Literals {
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_SPECIFICATION__NAME = eINSTANCE.getRefactoringSpecification_Name();

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
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl <em>CREATE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getCREATE()
		 * @generated
		 */
		EClass CREATE = eINSTANCE.getCREATE();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE__VAR_DECLARATION = eINSTANCE.getCREATE_VarDeclaration();

		/**
		 * The meta object literal for the '<em><b>Source Role Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE__SOURCE_ROLE_REFERENCE = eINSTANCE.getCREATE_SourceRoleReference();

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
		 * The meta object literal for the '<em><b>Create Command</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__CREATE_COMMAND = eINSTANCE.getVariable_CreateCommand();

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
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl <em>Relation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RelationReferenceImpl
		 * @see org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationPackageImpl#getRelationReference()
		 * @generated
		 */
		EClass RELATION_REFERENCE = eINSTANCE.getRelationReference();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_REFERENCE__RELATION = eINSTANCE.getRelationReference_Relation();

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

	}

} //RefactoringSpecificationPackage
