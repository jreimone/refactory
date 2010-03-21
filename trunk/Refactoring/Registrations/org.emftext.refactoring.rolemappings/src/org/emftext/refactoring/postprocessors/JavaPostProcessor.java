package org.emftext.refactoring.postprocessors;

import java.util.Map;
import java.util.Set;

import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.Void;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

public class JavaPostProcessor implements IRefactoringPostProcessor {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor#process(java.util.Map)
	 */
	public void process(Map<Role, Object> roleRuntimeInstanceMap) {
		System.out.println("Add return type for 'Extract Method' in Java");
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			if(role.getName().equals("NewContainer")){
				Object runtimeObject = roleRuntimeInstanceMap.get(role);
				if(runtimeObject instanceof ClassMethod){
					processMethodType((ClassMethod) runtimeObject);
				}
			}
		}
	}
	
	private void processMethodType(ClassMethod classMethod){
		Void voidType = TypesFactory.eINSTANCE.createVoid();
		classMethod.setTypeReference(voidType);
		System.out.println("setting 'void' for method '" + classMethod.getName() + "'");
	}
}
