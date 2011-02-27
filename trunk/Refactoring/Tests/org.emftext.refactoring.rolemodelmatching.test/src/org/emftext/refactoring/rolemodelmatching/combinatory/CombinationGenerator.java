package org.emftext.refactoring.rolemodelmatching.combinatory;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class CombinationGenerator <ElementType> {

	private int[] a;
	private int n;
	private int r;
	private BigInteger numLeft;
	private BigInteger total;


	private void init(int n, int r) {
		if (r > n) {
			throw new IllegalArgumentException();
		}
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.r = r;
		a = new int[r];
		BigInteger nFact = getFactorial(n);
		BigInteger rFact = getFactorial(r);
		BigInteger nminusrFact = getFactorial(n - r);
		total = nFact.divide(rFact.multiply(nminusrFact));
		reset();
	}

	// ------
	// Reset
	// ------

	private void reset() {
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		numLeft = new BigInteger(total.toString());
	}


	// -----------------------------
	// Are there more combinations?
	// -----------------------------

	private boolean hasMore() {
		return numLeft.compareTo(BigInteger.ZERO) == 1;
	}

	// ------------------
	// Compute factorial
	// ------------------

	private static BigInteger getFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = n; i > 1; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

	// --------------------------------------------------------
	// Generate next combination (algorithm from Rosen p. 286)
	// --------------------------------------------------------

	private int[] getNext() {

		if (numLeft.equals(total)) {
			numLeft = numLeft.subtract(BigInteger.ONE);
			return a;
		}

		int i = r - 1;
		while (a[i] == n - r + i) {
			i--;
		}
		a[i] = a[i] + 1;
		for (int j = i + 1; j < r; j++) {
			a[j] = a[i] + j - i;
		}

		numLeft = numLeft.subtract(BigInteger.ONE);
		return a;

	}

	public List<List<ElementType>> getCombinations(List<ElementType> input, int count) {
		List<List<ElementType>> combinations = new LinkedList<List<ElementType>>();
		if(input.size() == 0){
			return combinations;
		}
		init(input.size(), count);
		int[] indices;
		while (hasMore()) {
			List<ElementType> combination = new LinkedList<ElementType>();
			combinations.add(combination);
			indices = getNext();
			for (int i = 0; i < indices.length; i++) {
				combination.add(input.get(indices[i]));
			}
		}
		return combinations;
	}
}