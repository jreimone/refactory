package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.Arrays;
import java.util.List;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

/**
 * This listener removes a complete path to save memory. Before removal
 * all passed other listeners will be removed.
 * 
 * @author jreimann
 *
 */
public class RemoveCompletePathListener extends SequenceListener {


	public RemoveCompletePathListener(INodeListener otherListener){
		super(Arrays.asList(new INodeListener[]{otherListener}));
	}
	
	/**
	 * Call this constructor to ensure that all <code>otherListeners</code> 
	 * are invoked before this listener is being invoked. This listener itself
	 * removes a complete path.
	 * 
	 * @param otherListeners
	 */
	public RemoveCompletePathListener(List<INodeListener> otherListeners) {
		super(otherListeners);
	}

	@Override
	public void executeAfterOthers(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		MatchNode<?, ?> child = node;
		while (parent.getParent() != null && (parent.getChildren().size() == 0 || parent.getChildren().size() == 1)) {
			child = parent;
			parent = parent.getParent();
		}
		parent.getChildren().remove(child);
	}


}
