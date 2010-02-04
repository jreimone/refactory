/**
 * 
 */
package org.emftext.refactoring.graph.util;

import org.emftext.refactoring.graph.IShortestPathAlgorithm;
import org.emftext.refactoring.graph.impl.DepthFirstSearch;

/**
 * @author Jan Reimann
 *
 */
public class PathAlgorithmFactory {

	public IShortestPathAlgorithm getAlgorithm(){
		return new DepthFirstSearch();
	}
}
