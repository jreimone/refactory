/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class CoedGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static CoedGrammarInformationProvider INSTANCE = new CoedGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_0_0_0_0 = INSTANCE.getCOED_0_0_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_0_0_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("CoED", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_0_0_0_1 = INSTANCE.getCOED_0_0_0_1();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_0_0_0_1() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_0_0_0_2 = INSTANCE.getCOED_0_0_0_2();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_0_0_0_2() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("for", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_0_0_0_3 = INSTANCE.getCOED_0_0_0_3();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_0_0_0_3() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder COED_0_0_0_4 = INSTANCE.getCOED_0_0_0_4();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder getCOED_0_0_0_4() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL), "QUOTED_60_62", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_0_0_0_5 = INSTANCE.getCOED_0_0_0_5();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_0_0_0_5() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_0_0_0_6 = INSTANCE.getCOED_0_0_0_6();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_0_0_0_6() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("{", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak COED_0_0_0_7 = INSTANCE.getCOED_0_0_0_7();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak getCOED_0_0_0_7() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_0_0_0_8 = INSTANCE.getCOED_0_0_0_8();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_0_0_0_8() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("incoming", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_0_0_0_9 = INSTANCE.getCOED_0_0_0_9();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_0_0_0_9() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment COED_0_0_0_10 = INSTANCE.getCOED_0_0_0_10();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment getCOED_0_0_0_10() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__EVENT), org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getEvent(), }, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak COED_0_0_0_11 = INSTANCE.getCOED_0_0_0_11();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak getCOED_0_0_0_11() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment COED_0_0_0_12 = INSTANCE.getCOED_0_0_0_12();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment getCOED_0_0_0_12() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION), org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.QUESTIONMARK, new EClass[] {org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCondition(), }, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak COED_0_0_0_13 = INSTANCE.getCOED_0_0_0_13();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak getCOED_0_0_0_13() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_0_0_0_14 = INSTANCE.getCOED_0_0_0_14();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_0_0_0_14() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("outgoing", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_0_0_0_15 = INSTANCE.getCOED_0_0_0_15();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_0_0_0_15() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment COED_0_0_0_16 = INSTANCE.getCOED_0_0_0_16();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment getCOED_0_0_0_16() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedContainment(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__ACTION), org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, new EClass[] {org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getAction(), }, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak COED_0_0_0_17 = INSTANCE.getCOED_0_0_0_17();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak getCOED_0_0_0_17() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedLineBreak(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_0_0_0_18 = INSTANCE.getCOED_0_0_0_18();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_0_0_0_18() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("}", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence COED_0_0_0 = INSTANCE.getCOED_0_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence getCOED_0_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_0_0_0_0, COED_0_0_0_1, COED_0_0_0_2, COED_0_0_0_3, COED_0_0_0_4, COED_0_0_0_5, COED_0_0_0_6, COED_0_0_0_7, COED_0_0_0_8, COED_0_0_0_9, COED_0_0_0_10, COED_0_0_0_11, COED_0_0_0_12, COED_0_0_0_13, COED_0_0_0_14, COED_0_0_0_15, COED_0_0_0_16, COED_0_0_0_17, COED_0_0_0_18);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice COED_0_0 = INSTANCE.getCOED_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice getCOED_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_0_0_0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule COED_0 = INSTANCE.getCOED_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule getCOED_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(), COED_0_0, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_1_0_0_0 = INSTANCE.getCOED_1_0_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_1_0_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("condition", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder COED_1_0_0_1 = INSTANCE.getCOED_1_0_0_1();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder getCOED_1_0_0_1() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CONDITION), "QUOTED_123_125", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence COED_1_0_0 = INSTANCE.getCOED_1_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence getCOED_1_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_1_0_0_0, COED_1_0_0_1);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice COED_1_0 = INSTANCE.getCOED_1_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice getCOED_1_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_1_0_0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule COED_1 = INSTANCE.getCOED_1();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule getCOED_1() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), COED_1_0, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_2_0_0_0 = INSTANCE.getCOED_2_0_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_2_0_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("refactoring", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_2_0_0_1 = INSTANCE.getCOED_2_0_0_1();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_2_0_0_1() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder COED_2_0_0_2 = INSTANCE.getCOED_2_0_0_2();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder getCOED_2_0_0_2() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING), "QUOTED_60_62", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence COED_2_0_0 = INSTANCE.getCOED_2_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence getCOED_2_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_2_0_0_0, COED_2_0_0_1, COED_2_0_0_2);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice COED_2_0 = INSTANCE.getCOED_2_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice getCOED_2_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_2_0_0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule COED_2 = INSTANCE.getCOED_2();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule getCOED_2() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent(), COED_2_0, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword COED_3_0_0_0 = INSTANCE.getCOED_3_0_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword getCOED_3_0_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword("corefactoring", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_3_0_0_1 = INSTANCE.getCOED_3_0_0_1();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_3_0_0_1() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder COED_3_0_0_2 = INSTANCE.getCOED_3_0_0_2();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder getCOED_3_0_0_2() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING), "QUOTED_60_62", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace COED_3_0_0_3_0_0_0 = INSTANCE.getCOED_3_0_0_3_0_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace getCOED_3_0_0_3_0_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedWhiteSpace(1, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder COED_3_0_0_3_0_0_1 = INSTANCE.getCOED_3_0_0_3_0_0_1();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder getCOED_3_0_0_3_0_0_1() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedPlaceholder(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__BINDING), "QUOTED_123_125", org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence COED_3_0_0_3_0_0 = INSTANCE.getCOED_3_0_0_3_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence getCOED_3_0_0_3_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_3_0_0_3_0_0_0, COED_3_0_0_3_0_0_1);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice COED_3_0_0_3_0 = INSTANCE.getCOED_3_0_0_3_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice getCOED_3_0_0_3_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_3_0_0_3_0_0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCompound COED_3_0_0_3 = INSTANCE.getCOED_3_0_0_3();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCompound getCOED_3_0_0_3() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCompound(COED_3_0_0_3_0, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.QUESTIONMARK);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence COED_3_0_0 = INSTANCE.getCOED_3_0_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence getCOED_3_0_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSequence(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_3_0_0_0, COED_3_0_0_1, COED_3_0_0_2, COED_3_0_0_3);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice COED_3_0 = INSTANCE.getCOED_3_0();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice getCOED_3_0() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE, COED_3_0_0);
	}
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule COED_3 = INSTANCE.getCOED_3();
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule getCOED_3() {
		return new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction(), COED_3_0, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality.ONE);
	}
	
	public static String getSyntaxElementID(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.class.getFields()) {
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
	
	public static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement) org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule[] RULES = new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule[] {
		COED_0,
		COED_1,
		COED_2,
		COED_3,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement element, Set<String> keywords) {
		if (element instanceof org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword) {
			keywords.add(((org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword) element).getValue());
		} else if (element instanceof org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedBooleanTerminal) {
			keywords.add(((org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedEnumerationTerminal) {
			org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedEnumerationTerminal terminal = (org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
