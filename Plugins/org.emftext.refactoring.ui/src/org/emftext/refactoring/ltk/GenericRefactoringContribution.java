package org.emftext.refactoring.ltk;

import java.util.ArrayList;
import java.util.HashMap;
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
			String inputBindingsString = (String) arguments.get(ModelRefactoringDescriptor.ID_INPUT_BINDINGS);
			String otherBindingsString = (String) arguments.get(ModelRefactoringDescriptor.ID_OTHER_BINDINGS);
			RoleMapping roleMapping = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodel).get(roleMappingName);
			URI uri = URI.createURI(resourceString);
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(uri, true);
			IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, roleMapping);
			Map<Role, List<EObject>> inputBindings = null;
			if(inputBindingsString != null){
				inputBindings = determineBindings(inputBindingsString, roleMapping, rs);
			}
			if(inputBindings != null && !inputBindings.isEmpty()){
				refactorer.getInterpreter().getRoleBindings().putAll(inputBindings);
			}
			Map<Role, List<EObject>> otherBindings = null;
			if(otherBindingsString != null){
				otherBindings = determineBindings(otherBindingsString, roleMapping, rs);
			}
			System.out.println();
			if(otherBindings != null && !otherBindings.isEmpty()){
				refactorer.getInterpreter().getRoleBindings().putAll(otherBindings);
			}
			// TODO jreimann: provide new value provider which takes the already provided values into account and provides them
			IValueProviderFactory factory = new BasicValueProviderFactory(refactorer);
			refactorer.setValueProviderFactory(factory);
			RefactoringDescriptor descriptor = new ModelRefactoringDescriptor(refactorer);
			return descriptor;
		}
		return null;
	}

	private Map<Role, List<EObject>> determineBindings(String otherBindingsString, RoleMapping roleMapping, ResourceSet rs) {
		Map<Role, List<EObject>> bindings = new HashMap<Role, List<EObject>>();
		String[] roleBindings = otherBindingsString.split("\\r?\\n");
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
				if(!boundElements.isEmpty()){
					bindings.put(role, boundElements);
				}
			}
		}
		return bindings;
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
