/**
 * 
 */
package org.emftext.refactoring.indexconnector;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * Interface for build up a connection to an Indexer such as Sokan or EMF Index.
 * 
 * @author Jan Reimann
 *
 */
public interface IndexConnector {

	/**
	 * Returns the role mapping for the given URI of the metamodel from the index.
	 * That means that the nsUri {@link RoleMappingModel#getTargetMetamodel()} must equal 
	 * the given metamodelURI.
	 * 
	 * @param metamodelURI uri for the metamodel to get the role mapping for
	 * @return the corresponding {@link RoleMappingModel}
	 */
	public RoleMappingModel getRoleMapping(String metamodelURI);
	
	/**
	 * Searches the index for entries being models of type {@link RefactoringSpecification} and
	 * containing the steps for a refactoring of the given {@link RoleModel}.
	 * 
	 * @param roleModel the RoleModel to get the refactoring steps for
	 * @return the correspionding {@link RefactoringSpecification} for the given {@link RoleModel}
	 */
	public RefactoringSpecification getRefactoringSpecification(RoleModel roleModel);
}
