package org.modelrefactoring.corefactoring.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;

public class TestKnowledgeBase implements IKnowledgeBase {

	private Map<EObject, List<EObject>> dependencies = new HashMap<>();

	@Override
	public void generateKnowledge(Resource resource) {
		// nothing more to be generated
	}

	@Override
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs) {
		for (EObject source : dependencies.keySet()) {
			URI originalUri = source.eResource().getURI();
			if(originalUri.equals(uri)){
				Map<EObject, Collection<EObject>> result = new HashMap<>();
				List<EObject> dependentElements = dependencies.get(source);
				for (EObject target : dependentElements) {
					EObject root = EcoreUtil.getRootContainer(target);
					Collection<EObject> specificDependencies = result.get(root);
					if(specificDependencies == null){
						specificDependencies = new ArrayList<>();
						result.put(root, specificDependencies);
					}
					if(!specificDependencies.contains(target)){
						specificDependencies.add(target);
					}
				}
				return result;
			}
		}
		return null;
	}

	public void addDependency(EObject source, EObject target) {
		List<EObject> dependentElements = dependencies.get(source);
		if(dependentElements == null){
			dependentElements = new ArrayList<>();
			dependencies.put(source, dependentElements);
		}
		if(!dependentElements.contains(target)){
			dependentElements.add(target);
		}
	}

	@Override
	public Collection<EObject> getDependencies(EObject element) {
		return dependencies.get(element);
	}

}
