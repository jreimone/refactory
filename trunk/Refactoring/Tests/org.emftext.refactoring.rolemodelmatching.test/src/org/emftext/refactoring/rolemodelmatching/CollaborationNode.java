package org.emftext.refactoring.rolemodelmatching;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.roles.Collaboration;

public class CollaborationNode extends
		MatchNode<Collaboration, EReference> {

	public CollaborationNode(MatchNode<?, ?> parent) {
		super(parent);
	}

}
