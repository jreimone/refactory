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
package org.emftext.language.refactoring.roles.refactoring.facade;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

/**
 * Provides a facade for simpler access to the registered {@link RoleMapping}s for
 * the metamodel: http://www.emftext.org/language/roles.<br>
 * For every registered mapping two methods are contained in this facade:
 * <li> a method for returning the {@link RoleMapping} itself
 * <li> a method for returning the registered icon if one exists
 * <br>
 */
public class RolesRefactoringFacade {
	
	private Resource resource;
	private List<EObject> selectedElements;
	private Map<String, RoleMapping> mappingMap;
	private Map<RoleMapping, IRefactorer> refactorerMap;
	
	public RolesRefactoringFacade(Resource resource, List<EObject> selectedElements){
		super();
		this.resource = resource;
		this.selectedElements = selectedElements;
		initialize();
	}
	
	private void initialize() {
		mappingMap = new HashMap<String, RoleMapping>();
		List<RoleMapping> possibleRoleMappingsForResource = IRoleMappingRegistry.INSTANCE.getPossibleRoleMappingsForResource(resource, selectedElements, 1.0);
		for (RoleMapping roleMapping : possibleRoleMappingsForResource) {
			mappingMap.put(roleMapping.getName(), roleMapping);
			IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, roleMapping);
			if(refactorer != null){
				refactorerMap.put(roleMapping, refactorer);
			}
		}
	}
	
	/**
	 * Returns a refactorer for the given <code>roleMapping</code>.
	 */
	public IRefactorer getRefactorerForRoleMapping(RoleMapping roleMapping) {
		return refactorerMap.get(roleMapping);
	}
	
	/**
	 * Returns the {@link RoleMapping} with name 'RenameRoleModelElement'.
	 * 
	 * @return
	 */
	public RoleMapping getRenameRoleModelElementMapping(){
		return mappingMap.get("RenameRoleModelElement");
	}
	
	
	/**
	 * Returns the registered icon for the {@link RoleMapping} with name
	 * 'RenameRoleModelElement'.
	 * 
	 * @return the registered icon or null if none is registered
	 */
	public URL getRenameRoleModelElementIcon(){
		return IRoleMappingRegistry.INSTANCE.getImagePathForMapping(getRenameRoleModelElementMapping());
	}
	
}
