package org.emftext.refactoring.postprocessors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

public class UMLExtractCompositeStatePostProcessor implements IRefactoringPostProcessor {

	private List<State> extract;
	private State newContainer;

	@SuppressWarnings("unchecked")
	public void process(Map<Role, Object> roleRuntimeInstanceMap) {
		System.out.println("Add additional transitions for 'Extract Composite State' in UML");
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			Object runtimeObject = roleRuntimeInstanceMap.get(role);
			if(role.getName().equals("Extract")){
				if(runtimeObject instanceof List<?>){
					extract = (List<State>) runtimeObject;
				}
			} else if(role.getName().equals("NewContainer")){
				if(runtimeObject instanceof State){
					newContainer = (State) runtimeObject;
				}
			}
		}
		processAdditionals();
	}

	private void processAdditionals(){
		moveRelevantTransitionsToCompositeState();
		createActivity();
	}

	private void moveRelevantTransitionsToCompositeState(){
		Set<Transition> removees = new HashSet<Transition>();
		Set<Transition> inComposites = new HashSet<Transition>();
		Set<Transition> outComposites = new HashSet<Transition>();
		for (State state : extract) {
			List<State> others = new ArrayList<State>();
			for (State other : extract) {
				if(!other.equals(state)){
					others.add(other);
				}
			}
			List<Transition> incomings = state.getIncomings();
			handleTransitions(removees, inComposites, others, incomings, true);
			List<Transition> outgoings = state.getOutgoings();
			handleTransitions(removees, outComposites, others, outgoings, false);
		}

		handleInternalTransitions(removees);
		for (Transition transition : inComposites) {
			transition.setTarget(newContainer);
			System.out.println("set '" + newContainer + "' as new target of incoming transition");
		}
		for (Transition transition : outComposites) {
			transition.setSource(newContainer);
			System.out.println("set '" + newContainer + "' as new source of outgoing transition");
		}
	}

	private void handleInternalTransitions(Set<Transition> removees) {
		List<Region> regions = newContainer.getRegions();
		for (Region region : regions) {
			if(region.getSubvertices().containsAll(extract)){
				for (Transition transition : removees) {
					EcoreUtil.remove(transition);
					region.getTransitions().add(transition);
				}
			}
		}
	}

	private void handleTransitions(Set<Transition> removees, Set<Transition> outsides, List<State> others, List<Transition> transitions, boolean source) {
		for (Transition transition : transitions) {
			Vertex vertex = null;
			if(source){
				vertex = transition.getSource();
			} else {
				vertex = transition.getTarget();
			}
			if(others.contains(vertex)){
				removees.add(transition);
			} else {
				outsides.add(transition);
			}
		}
	}

	private void createActivity(){
		Activity activity = UMLFactory.eINSTANCE.createActivity();
		activity.setName(newContainer.getName() + "Activity");
		newContainer.setDoActivity(activity);
		System.out.println("set new doActivity for " + newContainer);
	}
}
