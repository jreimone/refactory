/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * The PropertiesTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class PropertiesTokenResolverFactory implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver defaultResolver = new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesDefaultTokenResolver();
	
	public PropertiesTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesTEXTTokenResolver());
		registerTokenResolver("QUOTED_91_93", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesQUOTED_91_93TokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesQUOTED_34_34TokenResolver());
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver> resolverMap, String key, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
