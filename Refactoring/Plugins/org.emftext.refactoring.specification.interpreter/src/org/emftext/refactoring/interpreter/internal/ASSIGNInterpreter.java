/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.AdditionalCommand;
import org.emftext.language.refactoring.refactoring_specification.UPDATE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.indexconnector.IndexConnectorRegistry;
import org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider;
import org.emftext.refactoring.specification.interpreter.ui.DialogAttributeValueProvider;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * @author Jan Reimann
 *
 */
public class ASSIGNInterpreter {
	
	// the following two variables will only be used when test plugin specifies a value provider
	private static Class<IStructuralFeatureValueProvider> valueProviderClass;
	private boolean providerExternallySet = false;
	private IStructuralFeatureValueProvider valueProvider;
	
	private Mapping mapping;
	private RefactoringInterpreterContext context;
	private List<? extends EObject> selection;
	
	private Role assignedRole;
	private Object roleRuntimeValue;
	
	public ASSIGNInterpreter(Mapping mapping) {
		this.mapping = mapping;
		this.valueProvider = new DialogAttributeValueProvider(mapping);
	}

	public Boolean interpreteASSIGN(ASSIGN object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.context = context;
		this.selection = selection;
		RoleAttribute source = object.getSourceAttribute();
		RoleAttribute target = object.getTargetAttribute();
		AdditionalCommand addition = object.getAdditionalCommand();
		if(source != null){
			return handleSourceAndTarget(source, target, addition);
		} else {
			return handleTargetOnly(target, addition);
		}
	}
	
	private boolean handleSourceAndTarget(RoleAttribute source, RoleAttribute target, AdditionalCommand addition){
		Role sourceRole = source.getAttributeRole();
		AttributeMapping sourceMapping = mapping.getConcreteMappingForRole(sourceRole).getAttributeMappingForAttribute(source);
		if(sourceMapping == null){
			return false;
		}
		EObject sourceInterpretationContext = source.getInterpretationContext();
		EObject sourceObject = null;
		if(sourceInterpretationContext instanceof Variable){
			sourceObject = context.getEObjectForVariable((Variable) sourceInterpretationContext);
		}
		EAttribute sourceClassAttribute = sourceMapping.getClassAttribute();
		Object value = null;
		if(sourceObject != null){
			value = sourceObject.eGet(sourceClassAttribute, true);
		}
		
		Role targetRole = target.getAttributeRole();
		AttributeMapping targetMapping = mapping.getConcreteMappingForRole(targetRole).getAttributeMappingForAttribute(target);
		if(targetMapping == null){
			return false;
		}
		EObject targetInterpretationContext = target.getInterpretationContext();
		EObject targetObject = null;
		if(targetInterpretationContext instanceof Variable){
			targetObject = context.getEObjectForVariable((Variable) targetInterpretationContext);
		}
		EAttribute targetClassAttribute = targetMapping.getClassAttribute();
		if(targetClassAttribute.getEAttributeType().equals(sourceClassAttribute.getEAttributeType())){
			List<Resource> referer = getReferer(targetObject);
			targetObject.eSet(targetClassAttribute, value);
			handleAdditional(referer, addition, targetObject, targetClassAttribute, value);
			return true;
		}
		return false;
	}
	
//	private boolean attributeIsBound(RoleAttribute attribute){
//		Role role = attribute.getAttributeRole();
//		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(role);
//		List<AttributeMapping> attMappings = concreteMapping.getAttributeMappings();
//		for (AttributeMapping attributeMapping : attMappings) {
//			if(attributeMapping.getRoleAttribute().equals(attribute)){
//				return true;
//			}
//		}
//		return false;
//	}
	
	private boolean handleTargetOnly(RoleAttribute target, AdditionalCommand addition){
		EObject interpretationContext = target.getInterpretationContext();
		Role targetRole = target.getAttributeRole();
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
		EcoreUtil.resolveAll(concreteMapping);
		AttributeMapping attMapping = concreteMapping.getAttributeMappingForAttribute(target);
		if(attMapping == null){
			return false;
		}
		EAttribute classAttribute = attMapping.getClassAttribute();
		EObject targetObject = null;
		if(interpretationContext instanceof Variable){
			targetObject = context.getEObjectForVariable((Variable) interpretationContext);
		} else if(interpretationContext instanceof Role) {
			if(((Role) interpretationContext).getModifier().contains(RoleModifier.INPUT)){
				if(selection.size() == 1){
					targetObject = selection.get(0);
					assignedRole = (Role) interpretationContext;
					roleRuntimeValue = targetObject;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		Object value = getValueProvider().provideValue(classAttribute);
		List<Resource> referer = getReferer(targetObject);
		targetObject.eSet(classAttribute, value);
		handleAdditional(referer, addition, targetObject, classAttribute, value);
		return true;
	}
	
	private List<Resource> getReferer(EObject referenceTarget){
		List<Resource> referers = IndexConnectorRegistry.INSTANCE.getReferencingResources(referenceTarget);
		if(referers == null || referers.size() == 0){
			return null;
		}
		List<Resource> realReferers = new LinkedList<Resource>();
		for (Resource resource : referers) {
			ResourceSet refactoredModelResourceSet = referenceTarget.eResource().getResourceSet();
			refactoredModelResourceSet.getResources().add(resource);
		}
		for (Resource resource : referers) {
			Collection<Setting> references = EcoreUtil.UsageCrossReferencer.find(referenceTarget, resource);
			if(references.size() > 0){
				realReferers.add(resource);
			}
		}
		return realReferers;
	}
	
	private void handleAdditional(List<Resource> referers, AdditionalCommand addition, EObject owner, EStructuralFeature feature, Object value){
		if(addition instanceof UPDATE){
			if(referers == null){
				return;
			}
			for (Resource resource : referers) {
				Collection<Setting> references = EcoreUtil.UsageCrossReferencer.find(owner, resource);
				try {
					resource.save(Collections.EMPTY_MAP);
					System.out.println("Updated inverse reference resource " + resource);
				} catch (IOException e) {
					RegistryUtil.log("Failed saving inverse referenced resource " + resource, IStatus.ERROR, e);
//					e.printStackTrace();
				}
//				for (Setting setting : references) {
//					EObject referer = setting.getEObject();
//					EStructuralFeature referingFeature = setting.getEStructuralFeature();
//					Object oldValue = referer.eGet(referingFeature);
//					System.out.println("Do the update of resource " + referer.eResource() + " here");
//				}
			}
		}
	}
	
	/**
	 * Can only be invoked from the test plugin to activate an external value provider while testing
	 * to not open dialogs when asking for values.
	 * 
	 * @param valueProvider
	 */
	public static void setValueProvider(Class<IStructuralFeatureValueProvider> valueProvider){
		valueProviderClass = valueProvider;
	}
	
	private IStructuralFeatureValueProvider getValueProvider(){
		if(valueProviderClass != null){
			if(!providerExternallySet){
				try {
					valueProvider = valueProviderClass.newInstance();
					providerExternallySet = true;
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return valueProvider;
	}

	public Role getAssignedRole() {
		return assignedRole;
	}

	public Object getRoleRuntimeValue() {
		return roleRuntimeValue;
	}
}
