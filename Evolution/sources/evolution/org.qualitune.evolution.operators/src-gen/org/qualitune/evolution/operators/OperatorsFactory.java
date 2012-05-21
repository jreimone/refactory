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
package org.qualitune.evolution.operators;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.operators.OperatorsPackage
 * @generated
 */
public interface OperatorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperatorsFactory eINSTANCE = org.qualitune.evolution.operators.impl.OperatorsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CREATE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CREATE</em>'.
	 * @generated
	 */
	CREATE createCREATE();

	/**
	 * Returns a new object of class '<em>Type Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Variable</em>'.
	 * @generated
	 */
	TypeVariable createTypeVariable();

	/**
	 * Returns a new object of class '<em>DELETE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DELETE</em>'.
	 * @generated
	 */
	DELETE createDELETE();

	/**
	 * Returns a new object of class '<em>ASSIGN</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ASSIGN</em>'.
	 * @generated
	 */
	ASSIGN createASSIGN();

	/**
	 * Returns a new object of class '<em>EObject Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Reference</em>'.
	 * @generated
	 */
	EObjectReference createEObjectReference();

	/**
	 * Returns a new object of class '<em>Primitive Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Reference</em>'.
	 * @generated
	 */
	PrimitiveReference createPrimitiveReference();

	/**
	 * Returns a new object of class '<em>SET</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SET</em>'.
	 * @generated
	 */
	SET createSET();

	/**
	 * Returns a new object of class '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Reference</em>'.
	 * @generated
	 */
	VariableReference createVariableReference();

	/**
	 * Returns a new object of class '<em>MOVE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MOVE</em>'.
	 * @generated
	 */
	MOVE createMOVE();

	/**
	 * Returns a new object of class '<em>SPLIT</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPLIT</em>'.
	 * @generated
	 */
	SPLIT createSPLIT();

	/**
	 * Returns a new object of class '<em>Structural Feature Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Feature Set</em>'.
	 * @generated
	 */
	StructuralFeatureSet createStructuralFeatureSet();

	/**
	 * Returns a new object of class '<em>MERGE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MERGE</em>'.
	 * @generated
	 */
	MERGE createMERGE();

	/**
	 * Returns a new object of class '<em>VAR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VAR</em>'.
	 * @generated
	 */
	VAR createVAR();

	/**
	 * Returns a new object of class '<em>Query Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Variable</em>'.
	 * @generated
	 */
	QueryVariable createQueryVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperatorsPackage getOperatorsPackage();

} //OperatorsFactory
