package org.emftext.refactoring.rolemodelmatching;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class CombinatoryTest {

	@Test
	public void testVariations() {
		List<Object> elements = new LinkedList<Object>();
		elements.add("J");
		elements.add("a");
		elements.add("n");
		CombinationGenerator<Object> combinationsGenerator = new CombinationGenerator<Object>();
		List<List<Object>> combinations = combinationsGenerator.getCombinations(elements, 3);
		System.out.println("Combinations:");
		for (List<Object> list : combinations) {
			for (Object object : list) {
				System.out.print(object + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Permutations:");
		PermutationGenerator<Object> permutationsGenerator = new PermutationGenerator<Object>();
		StringBuffer combinationPermutation = new StringBuffer();
		for (List<Object> combination : combinations) {
			List<List<Object>> permutations = permutationsGenerator.getPermutations(combination);
			for (List<Object> list : permutations) {
				for (Object object : list) {
					combinationPermutation.append(object + " ");
				}
				combinationPermutation.append("\n");
			}
		}
		System.out.println(combinationPermutation.toString());
		System.out.println("Variations:");
		VariationGenerator<Object> variationsGenerator = new VariationGenerator<Object>();
		StringBuffer variationsBuffer = new StringBuffer();
		List<List<Object>> variations = variationsGenerator.getVariations(elements, 3);
		for (List<Object> variation : variations) {
			for (Object object : variation) {
				variationsBuffer.append(object + " ");
			}
			variationsBuffer.append("\n");
		}
		System.out.println(variationsBuffer.toString());
		String first = combinationPermutation.toString();
		String second = variationsBuffer.toString();
		assertEquals(first, second);
	}

}
