package earlybinding;

import earlybinding.EarlyBindingMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.emf.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EarlyBindingMatcher in a type-safe way.
 * 
 * @see EarlyBindingMatcher
 * @see EarlyBindingMatch
 * 
 */
public class EarlyBindingMatcherFactory extends BaseGeneratedMatcherFactory<EarlyBindingMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EarlyBindingMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EarlyBindingMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EarlyBindingMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "org.qualitune.refactoring.energy.test";
    
  }
  
  @Override
  protected String patternName() {
    return "earlyBinding";
    
  }
  
  private EarlyBindingMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EarlyBindingMatcherFactory> {
    @Override
    public EarlyBindingMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EarlyBindingMatcherFactory INSTANCE = make();
    
    public static EarlyBindingMatcherFactory make() {
      try {
      	return new EarlyBindingMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
