/**
 * 
 */
package org.emftext.refactoring.interpreter;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
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
	 * The <code>interpreter</code> is needed to determine if this refactoring run is a fake run
	 * for collecting all values that must be provided by the user.
	 * 
	 * @param interpreter the interpreter in which context this value will be provided
	 * @param from
	 * @return
	 */
	public ValueType provideValue(IRefactoringInterpreter interpreter, ValueFrom from, Object... context);
	
	/**
	 * Sometimes value providers provide the value by a dialog. Dialogs always have a return code.
	 * This code should be returned by implementors.
	 * 
	 * @return
	 */
	public int getReturnCode();
	
	/**
	 * Re-invokes the same value provider before the refactoring starts. With the copier the formerly 
	 * fake elements can be evaluated to its real elements.
	 * 
	 * @param copier
	 */
	public void provideValue(Map<EObject, EObject> inverseCopier);
	
	/**
	 * This method returns the fake object which was passed in the fake run to this value provider.
	 * It is needed to determine if values are included that aren't contained in the original real model.
	 * If that's the case this value provider can't be run before the real refactoring.
	 * 
	 * 
	 * @return
	 */
	public Object getFakeObject();
}
