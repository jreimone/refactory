/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * org.emftext.language.refactoring.composition.resource.IRefcompURIMapping
 * interface that can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.emftext.language.refactoring.composition.resource.IRefcompURIMapping.
 */
public class RefcompURIMapping<ReferenceType> implements org.emftext.language.refactoring.composition.resource.IRefcompURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public RefcompURIMapping(String identifier, URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
