/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A CoedContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * CoedContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class CoedContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] path;
	
	public CoedContainmentTrace(EClass startClass, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public EClass getStartClass() {
		return startClass;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + org.modelrefactoring.evolution.coed.resource.coed.util.CoedStringUtil.explode(path, "->");
	}
	
}
