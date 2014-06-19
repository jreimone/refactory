/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The OperatorsTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class OperatorsTokenResolverFactory implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolverFactory {
	
	private Map<String, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver> tokenName2TokenResolver;
	private Map<String, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver> featureName2CollectInTokenResolver;
	private static org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver defaultResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultTokenResolver();
	
	public OperatorsTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver>();
		registerTokenResolver("IDENTIFIER", new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsIDENTIFIERTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsQUOTED_34_34TokenResolver());
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver internalCreateResolver(Map<String, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver> resolverMap, String key, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
