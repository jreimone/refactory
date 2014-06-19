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
package org.emftext.refactoring.rolemodelmatching.visitors;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

/**
 * This interface is used to attach a visitor to the root {@link StringMappingNode} of
 * the matching tree being constructed from the persisted real matching tree.
 * If a leaf is reached while tree construction the {@link #visit(StringMappingNode)} method
 * is invoked. 
 * 
 * @author jreimann
 *
 */
public interface INodeVisitor {

	/**
	 * This method contains the implementation of the visitor which is being invoked on the
	 * given <code>node</code>.
	 * 
	 * @param node
	 */
	public void visit(StringMappingNode node, Object context);
}
