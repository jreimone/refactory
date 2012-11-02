package earlybinding;

import earlybinding.EarlyBindingMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;
import org.emftext.language.java.members.ClassMethod;

/**
 * A match processor tailored for the earlyBinding pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EarlyBindingProcessor implements IMatchProcessor<EarlyBindingMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pActClass the value of pattern parameter actClass in the currently processed match 
   * @param pOnCreate the value of pattern parameter onCreate in the currently processed match 
   * @param pSuperClass the value of pattern parameter superClass in the currently processed match 
   * @param pCallee the value of pattern parameter callee in the currently processed match 
   * 
   */
  public abstract void process(final org.emftext.language.java.classifiers.Class actClass, final ClassMethod onCreate, final org.emftext.language.java.classifiers.Class superClass, final ClassMethod callee);
  
  @Override
  public void process(final EarlyBindingMatch match) {
    process(match.getActClass(), match.getOnCreate(), match.getSuperClass(), match.getCallee());  				
    
  }
}
