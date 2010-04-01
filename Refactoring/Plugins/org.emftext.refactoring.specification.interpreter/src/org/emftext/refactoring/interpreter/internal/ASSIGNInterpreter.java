/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
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

	private List<Resource> resourcesToSave;

	public ASSIGNInterpreter(Mapping mapping) {
		this.mapping = mapping;
		this.valueProvider = new DialogAttributeValueProvider(mapping);
	}

	public Boolean interpreteASSIGN(ASSIGN object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
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

	private boolean handleSourceAndTarget(RoleAttribute source, RoleAttribute target){
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
			resourcesToSave = getReferer(targetObject);
			targetObject.eSet(targetClassAttribute, value);
			return true;
		}
		return false;
	}

	private boolean handleTargetOnly(RoleAttribute target){
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
		resourcesToSave = getReferer(targetObject);
		targetObject.eSet(classAttribute, value);
		return true;
	}

	private List<Resource> getReferer(EObject referenceTarget){
		List<Resource> referers = IndexConnectorRegistry.INSTANCE.getReferencingResources(referenceTarget);
		if(referers == null || referers.size() == 0){
			return null;
		}
		return referers;
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

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}
}
