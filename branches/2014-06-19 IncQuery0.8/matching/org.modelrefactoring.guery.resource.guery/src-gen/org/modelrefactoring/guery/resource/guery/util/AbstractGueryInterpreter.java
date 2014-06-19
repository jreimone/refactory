/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.util;

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
public class AbstractGueryInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.modelrefactoring.guery.resource.guery.IGueryInterpreterListener> listeners = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.IGueryInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
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
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.modelrefactoring.guery.MotifModel) {
			result = interprete_org_modelrefactoring_guery_MotifModel((org.modelrefactoring.guery.MotifModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.Motif) {
			result = interprete_org_modelrefactoring_guery_Motif((org.modelrefactoring.guery.Motif) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.Role) {
			result = interprete_org_modelrefactoring_guery_Role((org.modelrefactoring.guery.Role) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.Constraint) {
			result = interprete_org_modelrefactoring_guery_Constraint((org.modelrefactoring.guery.Constraint) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.VertexSelection) {
			result = interprete_org_modelrefactoring_guery_VertexSelection((org.modelrefactoring.guery.VertexSelection) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.ConnectedBy) {
			result = interprete_org_modelrefactoring_guery_ConnectedBy((org.modelrefactoring.guery.ConnectedBy) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.Connection) {
			result = interprete_org_modelrefactoring_guery_Connection((org.modelrefactoring.guery.Connection) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.NotConnectedBy) {
			result = interprete_org_modelrefactoring_guery_NotConnectedBy((org.modelrefactoring.guery.NotConnectedBy) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.Grouping) {
			result = interprete_org_modelrefactoring_guery_Grouping((org.modelrefactoring.guery.Grouping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.PreProcessor) {
			result = interprete_org_modelrefactoring_guery_PreProcessor((org.modelrefactoring.guery.PreProcessor) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.EdgeSelection) {
			result = interprete_org_modelrefactoring_guery_EdgeSelection((org.modelrefactoring.guery.EdgeSelection) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.modelrefactoring.guery.Constrainable) {
			result = interprete_org_modelrefactoring_guery_Constrainable((org.modelrefactoring.guery.Constrainable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof java.util.Map.Entry<?,?>) {
			result = interprete_java_util_Map_Entry((java.util.Map.Entry<?,?>) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_MotifModel(org.modelrefactoring.guery.MotifModel motifModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_Motif(org.modelrefactoring.guery.Motif motif, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_Role(org.modelrefactoring.guery.Role role, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_Constraint(org.modelrefactoring.guery.Constraint constraint, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_VertexSelection(org.modelrefactoring.guery.VertexSelection vertexSelection, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_ConnectedBy(org.modelrefactoring.guery.ConnectedBy connectedBy, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_Connection(org.modelrefactoring.guery.Connection connection, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_NotConnectedBy(org.modelrefactoring.guery.NotConnectedBy notConnectedBy, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_Grouping(org.modelrefactoring.guery.Grouping grouping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_PreProcessor(org.modelrefactoring.guery.PreProcessor preProcessor, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_EdgeSelection(org.modelrefactoring.guery.EdgeSelection edgeSelection, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_modelrefactoring_guery_Constrainable(org.modelrefactoring.guery.Constrainable constrainable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_java_util_Map_Entry(java.util.Map.Entry<?,?> stringToEObjectMap, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.modelrefactoring.guery.resource.guery.IGueryInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.modelrefactoring.guery.resource.guery.IGueryInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.modelrefactoring.guery.resource.guery.IGueryInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
