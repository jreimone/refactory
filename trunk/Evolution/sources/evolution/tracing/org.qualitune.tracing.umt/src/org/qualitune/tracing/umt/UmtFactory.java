/**
 */
package org.qualitune.tracing.umt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.umt.UmtPackage
 * @generated
 */
public interface UmtFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmtFactory eINSTANCE = org.qualitune.tracing.umt.impl.UmtFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Instruction Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instruction Block</em>'.
	 * @generated
	 */
	InstructionBlock createInstructionBlock();

	/**
	 * Returns a new object of class '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection</em>'.
	 * @generated
	 */
	Selection createSelection();

	/**
	 * Returns a new object of class '<em>Variable Declaration Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration Instruction</em>'.
	 * @generated
	 */
	VariableDeclarationInstruction createVariableDeclarationInstruction();

	/**
	 * Returns a new object of class '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Assignment</em>'.
	 * @generated
	 */
	VariableAssignment createVariableAssignment();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Debug</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Debug</em>'.
	 * @generated
	 */
	Debug createDebug();

	/**
	 * Returns a new object of class '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program</em>'.
	 * @generated
	 */
	Program createProgram();

	/**
	 * Returns a new object of class '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop</em>'.
	 * @generated
	 */
	Loop createLoop();

	/**
	 * Returns a new object of class '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch</em>'.
	 * @generated
	 */
	Branch createBranch();

	/**
	 * Returns a new object of class '<em>Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Expression</em>'.
	 * @generated
	 */
	CallExpression createCallExpression();

	/**
	 * Returns a new object of class '<em>Add Trace Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Trace Link</em>'.
	 * @generated
	 */
	AddTraceLink createAddTraceLink();

	/**
	 * Returns a new object of class '<em>Write</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write</em>'.
	 * @generated
	 */
	Write createWrite();

	/**
	 * Returns a new object of class '<em>Delete</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete</em>'.
	 * @generated
	 */
	Delete createDelete();

	/**
	 * Returns a new object of class '<em>Type Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Filter</em>'.
	 * @generated
	 */
	TypeFilter createTypeFilter();

	/**
	 * Returns a new object of class '<em>Logical Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Condition</em>'.
	 * @generated
	 */
	LogicalCondition createLogicalCondition();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Black Box Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Black Box Expression</em>'.
	 * @generated
	 */
	BlackBoxExpression createBlackBoxExpression();

	/**
	 * Returns a new object of class '<em>Instance Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Model</em>'.
	 * @generated
	 */
	InstanceModel createInstanceModel();

	/**
	 * Returns a new object of class '<em>Meta Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Model</em>'.
	 * @generated
	 */
	MetaModel createMetaModel();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Cfs Push</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cfs Push</em>'.
	 * @generated
	 */
	CfsPush createCfsPush();

	/**
	 * Returns a new object of class '<em>Cfs Pop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cfs Pop</em>'.
	 * @generated
	 */
	CfsPop createCfsPop();

	/**
	 * Returns a new object of class '<em>Primitive Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Variable</em>'.
	 * @generated
	 */
	PrimitiveVariable createPrimitiveVariable();

	/**
	 * Returns a new object of class '<em>Collection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Variable</em>'.
	 * @generated
	 */
	CollectionVariable createCollectionVariable();

	/**
	 * Returns a new object of class '<em>Model Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Variable</em>'.
	 * @generated
	 */
	ModelVariable createModelVariable();

	/**
	 * Returns a new object of class '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type</em>'.
	 * @generated
	 */
	ModelType createModelType();

	/**
	 * Returns a new object of class '<em>Variable Reset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Reset</em>'.
	 * @generated
	 */
	VariableReset createVariableReset();

	/**
	 * Returns a new object of class '<em>Model Type Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type Attribute</em>'.
	 * @generated
	 */
	ModelTypeAttribute createModelTypeAttribute();

	/**
	 * Returns a new object of class '<em>Model Attribute Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Attribute Variable</em>'.
	 * @generated
	 */
	ModelAttributeVariable createModelAttributeVariable();

	/**
	 * Returns a new object of class '<em>St Put</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>St Put</em>'.
	 * @generated
	 */
	StPut createStPut();

	/**
	 * Returns a new object of class '<em>St Drop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>St Drop</em>'.
	 * @generated
	 */
	StDrop createStDrop();

	/**
	 * Returns a new object of class '<em>Calculated Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Calculated Expression</em>'.
	 * @generated
	 */
	CalculatedExpression createCalculatedExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmtPackage getUmtPackage();

} //UmtFactory
