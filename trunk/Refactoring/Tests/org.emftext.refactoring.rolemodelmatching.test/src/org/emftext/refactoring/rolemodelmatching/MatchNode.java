package org.emftext.refactoring.rolemodelmatching;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.rolemodelmatching.listener.IIncompleteNodeListener;
import org.emftext.refactoring.rolemodelmatching.listener.INodeListener;

public abstract class MatchNode <RoleModelElement extends EObject, MetaModelElement extends EObject>{

	private MatchNode<?,?> parent;
	private List<MatchNode<?,?>> children;
	private boolean complete = false;
	private List<INodeListener> listener;
	
	public List<INodeListener> getListener() {
		return listener;
	}
	
	public void addListener(INodeListener listener){
		if(this.listener == null){
			this.listener = new LinkedList<INodeListener>();
		}
		if(listener != null && !this.listener.contains(listener)){
			this.listener.add(listener);
			listener.setSubject(this);
		}
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
		if(complete){
			updateCompletePathNode();
		} else {
			updateIncompletePathNode();
		}
	}

	private void updateIncompletePathNode() {
		initListenersFromRoot();
		if(listener != null){
			for (INodeListener listener : this.listener) {
				if(listener instanceof IIncompleteNodeListener){
					listener.execute(this);
				}
			}
		}
	}

	public void updateCompletePathNode() {
		initListenersFromRoot();
		if(listener != null){
			for (INodeListener listener : this.listener) {
				if(!(listener instanceof IIncompleteNodeListener)){
					listener.execute(this);
				}
			}
		}
	}

	private void initListenersFromRoot() {
		List<INodeListener> rootListeners = getRoot().getListener();
		if(!(rootListeners == null || rootListeners.size() == 0)){
			if(listener == null){
				listener = new LinkedList<INodeListener>();
			}
			listener.addAll(rootListeners);
			
		}
	}

	// used for an element from the metamodel - can be an EClass, an EAtribute or an ReferenceMetaClassPair
	private MetaModelElement metaElement;
	// used for an element from the rolemodel - can be a Role, a RoleAttribute or a MultiplicityCollaboration
	private RoleModelElement roleElement;

	public MetaModelElement getMetaElement() {
		return metaElement;
	}

	public void setMetaElement(MetaModelElement metaElement) {
		this.metaElement = metaElement;
	}

	public RoleModelElement getRoleElement() {
		return roleElement;
	}

	public void setRoleElement(RoleModelElement roleElement) {
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

	public List<MatchNode<?,?>> getChildren() {
		return children;
	}

	public MatchNode(MatchNode<?,?> parent) {
		super();
		this.parent = parent;
		children = new LinkedList<MatchNode<?,?>>();
		if(parent != null){
			parent.getChildren().add(this);
		}
	}

	public MatchNode<?,?> getParent() {
		return parent;
	}

	public RoleNode getRoot(){
		if(parent == null){
			return (RoleNode) this;
		}
		MatchNode<?, ?> node = parent;
		while (node.getParent() != null) {
			node = node.getParent();
		}
		return (RoleNode) node;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (complete ? 1231 : 1237);
		result = prime * result
				+ ((metaElement == null) ? 0 : metaElement.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result
				+ ((roleElement == null) ? 0 : roleElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchNode<?,?> other = (MatchNode<?,?>) obj;
		MatchNode<?,?> current = this;
		while (current != null) {
			EObject roleElementOther = other.getRoleElement();
			EObject metaElementOther = other.getMetaElement();
			if(!EcoreUtil.equals(current.getRoleElement(), roleElementOther)){
				return false;
			}
			if(!EcoreUtil.equals(current.getMetaElement(), metaElementOther)){
				return false;
			}
			other = other.getParent();
			current = current.getParent();
		}
		if(other == null){
			return true;
		}
		return false;
	}

}
