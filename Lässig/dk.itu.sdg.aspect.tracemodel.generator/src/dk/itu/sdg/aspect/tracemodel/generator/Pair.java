package dk.itu.sdg.aspect.tracemodel.generator;

import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public class Pair {
  public EClass fst;
  public EClass snd;
  
  public Pair(final EClass classA, final EClass classB) {
	  fst = classA;
	  snd = classB;
  }
}
