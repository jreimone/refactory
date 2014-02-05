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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.modelrefactoring.evolution.operators.CREATE;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;

public class CREATEParentCompositeReferenceReferenceResolver implements IOperatorsReferenceResolver<CREATE, EReference> {
	
//	private OperatorsDefaultResolverDelegate<CREATE, EReference> delegate = new OperatorsDefaultResolverDelegate<CREATE, EReference>();
	
	public void resolve(String identifier, CREATE container, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EReference> result) {
		Referrable referrable = container.getParent();
		if(referrable == null){
			result.setErrorMessage("Parent of the new element must be specified");
			return;
		}
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject parent = OperatorsUtil.getEObjectFromReferrable(referrable, errors);
		EClass metaclass = parent.eClass();
		List<EReference> allContainments = metaclass.getEAllContainments();
		for (EReference eReference : allContainments) {
			if(resolveFuzzy || identifier.equals(eReference.getName())){
				result.addMapping(eReference.getName(), eReference);
			}
		}
	}
	
	public String deResolve(EReference element, CREATE container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
