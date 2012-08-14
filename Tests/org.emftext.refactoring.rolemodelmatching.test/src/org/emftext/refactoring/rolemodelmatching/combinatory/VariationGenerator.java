/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
