package org.emftext.refactoring.rolemodelmatching;

import java.util.List;

/**
 * This class is used to construct the whole match tree after it was persisted to disc.
 * Since we only need String comparison this strategy saves memory while determing valid
 * matches for pre-selected mappings.
 * 
 * @author jreimann
 *
 */
public class StringMappingNode {

	private String mappingString;
	private StringMappingNode parent;
	private List<StringMappingNode> children;
//	private StringMappingNode root;

	public StringMappingNode(StringMappingNode parent) {
		super();
		this.parent = parent;
		children = new StringMappingNodeList();
		if(this.parent != null){
			this.parent.getChildren().add(this);
		}
//		root = determineRoot();
	}
	
//	private StringMappingNode determineRoot(){
//		if(parent == null){
//			return this;
//		}
//		StringMappingNode node = parent;
//		while (node.getParent() != null) {
//			node = node.getParent();
//		}
//		return node;
//	}

	public String getMappingString() {
		return mappingString;
	}

	public void setMappingString(String mappingString) {
		this.mappingString = mappingString;
	}

	public StringMappingNode getParent() {
		return parent;
	}

	public List<StringMappingNode> getChildren() {
		return children;
	}

	@Override
	public boolean equals(Object obj) {
		if(mappingString == null || obj == null){
			return false;
		}
		return mappingString.equals(obj);
	}

	@Override
	public String toString() {
		return mappingString;
	} 
}
