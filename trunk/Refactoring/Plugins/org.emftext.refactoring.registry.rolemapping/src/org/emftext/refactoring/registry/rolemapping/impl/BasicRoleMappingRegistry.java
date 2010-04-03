package org.emftext.refactoring.registry.rolemapping.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.IPostProcessorExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRoleMappingRegistry implements IRoleMappingRegistry {

	private Map<String, Map<String, Mapping>> roleMappingsMap;
	private Map<String, Map<Mapping, IRefactoringPostProcessor>> postProcessorMap;
	private Map<Mapping, ImageDescriptor> iconMap;
	private Map<Mapping, ImageDescriptor> defaultIconMap;

	public BasicRoleMappingRegistry(){
		roleMappingsMap = new LinkedHashMap<String, Map<String, Mapping>>();
		postProcessorMap = new LinkedHashMap<String, Map<Mapping,IRefactoringPostProcessor>>();
		iconMap = new LinkedHashMap<Mapping, ImageDescriptor>();
		defaultIconMap = new LinkedHashMap<Mapping, ImageDescriptor>();
		collectRegisteredRoleMappings();
		collectRegisteredPostProcessors();
	}

	public Map<String, Mapping> getRoleMappingsForUri(String nsUri) {
		return getRoleMappingsMap().get(nsUri);
	}

	private void collectRegisteredRoleMappings(){
		Map<RoleMappingModel, IConfigurationElement> models = RegistryUtil.collectRegisteredResources(IRoleMappingExtensionPoint.ID
				, IRoleMappingExtensionPoint.RESOURCE_ATTRIBUTE
				, RoleMappingModel.class);
		for (RoleMappingModel roleMapping : models.keySet()) {
			registerRoleMapping(roleMapping, models.get(roleMapping));
		}
	}

	private void registerRoleMapping(RoleMappingModel roleMapping, IConfigurationElement config) {
		try {
			registerRoleMapping(roleMapping);
			String defaultIconString = config.getAttribute(IRoleMappingExtensionPoint.DEFAULT_ICON_ATTRIBUTE);
			if(defaultIconString == null){
				return;
			}
			String plugin = config.getContributor().getName();
			
			ImageData imageData = getImageData(defaultIconString, plugin);
			
			ImageDescriptor defaultImage = ImageDescriptor.createFromImageData(imageData);
			for (Mapping mapping : roleMapping.getMappings()) {
				IConfigurationElement[] children = config.getChildren();
				for (IConfigurationElement element : children) {
					if(element.getName().equals(IRoleMappingExtensionPoint.SUB_MAPPING_ICON_ID)){
						String mappingName = element.getAttribute(IRoleMappingExtensionPoint.SUB_MAPPING_NAME);
						String mappingIcon = element.getAttribute(IRoleMappingExtensionPoint.SUB_ICON_RESOURCE);
						System.out.println("found icon " + mappingIcon + " for mapping " + mappingName);
					}
				}
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ImageData getImageData(String defaultIconString, String plugin) throws URISyntaxException, MalformedURLException, IOException {
		// TODO uncomment and bugfix
		//		URI uri = URI.createPlatformPluginURI("/" + plugin + "/" + defaultIconString, true);
//		java.net.URI normalUri = new java.net.URI(uri.toPlatformString(true));
//		URL imageUrl = normalUri.toURL();
//		InputStream stream = imageUrl.openStream();
//		ImageData imageData = new ImageData(stream);
//		stream.close();
//		return imageData;
		return null;
	}

	private void collectRegisteredPostProcessors(){
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IPostProcessorExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			try {
				IRefactoringPostProcessor postprocessor = (IRefactoringPostProcessor) element.createExecutableExtension(IPostProcessorExtensionPoint.ATTRIBUTE_POST_PROCESSOR);
				String nsUri = element.getAttribute(IPostProcessorExtensionPoint.ATTRIBUTE_NS_URI);
				String mappingName = element.getAttribute(IPostProcessorExtensionPoint.ATTRIBUTE_MAPPING);
				Map<String, Mapping> roleMappings = getRoleMappingsForUri(nsUri);
				Mapping mapping = null;
				for (String registeredName : roleMappings.keySet()) {
					if(registeredName.equals(mappingName.trim())){
						mapping = roleMappings.get(registeredName);
						break;
					}
				}
				if(mapping == null){
					continue;
				}
				registerPostProcessor(mapping, postprocessor);
			} catch (CoreException e) {
				RegistryUtil.log("Could not instantiate postprocessor", IStatus.ERROR, e);
			}
		}
	}

	public void registerRoleMapping(RoleMappingModel roleMapping) {
		Map<String, Mapping> mappingsToRegister = new LinkedHashMap<String, Mapping>();
		for (Mapping mapping : roleMapping.getMappings()) {
			mappingsToRegister.put(mapping.getName(), mapping);
		}

		String nsUri = roleMapping.getTargetMetamodel().getNsURI();
		Map<String, Mapping> registered = getRoleMappingsMap().get(nsUri);
		if(registered == null){
			registered = new LinkedHashMap<String, Mapping>();
			getRoleMappingsMap().put(nsUri, registered);
		}
		for (String mappingName : mappingsToRegister.keySet()) {
			if(registered.get(mappingName) != null){
				RegistryUtil.log("A mapping '" + mappingName + "' already exists in the registry for metamodel " + nsUri, IStatus.WARNING);
			} else {
				registered.put(mappingName, mappingsToRegister.get(mappingName));
				registerIconForMapping(mappingsToRegister.get(mappingName));
			}
		}
		EPackage rootPackage = roleMapping.getTargetMetamodel();
		registerSubPackages(rootPackage, registered);
	}

	private void registerIconForMapping(Mapping mapping) {
		//		RegistryUtil.
	}

	private void registerSubPackages(EPackage rootPackage, Map<String, Mapping> mappings){
		List<EPackage> subPackages = rootPackage.getESubpackages();
		if(subPackages != null){
			for (EPackage subpackage : subPackages) {
				String nsUri = subpackage.getNsURI();
				Map<String, Mapping> registered = getRoleMappingsMap().get(nsUri);
				if(registered != null){
					RegistryUtil.log("Metamodel " + nsUri + " already registered ", IStatus.WARNING);
				} else {
					getRoleMappingsMap().put(nsUri, mappings);
					registerSubPackages(subpackage, mappings);
				}
			}
		}
	}

	public Map<String, Map<String, Mapping>> getRoleMappingsMap() {
		return roleMappingsMap;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#registerPostProcessor(org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.emftext.language.refactoring.rolemapping.Mapping, org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor)
	 */
	public void registerPostProcessor(Mapping mapping, IRefactoringPostProcessor postProcessor) {
		RoleMappingModel root = (RoleMappingModel) EcoreUtil.getRootContainer(mapping);
		registerPostProcessor(root.getTargetMetamodel(), mapping, postProcessor);
		List<EPackage> subPackages = root.getTargetMetamodel().getESubpackages();
		for (EPackage subPackage : subPackages) {
			registerPostProcessor(subPackage, mapping, postProcessor);
		}
	}

	private void registerPostProcessor(EPackage metamodel, Mapping mapping, IRefactoringPostProcessor postProcessor) {
		String nsUri = metamodel.getNsURI();
		Map<Mapping, IRefactoringPostProcessor> map = postProcessorMap.get(nsUri);
		if(map == null){
			map = new LinkedHashMap<Mapping, IRefactoringPostProcessor>();
		}
		map.put(mapping, postProcessor);
		postProcessorMap.put(nsUri, map);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#getPostProcessor(org.eclipse.emf.ecore.EPackage, org.emftext.language.refactoring.rolemapping.Mapping)
	 */
	public IRefactoringPostProcessor getPostProcessor(EPackage metamodel, Mapping mapping) {
		String nsUri = metamodel.getNsURI();
		Map<Mapping, IRefactoringPostProcessor> map = postProcessorMap.get(nsUri);
		if(map == null){
			return null;
		}
		return map.get(mapping);
	}

	public ImageDescriptor getImageForMapping(Mapping mapping) {
		ImageDescriptor image = iconMap.get(mapping);
		if(image == null){
			image = defaultIconMap.get(mapping);
		}
		return image;
	}
}
