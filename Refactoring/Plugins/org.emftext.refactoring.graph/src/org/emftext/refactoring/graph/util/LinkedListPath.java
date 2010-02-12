/**
 * 
 */
package org.emftext.refactoring.graph.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

/**
 * @author Jan Reimann
 *
 */
public class LinkedListPath extends LinkedList<EClass> implements IPath {

	private static final long serialVersionUID = -6308692673257748635L;

	public LinkedListPath(){
		super(Collections.synchronizedList(new LinkedList<EClass>()));
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.graph.util.IPath#removeAbstractEClasses()
	 */
	public boolean removeAbstractEClasses() {
		List<EClass> classes = new ArrayList<EClass>();
		for (EClass eClass : this) {
			if(eClass.isAbstract() || eClass.isInterface()){
				classes.add(eClass);
			}
		}
		return this.removeAll(classes);
	}
}
