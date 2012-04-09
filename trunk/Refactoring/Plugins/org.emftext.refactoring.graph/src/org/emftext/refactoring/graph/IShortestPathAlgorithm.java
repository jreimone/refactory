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
package org.emftext.refactoring.graph;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.graph.util.IPath;


/**
 * Interface for implementations for algorithms of shortest path calculation for metamodels.
 * 
 * @author Jan
 *
 */
public interface IShortestPathAlgorithm {
	
	/**
	 * Calculates all paths in the metamodel from source to target. Internally the EClasses of the given source and target
	 * EObject's are considered. If there is only one path this method returns a list of cardinality 1.
	 * 
	 * @param source source node in the model to calculate the path from
	 * @param target target node in the model to calculate the path to
	 * @return a list of paths from source to target
	 */
	public List<IPath> calculatePaths(EObject source, EObject target);

	/**
	 * @param output the output to set
	 */
	public void setOutput(boolean output);
}
