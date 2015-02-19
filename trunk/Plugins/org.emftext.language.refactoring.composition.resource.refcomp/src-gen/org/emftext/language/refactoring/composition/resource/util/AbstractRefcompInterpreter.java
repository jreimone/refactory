/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.Commentable;
import org.emftext.language.refactoring.roles.Multiplicity;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.NamedElement;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleFeature;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleProhibition;

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
public class AbstractRefcompInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.emftext.language.refactoring.composition.resource.IRefcompInterpreterListener> listeners = new ArrayList<org.emftext.language.refactoring.composition.resource.IRefcompInterpreterListener>();
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
		if (object instanceof org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping) {
			result = interprete_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping((org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping) {
			result = interprete_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping((org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) {
			result = interprete_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding((org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EAttribute) {
			result = interprete_org_eclipse_emf_ecore_EAttribute((org.eclipse.emf.ecore.EAttribute) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EAnnotation) {
			result = interprete_org_eclipse_emf_ecore_EAnnotation((org.eclipse.emf.ecore.EAnnotation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EClass) {
			result = interprete_org_eclipse_emf_ecore_EClass((org.eclipse.emf.ecore.EClass) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EEnum) {
			result = interprete_org_eclipse_emf_ecore_EEnum((org.eclipse.emf.ecore.EEnum) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EDataType) {
			result = interprete_org_eclipse_emf_ecore_EDataType((org.eclipse.emf.ecore.EDataType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EClassifier) {
			result = interprete_org_eclipse_emf_ecore_EClassifier((org.eclipse.emf.ecore.EClassifier) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EEnumLiteral) {
			result = interprete_org_eclipse_emf_ecore_EEnumLiteral((org.eclipse.emf.ecore.EEnumLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EFactory) {
			result = interprete_org_eclipse_emf_ecore_EFactory((org.eclipse.emf.ecore.EFactory) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EOperation) {
			result = interprete_org_eclipse_emf_ecore_EOperation((org.eclipse.emf.ecore.EOperation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EPackage) {
			result = interprete_org_eclipse_emf_ecore_EPackage((org.eclipse.emf.ecore.EPackage) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EParameter) {
			result = interprete_org_eclipse_emf_ecore_EParameter((org.eclipse.emf.ecore.EParameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EReference) {
			result = interprete_org_eclipse_emf_ecore_EReference((org.eclipse.emf.ecore.EReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EStructuralFeature) {
			result = interprete_org_eclipse_emf_ecore_EStructuralFeature((org.eclipse.emf.ecore.EStructuralFeature) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.ETypedElement) {
			result = interprete_org_eclipse_emf_ecore_ETypedElement((org.eclipse.emf.ecore.ETypedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.ENamedElement) {
			result = interprete_org_eclipse_emf_ecore_ENamedElement((org.eclipse.emf.ecore.ENamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EModelElement) {
			result = interprete_org_eclipse_emf_ecore_EModelElement((org.eclipse.emf.ecore.EModelElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			result = interprete_org_eclipse_emf_ecore_EObject((org.eclipse.emf.ecore.EObject) object, context);
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
		if (object instanceof org.eclipse.emf.ecore.EGenericType) {
			result = interprete_org_eclipse_emf_ecore_EGenericType((org.eclipse.emf.ecore.EGenericType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.ETypeParameter) {
			result = interprete_org_eclipse_emf_ecore_ETypeParameter((org.eclipse.emf.ecore.ETypeParameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.NamedElement) {
			result = interprete_org_emftext_language_refactoring_roles_NamedElement((org.emftext.language.refactoring.roles.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.Collaboration) {
			result = interprete_org_emftext_language_refactoring_roles_Collaboration((org.emftext.language.refactoring.roles.Collaboration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.Role) {
			result = interprete_org_emftext_language_refactoring_roles_Role((org.emftext.language.refactoring.roles.Role) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleModel) {
			result = interprete_org_emftext_language_refactoring_roles_RoleModel((org.emftext.language.refactoring.roles.RoleModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.Multiplicity) {
			result = interprete_org_emftext_language_refactoring_roles_Multiplicity((org.emftext.language.refactoring.roles.Multiplicity) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.MultiplicityCollaboration) {
			result = interprete_org_emftext_language_refactoring_roles_MultiplicityCollaboration((org.emftext.language.refactoring.roles.MultiplicityCollaboration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleProhibition) {
			result = interprete_org_emftext_language_refactoring_roles_RoleProhibition((org.emftext.language.refactoring.roles.RoleProhibition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleAssociation) {
			result = interprete_org_emftext_language_refactoring_roles_RoleAssociation((org.emftext.language.refactoring.roles.RoleAssociation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleComposition) {
			result = interprete_org_emftext_language_refactoring_roles_RoleComposition((org.emftext.language.refactoring.roles.RoleComposition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleImplication) {
			result = interprete_org_emftext_language_refactoring_roles_RoleImplication((org.emftext.language.refactoring.roles.RoleImplication) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleAttribute) {
			result = interprete_org_emftext_language_refactoring_roles_RoleAttribute((org.emftext.language.refactoring.roles.RoleAttribute) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.RoleFeature) {
			result = interprete_org_emftext_language_refactoring_roles_RoleFeature((org.emftext.language.refactoring.roles.RoleFeature) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.roles.Commentable) {
			result = interprete_org_emftext_language_refactoring_roles_Commentable((org.emftext.language.refactoring.roles.Commentable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.rolemapping.RoleMappingModel) {
			result = interprete_org_emftext_language_refactoring_rolemapping_RoleMappingModel((org.emftext.language.refactoring.rolemapping.RoleMappingModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.rolemapping.RoleMapping) {
			result = interprete_org_emftext_language_refactoring_rolemapping_RoleMapping((org.emftext.language.refactoring.rolemapping.RoleMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.rolemapping.ConcreteMapping) {
			result = interprete_org_emftext_language_refactoring_rolemapping_ConcreteMapping((org.emftext.language.refactoring.rolemapping.ConcreteMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.rolemapping.CollaborationMapping) {
			result = interprete_org_emftext_language_refactoring_rolemapping_CollaborationMapping((org.emftext.language.refactoring.rolemapping.CollaborationMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.rolemapping.AttributeMapping) {
			result = interprete_org_emftext_language_refactoring_rolemapping_AttributeMapping((org.emftext.language.refactoring.rolemapping.AttributeMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair) {
			result = interprete_org_emftext_language_refactoring_rolemapping_ReferenceMetaClassPair((org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping(CompositeRoleMapping compositeRoleMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping(BoundRoleMapping boundRoleMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding(SourceTargetBinding sourceTargetBinding, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EAttribute(EAttribute eAttribute, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EAnnotation(EAnnotation eAnnotation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EClass(EClass eClass, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EClassifier(EClassifier eClassifier, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EDataType(EDataType eDataType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EEnum(EEnum eEnum, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EEnumLiteral(EEnumLiteral eEnumLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EFactory(EFactory eFactory, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EModelElement(EModelElement eModelElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_ENamedElement(ENamedElement eNamedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EObject(EObject eObject, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EOperation(EOperation eOperation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EPackage(EPackage ePackage, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EParameter(EParameter eParameter, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EReference(EReference eReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EStructuralFeature(EStructuralFeature eStructuralFeature, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_ETypedElement(ETypedElement eTypedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_java_util_Map_Entry(Entry<?,?> eStringToStringMapEntry, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EGenericType(EGenericType eGenericType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_ETypeParameter(ETypeParameter eTypeParameter, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_NamedElement(NamedElement namedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_Collaboration(Collaboration collaboration, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_Role(Role role, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleModel(RoleModel roleModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_Multiplicity(Multiplicity multiplicity, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_MultiplicityCollaboration(MultiplicityCollaboration multiplicityCollaboration, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleProhibition(RoleProhibition roleProhibition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleAssociation(RoleAssociation roleAssociation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleComposition(RoleComposition roleComposition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleImplication(RoleImplication roleImplication, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleAttribute(RoleAttribute roleAttribute, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_RoleFeature(RoleFeature roleFeature, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_roles_Commentable(Commentable commentable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_rolemapping_RoleMappingModel(RoleMappingModel roleMappingModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_rolemapping_RoleMapping(RoleMapping roleMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_rolemapping_ConcreteMapping(ConcreteMapping concreteMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_rolemapping_CollaborationMapping(CollaborationMapping collaborationMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_rolemapping_AttributeMapping(AttributeMapping attributeMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_rolemapping_ReferenceMetaClassPair(ReferenceMetaClassPair referenceMetaClassPair, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.emftext.language.refactoring.composition.resource.IRefcompInterpreterListener listener : listeners) {
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
	
	public void addListener(org.emftext.language.refactoring.composition.resource.IRefcompInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.refactoring.composition.resource.IRefcompInterpreterListener listener) {
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
