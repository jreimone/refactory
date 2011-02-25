package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.rolemodelmatching.MatchNode;

public class MatchCountListener extends AbstractNodeListener {

	private AtomicInteger count;
	private RoleModel rolemodel;
	private EPackage metamodel;
	
	public MatchCountListener(AtomicInteger count, RoleModel rolemodel, EPackage metamodel) {
		super();
		this.count = count;
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
	}

	public void execute(MatchNode<?, ?> node) {
		count.incrementAndGet();
	}

	public void printCount(){
		System.err.println("RoleModel '" + rolemodel.getName() + "' could be mapped in metamodel '" + metamodel.getNsURI() + "': " + count.get() + " times");
	}
	
	public AtomicInteger getCount(){
		return count;
	}
}
