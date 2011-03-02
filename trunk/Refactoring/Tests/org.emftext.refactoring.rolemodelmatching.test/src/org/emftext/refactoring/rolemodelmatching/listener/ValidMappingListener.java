package org.emftext.refactoring.rolemodelmatching.listener;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class ValidMappingListener extends AbstractNodeListener {

	private MatchNodeList validMappings;
	
	public ValidMappingListener(MatchNodeList validMappings) {
		super();
		this.validMappings = validMappings;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		while (parent.getRolemodel() == null && parent.getMetamodel() == null) {
			if(!validMappings.contains(parent)){
				validMappings.add(parent);
			}
			parent = parent.getParent();
		}
	}

	public MatchNodeList getValidMappings() {
		return validMappings;
	}
	
}
