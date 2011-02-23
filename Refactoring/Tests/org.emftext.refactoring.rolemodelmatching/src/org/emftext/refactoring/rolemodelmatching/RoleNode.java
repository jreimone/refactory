package org.emftext.refactoring.rolemodelmatching;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.refactoring.roles.Role;

public class RoleNode extends MatchNode<Role, EClass> {

	public RoleNode(MatchNode<?, ?> parent) {
		super(parent);
	}

}
