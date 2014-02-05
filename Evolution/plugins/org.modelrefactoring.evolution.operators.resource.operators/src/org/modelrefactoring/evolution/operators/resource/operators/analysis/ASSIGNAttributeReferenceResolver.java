/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.modelrefactoring.evolution.operators.ASSIGN;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;

public class ASSIGNAttributeReferenceResolver implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.ASSIGN, org.eclipse.emf.ecore.EAttribute> {
	
//	private OperatorsDefaultResolverDelegate<ASSIGN, EAttribute> delegate = new OperatorsDefaultResolverDelegate<ASSIGN, EAttribute>();
	
	public void resolve(String identifier, ASSIGN container, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EAttribute> result) {
		Referrable referrable = container.getAttributeOwner();
		if(referrable == null){
			result.setErrorMessage("Owner of the attribute must be specified");
			return;
		}
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject attributeOwner = OperatorsUtil.getEObjectFromReferrable(referrable, errors);
		EClass metaclass = attributeOwner.eClass();
		List<EAttribute> allAttributes = metaclass.getEAllAttributes();
		for (EAttribute attribute : allAttributes) {
			if(resolveFuzzy || identifier.equals(attribute.getName())){
				result.addMapping(attribute.getName(), attribute);
			}
		}
	}
	
	public String deResolve(EAttribute attribute, ASSIGN container, EReference reference) {
		return attribute.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
