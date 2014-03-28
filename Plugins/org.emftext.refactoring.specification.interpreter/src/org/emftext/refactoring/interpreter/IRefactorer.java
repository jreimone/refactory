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
	 * This method determines the only input role and delegates to {@link #setInputRoleBinding(Map)}. 
	 * 
	 * @param selectedElements the selected elements
	 * @see #setInputRoleBinding(Map)
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
	public void setInputRoleBinding(Map<String, List<EObject>> inputRoleBinding);
	
	/**
	 * Returns the role bindings produced while executing the refactoring.
	 * They keys of the returned map are the roles, and the value lists are the model elements
	 * bound to the particular role.
	 * 
	 * @return
	 */
	public Map<Role, List<EObject>> getRoleBindings();
	
	/**
	 * Returns the selected elements on which this refactoring is to be executed.
	 * @see #setInput(List)
	 * @return
	 */
	public List<EObject> getInput();
	
	/**
	 * Infers over the mapped roles of the elements set with {@link #setInput(EList)} and determines 
	 * by the completeness of the applied roles in different mappings if they are invokable.
	 * All present roles in the from the elements will be compared to the overall mapped roles in each 
	 * mapping. If the percental equality of the present roles and the one of the mapping is greater
	 * or equal as minEquality then the corresponding {@link RefactoringSpecification} will be contained in
	 * returned list.
	 * 
	 * @param minEquality the minimum equality of the present roles and the mapped roles
	 * 
	 * @return a list of possible RefactoringSpecifications matching the minimum equality
	 */
//	public List<RefactoringSpecification> getPossibleRefactoringsForNearestRoleModels(double minEquality);
	
	/**
	 * Infers over the objects which were set with {@link #setInput(EList)} and identifies all of its applied roles.
	 * Then all {@link RoleMapping}s will be checked for roles marked as {@link RoleModifier#INPUT} and compared to
	 * the input. If all input roles are present in the input then value 1.0 will be returned.
	 * 
	 * @param minEquality specifies the minimum equality in percent the applied roles must fulfill
	 * @return a list of all {@link RefactoringSpecification}s having a percental equality greater or equal <code>minEquality</code> 
	 */
//	public List<RefactoringSpecification> getPossibleRefactorings(double minEquality);
	
//	//cseidl
//	public IRefactoringFakeInterpreter collectValuesToProvide(RoleMapping mapping);
	
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
	 * Sets the appropriate {@link RoleMapping} which is intended to be interpreted and returns the
	 * corresponding {@link IRefactoringInterpreter}.
	 * @param mapping
	 * @return
	 */
//	public IRefactoringInterpreter loadReferencingResources(RoleMapping mapping);
	
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
