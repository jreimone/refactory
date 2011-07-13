package org.emftext.jamopp.refactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.modifiers.Static;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.Void;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

public class JavaExtractMethodPostProcessor extends AbstractRefactoringPostProcessor {

	private ClassMethod newContainer;
	private ClassMethod origContainer;

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor#process(java.util.Map)
	 */
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	ResourceSet resourceSet, ChangeDescription change) {
//		System.out.println("Add return type for 'Extract Method' in Java");
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			if(role.getName().equals("NewContainer")){
				List<EObject> runtimeObject = roleRuntimeInstanceMap.get(role);
				if(runtimeObject.get(0) instanceof ClassMethod){
					newContainer = (ClassMethod) runtimeObject.get(0);
				}
			} else if(role.getName().equals("OrigContainer")){
				List<EObject> runtimeObject = roleRuntimeInstanceMap.get(role);
				if(runtimeObject.get(0) instanceof ClassMethod){
					origContainer = (ClassMethod) runtimeObject.get(0);
				} else {
					Object first = ((List<?>) runtimeObject).get(0);
					if(first instanceof ClassMethod){
						origContainer = (ClassMethod) first;
					} else {
						IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "orig container is not a Class Method");
						Activator.getDefault().getLog().log(status);
						return status;
					}
				}
				if(runtimeObject.size() > 1){
					IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "could not determine the original container");
					Activator.getDefault().getLog().log(status);
					return status;
				}
			}
		}
		boolean result = processMethodType();
		if(!result){
			return new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Couldn't determine the correct method return type and modifier");
		}
		return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
	}

	private Boolean processMethodType(){
		Void voidType = TypesFactory.eINSTANCE.createVoid();
		newContainer.setTypeReference(voidType);
//		System.out.println("setting 'void' for method '" + newContainer.getName() + "'");
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
