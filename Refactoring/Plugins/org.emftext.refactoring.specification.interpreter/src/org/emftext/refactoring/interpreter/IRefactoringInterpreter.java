/**
 * 
 */
package org.emftext.refactoring.interpreter;


import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
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
	 * and the elements serving as input for the refactoring are needed, too. Finally a {@link Mapping} is
	 * obligatory because by the mapping the metaclasses can be determined.
	 * 
	 * @param refSpec the specification containing the steps of the refactoring
	 * @param model the model being refactored
	 * @param mapping 
	 */
	public void initialize(RefactoringSpecification refSpec, Mapping mapping);
	
	/**
	 * This method returns the {@link RefactoringSpecification} with which this interpreter has been initialized
	 * @return
	 */
	public RefactoringSpecification getRefactoringSpecification();
	
	/**
	 * Returns the mapping with which this interpreter has been initialized
	 * @return
	 */
	public Mapping getMapping();
	
	/**
	 * Invokes the refactoring process on the model and with the steps determined in {@link IRefactoringInterpreter#initialize(RefactoringSpecification, EObject)}.
	 * 
	 * @param copy flag to decide whether the refactoring should be invoked on a copy of the model
	 * @return returns the refactored model or <code>null</code> if {@link IRefactoringInterpreter#setMapping(Mapping)} wasn't invoked before
	 */
	public EObject interprete(EObject model);
	
	/**
	 * This method should return a copy of this interpreter for a fake run. It then can be used to collect all
	 * required inputs. For this reason this interface extends {@link Cloneable}.
	 * 
	 * @return
	 */
	public IRefactoringFakeInterpreter getFakeInterpreter();
	
	/**
	 * Sets the the current selection, for which the appropriate interpreter is to be run, as input.
	 * @param currentSelection
	 */
	public void setInput(List<? extends EObject> currentSelection);
	
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
	 * 
	 * @return
	 */
	public Map<Role, Object> getRoleRuntimeInstances();
	
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
	
	/**
	 * Returns the value provider for the given instruction. This method is needed that the interpreter and its
	 * fake interpreter can share the same value provider
	 * 
	 * @param command
	 * @return
	 */
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command);
	
	/**
	 * With this method a value provider will be registered to the given instruction.
	 * @param command
	 */
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider);
}
