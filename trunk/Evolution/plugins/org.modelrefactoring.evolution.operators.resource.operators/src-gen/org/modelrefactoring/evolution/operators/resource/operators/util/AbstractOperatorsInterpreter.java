/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.operators.ASSIGN;
import org.modelrefactoring.evolution.operators.CREATE;
import org.modelrefactoring.evolution.operators.DELETE;
import org.modelrefactoring.evolution.operators.EObjectReference;
import org.modelrefactoring.evolution.operators.EOperationQualifier;
import org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier;
import org.modelrefactoring.evolution.operators.MERGE;
import org.modelrefactoring.evolution.operators.MOVE;
import org.modelrefactoring.evolution.operators.Operator;
import org.modelrefactoring.evolution.operators.PrimitiveReference;
import org.modelrefactoring.evolution.operators.QueryVariable;
import org.modelrefactoring.evolution.operators.QueryVariableQualifier;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.Result;
import org.modelrefactoring.evolution.operators.SET;
import org.modelrefactoring.evolution.operators.SPLIT;
import org.modelrefactoring.evolution.operators.StructuralFeatureSet;
import org.modelrefactoring.evolution.operators.TypeVariable;
import org.modelrefactoring.evolution.operators.VAR;
import org.modelrefactoring.evolution.operators.Variable;
import org.modelrefactoring.evolution.operators.VariableReference;

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
public class AbstractOperatorsInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsInterpreterListener> listeners = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsInterpreterListener>();
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
		if (object instanceof org.modelrefactoring.evolution.operators.CREATE) {
			result = interprete_org_modelrefactoring_evolution_operators_CREATE((org.modelrefactoring.evolution.operators.CREATE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.DELETE) {
			result = interprete_org_modelrefactoring_evolution_operators_DELETE((org.modelrefactoring.evolution.operators.DELETE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.ASSIGN) {
			result = interprete_org_modelrefactoring_evolution_operators_ASSIGN((org.modelrefactoring.evolution.operators.ASSIGN) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.Operator) {
			result = interprete_org_modelrefactoring_evolution_operators_Operator((org.modelrefactoring.evolution.operators.Operator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.TypeVariable) {
			result = interprete_org_modelrefactoring_evolution_operators_TypeVariable((org.modelrefactoring.evolution.operators.TypeVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.EObjectReference) {
			result = interprete_org_modelrefactoring_evolution_operators_EObjectReference((org.modelrefactoring.evolution.operators.EObjectReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.PrimitiveReference) {
			result = interprete_org_modelrefactoring_evolution_operators_PrimitiveReference((org.modelrefactoring.evolution.operators.PrimitiveReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.Result) {
			result = interprete_org_modelrefactoring_evolution_operators_Result((org.modelrefactoring.evolution.operators.Result) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.VariableReference) {
			result = interprete_org_modelrefactoring_evolution_operators_VariableReference((org.modelrefactoring.evolution.operators.VariableReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.Referrable) {
			result = interprete_org_modelrefactoring_evolution_operators_Referrable((org.modelrefactoring.evolution.operators.Referrable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.SET) {
			result = interprete_org_modelrefactoring_evolution_operators_SET((org.modelrefactoring.evolution.operators.SET) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.MOVE) {
			result = interprete_org_modelrefactoring_evolution_operators_MOVE((org.modelrefactoring.evolution.operators.MOVE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.SPLIT) {
			result = interprete_org_modelrefactoring_evolution_operators_SPLIT((org.modelrefactoring.evolution.operators.SPLIT) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.StructuralFeatureSet) {
			result = interprete_org_modelrefactoring_evolution_operators_StructuralFeatureSet((org.modelrefactoring.evolution.operators.StructuralFeatureSet) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.MERGE) {
			result = interprete_org_modelrefactoring_evolution_operators_MERGE((org.modelrefactoring.evolution.operators.MERGE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.VAR) {
			result = interprete_org_modelrefactoring_evolution_operators_VAR((org.modelrefactoring.evolution.operators.VAR) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.QueryVariable) {
			result = interprete_org_modelrefactoring_evolution_operators_QueryVariable((org.modelrefactoring.evolution.operators.QueryVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.Variable) {
			result = interprete_org_modelrefactoring_evolution_operators_Variable((org.modelrefactoring.evolution.operators.Variable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.EOperationQualifier) {
			result = interprete_org_modelrefactoring_evolution_operators_EOperationQualifier((org.modelrefactoring.evolution.operators.EOperationQualifier) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier) {
			result = interprete_org_modelrefactoring_evolution_operators_EStructuralFeatureQualifier((org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.evolution.operators.QueryVariableQualifier) {
			result = interprete_org_modelrefactoring_evolution_operators_QueryVariableQualifier((org.modelrefactoring.evolution.operators.QueryVariableQualifier) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_Operator(Operator operator, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_CREATE(CREATE cREATE, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_TypeVariable(TypeVariable typeVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_DELETE(DELETE dELETE, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_ASSIGN(ASSIGN aSSIGN, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_EObjectReference(EObjectReference eObjectReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_Result(Result result, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_Referrable(Referrable referrable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_PrimitiveReference(PrimitiveReference primitiveReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_SET(SET sET, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_VariableReference(VariableReference variableReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_MOVE(MOVE mOVE, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_SPLIT(SPLIT sPLIT, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_StructuralFeatureSet(StructuralFeatureSet structuralFeatureSet, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_MERGE(MERGE mERGE, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_VAR(VAR vAR, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_QueryVariable(QueryVariable queryVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_Variable(Variable variable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_QueryVariableQualifier(QueryVariableQualifier queryVariableQualifier, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_EOperationQualifier(EOperationQualifier eOperationQualifier, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_evolution_operators_EStructuralFeatureQualifier(EStructuralFeatureQualifier eStructuralFeatureQualifier, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.modelrefactoring.evolution.operators.resource.operators.IOperatorsInterpreterListener listener : listeners) {
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
	
	public void addListener(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsInterpreterListener listener) {
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
