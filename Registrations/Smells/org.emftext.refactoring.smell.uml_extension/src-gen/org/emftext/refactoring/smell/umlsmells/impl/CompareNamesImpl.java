/**
 */
package org.emftext.refactoring.smell.umlsmells.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

import org.emftext.refactoring.smell.umlsmells.CompareNames;
import org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compare Names</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CompareNamesImpl extends MetricImpl implements CompareNames {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareNamesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlsmellsPackage.Literals.COMPARE_NAMES;
	}

	@Override
	public String getName() {
		return "UML Classes with same names count";
	}

	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return super.getDescription();
	}

	@Override
	public String getSmellMessage() {
		return "This UML class has the same name like another one.";
	}

	@Override
	public CalculationResult calculate(EObject model, float threshold) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		result.setResultingValue(0);
		if(model == null || !(model instanceof Model)){
			return null;
		}
		Model umlModel = (Model) model;
		Map<String, Set<Classifier>> allNames = new HashMap<String, Set<Classifier>>();
		for (Element element : umlModel.allOwnedElements()) {
			if(element instanceof Classifier){
				Classifier classifier = (Classifier) element;
				if(!allNames.containsKey(classifier.getName())){
					allNames.put(classifier.getName(), new HashSet<Classifier>());
				}
				allNames.get(classifier.getName()).add(classifier);
			}
		}
		for (String name : allNames.keySet()) {
			Set<Classifier> equalNamedClassifiers = allNames.get(name);
			if(equalNamedClassifiers.size() > 1){
				result.getCausingObjects().addAll(equalNamedClassifiers);
			}
		}
		result.setResultingValue(result.getCausingObjects().size());
		return result;
	}
} //CompareNamesImpl
