/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;


public class RefcompTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMPOSITE".equals(tokenName)) {
			return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("REFACTORING".equals(tokenName)) {
			return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("FOR".equals(tokenName)) {
			return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
