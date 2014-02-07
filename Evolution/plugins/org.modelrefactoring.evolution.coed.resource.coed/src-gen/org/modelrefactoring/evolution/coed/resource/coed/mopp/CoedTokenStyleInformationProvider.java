/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;


public class CoedTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("CoED".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("for".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("import".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("incoming".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("outgoing".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("condition".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("refactoring".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("corefactoring".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_123_125".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
