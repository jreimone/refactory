/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * A basic implementation of the
 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsURIMapping
 * interface that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsURIMapping
 * .
 */
public class OperatorsURIMapping<ReferenceType> implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public OperatorsURIMapping(String identifier, URI newIdentifier, String warning) {
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
