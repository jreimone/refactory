/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The RefcompTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class RefcompTokenResolverFactory implements org.emftext.language.refactoring.composition.resource.IRefcompTokenResolverFactory {
	
	private Map<String, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver> tokenName2TokenResolver;
	private Map<String, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver defaultResolver = new org.emftext.language.refactoring.composition.resource.analysis.RefcompDefaultTokenResolver();
	
	public RefcompTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver>();
		registerTokenResolver("IDENTIFIER", new org.emftext.language.refactoring.composition.resource.analysis.RefcompIDENTIFIERTokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.language.refactoring.composition.resource.analysis.RefcompQUOTED_34_34TokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.language.refactoring.composition.resource.analysis.RefcompQUOTED_60_62TokenResolver());
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver internalCreateResolver(Map<String, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver> resolverMap, String key, org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
