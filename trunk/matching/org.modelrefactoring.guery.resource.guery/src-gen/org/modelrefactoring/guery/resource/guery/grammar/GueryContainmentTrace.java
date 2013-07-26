/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

/**
 * A GueryContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * GueryContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class GueryContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private org.eclipse.emf.ecore.EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] path;
	
	public GueryContainmentTrace(org.eclipse.emf.ecore.EClass startClass, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] path) {
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
	
	public org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + org.modelrefactoring.guery.resource.guery.util.GueryStringUtil.explode(path, "->");
	}
	
}
