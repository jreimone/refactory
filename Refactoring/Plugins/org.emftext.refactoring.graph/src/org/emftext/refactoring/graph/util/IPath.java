/**
 * 
 */
package org.emftext.refactoring.graph.util;

import java.util.List;


/**
 * An interface for a path through a tree
 * 
 * @author Jan Reimann
 *
 */
public interface IPath extends List<TreeNode>{

	/**
	 * Removes the abstract EClasses in this path.
	 */
	public boolean removeAbstractEClasses();
}