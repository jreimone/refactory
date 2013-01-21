package org.emftext.refactoring.smell.ecore_extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

public class CheckInterfaceSpecifications extends MetricImpl {
	
	private List<EPackage> packages;

	public CheckInterfaceSpecifications() {
		packages = new ArrayList<EPackage>();
	}

	@Override
	public String getName() {
		return "Interfaces Without Specifications Count";
	}

	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines all interfaces in each EPackage having no implementing subclasses.";
	}

	@Override
	public String getSmellMessage() {
		return "This EClass being an interface has no implementing classes in this model.";
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
		if (epackage != null){
			packages.add(epackage);
			walkPackages(epackage.getESubpackages());
			for (EPackage ep : packages) {
				List<EObject> contents = ep.eContents();
				for (EObject eo : contents) {
					if (eo instanceof EClass) {
						if (((EClass) eo).isInterface()){
							boolean hasNoSpecification = true;
							for (EPackage ep2 : packages){
								List<EObject> contents2 = ep2.eContents();
								for (EObject eo2: contents2) {
									if (eo2 instanceof EClass) {
										if (((EClass) eo).isSuperTypeOf((EClass)eo2) && !(eo.equals(eo2))){
											hasNoSpecification = false;
											break;
										}
									}
								}
							}
							if (hasNoSpecification){
								result.getCausingObjects().add(eo);
								result.setResultingValue(result.getResultingValue() + 1);
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
