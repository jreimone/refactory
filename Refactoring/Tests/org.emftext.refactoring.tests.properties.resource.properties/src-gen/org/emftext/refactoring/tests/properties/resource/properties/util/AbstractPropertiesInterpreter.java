/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.util;

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
public class AbstractPropertiesInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		while (!interpretationStack.empty()) {
			org.eclipse.emf.ecore.EObject next = interpretationStack.pop();
			result = interprete(next, context);
			if (!continueInterpretation(result)) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.refactoring.tests.properties.StringValue) {
			result = interprete_org_emftext_refactoring_tests_properties_StringValue((org.emftext.refactoring.tests.properties.StringValue) object, context);
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
		if (object instanceof org.emftext.refactoring.tests.properties.Key) {
			result = interprete_org_emftext_refactoring_tests_properties_Key((org.emftext.refactoring.tests.properties.Key) object, context);
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
		if (object instanceof org.emftext.refactoring.tests.properties.Value) {
			result = interprete_org_emftext_refactoring_tests_properties_Value((org.emftext.refactoring.tests.properties.Value) object, context);
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
		if (object instanceof org.emftext.refactoring.tests.properties.PropertyModel) {
			result = interprete_org_emftext_refactoring_tests_properties_PropertyModel((org.emftext.refactoring.tests.properties.PropertyModel) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_PropertyModel(org.emftext.refactoring.tests.properties.PropertyModel object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_Category(org.emftext.refactoring.tests.properties.Category object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_Value(org.emftext.refactoring.tests.properties.Value object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_KeyValuePair(org.emftext.refactoring.tests.properties.KeyValuePair object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_Key(org.emftext.refactoring.tests.properties.Key object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_EObjectReferenceValue(org.emftext.refactoring.tests.properties.EObjectReferenceValue object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_refactoring_tests_properties_StringValue(org.emftext.refactoring.tests.properties.StringValue object, ContextType context) {
		return null;
	}
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}
