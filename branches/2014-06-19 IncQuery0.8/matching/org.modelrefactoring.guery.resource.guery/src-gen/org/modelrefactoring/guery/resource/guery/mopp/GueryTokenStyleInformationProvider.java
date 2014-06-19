/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.modelrefactoring.guery.resource.guery.IGueryTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("SL_COMMENT".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, true, false, false);
		}
		if ("CLASSNAME".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, false, false, false, false);
		}
		if ("find all".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("connected by".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("group by".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("not connected by".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("prepare with".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("motif".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("select".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("where".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
