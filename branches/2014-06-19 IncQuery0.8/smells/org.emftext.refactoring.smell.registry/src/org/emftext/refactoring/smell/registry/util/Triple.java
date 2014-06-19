package org.emftext.refactoring.smell.registry.util;

public class Triple<First, Second, Third> extends Pair<First, Second> {

	private Third third;

	public Triple(First first, Second second, Third third) {
		super(first, second);
		this.third = third;
	}
	
	public Third getThird(){
		return third;
	}
}
