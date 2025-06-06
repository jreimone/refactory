/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class TestpropertiesFollowSetProvider {
	
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement TERMINALS[] = new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement[5];
	
	public final static EStructuralFeature[] FEATURES = new EStructuralFeature[4];
	
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] LINKS = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[42];
	
	public final static org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_1_0_0_0);
		TERMINALS[1] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_3_0_0_0);
		TERMINALS[2] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_4_0_0_0);
		TERMINALS[3] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_5_0_0_0);
		TERMINALS[4] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesExpectedCsString(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesGrammarInformationProvider.TESTPROPERTIES_2_0_0_0_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY);
		FEATURES[1] = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS);
		FEATURES[2] = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE);
		FEATURES[3] = org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[1] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[2] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[3] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]);
		LINKS[4] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[5] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[6] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[7] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[8] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[9] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[10] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]);
		LINKS[11] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[12] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[13] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[14] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[15] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[16] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[17] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[18] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[19] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[20] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[21] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]);
		LINKS[22] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[23] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[24] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[25] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[26] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[27] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[28] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]);
		LINKS[29] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[30] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[31] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[32] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[33] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[34] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
		LINKS[35] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]);
		LINKS[36] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[37] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]);
		LINKS[38] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[39] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]);
		LINKS[40] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]);
		LINKS[41] = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[0].addFollower(TERMINALS[2], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[0].addFollower(TERMINALS[3], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[0].addFollower(TERMINALS[0], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]), });
		TERMINALS[4].addFollower(TERMINALS[2], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]), });
		TERMINALS[4].addFollower(TERMINALS[3], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]), });
		TERMINALS[1].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[1], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[2].addFollower(TERMINALS[2], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[2].addFollower(TERMINALS[3], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[2].addFollower(TERMINALS[0], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]), });
		TERMINALS[3].addFollower(TERMINALS[1], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(), FEATURES[0]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[3].addFollower(TERMINALS[2], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(), FEATURES[2]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[3].addFollower(TERMINALS[3], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(), FEATURES[2]), new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(), FEATURES[1]), });
		TERMINALS[3].addFollower(TERMINALS[0], new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] {new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(), FEATURES[3]), });
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
