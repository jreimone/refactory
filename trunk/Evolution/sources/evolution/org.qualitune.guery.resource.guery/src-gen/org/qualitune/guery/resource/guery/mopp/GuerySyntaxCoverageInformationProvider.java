/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GuerySyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getMotif(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getPreProcessor(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getVertexSelection(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getRole(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getConstraint(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getConnectedBy(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getNotConnectedBy(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getConnection(),
			org.qualitune.guery.GueryPackage.eINSTANCE.getGrouping(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.qualitune.guery.GueryPackage.eINSTANCE.getMotifModel(),
		};
	}
	
}
