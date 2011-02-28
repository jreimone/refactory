package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class PrintMatchPathListener extends AbstractNodeListener {

	private MatchNode<?, ?> leaf;

	public void execute(MatchNode<?, ?> node) {
		leaf = node;
		StringBuffer printPath = printPath(leaf);
		System.out.println(printPath.toString());
	}

	protected StringBuffer printPath(MatchNode<?, ?> leaf){
		StringBuffer print = new StringBuffer();
		List<MatchNode<?, ?>> matchPath = new LinkedList<MatchNode<?, ?>>();
		MatchNode<?, ?> node = leaf;
		while (node != null && node.getMetaElement() != null
				&& node.getRoleElement() != null) {
			matchPath.add(node);
			node = node.getParent();
		}
		Collections.reverse(matchPath);
		int count = 0;
		count++;
		for (MatchNode<?, ?> matchNode : matchPath) {
			print.append(printNode(matchNode) + "\t");
		}
		print.append("\n");
		return print;
	}

	protected StringBuffer printNode(MatchNode<?, ?> matchNode) {
		StringBuffer node = new StringBuffer();
		EObject roleElement = matchNode.getRoleElement();
		String roleString = "";
		if (roleElement instanceof Role) {
			roleString = ((Role) roleElement).getName();
		} else if (roleElement instanceof MultiplicityCollaboration) {
			roleString = ((MultiplicityCollaboration) roleElement).getTargetName();
		}
		EObject metaElement = matchNode.getMetaElement();
		String metaString = "";
		if (metaElement instanceof ENamedElement) {
			metaString = ((ENamedElement) metaElement).getName();
		}
		node.append(roleString + " --> " + metaString);
		return node;
	}
	
}
