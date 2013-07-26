/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GuerySyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotif(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getPreProcessor(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getVertexSelection(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getRole(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConstraint(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnectedBy(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getNotConnectedBy(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getConnection(),
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getGrouping(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.modelrefactoring.guery.GueryPackage.eINSTANCE.getMotifModel(),
		};
	}
	
}
