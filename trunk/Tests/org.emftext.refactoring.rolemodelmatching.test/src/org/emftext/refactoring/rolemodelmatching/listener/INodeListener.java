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
package org.emftext.refactoring.rolemodelmatching.listener;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

/**
 * Can be registered to nodes. But should only be registered to the root because
 * listeners will only be executed if a leaf is reached in the tree. In this case
 * the registered listeners from the root will be propagated to the leaf.
 * 
 * @author jreimann
 *
 */
public interface INodeListener {

	public void execute(MatchNode<?, ?> node);
	
	public MatchNode<?, ?> getSubject();
	
	public void setSubject(MatchNode<?, ?> subject);
}
