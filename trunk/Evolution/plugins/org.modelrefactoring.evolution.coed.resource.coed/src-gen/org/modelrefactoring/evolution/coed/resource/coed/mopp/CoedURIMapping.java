/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * A basic implementation of the
 * org.modelrefactoring.evolution.coed.resource.coed.ICoedURIMapping interface
 * that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.modelrefactoring.evolution.coed.resource.coed.ICoedURIMapping.
 */
public class CoedURIMapping<ReferenceType> implements org.modelrefactoring.evolution.coed.resource.coed.ICoedURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public CoedURIMapping(String identifier, URI newIdentifier, String warning) {
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
