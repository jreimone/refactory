/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class OperatorsDefaultResolverDelegate<ContainerType extends EObject, ReferenceType extends EObject> {
	
	private static class StringMatch {
		
		private String exactMatch;
		private String similarMatch;
		
		public StringMatch() {
			super();
		}
		
		public StringMatch(String exactMatch) {
			super();
			this.exactMatch = exactMatch;
		}
		
		public String getExactMatch() {
			return exactMatch;
		}
		
		public void setSimilarMatch(String similarMatch) {
			this.similarMatch = similarMatch;
		}
		
		public String getSimilarMatch() {
			return similarMatch;
		}
		
	}
	
	/**
	 * The maximal distance between two identifiers according to the Levenshtein
	 * distance to qualify for a quick fix.
	 */
	public int MAX_DISTANCE = 2;
	
	private boolean enableScoping = true;
	
	/**
	 * This is a cache for the external objects that are referenced by the current
	 * resource. We must cache this set because determining this set required to
	 * resolve proxy objects, which causes reference resolving to slow down
	 * exponentially.
	 */
	private Set<EObject> referencedExternalObjects;
	
	/**
	 * We store the number of proxy objects that were present when
	 * <code>referencedExternalObjects</code> was resolved, to recompute this set when
	 * a proxy was resolved. This is required, because a resolved proxy may point to a
	 * new external object.
	 */
	private int oldProxyCount = -1;
	
	private static org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation metaInformation = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation();
	
	protected org.modelrefactoring.evolution.operators.resource.operators.IOperatorsNameProvider nameProvider = metaInformation.createNameProvider();
	
	/**
	 * This standard implementation searches for objects in the resource, which have
	 * the correct type and a name/id attribute matching the identifier. If no
	 * matching object is found, the identifier is used as URI. If the resource at
	 * this URI has a root element of the correct type, this element is returned.
	 */
	public void resolve(String identifier, ContainerType container, EReference reference, int position, boolean resolveFuzzy, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<ReferenceType> result) {
		try {
			EObject root = container;
			if (!enableScoping) {
				root = EcoreUtil.getRootContainer(container);
			}
			while (root != null) {
				boolean continueSearch = tryToResolveIdentifierInObjectTree(identifier, container, root, reference, position, resolveFuzzy, result, !enableScoping);
				if (!continueSearch) {
					return;
				}
				root = root.eContainer();
			}
			boolean continueSearch = tryToResolveIdentifierAsURI(identifier, container, reference, position, resolveFuzzy, result);
			if (continueSearch) {
				Set<EObject> crossReferencedObjectsInOtherResource = findReferencedExternalObjects(container);
				for (EObject externalObject : crossReferencedObjectsInOtherResource) {
					continueSearch = tryToResolveIdentifierInObjectTree(identifier, container, externalObject, reference, position, resolveFuzzy, result, !enableScoping);
					if (!continueSearch) {
						return;
					}
				}
			}
			if (continueSearch) {
				continueSearch = tryToResolveIdentifierInGenModelRegistry(identifier, container, reference, position, resolveFuzzy, result);
			}
		} catch (RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
		}
	}
	
	/**
	 * Returns all EObjects that are referenced by EObjects in the resource that
	 * contains <code>object</code>, but that are located in different resources.
	 */
	protected Set<EObject> findReferencedExternalObjects(EObject object) {
		EObject root = EcoreUtil.getRootContainer(object);
		Map<EObject, Collection<Setting>> proxies = EcoreUtil.ProxyCrossReferencer.find(root);
		int proxyCount = 0;
		for (Collection<Setting> settings : proxies.values()) {
			proxyCount += settings.size();
		}
		// Use the cache if it is still valid
		if (referencedExternalObjects != null && oldProxyCount == proxyCount) {
			return referencedExternalObjects;
		}
		referencedExternalObjects = new LinkedHashSet<EObject>();
		oldProxyCount = proxyCount;
		Set<EObject> referencedExternalObjects = new LinkedHashSet<EObject>();
		referencedExternalObjects.addAll(getExternalObjects(root.eCrossReferences(), object));
		Iterator<EObject> eAllContents = root.eAllContents();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			referencedExternalObjects.addAll(getExternalObjects(next.eCrossReferences(), object));
		}
		return referencedExternalObjects;
	}
	
	/**
	 * Returns all EObjects that are not contained in the same resource as the given
	 * EObject.
	 */
	protected Set<EObject> getExternalObjects(Collection<EObject> objects, EObject object) {
		Set<EObject> externalObjects = new LinkedHashSet<EObject>();
		for (EObject next : objects) {
			if (next.eResource() != object.eResource()) {
				externalObjects.add(next);
			}
		}
		return externalObjects;
	}
	
	/**
	 * Searches for objects in the tree of EObjects that is rooted at
	 * <code>root</code>, which have the correct type and a name/id attribute matching
	 * the identifier. This method can be used to quickly implement custom reference
	 * resolvers which require to search in a particular scope for referenced
	 * elements, rather than in the whole resource as done by resolve().
	 */
	protected boolean tryToResolveIdentifierInObjectTree(String identifier, EObject container, EObject root, EReference reference, int position, boolean resolveFuzzy, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<ReferenceType> result, boolean checkRootFirst) {
		EClass type = reference.getEReferenceType();
		boolean continueSearch;
		if (checkRootFirst) {
			// check whether the root element matches
			continueSearch = checkElement(container, root, reference, position, type, identifier, resolveFuzzy, true, result);
			if (!continueSearch) {
				return false;
			}
		}
		// check the contents
		for (Iterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
			EObject element = iterator.next();
			continueSearch = checkElement(container, element, reference, position, type, identifier, resolveFuzzy, true, result);
			if (!continueSearch) {
				return false;
			}
		}
		// if the root element was already checked, we can return.
		if (checkRootFirst) {
			return true;
		}
		// check whether the root element matches
		continueSearch = checkElement(container, root, reference, position, type, identifier, resolveFuzzy, true, result);
		if (!continueSearch) {
			return false;
		}
		return true;
	}
	
	protected boolean tryToResolveIdentifierAsURI(String identifier, ContainerType container, EReference reference, int position, boolean resolveFuzzy, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<ReferenceType> result) {
		EClass type = reference.getEReferenceType();
		Resource resource = container.eResource();
		if (resource != null) {
			URI uri = getURI(identifier, resource.getURI());
			if (uri != null) {
				EObject element = loadResource(container.eResource().getResourceSet(), uri);
				if (element == null) {
					return true;
				}
				return checkElement(container, element, reference, position, type, identifier, resolveFuzzy, false, result);
			}
		}
		return true;
	}
	
	protected boolean tryToResolveIdentifierInGenModelRegistry(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<ReferenceType> result) {
		EClass type = reference.getEReferenceType();
		
		final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		for (String nextNS : packageNsURIToGenModelLocationMap.keySet()) {
			URI genModelURI = packageNsURIToGenModelLocationMap.get(nextNS);
			try {
				final ResourceSet rs = container.eResource().getResourceSet();
				Resource genModelResource = rs.getResource(genModelURI, true);
				if (genModelResource == null) {
					continue;
				}
				final List<EObject> contents = genModelResource.getContents();
				if (contents == null || contents.size() == 0) {
					continue;
				}
				EObject genModel = contents.get(0);
				boolean continueSearch = checkElement(container, genModel, reference, position, type, identifier, resolveFuzzy, false, result);
				if (!continueSearch) {
					return false;
				}
			} catch (Exception e) {
				// ignore exceptions that are raised by faulty genmodel registrations
			}
		}
		return true;
	}
	
	protected boolean checkElement(EObject container, EObject element, EReference reference, int position, EClass type, String identifier, boolean resolveFuzzy, boolean checkStringWise, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<ReferenceType> result) {
		if (element.eIsProxy()) {
			return true;
		}
		
		boolean hasCorrectType = hasCorrectEType(element, type);
		if (!hasCorrectType) {
			return true;
		}
		
		StringMatch match;
		// do not compare string-wise if identifier is a URI
		if (checkStringWise) {
			match = matches(element, identifier, resolveFuzzy);
		} else {
			match = new StringMatch(identifier);
		}
		String exactMatch = match.getExactMatch();
		if (exactMatch == null) {
			String similarMatch = match.getSimilarMatch();
			if (similarMatch != null) {
				EObject oldTarget;
				Object value = container.eGet(reference);
				if (value instanceof List) {
					List<?> list = (List<?>) container.eGet(reference);
					oldTarget = (EObject) list.get(position);
				} else {
					oldTarget = (EObject) container.eGet(reference, false);
				}
				result.addQuickFix(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsChangeReferenceQuickFix("Replace with " + similarMatch, "IMG_TOOL_FORWARD", container, reference, oldTarget, element));
			}
			return true;
		}
		// we can safely cast 'element' to 'ReferenceType' here, because we've checked the
		// type of 'element' against the type of the reference. unfortunately the compiler
		// does not know that this is sufficient, so we must call cast(), which is not
		// type safe by itself.
		result.addMapping(exactMatch, cast(element));
		if (!resolveFuzzy) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method encapsulates an unchecked cast from EObject to ReferenceType. We
	 * cannot do this cast strictly type safe, because type parameters are erased by
	 * compilation. Thus, an instanceof check cannot be performed at runtime.
	 */
	@SuppressWarnings("unchecked")
	
	protected ReferenceType cast(EObject element) {
		return (ReferenceType) element;
	}
	
	protected String produceDeResolveErrorMessage(EObject refObject, EObject container, EReference reference, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
		String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";
		return msg;
	}
	
	protected String deResolve(ReferenceType element, ContainerType container, EReference reference) {
		Resource elementResource = element.eResource();
		// For elements in external resources we return the resource URI instead of the
		// name of the element.
		if (elementResource != null && !elementResource.equals(container.eResource())) {
			return elementResource.getURI().toString();
		}
		return getName(element);
	}
	
	protected StringMatch matches(EObject element, String identifier, boolean matchFuzzy) {
		for (Object name : getNames(element)) {
			StringMatch match = matches(identifier, name, matchFuzzy);
			if (match.getExactMatch() != null) {
				return match;
			}
		}
		return new StringMatch();
	}
	
	/**
	 * This method is only kept for compatibility reasons. The current version
	 * delegates all calls to a name provider, but previous custom implementation of
	 * this class may have overridden this method.
	 */
	public List<String> getNames(EObject element) {
		return nameProvider.getNames(element);
	}
	
	protected StringMatch matches(String identifier, Object attributeValue, boolean matchFuzzy) {
		if (attributeValue != null && attributeValue instanceof String) {
			String name = (String) attributeValue;
			if (name.equals(identifier) || matchFuzzy) {
				return new StringMatch(name);
			}
			if (isSimilar(name, identifier)) {
				StringMatch match = new StringMatch();
				match.setSimilarMatch(name);
				return match;
			}
		}
		return new StringMatch();
	}
	
	protected String getName(ReferenceType element) {
		String deresolvedReference = null;
		if (element instanceof EObject) {
			EObject eObjectToDeResolve = (EObject) element;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				// If the proxy was created by EMFText, we can try to recover the identifier from
				// the proxy URI
				if (deresolvedReference != null && deresolvedReference.startsWith(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		if (deresolvedReference != null) {
			return deresolvedReference;
		}
		// if the referenced element was not a proxy, we try the same magic that was used
		// while resolving elements to obtain names for elements
		List<String> names = getNames(element);
		for (String name : names) {
			if (name != null) {
				return name;
			}
		}
		return null;
	}
	
	protected boolean hasCorrectEType(EObject element, EClass expectedTypeEClass) {
		if (expectedTypeEClass.getInstanceClass() == null) {
			return expectedTypeEClass.isInstance(element);
		}
		return hasCorrectType(element, expectedTypeEClass.getInstanceClass());
	}
	
	protected boolean hasCorrectType(EObject element, Class<?> expectedTypeClass) {
		return expectedTypeClass.isInstance(element);
	}
	
	protected EObject loadResource(ResourceSet resourceSet, URI uri) {
		try {
			Resource resource = resourceSet.getResource(uri, true);
			EList<EObject> contents = resource.getContents();
			if (contents.size() > 0) {
				return contents.get(0);
			}
		} catch (RuntimeException re) {
			// do nothing here. if no resource can be loaded the uriString is probably not a
			// valid resource URI
		}
		return null;
	}
	
	protected URI getURI(String identifier, URI baseURI) {
		if (identifier == null) {
			return null;
		}
		try {
			URI uri = URI.createURI(identifier);
			if (uri.isRelative()) {
				uri = uri.resolve(baseURI);
			}
			return uri;
		} catch (IllegalArgumentException iae) {
			// the identifier string is not a valid URI
			return null;
		}
	}
	
	protected org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceCache getCache(EObject object) {
		EObject root = EcoreUtil.getRootContainer(object);
		Adapter adapter = org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsEObjectUtil.getEAdapter(root, org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsReferenceCache.class);
		org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsReferenceCache cache = org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsCastUtil.cast(adapter);
		if (cache != null) {
			return cache;
		} else {
			// cache does not exist. create a new one.
			cache = new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsReferenceCache(nameProvider);
			cache.initialize(root);
			root.eAdapters().add(cache);
			return cache;
		}
	}
	
	public void setEnableScoping(boolean enableScoping) {
		this.enableScoping = enableScoping;
	}
	
	public boolean getEnableScoping() {
		return enableScoping;
	}
	
	protected boolean isSimilar(String identifier, Object attributeValue) {
		if (attributeValue != null && attributeValue instanceof String) {
			String name = (String) attributeValue;
			if (org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStringUtil.computeLevenshteinDistance(identifier, name) <= MAX_DISTANCE) {
				return true;
			}
		}
		return false;
	}
	
}
