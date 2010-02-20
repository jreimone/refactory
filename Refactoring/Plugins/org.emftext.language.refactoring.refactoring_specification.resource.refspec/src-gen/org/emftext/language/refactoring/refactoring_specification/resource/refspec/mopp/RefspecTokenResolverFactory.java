/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecTokenResolverFactory implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver defaultResolver = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefspecDefaultTokenResolver();
	
	public RefspecTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefspecTEXTTokenResolver());
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver> resolverMap, java.lang.String key, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
