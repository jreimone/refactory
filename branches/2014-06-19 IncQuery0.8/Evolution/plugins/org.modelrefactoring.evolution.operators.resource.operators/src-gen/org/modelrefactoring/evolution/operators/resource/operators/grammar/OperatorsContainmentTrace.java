/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A OperatorsContainmentTrace represents a specific path to a structural feature
 * by navigating over a set of a structural feature from a start class.
 * OperatorsContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class OperatorsContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[] path;
	
	public OperatorsContainmentTrace(EClass startClass, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[] path) {
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
	
	public org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStringUtil.explode(path, "->");
	}
	
}
