/**
 * 
 */
package org.emftext.refactoring.interpreter;

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
public interface IValueProvider <ValueFrom, ValueType>{

	/**
	 * With this method a concrete value for the given <code>from</code> will be provided.
	 * 
	 * @param from
	 * @return
	 */
	public ValueType provideValue(ValueFrom from);
	
	/**
	 * Sometimes value providers provide the value by a dialog. Dialogs always have a return code.
	 * This code should be returned by implementors.
	 * 
	 * @return
	 */
	public int getReturnCode();
}
