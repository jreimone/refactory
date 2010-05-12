package org.eclipse.stp.bpmn.refactoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stp.bpmn.Activity;
import org.eclipse.stp.bpmn.ActivityType;
import org.eclipse.stp.bpmn.BpmnFactory;
import org.eclipse.stp.bpmn.SequenceEdge;
import org.eclipse.stp.bpmn.SubProcess;
import org.eclipse.stp.bpmn.Vertex;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

public class ExtractSubProcessPostProcessor implements IRefactoringPostProcessor {

	private List<EObject> extract;
	private SubProcess newContainer;

	public ExtractSubProcessPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		System.out.println("Add additional SequenceEdge for 'Extract SubProcess' in BPMN");
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
		Activity start = BpmnFactory.eINSTANCE.createActivity();
		start.setActivityType(ActivityType.EVENT_START_EMPTY_LITERAL);
		newContainer.getVertices().add(start);
		Activity end = BpmnFactory.eINSTANCE.createActivity();
		end.setActivityType(ActivityType.EVENT_END_EMPTY_LITERAL);
		newContainer.getVertices().add(end);
		Activity first = (Activity) extract.get(0);
		Activity last = (Activity) extract.get(extract.size() - 1);
		SequenceEdge edge = BpmnFactory.eINSTANCE.createSequenceEdge();
		newContainer.getSequenceEdges().add(edge);
		edge.setSource(start);
		edge.setTarget(first);
		edge = BpmnFactory.eINSTANCE.createSequenceEdge();
		newContainer.getSequenceEdges().add(edge);
		edge.setSource(last);
		edge.setTarget(end);
		return true;
	}

	private Boolean moveRelevantAssociationsToSubProcess(){
		Set<SequenceEdge> removees = new HashSet<SequenceEdge>();
		Set<SequenceEdge> inComposites = new HashSet<SequenceEdge>();
		Set<SequenceEdge> outComposites = new HashSet<SequenceEdge>();
		for (EObject eObject : extract) {
			Activity activity = (Activity) eObject;
			List<Activity> others = new ArrayList<Activity>();
			for (EObject otherObject : extract) {
				Activity other = (Activity) otherObject;
				if(!other.equals(activity)){
					others.add(other);
				}
			}
			List<SequenceEdge> incomings = activity.getIncomingEdges();
			handleTransitions(removees, inComposites, others, incomings, true);
			List<SequenceEdge> outgoings = activity.getOutgoingEdges();
			handleTransitions(removees, outComposites, others, outgoings, false);
		}

		handleInternalTransitions(removees);
		for (SequenceEdge edge : inComposites) {
			edge.setTarget(newContainer);
			System.out.println("set '" + newContainer + "' as new target of incoming SequenceEdge");
		}
		for (SequenceEdge edge : outComposites) {
			edge.setSource(newContainer);
			System.out.println("set '" + newContainer + "' as new source of outgoing SequenceEdge");
		}
		return true;
	}

	private Boolean handleInternalTransitions(Set<SequenceEdge> removees) {
		for (SequenceEdge edge : removees) {
			EcoreUtil.remove(edge);
			if(!newContainer.getSequenceEdges().add(edge)){
				return false;
			}
		}
		return true;
	}

	private void handleTransitions(Set<SequenceEdge> removees, Set<SequenceEdge> outsides, List<Activity> others, List<SequenceEdge> edges, boolean source) {
		for (SequenceEdge edge : edges) {
			Vertex vertex = null;
			if(source){
				vertex = edge.getSource();
			} else {
				vertex = edge.getTarget();
			}
			if(others.contains(vertex)){
				removees.add(edge);
			} else {
				outsides.add(edge);
			}
		}
	}
}
