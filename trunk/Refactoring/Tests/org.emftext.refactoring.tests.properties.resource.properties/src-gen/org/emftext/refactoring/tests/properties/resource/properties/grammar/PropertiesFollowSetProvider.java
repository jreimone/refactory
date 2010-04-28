/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class PropertiesFollowSetProvider {
	
	public final static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement TERMINAL_0 = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_1_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement TERMINAL_1 = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_3_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement TERMINAL_2 = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_4_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement TERMINAL_3 = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_5_0_0_0);
	public final static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement TERMINAL_4 = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesExpectedCsString(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesGrammarInformationProvider.PROPERTIES_2_0_0_0_0_0_1);
	
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_0 = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES);
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_1 = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY);
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_2 = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS);
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_3 = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE);
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] EMPTY_FEATURE_ARRAY = new org.eclipse.emf.ecore.EStructuralFeature[0];
	
	public static void wire0() {
		TERMINAL_0.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, FEATURE_2, });
		TERMINAL_0.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, FEATURE_2, });
		TERMINAL_0.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, FEATURE_2, });
		TERMINAL_0.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_4.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_4.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, });
		TERMINAL_1.addFollower(TERMINAL_4, EMPTY_FEATURE_ARRAY);
		TERMINAL_2.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, FEATURE_2, });
		TERMINAL_2.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, FEATURE_2, });
		TERMINAL_2.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, FEATURE_2, });
		TERMINAL_2.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_3.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, FEATURE_2, });
		TERMINAL_3.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, FEATURE_2, });
		TERMINAL_3.addFollower(TERMINAL_3, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_3, FEATURE_2, });
		TERMINAL_3.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
	}
	// wire the terminals
	static {
		wire0();
	}
}
