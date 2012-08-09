package smell_model.impl;

public class Tuple<O1, O2> {
	
	private O1 first;
	private O2 second;
	
	public Tuple(){
		setFirst(null);
		setSecond(null);
	}

	public Tuple (O1 o1, O2 o2){
		setFirst(o1);
		setSecond(o2);
	}

	public O1 getFirst() {
		return first;
	}

	public void setFirst(O1 first) {
		this.first = first;
	}

	public O2 getSecond() {
		return second;
	}

	public void setSecond(O2 second) {
		this.second = second;
	}
}
