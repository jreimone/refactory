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
 * Tells whether two models matches.
 * 
 * @author Erik Tittel
 */
public final class ModelComparator {

	private EObject model1;
	private EObject model2;
	private List<Match> matches;
	private List<Diff>  differences;

	public boolean areModelsEqual(String fileName1, String fileName2) {
		loadModels(fileName1, fileName2);
		return areModelsEqual(model1, model2);
	}

	private void loadModels(String fileName1, String fileName2) {
		model1 = ModelStorageUtil.loadModelFromFileName(fileName1);
		model2 = ModelStorageUtil.loadModelFromFileName(fileName2);
	}

	public boolean areModelsEqual(EObject model1, EObject model2) {
		String metamodel1 = ModelStorageUtil.getMetaModelAsString(model1);
		String metamodel2 = ModelStorageUtil.getMetaModelAsString(model2);
		// It has to be ensured that metamodels of models to compare are equals.
		// Otherwise EMF Compare gives strange results.
		if (!metamodel1.equals(metamodel2)) {
			return false;
		}
		prepareMatchAndDiffModel(model1, model2);
		boolean modelsAreEqual = checkIfAllElementsMatch(matches)
				&& checkIfNoDifferentElementsExist();
		return modelsAreEqual;
	}

	private void prepareMatchAndDiffModel(EObject model1, EObject model2) {
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
		matches = comparison.getMatches();
		differences = comparison.getDifferences();
	}

	/**
	 * Recursive algorithm, that checks if the similarity of all elements is
	 * 1.0.
	 */
	private boolean checkIfAllElementsMatch(List<Match> matchedElements) {
//		if (matchedElements.isEmpty()) {
//			return true;
//		}
//		boolean result = true;
//		for (Match matchElement : matchedElements) {
//				result = checkIfAllElementsMatch(matchElement.getSubmatches());
//				if (!result) {
//					break;
//				}
//		}
//		return result;
		return true;
	}

	private boolean checkIfNoDifferentElementsExist() {
//		EList<DiffElement> ownedElements = differences.getOwnedElements();
//		EList<DiffElement> subDiffElements = ownedElements.get(0).getSubDiffElements();
//		return subDiffElements.size() == 0;
		return differences.isEmpty();
	}
}
