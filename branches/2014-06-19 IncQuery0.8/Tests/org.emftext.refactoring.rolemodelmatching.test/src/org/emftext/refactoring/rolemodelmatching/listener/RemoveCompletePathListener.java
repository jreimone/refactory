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

import java.util.Arrays;
import java.util.List;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

/**
 * This listener removes a complete path to save memory. Before removal
 * all passed other listeners will be removed.
 * 
 * @author jreimann
 *
 */
public class RemoveCompletePathListener extends SequenceListener {


	public RemoveCompletePathListener(INodeListener otherListener){
		super(Arrays.asList(new INodeListener[]{otherListener}));
	}
	
	/**
	 * Call this constructor to ensure that all <code>otherListeners</code> 
	 * are invoked before this listener is being invoked. This listener itself
	 * removes a complete path.
	 * 
	 * @param otherListeners
	 */
	public RemoveCompletePathListener(List<INodeListener> otherListeners) {
		super(otherListeners);
	}

	@Override
	public void executeAfterOthers(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		MatchNode<?, ?> child = node;
		while (parent.getParent() != null && (parent.getChildren().size() == 0 || parent.getChildren().size() == 1)) {
			child = parent;
			parent = parent.getParent();
		}
		parent.getChildren().remove(child);
	}


}
