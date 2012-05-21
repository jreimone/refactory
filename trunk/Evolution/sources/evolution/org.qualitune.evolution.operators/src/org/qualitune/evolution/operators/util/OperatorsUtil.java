/**
 * 
 */
package org.qualitune.evolution.operators.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author jreimann
 *
 */
public abstract class OperatorsUtil {

	/**
	 * Creates and {@link Diagnostic} to the resource of the given <code>element</code> with the given
	 * <code>errorsMessage</code>.
	 * @param element
	 * @param errorMessage
	 * @return
	 */
	public static Resource.Diagnostic addErrorToResourceOf(EObject element, final String errorMessage){
		final Resource resource = element.eResource();
		if(resource != null){
			Resource.Diagnostic diagnostic = new Resource.Diagnostic() {

				@Override
				public String getMessage() {
					return errorMessage;
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
			return diagnostic;
		}
		return null;
	}
}
