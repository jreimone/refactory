/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.util;

/**
 * A utility class that bundles all dependencies to the Eclipse platform. Clients
 * of this class must check whether the Eclipse bundles are available in the
 * classpath. If they are not available, this class is not used, which allows to
 * run resource plug-in that are generated by EMFText in stand-alone mode. In this
 * case the EMF JARs are sufficient to parse and print resources.
 */
public class XwpfEclipseProxy {
	
	/**
	 * Adds all registered load option provider extension to the given map. Load
	 * option providers can be used to set default options for loading resources (e.g.
	 * input stream pre-processors).
	 */
	public void getDefaultLoadOptionProviderExtensions(java.util.Map<Object, Object> optionsMap) {
		if (org.eclipse.core.runtime.Platform.isRunning()) {
			// find default load option providers
			org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
			org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
				try {
					dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptionProvider provider = (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptionProvider) element.createExecutableExtension("class");
					final java.util.Map<?, ?> options = provider.getOptions();
					final java.util.Collection<?> keys = options.keySet();
					for (Object key : keys) {
						dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfMapUtil.putAndMergeKeys(optionsMap, key, options.get(key));
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while getting default options.", ce);
				}
			}
		}
	}
	
	/**
	 * Adds all registered resource factory extensions to the given map. Such
	 * extensions can be used to register multiple resource factories for the same
	 * file extension.
	 */
	public void getResourceFactoryExtensions(java.util.Map<String, org.eclipse.emf.ecore.resource.Resource.Factory> factories) {
		if (org.eclipse.core.runtime.Platform.isRunning()) {
			org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
			org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfPlugin.EP_ADDITIONAL_EXTENSION_PARSER_ID);
			for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
				try {
					String type = element.getAttribute("type");
					org.eclipse.emf.ecore.resource.Resource.Factory factory = (org.eclipse.emf.ecore.resource.Resource.Factory) element.createExecutableExtension("class");
					if (type == null) {
						type = "";
					}
					org.eclipse.emf.ecore.resource.Resource.Factory otherFactory = factories.get(type);
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
				} catch (org.eclipse.core.runtime.CoreException ce) {
					new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while getting default options.", ce);
				}
			}
		}
	}
	
	/**
	 * Gets the resource that is contained in the give file.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(org.eclipse.core.resources.IFile file) {
		org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		org.eclipse.emf.ecore.resource.Resource resource = rs.getResource(org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(),true), true);
		return (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource) resource;
	}
	
	/**
	 * Checks all registered EMF validation constraints. Note: EMF validation does not
	 * work if OSGi is not running.
	 */
	@SuppressWarnings("restriction")	
	public void checkEMFValidationConstraints(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource, org.eclipse.emf.ecore.EObject root) {
		// The EMF validation framework code throws a NPE if the validation plug-in is not
		// loaded. This is a bug, which is fixed in the Helios release. Nonetheless, we
		// need to catch the exception here.
		if (new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().isEclipsePlatformRunning()) {
			// The EMF validation framework code throws a NPE if the validation plug-in is not
			// loaded. This is a workaround for bug 322079.
			if (org.eclipse.emf.validation.internal.EMFModelValidationPlugin.getPlugin() != null) {
				try {
					org.eclipse.emf.validation.service.ModelValidationService service = org.eclipse.emf.validation.service.ModelValidationService.getInstance();
					org.eclipse.emf.validation.service.IBatchValidator validator = service.<org.eclipse.emf.ecore.EObject, org.eclipse.emf.validation.service.IBatchValidator>newValidator(org.eclipse.emf.validation.model.EvaluationMode.BATCH);
					validator.setIncludeLiveConstraints(true);
					org.eclipse.core.runtime.IStatus status = validator.validate(root);
					addStatus(status, resource, root);
				} catch (Throwable t) {
					new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logError("Exception while checking contraints provided by EMF validator classes.", t);
				}
			}
		}
	}
	
	public void addStatus(org.eclipse.core.runtime.IStatus status, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource, org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> causes = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		causes.add(root);
		if (status instanceof org.eclipse.emf.validation.model.ConstraintStatus) {
			org.eclipse.emf.validation.model.ConstraintStatus constraintStatus = (org.eclipse.emf.validation.model.ConstraintStatus) status;
			java.util.Set<org.eclipse.emf.ecore.EObject> resultLocus = constraintStatus.getResultLocus();
			causes.clear();
			causes.addAll(resultLocus);
		}
		boolean hasChildren = status.getChildren() != null && status.getChildren().length > 0;
		// Ignore composite status objects that have children. The actual status
		// information is then contained in the child objects.
		if (!status.isMultiStatus() || !hasChildren) {
			if (status.getSeverity() == org.eclipse.core.runtime.IStatus.ERROR) {
				for (org.eclipse.emf.ecore.EObject cause : causes) {
					resource.addError(status.getMessage(), dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType.ANALYSIS_PROBLEM, cause);
				}
			}
			if (status.getSeverity() == org.eclipse.core.runtime.IStatus.WARNING) {
				for (org.eclipse.emf.ecore.EObject cause : causes) {
					resource.addWarning(status.getMessage(), dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType.ANALYSIS_PROBLEM, cause);
				}
			}
		}
		for (org.eclipse.core.runtime.IStatus child : status.getChildren()) {
			addStatus(child, resource, root);
		}
	}
	
	/**
	 * Returns the encoding for this resource that is specified in the workspace file
	 * properties or determined by the default workspace encoding in Eclipse.
	 */
	public String getPlatformResourceEncoding(org.eclipse.emf.common.util.URI uri) {
		// We can't determine the encoding if the platform is not running.
		if (!new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().isEclipsePlatformRunning()) {
			return null;
		}
		if (uri != null && uri.isPlatform()) {
			String platformString = uri.toPlatformString(true);
			org.eclipse.core.resources.IResource platformResource = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (platformResource instanceof org.eclipse.core.resources.IFile) {
				org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) platformResource;
				try {
					return file.getCharset();
				} catch (org.eclipse.core.runtime.CoreException ce) {
					new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logWarning("Could not determine encoding of platform resource: " + uri.toString(), ce);
				}
			}
		}
		return null;
	}
	
}
