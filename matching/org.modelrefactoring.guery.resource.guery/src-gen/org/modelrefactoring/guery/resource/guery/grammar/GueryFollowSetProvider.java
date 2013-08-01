/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class GueryFollowSetProvider {
	
	public final static org.modelrefactoring.guery.resource.guery.IGueryExpectedElement TERMINALS[] = new org.modelrefactoring.guery.resource.guery.IGueryExpectedElement[32];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[8];
	
	public final static org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] LINKS = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[148];
	
	public final static org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] EMPTY_LINK_ARRAY = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_0);
		TERMINALS[1] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_1_0_0_1);
		TERMINALS[2] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_1);
		TERMINALS[3] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_1);
		TERMINALS[4] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_1);
		TERMINALS[5] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_1);
		TERMINALS[6] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_1);
		TERMINALS[7] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_2_0_0_2);
		TERMINALS[8] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_4_0_0_0);
		TERMINALS[9] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_3_0_0_0);
		TERMINALS[10] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_1);
		TERMINALS[11] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_5_0_0_0);
		TERMINALS[12] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_3_0_0_4_0_0_4_0_0_1);
		TERMINALS[13] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_4_0_0_1);
		TERMINALS[14] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_4_0_0_1);
		TERMINALS[15] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_9_0_0_4_0_0_1);
		TERMINALS[16] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_0);
		TERMINALS[17] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_4_0_0_1);
		TERMINALS[18] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_6_0_0_5_0_0_1);
		TERMINALS[19] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_4_0_0_1);
		TERMINALS[20] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_7_0_0_5_0_0_1);
		TERMINALS[21] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_1);
		TERMINALS[22] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_2);
		TERMINALS[23] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_3);
		TERMINALS[24] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_4);
		TERMINALS[25] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_5);
		TERMINALS[26] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_0);
		TERMINALS[27] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedBooleanTerminal(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_8);
		TERMINALS[28] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_1);
		TERMINALS[29] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_2);
		TERMINALS[30] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedStructuralFeature(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_3);
		TERMINALS[31] = new org.modelrefactoring.guery.resource.guery.mopp.GueryExpectedCsString(org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.GUERY_8_0_0_6_0_0_4);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__PREPARE);
		FEATURES[1] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__VERTEX_SELECTION);
		FEATURES[2] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES);
		FEATURES[3] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstrainable().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINABLE__CONSTRAINTS);
		FEATURES[4] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__EDGE_SELECTIONS);
		FEATURES[5] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__GROUP_BY);
		FEATURES[6] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS);
		FEATURES[7] = org.modelrefactoring.guery.GueryPackage.eINSTANCE.getEdgeSelection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.EDGE_SELECTION__CONNECTIONS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[1] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[2] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[3] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[4] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), FEATURES[0]);
		LINKS[5] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), FEATURES[1]);
		LINKS[6] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), FEATURES[0]);
		LINKS[7] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), FEATURES[1]);
		LINKS[8] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[9] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[10] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[11] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[12] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[13] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[14] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[15] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[16] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[17] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[18] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), FEATURES[0]);
		LINKS[19] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), FEATURES[1]);
		LINKS[20] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), FEATURES[2]);
		LINKS[21] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[22] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[23] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[24] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[25] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), FEATURES[2]);
		LINKS[26] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[27] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[28] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[29] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[30] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[31] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[32] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[33] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[34] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[35] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[36] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[37] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[38] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[39] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[40] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[41] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[42] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[43] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[44] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[45] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[46] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[47] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[48] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[49] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[50] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[51] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[52] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[53] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[54] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[55] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[56] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[57] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[58] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[59] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[60] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]);
		LINKS[61] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[62] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[63] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[64] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[65] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]);
		LINKS[66] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[67] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[68] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[69] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[70] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[71] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[72] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[73] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[74] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[75] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[76] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[77] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[78] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[79] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[80] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[81] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[82] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[83] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[84] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[85] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[86] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[87] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[88] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[89] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[90] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[91] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[92] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]);
		LINKS[93] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[94] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[95] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[96] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[97] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]);
		LINKS[98] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[99] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[100] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[101] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[102] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[103] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[104] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[105] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[106] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[107] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[108] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[109] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[110] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[111] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[112] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[113] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[114] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[115] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[116] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[117] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[118] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[119] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[120] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[121] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[122] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[123] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[124] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[125] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[126] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[127] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[128] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[129] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[130] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[131] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[132] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[133] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[134] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[135] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[136] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]);
		LINKS[137] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]);
		LINKS[138] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[139] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[140] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[141] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[142] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[143] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]);
		LINKS[144] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[145] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
		LINKS[146] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]);
		LINKS[147] = new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), FEATURES[0]), });
		TERMINALS[1].addFollower(TERMINALS[3], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), FEATURES[1]), });
		TERMINALS[2].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[2], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), FEATURES[0]), });
		TERMINALS[7].addFollower(TERMINALS[3], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), FEATURES[1]), });
		TERMINALS[3].addFollower(TERMINALS[8], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[8], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), FEATURES[2]), });
		TERMINALS[10].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[12].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[4], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]), });
		TERMINALS[8].addFollower(TERMINALS[5], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]), });
		TERMINALS[8].addFollower(TERMINALS[6], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]), });
		TERMINALS[8].addFollower(TERMINALS[0], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]), });
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[4], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]), });
		TERMINALS[11].addFollower(TERMINALS[5], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]), });
		TERMINALS[11].addFollower(TERMINALS[6], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]), });
		TERMINALS[11].addFollower(TERMINALS[0], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]), });
		TERMINALS[11].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[16], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]), });
		TERMINALS[17].addFollower(TERMINALS[16], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]), });
		TERMINALS[18].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[13].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[5].addFollower(TERMINALS[16], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]), });
		TERMINALS[19].addFollower(TERMINALS[16], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), FEATURES[7]), });
		TERMINALS[20].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[14].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[16].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[22], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[24], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[25], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[26], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[4], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]), });
		TERMINALS[25].addFollower(TERMINALS[5], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]), });
		TERMINALS[25].addFollower(TERMINALS[6], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]), });
		TERMINALS[25].addFollower(TERMINALS[0], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]), });
		TERMINALS[25].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[29], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[30], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[31], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[4], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]), });
		TERMINALS[31].addFollower(TERMINALS[5], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]), });
		TERMINALS[31].addFollower(TERMINALS[6], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]), });
		TERMINALS[31].addFollower(TERMINALS[0], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]), });
		TERMINALS[31].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[4], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), FEATURES[4]), });
		TERMINALS[27].addFollower(TERMINALS[5], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), FEATURES[4]), });
		TERMINALS[27].addFollower(TERMINALS[6], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), FEATURES[5]), });
		TERMINALS[27].addFollower(TERMINALS[0], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), FEATURES[6]), });
		TERMINALS[27].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
		TERMINALS[15].addFollower(TERMINALS[11], new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] {new org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), FEATURES[3]), });
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
