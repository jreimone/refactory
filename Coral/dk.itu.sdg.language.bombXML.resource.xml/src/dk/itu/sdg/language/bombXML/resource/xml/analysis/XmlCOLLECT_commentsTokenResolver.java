/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.bombXML.resource.xml.analysis;

public class XmlCOLLECT_commentsTokenResolver implements dk.itu.sdg.language.bombXML.resource.xml.IXmlTokenResolver {
	
	private dk.itu.sdg.language.bombXML.resource.xml.analysis.XmlDefaultTokenResolver defaultTokenResolver = new dk.itu.sdg.language.bombXML.resource.xml.analysis.XmlDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.bombXML.resource.xml.IXmlTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
