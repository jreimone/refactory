package org.modelrefactoring.corefactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;

public interface CoRefactorer {

	/**
	 * Returns the initial refactorer.
	 * @return
	 */
	public IRefactorer getInitialRefactorer();

	/**
	 * Returns the model which depends on the model which was refactored by the initial refactorer.
	 * @return
	 * @see #getInitialRefactorer()
	 */
	public EObject getDependentModel();

	/**
	 * Returns those elements being dependent on the elements which were subject of the initial refactorer.
	 * 
	 * @return
	 * @see #getInitialRefactorer()
	 * @see #getDependentModel()
	 */
	public List<EObject> getDependentElements();

	/**
	 * Returns the co-refactored model.
	 * @return
	 */
	public EObject coRefactor();

	/**
	 * Returns the rolemapping being used to co-refactor the dependent model.
	 * 
	 * @return
	 */
	public RoleMapping getDependentRoleMapping();

	/**
	 * Returns the rolemapping which was used to refactor the initial model.
	 * @return
	 * @see #getInitialRefactorer()
	 */
	public RoleMapping getInitialRoleMapping();

}
