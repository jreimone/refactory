package org.emftext.refactoring.registry.rolemapping.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
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
import org.osgi.framework.Bundle;

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
		registerRoleMapping(roleMapping);
		registerIconsForMappings(roleMapping, config);
	}

	private void registerIconsForMappings(RoleMappingModel roleMapping, IConfigurationElement config) {
		String defaultIconString = config.getAttribute(IRoleMappingExtensionPoint.DEFAULT_ICON_ATTRIBUTE);
		if(defaultIconString == null){
			return;
		}
		IContributor contributor = config.getContributor();
		Bundle plugin = Platform.getBundle(contributor.getName());
		
		ImageData defaultImageData = getImageData(defaultIconString, plugin);
		ImageDescriptor defaultImage = null;
		if(defaultImageData != null){
			defaultImage = ImageDescriptor.createFromImageData(defaultImageData);
		}
		for (Mapping mapping : roleMapping.getMappings()) {
			IConfigurationElement[] children = config.getChildren();
			boolean found = false;
			for (IConfigurationElement element : children) {
				if(element.getName().equals(IRoleMappingExtensionPoint.SUB_MAPPING_ICON_ID)){
					String mappingName = element.getAttribute(IRoleMappingExtensionPoint.SUB_MAPPING_NAME);
					if(mappingName.equals(mapping.getName())){
						String mappingIcon = element.getAttribute(IRoleMappingExtensionPoint.SUB_ICON_RESOURCE);
						ImageData iconData = getImageData(mappingIcon, plugin);
						ImageDescriptor iconDescriptor = null;
						if(iconData != null){
							iconDescriptor = ImageDescriptor.createFromImageData(iconData);
							iconMap.put(mapping, iconDescriptor);
							System.out.println("found icon " + mappingIcon + " for mapping " + mappingName);
							found = true;
						}
					}
				}
			}
			if(!found && defaultImage != null){
				defaultIconMap.put(mapping, defaultImage);
			}
		}
	}

	private ImageData getImageData(String defaultIconString, Bundle plugin) {
		try {
			IPath path = new Path(defaultIconString);
			InputStream stream = FileLocator.openStream(plugin, path, false);
			ImageData imageData = new ImageData(stream);
			stream.close();
			return imageData;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public List<Mapping> registerRoleMapping(RoleMappingModel roleMapping) {
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
		List<Mapping> alreadyRegistered = new LinkedList<Mapping>();
		for (String mappingName : mappingsToRegister.keySet()) {
			if(registered.get(mappingName) != null){
				alreadyRegistered.add(mappingsToRegister.get(mappingName));
				RegistryUtil.log("A mapping '" + mappingName + "' already exists in the registry for metamodel " + nsUri, IStatus.WARNING);
			} else {
				registered.put(mappingName, mappingsToRegister.get(mappingName));
			}
		}
		EPackage rootPackage = roleMapping.getTargetMetamodel();
		registerSubPackages(rootPackage, registered);
		return alreadyRegistered;
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

	public void updateMappings(List<Mapping> mappingsToUpdate) {
		for (Mapping mapping : mappingsToUpdate) {
			RoleMappingModel model = mapping.getOwningMappingModel();
			if(model != null){
				String nsUri = model.getTargetMetamodel().getNsURI();
				Map<String, Mapping> registeredMappings = getRoleMappingsForUri(nsUri);
				if(registeredMappings != null){
					Mapping correspondingMapping = registeredMappings.get(mapping.getName());
					if(correspondingMapping == null 
							|| mapping.eResource().getURI().equals(correspondingMapping.eResource().getURI())){
						registeredMappings.put(mapping.getName(), mapping);
					}
				}
			}
		}
	}
}
