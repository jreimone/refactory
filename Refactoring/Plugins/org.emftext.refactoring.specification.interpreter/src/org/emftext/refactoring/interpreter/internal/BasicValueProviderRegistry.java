package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedHashMap;
import java.util.Map;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderRegistry;

public class BasicValueProviderRegistry implements IValueProviderRegistry {

	private Map<RoleMapping, Class<? extends IValueProvider<?, ?>>> valueProviderMap;
	
	public BasicValueProviderRegistry(){
		valueProviderMap = new LinkedHashMap<RoleMapping, Class<? extends IValueProvider<?,?>>>();
	}
	
	public Class<? extends IValueProvider<?, ?>> registerValueProvider(RoleMapping roleMapping, Class<? extends IValueProvider<?, ?>> valueProviderClass) {
		Class<? extends IValueProvider<?, ?>> registeredValueProvider = getValueProviderMap().get(roleMapping);
		if(registeredValueProvider == null){
			getValueProviderMap().put(roleMapping, valueProviderClass);
			registeredValueProvider = valueProviderClass;
		}
		return registeredValueProvider;
	}

	public Class<? extends IValueProvider<?, ?>> getValueProviderByRoleMapping(RoleMapping roleMapping) {
		return getValueProviderMap().get(roleMapping);
	}

	public Map<RoleMapping, Class<? extends IValueProvider<?, ?>>> getValueProviderMap() {
		return valueProviderMap;
	}

}
