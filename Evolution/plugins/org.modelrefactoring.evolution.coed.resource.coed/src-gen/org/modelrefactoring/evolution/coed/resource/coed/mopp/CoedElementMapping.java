/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;


/**
 * A basic implementation of the
 * org.modelrefactoring.evolution.coed.resource.coed.ICoedElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class CoedElementMapping<ReferenceType> implements org.modelrefactoring.evolution.coed.resource.coed.ICoedElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public CoedElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
