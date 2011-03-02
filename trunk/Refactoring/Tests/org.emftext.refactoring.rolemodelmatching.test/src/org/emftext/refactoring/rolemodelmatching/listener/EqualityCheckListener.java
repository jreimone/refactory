package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.Set;
import static org.junit.Assert.*;

import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class EqualityCheckListener extends AbstractNodeListener {

	private Set<MatchNode<?, ?>> nodeSet;
	
	public EqualityCheckListener(Set<MatchNode<?, ?>> nodeSet) {
		super();
		this.nodeSet = nodeSet;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		assertNotNull("Set mustn't be null", nodeSet);
		boolean notExisted = nodeSet.add(node);
		assertTrue("This mapping has already been matched", notExisted);
	}

}
