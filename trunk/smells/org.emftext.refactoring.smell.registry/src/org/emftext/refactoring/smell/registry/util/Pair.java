package org.emftext.refactoring.smell.registry.util;

public class Pair<First, Second> {

	private Second second;
	private First first;

	public Pair(First first, Second second){
		this.first = first;
		this.second = second;
	}
	
	public First getFirst(){
		return first;
	}
	
	public Second getSecond(){
		return second;
	}
}
