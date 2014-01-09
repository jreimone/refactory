/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Selection;
import org.qualitune.tracing.umt.VariableAssignment;

/**
 * 
 * That's a Depth First Search tree iterator for code sections of UMT programs.
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
	 * 
	 * Copying collections beforehand makes this iterator stable.
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Iterator getChildren(Object umtObject) {
		if (umtObject instanceof Program) {
			LinkedList<EObject> functions = new LinkedList<EObject>();
			Program program = (Program) umtObject;
			functions.addAll( (Collection<? extends EObject>) program.getFunctions());
			return functions.iterator();
		} else if (umtObject instanceof Function) {
			LinkedList<EObject> instructions = new LinkedList<EObject>();
			Function function = (Function) umtObject;
			instructions.addAll( (Collection<? extends EObject>) function.getBody().getInstructions());
			return instructions.iterator();
		} else if (umtObject instanceof Selection) {
			LinkedList<EObject> branches = new LinkedList<EObject>();
			Selection selection = (Selection) umtObject;
			branches.addAll( (Collection<? extends EObject>) selection.getBranches());
			return branches.iterator();
		} else if (umtObject instanceof Branch) {
			LinkedList<EObject> instructions = new LinkedList<EObject>();
			Branch branch = (Branch) umtObject;
			instructions.addAll( (Collection<? extends EObject>) branch.getBody().getInstructions());
			return instructions.iterator();
		} else if (umtObject instanceof VariableAssignment) {
			LinkedList<EObject> retList = new LinkedList<EObject>();
			retList.add( ((VariableAssignment) umtObject).getAssignedExpression() );
			return retList.iterator();
		} else // TODO loop
			return ECollections.EMPTY_ELIST.iterator() ;
	}

}
