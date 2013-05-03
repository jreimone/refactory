/**
 */
package org.emftext.refactoring.smell.umlsmells.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

import org.emftext.refactoring.smell.umlsmells.SearchEmptyClassesAndInterfaces;
import org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Empty Classes And Interfaces</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SearchEmptyClassesAndInterfacesImpl extends MetricImpl implements SearchEmptyClassesAndInterfaces {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchEmptyClassesAndInterfacesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlsmellsPackage.Literals.SEARCH_EMPTY_CLASSES_AND_INTERFACES;
	}

	@Override
	public String getName() {
		return "Empty UML Classes Count";
	}

	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines all UML classes having no properties or operations.";
	}

	@Override
	public String getSmellMessage() {
		return "This UML class is empty has no properties or operations.";
	}

	@Override
	public CalculationResult calculate(EObject model, float threshold) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		result.setResultingValue(0);
		if(model == null || !(model instanceof Model)){
			return null;
		}
		Model umlModel = (Model) model;
		for (Element element : umlModel.allOwnedElements()) {
			if(element instanceof Classifier){
				Classifier classifier = (Classifier) element;
				if(classifier.getAllAttributes().isEmpty() && classifier.getAllOperations().isEmpty()){
					result.getCausingObjects().add(classifier);
				}
			}
		}
		result.setResultingValue(result.getCausingObjects().size());
		return result;
	}
} //SearchEmptyClassesAndInterfacesImpl
