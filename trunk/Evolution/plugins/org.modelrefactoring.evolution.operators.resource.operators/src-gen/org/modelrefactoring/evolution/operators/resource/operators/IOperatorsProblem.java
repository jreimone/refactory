/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import java.util.Collection;

public interface IOperatorsProblem {
	public String getMessage();
	public org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity getSeverity();
	public org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType getType();
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix> getQuickFixes();
}
