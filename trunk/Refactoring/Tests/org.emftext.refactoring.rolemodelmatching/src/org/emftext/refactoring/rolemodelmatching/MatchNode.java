package org.emftext.refactoring.rolemodelmatching;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.roles.RoleModel;

public class MatchNode {

	private MatchNode parent;
	private List<MatchNode> children;

	// used for an element from the metamodel - can be an EClass, an EAtribute or an ReferenceMetaClassPair
	private EObject metaElement;
	// used for an element from the rolemodel - can be a Role, a RoleAttribute or a MultiplicityCollaboration
	private EObject roleElement;

	public EObject getMetaElement() {
		return metaElement;
	}

	public void setMetaElement(EObject metaElement) {
		this.metaElement = metaElement;
	}

	public EObject getRoleElement() {
		return roleElement;
	}

	public void setRoleElement(EObject roleElement) {
		this.roleElement = roleElement;
	}

	// used for indicating metamodel and rolemodel for a match run
	private EPackage metamodel;
	public EPackage getMetamodel() {
		return metamodel;
	}

	public RoleModel getRolemodel() {
		return rolemodel;
	}

	private RoleModel rolemodel;

	public void setMetamodel(EPackage metamodel) {
		this.metamodel = metamodel;
	}

	public void setRolemodel(RoleModel rolemodel) {
		this.rolemodel = rolemodel;
	}

	public List<MatchNode> getChildren() {
		return children;
	}

	public MatchNode(MatchNode parent) {
		super();
		this.parent = parent;
		children = new LinkedList<MatchNode>();
		if(parent != null){
			parent.getChildren().add(this);
		}
	}

	public MatchNode getParent() {
		return parent;
	}

}
