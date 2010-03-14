/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.ecore.EAttribute;
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
public interface IAttributeValueProvider {

	/**
	 * With this method a concrete value for the given <code>attribute</code> will be provided.
	 * 
	 * @param attribute
	 * @return
	 */
	public Object provideAttributeValue(EAttribute attribute);
}
