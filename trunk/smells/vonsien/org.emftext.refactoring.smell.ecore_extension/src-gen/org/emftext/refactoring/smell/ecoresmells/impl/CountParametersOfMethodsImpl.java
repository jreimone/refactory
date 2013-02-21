/**
 */
package org.emftext.refactoring.smell.ecoresmells.impl;

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
import org.emftext.refactoring.smell.ecoresmells.CountParametersOfMethods;
import org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Count Parameters Of Methods</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CountParametersOfMethodsImpl extends MetricImpl implements CountParametersOfMethods {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountParametersOfMethodsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoresmellsPackage.Literals.COUNT_PARAMETERS_OF_METHODS;
	}

	private List<EPackage> packages;
//	private Float highNumberOfParameters = 8.0f;

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
	public CalculationResult calculate(EObject model, float threshold) {
		packages = new ArrayList<EPackage>();
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
						if(parameterCount >= threshold){
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
} //CountParametersOfMethodsImpl
