/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesTokenResolverFactory implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver defaultResolver = new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesDefaultTokenResolver();
	
	public PropertiesTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<java.lang.String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<java.lang.String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesTEXTTokenResolver());
		registerTokenResolver("QUOTED_91_93", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesQUOTED_91_93TokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesQUOTED_34_34TokenResolver());
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> resolverMap, java.lang.String key, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
