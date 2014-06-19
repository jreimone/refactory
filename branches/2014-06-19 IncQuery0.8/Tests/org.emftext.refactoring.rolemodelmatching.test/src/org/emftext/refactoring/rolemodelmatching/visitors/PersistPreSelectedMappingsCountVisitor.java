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
package org.emftext.refactoring.rolemodelmatching.visitors;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.emftext.refactoring.rolemodelmatching.StringMappingNode;
import org.emftext.refactoring.rolemodelmatching.StringMappingNodeList;

public class PersistPreSelectedMappingsCountVisitor implements INodeVisitor {

	private FileWriter fileWriter;
	
	public PersistPreSelectedMappingsCountVisitor(FileWriter fileWriter) {
		super();
		this.fileWriter = fileWriter;
	}

	@SuppressWarnings("unchecked")
	public void visit(StringMappingNode node, Object context) {
		List<StringMappingNode> filteredLeafList = null;
		if(context instanceof List<?> && !((List<?>) context).isEmpty() && (((List<?>) context).get(0) instanceof StringMappingNode)){
			filteredLeafList = (List<StringMappingNode>) context;
		}
		StringMappingNodeList completeMapping = node.getListFromRoot();
		try {
			fileWriter.append(completeMapping.size() + ";");
			if(filteredLeafList != null){
				fileWriter.append(filteredLeafList.size() + ";");
			}
			fileWriter.append(completeMapping.printList() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}

}
