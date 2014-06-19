/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.tests.properties.Category;
import org.emftext.refactoring.tests.properties.EObjectReferenceValue;
import org.emftext.refactoring.tests.properties.Key;
import org.emftext.refactoring.tests.properties.KeyValuePair;
import org.emftext.refactoring.tests.properties.PropertyModel;
import org.emftext.refactoring.tests.properties.StringValue;
import org.emftext.refactoring.tests.properties.Value;

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
public class AbstractTestpropertiesInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInterpreterListener> listeners = new ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInterpreterListener>();
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
		if (object instanceof org.emftext.refactoring.tests.properties.PropertyModel) {
			result = interprete_org_emftext_refactoring_tests_properties_PropertyModel((org.emftext.refactoring.tests.properties.PropertyModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.refactoring.tests.properties.Category) {
			result = interprete_org_emftext_refactoring_tests_properties_Category((org.emftext.refactoring.tests.properties.Category) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.refactoring.tests.properties.Value) {
			result = interprete_org_emftext_refactoring_tests_properties_Value((org.emftext.refactoring.tests.properties.Value) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.refactoring.tests.properties.KeyValuePair) {
			result = interprete_org_emftext_refactoring_tests_properties_KeyValuePair((org.emftext.refactoring.tests.properties.KeyValuePair) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.refactoring.tests.properties.Key) {
			result = interprete_org_emftext_refactoring_tests_properties_Key((org.emftext.refactoring.tests.properties.Key) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.refactoring.tests.properties.EObjectReferenceValue) {
			result = interprete_org_emftext_refactoring_tests_properties_EObjectReferenceValue((org.emftext.refactoring.tests.properties.EObjectReferenceValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.refactoring.tests.properties.StringValue) {
			result = interprete_org_emftext_refactoring_tests_properties_StringValue((org.emftext.refactoring.tests.properties.StringValue) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_PropertyModel(PropertyModel propertyModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_Category(Category category, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_Value(Value value, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_KeyValuePair(KeyValuePair keyValuePair, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_Key(Key key, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_EObjectReferenceValue(EObjectReferenceValue eObjectReferenceValue, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_StringValue(StringValue stringValue, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInterpreterListener listener : listeners) {
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
	
	public void addListener(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesInterpreterListener listener) {
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
