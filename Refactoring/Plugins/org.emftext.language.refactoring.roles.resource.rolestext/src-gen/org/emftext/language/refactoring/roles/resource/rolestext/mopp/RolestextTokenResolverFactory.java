/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextTokenResolverFactory implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver defaultResolver = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver();
	
	public RolestextTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver>();
		registerCollectInTokenResolver("comments", new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextCOLLECT_commentsTokenResolver());
		registerCollectInTokenResolver("comments", new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextCOLLECT_commentsTokenResolver());
		registerTokenResolver("BOOLEAN_LITERAL", new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextBOOLEAN_LITERALTokenResolver());
		registerTokenResolver("IDENTIFIER", new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextIDENTIFIERTokenResolver());
		registerTokenResolver("NUMBER", new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextNUMBERTokenResolver());
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver> resolverMap, java.lang.String key, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
