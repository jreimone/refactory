import earlybinding.EarlyBindingMatcher;
import earlybinding3.EarlyBinding3Matcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryException;

public final class GroupOfFileEarlyBinding extends BaseGeneratedPatternGroup {
  public GroupOfFileEarlyBinding() throws IncQueryException {
    matcherFactories.add(EarlyBindingMatcher.factory());
    matcherFactories.add(EarlyBinding3Matcher.factory());
    
  }
}
