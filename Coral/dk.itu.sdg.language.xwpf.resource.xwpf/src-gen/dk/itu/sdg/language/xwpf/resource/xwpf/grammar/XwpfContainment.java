/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfContainment extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public XwpfContainment(org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.explode(allowedTypes, ", ", new dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
