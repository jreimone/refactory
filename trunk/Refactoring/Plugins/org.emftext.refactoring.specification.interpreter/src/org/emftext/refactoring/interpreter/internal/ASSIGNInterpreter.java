/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.specification.interpreter.ui.DialogValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class ASSIGNInterpreter {
	
	// the following two variables will only be used when test plugin specifies a value provider
	private static Class<IAttributeValueProvider> valueProviderClass;
	private boolean providerExternallySet = false;
	private IAttributeValueProvider valueProvider;
	
	private Mapping mapping;
	private RefactoringInterpreterContext context;
	
	public ASSIGNInterpreter(Mapping mapping) {
		this.mapping = mapping;
		this.valueProvider = new DialogValueProvider(mapping);
	}

	public Boolean interpreteASSIGN(ASSIGN object, RefactoringInterpreterContext context) {
		this.context = context;
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
		EObject targetInterpretationContext = target.getInterpretationContext();
		EObject targetObject = null;
		if(targetInterpretationContext instanceof Variable){
			targetObject = context.getEObjectForVariable((Variable) targetInterpretationContext);
		}
		EAttribute targetClassAttribute = targetMapping.getClassAttribute();
		if(targetClassAttribute.getEAttributeType().equals(sourceClassAttribute.getEAttributeType())){
			targetObject.eSet(targetClassAttribute, value);
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
	
	private boolean handleTargetOnly(RoleAttribute target){
		EObject interpretationContext = target.getInterpretationContext();
		Role targetRole = target.getAttributeRole();
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
		EcoreUtil.resolveAll(concreteMapping);
		AttributeMapping attMapping = concreteMapping.getAttributeMappingForAttribute(target);
		EAttribute classAttribute = attMapping.getClassAttribute();
		EObject targetObject = null;
		if(interpretationContext instanceof Variable){
			targetObject = context.getEObjectForVariable((Variable) interpretationContext);
			Object value = getValueProvider().provideAttributeValue(classAttribute);
			targetObject.eSet(classAttribute, value);
			return true;
		}
		return false;
	}
	
	/**
	 * Can only be invoked from the test plugin to activate an external value provider while testing
	 * to not open dialogs when asking for values.
	 * 
	 * @param valueProvider
	 */
	public static void setValueProvider(Class<IAttributeValueProvider> valueProvider){
		valueProviderClass = valueProvider;
	}
	
	private IAttributeValueProvider getValueProvider(){
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
}
