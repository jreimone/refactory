package org.emftext.refactoring.smell.ecore_extension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

public class CompareNamesOfClasses extends MetricImpl {
	
	private List<EPackage> packages;
	
	public CompareNamesOfClasses(){
		packages = new ArrayList<EPackage>();
	}

	@Override
	public String getName() {
		return "EClassifiers with same name count";
	}
	
	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines all EClassifiers having the same name.";
	}

	@Override
	public String getSmellMessage() {
		return "This EClassifier has the same name as another one.";
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
		Set<EClassifier> classifiersWithSameName = new HashSet<>();
		for (EPackage p : packages) {
			for (EClassifier c : p.getEClassifiers()){
				for (EPackage p2 : packages) {
					for (EClassifier c2 : p2.getEClassifiers()){
						if (!p.equals(p2) && !c.equals(c2) && c.getName().equals(c2.getName())){
							classifiersWithSameName.add(c2);
							classifiersWithSameName.add(c);
						}
					}
				}
			}
		}
		result.getCausingObjects().addAll(classifiersWithSameName);
		// means: classes with same name --> if only one is contained in the result it's OK, because no other
		// class has the same name --> threshold must be set to 2 at least
		result.setResultingValue(classifiersWithSameName.size() + 1);
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
