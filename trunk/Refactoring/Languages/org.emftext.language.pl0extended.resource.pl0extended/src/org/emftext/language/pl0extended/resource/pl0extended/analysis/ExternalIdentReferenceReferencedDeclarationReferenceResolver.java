/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

import java.util.LinkedList;
import java.util.List;

import org.emftext.language.pl0.Declaration;

public class ExternalIdentReferenceReferencedDeclarationReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.Declaration> {

	private org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.Declaration> delegate = new org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.Declaration>();

	public void resolve(java.lang.String identifier, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0.Declaration> result) {
		try {
			List<Declaration> declarations = new LinkedList<Declaration>();
			declarations.addAll(container.getImportReference().getProgramReference().getBlock().getConstants());
			declarations.addAll(container.getImportReference().getProgramReference().getBlock().getVariables());
			for (Declaration declaration : declarations) {
				if(declaration.getName().equals(identifier) || resolveFuzzy){
					container.setIdent(declaration);
					result.addMapping(identifier, declaration);
				}
			}
		} catch (Exception e) {
			result.setErrorMessage("Import '" + container.getImportReference().getProgramReference().getName() + "' doesn't contain a declaration with identifier '" + identifier + "'");
		}
	}

	public java.lang.String deResolve(org.emftext.language.pl0.Declaration element, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
