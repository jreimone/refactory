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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.operators.OperatorsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface OperatorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operators";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.qualitune.org/operators";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operators";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperatorsPackage eINSTANCE = org.qualitune.evolution.operators.impl.OperatorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.OperatorImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__RESULT = 0;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__EXECUTED = 1;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.CREATEImpl <em>CREATE</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.CREATEImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getCREATE()
	 * @generated
	 */
	int CREATE = 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>New Instance Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__NEW_INSTANCE_VARIABLE = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__PARENT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Composite Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__PARENT_COMPOSITE_REFERENCE = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CREATE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.VariableImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.TypeVariableImpl <em>Type Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.TypeVariableImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getTypeVariable()
	 * @generated
	 */
	int TYPE_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__TYPE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE__VALUE = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.DELETEImpl <em>DELETE</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.DELETEImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getDELETE()
	 * @generated
	 */
	int DELETE = 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>Deletion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__DELETION = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DELETE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.ASSIGNImpl <em>ASSIGN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.ASSIGNImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getASSIGN()
	 * @generated
	 */
	int ASSIGN = 4;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__ATTRIBUTE = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__VALUE = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ASSIGN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.ResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.ResultImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getResult()
	 * @generated
	 */
	int RESULT = 6;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.EObjectReferenceImpl <em>EObject Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.EObjectReferenceImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getEObjectReference()
	 * @generated
	 */
	int EOBJECT_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_REFERENCE__ELEMENT = RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_REFERENCE_FEATURE_COUNT = RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.ReferrableImpl <em>Referrable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.ReferrableImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getReferrable()
	 * @generated
	 */
	int REFERRABLE = 7;

	/**
	 * The number of structural features of the '<em>Referrable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.PrimitiveReferenceImpl <em>Primitive Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.PrimitiveReferenceImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getPrimitiveReference()
	 * @generated
	 */
	int PRIMITIVE_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REFERENCE__VALUE = RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REFERENCE_FEATURE_COUNT = RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.SETImpl <em>SET</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.SETImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getSET()
	 * @generated
	 */
	int SET = 9;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__REFERENCE = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__VALUE = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SET</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.VariableReferenceImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Referenced Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__REFERENCED_VARIABLE = REFERRABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = REFERRABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.MOVEImpl <em>MOVE</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.MOVEImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getMOVE()
	 * @generated
	 */
	int MOVE = 11;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>New Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__NEW_PARENT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__PARENT_REFERENCE = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Movee</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__MOVEE = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>MOVE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.SPLITImpl <em>SPLIT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.SPLITImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getSPLIT()
	 * @generated
	 */
	int SPLIT = 12;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>Split Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__SPLIT_SETS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Split Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__SPLIT_OBJECT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SPLIT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.StructuralFeatureSetImpl <em>Structural Feature Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.StructuralFeatureSetImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getStructuralFeatureSet()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_SET = 13;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES = 0;

	/**
	 * The number of structural features of the '<em>Structural Feature Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.MERGEImpl <em>MERGE</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.MERGEImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getMERGE()
	 * @generated
	 */
	int MERGE = 14;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>Merge Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE__MERGE_OBJECTS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MERGE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.VARImpl <em>VAR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.VARImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getVAR()
	 * @generated
	 */
	int VAR = 15;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__RESULT = OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__EXECUTED = OPERATOR__EXECUTED;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__VARIABLE = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VAR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.qualitune.evolution.operators.impl.QueryVariableImpl <em>Query Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.qualitune.evolution.operators.impl.QueryVariableImpl
	 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getQueryVariable()
	 * @generated
	 */
	int QUERY_VARIABLE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_VARIABLE__OPERATION = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_VARIABLE__STRUCTURAL_FEATURE = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Query Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_VARIABLE__QUERY_OBJECT = VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Query Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_VARIABLE__QUERY_RESULT = VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see org.qualitune.evolution.operators.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.Operator#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.qualitune.evolution.operators.Operator#getResult()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.evolution.operators.Operator#isExecuted <em>Executed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executed</em>'.
	 * @see org.qualitune.evolution.operators.Operator#isExecuted()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Executed();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.CREATE <em>CREATE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CREATE</em>'.
	 * @see org.qualitune.evolution.operators.CREATE
	 * @generated
	 */
	EClass getCREATE();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.CREATE#getNewInstanceVariable <em>New Instance Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Instance Variable</em>'.
	 * @see org.qualitune.evolution.operators.CREATE#getNewInstanceVariable()
	 * @see #getCREATE()
	 * @generated
	 */
	EReference getCREATE_NewInstanceVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.CREATE#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent</em>'.
	 * @see org.qualitune.evolution.operators.CREATE#getParent()
	 * @see #getCREATE()
	 * @generated
	 */
	EReference getCREATE_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.CREATE#getParentCompositeReference <em>Parent Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Composite Reference</em>'.
	 * @see org.qualitune.evolution.operators.CREATE#getParentCompositeReference()
	 * @see #getCREATE()
	 * @generated
	 */
	EReference getCREATE_ParentCompositeReference();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.TypeVariable <em>Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Variable</em>'.
	 * @see org.qualitune.evolution.operators.TypeVariable
	 * @generated
	 */
	EClass getTypeVariable();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.TypeVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.qualitune.evolution.operators.TypeVariable#getType()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EReference getTypeVariable_Type();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.TypeVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.qualitune.evolution.operators.TypeVariable#getValue()
	 * @see #getTypeVariable()
	 * @generated
	 */
	EReference getTypeVariable_Value();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.DELETE <em>DELETE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DELETE</em>'.
	 * @see org.qualitune.evolution.operators.DELETE
	 * @generated
	 */
	EClass getDELETE();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.DELETE#getDeletion <em>Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deletion</em>'.
	 * @see org.qualitune.evolution.operators.DELETE#getDeletion()
	 * @see #getDELETE()
	 * @generated
	 */
	EReference getDELETE_Deletion();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.ASSIGN <em>ASSIGN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASSIGN</em>'.
	 * @see org.qualitune.evolution.operators.ASSIGN
	 * @generated
	 */
	EClass getASSIGN();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.ASSIGN#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see org.qualitune.evolution.operators.ASSIGN#getAttribute()
	 * @see #getASSIGN()
	 * @generated
	 */
	EReference getASSIGN_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.evolution.operators.ASSIGN#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.qualitune.evolution.operators.ASSIGN#getValue()
	 * @see #getASSIGN()
	 * @generated
	 */
	EAttribute getASSIGN_Value();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.EObjectReference <em>EObject Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Reference</em>'.
	 * @see org.qualitune.evolution.operators.EObjectReference
	 * @generated
	 */
	EClass getEObjectReference();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.evolution.operators.EObjectReference#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element</em>'.
	 * @see org.qualitune.evolution.operators.EObjectReference#getElement()
	 * @see #getEObjectReference()
	 * @generated
	 */
	EReference getEObjectReference_Element();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see org.qualitune.evolution.operators.Result
	 * @generated
	 */
	EClass getResult();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.Referrable <em>Referrable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referrable</em>'.
	 * @see org.qualitune.evolution.operators.Referrable
	 * @generated
	 */
	EClass getReferrable();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.PrimitiveReference <em>Primitive Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Reference</em>'.
	 * @see org.qualitune.evolution.operators.PrimitiveReference
	 * @generated
	 */
	EClass getPrimitiveReference();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.evolution.operators.PrimitiveReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.qualitune.evolution.operators.PrimitiveReference#getValue()
	 * @see #getPrimitiveReference()
	 * @generated
	 */
	EAttribute getPrimitiveReference_Value();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.SET <em>SET</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SET</em>'.
	 * @see org.qualitune.evolution.operators.SET
	 * @generated
	 */
	EClass getSET();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.SET#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.qualitune.evolution.operators.SET#getReference()
	 * @see #getSET()
	 * @generated
	 */
	EReference getSET_Reference();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.SET#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.qualitune.evolution.operators.SET#getValue()
	 * @see #getSET()
	 * @generated
	 */
	EReference getSET_Value();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.qualitune.evolution.operators.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.VariableReference#getReferencedVariable <em>Referenced Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Variable</em>'.
	 * @see org.qualitune.evolution.operators.VariableReference#getReferencedVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_ReferencedVariable();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.MOVE <em>MOVE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MOVE</em>'.
	 * @see org.qualitune.evolution.operators.MOVE
	 * @generated
	 */
	EClass getMOVE();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.MOVE#getNewParent <em>New Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Parent</em>'.
	 * @see org.qualitune.evolution.operators.MOVE#getNewParent()
	 * @see #getMOVE()
	 * @generated
	 */
	EReference getMOVE_NewParent();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.MOVE#getParentReference <em>Parent Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Reference</em>'.
	 * @see org.qualitune.evolution.operators.MOVE#getParentReference()
	 * @see #getMOVE()
	 * @generated
	 */
	EReference getMOVE_ParentReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.MOVE#getMovee <em>Movee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Movee</em>'.
	 * @see org.qualitune.evolution.operators.MOVE#getMovee()
	 * @see #getMOVE()
	 * @generated
	 */
	EReference getMOVE_Movee();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.SPLIT <em>SPLIT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPLIT</em>'.
	 * @see org.qualitune.evolution.operators.SPLIT
	 * @generated
	 */
	EClass getSPLIT();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.evolution.operators.SPLIT#getSplitSets <em>Split Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Split Sets</em>'.
	 * @see org.qualitune.evolution.operators.SPLIT#getSplitSets()
	 * @see #getSPLIT()
	 * @generated
	 */
	EReference getSPLIT_SplitSets();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.SPLIT#getSplitObject <em>Split Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Split Object</em>'.
	 * @see org.qualitune.evolution.operators.SPLIT#getSplitObject()
	 * @see #getSPLIT()
	 * @generated
	 */
	EReference getSPLIT_SplitObject();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.StructuralFeatureSet <em>Structural Feature Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature Set</em>'.
	 * @see org.qualitune.evolution.operators.StructuralFeatureSet
	 * @generated
	 */
	EClass getStructuralFeatureSet();

	/**
	 * Returns the meta object for the reference list '{@link org.qualitune.evolution.operators.StructuralFeatureSet#getStructuralFeatures <em>Structural Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Structural Features</em>'.
	 * @see org.qualitune.evolution.operators.StructuralFeatureSet#getStructuralFeatures()
	 * @see #getStructuralFeatureSet()
	 * @generated
	 */
	EReference getStructuralFeatureSet_StructuralFeatures();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.MERGE <em>MERGE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MERGE</em>'.
	 * @see org.qualitune.evolution.operators.MERGE
	 * @generated
	 */
	EClass getMERGE();

	/**
	 * Returns the meta object for the containment reference list '{@link org.qualitune.evolution.operators.MERGE#getMergeObjects <em>Merge Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Merge Objects</em>'.
	 * @see org.qualitune.evolution.operators.MERGE#getMergeObjects()
	 * @see #getMERGE()
	 * @generated
	 */
	EReference getMERGE_MergeObjects();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.VAR <em>VAR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VAR</em>'.
	 * @see org.qualitune.evolution.operators.VAR
	 * @generated
	 */
	EClass getVAR();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.VAR#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.qualitune.evolution.operators.VAR#getVariable()
	 * @see #getVAR()
	 * @generated
	 */
	EReference getVAR_Variable();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.QueryVariable <em>Query Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Variable</em>'.
	 * @see org.qualitune.evolution.operators.QueryVariable
	 * @generated
	 */
	EClass getQueryVariable();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.QueryVariable#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.qualitune.evolution.operators.QueryVariable#getOperation()
	 * @see #getQueryVariable()
	 * @generated
	 */
	EReference getQueryVariable_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.QueryVariable#getStructuralFeature <em>Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structural Feature</em>'.
	 * @see org.qualitune.evolution.operators.QueryVariable#getStructuralFeature()
	 * @see #getQueryVariable()
	 * @generated
	 */
	EReference getQueryVariable_StructuralFeature();

	/**
	 * Returns the meta object for the containment reference '{@link org.qualitune.evolution.operators.QueryVariable#getQueryObject <em>Query Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query Object</em>'.
	 * @see org.qualitune.evolution.operators.QueryVariable#getQueryObject()
	 * @see #getQueryVariable()
	 * @generated
	 */
	EReference getQueryVariable_QueryObject();

	/**
	 * Returns the meta object for the reference '{@link org.qualitune.evolution.operators.QueryVariable#getQueryResult <em>Query Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query Result</em>'.
	 * @see org.qualitune.evolution.operators.QueryVariable#getQueryResult()
	 * @see #getQueryVariable()
	 * @generated
	 */
	EReference getQueryVariable_QueryResult();

	/**
	 * Returns the meta object for class '{@link org.qualitune.evolution.operators.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.qualitune.evolution.operators.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.qualitune.evolution.operators.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.qualitune.evolution.operators.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperatorsFactory getOperatorsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.OperatorImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__RESULT = eINSTANCE.getOperator_Result();

		/**
		 * The meta object literal for the '<em><b>Executed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__EXECUTED = eINSTANCE.getOperator_Executed();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.CREATEImpl <em>CREATE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.CREATEImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getCREATE()
		 * @generated
		 */
		EClass CREATE = eINSTANCE.getCREATE();

		/**
		 * The meta object literal for the '<em><b>New Instance Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE__NEW_INSTANCE_VARIABLE = eINSTANCE.getCREATE_NewInstanceVariable();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE__PARENT = eINSTANCE.getCREATE_Parent();

		/**
		 * The meta object literal for the '<em><b>Parent Composite Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE__PARENT_COMPOSITE_REFERENCE = eINSTANCE.getCREATE_ParentCompositeReference();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.TypeVariableImpl <em>Type Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.TypeVariableImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getTypeVariable()
		 * @generated
		 */
		EClass TYPE_VARIABLE = eINSTANCE.getTypeVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE__TYPE = eINSTANCE.getTypeVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_VARIABLE__VALUE = eINSTANCE.getTypeVariable_Value();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.DELETEImpl <em>DELETE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.DELETEImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getDELETE()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDELETE();

		/**
		 * The meta object literal for the '<em><b>Deletion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE__DELETION = eINSTANCE.getDELETE_Deletion();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.ASSIGNImpl <em>ASSIGN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.ASSIGNImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getASSIGN()
		 * @generated
		 */
		EClass ASSIGN = eINSTANCE.getASSIGN();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__ATTRIBUTE = eINSTANCE.getASSIGN_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN__VALUE = eINSTANCE.getASSIGN_Value();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.EObjectReferenceImpl <em>EObject Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.EObjectReferenceImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getEObjectReference()
		 * @generated
		 */
		EClass EOBJECT_REFERENCE = eINSTANCE.getEObjectReference();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_REFERENCE__ELEMENT = eINSTANCE.getEObjectReference_Element();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.ResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.ResultImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getResult()
		 * @generated
		 */
		EClass RESULT = eINSTANCE.getResult();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.ReferrableImpl <em>Referrable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.ReferrableImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getReferrable()
		 * @generated
		 */
		EClass REFERRABLE = eINSTANCE.getReferrable();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.PrimitiveReferenceImpl <em>Primitive Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.PrimitiveReferenceImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getPrimitiveReference()
		 * @generated
		 */
		EClass PRIMITIVE_REFERENCE = eINSTANCE.getPrimitiveReference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_REFERENCE__VALUE = eINSTANCE.getPrimitiveReference_Value();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.SETImpl <em>SET</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.SETImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getSET()
		 * @generated
		 */
		EClass SET = eINSTANCE.getSET();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET__REFERENCE = eINSTANCE.getSET_Reference();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET__VALUE = eINSTANCE.getSET_Value();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.VariableReferenceImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Referenced Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__REFERENCED_VARIABLE = eINSTANCE.getVariableReference_ReferencedVariable();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.MOVEImpl <em>MOVE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.MOVEImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getMOVE()
		 * @generated
		 */
		EClass MOVE = eINSTANCE.getMOVE();

		/**
		 * The meta object literal for the '<em><b>New Parent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVE__NEW_PARENT = eINSTANCE.getMOVE_NewParent();

		/**
		 * The meta object literal for the '<em><b>Parent Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVE__PARENT_REFERENCE = eINSTANCE.getMOVE_ParentReference();

		/**
		 * The meta object literal for the '<em><b>Movee</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVE__MOVEE = eINSTANCE.getMOVE_Movee();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.SPLITImpl <em>SPLIT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.SPLITImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getSPLIT()
		 * @generated
		 */
		EClass SPLIT = eINSTANCE.getSPLIT();

		/**
		 * The meta object literal for the '<em><b>Split Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT__SPLIT_SETS = eINSTANCE.getSPLIT_SplitSets();

		/**
		 * The meta object literal for the '<em><b>Split Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT__SPLIT_OBJECT = eINSTANCE.getSPLIT_SplitObject();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.StructuralFeatureSetImpl <em>Structural Feature Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.StructuralFeatureSetImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getStructuralFeatureSet()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_SET = eINSTANCE.getStructuralFeatureSet();

		/**
		 * The meta object literal for the '<em><b>Structural Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_SET__STRUCTURAL_FEATURES = eINSTANCE.getStructuralFeatureSet_StructuralFeatures();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.MERGEImpl <em>MERGE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.MERGEImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getMERGE()
		 * @generated
		 */
		EClass MERGE = eINSTANCE.getMERGE();

		/**
		 * The meta object literal for the '<em><b>Merge Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE__MERGE_OBJECTS = eINSTANCE.getMERGE_MergeObjects();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.VARImpl <em>VAR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.VARImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getVAR()
		 * @generated
		 */
		EClass VAR = eINSTANCE.getVAR();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR__VARIABLE = eINSTANCE.getVAR_Variable();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.QueryVariableImpl <em>Query Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.QueryVariableImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getQueryVariable()
		 * @generated
		 */
		EClass QUERY_VARIABLE = eINSTANCE.getQueryVariable();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_VARIABLE__OPERATION = eINSTANCE.getQueryVariable_Operation();

		/**
		 * The meta object literal for the '<em><b>Structural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_VARIABLE__STRUCTURAL_FEATURE = eINSTANCE.getQueryVariable_StructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Query Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_VARIABLE__QUERY_OBJECT = eINSTANCE.getQueryVariable_QueryObject();

		/**
		 * The meta object literal for the '<em><b>Query Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_VARIABLE__QUERY_RESULT = eINSTANCE.getQueryVariable_QueryResult();

		/**
		 * The meta object literal for the '{@link org.qualitune.evolution.operators.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.qualitune.evolution.operators.impl.VariableImpl
		 * @see org.qualitune.evolution.operators.impl.OperatorsPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

	}

} //OperatorsPackage
