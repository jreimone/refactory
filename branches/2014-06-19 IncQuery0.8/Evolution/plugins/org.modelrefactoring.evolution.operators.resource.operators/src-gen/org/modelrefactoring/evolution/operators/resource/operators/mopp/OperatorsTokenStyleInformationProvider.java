/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;


public class OperatorsTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("var".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("create".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("in".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("new".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("delete".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("move".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("to".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
