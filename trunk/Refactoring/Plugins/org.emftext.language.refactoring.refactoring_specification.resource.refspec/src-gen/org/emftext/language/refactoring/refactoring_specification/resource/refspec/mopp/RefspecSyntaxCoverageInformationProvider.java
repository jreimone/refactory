/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getMOVE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariable(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(),
		};
	}
	
}
