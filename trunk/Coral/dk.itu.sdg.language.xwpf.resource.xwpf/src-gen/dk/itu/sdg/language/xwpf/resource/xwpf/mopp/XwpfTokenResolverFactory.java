/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * The XwpfTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class XwpfTokenResolverFactory implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolverFactory {
	
	private java.util.Map<String, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver> featureName2CollectInTokenResolver;
	private static dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver defaultResolver = new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultTokenResolver();
	
	public XwpfTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver>();
		registerTokenResolver("TEXT", new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfQUOTED_34_34TokenResolver());
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver internalCreateResolver(java.util.Map<String, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver> resolverMap, String key, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
