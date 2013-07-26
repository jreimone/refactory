/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery;

public interface IGueryProblem {
	public String getMessage();
	public org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity getSeverity();
	public org.modelrefactoring.guery.resource.guery.GueryEProblemType getType();
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryQuickFix> getQuickFixes();
}
