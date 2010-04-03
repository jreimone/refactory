package org.emftext.refactoring.postprocessors;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.modifiers.Static;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.Void;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

public class JavaExtractMethodPostProcessor implements IRefactoringPostProcessor {

	private ClassMethod newContainer;
	private ClassMethod origContainer;
	
	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor#process(java.util.Map)
	 */
	public IStatus process(Map<Role, Object> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		System.out.println("Add return type for 'Extract Method' in Java");
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			if(role.getName().equals("NewContainer")){
				Object runtimeObject = roleRuntimeInstanceMap.get(role);
				if(runtimeObject instanceof ClassMethod){
					newContainer = (ClassMethod) runtimeObject;
				}
			} else if(role.getName().equals("OrigContainer")){
				Object runtimeObject = roleRuntimeInstanceMap.get(role);
				if(runtimeObject instanceof ClassMethod){
					origContainer = (ClassMethod) runtimeObject;
				}
			}
		}
		boolean result = processMethodType();
		if(!result){
			return new Status(IStatus.WARNING, "org.emftext.refactoring.rolemappings", "Couldn't determine the correct method return type and modifier");
		}
		return new Status(IStatus.OK, "org.emftext.refactoring.rolemappings", "");
	}
	
	private Boolean processMethodType(){
		Void voidType = TypesFactory.eINSTANCE.createVoid();
		newContainer.setTypeReference(voidType);
		System.out.println("setting 'void' for method '" + newContainer.getName() + "'");
		List<AnnotationInstanceOrModifier> modifiers = origContainer.getAnnotationsAndModifiers();
		for (AnnotationInstanceOrModifier modifier : modifiers) {
			if(modifier instanceof Static){
				Static staticModifier = ModifiersFactory.eINSTANCE.createStatic();
				return newContainer.getAnnotationsAndModifiers().add(staticModifier);
			}
		}
		return true;
	}
}
