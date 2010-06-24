/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.specification.interpreter.ui.DialogAttributeValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class ASSIGNInterpreter {

	// the following two variables will only be used when test plugin specifies a value provider
	private static Class<IAttributeValueProvider> externalValueProvider;
	private boolean providerExternallySet = false;
	private IValueProvider<EAttribute, Object> valueProvider;

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
		this.valueProvider = new DialogAttributeValueProvider(mapping);
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
		IValueProvider<EAttribute, Object> valueProvider = (IValueProvider<EAttribute, Object>) interpreter.getValueProviderForCommand(assign);
		if(valueProvider == null){
			valueProvider = getValueProvider();
			interpreter.registerValueProviderForCommand(assign, valueProvider);
		}
		Object value = valueProvider.provideValue(interpreter, classAttribute, targetObject);
		if(getValueProvider().getReturnCode() == Dialog.CANCEL){
			return new RefactoringStatus(IRefactoringStatus.CANCEL);
		}
		resourcesToSave = getReferer(targetObject);
		targetObject.eSet(classAttribute, value);
		return new RefactoringStatus(IRefactoringStatus.OK);
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

	/**
	 * Can only be invoked from the test plugin to activate an external value provider while testing
	 * to not open dialogs when asking for values.
	 * 
	 * @param valueProvider
	 */
	@SuppressWarnings("unchecked")
	public static void setValueProvider(Class<? extends IAttributeValueProvider> valueProvider){
		externalValueProvider = (Class<IAttributeValueProvider>) valueProvider;
	}

	private IValueProvider<EAttribute, Object> getValueProvider(){
		if(externalValueProvider != null){
			//			if(!providerExternallySet){
			try {
				valueProvider = externalValueProvider.newInstance();
				providerExternallySet = true;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			//			}
		} else {
			valueProvider = new DialogAttributeValueProvider(mapping);
		}
		return valueProvider;
	}

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
}
