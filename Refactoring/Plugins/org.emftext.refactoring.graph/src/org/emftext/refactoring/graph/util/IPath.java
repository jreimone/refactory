/**
 * 
 */
package org.emftext.refactoring.graph.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

/**
 * An interface for a path through a tree
 * 
 * @author Jan Reimann
 *
 */
public interface IPath extends List<EClass>{

	/**
	 * Removes the abstract EClasses in this path.
	 */
	public boolean removeAbstractEClasses();
}