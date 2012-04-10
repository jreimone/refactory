/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.indexconnector.IndexConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.RefactoringStatus;

/**
 * @author Jan Reimann
 *
 */
//public class ASSIGNInterpreter extends AbstractValueProviderInstantiator<EAttribute, Object>{
public class ASSIGNInterpreter {

	private RoleMapping mapping;
	private RefactoringInterpreterContext context;
	private List<? extends EObject> selection;

	private Role assignedRole;
	private Object roleRuntimeValue;

	private List<Resource> resourcesToSave;

	private AdapterFactoryLabelProvider labelProvider;

	private IRefactoringInterpreter interpreter;

	private ASSIGN assign;

	public ASSIGNInterpreter(RoleMapping mapping, IRefactoringInterpreter interpreter) {
		this.mapping = mapping;
		this.interpreter = interpreter;
	}

	public IRefactoringStatus interpreteASSIGN(ASSIGN object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.assign = object;
		this.context = context;
		this.selection = selection;
		RoleAttribute source = object.getSourceAttribute();
		RoleAttribute target = object.getTargetAttribute();
		if(source != null){
			return handleSourceAndTarget(source, target);
		} else {
			return handleTargetOnly(target);
		}
	}

	private IRefactoringStatus handleSourceAndTarget(RoleAttribute source, RoleAttribute target){
		Role sourceRole = source.getAttributeRole();
		AttributeMapping sourceMapping = mapping.getConcreteMappingForRole(sourceRole).getAttributeMappingForAttribute(source);
		if(sourceMapping == null){
			EClass clazz = mapping.getEClassForRole(sourceRole);
			String message = "For model element " + getLabelProvider().getText(clazz) + " no adequate attribute was mapped";
			return new RefactoringStatus(IRefactoringStatus.ERROR, message);
		}
		EObject sourceInterpretationContext = source.getInterpretationContext();
		EObject sourceObject = null;
		if(sourceInterpretationContext instanceof Variable){
			sourceObject = (EObject) context.getObjectForVariable((Variable) sourceInterpretationContext);
		}
		EAttribute sourceClassAttribute = sourceMapping.getClassAttribute();
		Object value = null;
		if(sourceObject != null){
			value = sourceObject.eGet(sourceClassAttribute, true);
		}

		Role targetRole = target.getAttributeRole();
		AttributeMapping targetMapping = mapping.getConcreteMappingForRole(targetRole).getAttributeMappingForAttribute(target);
		if(targetMapping == null){
			EClass clazz = mapping.getEClassForRole(targetRole);
			String message = "For model element " + getLabelProvider().getText(clazz) + " no adequate attribute was mapped";
			return new RefactoringStatus(IRefactoringStatus.ERROR, message);
		}
		EObject targetInterpretationContext = target.getInterpretationContext();
		EObject targetObject = null;
		if(targetInterpretationContext instanceof Variable){
			targetObject = (EObject) context.getObjectForVariable((Variable) targetInterpretationContext);
		}
		EAttribute targetClassAttribute = targetMapping.getClassAttribute();
		if(targetClassAttribute.getEAttributeType().equals(sourceClassAttribute.getEAttributeType())){
			resourcesToSave = getReferer(targetObject);
			targetObject.eSet(targetClassAttribute, value);
			return new RefactoringStatus(IRefactoringStatus.OK);
		}
		return new RefactoringStatus(IRefactoringStatus.ERROR, "Couldn't assign something");
	}

	private IRefactoringStatus handleTargetOnly(RoleAttribute target){
		//TODO "assignedRole" und "roleRuntimeValue" werden hier nur einmal gesetzt --> korrekt? werden null
		EObject interpretationContext = target.getInterpretationContext();
		Role targetRole = target.getAttributeRole();
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
		EcoreUtil.resolveAll(concreteMapping);
		AttributeMapping attMapping = concreteMapping.getAttributeMappingForAttribute(target);
		if(attMapping == null){
			EClass clazz = mapping.getEClassForRole(targetRole);
			String message = "For model element " + getLabelProvider().getText(clazz) + " no adequate attribute was mapped";
			return new RefactoringStatus(IRefactoringStatus.ERROR, message);
		}
		EAttribute classAttribute = attMapping.getClassAttribute();
		EObject targetObject = null;
		if(interpretationContext instanceof Variable){
			targetObject = (EObject) context.getObjectForVariable((Variable) interpretationContext);
		} else if(interpretationContext instanceof Role) {
			if(((Role) interpretationContext).getModifier().contains(RoleModifier.INPUT)){
				if(selection.size() == 1){
					targetObject = selection.get(0);
					assignedRole = (Role) interpretationContext;
					roleRuntimeValue = targetObject;
				} else {
					EClass clazz = mapping.getEClassForRole((Role) interpretationContext);
					String message = "The input of type " + getLabelProvider().getText(clazz) + " must only consist of one element";
					return new RefactoringStatus(IRefactoringStatus.ERROR, message);
				}
			} else {
				EClass clazz = mapping.getEClassForRole((Role) interpretationContext);
				String message = "Role " + getLabelProvider().getText(clazz) + " couldn't be bound";
				return new RefactoringStatus(IRefactoringStatus.ERROR, message);
			}
		}

		@SuppressWarnings("unchecked")
		IValueProvider<EAttribute, Object> valueProvider = (IValueProvider<EAttribute, Object>) interpreter.getValueProviderFactory().getValueProviderForCommand(assign);
//		IValueProvider<EAttribute, Object> valueProvider = (IValueProvider<EAttribute, Object>) interpreter.getValueProviderForCommand(assign);
//		if(valueProvider == null){
//			valueProvider = getNewValueProvider(mapping);
//			interpreter.registerValueProviderForCommand(assign, valueProvider);
//		}
		Object value = valueProvider.provideValue(interpreter, classAttribute, targetObject);
		if(valueProvider.getReturnCode() == Dialog.CANCEL){
			return new RefactoringStatus(IRefactoringStatus.CANCEL);
		}
		resourcesToSave = getReferer(targetObject);
		collectReferer(targetObject);
		targetObject.eSet(classAttribute, value);
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	/**
	 * This method is needed to collect all referers of an EObject. 
	 * Must be done because sometimes pure EMF doesn't recognize appropriate referers.
	 * Belongs to bug 1665:
	 * http://mantis-st.inf.tu-dresden.de/view.php?id=1665
	 * 
	 * It seems that the refer must be touched once to assure correct proxy resolving
	 * to the updated EObject.
	 * 
	 * @param targetObject
	 */
	private void collectReferer(EObject targetObject) {
		Resource targetResource = targetObject.eResource();
		if(targetResource == null) return;
		ResourceSet resourceSet = targetResource.getResourceSet();
		List<Adapter> adapters = resourceSet.eAdapters();
		ECrossReferenceAdapter crossReferencer = null;
		for (Adapter adapter : adapters) {
			if (adapter instanceof ECrossReferenceAdapter) {
				crossReferencer = (ECrossReferenceAdapter) adapter;
				break;
			}
		}
		if (crossReferencer == null) {
			crossReferencer = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(crossReferencer);
		}
		// just touch the references to assure correct proxy resolving 
		crossReferencer.getInverseReferences(targetObject, true);
	}

	private List<Resource> getReferer(EObject referenceTarget){
		if(!(interpreter instanceof IRefactoringFakeInterpreter)){
			List<Resource> referers = IndexConnectorRegistry.INSTANCE.getReferencingResources(referenceTarget);
			if(referers == null || referers.size() == 0){
				return null;
			}
			return referers;
		}
		return null;
	}

//	/**
//	 * Can only be invoked from the test plugin to activate an external value provider while testing
//	 * to not open dialogs when asking for values.
//	 * 
//	 * @param valueProvider
//	 */
//	@SuppressWarnings("unchecked")
//	public static void setValueProvider(Class<? extends IAttributeValueProvider> valueProvider){
//		externalValueProvider = (Class<IAttributeValueProvider>) valueProvider;
//	}

//	private IValueProvider<EAttribute, Object> getValueProvider(){
//		if(externalValueProvider != null){
//			//			if(!providerExternallySet){
//			try {
//				valueProvider = externalValueProvider.newInstance();
//				providerExternallySet = true;
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			//			}
//		} else {
//			valueProvider = new DialogAttributeValueProvider(mapping);
//		}
//		return valueProvider;
//	}

	public Role getAssignedRole() {
		return assignedRole;
	}

	public Object getRoleRuntimeValue() {
		return roleRuntimeValue;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}

	private AdapterFactoryLabelProvider getLabelProvider(){
		if(labelProvider == null){
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		}
		return labelProvider;
	}

//	@Override
//	public IValueProvider<EAttribute, Object> getDefaultValueProvider(RoleMapping roleMapping) {
//		return new DialogAttributeValueProvider(roleMapping);
//	}
}
