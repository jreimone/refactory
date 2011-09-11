package org.emftext.refactoring.rolemodelmatching.visitors;

import java.util.concurrent.atomic.AtomicInteger;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;
import org.emftext.refactoring.rolemodelmatching.StringMappingNodeList;

public class PreSelectedMappingsCountVisitor implements INodeVisitor {

	private AtomicInteger preSelectedMappingsCount = new AtomicInteger();
	
	public void visit(StringMappingNode node) {
		StringMappingNodeList completeMapping = node.getListFromRoot();
		preSelectedMappingsCount.addAndGet(completeMapping.size());
	}

	public int getPreSelectedMappingsCount() {
		return preSelectedMappingsCount.intValue();
	}

}
