package org.qualitune.refactoring.energy.test;
import java.io.File;


public class EarlyResourceBinding extends File{

	private static final long serialVersionUID = 6805008686507481048L;

	public EarlyResourceBinding(File parent, String child) {
		super(parent, child);
	}

	public void testMethod(){
		System.out.println("nothing");
	}

	@Override
	public String toString() {
		testMethod();
		return super.toString();
	}
}
