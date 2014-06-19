/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;


/**
 * A basic implementation of the
 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsElementMap
 * ping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class OperatorsElementMapping<ReferenceType> implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public OperatorsElementMapping(String identifier, ReferenceType target, String warning) {
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
