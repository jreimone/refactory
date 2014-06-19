package org.eclipse.uml2.refactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.refactoring.util.StringUtil;

public class IntroduceParameterObjectPostProcessor extends AbstractRefactoringPostProcessor {

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
//		Class origClass = RoleUtil.getFirstObjectForRole("OrigContainer", Class.class, roleRuntimeInstanceMap);
		Class newClass = RoleUtil.getFirstObjectForRole("NewContainer", Class.class, roleRuntimeInstanceMap);
		List<Parameter> parameters = RoleUtil.getObjectsForRole("Extractee", Parameter.class, roleRuntimeInstanceMap);
		Operation operation = null;
		for (Parameter parameter : parameters) {
			operation = parameter.getOperation();
			createPropertyInClassForParameter(newClass, parameter);
			EcoreUtil.remove(parameter);
		}
		addParameterObjectToOperation(operation, newClass);
		return Status.OK_STATUS;
	}

	private void addParameterObjectToOperation(Operation operation, Class newClass) {
		Parameter parameter = UMLFactory.eINSTANCE.createParameter();
		parameter.setType(newClass);
		parameter.setName(StringUtil.firstLetterLowerCase(newClass.getName()));
		operation.getOwnedParameters().add(parameter);
	}

	private void createPropertyInClassForParameter(Class newClass, Parameter parameter) {
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName(parameter.getName());
		property.setType(parameter.getType());
		property.setLower(parameter.getLower());
		property.setUpper(parameter.getUpper());
		newClass.getOwnedAttributes().add(property);
	}
}
