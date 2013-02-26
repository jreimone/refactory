/**
 */
package org.emftext.refactoring.smell.ecoresmells.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;
import org.emftext.refactoring.smell.ecoresmells.CompareNamesOfClasses;
import org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compare Names Of Classes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CompareNamesOfClassesImpl extends MetricImpl implements CompareNamesOfClasses {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareNamesOfClassesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoresmellsPackage.Literals.COMPARE_NAMES_OF_CLASSES;
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
	public CalculationResult calculate(EObject model, float threshold) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		result.setResultingValue(0);
		if(model == null || !(model instanceof EPackage)){
			return null;
		}
		EPackage epackage = (EPackage) model;
		List<EClassifier> metaclasses = new ArrayList<>();
		walkPackages(epackage, metaclasses);
		Map<String, List<EClassifier>> classifiersWithSameName = new HashMap<>();
		for (EClassifier classifier : metaclasses) {
			List<EClassifier> list = classifiersWithSameName.get(classifier.getName());
			if(list == null){
				list = new ArrayList<>();
				classifiersWithSameName.put(classifier.getName(), list);
			}
			list.add(classifier);
		}
		for (List<EClassifier> list : classifiersWithSameName.values()) {
			if(list.size() > 1){
				result.getCausingObjects().addAll(list);
			}
		}
		// means: classes with same name --> if only one is contained in the result it's OK, because no other
		// class has the same name --> threshold must be set to 2 at least
		result.setResultingValue(result.getCausingObjects().size());
		return result;
	}
	
	private void walkPackages(EPackage epackage, List<EClassifier> metaclasses) {
		metaclasses.addAll(epackage.getEClassifiers());
		List<EPackage> subpackages = epackage.getESubpackages();
		for (EPackage subPackage : subpackages) {
			walkPackages(subPackage, metaclasses);
		}
	}
} //CompareNamesOfClassesImpl
