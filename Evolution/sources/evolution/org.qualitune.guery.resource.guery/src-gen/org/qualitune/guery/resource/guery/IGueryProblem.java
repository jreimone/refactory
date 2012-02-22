/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery;

public interface IGueryProblem {
	public String getMessage();
	public org.qualitune.guery.resource.guery.GueryEProblemSeverity getSeverity();
	public org.qualitune.guery.resource.guery.GueryEProblemType getType();
	public java.util.Collection<org.qualitune.guery.resource.guery.IGueryQuickFix> getQuickFixes();
}
