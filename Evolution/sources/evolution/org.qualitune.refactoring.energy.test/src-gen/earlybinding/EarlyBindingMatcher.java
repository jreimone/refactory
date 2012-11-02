package earlybinding;

import earlybinding.EarlyBindingMatch;
import earlybinding.EarlyBindingMatcherFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra2.emf.incquery.runtime.api.EngineManager;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.gtasm.patternmatcher.incremental.rete.misc.DeltaMonitor;
import org.eclipse.viatra2.gtasm.patternmatcher.incremental.rete.tuple.Tuple;
import org.emftext.language.java.members.ClassMethod;

/**
 * Generated pattern matcher API of the earlyBinding pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * // inspired by the GReQL query for "early resource binding" from the following paper:
 * // Marion Gottschalk, Mirco Joseﬁok, Jan Jelschen, Andreas Winter (2012) 
 * // "Removing Energy Code Smells with Reengineering Services"
 * pattern earlyBinding(actClass:Class, onCreate:ClassMethod, superClass: Class, callee:ClassMethod){
 * 	Class.^extends(actClass, superClassRef);
 * 	NamespaceClassifierReference.classifierReferences(superClassRef, classifierRef);
 * 	ClassifierReference.target(classifierRef, superClass);
 * 	Class.name(superClass, "Activity");
 * 	Class.members(actClass, onCreate);
 * 	ClassMethod.name(onCreate, "onCreate");
 * 	ClassMethod.statements(onCreate, statement);
 * 	ExpressionStatement.expression(statement, caller);
 * 	MethodCall.target(caller, callee);
 * 	ClassMethod.name(callee, "requestLocationUpdates");
 * }
 * </pre></code>
 * 
 * @see EarlyBindingMatch
 * @see EarlyBindingMatcherFactory
 * @see EarlyBindingProcessor
 * 
 */
public class EarlyBindingMatcher extends BaseGeneratedMatcher<EarlyBindingMatch> implements IncQueryMatcher<EarlyBindingMatch> {
  private final static int POSITION_ACTCLASS = 0;
  
  private final static int POSITION_ONCREATE = 1;
  
  private final static int POSITION_SUPERCLASS = 2;
  
  private final static int POSITION_CALLEE = 3;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a lightweight reference is created.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so 
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public EarlyBindingMatcher(final Notifier emfRoot) throws IncQueryException {
    this(EngineManager.getInstance().getIncQueryEngine(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a lightweight reference is created.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public EarlyBindingMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @return matches represented as a EarlyBindingMatch object.
   * 
   */
  public Collection<EarlyBindingMatch> getAllMatches(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    return rawGetAllMatches(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @return a match represented as a EarlyBindingMatch object, or null if no match is found.
   * 
   */
  public EarlyBindingMatch getOneArbitraryMatch(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    return rawGetOneArbitraryMatch(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    return rawHasMatch(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    return rawCountMatches(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee, final IMatchProcessor<? super EarlyBindingMatch> processor) {
    rawForEachMatch(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee, final IMatchProcessor<? super EarlyBindingMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<EarlyBindingMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * @param pActClass the fixed value of pattern parameter actClass, or null if not bound.
   * @param pOnCreate the fixed value of pattern parameter onCreate, or null if not bound.
   * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
   * @param pCallee the fixed value of pattern parameter callee, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EarlyBindingMatch newMatch(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    return new EarlyBindingMatch(pActClass, pOnCreate, pSuperClass, pCallee);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for actClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> rawAccumulateAllValuesOfactClass(final Object[] parameters) {
    Set<org.emftext.language.java.classifiers.Class> results = new HashSet<org.emftext.language.java.classifiers.Class>();
    rawAccumulateAllValues(POSITION_ACTCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for actClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> getAllValuesOfactClass() {
    return rawAccumulateAllValuesOfactClass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for actClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> getAllValuesOfactClass(final EarlyBindingMatch partialMatch) {
    return rawAccumulateAllValuesOfactClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for actClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> getAllValuesOfactClass(final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    org.emftext.language.java.classifiers.Class pActClass = null;
    return rawAccumulateAllValuesOfactClass(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Retrieve the set of values that occur in matches for onCreate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> rawAccumulateAllValuesOfonCreate(final Object[] parameters) {
    Set<ClassMethod> results = new HashSet<ClassMethod>();
    rawAccumulateAllValues(POSITION_ONCREATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for onCreate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> getAllValuesOfonCreate() {
    return rawAccumulateAllValuesOfonCreate(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for onCreate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> getAllValuesOfonCreate(final EarlyBindingMatch partialMatch) {
    return rawAccumulateAllValuesOfonCreate(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for onCreate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> getAllValuesOfonCreate(final org.emftext.language.java.classifiers.Class pActClass, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    ClassMethod pOnCreate = null;
    return rawAccumulateAllValuesOfonCreate(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Retrieve the set of values that occur in matches for superClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> rawAccumulateAllValuesOfsuperClass(final Object[] parameters) {
    Set<org.emftext.language.java.classifiers.Class> results = new HashSet<org.emftext.language.java.classifiers.Class>();
    rawAccumulateAllValues(POSITION_SUPERCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for superClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> getAllValuesOfsuperClass() {
    return rawAccumulateAllValuesOfsuperClass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for superClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> getAllValuesOfsuperClass(final EarlyBindingMatch partialMatch) {
    return rawAccumulateAllValuesOfsuperClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for superClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.emftext.language.java.classifiers.Class> getAllValuesOfsuperClass(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final ClassMethod pCallee) {
    org.emftext.language.java.classifiers.Class pSuperClass = null;
    return rawAccumulateAllValuesOfsuperClass(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  /**
   * Retrieve the set of values that occur in matches for callee.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> rawAccumulateAllValuesOfcallee(final Object[] parameters) {
    Set<ClassMethod> results = new HashSet<ClassMethod>();
    rawAccumulateAllValues(POSITION_CALLEE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for callee.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> getAllValuesOfcallee() {
    return rawAccumulateAllValuesOfcallee(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for callee.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> getAllValuesOfcallee(final EarlyBindingMatch partialMatch) {
    return rawAccumulateAllValuesOfcallee(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for callee.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassMethod> getAllValuesOfcallee(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass) {
    ClassMethod pCallee = null;
    return rawAccumulateAllValuesOfcallee(new Object[]{pActClass, pOnCreate, pSuperClass, pCallee});
  }
  
  @Override
  public EarlyBindingMatch tupleToMatch(final Tuple t) {
    try {
    	return new EarlyBindingMatch((org.emftext.language.java.classifiers.Class) t.get(POSITION_ACTCLASS), (org.emftext.language.java.members.ClassMethod) t.get(POSITION_ONCREATE), (org.emftext.language.java.classifiers.Class) t.get(POSITION_SUPERCLASS), (org.emftext.language.java.members.ClassMethod) t.get(POSITION_CALLEE));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  public EarlyBindingMatch arrayToMatch(final Object[] match) {
    try {
    	return new EarlyBindingMatch((org.emftext.language.java.classifiers.Class) match[POSITION_ACTCLASS], (org.emftext.language.java.members.ClassMethod) match[POSITION_ONCREATE], (org.emftext.language.java.classifiers.Class) match[POSITION_SUPERCLASS], (org.emftext.language.java.members.ClassMethod) match[POSITION_CALLEE]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<EarlyBindingMatcher> factory() throws IncQueryException {
    return EarlyBindingMatcherFactory.instance();
  }
}
