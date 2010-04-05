package org.emftext.refactoring.interpreter;

import java.util.List;

/**
 * This interface represents a fake interpreter for a fake refactoring run. It can be used to
 * collect all values which have to be provided by the user before the real refactoring starts.
 * 
 * @author jreimann
 *
 */
public interface IRefactoringFakeInterpreter extends IRefactoringInterpreter {

	/**
	 * Returns the values that have to be provided by the real interpreter.
	 * @return
	 */
	public List<IValueProvider<?, ?>> getValuesToProvide();
	
	/**
	 * Adds a new value provider
	 * @param valueProvider
	 */
	public void addValueProvider(IValueProvider<?, ?> valueProvider);
	
	/**
	 * Returns the real interpreter of this fake interpreter
	 * @return
	 */
	public IRefactoringInterpreter getRealInterpreter();
	
	/**
	 * Use this method after analysing the collected value providers returned by {@link IRefactoringFakeInterpreter#getValuesToProvide()}.
	 * Analyse the values if they really can be provided before the refactoring starts. That means that the 
	 * elements for which a value must be provided must be all contained in the original model.  
	 * 
	 * @param provideableValues
	 */
	public void setProvideableValues(List<IValueProvider<?, ?>> provideableValues);
}
