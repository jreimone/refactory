/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.hbm.xml.analysis;

public class HbmXmlSTRING_LITERALTokenResolver implements dk.itu.sdg.language.hbm.xml.IHbmXmlTokenResolver {
	
	private dk.itu.sdg.language.hbm.xml.analysis.HbmXmlDefaultTokenResolver defaultTokenResolver = new dk.itu.sdg.language.hbm.xml.analysis.HbmXmlDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.hbm.xml.IHbmXmlTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
