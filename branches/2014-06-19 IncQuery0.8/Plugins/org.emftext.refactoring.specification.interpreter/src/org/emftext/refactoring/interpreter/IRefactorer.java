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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;

/**
 * Interface for Refactorer. A {@link IRefactorer} will be used for one {@link RoleMapping roleMapping}. 
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactorer {
	
	/**
	 * Sets the input for the RefactoringInterpreter by passing the selected EObjects.
	 * The selection can come for example from selected nodes in a EMF generated tree editor. 
	 * This method can only be invoked if the rolemapping to be used in this refactoring
	 * only contains only one role marked is {@link RoleModifier#INPUT}.
	 * This method determines the only input role and delegates to {@link #setInputRoleBindings(Map)}. 
	 * 
	 * @param selectedElements the selected elements
	 * @see #setInputRoleBindings(Map)
	 */
	public void setInput(List<? extends EObject> selectedElements);
	
	/**
	 * This method can be used to provide an initial binding for all roles marked as {@link RoleModifier#INPUT}.
	 * Usually this method should be used if more than one input role exists.
	 * The keys in the given <code>initialInputRoleBinding</code> represent the role names of the input roles.
	 * The values are lists and represent all model elements which should be bound to a particular input role.
	 * Internally, only those initial bindings are taken into account which are bound to input roles.
	 * In case only one input role exists {@link #setInput(List)} should be used. 
	 * 
	 * @param inputRoleBinding
	 */
	public void setInputRoleBindings(Map<String, List<EObject>> inputRoleBinding);
	
	/**
	 * Returns the selected elements on which this refactoring is to be executed.
	 * Beware: this method only returns a list of the selected elements. Thus, the information to which roles they belong is lost.
	 * If you need the information about the roles use {@link #getInputRoleBindings()} instead.
	 * 
	 * @see #setInput(List)
	 * @see #getInputRoleBindings()
	 * @return
	 */
	public List<EObject> getInput();
	
	/**
	 * Returns only those role bindings belonging to input roles.
	 * 
	 * @return
	 */
	public Map<Role, List<EObject>> getInputRoleBindings();
	
	
	/**
	 * This method must be invoked to run a fake refactoring process by which a copied refactored model is constructed.
	 * This is needed if a graphical comparison between original and target model is needed.
	 */
	public void fakeRefactor();
	
	/**
	 * Invokes the RefactoringSpecification on the given {@link RoleMapping} on the model set with {@link #setInput(EList)}.
	 * Clients must invoke {@link #setValueProviderFactory(IValueProviderFactory)} first.
	 * 
	 * @param the mapping for which the {@link RefactoringSpecification} is intended to be invoked
	 * @return the refactored model
	 */
	public EObject refactor();
	
	/**
	 * This method returns the result of the model after the execution of {@link IRefactorer#fakeRefactor(RoleMapping)}.
	 * This model can be used to display a comparison dialog with the original model to show the effects of the refactoring.
	 * 
	 * @return
	 */
	public EObject getFakeRefactoredModel();
	
	/**
	 * Returns <code>false</code> if no errors occured while refactoring. 
	 * @return
	 */
	public boolean didErrorsOccur();
	
	/**
	 * Returns all resources which have to be saved after the refactoring. Those resources might be all inverse cross
	 * references from the given model. That means those resources which refer the refactored model and hence depend on 
	 * the modifications. 
	 * 
	 * @return
	 */
	public List<Resource> getResourcesToSave();
	
	/**
	 * The resource on which the refactorer works. 
	 * 
	 * @return
	 */
	public Resource getResource();
	
	/**
	 * Returns the status which was processed during the refactoring.
	 * @return
	 */
	public IRefactoringStatus getStatus();
	
	/**
	 * Returns the original model before the refactoring was invoked.
	 * @return
	 */
	public EObject getOriginalModel();
	
	/**
	 * Returns the interpreter which actually did the transformations.
	 * 
	 * @return
	 */
	public IRefactoringInterpreter getInterpreter();
	
	/**
	 * Sets the {@link IValueProviderFactory} for this refactorer.
	 * @param factory
	 */
	public void setValueProviderFactory(IValueProviderFactory factory);
	
	/**
	 * Returns the role mapping of this refactorer.
	 * @return
	 */
	public RoleMapping getRoleMapping();
}
