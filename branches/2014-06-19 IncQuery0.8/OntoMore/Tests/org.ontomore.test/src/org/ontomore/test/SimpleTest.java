package org.ontomore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleTest {

	@Test
	public void testUpperBoundString() {
		int upperBound = 1;
		String annotationString = "upperbound=-1";
		if (annotationString.startsWith("upperbound")) {
			String upperBoundString = annotationString.substring(annotationString.indexOf("=")+1);
			upperBound = Integer.valueOf(upperBoundString);
		}
		assertEquals(-1, upperBound, .001);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testStringConvertion() {
		Integer.valueOf("");
		Boolean.valueOf("");
	}
	
	@Test
	public void testInstanceofCheck() {
		Object object = null;
		int value = 3;
		object = value;
		assertTrue(object instanceof Integer);
	}
}
