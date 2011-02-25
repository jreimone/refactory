package org.emftext.refactoring.rolemodelmatching.combinatory;

import java.util.LinkedList;
import java.util.List;

public class VariationGenerator <ElementType>{

	public List<List<ElementType>> getVariations(List<ElementType> input, int selection){
		List<List<ElementType>> variations = new LinkedList<List<ElementType>>();
		CombinationGenerator<ElementType> combinationsGenerator = new CombinationGenerator<ElementType>();
		List<List<ElementType>> combinations = combinationsGenerator.getCombinations(input, selection);
		PermutationGenerator<ElementType> permutationsGenerator = new PermutationGenerator<ElementType>();
		for (List<ElementType> combination : combinations) {
			List<List<ElementType>> permutations = permutationsGenerator.getPermutations(combination);
			for (List<ElementType> permutation : permutations) {
				variations.add(permutation);
			}
		}
		return variations;
	}
}