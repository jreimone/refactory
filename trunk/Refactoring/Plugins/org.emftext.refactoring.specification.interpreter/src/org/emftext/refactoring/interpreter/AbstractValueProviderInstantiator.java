package org.emftext.refactoring.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.util.RegistryUtil;

public abstract class AbstractValueProviderInstantiator <ValueFrom, ValueType> {

	private IValueProviderRegistry registry;
	
	public AbstractValueProviderInstantiator(){
		registry = IValueProviderRegistry.INSTANCE;
	}
	
	@SuppressWarnings("unchecked")
	public IValueProvider<ValueFrom, ValueType> getNewValueProvider(RoleMapping roleMapping){
		Class<? extends IValueProvider<?,?>> valueProviderClass = registry.getValueProviderByRoleMapping(roleMapping);
		if(valueProviderClass == null){
			return getDefaultValueProvider(roleMapping);
		}
		IValueProvider<ValueFrom, ValueType> valueProvider = null;
		try {
			valueProvider = (IValueProvider<ValueFrom, ValueType>) valueProviderClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			RegistryUtil.log("ValueProvider could not be instantiated", IStatus.ERROR, e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			RegistryUtil.log("ValueProvider could not be instantiated", IStatus.ERROR, e);
		}
		return valueProvider;
	}

	public abstract IValueProvider<ValueFrom, ValueType> getDefaultValueProvider(RoleMapping roleMapping);
}
