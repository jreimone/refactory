/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecTokenResolverFactory implements org.emftext.language.refactoring.specification.resource.IRefspecTokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver defaultResolver = new org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultTokenResolver();
	
	public RefspecTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.language.refactoring.specification.resource.analysis.RefspecTEXTTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.language.refactoring.specification.resource.analysis.RefspecQUOTED_60_62TokenResolver());
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver> resolverMap, java.lang.String key, org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
