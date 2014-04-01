package org.emftext.refactoring.ltk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ltk.core.refactoring.RefactoringContribution;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.refactoring.valueprovider.BasicValueProviderFactory;

public class GenericRefactoringContribution extends RefactoringContribution {

	@SuppressWarnings("rawtypes")
	@Override
	public RefactoringDescriptor createDescriptor(String id, String project, String description, String comment, Map arguments, int flags) throws IllegalArgumentException {
		if(arguments != null && arguments.size() > 0){
			String metamodel = (String) arguments.get(ModelRefactoringDescriptor.ID_METAMODEL);
			String roleMappingName = (String) arguments.get(ModelRefactoringDescriptor.ID_ROLEMAPPING);
			String resourceString = (String) arguments.get(ModelRefactoringDescriptor.ID_RESOURCE);
			String selectedElementsString = (String) arguments.get(ModelRefactoringDescriptor.ID_SELECTED_ELEMENTS);
			String roleBindingsString = (String) arguments.get(ModelRefactoringDescriptor.ID_ROLE_BINDINGS);
			RoleMapping roleMapping = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodel).get(roleMappingName);
			URI uri = URI.createURI(resourceString);
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(uri, true);
			IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, roleMapping);
			List<EObject> selectedElements = new ArrayList<EObject>();
			String[] elements = selectedElementsString.split(";");
			for (String elementString : elements) {
				EObject element = getEObjectFromURIString(rs, elementString);
				if(element != null){
					selectedElements.add(element);
				}
			}
			refactorer.setInput(selectedElements);
			if(roleBindingsString != null){
				String[] roleBindings = roleBindingsString.split("\\r?\\n");
				for (String roleBinding : roleBindings) {
					String[] split = roleBinding.split("=");
					String roleName = split[0];
					Role role = RoleUtil.getRoleByName(roleMapping, roleName);
					if(role != null){
						split = split[1].split(";");
						List<EObject> boundElements = new ArrayList<EObject>();
						for (int i = 0; i < split.length; i++) {
							String uriString = split[i];
							EObject element = getEObjectFromURIString(rs, uriString);
							if(element != null){
								boundElements.add(element);
							}
						}
						refactorer.getInterpreter().getRoleBindings().put(role, boundElements);
					}
				}
			}
			// TODO jreimann: provide new value provider which takes the already provided values into account and provides them
			IValueProviderFactory factory = new BasicValueProviderFactory(refactorer);
			refactorer.setValueProviderFactory(factory);
			RefactoringDescriptor descriptor = new ModelRefactoringDescriptor(refactorer);
			return descriptor;
		}
		return null;
	}

	protected EObject getEObjectFromURIString(ResourceSet rs, String elementString) {
		URI uri = URI.createURI(elementString);
		EObject element = null;
		try {
			element = rs.getEObject(uri, true);
		} catch (Exception e) {
			// just do nothing
		}
		return element;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map retrieveArgumentMap(RefactoringDescriptor descriptor) {
		if(descriptor instanceof ModelRefactoringDescriptor){
			return ((ModelRefactoringDescriptor) descriptor).getArgumentsMap();
		}
		return super.retrieveArgumentMap(descriptor);
	}
}
