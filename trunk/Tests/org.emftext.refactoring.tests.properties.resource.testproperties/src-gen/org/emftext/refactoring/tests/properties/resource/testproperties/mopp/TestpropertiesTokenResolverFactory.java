/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * The TestpropertiesTokenResolverFactory class provides access to all generated
 * token resolvers. By giving the name of a defined token, the corresponding
 * resolve can be obtained. Despite the fact that this class is called
 * TokenResolverFactory is does NOT create new token resolvers whenever a client
 * calls methods to obtain a resolver. Rather, this class maintains a map of all
 * resolvers and creates each resolver at most once.
 */
public class TestpropertiesTokenResolverFactory implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver defaultResolver = new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultTokenResolver();
	
	public TestpropertiesTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesTEXTTokenResolver());
		registerTokenResolver("QUOTED_91_93", new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesQUOTED_91_93TokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesQUOTED_34_34TokenResolver());
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver> resolverMap, String key, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
