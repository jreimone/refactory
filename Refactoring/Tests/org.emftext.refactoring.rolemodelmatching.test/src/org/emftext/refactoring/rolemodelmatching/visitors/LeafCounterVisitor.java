package org.emftext.refactoring.rolemodelmatching.visitors;

import java.util.concurrent.atomic.AtomicInteger;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

public class LeafCounterVisitor implements INodeVisitor {

	private AtomicInteger count = new AtomicInteger();
	
	public void visit(StringMappingNode node, Object context) {
		count.incrementAndGet();
	}

	public int getLeafCount(){
		return count.intValue();
	}
}
