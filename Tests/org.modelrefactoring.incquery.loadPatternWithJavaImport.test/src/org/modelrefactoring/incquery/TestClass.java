package org.modelrefactoring.incquery;

public class TestClass {

	public static void main(String[] args) {
		// should match
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			System.out.println(string);
		}
		// should not match
		for (int i = 1; i < args.length; i++) {
			String string = args[i];
			System.out.println(string);
		}
		// should match
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			System.out.println(string);
		}
	}

}
