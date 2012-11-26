/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

/**
 * A XwpfContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * XwpfContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class XwpfContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private org.eclipse.emf.ecore.EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[] path;
	
	public XwpfContainmentTrace(org.eclipse.emf.ecore.EClass startClass, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				org.eclipse.emf.ecore.EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public org.eclipse.emf.ecore.EClass getStartClass() {
		return startClass;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.explode(path, "->");
	}
	
}
