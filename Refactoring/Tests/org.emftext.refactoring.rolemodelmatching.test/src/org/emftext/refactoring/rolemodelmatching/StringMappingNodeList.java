/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
