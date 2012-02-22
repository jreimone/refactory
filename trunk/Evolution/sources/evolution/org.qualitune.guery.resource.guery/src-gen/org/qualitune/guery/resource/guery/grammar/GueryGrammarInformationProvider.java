/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

public class GueryGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static GueryGrammarInformationProvider INSTANCE = new GueryGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_0_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_0_0_0_1_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_0_0_0_1_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_0_0_0_1_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_0_0_0_1_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0_1_0_0_0, GUERY_0_0_0_1_0_0_1, GUERY_0_0_0_1_0_0_2);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_0_0_0_1_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0_1_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_0_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_0_0_0_1_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0_0, GUERY_0_0_0_1);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_0 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(), GUERY_0_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_1_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("motif", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_1_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME), "IDENTIFIER", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__PREPARE), org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getPreProcessor(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__VERTEX_SELECTION), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__EDGE_SELECTIONS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getEdgeSelection(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_5 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__GROUP_BY), org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getGrouping(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_1_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_1_0_0_0, GUERY_1_0_0_1, GUERY_1_0_0_2, GUERY_1_0_0_3, GUERY_1_0_0_4, GUERY_1_0_0_5);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_1_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_1_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_1 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(), GUERY_1_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_2_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_2_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("prepare", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_2_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("with", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_2_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getPreProcessor().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME), "CLASSNAME", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_2_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_2_0_0_0, GUERY_2_0_0_1, GUERY_2_0_0_2, GUERY_2_0_0_3);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_2_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_2_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_2 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getPreProcessor(), GUERY_2_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_3_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_3_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("select", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getRole(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_3_0_0_3_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword(",", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_3_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getRole(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_3_0_0_3_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_3_0_0_0, GUERY_3_0_0_3_0_0_1);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_3_0_0_3_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_3_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_3_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_3_0_0_3_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINT), org.qualitune.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_3_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_0, GUERY_3_0_0_1, GUERY_3_0_0_2, GUERY_3_0_0_3, GUERY_3_0_0_4);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_3_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_3 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(), GUERY_3_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_4_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getRole().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME), "IDENTIFIER", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_4_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_4_0_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_4_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_4_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_4 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getRole(), GUERY_4_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_5_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_5_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("where", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_5_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), "QUOTED_34_34", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_5_0_0_3_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("and", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_5_0_0_3_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), "QUOTED_34_34", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_5_0_0_3_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_5_0_0_3_0_0_0, GUERY_5_0_0_3_0_0_1);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_5_0_0_3_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_5_0_0_3_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_5_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_5_0_0_3_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_5_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_5_0_0_0, GUERY_5_0_0_1, GUERY_5_0_0_2, GUERY_5_0_0_3);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_5_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_5_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_5 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint(), GUERY_5_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_6_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("connected", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("by", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_4_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("and", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_4_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_6_0_0_4_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_4_0_0_0, GUERY_6_0_0_4_0_0_1);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_6_0_0_4_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_4_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_6_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_6_0_0_4_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_5 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONSTRAINT), org.qualitune.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_6_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_0, GUERY_6_0_0_1, GUERY_6_0_0_2, GUERY_6_0_0_3, GUERY_6_0_0_4, GUERY_6_0_0_5);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_6_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_6 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(), GUERY_6_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_7_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("not", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("connected", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("by", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_5_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("and", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_5_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS), org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_7_0_0_5_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_5_0_0_0, GUERY_7_0_0_5_0_0_1);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_7_0_0_5_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_5_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_7_0_0_5 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_7_0_0_5_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR);
	public final static org.qualitune.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_6 = new org.qualitune.guery.resource.guery.grammar.GueryContainment(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINT), org.qualitune.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK, new org.eclipse.emf.ecore.EClass[] {org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_7_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_0, GUERY_7_0_0_1, GUERY_7_0_0_2, GUERY_7_0_0_3, GUERY_7_0_0_4, GUERY_7_0_0_5, GUERY_7_0_0_6);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_7_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_7 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), GUERY_7_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH), "IDENTIFIER", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("(", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), "IDENTIFIER", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword(">", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), "IDENTIFIER", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_5 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword(")", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_6_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("[", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_6_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH), "CARDINALITY", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_6_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword(",", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_6_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH), "CARDINALITY", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_6_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("]", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_8_0_0_6_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0_6_0_0_0, GUERY_8_0_0_6_0_0_1, GUERY_8_0_0_6_0_0_2, GUERY_8_0_0_6_0_0_3, GUERY_8_0_0_6_0_0_4);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_8_0_0_6_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0_6_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_8_0_0_6 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_8_0_0_6_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK);
	public final static org.qualitune.guery.resource.guery.grammar.GueryBooleanTerminal GUERY_8_0_0_7 = new org.qualitune.guery.resource.guery.grammar.GueryBooleanTerminal(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL), "find all", "", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_8_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0_0, GUERY_8_0_0_1, GUERY_8_0_0_2, GUERY_8_0_0_3, GUERY_8_0_0_4, GUERY_8_0_0_5, GUERY_8_0_0_6, GUERY_8_0_0_7);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_8_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_8 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection(), GUERY_8_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryLineBreak GUERY_9_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryLineBreak(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_9_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("group", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_9_0_0_2 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("by", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_9_0_0_3 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getGrouping().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), "QUOTED_34_34", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryKeyword GUERY_9_0_0_4_0_0_0 = new org.qualitune.guery.resource.guery.grammar.GueryKeyword("and", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	public final static org.qualitune.guery.resource.guery.grammar.GueryPlaceholder GUERY_9_0_0_4_0_0_1 = new org.qualitune.guery.resource.guery.grammar.GueryPlaceholder(org.qualitune.guery.GueryPackage.eINSTANCE.getGrouping().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), "QUOTED_34_34", org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_9_0_0_4_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0_4_0_0_0, GUERY_9_0_0_4_0_0_1);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_9_0_0_4_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0_4_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryCompound GUERY_9_0_0_4 = new org.qualitune.guery.resource.guery.grammar.GueryCompound(GUERY_9_0_0_4_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.STAR);
	public final static org.qualitune.guery.resource.guery.grammar.GuerySequence GUERY_9_0_0 = new org.qualitune.guery.resource.guery.grammar.GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0_0, GUERY_9_0_0_1, GUERY_9_0_0_2, GUERY_9_0_0_3, GUERY_9_0_0_4);
	public final static org.qualitune.guery.resource.guery.grammar.GueryChoice GUERY_9_0 = new org.qualitune.guery.resource.guery.grammar.GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0);
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule GUERY_9 = new org.qualitune.guery.resource.guery.grammar.GueryRule(org.qualitune.guery.GueryPackage.eINSTANCE.getGrouping(), GUERY_9_0, org.qualitune.guery.resource.guery.grammar.GueryCardinality.ONE);
	
	public final static org.qualitune.guery.resource.guery.grammar.GueryRule[] RULES = new org.qualitune.guery.resource.guery.grammar.GueryRule[] {
		GUERY_0,
		GUERY_1,
		GUERY_2,
		GUERY_3,
		GUERY_4,
		GUERY_5,
		GUERY_6,
		GUERY_7,
		GUERY_8,
		GUERY_9,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.qualitune.guery.resource.guery.grammar.GueryRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.qualitune.guery.resource.guery.grammar.GueryKeyword) {
			keywords.add(((org.qualitune.guery.resource.guery.grammar.GueryKeyword) element).getValue());
		} else if (element instanceof org.qualitune.guery.resource.guery.grammar.GueryBooleanTerminal) {
			keywords.add(((org.qualitune.guery.resource.guery.grammar.GueryBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.qualitune.guery.resource.guery.grammar.GueryBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.qualitune.guery.resource.guery.grammar.GueryEnumerationTerminal) {
			org.qualitune.guery.resource.guery.grammar.GueryEnumerationTerminal terminal = (org.qualitune.guery.resource.guery.grammar.GueryEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
