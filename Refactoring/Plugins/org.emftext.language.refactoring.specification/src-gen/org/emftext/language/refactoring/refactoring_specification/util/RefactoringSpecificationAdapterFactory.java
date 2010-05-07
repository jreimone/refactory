/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.refactoring_specification.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage
 * @generated
 */
public class RefactoringSpecificationAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static RefactoringSpecificationPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RefactoringSpecificationAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = RefactoringSpecificationPackage.eINSTANCE;
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
  public boolean isFactoryForType(Object object)
  {
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
  protected RefactoringSpecificationSwitch<Adapter> modelSwitch =
    new RefactoringSpecificationSwitch<Adapter>() {
			@Override
			public Adapter caseRefactoringSpecification(RefactoringSpecification object) {
				return createRefactoringSpecificationAdapter();
			}
			@Override
			public Adapter caseInstruction(Instruction object) {
				return createInstructionAdapter();
			}
			@Override
			public Adapter caseContainmentCommand(ContainmentCommand object) {
				return createContainmentCommandAdapter();
			}
			@Override
			public Adapter caseCREATE(CREATE object) {
				return createCREATEAdapter();
			}
			@Override
			public Adapter caseMOVE(MOVE object) {
				return createMOVEAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseVariableReference(VariableReference object) {
				return createVariableReferenceAdapter();
			}
			@Override
			public Adapter caseSourceContext(SourceContext object) {
				return createSourceContextAdapter();
			}
			@Override
			public Adapter caseRoleReference(RoleReference object) {
				return createRoleReferenceAdapter();
			}
			@Override
			public Adapter caseCollaborationReference(CollaborationReference object) {
				return createCollaborationReferenceAdapter();
			}
			@Override
			public Adapter caseTargetContext(TargetContext object) {
				return createTargetContextAdapter();
			}
			@Override
			public Adapter caseReferenceCommand(ReferenceCommand object) {
				return createReferenceCommandAdapter();
			}
			@Override
			public Adapter caseSET(SET object) {
				return createSETAdapter();
			}
			@Override
			public Adapter caseAttributeCommand(AttributeCommand object) {
				return createAttributeCommandAdapter();
			}
			@Override
			public Adapter caseASSIGN(ASSIGN object) {
				return createASSIGNAdapter();
			}
			@Override
			public Adapter caseFromClause(FromClause object) {
				return createFromClauseAdapter();
			}
			@Override
			public Adapter caseFromOperator(FromOperator object) {
				return createFromOperatorAdapter();
			}
			@Override
			public Adapter caseUPTREE(UPTREE object) {
				return createUPTREEAdapter();
			}
			@Override
			public Adapter caseConstantsReference(ConstantsReference object) {
				return createConstantsReferenceAdapter();
			}
			@Override
			public Adapter caseObjectReference(ObjectReference object) {
				return createObjectReferenceAdapter();
			}
			@Override
			public Adapter caseContext(Context object) {
				return createContextAdapter();
			}
			@Override
			public Adapter caseIndexAssignmentCommand(IndexAssignmentCommand object) {
				return createIndexAssignmentCommandAdapter();
			}
			@Override
			public Adapter caseIndexVariable(IndexVariable object) {
				return createIndexVariableAdapter();
			}
			@Override
			public Adapter caseConcreteIndex(ConcreteIndex object) {
				return createConcreteIndexAdapter();
			}
			@Override
			public Adapter caseFIRST(FIRST object) {
				return createFIRSTAdapter();
			}
			@Override
			public Adapter caseLAST(LAST object) {
				return createLASTAdapter();
			}
			@Override
			public Adapter caseObjectReferenceAssignment(ObjectReferenceAssignment object) {
				return createObjectReferenceAssignmentAdapter();
			}
			@Override
			public Adapter caseObjectAssignmentCommand(ObjectAssignmentCommand object) {
				return createObjectAssignmentCommandAdapter();
			}
			@Override
			public Adapter caseVariableDeclarationCommand(VariableDeclarationCommand object) {
				return createVariableDeclarationCommandAdapter();
			}
			@Override
			public Adapter caseTRACE(TRACE object) {
				return createTRACEAdapter();
			}
			@Override
			public Adapter caseTraceObject(TraceObject object) {
				return createTraceObjectAdapter();
			}
			@Override
			public Adapter caseVariableAssignment(VariableAssignment object) {
				return createVariableAssignmentAdapter();
			}
			@Override
			public Adapter casePATH(PATH object) {
				return createPATHAdapter();
			}
			@Override
			public Adapter caseFILTER(FILTER object) {
				return createFILTERAdapter();
			}
			@Override
			public Adapter caseModifier(Modifier object) {
				return createModifierAdapter();
			}
			@Override
			public Adapter caseDISTINCT(DISTINCT object) {
				return createDISTINCTAdapter();
			}
			@Override
			public Adapter caseDeleteCommand(DeleteCommand object) {
				return createDeleteCommandAdapter();
			}
			@Override
			public Adapter caseUNSET(UNSET object) {
				return createUNSETAdapter();
			}
			@Override
			public Adapter caseREMOVE(REMOVE object) {
				return createREMOVEAdapter();
			}
			@Override
			public Adapter caseObjectRemoval(ObjectRemoval object) {
				return createObjectRemovalAdapter();
			}
			@Override
			public Adapter caseRoleRemoval(RoleRemoval object) {
				return createRoleRemovalAdapter();
			}
			@Override
			public Adapter caseRemoveModifier(RemoveModifier object) {
				return createRemoveModifierAdapter();
			}
			@Override
			public Adapter caseUNUSED(UNUSED object) {
				return createUNUSEDAdapter();
			}
			@Override
			public Adapter caseEMPTY(EMPTY object) {
				return createEMPTYAdapter();
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
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification <em>Refactoring Specification</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification
	 * @generated
	 */
  public Adapter createRefactoringSpecificationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.Instruction
	 * @generated
	 */
  public Adapter createInstructionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ContainmentCommand <em>Containment Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ContainmentCommand
	 * @generated
	 */
  public Adapter createContainmentCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.CREATE <em>CREATE</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.CREATE
	 * @generated
	 */
  public Adapter createCREATEAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.MOVE <em>MOVE</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.MOVE
	 * @generated
	 */
  public Adapter createMOVEAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.Variable
	 * @generated
	 */
  public Adapter createVariableAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableReference
	 * @generated
	 */
  public Adapter createVariableReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.SourceContext <em>Source Context</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.SourceContext
	 * @generated
	 */
  public Adapter createSourceContextAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.RoleReference <em>Role Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleReference
	 * @generated
	 */
  public Adapter createRoleReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.CollaborationReference <em>Collaboration Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.CollaborationReference
	 * @generated
	 */
  public Adapter createCollaborationReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.TargetContext <em>Target Context</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.TargetContext
	 * @generated
	 */
  public Adapter createTargetContextAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ReferenceCommand <em>Reference Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ReferenceCommand
	 * @generated
	 */
  public Adapter createReferenceCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.SET <em>SET</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.SET
	 * @generated
	 */
  public Adapter createSETAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.AttributeCommand <em>Attribute Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.AttributeCommand
	 * @generated
	 */
  public Adapter createAttributeCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN <em>ASSIGN</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ASSIGN
	 * @generated
	 */
  public Adapter createASSIGNAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.FromClause <em>From Clause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.FromClause
	 * @generated
	 */
  public Adapter createFromClauseAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.FromOperator <em>From Operator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.FromOperator
	 * @generated
	 */
  public Adapter createFromOperatorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.UPTREE <em>UPTREE</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.UPTREE
	 * @generated
	 */
  public Adapter createUPTREEAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ConstantsReference <em>Constants Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ConstantsReference
	 * @generated
	 */
  public Adapter createConstantsReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectReference <em>Object Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectReference
	 * @generated
	 */
  public Adapter createObjectReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.Context
	 * @generated
	 */
  public Adapter createContextAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand <em>Index Assignment Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand
	 * @generated
	 */
  public Adapter createIndexAssignmentCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.IndexVariable <em>Index Variable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.IndexVariable
	 * @generated
	 */
  public Adapter createIndexVariableAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ConcreteIndex <em>Concrete Index</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ConcreteIndex
	 * @generated
	 */
  public Adapter createConcreteIndexAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.FIRST <em>FIRST</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.FIRST
	 * @generated
	 */
  public Adapter createFIRSTAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.LAST <em>LAST</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.LAST
	 * @generated
	 */
  public Adapter createLASTAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment <em>Object Reference Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment
	 * @generated
	 */
  public Adapter createObjectReferenceAssignmentAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand <em>Object Assignment Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand
	 * @generated
	 */
  public Adapter createObjectAssignmentCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand <em>Variable Declaration Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand
	 * @generated
	 */
  public Adapter createVariableDeclarationCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.TRACE <em>TRACE</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.TRACE
	 * @generated
	 */
  public Adapter createTRACEAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.TraceObject <em>Trace Object</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.TraceObject
	 * @generated
	 */
  public Adapter createTraceObjectAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.VariableAssignment
	 * @generated
	 */
  public Adapter createVariableAssignmentAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.PATH <em>PATH</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.PATH
	 * @generated
	 */
  public Adapter createPATHAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.FILTER <em>FILTER</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.FILTER
	 * @generated
	 */
  public Adapter createFILTERAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.Modifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.Modifier
	 * @generated
	 */
  public Adapter createModifierAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.DISTINCT <em>DISTINCT</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.DISTINCT
	 * @generated
	 */
  public Adapter createDISTINCTAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.DeleteCommand <em>Delete Command</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.DeleteCommand
	 * @generated
	 */
  public Adapter createDeleteCommandAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.UNSET <em>UNSET</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.UNSET
	 * @generated
	 */
  public Adapter createUNSETAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.REMOVE <em>REMOVE</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.REMOVE
	 * @generated
	 */
  public Adapter createREMOVEAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.ObjectRemoval <em>Object Removal</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.ObjectRemoval
	 * @generated
	 */
  public Adapter createObjectRemovalAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.RoleRemoval <em>Role Removal</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.RoleRemoval
	 * @generated
	 */
  public Adapter createRoleRemovalAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.RemoveModifier <em>Remove Modifier</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.RemoveModifier
	 * @generated
	 */
  public Adapter createRemoveModifierAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.UNUSED <em>UNUSED</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.UNUSED
	 * @generated
	 */
  public Adapter createUNUSEDAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.EMPTY <em>EMPTY</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.EMPTY
	 * @generated
	 */
  public Adapter createEMPTYAdapter()
  {
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
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //RefactoringSpecificationAdapterFactory
