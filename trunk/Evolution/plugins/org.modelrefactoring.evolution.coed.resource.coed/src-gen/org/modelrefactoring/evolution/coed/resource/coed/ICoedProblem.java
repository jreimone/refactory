/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;

import java.util.Collection;

public interface ICoedProblem {
	public String getMessage();
	public org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity getSeverity();
	public org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType getType();
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> getQuickFixes();
}
