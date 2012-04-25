/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.registry.rolemapping.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.Activator;
import org.emftext.refactoring.registry.rolemapping.IPostProcessorExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRefactoringSubMenuRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistryListener;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;
import org.osgi.framework.Bundle;

public class BasicRoleMappingRegistry implements IRoleMappingRegistry {

	private Map<String, Map<String, RoleMapping>> roleMappingsMap;
	private Map<RoleModel, List<RoleMapping>> roleModelMappingsMap;
	private Map<String, Map<RoleMapping, IRefactoringPostProcessor>> postProcessorMap;
	private Map<RoleMapping, ImageDescriptor> iconMap;
	private Map<RoleMapping, ImageDescriptor> defaultIconMap;
	private Map<RoleMapping, URL> iconBundlePathMap;
	private Set<IRoleMappingRegistryListener> listeners;

	public BasicRoleMappingRegistry(){
		roleMappingsMap = new LinkedHashMap<String, Map<String, RoleMapping>>();
		roleModelMappingsMap = new HashMap<RoleModel, List<RoleMapping>>();
		postProcessorMap = new LinkedHashMap<String, Map<RoleMapping,IRefactoringPostProcessor>>();
		iconMap = new LinkedHashMap<RoleMapping, ImageDescriptor>();
		defaultIconMap = new LinkedHashMap<RoleMapping, ImageDescriptor>();
		iconBundlePathMap = new LinkedHashMap<RoleMapping, URL>();
		listeners = new HashSet<IRoleMappingRegistryListener>();
		collectRegisteredRoleMappings();
		collectRegisteredPostProcessors();
	}

	public Map<String, RoleMapping> getRoleMappingsForUri(String nsUri) {
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
		registerRoleMappingInternal(roleMapping, config);
		registerIconsForMappings(roleMapping, config);
		registerSubMenu(roleMapping, config);
	}

	private void registerSubMenu(RoleMappingModel roleMappingModel, IConfigurationElement config) {
		String subMenuID = config.getAttribute(IRoleMappingExtensionPoint.SUB_MENU_ID);
		if(subMenuID != null){
			IRefactoringSubMenuRegistry subMenuRegistry = IRefactoringSubMenuRegistry.INSTANCE;
			List<RoleMapping> roleMappings = roleMappingModel.getMappings();
			for (RoleMapping roleMapping : roleMappings) {
				subMenuRegistry.registerRoleMappingForSubMenu(roleMapping, subMenuID);
			}
		}
	}

	private void registerIconsForMappings(RoleMappingModel roleMapping, IConfigurationElement config) {
		IContributor contributor = config.getContributor();
		Bundle plugin = Platform.getBundle(contributor.getName());

		// first look for default icon
		ImageDescriptor defaultImage = null;
		String defaultIconString = config.getAttribute(IRoleMappingExtensionPoint.DEFAULT_ICON_ATTRIBUTE);
		URL defaultIconBundleURL = null;
		if (defaultIconString != null) {
			ImageData defaultImageData = getImageData(defaultIconString, plugin);
			if (defaultImageData != null) {
				defaultImage = ImageDescriptor.createFromImageData(defaultImageData);
				IPath path = new Path(defaultIconString);
				defaultIconBundleURL = FileLocator.find(plugin, path, Collections.EMPTY_MAP);
			}
		}

		// then look for specific icons
		for (RoleMapping mapping : roleMapping.getMappings()) {
			IConfigurationElement[] children = config.getChildren();
			boolean found = false;
			for (IConfigurationElement element : children) {
				if (element.getName().equals(IRoleMappingExtensionPoint.SUB_MAPPING_ICON_ID)) {
					String mappingName = element.getAttribute(IRoleMappingExtensionPoint.SUB_MAPPING_NAME);
					if (mappingName.equals(mapping.getName())) {
						String mappingIcon = element.getAttribute(IRoleMappingExtensionPoint.SUB_ICON_RESOURCE);
						ImageData iconData = getImageData(mappingIcon, plugin);
						ImageDescriptor iconDescriptor = null;
						if (iconData != null) {
							iconDescriptor = ImageDescriptor.createFromImageData(iconData);
							iconMap.put(mapping, iconDescriptor);
							IPath path = new Path(mappingIcon);
							URL iconBundlePath = FileLocator.find(plugin, path, Collections.EMPTY_MAP);
							iconBundlePathMap.put(mapping, iconBundlePath);
							found = true;
						}
					}
				}
			}
			// register default icon only if no specific icon was found
			if (!found && defaultImage != null) {
				defaultIconMap.put(mapping, defaultImage);
				if(defaultIconBundleURL != null){
					iconBundlePathMap.put(mapping, defaultIconBundleURL);
				}
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
				Map<String, RoleMapping> roleMappings = getRoleMappingsForUri(nsUri);
				if(roleMappings != null){
					RoleMapping mapping = null;
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
				}
			} catch (CoreException e) {
				RegistryUtil.log("Could not instantiate postprocessor", IStatus.ERROR, e);
			}
		}
	}

	private List<RoleMapping> registerRoleMappingInternal(RoleMappingModel roleMapping, IConfigurationElement config) {
		Map<String, RoleMapping> mappingsToRegister = new LinkedHashMap<String, RoleMapping>();
		for (RoleMapping mapping : roleMapping.getMappings()) {
			if(canRegisterSingleRoleMapping(mapping, config)){
				mappingsToRegister.put(mapping.getName(), mapping);
			}
		}
		return registerCollectedMappings(mappingsToRegister, roleMapping.getTargetMetamodel());
	}

	private List<RoleMapping> registerCollectedMappings(Map<String, RoleMapping> mappingsToRegister, EPackage rootPackage){
		String nsUri = rootPackage.getNsURI();
		if(nsUri == null){// then the meta model isn't registered correctly and doesn't exist
			return new LinkedList<RoleMapping>(mappingsToRegister.values());
		}
		Map<String, RoleMapping> registered = getRoleMappingsMap().get(nsUri);
		if(registered == null){
			registered = new LinkedHashMap<String, RoleMapping>();
			getRoleMappingsMap().put(nsUri, registered);
		}
		List<RoleMapping> alreadyRegistered = new LinkedList<RoleMapping>();
		for (String mappingName : mappingsToRegister.keySet()) {
			RoleMapping roleMapping = mappingsToRegister.get(mappingName);
			if(registered.get(mappingName) != null){
				alreadyRegistered.add(roleMapping);
				//				RegistryUtil.log("A mapping '" + mappingName + "' already exists in the registry for metamodel " + nsUri, IStatus.WARNING);
			} else {
				RoleModel mappedRoleModel = roleMapping.getMappedRoleModel();
				List<RoleMapping> roleMappings = roleModelMappingsMap.get(mappedRoleModel);
				if(roleMappings == null){
					roleMappings = new ArrayList<RoleMapping>();
					roleModelMappingsMap.put(mappedRoleModel, roleMappings);
				}
				roleMappings.add(roleMapping);
				registered.put(mappingName, roleMapping);
				for (IRoleMappingRegistryListener listener : listeners) {
					listener.roleMappingAdded(roleMapping);
				}
			}
		}
		registerSubPackages(rootPackage, registered);
		return alreadyRegistered;
	}

	private boolean canRegisterSingleRoleMapping(RoleMapping mapping, IConfigurationElement config) {
		Resource mappingResource = mapping.eResource();
		if(mappingResource != null && mappingResource.getErrors() != null && mappingResource.getErrors().size() > 0 ){
			List<Diagnostic> errors = mappingResource.getErrors();
			IStatus status = null;
			String pluginId;
			if(config != null){
				pluginId = config.getContributor().getName();					
			} else {
				pluginId = Activator.PLUGIN_ID;
			}
			List<IStatus> errorStati = new ArrayList<IStatus>();
			for (Diagnostic diagnostic : errors) {
				errorStati.add(new Status(IStatus.ERROR, pluginId, diagnostic.getMessage()));
			}
			status = new MultiStatus(
					pluginId
					, IStatus.ERROR
					, errorStati.toArray(new IStatus[0])
					, "The mapping '" + mapping.getName() + "' cannot be registered because of contained errors. Inspect the sub-entries."
					, null);
			if(Platform.isRunning()){
				Activator.getDefault().getLog().log(status);
			}
			return false;
		} else {
			RoleModel mappedRoleModel = mapping.getMappedRoleModel();
			RoleModel registeredRoleModel = IRoleModelRegistry.INSTANCE.getRoleModelByName(mappedRoleModel.getName());
			if(registeredRoleModel != null){
				RefactoringSpecification registeredRefSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(registeredRoleModel);
				if(registeredRefSpec != null){
					return true;
				}
			}
			return false;
		}
	}

	public List<RoleMapping> registerRoleMappingModel(RoleMappingModel roleMapping) {
		return registerRoleMappingInternal(roleMapping, null);
	}

	public List<RoleMapping> registerRoleMapping(RoleMapping roleMapping) {
		if(roleMapping == null){
			return null;
		}
		Map<String, RoleMapping> mappingsToRegister = new LinkedHashMap<String, RoleMapping>();
		if(canRegisterSingleRoleMapping(roleMapping, null)){
			mappingsToRegister.put(roleMapping.getName(), roleMapping);
		}
		return registerCollectedMappings(mappingsToRegister, roleMapping.getOwningMappingModel().getTargetMetamodel());
	}

	private void registerSubPackages(EPackage rootPackage, Map<String, RoleMapping> mappings){
		List<EPackage> subPackages = rootPackage.getESubpackages();
		if(subPackages != null){
			for (EPackage subpackage : subPackages) {
				String nsUri = subpackage.getNsURI();
				Map<String, RoleMapping> registered = getRoleMappingsMap().get(nsUri);
				if(registered != null){
					RegistryUtil.log("Metamodel " + nsUri + " already registered ", IStatus.WARNING);
				} else {
					getRoleMappingsMap().put(nsUri, mappings);
					registerSubPackages(subpackage, mappings);
				}
			}
		}
	}

	public Map<String, Map<String, RoleMapping>> getRoleMappingsMap() {
		return roleMappingsMap;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#registerPostProcessor(org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.emftext.language.refactoring.rolemapping.Mapping, org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor)
	 */
	public void registerPostProcessor(RoleMapping mapping, IRefactoringPostProcessor postProcessor) {
		RoleMappingModel root = (RoleMappingModel) EcoreUtil.getRootContainer(mapping);
		registerPostProcessor(root.getTargetMetamodel(), mapping, postProcessor);
		List<EPackage> subPackages = root.getTargetMetamodel().getESubpackages();
		for (EPackage subPackage : subPackages) {
			registerPostProcessor(subPackage, mapping, postProcessor);
		}
	}

	private void registerPostProcessor(EPackage metamodel, RoleMapping mapping, IRefactoringPostProcessor postProcessor) {
		String nsUri = metamodel.getNsURI();
		Map<RoleMapping, IRefactoringPostProcessor> map = postProcessorMap.get(nsUri);
		if(map == null){
			map = new LinkedHashMap<RoleMapping, IRefactoringPostProcessor>();
		}
		map.put(mapping, postProcessor);
		postProcessorMap.put(nsUri, map);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#getPostProcessor(org.eclipse.emf.ecore.EPackage, org.emftext.language.refactoring.rolemapping.Mapping)
	 */
	public IRefactoringPostProcessor getPostProcessor(RoleMapping mapping) {
		String nsUri = mapping.getOwningMappingModel().getTargetMetamodel().getNsURI();
		Map<RoleMapping, IRefactoringPostProcessor> map = postProcessorMap.get(nsUri);
		if(map == null){
			return null;
		}
		return map.get(mapping);
	}

	public ImageDescriptor getImageForMapping(RoleMapping mapping) {
		ImageDescriptor image = iconMap.get(mapping);
		if(image == null){
			image = defaultIconMap.get(mapping);
		}
		return image;
	}

	public RoleMapping unregisterRoleMapping(RoleMapping mappingToUnregister){
		if(mappingToUnregister != null){
			RoleMappingModel model = mappingToUnregister.getOwningMappingModel();
			if(model != null){
				String nsUri = model.getTargetMetamodel().getNsURI();
				if(nsUri != null){
					Map<String, RoleMapping> registeredMappings = getRoleMappingsForUri(nsUri);
					RoleMapping remove = registeredMappings.remove(mappingToUnregister.getName());
					if(remove != null){
						for (IRoleMappingRegistryListener listener : listeners) {
							listener.roleMappingRemoved(remove);
						}
					}
					return remove;
				}
			}
		}
		return null;
	}

	public List<RoleMapping> unregisterRoleMappings(RoleMappingModel mappingModelToUnregister){
		List<RoleMapping> ununregisteredModels = new ArrayList<RoleMapping>();
		List<RoleMapping> mappings = mappingModelToUnregister.getMappings();
		for (RoleMapping roleMapping : mappings) {
			RoleMapping unregisteredMapping = unregisterRoleMapping(roleMapping);
			if(unregisteredMapping == null){
				ununregisteredModels.add(roleMapping);
			}
		}
		return ununregisteredModels;
	}

	public URL getImagePathForMapping(RoleMapping mapping) {
		return iconBundlePathMap.get(mapping);
	}

	@Override
	public List<RoleMapping> getPossibleRoleMappingsForResource(Resource resource, List<EObject> selectedElements, double minEquality) {
		EObject root = resource.getContents().get(0);
		String mmUri = root.eClass().getEPackage().getNsURI();
		Map<String, RoleMapping> roleMappings = getRoleMappingsForUri(mmUri);
		return RoleUtil.getPossibleMappingsForInputSelection(selectedElements, roleMappings, minEquality);
	}

	@Override
	public List<RefactoringSpecification> getPossibleRefactorings(List<? extends EObject> selection, double minEquality) {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		String mmUri = selection.get(0).eClass().getEPackage().getNsURI();
		Map<String, RoleMapping> roleMappings = getRoleMappingsForUri(mmUri);
		List<RoleMapping> possibleMappings = RoleUtil.getPossibleMappingsForInputSelection(selection, roleMappings, minEquality);
		for (RoleMapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(mapping.getMappedRoleModel());
			if (refSpec != null) {
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}

	@Override
	public void addRegistryListener(IRoleMappingRegistryListener listener) {
		if(listener != null){
			listeners.add(listener);
		}
	}

	@Override
	public boolean removeRegistryListener(IRoleMappingRegistryListener listener) {
		if(listener != null){
			return listeners.remove(listener);
		}
		return false;
	}

	@Override
	public List<RoleMapping> getRoleMappingsForRoleModel(RoleModel roleModel) {
		return roleModelMappingsMap.get(roleModel);
	}
}
