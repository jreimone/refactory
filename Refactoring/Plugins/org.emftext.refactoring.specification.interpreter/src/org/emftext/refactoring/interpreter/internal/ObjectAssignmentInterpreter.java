/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FILTER;
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
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.RefactoringStatus;
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

	private IRefactoringStatus status;
	
	private IRefactoringInterpreter interpreter;
	
	private ObjectAssignmentCommand command;

	public ObjectAssignmentInterpreter(IRefactoringInterpreter interpreter, Mapping mapping) {
		super();
		this.mapping = mapping;
		this.interpreter = interpreter;
	}

	public IRefactoringStatus interpreteObjectAssignmentCommand(ObjectAssignmentCommand object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.selection = selection;
		this.context = context;
		this.command = object;

		Variable objectVar = object.getDeclaration().getVariable();
		EObject value = null;

		if(object instanceof RoleReference){
			FromOperator op = ((RoleReference) object).getFrom().getOperator();
			if(op instanceof FILTER){
				handleFILTER((RoleReference) object, objectVar);
			} else {
				value = handleRoleReference((RoleReference) object);
			}
		} else if(object instanceof TRACE){
			value = handleTrace((TRACE) object);
		}
		if(value != null){
			context.addEObjectForVariable(objectVar, value);
		}
		if(roleRuntimeValue == null){
			roleRuntimeValue = value;
		}
		if(status == null){
			status = new RefactoringStatus(IRefactoringStatus.OK);
		}
		return status;
	}

	private void handleFILTER(RoleReference object, Variable objectVar) {
		Role role = object.getRole();
		assignedRole = role;
		FromClause from = object.getFrom();
		FromReference reference = from.getReference();
		List<? extends EObject> elements = getFromReferenceObject(reference);
		List<EObject> filteredElements = new LinkedList<EObject>();
		for (EObject element : elements) {
			List<Role> mappedRoles = mapping.getMappedRolesForEObject(element);
			if(mappedRoles.contains(role)){
				filteredElements.add(element);
			}
		}
		if(filteredElements.size() == 1){
			context.addEObjectForVariable(objectVar, filteredElements.get(0));
			roleRuntimeValue = filteredElements.get(0);
		} else {
			context.addEObjectsForVariable(objectVar, filteredElements);
			roleRuntimeValue = filteredElements;
		}
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
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
			EClass clazz = mapping.getEClassForRole(assignedRole);
			String message = "From " + labelProvider.getText(sourceObject) + " no elements of type " + labelProvider.getText(clazz) + " are reachable or existent.";
			status = new RefactoringStatus(IRefactoringStatus.INFO, message);
			return null;
		}
		if(values.size() == 1){
			return values.get(0);
		}
		@SuppressWarnings("unchecked")
		IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderForCommand(command);
		if(valueProvider == null){
			valueProvider = new DialogOneListElementProvider(mapping);
			interpreter.registerValueProviderForCommand(command, valueProvider);
		}
		EObject value = valueProvider.provideValue(interpreter, values);
		if(valueProvider.getReturnCode() == Dialog.CANCEL){
			status = new RefactoringStatus(IRefactoringStatus.CANCEL);
		}
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
		EObject uptreeObject = RoleUtil.getFirstCommonObjectWithRoleFromPaths(fromRole, mapping, (List<? extends EObject>[]) rootPaths);
		if(uptreeObject == null){
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
			EClass clazz = mapping.getEClassForRole(fromRole);
			String message = "The following model elements aren't contained within the same " + labelProvider.getText(clazz) + ":\n";
			for (EObject eObject : fromObjects) {
				message += "\n" + labelProvider.getText(eObject);
			}
			status = new RefactoringStatus(mapping, IRefactoringStatus.INFO, message);
		}
		return uptreeObject;
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