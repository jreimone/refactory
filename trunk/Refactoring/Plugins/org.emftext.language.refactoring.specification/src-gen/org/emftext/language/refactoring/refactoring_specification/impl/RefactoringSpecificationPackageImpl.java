/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.refactoring.refactoring_specification.AttributeCommand;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.ConcreteIndex;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.ContainmentCommand;
import org.emftext.language.refactoring.refactoring_specification.Context;
import org.emftext.language.refactoring.refactoring_specification.DeleteCommand;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.Modifier;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.ObjectReference;
import org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment;
import org.emftext.language.refactoring.refactoring_specification.ObjectRemoval;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.ReferenceCommand;
import org.emftext.language.refactoring.refactoring_specification.RemoveModifier;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.RoleRemoval;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.TraceObject;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;

import org.emftext.language.refactoring.roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefactoringSpecificationPackageImpl extends EPackageImpl implements RefactoringSpecificationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refactoringSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collaborationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uptreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantsReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexAssignmentCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass firstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectReferenceAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectAssignmentCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distinctEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectRemovalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleRemovalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unusedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass afterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum constantsEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RefactoringSpecificationPackageImpl() {
		super(eNS_URI, RefactoringSpecificationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RefactoringSpecificationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RefactoringSpecificationPackage init() {
		if (isInited) return (RefactoringSpecificationPackage)EPackage.Registry.INSTANCE.getEPackage(RefactoringSpecificationPackage.eNS_URI);

		// Obtain or create and register package
		RefactoringSpecificationPackageImpl theRefactoringSpecificationPackage = (RefactoringSpecificationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RefactoringSpecificationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RefactoringSpecificationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RolesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRefactoringSpecificationPackage.createPackageContents();

		// Initialize created meta-data
		theRefactoringSpecificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRefactoringSpecificationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RefactoringSpecificationPackage.eNS_URI, theRefactoringSpecificationPackage);
		return theRefactoringSpecificationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefactoringSpecification() {
		return refactoringSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefactoringSpecification_UsedRoleModel() {
		return (EReference)refactoringSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefactoringSpecification_Instructions() {
		return (EReference)refactoringSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstruction() {
		return instructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainmentCommand() {
		return containmentCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentCommand_Index() {
		return (EReference)containmentCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCREATE() {
		return createEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCREATE_SourceRole() {
		return (EReference)createEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCREATE_TargetContext() {
		return (EReference)createEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMOVE() {
		return moveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMOVE_Source() {
		return (EReference)moveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMOVE_Target() {
		return (EReference)moveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMOVE_MoveModifier() {
		return (EReference)moveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_ContainerCommand() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableReference() {
		return variableReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableReference_Variable() {
		return (EReference)variableReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceContext() {
		return sourceContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleReference() {
		return roleReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleReference_Role() {
		return (EReference)roleReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleReference_From() {
		return (EReference)roleReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollaborationReference() {
		return collaborationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaborationReference_Collaboration() {
		return (EReference)collaborationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetContext() {
		return targetContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceCommand() {
		return referenceCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSET() {
		return setEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSET_Source() {
		return (EReference)setEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSET_Target() {
		return (EReference)setEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCommand() {
		return attributeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getASSIGN() {
		return assignEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getASSIGN_SourceAttribute() {
		return (EReference)assignEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getASSIGN_TargetAttribute() {
		return (EReference)assignEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromClause() {
		return fromClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromClause_Operator() {
		return (EReference)fromClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromClause_Reference() {
		return (EReference)fromClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromOperator() {
		return fromOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUPTREE() {
		return uptreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantsReference() {
		return constantsReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstantsReference_ReferencedConstant() {
		return (EAttribute)constantsReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectReference() {
		return objectReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexAssignmentCommand() {
		return indexAssignmentCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexAssignmentCommand_Variable() {
		return (EReference)indexAssignmentCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexVariable() {
		return indexVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexVariable_Name() {
		return (EAttribute)indexVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexVariable_IndexCommand() {
		return (EReference)indexVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteIndex() {
		return concreteIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteIndex_Index() {
		return (EAttribute)concreteIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFIRST() {
		return firstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLAST() {
		return lastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectReferenceAssignment() {
		return objectReferenceAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectReferenceAssignment_Reference() {
		return (EReference)objectReferenceAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectAssignmentCommand() {
		return objectAssignmentCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectAssignmentCommand_Declaration() {
		return (EReference)objectAssignmentCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclarationCommand() {
		return variableDeclarationCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclarationCommand_Variable() {
		return (EReference)variableDeclarationCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRACE() {
		return traceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRACE_Reference() {
		return (EReference)traceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRACE_Role() {
		return (EReference)traceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceObject() {
		return traceObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceObject_Container() {
		return (EReference)traceObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceObject_AppliedRole() {
		return (EReference)traceObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableAssignment() {
		return variableAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableAssignment_Assignment() {
		return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPATH() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFILTER() {
		return filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifier() {
		return modifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDISTINCT() {
		return distinctEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteCommand() {
		return deleteCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUNSET() {
		return unsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREMOVE() {
		return removeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREMOVE_Removal() {
		return (EReference)removeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREMOVE_Modifier() {
		return (EReference)removeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectRemoval() {
		return objectRemovalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleRemoval() {
		return roleRemovalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleRemoval_Role() {
		return (EReference)roleRemovalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveModifier() {
		return removeModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUNUSED() {
		return unusedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMPTY() {
		return emptyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAFTER() {
		return afterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConstants() {
		return constantsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringSpecificationFactory getRefactoringSpecificationFactory() {
		return (RefactoringSpecificationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		refactoringSpecificationEClass = createEClass(REFACTORING_SPECIFICATION);
		createEReference(refactoringSpecificationEClass, REFACTORING_SPECIFICATION__USED_ROLE_MODEL);
		createEReference(refactoringSpecificationEClass, REFACTORING_SPECIFICATION__INSTRUCTIONS);

		instructionEClass = createEClass(INSTRUCTION);

		containmentCommandEClass = createEClass(CONTAINMENT_COMMAND);
		createEReference(containmentCommandEClass, CONTAINMENT_COMMAND__INDEX);

		createEClass = createEClass(CREATE);
		createEReference(createEClass, CREATE__SOURCE_ROLE);
		createEReference(createEClass, CREATE__TARGET_CONTEXT);

		moveEClass = createEClass(MOVE);
		createEReference(moveEClass, MOVE__SOURCE);
		createEReference(moveEClass, MOVE__TARGET);
		createEReference(moveEClass, MOVE__MOVE_MODIFIER);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEReference(variableEClass, VARIABLE__CONTAINER_COMMAND);

		variableReferenceEClass = createEClass(VARIABLE_REFERENCE);
		createEReference(variableReferenceEClass, VARIABLE_REFERENCE__VARIABLE);

		sourceContextEClass = createEClass(SOURCE_CONTEXT);

		roleReferenceEClass = createEClass(ROLE_REFERENCE);
		createEReference(roleReferenceEClass, ROLE_REFERENCE__ROLE);
		createEReference(roleReferenceEClass, ROLE_REFERENCE__FROM);

		collaborationReferenceEClass = createEClass(COLLABORATION_REFERENCE);
		createEReference(collaborationReferenceEClass, COLLABORATION_REFERENCE__COLLABORATION);

		targetContextEClass = createEClass(TARGET_CONTEXT);

		referenceCommandEClass = createEClass(REFERENCE_COMMAND);

		setEClass = createEClass(SET);
		createEReference(setEClass, SET__SOURCE);
		createEReference(setEClass, SET__TARGET);

		attributeCommandEClass = createEClass(ATTRIBUTE_COMMAND);

		assignEClass = createEClass(ASSIGN);
		createEReference(assignEClass, ASSIGN__SOURCE_ATTRIBUTE);
		createEReference(assignEClass, ASSIGN__TARGET_ATTRIBUTE);

		fromClauseEClass = createEClass(FROM_CLAUSE);
		createEReference(fromClauseEClass, FROM_CLAUSE__OPERATOR);
		createEReference(fromClauseEClass, FROM_CLAUSE__REFERENCE);

		fromOperatorEClass = createEClass(FROM_OPERATOR);

		uptreeEClass = createEClass(UPTREE);

		constantsReferenceEClass = createEClass(CONSTANTS_REFERENCE);
		createEAttribute(constantsReferenceEClass, CONSTANTS_REFERENCE__REFERENCED_CONSTANT);

		objectReferenceEClass = createEClass(OBJECT_REFERENCE);

		contextEClass = createEClass(CONTEXT);

		indexAssignmentCommandEClass = createEClass(INDEX_ASSIGNMENT_COMMAND);
		createEReference(indexAssignmentCommandEClass, INDEX_ASSIGNMENT_COMMAND__VARIABLE);

		indexVariableEClass = createEClass(INDEX_VARIABLE);
		createEAttribute(indexVariableEClass, INDEX_VARIABLE__NAME);
		createEReference(indexVariableEClass, INDEX_VARIABLE__INDEX_COMMAND);

		concreteIndexEClass = createEClass(CONCRETE_INDEX);
		createEAttribute(concreteIndexEClass, CONCRETE_INDEX__INDEX);

		firstEClass = createEClass(FIRST);

		lastEClass = createEClass(LAST);

		objectReferenceAssignmentEClass = createEClass(OBJECT_REFERENCE_ASSIGNMENT);
		createEReference(objectReferenceAssignmentEClass, OBJECT_REFERENCE_ASSIGNMENT__REFERENCE);

		objectAssignmentCommandEClass = createEClass(OBJECT_ASSIGNMENT_COMMAND);
		createEReference(objectAssignmentCommandEClass, OBJECT_ASSIGNMENT_COMMAND__DECLARATION);

		variableDeclarationCommandEClass = createEClass(VARIABLE_DECLARATION_COMMAND);
		createEReference(variableDeclarationCommandEClass, VARIABLE_DECLARATION_COMMAND__VARIABLE);

		traceEClass = createEClass(TRACE);
		createEReference(traceEClass, TRACE__REFERENCE);
		createEReference(traceEClass, TRACE__ROLE);

		traceObjectEClass = createEClass(TRACE_OBJECT);
		createEReference(traceObjectEClass, TRACE_OBJECT__CONTAINER);
		createEReference(traceObjectEClass, TRACE_OBJECT__APPLIED_ROLE);

		variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
		createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__ASSIGNMENT);

		pathEClass = createEClass(PATH);

		filterEClass = createEClass(FILTER);

		modifierEClass = createEClass(MODIFIER);

		distinctEClass = createEClass(DISTINCT);

		deleteCommandEClass = createEClass(DELETE_COMMAND);

		unsetEClass = createEClass(UNSET);

		removeEClass = createEClass(REMOVE);
		createEReference(removeEClass, REMOVE__REMOVAL);
		createEReference(removeEClass, REMOVE__MODIFIER);

		objectRemovalEClass = createEClass(OBJECT_REMOVAL);

		roleRemovalEClass = createEClass(ROLE_REMOVAL);
		createEReference(roleRemovalEClass, ROLE_REMOVAL__ROLE);

		removeModifierEClass = createEClass(REMOVE_MODIFIER);

		unusedEClass = createEClass(UNUSED);

		emptyEClass = createEClass(EMPTY);

		afterEClass = createEClass(AFTER);

		// Create enums
		constantsEEnum = createEEnum(CONSTANTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RolesPackage theRolesPackage = (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		containmentCommandEClass.getESuperTypes().add(this.getInstruction());
		containmentCommandEClass.getESuperTypes().add(this.getReferenceCommand());
		createEClass.getESuperTypes().add(this.getContainmentCommand());
		createEClass.getESuperTypes().add(this.getVariableDeclarationCommand());
		moveEClass.getESuperTypes().add(this.getContainmentCommand());
		variableReferenceEClass.getESuperTypes().add(this.getSourceContext());
		variableReferenceEClass.getESuperTypes().add(this.getTargetContext());
		variableReferenceEClass.getESuperTypes().add(this.getObjectReference());
		sourceContextEClass.getESuperTypes().add(this.getContext());
		roleReferenceEClass.getESuperTypes().add(this.getObjectAssignmentCommand());
		collaborationReferenceEClass.getESuperTypes().add(this.getSourceContext());
		collaborationReferenceEClass.getESuperTypes().add(this.getTargetContext());
		collaborationReferenceEClass.getESuperTypes().add(this.getObjectRemoval());
		collaborationReferenceEClass.getESuperTypes().add(this.getObjectAssignmentCommand());
		targetContextEClass.getESuperTypes().add(this.getContext());
		referenceCommandEClass.getESuperTypes().add(this.getInstruction());
		setEClass.getESuperTypes().add(this.getReferenceCommand());
		attributeCommandEClass.getESuperTypes().add(this.getInstruction());
		assignEClass.getESuperTypes().add(this.getAttributeCommand());
		uptreeEClass.getESuperTypes().add(this.getFromOperator());
		constantsReferenceEClass.getESuperTypes().add(this.getObjectReference());
		constantsReferenceEClass.getESuperTypes().add(this.getSourceContext());
		objectReferenceEClass.getESuperTypes().add(this.getObjectRemoval());
		indexAssignmentCommandEClass.getESuperTypes().add(this.getInstruction());
		concreteIndexEClass.getESuperTypes().add(this.getIndexAssignmentCommand());
		firstEClass.getESuperTypes().add(this.getObjectReferenceAssignment());
		lastEClass.getESuperTypes().add(this.getObjectReferenceAssignment());
		objectReferenceAssignmentEClass.getESuperTypes().add(this.getIndexAssignmentCommand());
		variableDeclarationCommandEClass.getESuperTypes().add(this.getInstruction());
		traceEClass.getESuperTypes().add(this.getObjectAssignmentCommand());
		variableAssignmentEClass.getESuperTypes().add(this.getInstruction());
		variableAssignmentEClass.getESuperTypes().add(this.getVariableDeclarationCommand());
		pathEClass.getESuperTypes().add(this.getFromOperator());
		filterEClass.getESuperTypes().add(this.getFromOperator());
		distinctEClass.getESuperTypes().add(this.getModifier());
		deleteCommandEClass.getESuperTypes().add(this.getInstruction());
		unsetEClass.getESuperTypes().add(this.getReferenceCommand());
		unsetEClass.getESuperTypes().add(this.getDeleteCommand());
		removeEClass.getESuperTypes().add(this.getDeleteCommand());
		removeEClass.getESuperTypes().add(this.getContainmentCommand());
		roleRemovalEClass.getESuperTypes().add(this.getObjectRemoval());
		unusedEClass.getESuperTypes().add(this.getRemoveModifier());
		emptyEClass.getESuperTypes().add(this.getRemoveModifier());
		afterEClass.getESuperTypes().add(this.getObjectReferenceAssignment());

		// Initialize classes and features; add operations and parameters
		initEClass(refactoringSpecificationEClass, RefactoringSpecification.class, "RefactoringSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRefactoringSpecification_UsedRoleModel(), theRolesPackage.getRoleModel(), null, "usedRoleModel", null, 1, 1, RefactoringSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRefactoringSpecification_Instructions(), this.getInstruction(), null, "instructions", null, 1, -1, RefactoringSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(refactoringSpecificationEClass, this.getVariable(), "getDeclaredVariables", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(refactoringSpecificationEClass, this.getVariable(), "getVariableByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(refactoringSpecificationEClass, this.getInstruction(), "getInstructionsReferencingRole", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRole(), "referencedRole", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(refactoringSpecificationEClass, ecorePackage.getEBoolean(), "isRoleReferencedByObject", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRolesPackage.getRole(), "referencedRole", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instructionEClass, Instruction.class, "Instruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containmentCommandEClass, ContainmentCommand.class, "ContainmentCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainmentCommand_Index(), this.getIndexVariable(), null, "index", null, 0, 1, ContainmentCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createEClass, org.emftext.language.refactoring.refactoring_specification.CREATE.class, "CREATE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCREATE_SourceRole(), theRolesPackage.getRole(), null, "sourceRole", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.CREATE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCREATE_TargetContext(), this.getTargetContext(), null, "targetContext", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.CREATE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moveEClass, org.emftext.language.refactoring.refactoring_specification.MOVE.class, "MOVE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMOVE_Source(), this.getSourceContext(), null, "source", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.MOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMOVE_Target(), this.getTargetContext(), null, "target", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.MOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMOVE_MoveModifier(), this.getModifier(), null, "moveModifier", null, 0, 1, org.emftext.language.refactoring.refactoring_specification.MOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_ContainerCommand(), this.getVariableDeclarationCommand(), this.getVariableDeclarationCommand_Variable(), "containerCommand", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableReferenceEClass, VariableReference.class, "VariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableReference_Variable(), this.getVariable(), null, "variable", null, 1, 1, VariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceContextEClass, SourceContext.class, "SourceContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleReferenceEClass, RoleReference.class, "RoleReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleReference_Role(), theRolesPackage.getRole(), null, "role", null, 1, 1, RoleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleReference_From(), this.getFromClause(), null, "from", null, 1, 1, RoleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collaborationReferenceEClass, CollaborationReference.class, "CollaborationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollaborationReference_Collaboration(), theRolesPackage.getMultiplicityCollaboration(), null, "collaboration", null, 1, 1, CollaborationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetContextEClass, TargetContext.class, "TargetContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceCommandEClass, ReferenceCommand.class, "ReferenceCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setEClass, org.emftext.language.refactoring.refactoring_specification.SET.class, "SET", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSET_Source(), this.getSourceContext(), null, "source", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.SET.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSET_Target(), this.getTargetContext(), null, "target", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.SET.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeCommandEClass, AttributeCommand.class, "AttributeCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignEClass, org.emftext.language.refactoring.refactoring_specification.ASSIGN.class, "ASSIGN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getASSIGN_SourceAttribute(), theRolesPackage.getRoleAttribute(), null, "sourceAttribute", null, 0, 1, org.emftext.language.refactoring.refactoring_specification.ASSIGN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getASSIGN_TargetAttribute(), theRolesPackage.getRoleAttribute(), null, "targetAttribute", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.ASSIGN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fromClauseEClass, FromClause.class, "FromClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromClause_Operator(), this.getFromOperator(), null, "operator", null, 1, 1, FromClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromClause_Reference(), this.getObjectReference(), null, "reference", null, 1, 1, FromClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fromOperatorEClass, FromOperator.class, "FromOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uptreeEClass, org.emftext.language.refactoring.refactoring_specification.UPTREE.class, "UPTREE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantsReferenceEClass, ConstantsReference.class, "ConstantsReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantsReference_ReferencedConstant(), this.getConstants(), "referencedConstant", null, 1, 1, ConstantsReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectReferenceEClass, ObjectReference.class, "ObjectReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contextEClass, Context.class, "Context", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(indexAssignmentCommandEClass, IndexAssignmentCommand.class, "IndexAssignmentCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndexAssignmentCommand_Variable(), this.getIndexVariable(), this.getIndexVariable_IndexCommand(), "variable", null, 1, 1, IndexAssignmentCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexVariableEClass, IndexVariable.class, "IndexVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, IndexVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexVariable_IndexCommand(), this.getIndexAssignmentCommand(), this.getIndexAssignmentCommand_Variable(), "indexCommand", null, 1, 1, IndexVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteIndexEClass, ConcreteIndex.class, "ConcreteIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcreteIndex_Index(), ecorePackage.getEInt(), "index", null, 1, 1, ConcreteIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(firstEClass, org.emftext.language.refactoring.refactoring_specification.FIRST.class, "FIRST", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lastEClass, org.emftext.language.refactoring.refactoring_specification.LAST.class, "LAST", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectReferenceAssignmentEClass, ObjectReferenceAssignment.class, "ObjectReferenceAssignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectReferenceAssignment_Reference(), this.getObjectReference(), null, "reference", null, 1, 1, ObjectReferenceAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectAssignmentCommandEClass, ObjectAssignmentCommand.class, "ObjectAssignmentCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectAssignmentCommand_Declaration(), this.getVariableAssignment(), this.getVariableAssignment_Assignment(), "declaration", null, 1, 1, ObjectAssignmentCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclarationCommandEClass, VariableDeclarationCommand.class, "VariableDeclarationCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclarationCommand_Variable(), this.getVariable(), this.getVariable_ContainerCommand(), "variable", null, 1, 1, VariableDeclarationCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceEClass, org.emftext.language.refactoring.refactoring_specification.TRACE.class, "TRACE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRACE_Reference(), this.getObjectReference(), null, "reference", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.TRACE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRACE_Role(), theRolesPackage.getRole(), null, "role", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.TRACE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceObjectEClass, TraceObject.class, "TraceObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceObject_Container(), ecorePackage.getEObject(), null, "container", null, 1, 1, TraceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceObject_AppliedRole(), theRolesPackage.getRole(), null, "appliedRole", null, 1, 1, TraceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableAssignment_Assignment(), this.getObjectAssignmentCommand(), this.getObjectAssignmentCommand_Declaration(), "assignment", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathEClass, org.emftext.language.refactoring.refactoring_specification.PATH.class, "PATH", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterEClass, org.emftext.language.refactoring.refactoring_specification.FILTER.class, "FILTER", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modifierEClass, Modifier.class, "Modifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(distinctEClass, org.emftext.language.refactoring.refactoring_specification.DISTINCT.class, "DISTINCT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteCommandEClass, DeleteCommand.class, "DeleteCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unsetEClass, org.emftext.language.refactoring.refactoring_specification.UNSET.class, "UNSET", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeEClass, org.emftext.language.refactoring.refactoring_specification.REMOVE.class, "REMOVE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getREMOVE_Removal(), this.getObjectRemoval(), null, "removal", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.REMOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getREMOVE_Modifier(), this.getRemoveModifier(), null, "modifier", null, 0, 1, org.emftext.language.refactoring.refactoring_specification.REMOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectRemovalEClass, ObjectRemoval.class, "ObjectRemoval", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleRemovalEClass, RoleRemoval.class, "RoleRemoval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleRemoval_Role(), theRolesPackage.getRole(), null, "role", null, 1, 1, RoleRemoval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeModifierEClass, RemoveModifier.class, "RemoveModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unusedEClass, org.emftext.language.refactoring.refactoring_specification.UNUSED.class, "UNUSED", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emptyEClass, org.emftext.language.refactoring.refactoring_specification.EMPTY.class, "EMPTY", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(afterEClass, org.emftext.language.refactoring.refactoring_specification.AFTER.class, "AFTER", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(constantsEEnum, Constants.class, "Constants");
		addEEnumLiteral(constantsEEnum, Constants.INPUT);

		// Create resource
		createResource(eNS_URI);
	}

} //RefactoringSpecificationPackageImpl
