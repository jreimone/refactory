/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource;

// A TokenResolverFactory creates TokenResolvers for a given token name.
// They may be implemented like a registry.
public interface IRefspecTokenResolverFactory {
	
	// Creates a token resolver for normal tokens of type 'tokenName'.
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver createTokenResolver(String tokenName);
	
	// Creates a token resolver for COLLECT-IN tokens that are stores in
	// feature 'featureName'.
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver createCollectInTokenResolver(String featureName);
}
