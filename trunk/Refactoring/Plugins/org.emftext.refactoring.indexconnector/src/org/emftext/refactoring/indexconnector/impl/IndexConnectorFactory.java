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
/**
 * 
 */
package org.emftext.refactoring.indexconnector.impl;

import org.emftext.refactoring.indexconnector.IndexConnector;

/**
 * Factory for {@link IndexConnector}s.
 * 
 * @author Jan Reimann
 *
 */
public interface IndexConnectorFactory {

	public static final IndexConnectorFactory defaultINSTANCE = new DefaultIndexConnectorFactory();
	
	/**
	 * Returns the specific {@link IndexConnector}.
	 * @return
	 */
	public IndexConnector getIndexConnector();
	
	/**
	 * Returns an instance of the given {@link IndexConnector} <code>clazz</code>
	 * @param clazz
	 * @return
	 */
	public IndexConnector getIndexConnector(Class<? extends IndexConnector> clazz);
}
