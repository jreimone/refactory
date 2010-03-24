/**
 * 
 */
package org.emftext.refactoring.registry.rolemapping;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;

/**
 * This interface is intended to be implemented by postprocessors which can hook into the refactoring process, 
 * after the specified steps, to do some additional calculation steps like e.g. inferring over the needed parameters
 * of a method in the 'Extract Method' refactoring for Java. 
 * <br><br>
 * Every {@link IRefactoringPostProcessor} will be registered in the {@link IRoleMappingRegistry} and is therein
 * connected to a {@link Mapping}. That means that every postprocessor belongs to a specific metamodel and a specific
 * {@link Mapping mapping} in the {@link RoleMappingModel role mapping} registered for that metamodel.
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactoringPostProcessor {

	/**
	 * This method will be invoked after the refactoring process. Do some additional transformations here by using 
	 * the given <code>roleRuntimeInstanceMap</code>. Its keys are the {@link Role roles} used in the
	 * {@link ConcreteMapping concrete mappings} of the {@link Mapping mapping} to which this postprocessor is connected.
	 * The value of each key can be a single {@link EObject object} or a list of {@link EObject objects} representing
	 * the concrete objects on which the roles were bound at runtime of the refactoring.
	 * 
	 * @param roleRuntimeInstanceMap the map containing {@link Role roles} as keys and its at runtime bound {@link EObject objects} as values 
	 * @return <code>true</code> if no errors occurred while postprocessing 
	 */
	public Boolean process(Map<Role, Object> roleRuntimeInstanceMap);
}
