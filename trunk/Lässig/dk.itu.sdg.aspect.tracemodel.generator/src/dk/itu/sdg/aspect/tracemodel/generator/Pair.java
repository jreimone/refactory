package dk.itu.sdg.aspect.tracemodel.generator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

public class Pair {
	public GenClass fst;
	public GenClass snd;
	
	// public EClass fst;
	// public EClass snd;

	// public GenClass sndGen;
	// public GenClass fstGen;

	public Pair(GenClass genClassA, GenClass genClassB) {
		// fst = genClassA.getEcoreClass();
		// snd = genClassB.getEcoreClass();
		snd = genClassB;
		fst = genClassA;
		// sndGen = genClassB;
		// fstGen = genClassA;
	}
}
