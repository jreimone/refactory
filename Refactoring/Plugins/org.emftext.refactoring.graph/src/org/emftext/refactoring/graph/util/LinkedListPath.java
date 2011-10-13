/**
 * 
 */
package org.emftext.refactoring.graph.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Jan Reimann
 *
 */
public class LinkedListPath extends LinkedList<TreeNode> implements IPath {

	private static final long serialVersionUID = -6308692673257748635L;

	public LinkedListPath(){
		super(Collections.synchronizedList(new LinkedList<TreeNode>()));
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.graph.util.IPath#removeAbstractEClasses()
	 */
	public boolean removeAbstractEClasses() {
		List<TreeNode> classes = new ArrayList<TreeNode>();
		for (TreeNode eClass : this) {
			if(eClass.getEClass().isAbstract() || eClass.getEClass().isInterface()){
				classes.add(eClass);
			}
		}
		return this.removeAll(classes);
	}
}
