/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.eclipse.emf.ecore.EClass;

public class CoedSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(),
			org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getPlainCondition(),
			org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent(),
			org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition(),
		};
	}
	
}
