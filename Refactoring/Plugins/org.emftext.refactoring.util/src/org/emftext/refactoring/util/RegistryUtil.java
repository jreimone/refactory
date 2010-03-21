package org.emftext.refactoring.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class RegistryUtil {

	public static IConfigurationElement[] collectConfigurationElements(String extensionPoint){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if(registry == null){
			return null;
		}
		return registry.getConfigurationElementsFor(extensionPoint);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> collectRegisteredResources(String extensionPoint, String attribute, Class<T> expectedModel){
		ResourceSet rs = new ResourceSetImpl();
		List<T> resources = new ArrayList<T>();
		IConfigurationElement[] elements = collectConfigurationElements(extensionPoint);
		if(elements == null){
			return resources;
		}
		for (IConfigurationElement element : elements) {
			String value = element.getAttribute(attribute);
			String plugin = element.getContributor().getName();
			URI uri = URI.createPlatformPluginURI("/" + plugin + "/" + value, true);
			Resource resource = null;
			try{
				resource = rs.getResource(uri, true);
			} catch (Exception e) {
				log(String.format("Resource '%1$s' couldn't be loaded", value), IStatus.ERROR);
				continue;
			}
			if(resource == null){
				log(String.format("Resource '%1$s' couldn't be loaded", value), IStatus.ERROR);
				continue;
			}
			EObject model = resource.getContents().get(0);
			if(expectedModel.isInstance(model)){
				resources.add((T) model);
			} else {
				log(String.format("The resource with URI '%1$s' doesn't contain a %2$s", uri.toString(), expectedModel.getClass().getSimpleName())
						, IStatus.ERROR);
			}
		}
		return resources;
	}
	
	public static void log(String message, int status, Exception e){
		if(e.getStackTrace() != null && e.getStackTrace().length > 0){
		e.printStackTrace();
		} else {
			message = e.getMessage() + "\n" + message;
		}
		log(message, status);
	}
	
	public static void log(String message, int status){
		Level level = null;
		switch (status) {
		case IStatus.ERROR:
			level = Level.SEVERE;
			break;
		case IStatus.INFO:
			level = Level.INFO;
			break;
		case IStatus.WARNING:
			level = Level.WARNING;
			break;
		default:
			break;
		}
		Logger.getLogger(RegistryUtil.class.getSimpleName()).log(level, message);
	}
}
