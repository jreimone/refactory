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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.registry.rolemapping.impl.BasicRoleMappingRegistry;

import tudresden.ocl20.pivot.pivotmodel.Constraint;

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
	public List<RoleMapping> registerRoleMappingModel(RoleMappingModel roleMapping);

	/**
	 * To be invoked if a single {@link RoleMapping} is intended to be registered at runtime.
	 * This method returns those mappings contained in the <code>roleMapping</code> which couldn't be registered
	 * because they are already registered.
	 *  
	 * @param roleMapping
	 * @return those mappings which couldn't be registered
	 */
	public List<RoleMapping> registerRoleMapping(RoleMapping roleMapping);	
	
	/**
	 * This method unregisters the registered mapping <code>mappingToUnregister</code>.
	 *  
	 * @param mappingToUnregister
	 * @return the unregistered mapping or <code>null</code> if the mapping wasn't registered
	 */
	public RoleMapping unregisterRoleMapping(RoleMapping mappingToUnregister);
	
	/**
	 * Unregisters all role mappings contained in the given <code>mappingModel</code>.
	 * @param mappingModelToUnregister
	 * @return a list of all {@link RoleMapping role mappings} which couldn't be unregistered because they weren't registered
	 */
	public List<RoleMapping> unregisterRoleMappings(RoleMappingModel mappingModelToUnregister);
	
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
	
	/**
	 * Adds a listener to this registry which is notified when the registry changes.
	 * @param listener
	 */
	public void addRegistryListener(IRoleMappingRegistryListener listener);
	
	/**
	 * The given listener is removed and will not be notified anymore.
	 * @param listener
	 * @return see {@link Set#remove(Object)}
	 */
	public boolean removeRegistryListener(IRoleMappingRegistryListener listener);
	
	/**
	 * Returns all roleMappings for the given role model.
	 * @param roleModel
	 * @return
	 */
	public List<RoleMapping> getRoleMappingsForRoleModel(RoleModel roleModel);
	
	/**
	 * Registers a {@link Constraint pre-condition} for the given <code>mapping</code>. The given
	 * <code>errorMessage</code> will be displayed in case of violation of the <code>constraint</code>.
	 *  
	 * @param mapping
	 * @param constraint
	 * @param errorMessage
	 */
	public void registerPreCondition(RoleMapping mapping, Constraint constraint, String errorMessage);
	
	/**
	 * Registers a {@link Constraint post-condition} for the given <code>mapping</code>. The given
	 * <code>errorMessage</code> will be displayed in case of violation of the <code>constraint</code>.
	 *  
	 * @param mapping
	 * @param constraint
	 * @param errorMessage
	 */
	public void registerPostCondition(RoleMapping mapping, Constraint constraint, String errorMessage);
	
	/**
	 * Returns all constraints (pre-conditions) registered for the given <code>mapping</code>. Additionally, the registered 
	 * error message is returned for the found constraint.
	 * 
	 * @param mapping
	 * @return
	 */
	public List<Map.Entry<Constraint, String>> getPreConditionsForRoleMapping(RoleMapping mapping);
	
	/**
	 * Returns all constraints (post-conditions) registered for the given <code>mapping</code>. Additionally, the registered 
	 * error message is returned for the found constraint.
	 * 
	 * @param mapping
	 * @return
	 */
	public List<Map.Entry<Constraint, String>> getPostConditionsForRoleMapping(RoleMapping mapping);
}
