package org.emftext.refactoring.interpreter;

import java.util.Map;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.internal.BasicValueProviderRegistry;


/**
 * An interface for the {@link IValueProvider} registry. One can register
 * those providers for arbitrary {@link RoleMapping}s. If no provider has been 
 * registered a general provider will be used.
 * 
 * @author jreimann
 *
 */
public interface IValueProviderRegistry {

	public static IValueProviderRegistry INSTANCE = new BasicValueProviderRegistry();
	
	/**
	 * Registers a value provider class for the given roleMapping. This class then
	 * will be always instantiated for new. 
	 * Returns the given value provider itself
	 * if registration was successful. In case when any other value provider
	 * already has been registered for the given roleMapping the already registered value provider
	 * will be returned. 
	 * 
	 * @param roleMapping
	 * @param valueProvider
	 */
	public Class<? extends IValueProvider<?, ?>> registerValueProvider(RoleMapping roleMapping, Class<? extends IValueProvider<?, ?>> valueProviderClass);
	
	/**
	 * Returns the registered value provider for the given roleMapping or <code>null</code> if 
	 * none has been registered.
	 * 
	 * @param roleMapping
	 * @return
	 */
	public Class<? extends IValueProvider<?, ?>> getValueProviderByRoleMapping(RoleMapping roleMapping);
	
	/**
	 * Returns the complete registry.
	 * 
	 * @return
	 */
	public Map<RoleMapping, Class<? extends IValueProvider<?, ?>>> getValueProviderMap();
}
