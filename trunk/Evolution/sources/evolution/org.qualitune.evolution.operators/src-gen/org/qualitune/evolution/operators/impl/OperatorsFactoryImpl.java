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
package org.qualitune.evolution.operators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.qualitune.evolution.operators.*;
import org.qualitune.evolution.operators.custom.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorsFactoryImpl extends EFactoryImpl implements OperatorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorsFactory init() {
		try {
			OperatorsFactory theOperatorsFactory = (OperatorsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.qualitune.org/operators"); 
			if (theOperatorsFactory != null) {
				return theOperatorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperatorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsFactoryImpl() {
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
			case OperatorsPackage.CREATE: return createCREATE();
			case OperatorsPackage.TYPE_VARIABLE: return createTypeVariable();
			case OperatorsPackage.DELETE: return createDELETE();
			case OperatorsPackage.ASSIGN: return createASSIGN();
			case OperatorsPackage.EOBJECT_REFERENCE: return createEObjectReference();
			case OperatorsPackage.PRIMITIVE_REFERENCE: return createPrimitiveReference();
			case OperatorsPackage.SET: return createSET();
			case OperatorsPackage.VARIABLE_REFERENCE: return createVariableReference();
			case OperatorsPackage.MOVE: return createMOVE();
			case OperatorsPackage.SPLIT: return createSPLIT();
			case OperatorsPackage.STRUCTURAL_FEATURE_SET: return createStructuralFeatureSet();
			case OperatorsPackage.MERGE: return createMERGE();
			case OperatorsPackage.VAR: return createVAR();
			case OperatorsPackage.QUERY_VARIABLE: return createQueryVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CREATE createCREATE() {
		CREATEImpl create = new CREATECustom();
		return create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeVariable createTypeVariable() {
		TypeVariableImpl typeVariable = new TypeVariableImpl();
		return typeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DELETE createDELETE() {
		DELETEImpl delete = new DELETECustom();
		return delete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASSIGN createASSIGN() {
		ASSIGNImpl assign = new ASSIGNCustom();
		return assign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectReference createEObjectReference() {
		EObjectReferenceImpl eObjectReference = new EObjectReferenceImpl();
		return eObjectReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveReference createPrimitiveReference() {
		PrimitiveReferenceImpl primitiveReference = new PrimitiveReferenceImpl();
		return primitiveReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SET createSET() {
		SETImpl set = new SETCustom();
		return set;
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
	public MOVE createMOVE() {
		MOVEImpl move = new MOVECustom();
		return move;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPLIT createSPLIT() {
		SPLITImpl split = new SPLITImpl();
		return split;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureSet createStructuralFeatureSet() {
		StructuralFeatureSetImpl structuralFeatureSet = new StructuralFeatureSetImpl();
		return structuralFeatureSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MERGE createMERGE() {
		MERGEImpl merge = new MERGEImpl();
		return merge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VAR createVAR() {
		VARImpl var = new VARCustom();
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryVariable createQueryVariable() {
		QueryVariableImpl queryVariable = new QueryVariableImpl();
		return queryVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsPackage getOperatorsPackage() {
		return (OperatorsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperatorsPackage getPackage() {
		return OperatorsPackage.eINSTANCE;
	}

} //OperatorsFactoryImpl
