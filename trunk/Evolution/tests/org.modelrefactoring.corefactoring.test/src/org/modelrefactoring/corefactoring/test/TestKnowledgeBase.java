package org.modelrefactoring.corefactoring.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.owl.Class;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;

public class TestKnowledgeBase implements IKnowledgeBase {

	private Class fromOwlClass;
	private EClass toEcoreClass;

	public TestKnowledgeBase(org.emftext.language.owl.Class fromOwlClass, EClass toEcoreClass) {
		this.fromOwlClass = fromOwlClass;
		this.toEcoreClass = toEcoreClass;
	}

	@Override
	public void generateKnowledge(Resource resource) {
		// nothing more to be generated
	}

	@Override
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs) {
		URI originalUri = fromOwlClass.eResource().getURI();
		if(!originalUri.equals(uri)){
			return null;
		}
		Map<EObject, Collection<EObject>> result = new HashMap<>();
		List<EObject> dependencies = new ArrayList<>();
		dependencies.add(toEcoreClass);
		result.put(fromOwlClass, dependencies);
		return result;
	}

}
