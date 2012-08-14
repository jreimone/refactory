/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.interpreter;


/**
 * This interface represents a fake interpreter for a fake refactoring run. It can be used to
 * collect all values which have to be provided by the user before the real refactoring starts.
 * 
 * @author jreimann
 *
 */
public interface IRefactoringFakeInterpreter extends IRefactoringInterpreter {

//	/**
//	 * Returns the values that have to be provided by the real interpreter.
//	 * @return
//	 */
//	public List<IValueProvider<?, ?>> getValuesToProvide();
	
//	/**
//	 * Adds a new value provider
//	 * @param valueProvider
//	 */
//	public void addValueProvider(IValueProvider<?, ?> valueProvider);
	
	/**
	 * Returns the real interpreter of this fake interpreter
	 * @return
	 */
	public IRefactoringInterpreter getRealInterpreter();
	
//	/**
//	 * Use this method after analysing the collected value providers returned by {@link IRefactoringFakeInterpreter#getValuesToProvide()}.
//	 * Analyse the values if they really can be provided before the refactoring starts. That means that the 
//	 * elements for which a value must be provided must be all contained in the original model.  
//	 * 
//	 * @param provideableValues
//	 */
//	public void setProvideableValues(List<IValueProvider<?, ?>> provideableValues);
}
