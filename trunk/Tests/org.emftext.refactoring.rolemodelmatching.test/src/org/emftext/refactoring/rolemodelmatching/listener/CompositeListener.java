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

public abstract class CompositeListener extends AbstractNodeListener {

	private List<INodeListener> otherListeners;
	
	public List<INodeListener> getOtherListeners() {
		return otherListeners;
	}

	public CompositeListener(List<INodeListener> otherListeners){
		this.otherListeners = otherListeners;
		for (INodeListener listener : otherListeners) {
			// to ensure that listeners are not executed twice
			if(listener.getSubject() != null){
				listener.getSubject().getListener().remove(listener);
			}
		}
	}
	
	public abstract void execute(MatchNode<?, ?> node);

}
