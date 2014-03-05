package org.modelrefactoring.corefactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;

public class CoRefactorerImpl implements CoRefactorer {

	private IRefactorer initialRefactorer;
	private EObject dependentModel;
	private List<EObject> dependentElements;

	public CoRefactorerImpl(IRefactorer refactorer, EObject dependentModel, List<EObject> dependentElements) {
		this.initialRefactorer = refactorer;
		this.dependentModel = dependentModel;
		this.dependentElements = dependentElements;
		
	}

	@Override
	public IRefactorer getInitialRefactorer() {
		return initialRefactorer;
	}

	@Override
	public EObject getDependentModel() {
		return dependentModel;
	}

	@Override
	public List<EObject> getDependentElements() {
		return dependentElements;
	}

	@Override
	public EObject coRefactor() {
		return null;
	}

	@Override
	public RoleMapping getDependentRoleMapping() {
		return null;
	}

	@Override
	public RoleMapping getInitialRoleMapping() {
		return initialRefactorer.getRoleMapping();
	}

}
