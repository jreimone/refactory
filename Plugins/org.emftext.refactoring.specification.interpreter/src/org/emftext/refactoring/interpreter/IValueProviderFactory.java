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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * This factory interface is used to provide concrete {@link IValueProvider}s. They might
 * be different when running in a dedicated Eclipse instance or as JUnit tests. 
 * 
 * @author jreimann
 *
 */
public interface IValueProviderFactory {

	/**
	 * Returns the appropriate {@link IValueProvider} for the given command
	 * or creates a new one if none was created for the given command yet.
	 * 
	 * @param command
	 * @param context some arbitrary context objects which can be analysed in this factory
	 * @return
	 */
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context);
	
	/**
	 * Registers another <code>valueProvider</code> for the given <code>command</code>.
	 * @param command
	 * @param valueProvider
	 */
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider);
	
	/**
	 * Registers a new value provider for the given <code>command</code>.
	 * @param command
	 * @param context some optional context objects which can be used for further analysis (e.g. a role)
	 * @return the value provider
	 */
	public IValueProvider<?, ?> registerValueProviderForCommand(EObject command, Object... context);
	
	/**
	 * Returns all collected {@link IValueProvider}s. Implementors should check
	 * if the values are really providable in terms of being contained in the
	 * original model.
	 * 
	 * @return
	 */
	public List<IValueProvider<?, ?>> getValuesToProvide();
}
