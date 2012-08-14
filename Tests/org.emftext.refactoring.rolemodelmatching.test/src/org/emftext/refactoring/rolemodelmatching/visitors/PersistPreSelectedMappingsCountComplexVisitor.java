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

import org.emftext.refactoring.rolemodelmatching.RolemodelMatchingTestInitialization;
import org.emftext.refactoring.rolemodelmatching.StringMappingNode;
import org.emftext.refactoring.rolemodelmatching.StringMappingNodeList;

public class PersistPreSelectedMappingsCountComplexVisitor implements INodeVisitor {

	private FileWriter fileWriter;

	public PersistPreSelectedMappingsCountComplexVisitor(FileWriter fileWriter) {
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
			fileWriter.append("manual mappings which result in less than " + RolemodelMatchingTestInitialization.MAX_MAPPINGS_COUNT + " valid complete mappings (" + completeMapping.size() + " pre-selected): ");
			//				System.out.print("manual mappings which result in less than " + MAX_MAPPINGS_COUNT + " valid complete mappings (" + completeMapping.size() + " pre-selected): ");
			//					printMappingNodeList(completeMapping);
			fileWriter.append(completeMapping.printList() + "\n");
			fileWriter.append("\tleft valid mappings: " + filteredLeafList.size() + "\n");
//			System.out.println("\tleft valid mappings: " + filteredLeafList.size());
			for (StringMappingNode stringMappingNode : filteredLeafList) {
				//					System.out.print("\t");
				fileWriter.append("\t");
				//					printMappingNodeList(stringMappingNode.getListFromRoot());
				fileWriter.append(stringMappingNode.getListFromRoot().printList() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}

}
