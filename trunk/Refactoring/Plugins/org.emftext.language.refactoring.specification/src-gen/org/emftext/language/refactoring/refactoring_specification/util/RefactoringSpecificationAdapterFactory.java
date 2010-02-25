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
public class RefactoringSpecificationAdapterFactory extends AdapterFactoryImpl {
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
	public RefactoringSpecificationAdapterFactory() {
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
			public Adapter caseRelationReference(RelationReference object) {
				return createRelationReferenceAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification <em>Refactoring Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification
	 * @generated
	 */
	public Adapter createRefactoringSpecificationAdapter() {
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
	public Adapter createInstructionAdapter() {
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
	public Adapter createContainmentCommandAdapter() {
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
	public Adapter createCREATEAdapter() {
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
	public Adapter createMOVEAdapter() {
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
	public Adapter createVariableAdapter() {
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
	public Adapter createVariableReferenceAdapter() {
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
	public Adapter createSourceContextAdapter() {
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
	public Adapter createRoleReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.language.refactoring.refactoring_specification.RelationReference <em>Relation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.language.refactoring.refactoring_specification.RelationReference
	 * @generated
	 */
	public Adapter createRelationReferenceAdapter() {
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
	public Adapter createTargetContextAdapter() {
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
	public Adapter createReferenceCommandAdapter() {
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
	public Adapter createSETAdapter() {
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
	public Adapter createAttributeCommandAdapter() {
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
	public Adapter createASSIGNAdapter() {
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

} //RefactoringSpecificationAdapterFactory
