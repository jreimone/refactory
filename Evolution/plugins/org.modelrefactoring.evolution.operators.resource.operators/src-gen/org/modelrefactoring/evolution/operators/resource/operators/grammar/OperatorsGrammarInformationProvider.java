/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class OperatorsGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static OperatorsGrammarInformationProvider INSTANCE = new OperatorsGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_0_0_0_0 = INSTANCE.getOPERATORS_0_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_0_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), "QUOTED_60_62", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_0_0_0_1_0_0_0 = INSTANCE.getOPERATORS_0_0_0_1_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_0_0_0_1_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword(",", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_0_0_0_1_0_0_1 = INSTANCE.getOPERATORS_0_0_0_1_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_0_0_0_1_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_0_0_0_1_0_0_2 = INSTANCE.getOPERATORS_0_0_0_1_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_0_0_0_1_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), "QUOTED_60_62", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_0_0_0_1_0_0 = INSTANCE.getOPERATORS_0_0_0_1_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_0_0_0_1_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_0_0_0_1_0_0_0, OPERATORS_0_0_0_1_0_0_1, OPERATORS_0_0_0_1_0_0_2);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_0_0_0_1_0 = INSTANCE.getOPERATORS_0_0_0_1_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_0_0_0_1_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_0_0_0_1_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCompound OPERATORS_0_0_0_1 = INSTANCE.getOPERATORS_0_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCompound getOPERATORS_0_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCompound(OPERATORS_0_0_0_1_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.STAR);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_0_0_0 = INSTANCE.getOPERATORS_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_0_0_0_0, OPERATORS_0_0_0_1);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_0_0 = INSTANCE.getOPERATORS_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_0_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_0 = INSTANCE.getOPERATORS_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference(), OPERATORS_0_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_1_0_0_0 = INSTANCE.getOPERATORS_1_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_1_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVariableReference().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_1_0_0 = INSTANCE.getOPERATORS_1_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_1_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_1_0_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_1_0 = INSTANCE.getOPERATORS_1_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_1_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_1_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_1 = INSTANCE.getOPERATORS_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVariableReference(), OPERATORS_1_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_2_0_0_0 = INSTANCE.getOPERATORS_2_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_2_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("var", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_2_0_0_1 = INSTANCE.getOPERATORS_2_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_2_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_2_0_0_2 = INSTANCE.getOPERATORS_2_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_2_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VAR__VARIABLE), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_2_0_0 = INSTANCE.getOPERATORS_2_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_2_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_2_0_0_0, OPERATORS_2_0_0_1, OPERATORS_2_0_0_2);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_2_0 = INSTANCE.getOPERATORS_2_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_2_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_2_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_2 = INSTANCE.getOPERATORS_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR(), OPERATORS_2_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_3_0_0_0 = INSTANCE.getOPERATORS_3_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_3_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__NAME), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_3_0_0_1 = INSTANCE.getOPERATORS_3_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_3_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_3_0_0_2 = INSTANCE.getOPERATORS_3_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_3_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("=", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_3_0_0_3 = INSTANCE.getOPERATORS_3_0_0_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_3_0_0_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_3_0_0_4 = INSTANCE.getOPERATORS_3_0_0_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_3_0_0_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_3_0_0_5 = INSTANCE.getOPERATORS_3_0_0_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_3_0_0_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_3_0_0_6 = INSTANCE.getOPERATORS_3_0_0_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_3_0_0_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword(".", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_3_0_0_7 = INSTANCE.getOPERATORS_3_0_0_7();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_3_0_0_7() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_3_0_0_8 = INSTANCE.getOPERATORS_3_0_0_8();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_3_0_0_8() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUALIFIER), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariableQualifier(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_3_0_0 = INSTANCE.getOPERATORS_3_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_3_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_3_0_0_0, OPERATORS_3_0_0_1, OPERATORS_3_0_0_2, OPERATORS_3_0_0_3, OPERATORS_3_0_0_4, OPERATORS_3_0_0_5, OPERATORS_3_0_0_6, OPERATORS_3_0_0_7, OPERATORS_3_0_0_8);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_3_0 = INSTANCE.getOPERATORS_3_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_3_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_3_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_3 = INSTANCE.getOPERATORS_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(), OPERATORS_3_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_4_0_0_0 = INSTANCE.getOPERATORS_4_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_4_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEReferenceQualifier().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EREFERENCE_QUALIFIER__REFERENCE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_4_0_0 = INSTANCE.getOPERATORS_4_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_4_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_4_0_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_4_0 = INSTANCE.getOPERATORS_4_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_4_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_4_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_4 = INSTANCE.getOPERATORS_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEReferenceQualifier(), OPERATORS_4_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_5_0_0_0 = INSTANCE.getOPERATORS_5_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_5_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEOperationQualifier().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_5_0_0 = INSTANCE.getOPERATORS_5_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_5_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_5_0_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_5_0 = INSTANCE.getOPERATORS_5_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_5_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_5_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_5 = INSTANCE.getOPERATORS_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEOperationQualifier(), OPERATORS_5_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_6_0_0_0 = INSTANCE.getOPERATORS_6_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_6_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("create", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_6_0_0_1 = INSTANCE.getOPERATORS_6_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_6_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_6_0_0_2 = INSTANCE.getOPERATORS_6_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_6_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_6_0_0_3 = INSTANCE.getOPERATORS_6_0_0_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_6_0_0_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("in", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_6_0_0_4 = INSTANCE.getOPERATORS_6_0_0_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_6_0_0_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_6_0_0_5 = INSTANCE.getOPERATORS_6_0_0_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_6_0_0_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_6_0_0_6 = INSTANCE.getOPERATORS_6_0_0_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_6_0_0_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_6_0_0_7 = INSTANCE.getOPERATORS_6_0_0_7();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_6_0_0_7() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword(".", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_6_0_0_8 = INSTANCE.getOPERATORS_6_0_0_8();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_6_0_0_8() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_6_0_0_9 = INSTANCE.getOPERATORS_6_0_0_9();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_6_0_0_9() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_6_0_0 = INSTANCE.getOPERATORS_6_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_6_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_6_0_0_0, OPERATORS_6_0_0_1, OPERATORS_6_0_0_2, OPERATORS_6_0_0_3, OPERATORS_6_0_0_4, OPERATORS_6_0_0_5, OPERATORS_6_0_0_6, OPERATORS_6_0_0_7, OPERATORS_6_0_0_8, OPERATORS_6_0_0_9);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_6_0 = INSTANCE.getOPERATORS_6_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_6_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_6_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_6 = INSTANCE.getOPERATORS_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(), OPERATORS_6_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_7_0_0_0 = INSTANCE.getOPERATORS_7_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_7_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__NAME), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_7_0_0_1 = INSTANCE.getOPERATORS_7_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_7_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_7_0_0_2 = INSTANCE.getOPERATORS_7_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_7_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("=", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_7_0_0_3 = INSTANCE.getOPERATORS_7_0_0_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_7_0_0_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_7_0_0_4 = INSTANCE.getOPERATORS_7_0_0_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_7_0_0_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("new", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_7_0_0_5 = INSTANCE.getOPERATORS_7_0_0_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_7_0_0_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_7_0_0_6 = INSTANCE.getOPERATORS_7_0_0_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_7_0_0_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_7_0_0 = INSTANCE.getOPERATORS_7_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_7_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_7_0_0_0, OPERATORS_7_0_0_1, OPERATORS_7_0_0_2, OPERATORS_7_0_0_3, OPERATORS_7_0_0_4, OPERATORS_7_0_0_5, OPERATORS_7_0_0_6);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_7_0 = INSTANCE.getOPERATORS_7_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_7_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_7_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_7 = INSTANCE.getOPERATORS_7();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_7() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable(), OPERATORS_7_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_8_0_0_0 = INSTANCE.getOPERATORS_8_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_8_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("delete", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_8_0_0_1 = INSTANCE.getOPERATORS_8_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_8_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_8_0_0_2 = INSTANCE.getOPERATORS_8_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_8_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.DELETE__DELETION), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_8_0_0 = INSTANCE.getOPERATORS_8_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_8_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_8_0_0_0, OPERATORS_8_0_0_1, OPERATORS_8_0_0_2);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_8_0 = INSTANCE.getOPERATORS_8_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_8_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_8_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_8 = INSTANCE.getOPERATORS_8();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_8() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(), OPERATORS_8_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_9_0_0_0 = INSTANCE.getOPERATORS_9_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_9_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_9_0_0_1 = INSTANCE.getOPERATORS_9_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_9_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_9_0_0_2 = INSTANCE.getOPERATORS_9_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_9_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword(".", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_9_0_0_3 = INSTANCE.getOPERATORS_9_0_0_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_9_0_0_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_9_0_0_4 = INSTANCE.getOPERATORS_9_0_0_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_9_0_0_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_9_0_0_5 = INSTANCE.getOPERATORS_9_0_0_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_9_0_0_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_9_0_0_6 = INSTANCE.getOPERATORS_9_0_0_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_9_0_0_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("=", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_9_0_0_7 = INSTANCE.getOPERATORS_9_0_0_7();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_9_0_0_7() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_9_0_0_8 = INSTANCE.getOPERATORS_9_0_0_8();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_9_0_0_8() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__VALUE), "QUOTED_34_34", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_9_0_0 = INSTANCE.getOPERATORS_9_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_9_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_9_0_0_0, OPERATORS_9_0_0_1, OPERATORS_9_0_0_2, OPERATORS_9_0_0_3, OPERATORS_9_0_0_4, OPERATORS_9_0_0_5, OPERATORS_9_0_0_6, OPERATORS_9_0_0_7, OPERATORS_9_0_0_8);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_9_0 = INSTANCE.getOPERATORS_9_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_9_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_9_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_9 = INSTANCE.getOPERATORS_9();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_9() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN(), OPERATORS_9_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_10_0_0_0 = INSTANCE.getOPERATORS_10_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_10_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE_OWNER), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_10_0_0_1 = INSTANCE.getOPERATORS_10_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_10_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_10_0_0_2 = INSTANCE.getOPERATORS_10_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_10_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword(".", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_10_0_0_3 = INSTANCE.getOPERATORS_10_0_0_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_10_0_0_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_10_0_0_4 = INSTANCE.getOPERATORS_10_0_0_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_10_0_0_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_10_0_0_5 = INSTANCE.getOPERATORS_10_0_0_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_10_0_0_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_10_0_0_6 = INSTANCE.getOPERATORS_10_0_0_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_10_0_0_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("=", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_10_0_0_7 = INSTANCE.getOPERATORS_10_0_0_7();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_10_0_0_7() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_10_0_0_8 = INSTANCE.getOPERATORS_10_0_0_8();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_10_0_0_8() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__VALUE), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_10_0_0 = INSTANCE.getOPERATORS_10_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_10_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_10_0_0_0, OPERATORS_10_0_0_1, OPERATORS_10_0_0_2, OPERATORS_10_0_0_3, OPERATORS_10_0_0_4, OPERATORS_10_0_0_5, OPERATORS_10_0_0_6, OPERATORS_10_0_0_7, OPERATORS_10_0_0_8);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_10_0 = INSTANCE.getOPERATORS_10_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_10_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_10_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_10 = INSTANCE.getOPERATORS_10();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_10() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(), OPERATORS_10_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_11_0_0_0 = INSTANCE.getOPERATORS_11_0_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_11_0_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("move", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_11_0_0_1 = INSTANCE.getOPERATORS_11_0_0_1();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_11_0_0_1() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_11_0_0_2 = INSTANCE.getOPERATORS_11_0_0_2();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_11_0_0_2() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__MOVEE), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_11_0_0_3 = INSTANCE.getOPERATORS_11_0_0_3();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_11_0_0_3() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_11_0_0_4 = INSTANCE.getOPERATORS_11_0_0_4();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_11_0_0_4() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword("to", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_11_0_0_5 = INSTANCE.getOPERATORS_11_0_0_5();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_11_0_0_5() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(1, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment OPERATORS_11_0_0_6 = INSTANCE.getOPERATORS_11_0_0_6();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment getOPERATORS_11_0_0_6() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsContainment(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__NEW_PARENT), org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getReferrable(), }, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_11_0_0_7 = INSTANCE.getOPERATORS_11_0_0_7();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_11_0_0_7() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword OPERATORS_11_0_0_8 = INSTANCE.getOPERATORS_11_0_0_8();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword getOPERATORS_11_0_0_8() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword(".", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace OPERATORS_11_0_0_9 = INSTANCE.getOPERATORS_11_0_0_9();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace getOPERATORS_11_0_0_9() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsWhiteSpace(0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder OPERATORS_11_0_0_10 = INSTANCE.getOPERATORS_11_0_0_10();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder getOPERATORS_11_0_0_10() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE), "IDENTIFIER", org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence OPERATORS_11_0_0 = INSTANCE.getOPERATORS_11_0_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence getOPERATORS_11_0_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_11_0_0_0, OPERATORS_11_0_0_1, OPERATORS_11_0_0_2, OPERATORS_11_0_0_3, OPERATORS_11_0_0_4, OPERATORS_11_0_0_5, OPERATORS_11_0_0_6, OPERATORS_11_0_0_7, OPERATORS_11_0_0_8, OPERATORS_11_0_0_9, OPERATORS_11_0_0_10);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice OPERATORS_11_0 = INSTANCE.getOPERATORS_11_0();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getOPERATORS_11_0() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE, OPERATORS_11_0_0);
	}
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule OPERATORS_11 = INSTANCE.getOPERATORS_11();
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule getOPERATORS_11() {
		return new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(), OPERATORS_11_0, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality.ONE);
	}
	
	public static String getSyntaxElementID(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement) org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule[] RULES = new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule[] {
		OPERATORS_0,
		OPERATORS_1,
		OPERATORS_2,
		OPERATORS_3,
		OPERATORS_4,
		OPERATORS_5,
		OPERATORS_6,
		OPERATORS_7,
		OPERATORS_8,
		OPERATORS_9,
		OPERATORS_10,
		OPERATORS_11,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement element, Set<String> keywords) {
		if (element instanceof org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword) {
			keywords.add(((org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword) element).getValue());
		} else if (element instanceof org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsBooleanTerminal) {
			keywords.add(((org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsEnumerationTerminal) {
			org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsEnumerationTerminal terminal = (org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
