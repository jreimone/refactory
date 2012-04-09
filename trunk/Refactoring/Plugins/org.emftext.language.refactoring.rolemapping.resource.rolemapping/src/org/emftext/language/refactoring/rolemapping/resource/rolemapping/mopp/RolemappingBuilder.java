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
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingBuilder;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.RolemappingEProblemType;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class RolemappingBuilder implements IRolemappingBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource != null && (resource.getErrors() == null || resource.getErrors().size() == 0)){
			EObject root = resource.getContents().get(0);
			if(root instanceof RoleMappingModel){
				RoleMappingModel model = (RoleMappingModel) root;
				List<RoleMapping> mappings = model.getMappings();
				String uriString = model.getTargetMetamodel().getNsURI();
				Map<String,RoleMapping> registeredMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(uriString);
				if(registeredMappings == null || registeredMappings.size() == 0){
					return true;
				} else {
					for (RoleMapping mapping : mappings) {
						RoleMapping registeredMapping = registeredMappings.get(mapping.getName());
						if(registeredMapping == null){
							return true;
						}
						if(registeredMapping.eResource().getURI().equals(resource.getURI())){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public IStatus build(RolemappingResource resource, IProgressMonitor monitor) {
		RoleMappingModel model = (RoleMappingModel) resource.getContents().get(0);
		if((resource.getErrors() == null || resource.getErrors().size() == 0)){
			List<RoleMapping> unRegisterables = IRoleMappingRegistry.INSTANCE.registerRoleMapping(model);
			if(unRegisterables != null && unRegisterables.size() > 0){
				IRoleMappingRegistry.INSTANCE.updateMappings(unRegisterables);
			}
			resource.addWarning("This Role Mapping Model was only registered temporarily.\nYou should consider to register it as extension.", RolemappingEProblemType.BUILDER_ERROR, model);
		}
		return Status.OK_STATUS;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
