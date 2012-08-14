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

import java.util.HashSet;
import java.util.Set;

import org.emftext.refactoring.rolemodelmatching.RolemodelMatchingTestInitialization;
import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

/**
 * Collects all distinct mappings from role to a metaclass. Since a valid mapping,
 * such as e.g. Role1 -> Metaclass1, can be part of several complete role mappings
 * this mapping is collected only once by this visitor.
 * @author jreimann
 *
 */
public class CollectDistinctMappingsVisitor implements INodeVisitor {

	private Set<String> distinctNodeSet;
	
	public void visit(StringMappingNode node, Object context) {
		if(distinctNodeSet == null){
			distinctNodeSet = new HashSet<String>();
		}
		StringMappingNode parent = node;
		while (parent.getParent() != null) {
			if(parent.getMappingString().contains(RolemodelMatchingTestInitialization.ROLE_CONNECTOR)){
				distinctNodeSet.add(parent.getMappingString());
			}
			parent = parent.getParent();
		}
	}

	public Set<String> getDistinctNodeSet() {
		return distinctNodeSet;
	}

}
