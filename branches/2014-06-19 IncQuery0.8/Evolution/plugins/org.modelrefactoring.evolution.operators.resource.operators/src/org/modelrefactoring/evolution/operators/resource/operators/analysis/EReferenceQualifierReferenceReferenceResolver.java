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
import org.modelrefactoring.evolution.operators.EReferenceQualifier;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;

public class EReferenceQualifierReferenceReferenceResolver implements IOperatorsReferenceResolver<EReferenceQualifier, EReference> {
	
//	private OperatorsDefaultResolverDelegate<EReferenceQualifier, EReference> delegate = new OperatorsDefaultResolverDelegate<EReferenceQualifier, EReference>();
	
	public void resolve(String identifier, EReferenceQualifier qualifier, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EReference> result) {
		Referrable queryObject = qualifier.getVariable().getQueryObject();
		if(queryObject == null){
			result.setErrorMessage("Owner of the structural feature '" + identifier + "' must be specified");
			return;
		}
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject referenceOwner = OperatorsUtil.getEObjectFromReferrable(queryObject, errors);
		EClass metaclass = referenceOwner.eClass();
		List<EReference> allReferences = metaclass.getEAllReferences();
		for (EReference ownedReference : allReferences) {
			if(resolveFuzzy || identifier.equals(ownedReference.getName())){
				result.addMapping(ownedReference.getName(), ownedReference);
			}
		}
	}
	
	public String deResolve(EReference element, EReferenceQualifier container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
