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
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FILTER;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.ObjectReference;
import org.emftext.language.refactoring.refactoring_specification.PATH;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.TRACE;
import org.emftext.language.refactoring.refactoring_specification.UPTREE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
//public class ObjectAssignmentInterpreter extends AbstractValueProviderInstantiator<List<EObject>, EObject>{
public class ObjectAssignmentInterpreter{

	private RoleMapping mapping;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;

	private Role assignedRole;
	private Object roleRuntimeValue;

	private IRefactoringStatus status;

	private IRefactoringInterpreter interpreter;

	private ObjectAssignmentCommand command;
	private EClass classForValueProvider;

	public ObjectAssignmentInterpreter(IRefactoringInterpreter interpreter, RoleMapping mapping) {
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
			if(value != null){
				context.addEObjectForVariable(objectVar, value);
			}
			if(roleRuntimeValue == null){
				roleRuntimeValue = value;
			}
		} else if(object instanceof TRACE){
			handleTrace((TRACE) object, objectVar);
		} else if(object instanceof CollaborationReference){
			value = handleCollaboration((CollaborationReference) object, objectVar);
			roleRuntimeValue = value;
		}
		if(status == null){
			status = new RefactoringStatus(IRefactoringStatus.OK);
		}
		return status;
	}

	private EObject handleCollaboration(CollaborationReference object,	Variable objectVar) {
		// TODO split method
		MultiplicityCollaboration collaboration = object.getCollaboration();
		EObject interpretationContext = collaboration.getInterpretationContext();
		Object targetObject = null;
		ObjectAssignmentCommand connectedCommand = null;
		if(interpretationContext instanceof Variable){
			Variable variable = (Variable) interpretationContext;
			targetObject = context.getObjectForVariable(variable);
			VariableDeclarationCommand declarationCommand = variable.getContainerCommand();
			if(declarationCommand instanceof VariableAssignment){
				connectedCommand = ((VariableAssignment) declarationCommand).getAssignment();
			}
		} else if(interpretationContext instanceof Role) {
			Role referencedRole = (Role) interpretationContext;
			Role targetRole = collaboration.getTarget();
			assignedRole = targetRole;
			ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(referencedRole);
			CollaborationMapping collaborationMapping = concreteMapping.getCollaborationMappingForCollaboration(collaboration);
			List<ReferenceMetaClassPair> pairs = collaborationMapping.getReferenceMetaClassPair();
			if(referencedRole.getModifier().contains(RoleModifier.INPUT)){
				List<EObject> objects = RoleUtil.filterObjectsByRoles(selection, mapping, referencedRole);
				if(objects.size() == 1){
					List<EObject> resolvedObjects = getEObjectWithRoleFromPath(targetRole, objects.get(0), pairs);
					if(resolvedObjects.size() == 1){
						return resolvedObjects.get(0);
					}
					@SuppressWarnings("unchecked")
					IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderFactory().getValueProviderForCommand(command, assignedRole);
//					IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderForCommand(command);
//					if(valueProvider == null){
//						classForValueProvider = mapping.getEClassForRole(assignedRole);
//						valueProvider = getNewValueProvider(mapping);
//						interpreter.registerValueProviderForCommand(command, valueProvider);
//					}
					EObject value = valueProvider.provideValue(interpreter, resolvedObjects);
					context.addEObjectForVariable(objectVar, value);
					if(valueProvider.getReturnCode() == Dialog.CANCEL){
						status = new RefactoringStatus(IRefactoringStatus.CANCEL);
					}
					return value;
				} else {
					throw new UnsupportedOperationException("implement this case and iterate over list");
				}
			} else {
				throw new UnsupportedOperationException("implement this case");
			}
		}
		if(targetObject instanceof EObject){
			EObject root = (EObject) targetObject;
			Role sourceRole = collaboration.getSource();
			Role targetRole = collaboration.getTarget();
			assignedRole = targetRole;
			ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(sourceRole);
			CollaborationMapping collaborationMapping = concreteMapping.getCollaborationMappingForCollaboration(collaboration);
			List<ReferenceMetaClassPair> pairs = collaborationMapping.getReferenceMetaClassPair();
			List<EObject> resolvedObjects = getEObjectWithRoleFromPath(targetRole, root, pairs);
			if(resolvedObjects.size() == 1){
				return resolvedObjects.get(0);
			}
			@SuppressWarnings("unchecked")
			IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderFactory().getValueProviderForCommand(command, assignedRole);
			if(connectedCommand != null){
				interpreter.getValueProviderFactory().registerValueProviderForCommand(connectedCommand, valueProvider);
			}
//			IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderForCommand(command);
//			if(valueProvider == null){
//				EClass clazz = mapping.getEClassForRole(assignedRole);
//				valueProvider = new DialogOneListElementProvider("Select one " + clazz.getName(), mapping);
//				interpreter.registerValueProviderForCommand(command, valueProvider);
//				if(connectedCommand != null){
//					interpreter.registerValueProviderForCommand(connectedCommand, valueProvider);
//				}
//			}
			EObject value = valueProvider.provideValue(interpreter, resolvedObjects);
			context.addEObjectForVariable(objectVar, value);
			if(valueProvider.getReturnCode() == Dialog.CANCEL){
				status = new RefactoringStatus(IRefactoringStatus.CANCEL);
			}
			return value;
		} else {
			throw new UnsupportedOperationException("implement this case");
		}
	}

	//	private List<EObject> resolveCollaboration(EObject root, List<ReferenceMetaClassPair> pairs, Role filter) {
	//		if (pairs == null) {
	//			return null;
	//		} else {
	//			if (pairs.size() == 1) {
	//				List<EObject> containments = new LinkedList<EObject>();
	//				Object children = root.eGet(pairs.get(0).getReference(), true);
	//				if (children instanceof EObject) {
	//					containments.add((EObject) children);
	//				} else if (children instanceof List<?>) {
	//					containments.addAll((List<EObject>) children);
	//				}
	//				return RoleUtil.filterObjectsByRoles(containments, mapping, filter);
	//			} else {
	//				List<ReferenceMetaClassPair> reducedPairs = new LinkedList<ReferenceMetaClassPair>();
	//				for (int i = 1; i < pairs.size(); i++) {
	//					reducedPairs.add(pairs.get(i));
	//				}
	//				ReferenceMetaClassPair pair = pairs.get(0);
	//				Object newRoot = root.eGet(pair.getReference());
	//				if (newRoot instanceof EObject) {
	//					return resolveCollaboration((EObject) newRoot, reducedPairs, filter);
	//				} else if (newRoot instanceof List<?>) {
	//					List<EObject> newRoots = (List<EObject>) newRoot;
	//					List<EObject> objectCollection = new LinkedList<EObject>();
	//					for (EObject eObject : newRoots) {
	//						objectCollection.addAll(resolveCollaboration(eObject, reducedPairs, filter));
	//					}
	//					return objectCollection;
	////					throw new UnsupportedOperationException(
	////							"implement this case - but this shouldn't happen because here only one EObject should be returned");
	//				}
	//			}
	//		}
	//		return null;
	//	}

	private void handleFILTER(RoleReference object, Variable objectVar) {
		Role role = object.getRole();
		assignedRole = role;
		FromClause from = object.getFrom();
		ObjectReference reference = from.getReference();
		List<? extends EObject> elements = getObjectReferenceObject(reference);
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

	private void handleTrace(TRACE trace, Variable objectVar){
		assignedRole = trace.getRole();
		ObjectReference from = trace.getReference();
		List<? extends EObject> objects = getObjectReferenceObject(from);
		List<EObject> containers = new LinkedList<EObject>();
		for (EObject object : objects) {
			if(!containers.contains(object.eContainer())){
				containers.add(object.eContainer());
			}
		}
		roleRuntimeValue = containers;
		context.addEObjectsForVariable(objectVar, containers);


		//		EObject first = objects.get(0);
		//		EObject container = first.eContainer();
		//		roleRuntimeValue = container;
		//		TraceObject traceObject = RefactoringSpecificationFactory.eINSTANCE.createTraceObject();
		//		traceObject.setAppliedRole(assignedRole);
		//		traceObject.setContainer(container);
		//		return traceObject;
	}

	private EObject handleRoleReference(RoleReference roleRef) {
		assignedRole = roleRef.getRole();
		FromClause from = roleRef.getFrom();
		FromOperator operator = from.getOperator();
		List<? extends EObject> fromObjects = getObjectReferenceObject(from.getReference());
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
		CollaborationMapping collaborationMapping = concreteMapping.getCollaborationMappingForTargetRole(assignedRole);
		List<ReferenceMetaClassPair> pairs = collaborationMapping.getReferenceMetaClassPair();
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
		IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderFactory().getValueProviderForCommand(command, assignedRole);
		//		IValueProvider<List<EObject>, EObject> valueProvider = (IValueProvider<List<EObject>, EObject>) interpreter.getValueProviderForCommand(command);
		//		if(valueProvider == null){
		//			classForValueProvider = mapping.getEClassForRole(assignedRole);
		//			valueProvider = getNewValueProvider(mapping);
		//			interpreter.registerValueProviderForCommand(command, valueProvider);
		//		}
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

	@SuppressWarnings("unchecked")
	private List<? extends EObject> getObjectReferenceObject(ObjectReference reference){
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
			Object object = context.getObjectForVariable(variable);
			if(object instanceof EObject){
				temp.add((EObject) object);
			} else if(object instanceof List<?>) {
				temp.addAll((List<EObject>) object);
			}
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
//
//	@Override
//	public IValueProvider<List<EObject>, EObject> getDefaultValueProvider(RoleMapping roleMapping) {
//		return new DialogOneListElementProvider("Select one " + classForValueProvider.getName(), roleMapping);
//	}
}