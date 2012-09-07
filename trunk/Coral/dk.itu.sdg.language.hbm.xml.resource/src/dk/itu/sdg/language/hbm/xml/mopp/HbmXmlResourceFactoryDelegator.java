/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.hbm.xml.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlResourceFactory;

public class HbmXmlResourceFactoryDelegator implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	protected Map<String, Resource.Factory> factories = null;
	
	public HbmXmlResourceFactoryDelegator() {
//		super();
		init();
	}
	
//	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
//		return new dk.itu.sdg.language.xml.resource.hbm.mopp.HbmXmlResource(uri);
//	}
	
	
	
	public Map<String, Resource.Factory> getResourceFactoriesMap() {
		return factories;
	}
	
	
	public Resource.Factory getFactoryForURI(URI uri) {
		URI trimmedURI = uri.trimFileExtension();
		String secondaryFileExtension = trimmedURI.fileExtension();
		Resource.Factory factory = factories.get(secondaryFileExtension);
		if (factory == null) {
			factory = factories.get("");
		}
		return factory;
	}
	
	public Resource createResource(URI uri) {
		return getFactoryForURI(uri).createResource(uri);
	}
	
	protected void init() {
		if (factories == null) {
			factories = new LinkedHashMap<String, Resource.Factory>();
		}
		if (Platform.isRunning()) {
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(HbmXmlResourcePlugin.EP_ADDITIONAL_EXTENSION_PARSER_ID);
			for (IConfigurationElement element : configurationElements) {
				try {
					String type = element.getAttribute("type");
					Resource.Factory factory = (Resource.Factory) element.createExecutableExtension("class");
					if (type == null) {
						type = "";
					}
					Resource.Factory otherFactory = factories.get(type);
					if (otherFactory != null) {
						Class<?> superClass = factory.getClass().getSuperclass();
						while(superClass != Object.class) {
							if (superClass.equals(otherFactory.getClass())) {
								factories.put(type, factory);
								break;
							}
							superClass = superClass.getClass();
						}
					}
					else {
						factories.put(type, factory);
					}
				} catch (CoreException ce) {
					HbmXmlResourcePlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		if (factories.get("") == null) {
			factories.put("", new XmlResourceFactory());
		}
	}
	
}
