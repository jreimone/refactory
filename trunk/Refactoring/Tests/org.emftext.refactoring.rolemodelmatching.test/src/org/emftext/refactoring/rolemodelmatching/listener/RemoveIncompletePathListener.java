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

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class RemoveIncompletePathListener extends AbstractNodeListener implements IIncompleteNodeListener {

	private AtomicInteger incompleteCount;
	private RoleModel rolemodel;
	private EPackage metamodel;
	
	public RemoveIncompletePathListener(AtomicInteger incompleteCount, RoleModel rolemodel, EPackage metamodel){
		this.incompleteCount = incompleteCount;
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
	}
	
	@Override
	public void execute(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		MatchNode<?, ?> child = node;
		while (parent.getParent() != null && (parent.getChildren().size() == 0 || parent.getChildren().size() == 1)) {
			child = parent;
			parent = parent.getParent();
		}
		parent.getChildren().remove(child);
		incompleteCount.incrementAndGet();
	}
	
	public void printIncompleteRemovals(){
		System.out.println(rolemodel.getName() + " --> " + metamodel.getNsURI() + " removed incomplete tree paths: " + incompleteCount.get());
	}
}
