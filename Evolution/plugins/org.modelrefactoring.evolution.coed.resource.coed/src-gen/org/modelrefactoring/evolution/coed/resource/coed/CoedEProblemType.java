/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;


public enum CoedEProblemType {
	SYNTAX_ERROR, PRINT_PROBLEM, UNRESOLVED_REFERENCE, ANALYSIS_PROBLEM, BATCH_CONSTRAINT_PROBLEM, LIVE_CONSTRAINT_PROBLEM, BUILDER_ERROR, UNKNOWN, ;
	
	/**
	 * Returns the ID that is used for this type of problem when creating markers for
	 * problems.
	 */
	public String getID() {
		if (this == UNKNOWN) {
			return "";
		}
		return this.name().toLowerCase();
	}
	
}
