/**
 * 
 */
package org.qualitune.evolution.operators.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.PrimitiveReference;
import org.qualitune.evolution.operators.QueryVariable;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.Result;
import org.qualitune.evolution.operators.TypeVariable;
import org.qualitune.evolution.operators.Variable;
import org.qualitune.evolution.operators.VariableReference;

/**
 * @author jreimann
 *
 */
public abstract class OperatorsUtil {

	/**
	 * Determines the {@link EObject} from the given <code>referrable</code>. If an error occurs
	 * it will be added to the given <code>errors</code> list.
	 * 
	 * @param referrable
	 * @param errors
	 * @return
	 */
	public static EObject getEObjectFromReferrable(Referrable referrable, List<Diagnostic> errors){
		EObject result = null;
		if(referrable instanceof EObjectReference){
			List<EObject> elements = ((EObjectReference) referrable).getElement();
			if(elements.size() != 1){
				errors.add(createDiagnostic(referrable, "The referenced parent must not be a multi-valued list"));
				return null;
			}
			result = elements.get(0);
		} else if(referrable instanceof VariableReference){
			Variable referencedVariable = ((VariableReference) referrable).getReferencedVariable();
			if(referencedVariable instanceof QueryVariable){
				Result queryResult = ((QueryVariable) referencedVariable).getQueryResult();
				if(queryResult instanceof EObjectReference){
					List<EObject> elements = ((EObjectReference) queryResult).getElement();
					if(elements.size() != 1){
						errors.add(createDiagnostic(referrable, "The referenced parent must not be a multi-valued list"));
						return null;
					}
					result = elements.get(0);
				} else if(queryResult instanceof PrimitiveReference){
					errors.add(createDiagnostic(referrable, "The referenced parent must not be a primitive type"));
					return null;
				}
			} else if(referencedVariable instanceof TypeVariable){
				result = ((TypeVariable) referencedVariable).getValue();
			}
		}
		return result;
	}

	/**
	 * Adds the given <code>error</code> to the resource of the given <code>element</code>.
	 * @param element
	 * @param error
	 * @return
	 */
	public static Resource addErrorToResourceOf(EObject element, Resource.Diagnostic error){
		Resource resource = element.eResource();
		if(resource != null){
			resource.getErrors().add(error);
		}
		return resource;
	}

	/**
	 * Registers the given <code>errors</code> in the resource for the given <code>element</code>.
	 * Returns the resource of the element or <code>null</code> if no resource exists.
	 * 
	 * @param element
	 * @param errors
	 * @return
	 */
	public static Resource addErrorsToResourceOf(EObject element, List<Diagnostic> errors){
		Resource resource = null;
		for (Diagnostic error : errors) {
			resource = addErrorToResourceOf(element, error);
		}
		return resource;
	}

	/**
	 * Creates a {@link Diagnostic} to the resource of the given <code>element</code> with the given
	 * <code>errorsMessage</code>. Returns <code>null</code> if the element has no resource.
	 * @param element
	 * @param errorMessage
	 * @return
	 */
	public static Resource.Diagnostic createDiagnostic(final EObject element, final String errorMessage){
		Resource.Diagnostic diagnostic = new Resource.Diagnostic() {

			@Override
			public String getMessage() {
				return errorMessage;
			}

			@Override
			public String getLocation() {
				Resource resource = element.eResource();
				if(resource != null){
					return resource.getURI().toString();
				}
				return "resource is null - URI cannot be returned";
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
		return diagnostic;
	}
	
	/**
	 * Creates an error and adds it to the resource.
	 * @param element
	 * @param errorMessage
	 * @return
	 */
	public static Resource createDiagnosticAndAddToResource(final EObject element, final String errorMessage){
		Diagnostic error = createDiagnostic(element, errorMessage);
		Resource resource = addErrorToResourceOf(element, error);
		return resource;
	}
}
