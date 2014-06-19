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
package org.emftext.refactoring.indexconnector;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.indexconnector.impl.BasicIndexConnectorRegistry;

/**
 * This registry is used to register {@link IndexConnector connectors} which can be used for exampl to
 * find resources referencing a specific {@link EObject object}.
 * 
 * @author jreimann
 *
 */
public interface IndexConnectorRegistry {

	public static IndexConnectorRegistry INSTANCE = new BasicIndexConnectorRegistry();
	
	/**
	 * Returns all registered {@link IndexConnector connectors}.
	 * 
	 * @return
	 */
	public List<IndexConnector> getConnectors();
	
	/**
	 * Register a {@link IndexConnector connector} within the registry.
	 * 
	 * @param connector
	 */
	public void registerConnector(IndexConnector connector);
	
	/**
	 * Returns a list with all {@link Resource resources} referencing the given <code>referenceTarget</code>.
	 * @param referenceTarget
	 * @return
	 */
	public List<Resource> getReferencingResources(EObject referenceTarget);
}
