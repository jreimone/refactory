package org.emftext.refactoring.smell.calculation.custom;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.extensibility.QuerySpecificationRegistry;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.StructureImpl;


public class StructureCustom extends StructureImpl {

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
					IQuerySpecification<?> querySpecification = QuerySpecificationRegistry.getOrCreateQuerySpecification(pattern);
					if(querySpecification != null){
						// TODO try passing only the resource
						IncQueryEngine engine = IncQueryEngine.on(resourceSet);
						// TODO try the following one day
						// attention: then engine.wipe() and engine.dispose() must be called if use finished
//						IncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
						IncQueryMatcher<? extends IPatternMatch> matcher = querySpecification.getMatcher(engine);
						Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
						result = getResultFromMatches(matches);
					}
					// old IncQuery version
//					@SuppressWarnings("unchecked")
//					IMatcherFactory<IncQueryMatcher<IPatternMatch>> matcherFactory = (IMatcherFactory<IncQueryMatcher<IPatternMatch>>) MatcherFactoryRegistry.getOrCreateMatcherFactory(pattern);
//					if(matcherFactory != null){
//						IncQueryEngine engine = EngineManager.getInstance().getIncQueryEngine(resourceSet);
//						IncQueryMatcher<IPatternMatch> matcher = matcherFactory.getMatcher(engine);
//						// the above two lines can be replaced by the following single line
//						// here the matcher must be retrieved by the resourceSet because passing only a resource
//						// no matches are calculated
////						IncQueryMatcher<IPatternMatch> matcher = matcherFactory.getMatcher(resourceSet);
//						Collection<IPatternMatch> matches = matcher.getAllMatches();
//						result = getResultFromMatches(matches);
////						engine.wipe();
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
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