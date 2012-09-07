/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.bombXML.analysis;

public class HbmXmlIDENTIFIERTokenResolver implements dk.itu.sdg.language.bombXML.IHbmXmlTokenResolver {
	
	private dk.itu.sdg.language.bombXML.analysis.HbmXmlDefaultTokenResolver defaultTokenResolver = new dk.itu.sdg.language.bombXML.analysis.HbmXmlDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.bombXML.IHbmXmlTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
