/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getMOVE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getSET(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getASSIGN(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getUPDATE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariable(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableAssignment(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getTRACE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getConstantsReference(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getFromClause(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getUPTREE(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getPATH(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getFIRST(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getLAST(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getConcreteIndex(),
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getIndexVariable(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification(),
		};
	}
	
}
