/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class RefactoringSpecificationFactoryImpl extends EFactoryImpl implements RefactoringSpecificationFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RefactoringSpecificationFactory init()
  {
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
  public RefactoringSpecificationFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION: return createRefactoringSpecification();
			case RefactoringSpecificationPackage.CREATE: return createCREATE();
			case RefactoringSpecificationPackage.MOVE: return createMOVE();
			case RefactoringSpecificationPackage.VARIABLE: return createVariable();
			case RefactoringSpecificationPackage.VARIABLE_REFERENCE: return createVariableReference();
			case RefactoringSpecificationPackage.ROLE_REFERENCE: return createRoleReference();
			case RefactoringSpecificationPackage.COLLABORATION_REFERENCE: return createCollaborationReference();
			case RefactoringSpecificationPackage.SET: return createSET();
			case RefactoringSpecificationPackage.ASSIGN: return createASSIGN();
			case RefactoringSpecificationPackage.FROM_CLAUSE: return createFromClause();
			case RefactoringSpecificationPackage.UPTREE: return createUPTREE();
			case RefactoringSpecificationPackage.CONSTANTS_REFERENCE: return createConstantsReference();
			case RefactoringSpecificationPackage.INDEX_VARIABLE: return createIndexVariable();
			case RefactoringSpecificationPackage.CONCRETE_INDEX: return createConcreteIndex();
			case RefactoringSpecificationPackage.FIRST: return createFIRST();
			case RefactoringSpecificationPackage.LAST: return createLAST();
			case RefactoringSpecificationPackage.TRACE: return createTRACE();
			case RefactoringSpecificationPackage.TRACE_OBJECT: return createTraceObject();
			case RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
			case RefactoringSpecificationPackage.PATH: return createPATH();
			case RefactoringSpecificationPackage.FILTER: return createFILTER();
			case RefactoringSpecificationPackage.DISTINCT: return createDISTINCT();
			case RefactoringSpecificationPackage.UNSET: return createUNSET();
			case RefactoringSpecificationPackage.REMOVE: return createREMOVE();
			case RefactoringSpecificationPackage.ROLE_REMOVAL: return createRoleRemoval();
			case RefactoringSpecificationPackage.UNUSED: return createUNUSED();
			case RefactoringSpecificationPackage.EMPTY: return createEMPTY();
			case RefactoringSpecificationPackage.AFTER: return createAFTER();
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
  public Object createFromString(EDataType eDataType, String initialValue)
  {
		switch (eDataType.getClassifierID()) {
			case RefactoringSpecificationPackage.CONSTANTS:
				return createConstantsFromString(eDataType, initialValue);
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
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
		switch (eDataType.getClassifierID()) {
			case RefactoringSpecificationPackage.CONSTANTS:
				return convertConstantsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RefactoringSpecification createRefactoringSpecification()
  {
		RefactoringSpecificationImpl refactoringSpecification = new RefactoringSpecificationImpl();
		return refactoringSpecification;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CREATE createCREATE()
  {
		CREATEImpl create = new CREATEImpl();
		return create;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MOVE createMOVE()
  {
		MOVEImpl move = new MOVEImpl();
		return move;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Variable createVariable()
  {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VariableReference createVariableReference()
  {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RoleReference createRoleReference()
  {
		RoleReferenceImpl roleReference = new RoleReferenceImpl();
		return roleReference;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationReference createCollaborationReference() {
		CollaborationReferenceImpl collaborationReference = new CollaborationReferenceImpl();
		return collaborationReference;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SET createSET()
  {
		SETImpl set = new SETImpl();
		return set;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ASSIGN createASSIGN()
  {
		ASSIGNImpl assign = new ASSIGNImpl();
		return assign;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FromClause createFromClause()
  {
		FromClauseImpl fromClause = new FromClauseImpl();
		return fromClause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UPTREE createUPTREE()
  {
		UPTREEImpl uptree = new UPTREEImpl();
		return uptree;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConstantsReference createConstantsReference()
  {
		ConstantsReferenceImpl constantsReference = new ConstantsReferenceImpl();
		return constantsReference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IndexVariable createIndexVariable()
  {
		IndexVariableImpl indexVariable = new IndexVariableImpl();
		return indexVariable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConcreteIndex createConcreteIndex()
  {
		ConcreteIndexImpl concreteIndex = new ConcreteIndexImpl();
		return concreteIndex;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FIRST createFIRST()
  {
		FIRSTImpl first = new FIRSTImpl();
		return first;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LAST createLAST()
  {
		LASTImpl last = new LASTImpl();
		return last;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TRACE createTRACE()
  {
		TRACEImpl trace = new TRACEImpl();
		return trace;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TraceObject createTraceObject()
  {
		TraceObjectImpl traceObject = new TraceObjectImpl();
		return traceObject;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VariableAssignment createVariableAssignment()
  {
		VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
		return variableAssignment;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PATH createPATH()
  {
		PATHImpl path = new PATHImpl();
		return path;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FILTER createFILTER()
  {
		FILTERImpl filter = new FILTERImpl();
		return filter;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DISTINCT createDISTINCT() {
		DISTINCTImpl distinct = new DISTINCTImpl();
		return distinct;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UNSET createUNSET() {
		UNSETImpl unset = new UNSETImpl();
		return unset;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REMOVE createREMOVE() {
		REMOVEImpl remove = new REMOVEImpl();
		return remove;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleRemoval createRoleRemoval() {
		RoleRemovalImpl roleRemoval = new RoleRemovalImpl();
		return roleRemoval;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UNUSED createUNUSED() {
		UNUSEDImpl unused = new UNUSEDImpl();
		return unused;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMPTY createEMPTY() {
		EMPTYImpl empty = new EMPTYImpl();
		return empty;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AFTER createAFTER() {
		AFTERImpl after = new AFTERImpl();
		return after;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Constants createConstantsFromString(EDataType eDataType, String initialValue)
  {
		Constants result = Constants.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertConstantsToString(EDataType eDataType, Object instanceValue)
  {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RefactoringSpecificationPackage getRefactoringSpecificationPackage()
  {
		return (RefactoringSpecificationPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static RefactoringSpecificationPackage getPackage()
  {
		return RefactoringSpecificationPackage.eINSTANCE;
	}

} //RefactoringSpecificationFactoryImpl
