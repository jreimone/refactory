package org.ontomore.util;

import java.util.List;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IEqualityHelperFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;

/**
 * Prints the diff and match model.
 * 
 * @author Erik Tittel
 */
public class DiffAndMatchModelPrinter {

	public static void printMatchAndDiffModel(EObject model1, EObject model2) {
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IEqualityHelperFactory helperFactory = new DefaultEqualityHelperFactory();
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
		IComparisonScope scope = EMFCompare.createDefaultScope(model1, model2);
		Comparison comparison = comparator.compare(scope);
		List<Diff> differences = comparison.getDifferences();
		printModel("Diff Model", differences);
		List<Match> matches = comparison.getMatches();
		printModel("Match Model", matches);
	}

	private static void printModel(String name, List<? extends EObject> objects) {
		System.out.println(name + ":\n");
		for (EObject eObject : objects) {
			System.out.println(eObject);
		}
	}
}
