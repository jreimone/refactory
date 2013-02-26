package org.emftext.refactoring.smell.calculation.custom;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.MatcherFactoryRegistry;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.StructureImpl;


public class StructureCustom extends StructureImpl {
	
	public StructureCustom(){
		setMonotonicity(Monotonicity.DECREASING);
	}
	
	public CalculationResult calculate(EObject model, float threshold){
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		Pattern pattern = getPattern();
		Resource resource = model.eResource();
		if(resource != null){
			ResourceSet rs = resource.getResourceSet();
			@SuppressWarnings("unchecked")
			IMatcherFactory<IncQueryMatcher<IPatternMatch>> matcherFactory = (IMatcherFactory<IncQueryMatcher<IPatternMatch>>) MatcherFactoryRegistry.getOrCreateMatcherFactory(pattern);
			try {
				final IncQueryMatcher<IPatternMatch> matcher = matcherFactory.getMatcher(rs);
				String[] parameterNames = matcher.getParameterNames();
				matcher.forEachMatch(new IMatchProcessor<IPatternMatch>() {
					@Override
					public void process(IPatternMatch match) {
						String[] parameterNames2 = match.parameterNames();
						for (String name : parameterNames2) {
							Set<Object> values = matcher.getAllValues(name);
							Object object = match.get(name);
							System.out.println(match.prettyPrint());
						}
						
					}
				});
				Collection<IPatternMatch> matches = matcher.getAllMatches();
				
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}