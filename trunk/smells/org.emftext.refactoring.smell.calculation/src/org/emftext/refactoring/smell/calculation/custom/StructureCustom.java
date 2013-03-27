package org.emftext.refactoring.smell.calculation.custom;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.extensibility.MatcherFactoryRegistry;
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
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		Pattern pattern = getPattern();
		Resource resource = model.eResource();
		if(resource != null){
			try {
				@SuppressWarnings("unchecked")
				IMatcherFactory<IncQueryMatcher<IPatternMatch>> matcherFactory = (IMatcherFactory<IncQueryMatcher<IPatternMatch>>) MatcherFactoryRegistry.getOrCreateMatcherFactory(pattern);
				if(matcherFactory != null){
					final IncQueryMatcher<IPatternMatch> matcher = matcherFactory.getMatcher(resource);
					matcher.forEachMatch(new IMatchProcessor<IPatternMatch>() {

						@Override
						public void process(IPatternMatch match) {
							System.out.println();
						}
					});
					
					String[] parameterNames2 = matcher.getParameterNames();
					for (String string : parameterNames2) {
						int index = matcher.getPositionOfParameter(string);
						Variable variable = pattern.getParameters().get(index);
						IPatternMatch partialMatch = matcher.newMatch(variable);
						Collection<IPatternMatch> matches = matcher.getAllMatches(partialMatch);
						System.out.println();
					}
					
					
					Collection<IPatternMatch> matches = matcher.getAllMatches();
					for (IPatternMatch match : matches) {
						String[] parameterNames = match.parameterNames();
						for (String name : parameterNames) {
							Object object = match.get(name);
							if(object instanceof EObject){
								EObject element = (EObject) object;
								result.getCausingObjects().add(element);
							}
						}
						result.setResultingValue(result.getResultingValue() + 1);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}