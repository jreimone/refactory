/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

public class GueryGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static GueryGrammarInformationProvider INSTANCE = new GueryGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_0_0_0_0 = INSTANCE.getGUERY_0_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_0_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_0_0_0_1_0_0_0 = INSTANCE.getGUERY_0_0_0_1_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_0_0_0_1_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_0_0_0_1_0_0_1 = INSTANCE.getGUERY_0_0_0_1_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_0_0_0_1_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_0_0_0_1_0_0_2 = INSTANCE.getGUERY_0_0_0_1_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_0_0_0_1_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_0_0_0_1_0_0 = INSTANCE.getGUERY_0_0_0_1_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_0_0_0_1_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0_1_0_0_0, GUERY_0_0_0_1_0_0_1, GUERY_0_0_0_1_0_0_2);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_0_0_0_1_0 = INSTANCE.getGUERY_0_0_0_1_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_0_0_0_1_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0_1_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_0_0_0_1 = INSTANCE.getGUERY_0_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_0_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_0_0_0_1_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_0_0_0 = INSTANCE.getGUERY_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0_0, GUERY_0_0_0_1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_0_0 = INSTANCE.getGUERY_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_0_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_0 = INSTANCE.getGUERY_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(), GUERY_0_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_1_0_0_0 = INSTANCE.getGUERY_1_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_1_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("motif", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_1_0_0_1 = INSTANCE.getGUERY_1_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_1_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__NAME), "IDENTIFIER", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_2 = INSTANCE.getGUERY_1_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_1_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__PREPARE), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_3 = INSTANCE.getGUERY_1_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_1_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__VERTEX_SELECTION), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_4 = INSTANCE.getGUERY_1_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_1_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__EDGE_SELECTIONS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getEdgeSelection(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_1_0_0_5 = INSTANCE.getGUERY_1_0_0_5();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_1_0_0_5() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__GROUP_BY), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_1_0_0 = INSTANCE.getGUERY_1_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_1_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_1_0_0_0, GUERY_1_0_0_1, GUERY_1_0_0_2, GUERY_1_0_0_3, GUERY_1_0_0_4, GUERY_1_0_0_5);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_1_0 = INSTANCE.getGUERY_1_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_1_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_1_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_1 = INSTANCE.getGUERY_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(), GUERY_1_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_2_0_0_0 = INSTANCE.getGUERY_2_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_2_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_2_0_0_1 = INSTANCE.getGUERY_2_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_2_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("prepare with", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_2_0_0_2 = INSTANCE.getGUERY_2_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_2_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.PRE_PROCESSOR__PROCESSOR_CLASS_NAME), "CLASSNAME", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_2_0_0 = INSTANCE.getGUERY_2_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_2_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_2_0_0_0, GUERY_2_0_0_1, GUERY_2_0_0_2);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_2_0 = INSTANCE.getGUERY_2_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_2_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_2_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_2 = INSTANCE.getGUERY_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(), GUERY_2_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_3_0_0_0 = INSTANCE.getGUERY_3_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_3_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_3_0_0_1 = INSTANCE.getGUERY_3_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_3_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("select", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_2 = INSTANCE.getGUERY_3_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_3_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_3_0_0_3_0_0_0 = INSTANCE.getGUERY_3_0_0_3_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_3_0_0_3_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword(",", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_3_0_0_3_0_0_1 = INSTANCE.getGUERY_3_0_0_3_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_3_0_0_3_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_3_0_0_2 = INSTANCE.getGUERY_3_0_0_3_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_3_0_0_3_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_3_0_0_3_0_0 = INSTANCE.getGUERY_3_0_0_3_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_3_0_0_3_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_3_0_0_0, GUERY_3_0_0_3_0_0_1, GUERY_3_0_0_3_0_0_2);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_3_0_0_3_0 = INSTANCE.getGUERY_3_0_0_3_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_3_0_0_3_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_3_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_3_0_0_3 = INSTANCE.getGUERY_3_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_3_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_3_0_0_3_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_3_0_0_4_0_0_0 = INSTANCE.getGUERY_3_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_3_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_3_0_0_4_0_0_1 = INSTANCE.getGUERY_3_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_3_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("where", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_3_0_0_4_0_0_2 = INSTANCE.getGUERY_3_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_3_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_4_0_0_3 = INSTANCE.getGUERY_3_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_3_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_3_0_0_4_0_0_4_0_0_0 = INSTANCE.getGUERY_3_0_0_4_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_3_0_0_4_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_3_0_0_4_0_0_4_0_0_1 = INSTANCE.getGUERY_3_0_0_4_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_3_0_0_4_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("and", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_3_0_0_4_0_0_4_0_0_2 = INSTANCE.getGUERY_3_0_0_4_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_3_0_0_4_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_3_0_0_4_0_0_4_0_0_3 = INSTANCE.getGUERY_3_0_0_4_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_3_0_0_4_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_3_0_0_4_0_0_4_0_0 = INSTANCE.getGUERY_3_0_0_4_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_3_0_0_4_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_4_0_0_4_0_0_0, GUERY_3_0_0_4_0_0_4_0_0_1, GUERY_3_0_0_4_0_0_4_0_0_2, GUERY_3_0_0_4_0_0_4_0_0_3);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_3_0_0_4_0_0_4_0 = INSTANCE.getGUERY_3_0_0_4_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_3_0_0_4_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_4_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_3_0_0_4_0_0_4 = INSTANCE.getGUERY_3_0_0_4_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_3_0_0_4_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_3_0_0_4_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_3_0_0_4_0_0 = INSTANCE.getGUERY_3_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_3_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_4_0_0_0, GUERY_3_0_0_4_0_0_1, GUERY_3_0_0_4_0_0_2, GUERY_3_0_0_4_0_0_3, GUERY_3_0_0_4_0_0_4);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_3_0_0_4_0 = INSTANCE.getGUERY_3_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_3_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_3_0_0_4 = INSTANCE.getGUERY_3_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_3_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_3_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_3_0_0 = INSTANCE.getGUERY_3_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_3_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0_0, GUERY_3_0_0_1, GUERY_3_0_0_2, GUERY_3_0_0_3, GUERY_3_0_0_4);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_3_0 = INSTANCE.getGUERY_3_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_3_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_3_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_3 = INSTANCE.getGUERY_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(), GUERY_3_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_4_0_0_0 = INSTANCE.getGUERY_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.ROLE__NAME), "IDENTIFIER", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_4_0_0 = INSTANCE.getGUERY_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_4_0_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_4_0 = INSTANCE.getGUERY_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_4 = INSTANCE.getGUERY_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(), GUERY_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_5_0_0_0 = INSTANCE.getGUERY_5_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_5_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINT__EXPRESSION), "QUOTED_34_34", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_5_0_0 = INSTANCE.getGUERY_5_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_5_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_5_0_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_5_0 = INSTANCE.getGUERY_5_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_5_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_5_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_5 = INSTANCE.getGUERY_5();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_5() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), GUERY_5_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_6_0_0_0 = INSTANCE.getGUERY_6_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_6_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_1 = INSTANCE.getGUERY_6_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_6_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("connected by", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_6_0_0_2 = INSTANCE.getGUERY_6_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_6_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_3 = INSTANCE.getGUERY_6_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_6_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_6_0_0_4_0_0_0 = INSTANCE.getGUERY_6_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_6_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_4_0_0_1 = INSTANCE.getGUERY_6_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_6_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("and", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_6_0_0_4_0_0_2 = INSTANCE.getGUERY_6_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_6_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_4_0_0_3 = INSTANCE.getGUERY_6_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_6_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_6_0_0_4_0_0 = INSTANCE.getGUERY_6_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_6_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_4_0_0_0, GUERY_6_0_0_4_0_0_1, GUERY_6_0_0_4_0_0_2, GUERY_6_0_0_4_0_0_3);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_6_0_0_4_0 = INSTANCE.getGUERY_6_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_6_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_6_0_0_4 = INSTANCE.getGUERY_6_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_6_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_6_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_6_0_0_5_0_0_0 = INSTANCE.getGUERY_6_0_0_5_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_6_0_0_5_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_5_0_0_1 = INSTANCE.getGUERY_6_0_0_5_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_6_0_0_5_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("where", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_6_0_0_5_0_0_2 = INSTANCE.getGUERY_6_0_0_5_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_6_0_0_5_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_5_0_0_3 = INSTANCE.getGUERY_6_0_0_5_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_6_0_0_5_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_6_0_0_5_0_0_4_0_0_0 = INSTANCE.getGUERY_6_0_0_5_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_6_0_0_5_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_6_0_0_5_0_0_4_0_0_1 = INSTANCE.getGUERY_6_0_0_5_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_6_0_0_5_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("and", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_6_0_0_5_0_0_4_0_0_2 = INSTANCE.getGUERY_6_0_0_5_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_6_0_0_5_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_6_0_0_5_0_0_4_0_0_3 = INSTANCE.getGUERY_6_0_0_5_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_6_0_0_5_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_6_0_0_5_0_0_4_0_0 = INSTANCE.getGUERY_6_0_0_5_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_6_0_0_5_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_5_0_0_4_0_0_0, GUERY_6_0_0_5_0_0_4_0_0_1, GUERY_6_0_0_5_0_0_4_0_0_2, GUERY_6_0_0_5_0_0_4_0_0_3);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_6_0_0_5_0_0_4_0 = INSTANCE.getGUERY_6_0_0_5_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_6_0_0_5_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_5_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_6_0_0_5_0_0_4 = INSTANCE.getGUERY_6_0_0_5_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_6_0_0_5_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_6_0_0_5_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_6_0_0_5_0_0 = INSTANCE.getGUERY_6_0_0_5_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_6_0_0_5_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_5_0_0_0, GUERY_6_0_0_5_0_0_1, GUERY_6_0_0_5_0_0_2, GUERY_6_0_0_5_0_0_3, GUERY_6_0_0_5_0_0_4);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_6_0_0_5_0 = INSTANCE.getGUERY_6_0_0_5_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_6_0_0_5_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_5_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_6_0_0_5 = INSTANCE.getGUERY_6_0_0_5();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_6_0_0_5() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_6_0_0_5_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_6_0_0 = INSTANCE.getGUERY_6_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_6_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0_0, GUERY_6_0_0_1, GUERY_6_0_0_2, GUERY_6_0_0_3, GUERY_6_0_0_4, GUERY_6_0_0_5);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_6_0 = INSTANCE.getGUERY_6_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_6_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_6_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_6 = INSTANCE.getGUERY_6();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_6() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(), GUERY_6_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_7_0_0_0 = INSTANCE.getGUERY_7_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_7_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_1 = INSTANCE.getGUERY_7_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_7_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("not connected by", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_7_0_0_2 = INSTANCE.getGUERY_7_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_7_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_3 = INSTANCE.getGUERY_7_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_7_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_7_0_0_4_0_0_0 = INSTANCE.getGUERY_7_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_7_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_4_0_0_1 = INSTANCE.getGUERY_7_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_7_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("and", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_7_0_0_4_0_0_2 = INSTANCE.getGUERY_7_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_7_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_4_0_0_3 = INSTANCE.getGUERY_7_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_7_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_7_0_0_4_0_0 = INSTANCE.getGUERY_7_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_7_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_4_0_0_0, GUERY_7_0_0_4_0_0_1, GUERY_7_0_0_4_0_0_2, GUERY_7_0_0_4_0_0_3);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_7_0_0_4_0 = INSTANCE.getGUERY_7_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_7_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_7_0_0_4 = INSTANCE.getGUERY_7_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_7_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_7_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_7_0_0_5_0_0_0 = INSTANCE.getGUERY_7_0_0_5_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_7_0_0_5_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_5_0_0_1 = INSTANCE.getGUERY_7_0_0_5_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_7_0_0_5_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("where", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_7_0_0_5_0_0_2 = INSTANCE.getGUERY_7_0_0_5_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_7_0_0_5_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_5_0_0_3 = INSTANCE.getGUERY_7_0_0_5_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_7_0_0_5_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_7_0_0_5_0_0_4_0_0_0 = INSTANCE.getGUERY_7_0_0_5_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_7_0_0_5_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_7_0_0_5_0_0_4_0_0_1 = INSTANCE.getGUERY_7_0_0_5_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_7_0_0_5_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("and", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_7_0_0_5_0_0_4_0_0_2 = INSTANCE.getGUERY_7_0_0_5_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_7_0_0_5_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_7_0_0_5_0_0_4_0_0_3 = INSTANCE.getGUERY_7_0_0_5_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_7_0_0_5_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_7_0_0_5_0_0_4_0_0 = INSTANCE.getGUERY_7_0_0_5_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_7_0_0_5_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_5_0_0_4_0_0_0, GUERY_7_0_0_5_0_0_4_0_0_1, GUERY_7_0_0_5_0_0_4_0_0_2, GUERY_7_0_0_5_0_0_4_0_0_3);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_7_0_0_5_0_0_4_0 = INSTANCE.getGUERY_7_0_0_5_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_7_0_0_5_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_5_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_7_0_0_5_0_0_4 = INSTANCE.getGUERY_7_0_0_5_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_7_0_0_5_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_7_0_0_5_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_7_0_0_5_0_0 = INSTANCE.getGUERY_7_0_0_5_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_7_0_0_5_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_5_0_0_0, GUERY_7_0_0_5_0_0_1, GUERY_7_0_0_5_0_0_2, GUERY_7_0_0_5_0_0_3, GUERY_7_0_0_5_0_0_4);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_7_0_0_5_0 = INSTANCE.getGUERY_7_0_0_5_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_7_0_0_5_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_5_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_7_0_0_5 = INSTANCE.getGUERY_7_0_0_5();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_7_0_0_5() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_7_0_0_5_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_7_0_0 = INSTANCE.getGUERY_7_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_7_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0_0, GUERY_7_0_0_1, GUERY_7_0_0_2, GUERY_7_0_0_3, GUERY_7_0_0_4, GUERY_7_0_0_5);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_7_0 = INSTANCE.getGUERY_7_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_7_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_7_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_7 = INSTANCE.getGUERY_7();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_7() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(), GUERY_7_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_0 = INSTANCE.getGUERY_8_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_8_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__PATH), "IDENTIFIER", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_1 = INSTANCE.getGUERY_8_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_8_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("(", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_2 = INSTANCE.getGUERY_8_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_8_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM), "IDENTIFIER", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_3 = INSTANCE.getGUERY_8_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_8_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword(">", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_4 = INSTANCE.getGUERY_8_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_8_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO), "IDENTIFIER", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_5 = INSTANCE.getGUERY_8_0_0_5();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_8_0_0_5() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword(")", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_6_0_0_0 = INSTANCE.getGUERY_8_0_0_6_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_8_0_0_6_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("[", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_6_0_0_1 = INSTANCE.getGUERY_8_0_0_6_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_8_0_0_6_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MIN_LENGTH), "CARDINALITY", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_6_0_0_2 = INSTANCE.getGUERY_8_0_0_6_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_8_0_0_6_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword(",", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder GUERY_8_0_0_6_0_0_3 = INSTANCE.getGUERY_8_0_0_6_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder getGUERY_8_0_0_6_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryPlaceholder(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MAX_LENGTH), "CARDINALITY", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_8_0_0_6_0_0_4 = INSTANCE.getGUERY_8_0_0_6_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_8_0_0_6_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("]", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_8_0_0_6_0_0 = INSTANCE.getGUERY_8_0_0_6_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_8_0_0_6_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0_6_0_0_0, GUERY_8_0_0_6_0_0_1, GUERY_8_0_0_6_0_0_2, GUERY_8_0_0_6_0_0_3, GUERY_8_0_0_6_0_0_4);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_8_0_0_6_0 = INSTANCE.getGUERY_8_0_0_6_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_8_0_0_6_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0_6_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_8_0_0_6 = INSTANCE.getGUERY_8_0_0_6();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_8_0_0_6() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_8_0_0_6_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.QUESTIONMARK);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_8_0_0_7 = INSTANCE.getGUERY_8_0_0_7();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_8_0_0_7() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryBooleanTerminal GUERY_8_0_0_8 = INSTANCE.getGUERY_8_0_0_8();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryBooleanTerminal getGUERY_8_0_0_8() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryBooleanTerminal(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL), "find all", "", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_8_0_0 = INSTANCE.getGUERY_8_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_8_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0_0, GUERY_8_0_0_1, GUERY_8_0_0_2, GUERY_8_0_0_3, GUERY_8_0_0_4, GUERY_8_0_0_5, GUERY_8_0_0_6, GUERY_8_0_0_7, GUERY_8_0_0_8);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_8_0 = INSTANCE.getGUERY_8_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_8_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_8_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_8 = INSTANCE.getGUERY_8();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_8() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(), GUERY_8_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_9_0_0_0 = INSTANCE.getGUERY_9_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_9_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_9_0_0_1 = INSTANCE.getGUERY_9_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_9_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("group by", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_9_0_0_2 = INSTANCE.getGUERY_9_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_9_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_9_0_0_3 = INSTANCE.getGUERY_9_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_9_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak GUERY_9_0_0_4_0_0_0 = INSTANCE.getGUERY_9_0_0_4_0_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak getGUERY_9_0_0_4_0_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, 1);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword GUERY_9_0_0_4_0_0_1 = INSTANCE.getGUERY_9_0_0_4_0_0_1();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword getGUERY_9_0_0_4_0_0_1() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword("and", org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace GUERY_9_0_0_4_0_0_2 = INSTANCE.getGUERY_9_0_0_4_0_0_2();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace getGUERY_9_0_0_4_0_0_2() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryWhiteSpace(1, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryContainment GUERY_9_0_0_4_0_0_3 = INSTANCE.getGUERY_9_0_0_4_0_0_3();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryContainment getGUERY_9_0_0_4_0_0_3() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryContainment(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS), org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(), }, 0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_9_0_0_4_0_0 = INSTANCE.getGUERY_9_0_0_4_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_9_0_0_4_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0_4_0_0_0, GUERY_9_0_0_4_0_0_1, GUERY_9_0_0_4_0_0_2, GUERY_9_0_0_4_0_0_3);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_9_0_0_4_0 = INSTANCE.getGUERY_9_0_0_4_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_9_0_0_4_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0_4_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryCompound GUERY_9_0_0_4 = INSTANCE.getGUERY_9_0_0_4();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryCompound getGUERY_9_0_0_4() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryCompound(GUERY_9_0_0_4_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.STAR);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GuerySequence GUERY_9_0_0 = INSTANCE.getGUERY_9_0_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GuerySequence getGUERY_9_0_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0_0, GUERY_9_0_0_1, GUERY_9_0_0_2, GUERY_9_0_0_3, GUERY_9_0_0_4);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryChoice GUERY_9_0 = INSTANCE.getGUERY_9_0();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryChoice getGUERY_9_0() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE, GUERY_9_0_0);
	}
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule GUERY_9 = INSTANCE.getGUERY_9();
	private org.modelrefactoring.guery.resource.guery.grammar.GueryRule getGUERY_9() {
		return new org.modelrefactoring.guery.resource.guery.grammar.GueryRule(org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(), GUERY_9_0, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality.ONE);
	}
	
	public static String getSyntaxElementID(org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.class.getFields()) {
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
	
	public static org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement) org.modelrefactoring.guery.resource.guery.grammar.GueryGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.modelrefactoring.guery.resource.guery.grammar.GueryRule[] RULES = new org.modelrefactoring.guery.resource.guery.grammar.GueryRule[] {
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
			for (org.modelrefactoring.guery.resource.guery.grammar.GueryRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword) {
			keywords.add(((org.modelrefactoring.guery.resource.guery.grammar.GueryKeyword) element).getValue());
		} else if (element instanceof org.modelrefactoring.guery.resource.guery.grammar.GueryBooleanTerminal) {
			keywords.add(((org.modelrefactoring.guery.resource.guery.grammar.GueryBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.modelrefactoring.guery.resource.guery.grammar.GueryBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.modelrefactoring.guery.resource.guery.grammar.GueryEnumerationTerminal) {
			org.modelrefactoring.guery.resource.guery.grammar.GueryEnumerationTerminal terminal = (org.modelrefactoring.guery.resource.guery.grammar.GueryEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
