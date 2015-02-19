/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class RefcompFollowSetProvider {
	
	public final static org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement TERMINALS[] = new org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement[18];
	
	public final static EStructuralFeature[] FEATURES = new EStructuralFeature[3];
	
	public final static org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] LINKS = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[6];
	
	public final static org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_0);
		TERMINALS[1] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_2);
		TERMINALS[2] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_4);
		TERMINALS[3] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_6);
		TERMINALS[4] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_8);
		TERMINALS[5] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_0_0_0_11);
		TERMINALS[6] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_0);
		TERMINALS[7] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_2);
		TERMINALS[8] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_4_0_0_0);
		TERMINALS[9] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_0_0_0_0);
		TERMINALS[10] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_1);
		TERMINALS[11] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_1_0_0_4_0_0_4);
		TERMINALS[12] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_0_0_0_1);
		TERMINALS[13] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_3);
		TERMINALS[14] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_5_0_0_0);
		TERMINALS[15] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedStructuralFeature(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_6);
		TERMINALS[16] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_5_0_0_1);
		TERMINALS[17] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompExpectedCsString(org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.REFCOMP_2_0_0_7);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE);
		FEATURES[1] = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING);
		FEATURES[2] = org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[0]);
		LINKS[1] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[1]);
		LINKS[2] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(), FEATURES[2]);
		LINKS[3] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(), FEATURES[2]);
		LINKS[4] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[1]);
		LINKS[5] = new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[1]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[6], new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] {new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[0]), });
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[6], new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] {new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[1]), });
		TERMINALS[8].addFollower(TERMINALS[9], new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] {new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(), FEATURES[2]), });
		TERMINALS[8].addFollower(TERMINALS[10], new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] {new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[6], new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] {new org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), FEATURES[1]), });
		TERMINALS[9].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
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
