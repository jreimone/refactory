/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.modelrefactoring.evolution.operators.EOperationQualifier;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;

public class EOperationQualifierOperationReferenceResolver implements IOperatorsReferenceResolver<EOperationQualifier, EOperation> {
	
//	private OperatorsDefaultResolverDelegate<EOperationQualifier, EOperation> delegate = new OperatorsDefaultResolverDelegate<EOperationQualifier, EOperation>();
	
	public void resolve(String identifier, EOperationQualifier qualifier, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EOperation> result) {
		Referrable queryObject = qualifier.getVariable().getQueryObject();
		if(queryObject == null){
			result.setErrorMessage("Owner of the operation '" + identifier + "' must be specified");
			return;
		}
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject operationOwner = OperatorsUtil.getEObjectFromReferrable(queryObject, errors);
		EClass metaclass = operationOwner.eClass();
		List<EOperation> allOperations = metaclass.getEAllOperations();
		for (EOperation operation : allOperations) {
			if(resolveFuzzy || identifier.equals(operation.getName())){
				result.addMapping(operation.getName(), operation);
			}
		}
	}
	
	public String deResolve(EOperation operation, EOperationQualifier container, EReference reference) {
		return operation.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
