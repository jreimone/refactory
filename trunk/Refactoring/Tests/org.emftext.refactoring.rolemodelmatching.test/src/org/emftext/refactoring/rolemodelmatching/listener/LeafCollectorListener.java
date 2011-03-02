package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.List;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class LeafCollectorListener extends AbstractNodeListener {

	private List<MatchNode<?, ?>> leafList;
	
	public LeafCollectorListener(List<MatchNode<?, ?>> leafList) {
		super();
		this.leafList = leafList;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		leafList.add(node);
	}

}
