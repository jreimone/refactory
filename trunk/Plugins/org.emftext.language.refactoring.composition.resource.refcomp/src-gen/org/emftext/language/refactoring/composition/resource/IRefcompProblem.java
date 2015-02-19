/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource;

import java.util.Collection;

public interface IRefcompProblem {
	public String getMessage();
	public org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity getSeverity();
	public org.emftext.language.refactoring.composition.resource.RefcompEProblemType getType();
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> getQuickFixes();
}
