package org.emftext.refactoring.rolemodelmatching.listener;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public abstract class AbstractNodeListener implements INodeListener {

	private MatchNode<?, ?> subject;
	
	public abstract void execute(MatchNode<?, ?> node);

	public MatchNode<?, ?> getSubject() {
		return subject;
	}

	public void setSubject(MatchNode<?, ?> subject) {
		this.subject = subject;
	}

}
