package org.emftext.refactoring.rolemodelmatching.visitors;

import java.util.ArrayList;
import java.util.List;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

public class LeafCollectorVisitor implements INodeVisitor {

	private List<StringMappingNode> leafList;

	public void visit(StringMappingNode node) {
		if(leafList == null){
			leafList = new ArrayList<StringMappingNode>();
		}
		leafList.add(node);
	}

	public List<StringMappingNode> getLeafList() {
		return leafList;
	}

}
