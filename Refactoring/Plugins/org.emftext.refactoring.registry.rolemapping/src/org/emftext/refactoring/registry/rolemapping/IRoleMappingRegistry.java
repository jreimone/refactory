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
package org.emftext.refactoring.registry.rolemapping;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.registry.rolemapping.impl.BasicRoleMappingRegistry;

/**
 * Interface for the registry where {@link RoleMappingModel}s are registered to a specific metamodel.
 * 
 * @author jreimann
 *
 */
public interface IRoleMappingRegistry {

	public static final IRoleMappingRegistry INSTANCE = new BasicRoleMappingRegistry();
	
	/**
	 * Returns the {@link RoleMappingModel} registered for the given namespace URI.
	 * 
	 * @param nsUri
	 * @return
	 */
	public Map<String, RoleMapping> getRoleMappingsForUri(String nsUri);
	
	/**
	 * To be invoked if a {@link RoleMappingModel} is intended to be registered at runtime.
	 * This method returns those mappings contained in the <code>roleMapping</code> which couldn't be registered
	 * because they are already registered.
	 *  
	 * @param roleMapping
	 * @return those mappings which couldn't be registered
	 */
	public List<RoleMapping> registerRoleMapping(RoleMappingModel roleMapping);
	
	/**
	 * This method updates the registered mappings with the <code>mappingsToUpdate</code>. Only corresponding
	 * mappings will be updated. As input the output from {@link IRoleMappingRegistry#registerRoleMapping(RoleMappingModel)}
	 * could serve.
	 *  
	 * @param mappingsToUpdate
	 */
	public void updateMappings(List<RoleMapping> mappingsToUpdate);
	
	/**
	 * Returns the {@link RoleMappingModel rolemapping} map.
	 * @return
	 */
	public Map<String, Map<String, RoleMapping>> getRoleMappingsMap();
	
	/**
	 * Use this method to register a {@link IRefactoringPostProcessor postprocessor} for the given <code>roleMapping</code> and 
	 * <code>mapping</code>.
	 * @param mapping
	 * @param postProcessor
	 */
	public void registerPostProcessor(RoleMapping mapping, IRefactoringPostProcessor postProcessor);
	
	/**
	 * Returns the postprocessor registered to the given {@link Mapping mapping}. 
	 * 
	 * @param metamodel
	 * @return
	 */
	public IRefactoringPostProcessor getPostProcessor(RoleMapping mapping);
	
	/**
	 * Returns an {@link ImageDescriptor image} for the given <code>mapping</code> or null of no
	 * image was registered.
	 * 
	 * @param mapping
	 * @return
	 */
	public ImageDescriptor getImageForMapping(RoleMapping mapping);
	
	/**
	 * Returns the path in the bundle for the registered icon for the given <code>mapping</code>. 
	 * @param mapping for which an icon was registered
	 * @return the path in the bundle
	 */
	public URL getImagePathForMapping(RoleMapping mapping);
	
	/**
	 * Returns a list containing all {@link RoleMapping mappings} for which the current selection has all obligatory (input)roles
	 * applied. With <code>minEquality</code> one can decide how strict the presence of the applied roles should be.
	 * If <code>minEquality</code> is 1.0 than all (input)roles are considered to be applied in the current selection.
	 * This method should be used for retrieving the possible refactorings which should be offered to the user maybe in 
	 * a context menu. Therefore the {@link RoleMapping#getName()} is usefull because it is considered to have a meaningful name like
	 * 'ExtractStatements' for the <a href="http://www.emftext.org/index.php/EMFText_Concrete_Syntax_Zoo_PL0">PL/0</a> language for example.
	 * 
	 * @param minEquality
	 * @return
	 */
	public List<RoleMapping> getPossibleRoleMappingsForResource(Resource resource, List<EObject> selectedElements, double minEquality);
	
	/**
	 * Infers over the objects from the given <code>selection</code> and identifies all of its applied roles.
	 * Then all {@link RoleMapping}s will be checked for roles marked as {@link RoleModifier#INPUT} and compared to
	 * the input. If all input roles are present in the input then value 1.0 will be returned.
	 * 
	 * @param minEquality specifies the minimum equality in percent the applied roles must fulfill
	 * @return a list of all {@link RefactoringSpecification}s having a percentual equality greater or equal <code>minEquality</code> 
	 */
	public List<RefactoringSpecification> getPossibleRefactorings(List<? extends EObject> selection, double minEquality);
}
