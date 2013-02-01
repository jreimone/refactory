package dk.itu.sdg.aspect.tracemodel.generator;

import org.eclipse.emf.ecore.EClass;

public class Pair {
  public EClass fst;
  public EClass snd;
  
	public Pair(EClass classA, EClass classB) {
	  fst = classA;
	  snd = classB;
  }
}
