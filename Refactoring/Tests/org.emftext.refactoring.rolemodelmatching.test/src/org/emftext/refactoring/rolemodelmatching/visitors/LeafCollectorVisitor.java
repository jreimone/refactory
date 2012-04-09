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

import java.util.ArrayList;
import java.util.List;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

public class LeafCollectorVisitor implements INodeVisitor {

	private List<StringMappingNode> leafList;

	public void visit(StringMappingNode node, Object context) {
		if(leafList == null){
			leafList = new ArrayList<StringMappingNode>();
		}
		leafList.add(node);
	}

	public List<StringMappingNode> getLeafList() {
		return leafList;
	}

}
