package org.modelrefactoring.jamopp.test;

public class SimpleExtractMethodTestClass {

	public static void main(String[] args) {
		System.out.println("Hello Karlsruhe");
		iteration();
	}
	static void iteration() {
		for (int i = 0; i < 10; i++) {
			System.out.println("value: " + i);
		}
	}

}
