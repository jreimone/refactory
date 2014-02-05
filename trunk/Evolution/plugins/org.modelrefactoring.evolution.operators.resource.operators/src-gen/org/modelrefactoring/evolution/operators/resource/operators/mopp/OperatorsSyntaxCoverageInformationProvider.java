/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.eclipse.emf.ecore.EClass;

public class OperatorsSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVariableReference(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getQueryVariable(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEReferenceQualifier(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEOperationQualifier(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR(),
		};
	}
	
}
