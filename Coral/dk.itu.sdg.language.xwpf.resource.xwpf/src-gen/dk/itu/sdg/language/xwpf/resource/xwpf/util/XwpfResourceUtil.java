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
 * Class ResourceUtil can be used to perform common tasks on resources, such as
 * resolving proxy object, saving resources, as well as, checking them for errors.
 */
public class XwpfResourceUtil {
	
	/**
	 * Searches for all unresolved proxy objects in the given resource set.
	 * 
	 * @param resourceSet
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	public static java.util.Set<org.eclipse.emf.ecore.EObject> findUnresolvedProxies(org.eclipse.emf.ecore.resource.ResourceSet resourceSet) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfInterruptibleEcoreResolver().findUnresolvedProxies(resourceSet);
	}
	
	/**
	 * Searches for all unresolved proxy objects in the given resource.
	 * 
	 * @param resource
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	public static java.util.Set<org.eclipse.emf.ecore.EObject> findUnresolvedProxies(org.eclipse.emf.ecore.resource.Resource resource) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfInterruptibleEcoreResolver().findUnresolvedProxies(resource);
	}
	
	/**
	 * Tries to resolve all unresolved proxy objects in the given resource. If all
	 * proxies were resolved true is returned. If some could not be resolved, false is
	 * returned.
	 * 
	 * @param resource the resource containing the proxy object
	 * 
	 * @return true on success
	 */
	public static boolean resolveAll(org.eclipse.emf.ecore.resource.Resource resource) {
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(resource);
		if (findUnresolvedProxies(resource).size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String getProxyIdentifier(org.eclipse.emf.ecore.EObject eObject) {
		String deresolvedReference = null;
		if (eObject instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject eObjectToDeResolve = (org.eclipse.emf.ecore.EObject) eObject;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((org.eclipse.emf.ecore.InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				// If the proxy was created by EMFText, we can try to recover the identifier from
				// the proxy URI
				if (deresolvedReference != null && deresolvedReference.startsWith(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		return deresolvedReference;
	}
	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(java.io.File file) {
		return getResource(file, null);
	}
	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return getResource(org.eclipse.emf.common.util.URI.createFileURI(file.getAbsolutePath()), options);
	}
	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(org.eclipse.emf.common.util.URI uri) {
		return getResource(uri, null);
	}
	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation().registerResourceFactory();
		org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		if (options != null) {
			rs.getLoadOptions().putAll(options);
		}
		org.eclipse.emf.ecore.resource.Resource resource = rs.getResource(uri, true);
		return (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource) resource;
	}
	
	/**
	 * Returns the resource after parsing the given text.
	 */
	public static org.eclipse.emf.ecore.resource.Resource getResource(String text) {
		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation metaInformation = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation();
		metaInformation.registerResourceFactory();
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI("temp." + metaInformation.getSyntaxName());
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		org.eclipse.emf.ecore.resource.Resource resource = resourceSet.createResource(uri);
		if (resource == null) {
			return null;
		}
		java.io.ByteArrayInputStream inputStream = new java.io.ByteArrayInputStream(text.getBytes());
		try {
			resource.load(inputStream, null);
		} catch (java.io.IOException ioe) {
			return null;
		}
		return resource;
	}
	
	/**
	 * Returns the root element of the resource with the given URI.
	 */
	public static org.eclipse.emf.ecore.EObject getResourceContent(org.eclipse.emf.common.util.URI uri) {
		return getResourceContent(uri, null);
	}
	
	/**
	 * Returns the root element of the resource with the given URI.
	 */
	public static org.eclipse.emf.ecore.EObject getResourceContent(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		org.eclipse.emf.ecore.resource.Resource resource = getResource(uri, options);
		if (resource == null) {
			return null;
		}
		java.util.List<org.eclipse.emf.ecore.EObject> contents = resource.getContents();
		if (contents == null || contents.isEmpty()) {
			return null;
		}
		org.eclipse.emf.ecore.EObject root = contents.get(0);
		return (org.eclipse.emf.ecore.EObject) root;
	}
	
	/**
	 * Returns the root element after parsing the given text.
	 */
	public static org.eclipse.emf.ecore.EObject getResourceContent(String text) {
		org.eclipse.emf.ecore.resource.Resource resource = getResource(text);
		if (resource == null) {
			return null;
		}
		java.util.List<org.eclipse.emf.ecore.EObject> contents = resource.getContents();
		if (contents == null || contents.isEmpty()) {
			return null;
		}
		org.eclipse.emf.ecore.EObject root = contents.get(0);
		return (org.eclipse.emf.ecore.EObject) root;
	}
	
	public static void saveResource(java.io.File file, org.eclipse.emf.ecore.resource.Resource resource) throws java.io.IOException {
		java.util.Map<?, ?> options = java.util.Collections.EMPTY_MAP;
		java.io.OutputStream outputStream = new java.io.FileOutputStream(file);
		resource.save(outputStream, options);
		outputStream.close();
	}
	
	public static String getText(org.eclipse.emf.ecore.EObject eObject) {
		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation metaInformation = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation();
		metaInformation.registerResourceFactory();
		org.eclipse.emf.ecore.resource.ResourceSet rs = null;
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource = (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource) eObject.eResource();
		if (resource != null) {
			rs = resource.getResourceSet();
		}
		if (rs == null) {
			rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		}
		if (resource == null) {
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI("temp." + metaInformation.getSyntaxName());
			resource = (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource) rs.createResource(uri);
		}
		java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextPrinter printer = metaInformation.createPrinter(outputStream, resource);
		try {
			printer.print(eObject);
		} catch (java.io.IOException e) {
			return null;
		}
		return outputStream.toString();
	}
	
	public static boolean containsErrors(org.eclipse.emf.ecore.resource.Resource resource) {
		return !resource.getErrors().isEmpty();
	}
	
	public static boolean containsWarnings(org.eclipse.emf.ecore.resource.Resource resource) {
		return !resource.getWarnings().isEmpty();
	}
	
	public static boolean containsProblems(org.eclipse.emf.ecore.resource.Resource resource) {
		return containsErrors(resource) || containsWarnings(resource);
	}
	
}
