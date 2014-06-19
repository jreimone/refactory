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
package org.emftext.refactoring.ui.views.registry.model;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class TreeLeaf extends TreeObject {

	private RoleMapping mapping;

	public TreeLeaf(RoleMapping object) {
		super(object);
		this.mapping = object;
	}

	public boolean hasPostProcessorRegistered() {
		IRefactoringPostProcessor postProcessor = IRoleMappingRegistry.INSTANCE.getPostProcessor(mapping);
		if (postProcessor != null) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return mapping.getName();
	}
}