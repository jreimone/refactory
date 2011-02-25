package org.emftext.refactoring.rolemodelmatching.listener;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

/**
 * Can be registered to nodes. But should only be registered to the root because
 * listeners will only be executed if a leaf is reached in the tree. In this case
 * the registered listeners from the root will be propagated to the leaf.
 * 
 * @author jreimann
 *
 */
public interface INodeListener {

	public void execute(MatchNode<?, ?> node);
	
	public MatchNode<?, ?> getSubject();
	
	public void setSubject(MatchNode<?, ?> subject);
}
