/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import org.eclipse.emf.ecore.EClass;

public class RefcompSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping(),
			org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping(),
			org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping(),
		};
	}
	
}
