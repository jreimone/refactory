/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * A basic implementation of the
 * org.emftext.refactoring.tests.properties.resource.properties.IPropertiesElementM
 * apping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class PropertiesElementMapping<ReferenceType> implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public PropertiesElementMapping(String identifier, ReferenceType target, String warning) {
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
