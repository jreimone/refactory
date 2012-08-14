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

public class MatchCountListener extends AbstractNodeListener {

	private AtomicInteger count;
	private RoleModel rolemodel;
	private EPackage metamodel;
	
	public MatchCountListener(AtomicInteger count, RoleModel rolemodel, EPackage metamodel) {
		super();
		this.count = count;
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
	}

	public void execute(MatchNode<?, ?> node) {
		count.incrementAndGet();
	}

	public void printCount(){
		System.out.println(rolemodel.getName() + " --> " + metamodel.getNsURI() + " mapped: " + count.get());
	}
	
	public AtomicInteger getCount(){
		return count;
	}
}
