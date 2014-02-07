/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.Condition;
import org.modelrefactoring.evolution.coed.Event;
import org.modelrefactoring.evolution.coed.MetamodelImport;
import org.modelrefactoring.evolution.coed.PlainCondition;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractCoedInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.modelrefactoring.evolution.coed.resource.coed.ICoedInterpreterListener> listeners = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ICoedInterpreterListener>();
	private EObject nextObjectToInterprete;
	private ContextType currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.modelrefactoring.evolution.coed.CoEvolutionDefinition) {
			result = interprete_org_modelrefactoring_evolution_coed_CoEvolutionDefinition((org.modelrefactoring.evolution.coed.CoEvolutionDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.Event) {
			result = interprete_org_modelrefactoring_evolution_coed_Event((org.modelrefactoring.evolution.coed.Event) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.Condition) {
			result = interprete_org_modelrefactoring_evolution_coed_Condition((org.modelrefactoring.evolution.coed.Condition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.Action) {
			result = interprete_org_modelrefactoring_evolution_coed_Action((org.modelrefactoring.evolution.coed.Action) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.RoleMappingEvent) {
			result = interprete_org_modelrefactoring_evolution_coed_RoleMappingEvent((org.modelrefactoring.evolution.coed.RoleMappingEvent) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.PlainCondition) {
			result = interprete_org_modelrefactoring_evolution_coed_PlainCondition((org.modelrefactoring.evolution.coed.PlainCondition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.RoleMappingAction) {
			result = interprete_org_modelrefactoring_evolution_coed_RoleMappingAction((org.modelrefactoring.evolution.coed.RoleMappingAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.coed.MetamodelImport) {
			result = interprete_org_modelrefactoring_evolution_coed_MetamodelImport((org.modelrefactoring.evolution.coed.MetamodelImport) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_CoEvolutionDefinition(CoEvolutionDefinition coEvolutionDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_Event(Event event, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_Condition(Condition condition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_Action(Action action, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_RoleMappingEvent(RoleMappingEvent roleMappingEvent, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_PlainCondition(PlainCondition plainCondition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_RoleMappingAction(RoleMappingAction roleMappingAction, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_coed_MetamodelImport(MetamodelImport metamodelImport, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.modelrefactoring.evolution.coed.resource.coed.ICoedInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(Collection<? extends EObject> objects) {
		for (EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(Collection<? extends EObject> objects) {
		List<EObject> reverse = new ArrayList<EObject>(objects.size());
		reverse.addAll(objects);
		Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(EObject root) {
		List<EObject> objects = new ArrayList<EObject>();
		objects.add(root);
		Iterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.modelrefactoring.evolution.coed.resource.coed.ICoedInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.modelrefactoring.evolution.coed.resource.coed.ICoedInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public Stack<EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public ContextType getCurrentContext() {
		return currentContext;
	}
	
}
