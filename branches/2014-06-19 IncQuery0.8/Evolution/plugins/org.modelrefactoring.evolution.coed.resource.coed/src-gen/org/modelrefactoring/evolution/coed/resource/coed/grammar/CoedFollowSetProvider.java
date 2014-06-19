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
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement TERMINALS[] = new org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement[20];
	
	public final static EStructuralFeature[] FEATURES = new EStructuralFeature[4];
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] LINKS = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[5];
	
	public final static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] EMPTY_LINK_ARRAY = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_0);
		TERMINALS[1] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_2);
		TERMINALS[2] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_4);
		TERMINALS[3] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_6_0_0_0);
		TERMINALS[4] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_8);
		TERMINALS[5] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_0);
		TERMINALS[6] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_10);
		TERMINALS[7] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_0);
		TERMINALS[8] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_2_0_0_0);
		TERMINALS[9] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_16);
		TERMINALS[10] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_4_0_0_0);
		TERMINALS[11] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_0_0_0_20);
		TERMINALS[12] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_2);
		TERMINALS[13] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_1_0_0_4);
		TERMINALS[14] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_2_0_0_1);
		TERMINALS[15] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_2);
		TERMINALS[16] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_4);
		TERMINALS[17] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_3_0_0_6);
		TERMINALS[18] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_4_0_0_2);
		TERMINALS[19] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedExpectedStructuralFeature(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.COED_4_0_0_3_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS);
		FEATURES[1] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__EVENT);
		FEATURES[2] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__ACTION);
		FEATURES[3] = org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getMetamodelImport(), FEATURES[0]);
		LINKS[1] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent(), FEATURES[1]);
		LINKS[2] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), FEATURES[3]);
		LINKS[3] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction(), FEATURES[2]);
		LINKS[4] = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), FEATURES[3]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[5], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getMetamodelImport(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent(), FEATURES[1]), });
		TERMINALS[9].addFollower(TERMINALS[10], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction(), FEATURES[2]), });
		TERMINALS[5].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[8], new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] {new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(), FEATURES[3]), });
		TERMINALS[17].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
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
