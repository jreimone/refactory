package org.modelrefactoring.guery.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;

public class PreMapAdditionalListener implements AdditionalResultListener {

	@SuppressWarnings("unchecked")
	private Map<String, List<RoleMapping>> filterMap = new HashMap<String, List<RoleMapping>>();
	
	@Override
	public void found(Object... something) {
		if(something != null && something[0] instanceof RoleMapping){
			RoleMapping roleMapping = (RoleMapping) something[0];
			List<ConcreteMapping> concreteMappings = roleMapping.getRoleToMetaelement();
			for (ConcreteMapping concreteMapping : concreteMappings) {
				Role role = concreteMapping.getRole();
				EClass metaclass = concreteMapping.getMetaclass();
				String mappingString = role.getName() + ":" + metaclass.getName();
			}
		}
	}

	@Override
	public void done() {

	}
}
