/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static PropertiesGrammarInformationProvider INSTANCE = new PropertiesGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment PROPERTIES_0_0_0_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES), org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), }, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak PROPERTIES_0_0_0_0_0_0_1 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak PROPERTIES_0_0_0_0_0_0_2 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_0_0_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_0_0_0_0_0_0_0, PROPERTIES_0_0_0_0_0_0_1, PROPERTIES_0_0_0_0_0_0_2);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_0_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_0_0_0_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCompound PROPERTIES_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCompound(PROPERTIES_0_0_0_0_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.STAR);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_0_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule PROPERTIES_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(), PROPERTIES_0_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder PROPERTIES_1_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), "QUOTED_91_93", org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak PROPERTIES_1_0_0_1 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment PROPERTIES_1_0_0_2 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS), org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), }, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_1_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_1_0_0_0, PROPERTIES_1_0_0_1, PROPERTIES_1_0_0_2);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_1_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_1_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule PROPERTIES_1 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), PROPERTIES_1_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment PROPERTIES_2_0_0_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY), org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), }, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword PROPERTIES_2_0_0_0_0_0_1 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword("=", org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_2_0_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_2_0_0_0_0_0_0, PROPERTIES_2_0_0_0_0_0_1);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_2_0_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_2_0_0_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCompound PROPERTIES_2_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCompound(PROPERTIES_2_0_0_0_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.QUESTIONMARK);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment PROPERTIES_2_0_0_1 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesContainment(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE), org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getValue(), }, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak PROPERTIES_2_0_0_2 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_2_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_2_0_0_0, PROPERTIES_2_0_0_1, PROPERTIES_2_0_0_2);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_2_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_2_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule PROPERTIES_2 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), PROPERTIES_2_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder PROPERTIES_3_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), "TEXT", org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_3_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_3_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_3_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_3_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule PROPERTIES_3 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), PROPERTIES_3_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder PROPERTIES_4_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), "QUOTED_60_62", org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_4_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_4_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_4_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_4_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule PROPERTIES_4 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), PROPERTIES_4_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder PROPERTIES_5_0_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesPlaceholder(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), "QUOTED_34_34", org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, 0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence PROPERTIES_5_0_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_5_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice PROPERTIES_5_0 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE, PROPERTIES_5_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule PROPERTIES_5 = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), PROPERTIES_5_0, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality.ONE);
	
	public final static org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule[] RULES = new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule[] {
		PROPERTIES_0,
		PROPERTIES_1,
		PROPERTIES_2,
		PROPERTIES_3,
		PROPERTIES_4,
		PROPERTIES_5,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword) {
			keywords.add(((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword) element).getValue());
		} else if (element instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesBooleanTerminal) {
			keywords.add(((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesEnumerationTerminal) {
			org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesEnumerationTerminal terminal = (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
