package earlybinding3;

import earlybinding3.EarlyBinding3Matcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.emf.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EarlyBinding3Matcher in a type-safe way.
 * 
 * @see EarlyBinding3Matcher
 * @see EarlyBinding3Match
 * 
 */
public class EarlyBinding3MatcherFactory extends BaseGeneratedMatcherFactory<EarlyBinding3Matcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EarlyBinding3MatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EarlyBinding3Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EarlyBinding3Matcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "org.qualitune.refactoring.energy.test";
    
  }
  
  @Override
  protected String patternName() {
    return "earlyBinding3";
    
  }
  
  private EarlyBinding3MatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EarlyBinding3MatcherFactory> {
    @Override
    public EarlyBinding3MatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EarlyBinding3MatcherFactory INSTANCE = make();
    
    public static EarlyBinding3MatcherFactory make() {
      try {
      	return new EarlyBinding3MatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
