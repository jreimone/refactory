package org.emftext.refactoring.rolemodelmatching;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PermutationGenerator <ElementType>{

	private int[] a;
	private BigInteger numLeft;
	private BigInteger total;

	// -----------------------------------------------------------
	// Constructor. WARNING: Don't make n too large.
	// Recall that the number of permutations is n!
	// which can be very large, even when n is as small as 20 --
	// 20! = 2,432,902,008,176,640,000 and
	// 21! is too big to fit into a Java long, which is
	// why we use BigInteger instead.
	// ----------------------------------------------------------

	private void init(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("Min 1");
		}
		a = new int[n];
		total = getFactorial(n);
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
	// Are there more permutations?
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
	// Generate next permutation (algorithm from Rosen p. 284)
	// --------------------------------------------------------

	private int[] getNext() {

		if (numLeft.equals(total)) {
			numLeft = numLeft.subtract(BigInteger.ONE);
			return a;
		}

		int temp;

		// Find largest index j with a[j] < a[j+1]

		int j = a.length - 2;
		while (a[j] > a[j + 1]) {
			j--;
		}

		// Find index k such that a[k] is smallest integer
		// greater than a[j] to the right of a[j]

		int k = a.length - 1;
		while (a[j] > a[k]) {
			k--;
		}

		// Interchange a[j] and a[k]

		temp = a[k];
		a[k] = a[j];
		a[j] = temp;

		// Put tail end of permutation after jth position in increasing order

		int r = a.length - 1;
		int s = j + 1;

		while (r > s) {
			temp = a[s];
			a[s] = a[r];
			a[r] = temp;
			r--;
			s++;
		}

		numLeft = numLeft.subtract(BigInteger.ONE);
		return a;

	}

	public List<List<ElementType>> getPermutations(List<ElementType> input) {
		List<List<ElementType>> permutations = new LinkedList<List<ElementType>>();
		if(input.size() == 0){
			return permutations;
		}
		init(input.size());
		int[] indices;
		List<ElementType> permutation;
		while (hasMore()) {
			permutation = new LinkedList<ElementType>();
			permutations.add(permutation);
			indices = getNext();
			for (int i = 0; i < indices.length; i++) {
				permutation.add(input.get(indices[i]));
			}
		}
		return permutations;
	}
}
