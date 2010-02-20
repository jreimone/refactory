/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

// A basic implementation of the IElementMapping interface.
//
// @param <ReferenceType> the type of the reference that can be mapped to
//
public class RefspecElementMapping<ReferenceType> implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public RefspecElementMapping(String identifier, ReferenceType target, String warning) {
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
