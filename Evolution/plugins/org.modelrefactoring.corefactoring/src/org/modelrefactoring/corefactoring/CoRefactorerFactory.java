package org.modelrefactoring.corefactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;
import org.modelrefactoring.evolution.registry.IKnowledgeBaseRegistry;

public class CoRefactorerFactory {

	/**
	 * Creates a list of co-refactorers dependent on the given <code>refactorer</code>.
	 * Each co-refactorer is for one (initial model)-(dependent model) combination.
	 * @param refactorer
	 */
	public List<CoRefactorer> getCoRefactorers(IRefactorer refactorer) {
		IRefactoringInterpreter interpreter = refactorer.getInterpreter();
		List<EObject> boundElements = new ArrayList<EObject>();
		Map<Role, List<EObject>> roleBindings = interpreter.getRoleRuntimeInstances();
		for (Role role : roleBindings.keySet()) {
			boundElements.addAll(roleBindings.get(role));
		}
		// TODO use bound elements or input???
		Map<EObject, Collection<EObject>> dependencyMap = new HashMap<EObject, Collection<EObject>>();
		List<IKnowledgeBase> knowledgeBases = IKnowledgeBaseRegistry.INSTANCE.getKnowledgeBases();
		for (IKnowledgeBase knowledgeBase : knowledgeBases) {
			for (EObject element : boundElements) {
				Resource resource = element.eResource();
				URI uri = resource.getURI();
				dependencyMap.putAll(knowledgeBase.getDependencies(uri, resource.getResourceSet()));
			}
		}
		List<CoRefactorer> coRefactorers = new ArrayList<CoRefactorer>();
		for (EObject dependentModel : dependencyMap.keySet()) {
			Collection<EObject> dependentElements = dependencyMap.get(dependentModel);
			List<EObject> elements = Arrays.asList(dependentElements.toArray(new EObject[]{}));
			CoRefactorer coRefactorer = new CoRefactorerImpl(refactorer, dependentModel, elements);
			coRefactorers.add(coRefactorer);
		}
		return coRefactorers;
	}
}
