package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class RemoveIncompletePathListener extends AbstractNodeListener implements IIncompleteNodeListener {

	private AtomicInteger incompleteCount;
	private RoleModel rolemodel;
	private EPackage metamodel;
	
	public RemoveIncompletePathListener(AtomicInteger incompleteCount, RoleModel rolemodel, EPackage metamodel){
		this.incompleteCount = incompleteCount;
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
	}
	
	@Override
	public void execute(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		MatchNode<?, ?> child = node;
		while (parent.getParent() != null && (parent.getChildren().size() == 0 || parent.getChildren().size() == 1)) {
			child = parent;
			parent = parent.getParent();
		}
		parent.getChildren().remove(child);
		incompleteCount.incrementAndGet();
	}
	
	public void printIncompleteRemovals(){
		System.out.println(rolemodel.getName() + " --> " + metamodel.getNsURI() + " removed: " + incompleteCount.get());
	}
}
