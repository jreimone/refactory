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
package org.emftext.refactoring.registry.rolemapping;

import java.net.URL;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This interface can be used to provide an interpreter for constraints. 
 * 
 * @author jreimann
 *
 */
public interface IConstraintInterpreter {

	/**
	 * Determines if the given <code>constraint</code> can be interpreted by this interpreter.
	 * 
	 * @param constraint
	 * @return
	 */
	public boolean canInterprete(Object constraint);
	
	/**
	 * Interpretes the given <code>constraint</code> for the given <code>model</code> and returns an interpretation result.
	 * The given <code>mmResource</code> represents the resource which contains the metamodel of the <code>model</code>.
	 * 
	 * @param constraint
	 * @param errorMessage
	 * @return
	 */
	public IInterpretationResult interpreteConstraint(Object constraint, String errorMessage, EObject model, Resource mmResource);
	
	/**
	 * Determines all constraints in the given <code>constraintFile</code> for the metamodel contained in <code>mmResource</code>. Returns a map containing
	 * the name of a constraint as key and the constraint itself as value or <code>null</code> if the
	 * constraintFile cannot be parsed by this interpreter.
	 * 
	 * @param constraintFile
	 * @param mmResource
	 * @return
	 */
	public Map<String, Object> getConstraints(URL constraintFile, Resource mmResource);
}
