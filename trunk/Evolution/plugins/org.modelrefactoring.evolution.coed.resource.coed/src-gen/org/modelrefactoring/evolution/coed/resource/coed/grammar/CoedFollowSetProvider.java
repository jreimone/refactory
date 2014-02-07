/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class CoedFollowSetProvider {
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement TERMINALS[] = new org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement[14];
	
	public final static EStructuralFeature[] FEATURES = new EStructuralFeature[3];
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] LINKS = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[4];
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] EMPTY_LINK_ARRAY = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_0);
		TERMINALS[1] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_2);
		TERMINALS[2] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_4);
		TERMINALS[3] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_6);
		TERMINALS[4] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_8);
		TERMINALS[5] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_2_0_0_0);
		TERMINALS[6] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_0);
		TERMINALS[7] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_14);
		TERMINALS[8] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_0);
		TERMINALS[9] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_18);
		TERMINALS[10] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_1);
		TERMINALS[11] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_2_0_0_2);
		TERMINALS[12] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_2);
		TERMINALS[13] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_3_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__EVENT);
		FEATURES[1] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__ACTION);
		FEATURES[2] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent(), FEATURES[0]);
		LINKS[1] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), FEATURES[2]);
		LINKS[2] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction(), FEATURES[1]);
		LINKS[3] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), FEATURES[2]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent(), FEATURES[0]), });
		TERMINALS[7].addFollower(TERMINALS[8], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction(), FEATURES[1]), });
		TERMINALS[6].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[6], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
