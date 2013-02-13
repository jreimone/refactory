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
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
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
			RoleMapping roleMapping = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodel).get(roleMappingName);
			URI uri = URI.createURI(resourceString);
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(uri, true);
			IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, roleMapping);
			List<EObject> selectedElements = new ArrayList<EObject>();
			String[] elements = selectedElementsString.split(";");
			for (String elementString : elements) {
				uri = URI.createURI(elementString);
				EObject element = rs.getEObject(uri, true);
				if(element != null){
					selectedElements.add(element);
				}
			}
			refactorer.setInput(selectedElements);
			// TODO jreimann: provide new value provider which takes the already provided values into account and provides them
			IValueProviderFactory factory = new BasicValueProviderFactory(refactorer);
			refactorer.setValueProviderFactory(factory);
			RefactoringDescriptor descriptor = new ModelRefactoringDescriptor(refactorer);
			return descriptor;
		}
//		IRoleMappingRegistry.INSTANCE.get
//		RefactorerFactory.eINSTANCE.getRefactorer(resource, roleMapping)
		return null;
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
