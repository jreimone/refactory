/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * The GueryTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class GueryTokenResolverFactory implements org.qualitune.guery.resource.guery.IGueryTokenResolverFactory {
	
	private java.util.Map<String, org.qualitune.guery.resource.guery.IGueryTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.qualitune.guery.resource.guery.IGueryTokenResolver> featureName2CollectInTokenResolver;
	private static org.qualitune.guery.resource.guery.IGueryTokenResolver defaultResolver = new org.qualitune.guery.resource.guery.analysis.GueryDefaultTokenResolver();
	
	public GueryTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.qualitune.guery.resource.guery.IGueryTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.qualitune.guery.resource.guery.IGueryTokenResolver>();
		registerTokenResolver("IDENTIFIER", new org.qualitune.guery.resource.guery.analysis.GueryIDENTIFIERTokenResolver());
		registerTokenResolver("CLASSNAME", new org.qualitune.guery.resource.guery.analysis.GueryCLASSNAMETokenResolver());
		registerTokenResolver("CARDINALITY", new org.qualitune.guery.resource.guery.analysis.GueryCARDINALITYTokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.qualitune.guery.resource.guery.analysis.GueryQUOTED_34_34TokenResolver());
	}
	
	public org.qualitune.guery.resource.guery.IGueryTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.qualitune.guery.resource.guery.IGueryTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.qualitune.guery.resource.guery.IGueryTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.qualitune.guery.resource.guery.IGueryTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.qualitune.guery.resource.guery.IGueryTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.qualitune.guery.resource.guery.IGueryTokenResolver internalCreateResolver(java.util.Map<String, org.qualitune.guery.resource.guery.IGueryTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.qualitune.guery.resource.guery.IGueryTokenResolver> resolverMap, String key, org.qualitune.guery.resource.guery.IGueryTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
