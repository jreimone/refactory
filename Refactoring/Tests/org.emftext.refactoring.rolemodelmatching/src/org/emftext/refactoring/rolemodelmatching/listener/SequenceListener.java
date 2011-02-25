package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.List;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

/**
 * First execute the listeners passed to the constructor and then execute this listener.  
 * 
 * @author jreimann
 *
 */
public abstract class SequenceListener extends CompositeListener {

	public SequenceListener(List<INodeListener> otherListeners) {
		super(otherListeners);
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		for (INodeListener listener : getOtherListeners()) {
			listener.execute(node);
		}
		executeAfterOthers(node);
	}

	public abstract void executeAfterOthers(MatchNode<?, ?> node);
}
