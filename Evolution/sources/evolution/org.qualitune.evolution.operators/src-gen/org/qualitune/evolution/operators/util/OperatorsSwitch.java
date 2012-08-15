/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 */
package org.qualitune.evolution.operators.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.qualitune.evolution.operators.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.operators.OperatorsPackage
 * @generated
 */
public class OperatorsSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static OperatorsPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OperatorsSwitch() {
    if (modelPackage == null)
    {
      modelPackage = OperatorsPackage.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID)
    {
      case OperatorsPackage.OPERATOR:
      {
        Operator operator = (Operator)theEObject;
        T result = caseOperator(operator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.CREATE:
      {
        CREATE create = (CREATE)theEObject;
        T result = caseCREATE(create);
        if (result == null) result = caseOperator(create);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.TYPE_VARIABLE:
      {
        TypeVariable typeVariable = (TypeVariable)theEObject;
        T result = caseTypeVariable(typeVariable);
        if (result == null) result = caseVariable(typeVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.DELETE:
      {
        DELETE delete = (DELETE)theEObject;
        T result = caseDELETE(delete);
        if (result == null) result = caseOperator(delete);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.ASSIGN:
      {
        ASSIGN assign = (ASSIGN)theEObject;
        T result = caseASSIGN(assign);
        if (result == null) result = caseOperator(assign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.EOBJECT_REFERENCE:
      {
        EObjectReference eObjectReference = (EObjectReference)theEObject;
        T result = caseEObjectReference(eObjectReference);
        if (result == null) result = caseResult(eObjectReference);
        if (result == null) result = caseReferrable(eObjectReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.RESULT:
      {
        Result result = (Result)theEObject;
        T theResult = caseResult(result);
        if (theResult == null) theResult = defaultCase(theEObject);
        return theResult;
      }
      case OperatorsPackage.REFERRABLE:
      {
        Referrable referrable = (Referrable)theEObject;
        T result = caseReferrable(referrable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.PRIMITIVE_REFERENCE:
      {
        PrimitiveReference primitiveReference = (PrimitiveReference)theEObject;
        T result = casePrimitiveReference(primitiveReference);
        if (result == null) result = caseResult(primitiveReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.SET:
      {
        SET set = (SET)theEObject;
        T result = caseSET(set);
        if (result == null) result = caseOperator(set);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.VARIABLE_REFERENCE:
      {
        VariableReference variableReference = (VariableReference)theEObject;
        T result = caseVariableReference(variableReference);
        if (result == null) result = caseReferrable(variableReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.MOVE:
      {
        MOVE move = (MOVE)theEObject;
        T result = caseMOVE(move);
        if (result == null) result = caseOperator(move);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.SPLIT:
      {
        SPLIT split = (SPLIT)theEObject;
        T result = caseSPLIT(split);
        if (result == null) result = caseOperator(split);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.STRUCTURAL_FEATURE_SET:
      {
        StructuralFeatureSet structuralFeatureSet = (StructuralFeatureSet)theEObject;
        T result = caseStructuralFeatureSet(structuralFeatureSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.MERGE:
      {
        MERGE merge = (MERGE)theEObject;
        T result = caseMERGE(merge);
        if (result == null) result = caseOperator(merge);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.VAR:
      {
        VAR var = (VAR)theEObject;
        T result = caseVAR(var);
        if (result == null) result = caseOperator(var);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.QUERY_VARIABLE:
      {
        QueryVariable queryVariable = (QueryVariable)theEObject;
        T result = caseQueryVariable(queryVariable);
        if (result == null) result = caseVariable(queryVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OperatorsPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseOperator(Operator object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>CREATE</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CREATE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCREATE(CREATE object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Type Variable</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTypeVariable(TypeVariable object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>DELETE</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DELETE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDELETE(DELETE object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>ASSIGN</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASSIGN</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseASSIGN(ASSIGN object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject Reference</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseEObjectReference(EObjectReference object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Result</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseResult(Result object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Referrable</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Referrable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseReferrable(Referrable object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Reference</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePrimitiveReference(PrimitiveReference object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>SET</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SET</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSET(SET object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseVariableReference(VariableReference object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>MOVE</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MOVE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMOVE(MOVE object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>SPLIT</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SPLIT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSPLIT(SPLIT object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Structural Feature Set</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structural Feature Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseStructuralFeatureSet(StructuralFeatureSet object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>MERGE</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MERGE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMERGE(MERGE object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>VAR</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>VAR</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseVAR(VAR object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Query Variable</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseQueryVariable(QueryVariable object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseVariable(Variable object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
	public T defaultCase(EObject object) {
    return null;
  }

} //OperatorsSwitch
