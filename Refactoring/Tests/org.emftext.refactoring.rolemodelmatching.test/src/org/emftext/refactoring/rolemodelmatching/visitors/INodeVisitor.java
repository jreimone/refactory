package org.emftext.refactoring.rolemodelmatching.visitors;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

/**
 * This interface is used to attach a visitor to the root {@link StringMappingNode} of
 * the matching tree being constructed from the persisted real matching tree.
 * If a leaf is reached while tree construction the {@link #visit(StringMappingNode)} method
 * is invoked. 
 * 
 * @author jreimann
 *
 */
public interface INodeVisitor {

	/**
	 * This method contains the implementation of the visitor which is being invoked on the
	 * given <code>node</code>.
	 * 
	 * @param node
	 */
	public void visit(StringMappingNode node);
}
