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
package org.emftext.refactoring.ui.views.registry.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.ui.views.registry.model.TreeLeaf;
import org.emftext.refactoring.ui.views.registry.model.TreeMetaModelParent;
import org.emftext.refactoring.ui.views.registry.model.TreeObject;
import org.emftext.refactoring.ui.views.registry.model.TreeParent;

/**
 * @author jreimann
 *
 */
public class UnregisterAction extends Action {
	
	private TreeViewer viewer;
	
	public UnregisterAction(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void run() {
		ISelection selection = viewer.getSelection();
		if(selection != null && selection instanceof IStructuredSelection){
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if(firstElement instanceof TreeMetaModelParent) {
				TreeMetaModelParent metamodelParent = (TreeMetaModelParent) firstElement;
				TreeObject[] children = metamodelParent.getChildren();
				for (TreeObject treeObject : children) {
					EObject object = treeObject.getObject();
					if(object instanceof RoleMapping){
						IRoleMappingRegistry.INSTANCE.unregisterRoleMapping((RoleMapping) object);
					}
				}
			} else if(firstElement instanceof TreeParent){
				TreeParent roleModelParent = (TreeParent) firstElement;
				EObject object = roleModelParent.getObject();
				if(object instanceof RoleModel){
					IRoleModelRegistry.INSTANCE.unregisterRoleModel((RoleModel) object);
				} 
			}else if(firstElement instanceof TreeLeaf){
				EObject object = ((TreeLeaf) firstElement).getObject();
				if(object instanceof RoleMapping){
					IRoleMappingRegistry.INSTANCE.unregisterRoleMapping((RoleMapping) object);
				}
			}
		}
	}
}