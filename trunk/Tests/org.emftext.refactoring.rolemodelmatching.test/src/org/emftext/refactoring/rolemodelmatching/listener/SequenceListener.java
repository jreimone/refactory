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

import java.util.List;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

/**
 * First execute the listeners passed to the constructor and then execute this listener.  
 * 
 * @author jreimann
 *
 */
public abstract class SequenceListener extends CompositeListener {

	public SequenceListener(List<INodeListener> otherListeners) {
		super(otherListeners);
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		for (INodeListener listener : getOtherListeners()) {
			listener.execute(node);
		}
		executeAfterOthers(node);
	}

	public abstract void executeAfterOthers(MatchNode<?, ?> node);
}
