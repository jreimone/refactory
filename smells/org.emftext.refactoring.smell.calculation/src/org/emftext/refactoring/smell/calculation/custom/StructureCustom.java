package org.emftext.refactoring.smell.calculation.custom;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.StructureImpl;


public class StructureCustom extends StructureImpl {
	
	public StructureCustom(){
		setMonotonicity(Monotonicity.DECREASING);
	}
	
	public CalculationResult calculate(EObject model, float threshold){
		return null;
	}
}