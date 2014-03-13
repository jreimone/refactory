package org.modelrefactoring.evolution.prolog.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelrefactoring.evolution.prolog.IPrologGenerator;
import org.modelrefactoring.evolution.prolog.registry.IPrologRegistry;
import org.modelrefactoring.evolution.prolog.registry.PrologUtil;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoMoreSolutionException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;

public class PrologKnowledgeBase implements IKnowledgeBase {

	private static final String VAR_TARGET_ELEMENT		= "TargetElement";
	private static final String VAR_SOURCE_ELEMENT_URI	= "SourceElementUri";
	private static final String VAR_TARGET_ELEMENT_URI	= "TargetElementUri";
	private static final String VAR_TARGET_MODEL		= "TargetModel";
	private static final String VAR_TARGET_MODEL_URI	= "TargetModelUri";
	
	private Map<EObject, Collection<EObject>> modelChildrenMap;
	
	@Override
	public void generateKnowledge(Resource resource) {
		IPrologGenerator generator = IPrologGenerator.INSTANCE;
		if(resource != null){
			for (EObject model : resource.getContents()) {
				generator.generateTheoryAndAddToKnowledgebase(model);
			}
		}
	}

	@Override
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs) {
		modelChildrenMap = new HashMap<EObject, Collection<EObject>>();
		IPrologRegistry registry = IPrologRegistry.INSTANCE;
		Prolog engine = registry.getEngine();
		String query = "implicit(" + PrologUtil.makeStringAtomic(uri.toString()) + "," + VAR_TARGET_ELEMENT + ",_," + VAR_SOURCE_ELEMENT_URI + "," + VAR_TARGET_ELEMENT_URI + ").";
//		System.out.println(query);
		try {
			List<SolveInfo> results = solveQuery(engine, query);
			for (SolveInfo result : PrologUtil.removeDuplicates(results)) {
				if (result.isSuccess()){
//					String sourceElementUriString = PrologUtil.unescapeCharacters(PrologUtil.removeApostrophe(result.getVarValue(VAR_SOURCE_ELEMENT_URI).toString()));
					String targetElementUriString = PrologUtil.unescapeCharacters(PrologUtil.removeApostrophe(result.getVarValue(VAR_TARGET_ELEMENT_URI).toString()));
					String targetElementString = result.getVarValue(VAR_TARGET_ELEMENT).toString();
					String targetModelQuery = "elementtoresourcemapping(" + targetElementString + ", " + VAR_TARGET_MODEL + ").";
//					System.out.println(targetModelQuery);
					SolveInfo modelResult = engine.solve(targetModelQuery);
					String targetModel = modelResult.getVarValue(VAR_TARGET_MODEL).toString();
					String targetModelUriQuery = "uri(" + targetModel + "," + VAR_TARGET_MODEL_URI + ").";
//					System.out.println(targetModelUriQuery);
					SolveInfo modelUriResult = engine.solve(targetModelUriQuery);
					String targetModelUriString = PrologUtil.unescapeCharacters(PrologUtil.removeApostrophe(modelUriResult.getVarValue(VAR_TARGET_MODEL_URI).toString()));
					URI targetModelUri = URI.createURI(targetModelUriString);
					rs.getResource(targetModelUri, true);
					URI targetElementUri = URI.createURI(targetElementUriString);
					EObject targetElement = rs.getEObject(targetElementUri, true);
					addToMap(targetElement);
				}
			}
		} catch (MalformedGoalException e) {
			e.printStackTrace();
		} catch (NoSolutionException e) {
			e.printStackTrace();
		} 
		return modelChildrenMap;
	}


	private List<SolveInfo> solveQuery(Prolog engine, String query) {
		if(engine == null || query == null){
			return null;
		}
		List<SolveInfo> results = new ArrayList<SolveInfo>();
		try {
			SolveInfo result = engine.solve(query);
			results.add(result);
			while (engine.hasOpenAlternatives()) {
				results.add(engine.solveNext());
			}
		} catch (MalformedGoalException e) {
			e.printStackTrace();
		} catch (NoMoreSolutionException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	private void addToMap(EObject targetElement) {
		EObject model = EcoreUtil.getRootContainer(targetElement, true);
		if(model == null){
			model = targetElement;
		}
		Collection<EObject> children = modelChildrenMap.get(model);
		if(children == null){
			children = new HashSet<EObject>();
			modelChildrenMap.put(model, children);
		}
		if(!model.equals(targetElement)){
			children.add(targetElement);
		}
	}

	@Override
	public Collection<EObject> getDependencies(EObject element) {
		Resource resource = element.eResource();
		ResourceSet rs = null;
		URI uri = null;
		if(resource != null){
			uri = resource.getURI();
			rs = resource.getResourceSet();
		} else {
			uri = EcoreUtil.getURI(element);
			rs = new ResourceSetImpl();
		}
		Map<EObject, Collection<EObject>> dependencies = getDependencies(uri, rs);
		return dependencies.get(element);
	}
}
