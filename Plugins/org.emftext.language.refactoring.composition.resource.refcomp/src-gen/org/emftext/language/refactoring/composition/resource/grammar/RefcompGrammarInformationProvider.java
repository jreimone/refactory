/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class RefcompGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static RefcompGrammarInformationProvider INSTANCE = new RefcompGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_0_0_0_0 = INSTANCE.getREFCOMP_0_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_0_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("COMPOSITE", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_0_0_0_1 = INSTANCE.getREFCOMP_0_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_0_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_0_0_0_2 = INSTANCE.getREFCOMP_0_0_0_2();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_0_0_0_2() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("REFACTORING", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_0_0_0_3 = INSTANCE.getREFCOMP_0_0_0_3();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_0_0_0_3() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_0_0_0_4 = INSTANCE.getREFCOMP_0_0_0_4();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_0_0_0_4() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME), "QUOTED_34_34", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_0_0_0_5 = INSTANCE.getREFCOMP_0_0_0_5();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_0_0_0_5() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_0_0_0_6 = INSTANCE.getREFCOMP_0_0_0_6();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_0_0_0_6() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("FOR", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_0_0_0_7 = INSTANCE.getREFCOMP_0_0_0_7();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_0_0_0_7() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_0_0_0_8 = INSTANCE.getREFCOMP_0_0_0_8();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_0_0_0_8() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL), "QUOTED_60_62", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_0_0_0_9 = INSTANCE.getREFCOMP_0_0_0_9();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_0_0_0_9() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_0_0_0_10 = INSTANCE.getREFCOMP_0_0_0_10();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_0_0_0_10() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_0_0_0_11 = INSTANCE.getREFCOMP_0_0_0_11();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_0_0_0_11() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST), "QUOTED_60_62", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_0_0_0_12 = INSTANCE.getREFCOMP_0_0_0_12();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_0_0_0_12() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment REFCOMP_0_0_0_13 = INSTANCE.getREFCOMP_0_0_0_13();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment getREFCOMP_0_0_0_13() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE), org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, new EClass[] {org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), }, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_0_0_0 = INSTANCE.getREFCOMP_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_0_0_0_0, REFCOMP_0_0_0_1, REFCOMP_0_0_0_2, REFCOMP_0_0_0_3, REFCOMP_0_0_0_4, REFCOMP_0_0_0_5, REFCOMP_0_0_0_6, REFCOMP_0_0_0_7, REFCOMP_0_0_0_8, REFCOMP_0_0_0_9, REFCOMP_0_0_0_10, REFCOMP_0_0_0_11, REFCOMP_0_0_0_12, REFCOMP_0_0_0_13);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_0_0 = INSTANCE.getREFCOMP_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_0_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompRule REFCOMP_0 = INSTANCE.getREFCOMP_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompRule getREFCOMP_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompRule(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping(), REFCOMP_0_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_1_0_0_0 = INSTANCE.getREFCOMP_1_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_1_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("->", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_1_0_0_1 = INSTANCE.getREFCOMP_1_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_1_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_1_0_0_2 = INSTANCE.getREFCOMP_1_0_0_2();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_1_0_0_2() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING), "QUOTED_60_62", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_1_0_0_3 = INSTANCE.getREFCOMP_1_0_0_3();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_1_0_0_3() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_1_0_0_4_0_0_0 = INSTANCE.getREFCOMP_1_0_0_4_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_1_0_0_4_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("{", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_1_0_0_4_0_0_1 = INSTANCE.getREFCOMP_1_0_0_4_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_1_0_0_4_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 1);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment REFCOMP_1_0_0_4_0_0_2 = INSTANCE.getREFCOMP_1_0_0_4_0_0_2();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment getREFCOMP_1_0_0_4_0_0_2() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS), org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, new EClass[] {org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(), }, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_1_0_0_4_0_0_3 = INSTANCE.getREFCOMP_1_0_0_4_0_0_3();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_1_0_0_4_0_0_3() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_1_0_0_4_0_0_4 = INSTANCE.getREFCOMP_1_0_0_4_0_0_4();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_1_0_0_4_0_0_4() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("}", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_1_0_0_4_0_0 = INSTANCE.getREFCOMP_1_0_0_4_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_1_0_0_4_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_1_0_0_4_0_0_0, REFCOMP_1_0_0_4_0_0_1, REFCOMP_1_0_0_4_0_0_2, REFCOMP_1_0_0_4_0_0_3, REFCOMP_1_0_0_4_0_0_4);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_1_0_0_4_0 = INSTANCE.getREFCOMP_1_0_0_4_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_1_0_0_4_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_1_0_0_4_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound REFCOMP_1_0_0_4 = INSTANCE.getREFCOMP_1_0_0_4();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound getREFCOMP_1_0_0_4() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound(REFCOMP_1_0_0_4_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_1_0_0_5_0_0_0 = INSTANCE.getREFCOMP_1_0_0_5_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_1_0_0_5_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment REFCOMP_1_0_0_5_0_0_1 = INSTANCE.getREFCOMP_1_0_0_5_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment getREFCOMP_1_0_0_5_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompContainment(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING), org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, new EClass[] {org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), }, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_1_0_0_5_0_0 = INSTANCE.getREFCOMP_1_0_0_5_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_1_0_0_5_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_1_0_0_5_0_0_0, REFCOMP_1_0_0_5_0_0_1);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_1_0_0_5_0 = INSTANCE.getREFCOMP_1_0_0_5_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_1_0_0_5_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_1_0_0_5_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound REFCOMP_1_0_0_5 = INSTANCE.getREFCOMP_1_0_0_5();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound getREFCOMP_1_0_0_5() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound(REFCOMP_1_0_0_5_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_1_0_0 = INSTANCE.getREFCOMP_1_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_1_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_1_0_0_0, REFCOMP_1_0_0_1, REFCOMP_1_0_0_2, REFCOMP_1_0_0_3, REFCOMP_1_0_0_4, REFCOMP_1_0_0_5);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_1_0 = INSTANCE.getREFCOMP_1_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_1_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_1_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompRule REFCOMP_1 = INSTANCE.getREFCOMP_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompRule getREFCOMP_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompRule(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(), REFCOMP_1_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_2_0_0_0_0_0_0 = INSTANCE.getREFCOMP_2_0_0_0_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_2_0_0_0_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL), "QUOTED_60_62", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_2_0_0_0_0_0_1 = INSTANCE.getREFCOMP_2_0_0_0_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_2_0_0_0_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword(".", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_2_0_0_0_0_0 = INSTANCE.getREFCOMP_2_0_0_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_2_0_0_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_2_0_0_0_0_0_0, REFCOMP_2_0_0_0_0_0_1);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_2_0_0_0_0 = INSTANCE.getREFCOMP_2_0_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_2_0_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_2_0_0_0_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound REFCOMP_2_0_0_0 = INSTANCE.getREFCOMP_2_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound getREFCOMP_2_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound(REFCOMP_2_0_0_0_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_2_0_0_1 = INSTANCE.getREFCOMP_2_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_2_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE), "IDENTIFIER", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_2_0_0_2 = INSTANCE.getREFCOMP_2_0_0_2();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_2_0_0_2() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_2_0_0_3 = INSTANCE.getREFCOMP_2_0_0_3();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_2_0_0_3() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword("=", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace REFCOMP_2_0_0_4 = INSTANCE.getREFCOMP_2_0_0_4();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace getREFCOMP_2_0_0_4() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompWhiteSpace(1, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_2_0_0_5_0_0_0 = INSTANCE.getREFCOMP_2_0_0_5_0_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_2_0_0_5_0_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL), "QUOTED_60_62", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_2_0_0_5_0_0_1 = INSTANCE.getREFCOMP_2_0_0_5_0_0_1();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_2_0_0_5_0_0_1() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword(".", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_2_0_0_5_0_0 = INSTANCE.getREFCOMP_2_0_0_5_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_2_0_0_5_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_2_0_0_5_0_0_0, REFCOMP_2_0_0_5_0_0_1);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_2_0_0_5_0 = INSTANCE.getREFCOMP_2_0_0_5_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_2_0_0_5_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_2_0_0_5_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound REFCOMP_2_0_0_5 = INSTANCE.getREFCOMP_2_0_0_5();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound getREFCOMP_2_0_0_5() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompCompound(REFCOMP_2_0_0_5_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder REFCOMP_2_0_0_6 = INSTANCE.getREFCOMP_2_0_0_6();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder getREFCOMP_2_0_0_6() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompPlaceholder(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET), "IDENTIFIER", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword REFCOMP_2_0_0_7 = INSTANCE.getREFCOMP_2_0_0_7();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword getREFCOMP_2_0_0_7() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword(";", org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak REFCOMP_2_0_0_8 = INSTANCE.getREFCOMP_2_0_0_8();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak getREFCOMP_2_0_0_8() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, 0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence REFCOMP_2_0_0 = INSTANCE.getREFCOMP_2_0_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence getREFCOMP_2_0_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_2_0_0_0, REFCOMP_2_0_0_1, REFCOMP_2_0_0_2, REFCOMP_2_0_0_3, REFCOMP_2_0_0_4, REFCOMP_2_0_0_5, REFCOMP_2_0_0_6, REFCOMP_2_0_0_7, REFCOMP_2_0_0_8);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice REFCOMP_2_0 = INSTANCE.getREFCOMP_2_0();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getREFCOMP_2_0() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE, REFCOMP_2_0_0);
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompRule REFCOMP_2 = INSTANCE.getREFCOMP_2();
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompRule getREFCOMP_2() {
		return new org.emftext.language.refactoring.composition.resource.grammar.RefcompRule(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(), REFCOMP_2_0, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.class.getFields()) {
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
	
	public static org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement) org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.language.refactoring.composition.resource.grammar.RefcompRule[] RULES = new org.emftext.language.refactoring.composition.resource.grammar.RefcompRule[] {
		REFCOMP_0,
		REFCOMP_1,
		REFCOMP_2,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (org.emftext.language.refactoring.composition.resource.grammar.RefcompRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement element, Set<String> keywords) {
		if (element instanceof org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword) {
			keywords.add(((org.emftext.language.refactoring.composition.resource.grammar.RefcompKeyword) element).getValue());
		} else if (element instanceof org.emftext.language.refactoring.composition.resource.grammar.RefcompBooleanTerminal) {
			keywords.add(((org.emftext.language.refactoring.composition.resource.grammar.RefcompBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.language.refactoring.composition.resource.grammar.RefcompBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.language.refactoring.composition.resource.grammar.RefcompEnumerationTerminal) {
			org.emftext.language.refactoring.composition.resource.grammar.RefcompEnumerationTerminal terminal = (org.emftext.language.refactoring.composition.resource.grammar.RefcompEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
