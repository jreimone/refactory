/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static TestpropertiesGrammarInformationProvider INSTANCE = new TestpropertiesGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment TESTPROPERTIES_0_0_0_0_0_0_0 = INSTANCE.getTESTPROPERTIES_0_0_0_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment getTESTPROPERTIES_0_0_0_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES), org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), }, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak TESTPROPERTIES_0_0_0_0_0_0_1 = INSTANCE.getTESTPROPERTIES_0_0_0_0_0_0_1();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak getTESTPROPERTIES_0_0_0_0_0_0_1() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak TESTPROPERTIES_0_0_0_0_0_0_2 = INSTANCE.getTESTPROPERTIES_0_0_0_0_0_0_2();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak getTESTPROPERTIES_0_0_0_0_0_0_2() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_0_0_0_0_0_0 = INSTANCE.getTESTPROPERTIES_0_0_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_0_0_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_0_0_0_0_0_0_0, TESTPROPERTIES_0_0_0_0_0_0_1, TESTPROPERTIES_0_0_0_0_0_0_2);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_0_0_0_0_0 = INSTANCE.getTESTPROPERTIES_0_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_0_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_0_0_0_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCompound TESTPROPERTIES_0_0_0_0 = INSTANCE.getTESTPROPERTIES_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCompound getTESTPROPERTIES_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCompound(TESTPROPERTIES_0_0_0_0_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.STAR);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_0_0_0 = INSTANCE.getTESTPROPERTIES_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_0_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_0_0 = INSTANCE.getTESTPROPERTIES_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule TESTPROPERTIES_0 = INSTANCE.getTESTPROPERTIES_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule getTESTPROPERTIES_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), TESTPROPERTIES_0_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder TESTPROPERTIES_1_0_0_0 = INSTANCE.getTESTPROPERTIES_1_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder getTESTPROPERTIES_1_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), "QUOTED_91_93", org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak TESTPROPERTIES_1_0_0_1 = INSTANCE.getTESTPROPERTIES_1_0_0_1();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak getTESTPROPERTIES_1_0_0_1() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment TESTPROPERTIES_1_0_0_2 = INSTANCE.getTESTPROPERTIES_1_0_0_2();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment getTESTPROPERTIES_1_0_0_2() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS), org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), }, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_1_0_0 = INSTANCE.getTESTPROPERTIES_1_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_1_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_1_0_0_0, TESTPROPERTIES_1_0_0_1, TESTPROPERTIES_1_0_0_2);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_1_0 = INSTANCE.getTESTPROPERTIES_1_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_1_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_1_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule TESTPROPERTIES_1 = INSTANCE.getTESTPROPERTIES_1();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule getTESTPROPERTIES_1() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), TESTPROPERTIES_1_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment TESTPROPERTIES_2_0_0_0_0_0_0 = INSTANCE.getTESTPROPERTIES_2_0_0_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment getTESTPROPERTIES_2_0_0_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY), org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), }, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword TESTPROPERTIES_2_0_0_0_0_0_1 = INSTANCE.getTESTPROPERTIES_2_0_0_0_0_0_1();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword getTESTPROPERTIES_2_0_0_0_0_0_1() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword("=", org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_2_0_0_0_0_0 = INSTANCE.getTESTPROPERTIES_2_0_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_2_0_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_2_0_0_0_0_0_0, TESTPROPERTIES_2_0_0_0_0_0_1);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_2_0_0_0_0 = INSTANCE.getTESTPROPERTIES_2_0_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_2_0_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_2_0_0_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCompound TESTPROPERTIES_2_0_0_0 = INSTANCE.getTESTPROPERTIES_2_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCompound getTESTPROPERTIES_2_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCompound(TESTPROPERTIES_2_0_0_0_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.QUESTIONMARK);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment TESTPROPERTIES_2_0_0_1 = INSTANCE.getTESTPROPERTIES_2_0_0_1();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment getTESTPROPERTIES_2_0_0_1() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE), org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getValue(), }, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak TESTPROPERTIES_2_0_0_2 = INSTANCE.getTESTPROPERTIES_2_0_0_2();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak getTESTPROPERTIES_2_0_0_2() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_2_0_0 = INSTANCE.getTESTPROPERTIES_2_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_2_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_2_0_0_0, TESTPROPERTIES_2_0_0_1, TESTPROPERTIES_2_0_0_2);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_2_0 = INSTANCE.getTESTPROPERTIES_2_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_2_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_2_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule TESTPROPERTIES_2 = INSTANCE.getTESTPROPERTIES_2();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule getTESTPROPERTIES_2() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), TESTPROPERTIES_2_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder TESTPROPERTIES_3_0_0_0 = INSTANCE.getTESTPROPERTIES_3_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder getTESTPROPERTIES_3_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), "TEXT", org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_3_0_0 = INSTANCE.getTESTPROPERTIES_3_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_3_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_3_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_3_0 = INSTANCE.getTESTPROPERTIES_3_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_3_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_3_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule TESTPROPERTIES_3 = INSTANCE.getTESTPROPERTIES_3();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule getTESTPROPERTIES_3() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), TESTPROPERTIES_3_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder TESTPROPERTIES_4_0_0_0 = INSTANCE.getTESTPROPERTIES_4_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder getTESTPROPERTIES_4_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), "QUOTED_60_62", org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_4_0_0 = INSTANCE.getTESTPROPERTIES_4_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_4_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_4_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_4_0 = INSTANCE.getTESTPROPERTIES_4_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_4_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_4_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule TESTPROPERTIES_4 = INSTANCE.getTESTPROPERTIES_4();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule getTESTPROPERTIES_4() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), TESTPROPERTIES_4_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder TESTPROPERTIES_5_0_0_0 = INSTANCE.getTESTPROPERTIES_5_0_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder getTESTPROPERTIES_5_0_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), "QUOTED_34_34", org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, 0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence TESTPROPERTIES_5_0_0 = INSTANCE.getTESTPROPERTIES_5_0_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence getTESTPROPERTIES_5_0_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_5_0_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice TESTPROPERTIES_5_0 = INSTANCE.getTESTPROPERTIES_5_0();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getTESTPROPERTIES_5_0() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE, TESTPROPERTIES_5_0_0);
	}
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule TESTPROPERTIES_5 = INSTANCE.getTESTPROPERTIES_5();
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule getTESTPROPERTIES_5() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), TESTPROPERTIES_5_0, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality.ONE);
	}
	
	public static String getSyntaxElementID(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.class.getFields()) {
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
	
	public static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement) org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule[] RULES = new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule[] {
		TESTPROPERTIES_0,
		TESTPROPERTIES_1,
		TESTPROPERTIES_2,
		TESTPROPERTIES_3,
		TESTPROPERTIES_4,
		TESTPROPERTIES_5,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword) {
			keywords.add(((org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword) element).getValue());
		} else if (element instanceof org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesBooleanTerminal) {
			keywords.add(((org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesEnumerationTerminal) {
			org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesEnumerationTerminal terminal = (org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
