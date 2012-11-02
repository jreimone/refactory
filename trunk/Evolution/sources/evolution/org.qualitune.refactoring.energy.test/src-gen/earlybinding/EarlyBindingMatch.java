package earlybinding;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;
import org.emftext.language.java.members.ClassMethod;

/**
 * Pattern-specific match representation of the earlyBinding pattern, 
 * to be used in conjunction with EarlyBindingMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EarlyBindingMatcher
 * @see EarlyBindingProcessor
 * 
 */
public final class EarlyBindingMatch extends BasePatternMatch {
  private org.emftext.language.java.classifiers.Class fActClass;
  
  private ClassMethod fOnCreate;
  
  private org.emftext.language.java.classifiers.Class fSuperClass;
  
  private ClassMethod fCallee;
  
  private static String[] parameterNames = {"actClass", "onCreate", "superClass", "callee"};
  
  EarlyBindingMatch(final org.emftext.language.java.classifiers.Class pActClass, final ClassMethod pOnCreate, final org.emftext.language.java.classifiers.Class pSuperClass, final ClassMethod pCallee) {
    this.fActClass = pActClass;
    this.fOnCreate = pOnCreate;
    this.fSuperClass = pSuperClass;
    this.fCallee = pCallee;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("actClass".equals(parameterName)) return this.fActClass;
    if ("onCreate".equals(parameterName)) return this.fOnCreate;
    if ("superClass".equals(parameterName)) return this.fSuperClass;
    if ("callee".equals(parameterName)) return this.fCallee;
    return null;
    
  }
  
  public org.emftext.language.java.classifiers.Class getActClass() {
    return this.fActClass;
    
  }
  
  public ClassMethod getOnCreate() {
    return this.fOnCreate;
    
  }
  
  public org.emftext.language.java.classifiers.Class getSuperClass() {
    return this.fSuperClass;
    
  }
  
  public ClassMethod getCallee() {
    return this.fCallee;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("actClass".equals(parameterName) ) {
    	this.fActClass = (org.emftext.language.java.classifiers.Class) newValue;
    	return true;
    }
    if ("onCreate".equals(parameterName) ) {
    	this.fOnCreate = (org.emftext.language.java.members.ClassMethod) newValue;
    	return true;
    }
    if ("superClass".equals(parameterName) ) {
    	this.fSuperClass = (org.emftext.language.java.classifiers.Class) newValue;
    	return true;
    }
    if ("callee".equals(parameterName) ) {
    	this.fCallee = (org.emftext.language.java.members.ClassMethod) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setActClass(final org.emftext.language.java.classifiers.Class pActClass) {
    this.fActClass = pActClass;
    
  }
  
  public void setOnCreate(final ClassMethod pOnCreate) {
    this.fOnCreate = pOnCreate;
    
  }
  
  public void setSuperClass(final org.emftext.language.java.classifiers.Class pSuperClass) {
    this.fSuperClass = pSuperClass;
    
  }
  
  public void setCallee(final ClassMethod pCallee) {
    this.fCallee = pCallee;
    
  }
  
  @Override
  public String patternName() {
    return "earlyBinding";
    
  }
  
  @Override
  public String[] parameterNames() {
    return EarlyBindingMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fActClass, fOnCreate, fSuperClass, fCallee};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"actClass\"=" + prettyPrintValue(fActClass) + ", ");
    result.append("\"onCreate\"=" + prettyPrintValue(fOnCreate) + ", ");
    result.append("\"superClass\"=" + prettyPrintValue(fSuperClass) + ", ");
    result.append("\"callee\"=" + prettyPrintValue(fCallee));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fActClass == null) ? 0 : fActClass.hashCode()); 
    result = prime * result + ((fOnCreate == null) ? 0 : fOnCreate.hashCode()); 
    result = prime * result + ((fSuperClass == null) ? 0 : fSuperClass.hashCode()); 
    result = prime * result + ((fCallee == null) ? 0 : fCallee.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (obj == null)
    	return false;
    if (!(obj instanceof IPatternMatch))
    	return false;
    IPatternMatch otherSig  = (IPatternMatch) obj;
    if (!pattern().equals(otherSig.pattern()))
    	return false;
    if (!EarlyBindingMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    EarlyBindingMatch other = (EarlyBindingMatch) obj;
    if (fActClass == null) {if (other.fActClass != null) return false;}
    else if (!fActClass.equals(other.fActClass)) return false;
    if (fOnCreate == null) {if (other.fOnCreate != null) return false;}
    else if (!fOnCreate.equals(other.fOnCreate)) return false;
    if (fSuperClass == null) {if (other.fSuperClass != null) return false;}
    else if (!fSuperClass.equals(other.fSuperClass)) return false;
    if (fCallee == null) {if (other.fCallee != null) return false;}
    else if (!fCallee.equals(other.fCallee)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EarlyBindingMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
}
