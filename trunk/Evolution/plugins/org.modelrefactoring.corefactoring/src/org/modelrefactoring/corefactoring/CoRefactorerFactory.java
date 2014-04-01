package org.modelrefactoring.corefactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;
import org.modelrefactoring.evolution.registry.IKnowledgeBaseRegistry;

public class CoRefactorerFactory {

	/**
	 * Creates a list of co-refactorers dependent on the given <code>refactorer</code>.
	 * Each co-refactorer is for one (initial model)-(dependent model) combination.
	 * @param refactorer
	 */
	public List<CoRefactorer> getCoRefactorers(IRefactorer refactorer) {
		List<EObject> boundElements = new ArrayList<EObject>();
		Map<Role, List<EObject>> roleBindings = refactorer.getInterpreter().getRoleBindings();
		for (Role role : roleBindings.keySet()) {
			boundElements.addAll(roleBindings.get(role));
		}
		// TODO use bound elements or input???
		Map<EObject, Collection<EObject>> dependencyMap = new HashMap<EObject, Collection<EObject>>();
		List<IKnowledgeBase> knowledgeBases = IKnowledgeBaseRegistry.INSTANCE.getKnowledgeBases();
		for (IKnowledgeBase knowledgeBase : knowledgeBases) {
			for (EObject element : boundElements) {
				Collection<EObject> dependencies = knowledgeBase.getDependencies(element);
				if(dependencies != null){
					for (EObject dependency : dependencies) {
						EObject model = EcoreUtil.getRootContainer(dependency, true);
						Collection<EObject> modelDependencies = dependencyMap.get(model);
						if(modelDependencies == null){
							modelDependencies = new ArrayList<EObject>();
							dependencyMap.put(model, modelDependencies);
						}
						if(!modelDependencies.contains(dependency)){
							modelDependencies.add(dependency);
						}
					}
				}
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
