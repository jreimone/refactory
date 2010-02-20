/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.refactoring.refactoring_specification.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefactoringSpecificationFactoryImpl extends EFactoryImpl implements RefactoringSpecificationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RefactoringSpecificationFactory init() {
		try {
			RefactoringSpecificationFactory theRefactoringSpecificationFactory = (RefactoringSpecificationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/refactoring_specification"); 
			if (theRefactoringSpecificationFactory != null) {
				return theRefactoringSpecificationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RefactoringSpecificationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringSpecificationFactoryImpl() {
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
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION: return createRefactoringSpecification();
			case RefactoringSpecificationPackage.CREATE: return createCREATE();
			case RefactoringSpecificationPackage.MOVE: return createMOVE();
			case RefactoringSpecificationPackage.VARIABLE: return createVariable();
			case RefactoringSpecificationPackage.VARIABLE_REFERENCE: return createVariableReference();
			case RefactoringSpecificationPackage.ROLE_REFERENCE: return createRoleReference();
			case RefactoringSpecificationPackage.RELATION_REFERENCE: return createRelationReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringSpecification createRefactoringSpecification() {
		RefactoringSpecificationImpl refactoringSpecification = new RefactoringSpecificationImpl();
		return refactoringSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CREATE createCREATE() {
		CREATEImpl create = new CREATEImpl();
		return create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MOVE createMOVE() {
		MOVEImpl move = new MOVEImpl();
		return move;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleReference createRoleReference() {
		RoleReferenceImpl roleReference = new RoleReferenceImpl();
		return roleReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationReference createRelationReference() {
		RelationReferenceImpl relationReference = new RelationReferenceImpl();
		return relationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringSpecificationPackage getRefactoringSpecificationPackage() {
		return (RefactoringSpecificationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RefactoringSpecificationPackage getPackage() {
		return RefactoringSpecificationPackage.eINSTANCE;
	}

} //RefactoringSpecificationFactoryImpl
