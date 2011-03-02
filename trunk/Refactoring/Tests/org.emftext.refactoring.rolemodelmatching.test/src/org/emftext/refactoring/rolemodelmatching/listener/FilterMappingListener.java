package org.emftext.refactoring.rolemodelmatching.listener;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.rolemodelmatching.MatchNode;
import org.emftext.refactoring.rolemodelmatching.RoleNode;

/**
 * This listener checks if a path contains a given mapping passed to the constructor.
 * If this is not the case this path won't be counted. By this a filter is realized
 * to determine how much matches reside if one mapping is pre-selected (maybe by the user). 
 * 
 * @author jreimann
 *
 */
public class FilterMappingListener extends AbstractNodeListener {

	private RoleNode filterMapping;
	private AtomicInteger filterCount;
	private RoleModel rolemodel;
	private EPackage metamodel;
	
	public FilterMappingListener(RoleNode filterMapping, AtomicInteger filterCount, RoleModel rolemodel, EPackage metamodel) {
		super();
		this.filterMapping = filterMapping;
		this.filterCount = filterCount;
		this.rolemodel = rolemodel;
		this.metamodel = metamodel;
	}

	@Override
	public void execute(MatchNode<?, ?> node) {
		MatchNode<?, ?> parent = node;
		while (parent.getRolemodel() == null && parent.getMetamodel() == null) {
			if(parent instanceof RoleNode){
				if(parent.equalsNode(filterMapping)){
					filterCount.incrementAndGet();
					break;
				}
			}
			parent = parent.getParent();
		}
	}

	public void printFilteredMatches(){
		System.out.println("\tPre-selected mapping: " + filterMapping.getRoleElement().getName() + " --> " + filterMapping.getMetaElement().getName());
		System.out.println("\t" + rolemodel.getName() + " --> " + metamodel.getNsURI() + " mapped: " + filterCount.get());
	}
}
