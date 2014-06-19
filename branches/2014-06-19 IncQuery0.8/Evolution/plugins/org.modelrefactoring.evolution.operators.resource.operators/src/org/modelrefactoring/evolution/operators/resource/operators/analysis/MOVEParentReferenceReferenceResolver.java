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
import org.modelrefactoring.evolution.operators.MOVE;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;

public class MOVEParentReferenceReferenceResolver implements IOperatorsReferenceResolver<MOVE, EReference> {
	
//	private OperatorsDefaultResolverDelegate<MOVE, EReference> delegate = new OperatorsDefaultResolverDelegate<MOVE, EReference>();
	
	public void resolve(String identifier, MOVE move, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EReference> result) {
		Referrable newParentReferrable = move.getNewParent();
		if(newParentReferrable == null){
			result.setErrorMessage("The new parent must be specified");
			return;
		}
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject newParent = OperatorsUtil.getEObjectFromReferrable(newParentReferrable, errors);
		EClass metaclass = newParent.eClass();
		List<EReference> allReferences = metaclass.getEAllReferences();
		for (EReference ownedReference : allReferences) {
			if(resolveFuzzy || identifier.equals(ownedReference.getName())){
				result.addMapping(ownedReference.getName(), ownedReference);
			}
		}
	}
	
	public String deResolve(EReference element, MOVE container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
