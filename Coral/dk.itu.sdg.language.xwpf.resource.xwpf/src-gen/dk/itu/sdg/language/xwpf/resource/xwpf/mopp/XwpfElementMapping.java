/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * A basic implementation of the
 * dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class XwpfElementMapping<ReferenceType> implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public XwpfElementMapping(String identifier, ReferenceType target, String warning) {
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
