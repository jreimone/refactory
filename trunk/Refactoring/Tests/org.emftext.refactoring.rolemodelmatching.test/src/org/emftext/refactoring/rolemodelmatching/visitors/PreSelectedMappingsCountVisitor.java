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

import java.util.concurrent.atomic.AtomicInteger;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;
import org.emftext.refactoring.rolemodelmatching.StringMappingNodeList;

public class PreSelectedMappingsCountVisitor implements INodeVisitor {

	private AtomicInteger preSelectedMappingsCount = new AtomicInteger();
	
	public void visit(StringMappingNode node, Object context) {
		StringMappingNodeList completeMapping = node.getListFromRoot();
		preSelectedMappingsCount.addAndGet(completeMapping.size());
	}

	public int getPreSelectedMappingsCount() {
		return preSelectedMappingsCount.intValue();
	}

}
