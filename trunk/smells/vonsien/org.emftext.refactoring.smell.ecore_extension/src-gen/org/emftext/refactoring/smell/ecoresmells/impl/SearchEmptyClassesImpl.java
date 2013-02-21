/**
 */
package org.emftext.refactoring.smell.ecoresmells.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;
import org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage;
import org.emftext.refactoring.smell.ecoresmells.SearchEmptyClasses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Empty Classes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SearchEmptyClassesImpl extends MetricImpl implements SearchEmptyClasses {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchEmptyClassesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoresmellsPackage.Literals.SEARCH_EMPTY_CLASSES;
	}

	private List<EPackage> packages;

	@Override
	public String getName() {
		return "Empty Classes Count";
	}

	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines all EClasses having no attributes or operations";
	}

	@Override
	public String getSmellMessage() {
		return "This EClass has no attributes or operations.";
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
					if(((EClass) eo).getEAllAttributes().isEmpty() && ((EClass) eo).getEAllOperations().isEmpty()){
						result.getCausingObjects().add(eo);
					}
				}
			}
		}
		result.setResultingValue(result.getCausingObjects().size());
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
} //SearchEmptyClassesImpl
