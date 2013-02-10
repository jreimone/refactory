/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Selection;

/**
 * 
 * That's Depth First Search
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class UmtTreeIterator extends AbstractTreeIterator<EObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1016061133931947752L;

	/**
	 * @param object
	 */
	public UmtTreeIterator(EObject program) {
		super(program);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.AbstractTreeIterator#getChildren(java.lang.Object)
	 */
	@Override
	protected Iterator getChildren(Object umtObject) {
		if (umtObject instanceof Program) {
			return ((Program) umtObject).getFunctions().iterator();
		} else if (umtObject instanceof Function) {
			return ((InstructionBlock) ((Function) umtObject).getBody()).getInstructions().iterator();
		} else if (umtObject instanceof Selection) {
			return ((Selection) umtObject).getBranches().iterator();
		} else if (umtObject instanceof Branch) {
			return ((Branch) umtObject).getBody().getInstructions().iterator();
		} // TODO something about loop?
		return ECollections.EMPTY_ELIST.iterator() ;
	}

}
