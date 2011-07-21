/**
 * 
 */
package org.emftext.refactoring.interpreter;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.swt.widgets.Composite;
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
	 * Use this method to set the value.
	 * 
	 * @param value
	 */
	public void setValue(ValueType value);
	
	/**
	 * This method just returns the previously provided value. Extenders must override this method 
	 * to provide the value which is internally computed within this {@link Composite}.
	 * 
	 * @return
	 */
	public ValueType getValue();
	
	/**
	 * Sometimes value providers provide the value by a dialog. Dialogs always have a return code.
	 * This code should be returned by implementors.
	 * 
	 * @return
	 */
	public int getReturnCode();
	
	/**
	 * Re-invokes the same value provider before the refactoring starts. Internally {@link IValueProvider#getInverseCopier()}
	 * should be used to resolve the fake objects to the original objects.
	 * @param copier
	 */
	public void provideValue();
	
	/**
	 * This method returns the fake object which was passed in the fake run to this value provider.
	 * It is needed to determine if values are included that aren't contained in the original real model.
	 * If that's the case this value provider can't be run before the real refactoring.
	 * 
	 * 
	 * @return
	 */
	public Object getFakeObject();
	
	/**
	 * Returns a user readable name of this value provider.
	 * @return
	 */
	public String getName();
	
	public void setName(String name);
	
	/**
	 * This method can be used to set the copier with which copies of the original objects have been created.
	 * 
	 * @param copier
	 */
	public void setCopier(Copier copier);
	
	/**
	 * This method returns the copier
	 * @return
	 */
	public Copier getCopier();
	
	/**
	 * This method returns the inverse copier with which the fake objects can be resolved to its original ones.
	 * Implementors must assure that this method returns the inverse map of {@link IValueProvider#getCopier()}.
	 * 
	 * @return
	 */
	public Map<EObject, EObject> getInverseCopier();
	
	/**
	 * Return the composite which will presented to the user to provide this value.
	 * @return
	 */
	public Composite getProvidingComposite();
	
	/**
	 * For the creation of a comparison between original and fake refactored model,
	 * the values, provided by the user, must be propagated to the fake object,
	 * for the adequate presentation in the comparison. This propagation will be invoked 
	 * with this method.
	 * 
	 */
	public void propagateValueToFakeObject();
	
	/**
	 * In more intensive value providers it can be necessary that formerely computed values are
	 * accessable for the propagation of the made input to the fake object. With this method
	 * those context objects can be passed.
	 * 
	 * @param context
	 */
	public void setFakePropagationContext(Object... context);
}
