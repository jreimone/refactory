package org.emftext.refactoring.smell.ecore_extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;



public class CountParametersOfMethods extends MetricImpl {
	
	private List<EPackage> packages;
//	private Float highNumberOfParameters = 8.0f;

	public CountParametersOfMethods() {
		packages = new ArrayList<EPackage>();
	}

	@Override
	public String getName() {
		return "Parameters Of Methods Count";
	}

	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines those EOperations having a parameter count greater than the given threshold";
	}

	@Override
	public String getSmellMessage() {
		return "This EOperation has too many parameters.";
	}
	
	@Override
	public CalculationResult calculate(EObject model) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		result.setResultingValue(0);
		if(model == null || !(model instanceof EPackage)){
			return null;
		}
		EPackage epackage = (EPackage) model;
		// from here from cvonsien
		packages.add(epackage);
		walkPackages(epackage.getESubpackages());
		for (EPackage ep : packages) {
			List<EObject> contents = ep.eContents();
			for (EObject eo : contents) {
				if (eo instanceof EClass) {
					for (EOperation eop : ((EClass) eo).getEAllOperations()){
						int parameterCount = eop.getEParameters().size();
						if(parameterCount >= getThreshold()){
							result.getCausingObjects().add(eop);
							if(parameterCount > result.getResultingValue()) {
								// returns the highest parameter count
								result.setResultingValue(parameterCount);
							}
						}
					}
				}
			}
		}
		return result;
	}

	private void walkPackages(List<EPackage> subPackages){
		for (EPackage epackage : subPackages) {
			if (epackage.getESubpackages() != null){
				walkPackages(epackage.getESubpackages());
			}
			packages.add(epackage);
		}
	}
}