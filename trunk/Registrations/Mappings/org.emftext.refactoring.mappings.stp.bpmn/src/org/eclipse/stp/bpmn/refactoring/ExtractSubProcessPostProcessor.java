/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.eclipse.stp.bpmn.refactoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.FlowNode;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

public class ExtractSubProcessPostProcessor extends AbstractRefactoringPostProcessor {

	private List<EObject> extract;
	private SubProcess newContainer;

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		//	System.out.println("Add additional SequenceEdge for 'Extract SubProcess' in BPMN");
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			List<EObject> runtimeObjects = roleRuntimeInstanceMap.get(role);
			if(role.getName().equals("Extract")){
				extract = runtimeObjects;
			} else if(role.getName().equals("NewContainer")){
				if(runtimeObjects.get(0) instanceof SubProcess){
					newContainer = (SubProcess) runtimeObjects.get(0);
				}
			}
		}
		boolean result = processAdditionals();
		if(!result){
			return new Status(IStatus.WARNING, "org.emftext.refactoring.rolemappings", "Couldn't determine correctly the outgoing and incoming transitions");
		}
		return new Status(IStatus.OK, "org.emftext.refactoring.rolemappings", "");
	}

	private Boolean processAdditionals(){
		Boolean result = moveRelevantAssociationsToSubProcess();
		result =  result && createStartAndEnd();
		return result;
	}

	private boolean createStartAndEnd(){
		Activity start = Bpmn2Factory.eINSTANCE.createCallActivity();
		//		start.setActivityType(ActivityType.EVENT_START_EMPTY_LITERAL);
		newContainer.getFlowElements().add(start);
		Activity end = Bpmn2Factory.eINSTANCE.createCallActivity();
		//		end.setActivityType(ActivityType.EVENT_END_EMPTY_LITERAL);
		newContainer.getFlowElements().add(end);
		Activity first = (Activity) extract.get(0);
		Activity last = (Activity) extract.get(extract.size() - 1);
		SequenceFlow edge = Bpmn2Factory.eINSTANCE.createSequenceFlow();
		newContainer.getFlowElements().add(edge);
		edge.setSourceRef(start);
		edge.setTargetRef(first);
		edge = Bpmn2Factory.eINSTANCE.createSequenceFlow();
		newContainer.getFlowElements().add(edge);
		edge.setSourceRef(last);
		edge.setTargetRef(end);
		return true;
	}

	private Boolean moveRelevantAssociationsToSubProcess(){
		Set<SequenceFlow> removees = new HashSet<SequenceFlow>();
		Set<SequenceFlow> inComposites = new HashSet<SequenceFlow>();
		Set<SequenceFlow> outComposites = new HashSet<SequenceFlow>();
		for (EObject eObject : extract) {
			Activity activity = (Activity) eObject;
			List<Activity> others = new ArrayList<Activity>();
			for (EObject otherObject : extract) {
				Activity other = (Activity) otherObject;
				if(!other.equals(activity)){
					others.add(other);
				}
			}
			List<SequenceFlow> incomings = activity.getIncoming();
			handleTransitions(removees, inComposites, others, incomings, true);
			List<SequenceFlow> outgoings = activity.getOutgoing();
			handleTransitions(removees, outComposites, others, outgoings, false);
		}

		handleInternalTransitions(removees);
		for (SequenceFlow edge : inComposites) {
			edge.setTargetRef(newContainer);
			//			System.out.println("set '" + newContainer + "' as new target of incoming SequenceEdge");
		}
		for (SequenceFlow edge : outComposites) {
			edge.setSourceRef(newContainer);
			//			System.out.println("set '" + newContainer + "' as new source of outgoing SequenceEdge");
		}
		return true;
	}

	private Boolean handleInternalTransitions(Set<SequenceFlow> removees) {
		for (SequenceFlow edge : removees) {
			EcoreUtil.remove(edge);
			if(!newContainer.getFlowElements().add(edge)){
				return false;
			}
		}
		return true;
	}

	private void handleTransitions(Set<SequenceFlow> removees, Set<SequenceFlow> outsides, List<Activity> others, List<SequenceFlow> edges, boolean source) {
		for (SequenceFlow edge : edges) {
			FlowNode vertex = null;
			if(source){
				vertex = edge.getSourceRef();
			} else {
				vertex = edge.getTargetRef();
			}
			if(others.contains(vertex)){
				removees.add(edge);
			} else {
				outsides.add(edge);
			}
		}
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {
		return process(roleRuntimeInstanceMap, resourceSet, change);
	}
}
