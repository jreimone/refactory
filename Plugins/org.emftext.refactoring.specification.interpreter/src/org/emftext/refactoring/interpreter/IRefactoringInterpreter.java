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
/**
 * 
 */
package org.emftext.refactoring.interpreter;


import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

/**
 * Interface for RefactoringInterpreter
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactoringInterpreter extends Cloneable{

	/**
	 * Initializes a concrete RefactoringInterpreter with a {@link RefactoringSpecification} 
	 * containing the declared steps for the refactoring. Besides that the model being refactored
	 * and the elements serving as input for the refactoring are needed, too. Finally a {@link RoleMapping} is
	 * obligatory because by the mapping the metaclasses can be determined.
	 * 
	 * @param refSpec the specification containing the steps of the refactoring
	 * @param model the model being refactored
	 * @param mapping 
	 */
	public void initialize(RefactoringSpecification refSpec, RoleMapping mapping);
	
	/**
	 * This method returns the {@link RefactoringSpecification} with which this interpreter has been initialized
	 * @return
	 */
	public RefactoringSpecification getRefactoringSpecification();
	
	/**
	 * Returns the mapping with which this interpreter has been initialized
	 * @return
	 */
	public RoleMapping getRoleMapping();
	
	/**
	 * Invokes the refactoring process on the model and with the steps determined in {@link IRefactoringInterpreter#initialize(RefactoringSpecification, EObject)}.
	 * 
	 * @param copy flag to decide whether the refactoring should be invoked on a copy of the model
	 * @return returns the refactored model
	 */
	public EObject interprete(EObject model);
	
	/**
	 * Invokes the process of collecting the value providers before the refactoring starts.
	 * It is determined by analysing the corresponding {@link RefactoringSpecification}.
	 */
	public void collectValueProviders();
	
	/**
	 * This method should return a copy of this interpreter for a fake run. It then can be used to collect all
	 * required inputs. For this reason this interface extends {@link Cloneable}.
	 * 
	 * @return
	 */
	public IRefactoringFakeInterpreter getFakeInterpreter();
	
	/**
	 * Passes the given <code>roleBindings</code> to the interpreter which then will be further used
	 * to add additional bindings of the other roles being result of the interpretation process.
	 * Usually, the passed <code>roleBindings</code> initially only contain bindings for input roles.
	 * 
	 * @param inputRoleBinding
	 */
	public void setRoleBindings(Map<Role, List<EObject>> roleBindings);
	
	/**
	 * Returns <code>false</code> if no errors occured while refactoring. 
	 * @return
	 */
	public boolean didErrorsOccur();
	
	/**
	 * Returns the {@link IRefactoringPostProcessor postprocessor} connected to this interpreter instance.
	 * 
	 * @return
	 */
	public IRefactoringPostProcessor getPostProcessor();
	
	/**
	 * Returns a map containing the roles of the current refactoring as keys and a list
	 * containing its values, how they were resolved at runtime.
	 * @return
	 */
	public Map<Role, List<EObject>> getRoleBindings();
	
	/**
	 * While saving a model the {@link EObject objects} will be unloaded and the proxies set instead.
	 * To preserve unresolved proxies after saving this map returns the same structure as {@link #getRoleBindings()}
	 * but with unique {@link URI}s as values. After saving the model(s) the real {@link EObject objects}
	 * then can be resolved again by calling {@link ResourceSet#getEObject(URI, boolean)}.
	 * 
	 * @return
	 */
	public Map<Role, List<URI>> getRoleBindingURIs();
	
	/**
	 * Sets the runtime instance {@link URI}s before saving.
	 * @param runtimeInstanceURIs
	 */
	public void setRoleBindingURIs(Map<Role, List<URI>> runtimeInstanceURIs);
	
	/**
	 * Returns all resources which have to be saved after the refactoring. Those resources might be all inverse cross
	 * references from the given model. That means those resources which refer the refactored model nad hence depend on 
	 * the modifications. 
	 * 
	 * @return
	 */
	public List<Resource> getResourcesToSave();
	
	/**
	 * Returns the status which was processed during the refactoring.
	 * @return
	 */
	public IRefactoringStatus getStatus();
	
	public IValueProviderFactory getValueProviderFactory();

	public void setValueProviderFactory(IValueProviderFactory valueProviderFactory);
}
