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

import java.util.Collections;
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

	public StringMappingNode(StringMappingNode parent) {
		super();
		this.parent = parent;
		children = new StringMappingNodeList();
		if(this.parent != null){
			this.parent.getChildren().add(this);
		}
	}
	
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
		if(obj instanceof String){
			return mappingString.equals(obj);
		}
		if(obj instanceof StringMappingNode){
			return (mappingString.equals(((StringMappingNode) obj).getMappingString()));
		}
		return false;
	}

	@Override
	public String toString() {
		return getMappingString();
	}
	
	public StringMappingNodeList getListFromRoot(){
		StringMappingNodeList rootList = new StringMappingNodeList();
		StringMappingNode parent = this;
		while (parent.getParent() != null) {
			rootList.add(parent);
			parent = parent.getParent();
		}
		Collections.reverse(rootList);
		return rootList;
	}
}
