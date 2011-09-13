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
