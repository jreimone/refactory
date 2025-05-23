/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;


public class TestpropertiesTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, true, false, false);
		}
		if ("QUOTED_91_93".equals(tokenName)) {
			return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
