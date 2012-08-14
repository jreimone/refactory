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
package org.emftext.refactoring.indexconnector;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface for build up a connection to an Indexer such as Sokan or EMF Index.
 * 
 * @author Jan Reimann
 *
 */
public interface IndexConnector {
	
	/**
	 * Returns a list with all {@link Resource resources} referencing the given <code>referenceTarget</code>.
	 * @param referenceTarget TODO
	 * @return
	 */
	public List<Resource> getReferencingResources(EObject referenceTarget);
}
