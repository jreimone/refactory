/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.PATH;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.TRACE;
import org.emftext.language.refactoring.refactoring_specification.TraceObject;
import org.emftext.language.refactoring.refactoring_specification.UPTREE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider;
import org.emftext.refactoring.specification.interpreter.ui.DialogOneListElementProvider;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class ObjectAssignmentInterpreter {

	private Mapping mapping;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;

	private Role assignedRole;
	private Object roleRuntimeValue;

	public ObjectAssignmentInterpreter(Mapping mapping) {
		super();
		this.mapping = mapping;
	}

	public Boolean interpreteObjectAssignmentCommand(ObjectAssignmentCommand object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.selection = selection;
		this.context = context;

		Variable objectVar = object.getDeclaration().getVariable();
		EObject value = null;

		if(object instanceof RoleReference){
			value = handleRoleReference((RoleReference) object);
		}

		if(object instanceof TRACE){
			value = handleTrace((TRACE) object);
		}

		if(value != null){
			context.addEObjectForVariable(objectVar, value);
		}
		if(roleRuntimeValue == null){
			roleRuntimeValue = value;
		}

		return true;
	}

	private EObject handleTrace(TRACE trace){
		assignedRole = trace.getRole();
		FromReference from = trace.getReference();
		List<? extends EObject> objects = getFromReferenceObject(from);
		EObject first = objects.get(0);
		EObject container = first.eContainer();
		roleRuntimeValue = container;
		//		EReference reference = first.eContainmentFeature();
		//		ReferenceMetaClassPair pair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
		//		pair.setReference(reference);
		TraceObject traceObject = RefactoringSpecificationFactory.eINSTANCE.createTraceObject();
		traceObject.setAppliedRole(assignedRole);
		traceObject.setContainer(container);
		//		traceObject.setReferenceMetaClassPair(pair);
		return traceObject;
	}

	private EObject handleRoleReference(RoleReference roleRef) {
		assignedRole = roleRef.getRole();
		FromClause from = roleRef.getFrom();
		FromOperator operator = from.getOperator();
		List<? extends EObject> fromObjects = getFromReferenceObject(from.getReference());
		if(operator instanceof UPTREE){
			return handleFromOperatorUPTREE(assignedRole, fromObjects);	
		} else if(operator instanceof PATH){
			return handleFromOperatorPATH(assignedRole, fromObjects);
		}
		//		if(operator == null){
		//			return getFromReferenceObject(from.getReference());
		//		}
		return null;
	}

	private EObject handleFromOperatorPATH(Role assignedRole, List<? extends EObject> fromObjects) {
		EObject sourceObject = fromObjects.get(0);
		Role sourceRole = context.getRoleForEObject(sourceObject);
		if(sourceRole == null){
			return null;
		}
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(sourceRole);
		RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(assignedRole);
		List<ReferenceMetaClassPair> pairs = relationMapping.getReferenceMetaClassPair();
		List<EObject> values = getEObjectWithRoleFromPath(assignedRole, sourceObject, pairs);
		if(values == null  || values.size() == 0){
			return null;
		}
		if(values.size() == 1){
			return values.get(0);
		}
		IStructuralFeatureValueProvider valueProvider = new DialogOneListElementProvider(sourceObject, mapping);
		EObject value = valueProvider.provideValue(values);
		return value;
	}

	@SuppressWarnings("unchecked")
	private List<EObject> getEObjectWithRoleFromPath(Role role, EObject parent, List<ReferenceMetaClassPair> pairs){
		if(pairs.size() == 1){
			Object value = parent.eGet(pairs.get(0).getReference());
			if(value instanceof EObject){
				List<Role> mappedRoles = mapping.getMappedRolesForEObject((EObject) value);
				if(mappedRoles.contains(role)){
					return Arrays.asList(new EObject[]{(EObject) value});
				}
			}
			if(value instanceof List<?>){
				List<EObject> values = (List<EObject>) value;
				List<EObject> valuesWithRole = new LinkedList<EObject>();
				for (EObject object : values) {
					List<Role> mappedRoles = mapping.getMappedRolesForEObject(object);
					if(mappedRoles.contains(role)){
						valuesWithRole.add(object);
					}
				}
				return valuesWithRole;
			}
		} else if(pairs.size() > 1){
			List<ReferenceMetaClassPair> tempPairs =  new LinkedList<ReferenceMetaClassPair>();
			for (ReferenceMetaClassPair pair : pairs) {
				tempPairs.add(pair);
			}
			ReferenceMetaClassPair pair = tempPairs.get(0);
			tempPairs.remove(pair);
			Object ob = parent.eGet(pair.getReference());
			if(ob instanceof EObject){
				EObject stepParent = (EObject) ob;
				return getEObjectWithRoleFromPath(role, stepParent, tempPairs);
			}
			if(ob instanceof List<?>){
				List<EObject> values = (List<EObject>)ob;
				if(values.size() == 1){
					return getEObjectWithRoleFromPath(role, values.get(0), tempPairs);
				} else {
					throw new UnsupportedOperationException("This case must be implemented!");
				}
			}
			throw new UnsupportedOperationException("This case must be implemented!");
		}
		return null;
	}

	private List<? extends EObject> getFromReferenceObject(FromReference reference){
		if(reference instanceof ConstantsReference){
			Constants constant = ((ConstantsReference) reference).getReferencedConstant();
			switch (constant) {
			case INPUT:
				return selection;
			default:
				break;
			}
		}
		if(reference instanceof VariableReference){
			Variable variable = ((VariableReference) reference).getVariable();
			List<EObject> temp = new ArrayList<EObject>();
			temp.add(context.getEObjectForVariable(variable));
			return temp;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private EObject handleFromOperatorUPTREE(Role fromRole, List<? extends EObject> fromObjects) {
		List<?>[] rootPaths = new List<?>[fromObjects.size()];
		int i = 0;
		for (EObject eObject : fromObjects) {
			List<EObject> rootPath = ModelUtil.getPathToRoot(eObject);
			rootPaths[i] = rootPath;
			i++;
		}
		// build up uptree
		return RoleUtil.getFirstCommonObjectWithRoleFromPaths(fromRole, mapping, (List<? extends EObject>[]) rootPaths);
	}

	/**
	 * @return the assignedRole
	 */
	public Role getAssignedRole() {
		return assignedRole;
	}

	/**
	 * @return the roleRuntimeValue
	 */
	public Object getRoleRuntimeValue() {
		return roleRuntimeValue;
	}
}