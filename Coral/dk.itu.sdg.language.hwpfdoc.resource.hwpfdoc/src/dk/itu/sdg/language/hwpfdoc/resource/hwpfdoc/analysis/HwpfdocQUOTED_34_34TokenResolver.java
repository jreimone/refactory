/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.hwpfdoc.resource.hwpfdoc.analysis;

public class HwpfdocQUOTED_34_34TokenResolver implements dk.itu.sdg.language.hwpfdoc.resource.hwpfdoc.IHwpfdocTokenResolver {
	
	private dk.itu.sdg.language.hwpfdoc.resource.hwpfdoc.analysis.HwpfdocDefaultTokenResolver defaultTokenResolver = new dk.itu.sdg.language.hwpfdoc.resource.hwpfdoc.analysis.HwpfdocDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.hwpfdoc.resource.hwpfdoc.IHwpfdocTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
