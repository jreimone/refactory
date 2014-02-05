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
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.SET;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;

public class SETReferenceReferenceResolver implements IOperatorsReferenceResolver<SET, EReference> {
	
//	private OperatorsDefaultResolverDelegate<SET, EReference> delegate = new OperatorsDefaultResolverDelegate<SET, EReference>();
	
	public void resolve(String identifier, SET set, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EReference> result) {
		Referrable referenceOwnerReferrable = set.getReferenceOwner();
		if(referenceOwnerReferrable == null){
			result.setErrorMessage("The parent must be specified");
			return;
		}
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject referenceOwner = OperatorsUtil.getEObjectFromReferrable(referenceOwnerReferrable, errors);
		EClass metaclass = referenceOwner.eClass();
		List<EReference> allReferences = metaclass.getEAllReferences();
		for (EReference ownedReference : allReferences) {
			if(resolveFuzzy || identifier.equals(ownedReference.getName())){
				result.addMapping(ownedReference.getName(), ownedReference);
			}
		}
	}
	
	public String deResolve(EReference element, SET container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
