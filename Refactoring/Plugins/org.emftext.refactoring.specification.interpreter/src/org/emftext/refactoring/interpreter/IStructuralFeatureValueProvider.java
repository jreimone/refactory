/**
 * 
 */
package org.emftext.refactoring.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.refactoring.interpreter.internal.ASSIGNInterpreter;

/**
 * Interface for implementations providing values for attributes. It is needed to not ask for the values
 * in dialog when running the interpreter in a JUnit test. Therefore the internal package org.emftext.refactoring.interpreter.internal
 * has one plugin as friend defined: org.emftext.refactoring.tests
 * By this only the test plugin can invoke the static method {@link ASSIGNInterpreter#setValueProvider(Class)}
 * 
 * @author Jan Reimann
 *
 */
public interface IStructuralFeatureValueProvider {

	/**
	 * With this method a concrete value for the given <code>structuralFeature</code> will be provided.
	 * 
	 * @param structuralFeature
	 * @return
	 */
	public Object provideValue(EStructuralFeature structuralFeature);
	
	/**
	 * This method can be used to provide one value out of the given <code>elements</code>.
	 * 
	 * @param elements
	 * @return
	 */
	public EObject provideValue(List<EObject> elements);
}
