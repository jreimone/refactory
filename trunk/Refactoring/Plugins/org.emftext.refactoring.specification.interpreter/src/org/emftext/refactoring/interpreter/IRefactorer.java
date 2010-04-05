/**
 * 
 */
package org.emftext.refactoring.interpreter;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;

/**
 * Interface for Refactorer. A {@link IRefactorer} will be used for one {@link RoleMappingModel roleMapping}. 
 * Internally the {@link IRefactorer refactorer} consists of a map which connects a {@link Mapping} with
 * a {@link IRefactoringInterpreter}. This needed because one {@link RoleModel} can be applied to several parts 
 * of the same metamodel.
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactorer {
	
	/**
	 * Sets the input for the RefactoringInterpreter by passing the selected EObjects.
	 * The selection can come for example from selected nodes in a EMF generated tree editor. 
	 * 
	 * @param selectedElements the selected elements
	 */
	public void setInput(List<? extends EObject> selectedElements);
	
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
	public List<RefactoringSpecification> getPossibleRefactoringsForNearestRoleModels(double minEquality);
	
	/**
	 * Infers over the objects which were set with {@link #setInput(EList)} and identifies all of its applied roles.
	 * Then all {@link Mapping}s will be checked for roles marked as {@link RoleModifier#INPUT} and compared to
	 * the input. If all input roles are present in the input then value 1.0 will be returned.
	 * 
	 * @param minEquality specifies the minimum equality in percent the applied roles must fulfill
	 * @return a list of all {@link RefactoringSpecification}s having a percental equality greater or equal <code>minEquality</code> 
	 */
	public List<RefactoringSpecification> getPossibleRefactorings(double minEquality);
	
	/**
	 * This method must be invoked before {@link IRefactorer#refactor()}. By this a fake run will be executed to
	 * collect all values whioch have to be provided by the user and to calculate a comparison model.
	 * 
	 * @param mapping
	 * @return returns the fake interpreter used within this method
	 */
	public IRefactoringFakeInterpreter fakeRefactor(Mapping mapping);
	
	/**
	 * Invokes the RefactoringSpecification on the given {@link Mapping} on the model set with {@link #setInput(EList)}.
	 * 
	 * @param the mapping for which the {@link RefactoringSpecification} is intended to be invoked
	 * @return the refactored model
	 */
	public EObject refactor();
	
	/**
	 * This method returns the result of the model after the execution of {@link IRefactorer#fakeRefactor(Mapping)}.
	 * This model can be used to display a comparison dialog with the original model to show the effects of the refactoring.
	 * 
	 * @return
	 */
	public EObject getFakeRefactoredModel();
	
	/**
	 * Returns a list containing all {@link Mapping mappings} for which the current selection has all obligatory (input)roles
	 * applied. With <code>minEquality</code> one can decide how strict the presence of the applied roles should be.
	 * If <code>minEquality</code> is 1.0 than all (input)roles are considered to be applied in the current selection.
	 * This method should be used for retrieving the possible refactorings which should be offered to the user maybe in 
	 * a context menu. Therefore the {@link Mapping#getName()} is usefull because it is considered to have a meaningful name like
	 * 'ExtractStatements' for the <a href="http://www.emftext.org/index.php/EMFText_Concrete_Syntax_Zoo_PL0">PL/0</a> language for example.
	 * 
	 * @param minEquality
	 * @return
	 */
	public List<Mapping> getPossibleMappings(double minEquality);
	
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
}
