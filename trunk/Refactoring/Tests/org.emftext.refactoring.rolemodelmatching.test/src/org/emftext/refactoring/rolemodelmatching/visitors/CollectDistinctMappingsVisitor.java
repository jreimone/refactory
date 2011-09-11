package org.emftext.refactoring.rolemodelmatching.visitors;

import java.util.HashSet;
import java.util.Set;

import org.emftext.refactoring.rolemodelmatching.RolemodelMatchingTestSuite;
import org.emftext.refactoring.rolemodelmatching.StringMappingNode;

/**
 * Collects all distinct mappings from role to a metaclass. Since a valid mapping,
 * such as e.g. Role1 -> Metaclass1, can be part of several complete role mappings
 * this mapping is collected only once by this visitor.
 * @author jreimann
 *
 */
public class CollectDistinctMappingsVisitor implements INodeVisitor {

	private Set<String> distinctNodeSet;
	
	public void visit(StringMappingNode node) {
		if(distinctNodeSet == null){
			distinctNodeSet = new HashSet<String>();
		}
		StringMappingNode parent = node;
		while (parent.getParent() != null) {
			if(parent.getMappingString().contains(RolemodelMatchingTestSuite.ROLE_CONNECTOR)){
				distinctNodeSet.add(parent.getMappingString());
			}
			parent = parent.getParent();
		}
	}

	public Set<String> getDistinctNodeSet() {
		return distinctNodeSet;
	}

}
