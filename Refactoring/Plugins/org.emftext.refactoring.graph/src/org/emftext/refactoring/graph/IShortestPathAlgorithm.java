package org.emftext.refactoring.graph;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.graph.util.IPath;


/**
 * Interface for implementations for algorithms of shortest path calculation for metamodels.
 * 
 * @author Jan
 *
 */
public interface IShortestPathAlgorithm {
	
	/**
	 * Calculates all paths in the metamodel from source to target. Internally the EClasses of the given source and target
	 * EObject's are considered. If there is only one path this method returns a list of cardinality 1.
	 * 
	 * @param source source node in the model to calculate the path from
	 * @param target target node in the model to calculate the path to
	 * @return a list of paths from source to target
	 */
	public List<IPath> calculatePaths(EObject source, EObject target);

	/**
	 * @param output the output to set
	 */
	public void setOutput(boolean output);
}
