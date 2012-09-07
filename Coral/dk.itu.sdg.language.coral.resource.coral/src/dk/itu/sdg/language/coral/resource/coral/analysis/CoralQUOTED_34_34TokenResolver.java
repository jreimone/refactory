/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.coral.resource.coral.analysis;

public class CoralQUOTED_34_34TokenResolver implements dk.itu.sdg.language.coral.resource.coral.ICoralTokenResolver {
	
	private dk.itu.sdg.language.coral.resource.coral.analysis.CoralDefaultTokenResolver defaultTokenResolver = new dk.itu.sdg.language.coral.resource.coral.analysis.CoralDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.coral.resource.coral.ICoralTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
