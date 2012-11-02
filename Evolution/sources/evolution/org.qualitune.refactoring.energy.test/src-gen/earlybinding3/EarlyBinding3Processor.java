package earlybinding3;

import earlybinding3.EarlyBinding3Match;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;
import org.emftext.language.java.members.ClassMethod;

/**
 * A match processor tailored for the earlyBinding3 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EarlyBinding3Processor implements IMatchProcessor<EarlyBinding3Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pActClass the value of pattern parameter actClass in the currently processed match 
   * @param pSearchedMethod the value of pattern parameter searchedMethod in the currently processed match 
   * @param pSuperClass the value of pattern parameter superClass in the currently processed match 
   * @param pCallee the value of pattern parameter callee in the currently processed match 
   * 
   */
  public abstract void process(final org.emftext.language.java.classifiers.Class actClass, final ClassMethod searchedMethod, final org.emftext.language.java.classifiers.Class superClass, final ClassMethod callee);
  
  @Override
  public void process(final EarlyBinding3Match match) {
    process(match.getActClass(), match.getSearchedMethod(), match.getSuperClass(), match.getCallee());  				
    
  }
}
