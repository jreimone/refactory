package org.emftext.language.java.refactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class MoveRequestToVisibleStatePostProcessor extends AbstractRefactoringPostProcessor {

	private static final String ON_RESUME_METHOD_NAME	= "onResume";
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		ExpressionStatement bindingStatement = RoleUtil.getFirstObjectForRole("Selection", ExpressionStatement.class, roleRuntimeInstanceMap);
		EObject container = bindingStatement.eContainer();
		while (container != null && !(container instanceof CompilationUnit)) {
			container = container.eContainer();
		}
		if(container == null){
			return Status.OK_STATUS;
		}
		CompilationUnit compUnit = (CompilationUnit) container;
		org.emftext.language.java.classifiers.Class clazz = compUnit.getContainedClass();
		ClassMethod onResumeMethod = findExistingOnResumeMethod(clazz);
		if(onResumeMethod == null){
			onResumeMethod = MembersFactory.eINSTANCE.createClassMethod();
			onResumeMethod.setName(ON_RESUME_METHOD_NAME);
			onResumeMethod.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createProtected());
			onResumeMethod.setTypeReference(TypesFactory.eINSTANCE.createVoid());
			clazz.getMembers().add(onResumeMethod);
		}
		onResumeMethod.getStatements().add(bindingStatement);
		return Status.OK_STATUS;
	}

	private ClassMethod findExistingOnResumeMethod(org.emftext.language.java.classifiers.Class clazz){
		ClassMethod onResumeMethod = null;
		if(clazz != null){
			List<Method> methods = clazz.getMethods();
			for (Method method : methods) {
				if(ON_RESUME_METHOD_NAME.equals(method.getName()) && method instanceof ClassMethod){
					onResumeMethod = (ClassMethod) method;
					break;
				}
			}
		}
		return onResumeMethod;
	}
}
