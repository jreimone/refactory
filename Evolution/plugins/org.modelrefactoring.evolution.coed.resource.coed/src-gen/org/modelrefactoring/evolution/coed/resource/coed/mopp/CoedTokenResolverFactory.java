/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The CoedTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class CoedTokenResolverFactory implements org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolverFactory {
	
	private Map<String, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver> tokenName2TokenResolver;
	private Map<String, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver> featureName2CollectInTokenResolver;
	private static org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver defaultResolver = new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultTokenResolver();
	
	public CoedTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver>();
		registerTokenResolver("IDENTIFIER", new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedIDENTIFIERTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_123_125", new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedQUOTED_123_125TokenResolver());
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver internalCreateResolver(Map<String, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver> resolverMap, String key, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
