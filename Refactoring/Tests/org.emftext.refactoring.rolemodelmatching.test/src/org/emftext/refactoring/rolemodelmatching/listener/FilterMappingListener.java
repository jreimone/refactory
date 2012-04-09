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
import org.emftext.refactoring.rolemodelmatching.RoleNode;

/**
 * This listener checks if a path contains a given mapping passed to the constructor.
 * If this is not the case this path won't be counted. By this a filter is realized
 * to determine how much matches reside if one mapping is pre-selected (maybe by the user). 
 * 
 * @author jreimann
 *
 */
public class FilterMappingListener extends AbstractNodeListener {

	private RoleNode filterMapping;
	private AtomicInteger filterCount;
	private RoleModel rolemodel;
	private EPackage metamodel;
	
	public RoleModel getRolemodel() {
		return rolemodel;
	}

	public EPackage getMetamodel() {
		return metamodel;
	}

	public FilterMappingListener(RoleNode filterMapping, AtomicInteger filterCount, RoleModel rolemodel, EPackage metamodel) {
		super();
		this.filterMapping = filterMapping;
		this.filterCount = filterCount;
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		while (parent.getRolemodel() == null && parent.getMetamodel() == null) {
			if(parent instanceof RoleNode){
				if(parent.equalsNode(filterMapping)){
					filterCount.incrementAndGet();
					break;
				}
			}
			parent = parent.getParent();
		}
	}

	public void printFilteredMatches(){
		StringBuffer buffer = new StringBuffer(getFilteredMatchesString());
		System.out.println(buffer.toString());
	}

	public StringBuffer getFilteredMatchesString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(filterMapping.getRoleElement().getName() + " --> " + filterMapping.getMetaElement().getName() + ": ");
		buffer.append(filterCount.get());
		return buffer;
	}
}
