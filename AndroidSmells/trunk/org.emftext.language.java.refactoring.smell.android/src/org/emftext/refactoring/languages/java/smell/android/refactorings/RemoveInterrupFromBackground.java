package org.emftext.refactoring.languages.java.smell.android.refactorings;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class RemoveInterrupFromBackground extends
		AbstractRefactoringPostProcessor {

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			EObject refactoredModel, ResourceSet resourceSet,
			ChangeDescription change, RefactoringSpecification refSpec,
			List<IModelRefactoringWizardPage> customWizardPages,
			boolean isFakeRun, Map<EObject, EObject> copier,
			List<? extends EObject> initialSelection) {
		

		ExpressionStatement expression = RoleUtil.getFirstObjectForRole("Selection",
				ExpressionStatement.class, roleRuntimeInstanceMap);
		
		ClassMethod parent = expression.getParentByType(ClassMethod.class);
		if(parent != null) {
			parent.getStatements().remove(expression);
		}
		
		return Status.OK_STATUS;
	}

}
