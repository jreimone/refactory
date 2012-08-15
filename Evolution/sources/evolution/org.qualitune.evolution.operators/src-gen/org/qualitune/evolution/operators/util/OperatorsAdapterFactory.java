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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.qualitune.evolution.operators.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.operators.OperatorsPackage
 * @generated
 */
public class OperatorsAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static OperatorsPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OperatorsAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = OperatorsPackage.eINSTANCE;
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
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
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
	protected OperatorsSwitch<Adapter> modelSwitch =
		new OperatorsSwitch<Adapter>()
    {
      @Override
      public Adapter caseOperator(Operator object)
      {
        return createOperatorAdapter();
      }
      @Override
      public Adapter caseCREATE(CREATE object)
      {
        return createCREATEAdapter();
      }
      @Override
      public Adapter caseTypeVariable(TypeVariable object)
      {
        return createTypeVariableAdapter();
      }
      @Override
      public Adapter caseDELETE(DELETE object)
      {
        return createDELETEAdapter();
      }
      @Override
      public Adapter caseASSIGN(ASSIGN object)
      {
        return createASSIGNAdapter();
      }
      @Override
      public Adapter caseEObjectReference(EObjectReference object)
      {
        return createEObjectReferenceAdapter();
      }
      @Override
      public Adapter caseResult(Result object)
      {
        return createResultAdapter();
      }
      @Override
      public Adapter caseReferrable(Referrable object)
      {
        return createReferrableAdapter();
      }
      @Override
      public Adapter casePrimitiveReference(PrimitiveReference object)
      {
        return createPrimitiveReferenceAdapter();
      }
      @Override
      public Adapter caseSET(SET object)
      {
        return createSETAdapter();
      }
      @Override
      public Adapter caseVariableReference(VariableReference object)
      {
        return createVariableReferenceAdapter();
      }
      @Override
      public Adapter caseMOVE(MOVE object)
      {
        return createMOVEAdapter();
      }
      @Override
      public Adapter caseSPLIT(SPLIT object)
      {
        return createSPLITAdapter();
      }
      @Override
      public Adapter caseStructuralFeatureSet(StructuralFeatureSet object)
      {
        return createStructuralFeatureSetAdapter();
      }
      @Override
      public Adapter caseMERGE(MERGE object)
      {
        return createMERGEAdapter();
      }
      @Override
      public Adapter caseVAR(VAR object)
      {
        return createVARAdapter();
      }
      @Override
      public Adapter caseQueryVariable(QueryVariable object)
      {
        return createQueryVariableAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
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
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.Operator
   * @generated
   */
	public Adapter createOperatorAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.CREATE <em>CREATE</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.CREATE
   * @generated
   */
	public Adapter createCREATEAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.TypeVariable <em>Type Variable</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.TypeVariable
   * @generated
   */
	public Adapter createTypeVariableAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.DELETE <em>DELETE</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.DELETE
   * @generated
   */
	public Adapter createDELETEAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.ASSIGN <em>ASSIGN</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.ASSIGN
   * @generated
   */
	public Adapter createASSIGNAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.EObjectReference <em>EObject Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.EObjectReference
   * @generated
   */
	public Adapter createEObjectReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.Result <em>Result</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.Result
   * @generated
   */
	public Adapter createResultAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.Referrable <em>Referrable</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.Referrable
   * @generated
   */
	public Adapter createReferrableAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.PrimitiveReference <em>Primitive Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.PrimitiveReference
   * @generated
   */
	public Adapter createPrimitiveReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.SET <em>SET</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.SET
   * @generated
   */
	public Adapter createSETAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.VariableReference <em>Variable Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.VariableReference
   * @generated
   */
	public Adapter createVariableReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.MOVE <em>MOVE</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.MOVE
   * @generated
   */
	public Adapter createMOVEAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.SPLIT <em>SPLIT</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.SPLIT
   * @generated
   */
	public Adapter createSPLITAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.StructuralFeatureSet <em>Structural Feature Set</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.StructuralFeatureSet
   * @generated
   */
	public Adapter createStructuralFeatureSetAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.MERGE <em>MERGE</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.MERGE
   * @generated
   */
	public Adapter createMERGEAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.VAR <em>VAR</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.VAR
   * @generated
   */
	public Adapter createVARAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.QueryVariable <em>Query Variable</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.QueryVariable
   * @generated
   */
	public Adapter createQueryVariableAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.qualitune.evolution.operators.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.qualitune.evolution.operators.Variable
   * @generated
   */
	public Adapter createVariableAdapter() {
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

} //OperatorsAdapterFactory
