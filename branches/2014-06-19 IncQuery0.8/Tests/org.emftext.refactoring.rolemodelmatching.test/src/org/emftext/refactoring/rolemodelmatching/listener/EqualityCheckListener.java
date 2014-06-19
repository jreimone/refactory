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

import java.util.Set;
import static org.junit.Assert.*;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class EqualityCheckListener extends AbstractNodeListener {

	private Set<MatchNode<?, ?>> nodeSet;
	
	public EqualityCheckListener(Set<MatchNode<?, ?>> nodeSet) {
		super();
		this.nodeSet = nodeSet;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		assertNotNull("Set mustn't be null", nodeSet);
		boolean notExisted = nodeSet.add(node);
		assertTrue("This mapping has already been matched", notExisted);
	}

}
