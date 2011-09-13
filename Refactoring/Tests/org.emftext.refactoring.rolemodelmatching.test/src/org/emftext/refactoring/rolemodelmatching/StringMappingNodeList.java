package org.emftext.refactoring.rolemodelmatching;

import java.util.ArrayList;

/**
 * Help class for better handling list containing {@link StringMappingNode}s to enable simple comparison with Strings.
 * 
 * @author jreimann
 *
 */
public class StringMappingNodeList extends ArrayList<StringMappingNode> {

	private static final long serialVersionUID = -6365441883372699971L;

	@Override
	public boolean contains(Object elem) {
		if(!(elem instanceof String || elem instanceof StringMappingNode)){
			return false;
		}
		for (StringMappingNode node : this) {
			if(node.equals(elem)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object elem) {
		for (int i = 0; i < this.size(); i++) {
			StringMappingNode node = this.get(i);
			if(node.equals(elem)){
				return i;
			}
		}
		return -1;
	}
	
	public String printList() {
		StringBuffer buffer = new StringBuffer();
		for (StringMappingNode stringMappingNode : this) {
			String suffix = "";
			int index = this.indexOf(stringMappingNode);
			if(index < (this.size() - 1)){
				suffix = " - ";
			} else {
				//				suffix = "\n";
			}
			buffer.append(stringMappingNode + suffix);
			//			System.out.print(stringMappingNode + suffix);
		}
		return buffer.toString();
	}
}
