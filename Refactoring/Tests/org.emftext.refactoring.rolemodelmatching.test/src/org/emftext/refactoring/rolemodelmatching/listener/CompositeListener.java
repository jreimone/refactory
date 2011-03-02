package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.List;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public abstract class CompositeListener extends AbstractNodeListener {

	private List<INodeListener> otherListeners;
	
	public List<INodeListener> getOtherListeners() {
		return otherListeners;
	}

	public CompositeListener(List<INodeListener> otherListeners){
		this.otherListeners = otherListeners;
		for (INodeListener listener : otherListeners) {
			// to ensure that listeners are not executed twice
			if(listener.getSubject() != null){
				listener.getSubject().getListener().remove(listener);
			}
		}
	}
	
	public abstract void execute(MatchNode<?, ?> node);

}
