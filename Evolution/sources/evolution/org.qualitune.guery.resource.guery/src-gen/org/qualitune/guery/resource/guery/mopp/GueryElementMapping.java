/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * A basic implementation of the
 * org.qualitune.guery.resource.guery.IGueryElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class GueryElementMapping<ReferenceType> implements org.qualitune.guery.resource.guery.IGueryElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public GueryElementMapping(String identifier, ReferenceType target, String warning) {
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
