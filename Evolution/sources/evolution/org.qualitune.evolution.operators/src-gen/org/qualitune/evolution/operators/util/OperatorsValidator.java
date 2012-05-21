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

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.qualitune.evolution.operators.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.evolution.operators.OperatorsPackage
 * @generated
 */
public class OperatorsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final OperatorsValidator INSTANCE = new OperatorsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.qualitune.evolution.operators";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return OperatorsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case OperatorsPackage.OPERATOR:
				return validateOperator((Operator)value, diagnostics, context);
			case OperatorsPackage.CREATE:
				return validateCREATE((CREATE)value, diagnostics, context);
			case OperatorsPackage.TYPE_VARIABLE:
				return validateTypeVariable((TypeVariable)value, diagnostics, context);
			case OperatorsPackage.DELETE:
				return validateDELETE((DELETE)value, diagnostics, context);
			case OperatorsPackage.ASSIGN:
				return validateASSIGN((ASSIGN)value, diagnostics, context);
			case OperatorsPackage.EOBJECT_REFERENCE:
				return validateEObjectReference((EObjectReference)value, diagnostics, context);
			case OperatorsPackage.RESULT:
				return validateResult((Result)value, diagnostics, context);
			case OperatorsPackage.REFERRABLE:
				return validateReferrable((Referrable)value, diagnostics, context);
			case OperatorsPackage.PRIMITIVE_REFERENCE:
				return validatePrimitiveReference((PrimitiveReference)value, diagnostics, context);
			case OperatorsPackage.SET:
				return validateSET((SET)value, diagnostics, context);
			case OperatorsPackage.VARIABLE_REFERENCE:
				return validateVariableReference((VariableReference)value, diagnostics, context);
			case OperatorsPackage.MOVE:
				return validateMOVE((MOVE)value, diagnostics, context);
			case OperatorsPackage.SPLIT:
				return validateSPLIT((SPLIT)value, diagnostics, context);
			case OperatorsPackage.STRUCTURAL_FEATURE_SET:
				return validateStructuralFeatureSet((StructuralFeatureSet)value, diagnostics, context);
			case OperatorsPackage.MERGE:
				return validateMERGE((MERGE)value, diagnostics, context);
			case OperatorsPackage.VAR:
				return validateVAR((VAR)value, diagnostics, context);
			case OperatorsPackage.QUERY_VARIABLE:
				return validateQueryVariable((QueryVariable)value, diagnostics, context);
			case OperatorsPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperator(Operator operator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operator, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCREATE(CREATE create, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(create, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(create, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(create, diagnostics, context);
		if (result || diagnostics != null) result &= validateCREATE_containmentReference(create, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the containmentReference constraint of '<em>CREATE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CREATE__CONTAINMENT_REFERENCE__EEXPRESSION = "self.parentCompositeReference.containment = true";

	/**
	 * Validates the containmentReference constraint of '<em>CREATE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCREATE_containmentReference(CREATE create, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(OperatorsPackage.Literals.CREATE,
				 create,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "containmentReference",
				 CREATE__CONTAINMENT_REFERENCE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeVariable(TypeVariable typeVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypeVariable_typeMustBeConcrete(typeVariable, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the typeMustBeConcrete constraint of '<em>Type Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TYPE_VARIABLE__TYPE_MUST_BE_CONCRETE__EEXPRESSION = "not(self.type.abstract = true)";

	/**
	 * Validates the typeMustBeConcrete constraint of '<em>Type Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeVariable_typeMustBeConcrete(TypeVariable typeVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(OperatorsPackage.Literals.TYPE_VARIABLE,
				 typeVariable,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "typeMustBeConcrete",
				 TYPE_VARIABLE__TYPE_MUST_BE_CONCRETE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDELETE(DELETE delete, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(delete, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateASSIGN(ASSIGN assign, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assign, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEObjectReference(EObjectReference eObjectReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eObjectReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResult(Result result, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(result, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferrable(Referrable referrable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referrable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveReference(PrimitiveReference primitiveReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSET(SET set, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(set, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableReference(VariableReference variableReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMOVE(MOVE move, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(move, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSPLIT(SPLIT split, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(split, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureSet(StructuralFeatureSet structuralFeatureSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structuralFeatureSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMERGE(MERGE merge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(merge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVAR(VAR var, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(var, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQueryVariable(QueryVariable queryVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(queryVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(queryVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateQueryVariable_operationFeatureXOR(queryVariable, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the operationFeatureXOR constraint of '<em>Query Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String QUERY_VARIABLE__OPERATION_FEATURE_XOR__EEXPRESSION = "self.operation = null xor self.structuralFeature = null";

	/**
	 * Validates the operationFeatureXOR constraint of '<em>Query Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQueryVariable_operationFeatureXOR(QueryVariable queryVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(OperatorsPackage.Literals.QUERY_VARIABLE,
				 queryVariable,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "operationFeatureXOR",
				 QUERY_VARIABLE__OPERATION_FEATURE_XOR__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variable, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //OperatorsValidator
