package org.emftext.refactoring.smell.calculation.custom;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.StructureImpl;


public class StructureCustom extends StructureImpl {

	private static final Map<String, AdvancedIncQueryEngine> resourceUriEngineMap = new HashMap<String, AdvancedIncQueryEngine>();

	public StructureCustom(){
		setMonotonicity(Monotonicity.DECREASING);
	}

	/**
	 * Runs IncQuery Pattern
	 * @model
	 */
	public CalculationResult calculate(EObject model, float threshold){
		CalculationResult result = null;
		Pattern pattern = getPattern();
		Resource resource = model.eResource();
		if(resource != null){
			ResourceSet resourceSet = resource.getResourceSet();
			if(resourceSet != null){
				try {
					result = unmanagedEngineQuery(pattern, resource, resourceSet);

//					result = managedEngineQuery(pattern, resourceSet);
					// IncQuery version 0.7
					//					IQuerySpecification<?> querySpecification = QuerySpecificationRegistry.getOrCreateQuerySpecification(pattern);
					//					if(querySpecification != null){
					//						// TODO try passing only the resource
					//						IncQueryEngine engine = IncQueryEngine.on(resourceSet);
					//						// TODO try the following one day for better handling of the engine when the editor is closed and opened again
					//						// attention: then engine.wipe() and engine.dispose() must be called if use finished
					////						IncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
					//						IncQueryMatcher<? extends IPatternMatch> matcher = querySpecification.getMatcher(engine);
					//						Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
					//						result = getResultFromMatches(matches);
					//					}
					// old IncQuery version
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	protected CalculationResult unmanagedEngineQuery(Pattern pattern, Resource resource, ResourceSet resourceSet)
			throws IncQueryException {
		// TODO try the following one day for better handling of the engine when the editor is closed and opened again
		// attention: then engine.wipe() and engine.dispose() must be called if use finished
		// more information here: https://wiki.eclipse.org/EMFIncQuery/UserDocumentation/API/Advanced#The_IncQuery_Generic_API
		//					IncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
		URI uri = resource.getURI();
		String resourceUriString = uri.toString();
		AdvancedIncQueryEngine engine = resourceUriEngineMap.get(resourceUriString);
		if(engine == null){
			List<Resource> resources = resourceSet.getResources();
			for (Resource containingResource : resources) {
				uri = containingResource.getURI();
				String containingResourceUriString = uri.toString();
				engine = resourceUriEngineMap.get(containingResourceUriString);
				if(engine != null){
					resourceUriEngineMap.put(resourceUriString, engine);
					break;
				}
			}
			if(engine == null){
				engine = AdvancedIncQueryEngine.createUnmanagedEngine(resourceSet);
				resourceUriEngineMap.put(resourceUriString, engine);
				for (Resource containingResource : resources) {
					uri = containingResource.getURI();
					String containingResourceUriString = uri.toString();
					resourceUriEngineMap.put(containingResourceUriString, engine);
				}
			}
		}
		// A specification builder is used to translate patterns to query specifications
		SpecificationBuilder builder = new SpecificationBuilder();
		// attempt to retrieve a registered query specification		    
		IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> querySpecification = builder.getOrCreateSpecification(pattern);
		IncQueryMatcher<? extends IPatternMatch> matcher = engine.getMatcher(querySpecification);
		CalculationResult result = null;
		if (matcher!=null) {
			Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
			result = getResultFromMatches(matches);
		}
//					engine.wipe();
		return result;
	}

	private CalculationResult managedEngineQuery(Pattern pattern, ResourceSet resourceSet) throws IncQueryException {
		// TODO try passing only the resource
		//					IncQueryEngine engine = IncQueryEngine.on(resource);
		IncQueryEngine engine = IncQueryEngine.on(resourceSet);
		// A specification builder is used to translate patterns to query specifications
		SpecificationBuilder builder = new SpecificationBuilder();
		// attempt to retrieve a registered query specification		    
		IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> querySpecification = builder.getOrCreateSpecification(pattern);
		IncQueryMatcher<? extends IPatternMatch> matcher = engine.getMatcher(querySpecification);
		CalculationResult result = null;
		if (matcher!=null) {
			Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
			result = getResultFromMatches(matches);
		}
		return result;
	}

	private CalculationResult getResultFromMatches(Collection<? extends IPatternMatch> matches) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		for (IPatternMatch match : matches) {
			List<String> parameterNames = match.parameterNames();
			for (String name : parameterNames) {
				Object object = match.get(name);
				if(object instanceof EObject){
					EObject element = (EObject) object;
					result.getCausingObjects().add(element);
				}
			}
			result.setResultingValue(result.getResultingValue() + 1);
		}
		return result;
	}
}