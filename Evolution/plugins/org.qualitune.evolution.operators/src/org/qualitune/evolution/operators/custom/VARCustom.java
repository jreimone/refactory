package org.qualitune.evolution.operators.custom;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.EOperationQualifier;
import org.qualitune.evolution.operators.EStructuralFeatureQualifier;
import org.qualitune.evolution.operators.OperatorsFactory;
import org.qualitune.evolution.operators.QueryVariable;
import org.qualitune.evolution.operators.QueryVariableQualifier;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.Result;
import org.qualitune.evolution.operators.TypeVariable;
import org.qualitune.evolution.operators.Variable;
import org.qualitune.evolution.operators.VariableReference;
import org.qualitune.evolution.operators.impl.VARImpl;


public class VARCustom extends VARImpl {

	/**
	 * @model
	 */
	@Override
	public void execute() {
		QueryVariable queryVariable = getVariable();
		Referrable queryObject = queryVariable.getQueryObject();
		EObjectReference operatorResult = OperatorsFactory.eINSTANCE.createEObjectReference();
		setResult(operatorResult);
		queryVariable.setQueryResult(operatorResult);
		EObject contextObject = null;
		if(queryObject instanceof EObjectReference){
			EList<EObject> element = ((EObjectReference) queryObject).getElement();
			if(element != null && element.size() == 1){
				contextObject = element.get(0);
			}
		} else if(queryObject instanceof VariableReference){
			final Variable referencedVariable = ((VariableReference) queryObject).getReferencedVariable();
			if(referencedVariable instanceof TypeVariable){
				contextObject = ((TypeVariable) referencedVariable).getValue();
			} else if(referencedVariable instanceof QueryVariable){
				Result queryResult = ((QueryVariable) referencedVariable).getQueryResult();
				if(queryResult instanceof EObjectReference){
					EList<EObject> results = ((EObjectReference) queryResult).getElement();
					if(results != null && results.size() == 1){
						contextObject = results.get(0);
					} else {
						final Resource resource = this.eResource();
						if(resource != null){
							Resource.Diagnostic diagnostic = new Resource.Diagnostic() {
								
								@Override
								public String getMessage() {
									return "Variable " + referencedVariable.getName() + " refers to a list containing more than 1 elements";
								}
								
								@Override
								public String getLocation() {
									return resource.getURI().toString();
								}
								
								@Override
								public int getLine() {
									return 0;
								}
								
								@Override
								public int getColumn() {
									return 0;
								}
							};
							resource.getErrors().add(diagnostic);
						}
					}
				}
			}
		}
		QueryVariableQualifier qualifier = queryVariable.getQualifier();
		if(qualifier != null){
			if(qualifier instanceof EOperationQualifier){
				EOperation operation = ((EOperationQualifier) qualifier).getOperation();
				List<EParameter> parameters = operation.getEParameters();
				// only parameter-less operations are supported
				if(parameters == null || parameters.size() == 0){
					try {
						Object result = contextObject.eInvoke(operation, null);
						if(result instanceof EObject){
							EObject singleResult = (EObject) result;
							operatorResult.getElement().add(singleResult);
						} else if(result instanceof List<?>){
							List<?> resultList = (List<?>) result;
							List<EObject> eobjects = new BasicEList<EObject>();
							for (Object resultElement : resultList) {
								if(resultElement instanceof EObject){
									eobjects.add((EObject) resultElement);
								}
							}
							if(eobjects.size() == resultList.size()){
								operatorResult.getElement().addAll(eobjects);
							}
						}
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			} else if (qualifier instanceof EStructuralFeatureQualifier){
				EStructuralFeature structuralFeature = ((EStructuralFeatureQualifier) qualifier).getStructuralFeature();
				Object result = contextObject.eGet(structuralFeature, true);
				if(!structuralFeature.isMany()){
					EObject singleResult = (EObject) result;
					operatorResult.getElement().add(singleResult);
				} else {
					List<?> resultList = (List<?>) result;
					for (Object resultElement : resultList) {
						if(resultElement instanceof EObject){
							operatorResult.getElement().add((EObject) resultElement);
						}
					}
				}
			}
		}
		super.execute();
	}
}



