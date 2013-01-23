package org.emftext.refactoring.smell.uml_extension;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

public class CountParametersOfMethods extends MetricImpl {
	
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
		return "Determines those methods having a parameter count greater than the given threshold";
	}

	@Override
	public String getSmellMessage() {
		return "This method has too many parameters.";
	}

	@Override
	public CalculationResult calculate(EObject model) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		result.setResultingValue(0);
		if(model == null || !(model instanceof Model)){
			return null;
		}
		Model umlModel = (Model) model;
		for (Element element : umlModel.allOwnedElements()) {
			if(element instanceof Classifier){
				Classifier classifier = (Classifier) element;
				List<Operation> operations = classifier.getOperations();
				for (Operation operation : operations) {
					int parameterCount = operation.getOwnedParameters().size();
					if(parameterCount >= getThreshold()){
						result.getCausingObjects().add(operation);
						if(parameterCount > result.getResultingValue()){
							result.setResultingValue(parameterCount);
						}
					}
				}
			}
		}
		return result;
	}
}
