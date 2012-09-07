/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.coral.resource.coral.analysis;

public class DirectedRelationRefReferenceResolver implements dk.itu.sdg.language.coral.resource.coral.ICoralReferenceResolver<dk.itu.sdg.language.coral.DirectedRelation, dk.itu.sdg.language.coral.PublicType> {
	
	private dk.itu.sdg.language.coral.resource.coral.analysis.CoralDefaultResolverDelegate<dk.itu.sdg.language.coral.DirectedRelation, dk.itu.sdg.language.coral.PublicType> delegate = new dk.itu.sdg.language.coral.resource.coral.analysis.CoralDefaultResolverDelegate<dk.itu.sdg.language.coral.DirectedRelation, dk.itu.sdg.language.coral.PublicType>();
	
	public void resolve(String identifier, dk.itu.sdg.language.coral.DirectedRelation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final dk.itu.sdg.language.coral.resource.coral.ICoralReferenceResolveResult<dk.itu.sdg.language.coral.PublicType> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(dk.itu.sdg.language.coral.PublicType element, dk.itu.sdg.language.coral.DirectedRelation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
