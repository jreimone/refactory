/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.coral.resource.coral.analysis;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaProject;
import org.emftext.commons.jdt.JDTJavaClassifier;
import org.emftext.commons.jdt.resolve.JDTClassifierResolver;

import dk.itu.sdg.language.coral.PublicType;
import dk.itu.sdg.language.coral.resource.coral.ICoralReferenceResolveResult;

public class PublicTypeTypeReferenceResolver implements dk.itu.sdg.language.coral.resource.coral.ICoralReferenceResolver<dk.itu.sdg.language.coral.PublicType, org.emftext.commons.jdt.JDTJavaClassifier> {
	
	private final static class JDTClassCache extends AdapterImpl {
		
		private List<JDTJavaClassifier> classesInClassPath;

		public JDTClassCache(URI uri) {
			JDTClassifierResolver resolver = new JDTClassifierResolver();
			IJavaProject javaProject = resolver.getJavaProject(uri);
			if (javaProject == null) {
				return;
			}
			classesInClassPath = resolver.getAllClassifiersInClassPath(javaProject);
		}

		public List<JDTJavaClassifier> getClassifiersInClassPath() {
			return classesInClassPath;
		}
	}
	
//	private CoralDefaultResolverDelegate<PublicType, JDTJavaClassifier> delegate = new CoralDefaultResolverDelegate<PublicType, JDTJavaClassifier>();
	
	public void resolve(String identifier, PublicType container, EReference reference, int position, boolean resolveFuzzy, final ICoralReferenceResolveResult<JDTJavaClassifier> result) {
//		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		JDTClassCache cache = null;
		EList<Adapter> eAdapters = container.eResource().getResourceSet().eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof JDTClassCache) {
				cache = (JDTClassCache) adapter;
			}
		}
		// no cache found - create a new one
		if (cache == null) {
			cache = new JDTClassCache(container.eResource().getURI());
			eAdapters.add(cache);
		}
		
		for (JDTJavaClassifier jdtJavaClass : cache.getClassifiersInClassPath()) {
			String qualifiedName = jdtJavaClass.getQualifiedName();
			if (resolveFuzzy || identifier.equals(qualifiedName)) {
				result.addMapping(qualifiedName, jdtJavaClass);
			}
		}
	}
	
	public String deResolve(JDTJavaClassifier element, PublicType container, EReference reference) {
//		return delegate.deResolve(element, container, reference);
		return element.getQualifiedName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
	
}
