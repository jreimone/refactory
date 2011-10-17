package org.emftext.refactoring.rolemodelmatching.listener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.rolemodelmatching.MatchNode;
import org.emftext.refactoring.rolemodelmatching.RolemodelMatchingTestInitialization;

public class PersistMatchPathListener extends AbstractNodeListener {

	private FileWriter writer;
	private boolean print;
	
	public PersistMatchPathListener(FileWriter writer, boolean print){
		this.writer = writer;
		this.print = print;
	}
	
	@Override
	public void execute(MatchNode<?, ?> node) {
		StringBuffer printPath = printPath(node);
		try {
			writer.append(printPath.toString());
			writer.flush();
			if(print){
				System.out.println(printPath.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private StringBuffer printPath(MatchNode<?, ?> node) {
		MatchNode<?, ?> treeNode = node;
		StringBuffer buffer = new StringBuffer();
		List<MatchNode<?, ?>> matchPath = new ArrayList<MatchNode<?, ?>>();
		while (treeNode != null && treeNode.getMetaElement() != null && treeNode.getRoleElement() != null) {
			matchPath.add(treeNode);
			treeNode = treeNode.getParent();
		}
		Collections.reverse(matchPath);
		for (MatchNode<?, ?> matchNode : matchPath) {
			buffer.append(printNode(matchNode));
			if(matchPath.indexOf(matchNode) < (matchPath.size() - 1)) {
				buffer.append(RolemodelMatchingTestInitialization.MAPPING_SEPARATOR) ;
			}
		}
		buffer.append("\n");
		return buffer;
	}

	private Object printNode(MatchNode<?, ?> matchNode) {
		StringBuffer node = new StringBuffer();
		EObject roleElement = matchNode.getRoleElement();
		String roleString = "";
		String connector = "";
		if (roleElement instanceof Role) {
			roleString = ((Role) roleElement).getName();
			connector = RolemodelMatchingTestInitialization.ROLE_CONNECTOR;
		} else if (roleElement instanceof MultiplicityCollaboration) {
			roleString = ((MultiplicityCollaboration) roleElement).getTargetName();
			connector = RolemodelMatchingTestInitialization.COLL_CONNECTOR;
		}
		EObject metaElement = matchNode.getMetaElement();
		String metaString = "";
		if (metaElement instanceof ENamedElement) {
			metaString = ((ENamedElement) metaElement).getName();
		}
		node.append(roleString + connector + metaString);
		return node;
	}

}
