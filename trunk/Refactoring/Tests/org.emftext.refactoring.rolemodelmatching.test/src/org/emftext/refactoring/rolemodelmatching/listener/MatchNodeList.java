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

import java.util.LinkedList;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class MatchNodeList extends LinkedList<MatchNode<?, ?>> {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean remove(Object o) {
		if(!(o instanceof MatchNode<?, ?>)){
			return false;
		}
		MatchNode<?, ?> node = (MatchNode<?, ?>) o;
		for (int i = 0; i < this.size(); i++) {
			MatchNode<?, ?> other = get(i);
			if(other.equalsNode(node)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object o) {
		if(!(o instanceof MatchNode<?, ?>)){
			return -1;
		}
		MatchNode<?, ?> node = (MatchNode<?, ?>) o;
		for (int i = 0; i < this.size(); i++) {
			MatchNode<?, ?> other = get(i);
			if(other.equalsNode(node)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if(!(o instanceof MatchNode<?, ?>)){
			return -1;
		}
		MatchNode<?, ?> node = (MatchNode<?, ?>) o;
		int index = -1;
		for (int i = 0; i < this.size(); i++) {
			MatchNode<?, ?> other = get(i);
			if(other.equalsNode(node)){
				if(i > index){
					index = i;
				}
			}
		}
		return index;
	}

	
}
