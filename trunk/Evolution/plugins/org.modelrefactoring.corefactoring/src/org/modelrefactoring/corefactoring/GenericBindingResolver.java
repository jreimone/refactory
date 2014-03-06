package org.modelrefactoring.corefactoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.util.RoleUtil;
import org.mvel2.integration.PropertyHandler;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolver;

public class GenericBindingResolver extends MapVariableResolver implements PropertyHandler {

	private static final long serialVersionUID = -2295234042921075945L;
	
	private Stack<EObject> roleChain = new Stack<EObject>();
	
	private String variableNameToResolve;
	private IRefactorer initialRefactorer;
	private IRefactorer dependentRefactorer;
	private CoRefactoringValueProvider genericValueProvider;
	
	private Map<String, Object> inVariables = new HashMap<String, Object>();
	private Map<String, Object> outVariables = new HashMap<String, Object>();
	private Map<String, Object> undecidedVariables = new HashMap<String, Object>();
	private boolean isINcontext;
	private boolean isOUTcontext;
	private boolean isUndefined;

	public GenericBindingResolver(IRefactorer initialRefactorer, IRefactorer dependentRefactorer, CoRefactoringValueProvider genericValueProvider) {
		super(Util.getInRoleNameBindings(initialRefactorer), "Foo");
		this.initialRefactorer = initialRefactorer;
		this.dependentRefactorer = dependentRefactorer;
		this.genericValueProvider = genericValueProvider;
		inVariables.putAll(Util.getInRoleNameBindings(initialRefactorer));
		outVariables.putAll(Util.getOutRoleNameBindings(dependentRefactorer));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setStaticType(Class knownType) {
		super.setStaticType(knownType);
	}

	@Override
	public void setVariableMap(Map<String, Object> variableMap) {
		super.setVariableMap(variableMap);
	}

	@Override
	public String getName() {
		return variableNameToResolve;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getType() {
		return Object.class;
	}

	@Override
	public Object getValue() {
		String name = getName();
		Object value;
		EObject roleElement = null;
		if(!isUndefined){
			if(isINcontext){
				roleElement = RoleUtil.getFirstObjectForRole(name, EObject.class, initialRefactorer.getInterpreter().getRoleRuntimeInstances());
				value = inVariables.get(name);
			} else {
				value = outVariables.get(name);
			}
		} else {
			value = undecidedVariables.get(name);
		}
		if(roleElement != null){
			roleChain.push(roleElement);
		}
		return value != null ? value : super.getValue();
	}

	private void setINcontext(boolean INcontext){
		if(isINcontext != INcontext){
			roleChain.clear();
		}
		isINcontext = INcontext;
		isOUTcontext = !INcontext;
		isUndefined = false;
	}
	
	@Override
	public void setValue(Object arg0) {
		super.setValue(arg0);
	}

	@Override
	public Object getProperty(String propertyName, Object object, VariableResolverFactory resolverFactory) {
		if(isINcontext && !isUndefined){
			return returnPropertyValue(inVariables, propertyName);
		}
		if(isOUTcontext && !isUndefined){
			return returnPropertyValue(outVariables, propertyName);
		}
		return returnPropertyValue(undecidedVariables, propertyName);
	}

	protected Object returnPropertyValue(Map<String, Object> variables, String propertyName) {
		Object propertyValue = variables.get(propertyName);
		if(propertyValue != null){
			Object specializedValue = specializeValue(propertyValue);
			if(specializedValue instanceof EObject){
				RoleMapping roleMapping = null;
				if(isINcontext && !isUndefined){
					roleMapping = initialRefactorer.getRoleMapping();
				} else if(isOUTcontext && !isUndefined) {
					roleMapping = dependentRefactorer.getRoleMapping();
				}
				Role role = RoleUtil.getRoleByName(roleMapping, propertyName);
				roleChain.push(role);
			}
			return specializedValue;
		} else {
			EObject head = roleChain.peek();
			if(head instanceof Role){
				Role role = (Role) head;
				RoleAttribute attribute = RoleUtil.getAttributeByName(role, propertyName);
				if(!isUndefined){
					RoleMapping roleMapping = null;
					EObject element = null;
					Object object = null;
					if(isINcontext){
						roleMapping = initialRefactorer.getRoleMapping();
						object = inVariables.get(role.getName());
					} else if(isOUTcontext){
						roleMapping = dependentRefactorer.getRoleMapping();
						object = outVariables.get(role.getName());
					}
					ConcreteMapping concreteMapping = roleMapping.getConcreteMappingForRole(role);
					AttributeMapping attributeMapping = concreteMapping.getAttributeMappingForAttribute(attribute);
					EAttribute classAttribute = attributeMapping.getClassAttribute();
					roleChain.push(attributeMapping.getRoleAttribute());
					object = specializeValue(object);
					if(object instanceof EObject){
						element = (EObject) object;
					}
					if(element != null){
						Object value = element.eGet(classAttribute);
						value = specializeValue(value);
						return value;
					}
				}
			}
		}
		return null;
	}

	private Object specializeValue(Object propertyValue) {
		if(propertyValue instanceof List){
			@SuppressWarnings("rawtypes")
			List list = (List) propertyValue;
			if(list.size() == 1){
				return list.get(0);
			} else if(list.size() > 1){
				throw new RuntimeException("list size is greater than 1 - handle this case");
			}
		}
		return propertyValue;
	}

	@Override
	public Object setProperty(String propertyName, Object object, VariableResolverFactory resolverFactory, Object arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setVariableNameToResolve(String name) {
		variableNameToResolve = name;
		setName(name);
		if(name.equals(Util.IN)){
			setINcontext(true);
		} else if(name.equals(Util.OUT)){
			setINcontext(false);
		}
	}

	private void addVariable(String varName, Object value, boolean INcontext) {
		if(INcontext){
			inVariables.put(varName, value);
			setINcontext(true);
		} else {
			outVariables.put(varName, value);
			setINcontext(false);
		}
		setVariableNameToResolve(varName);
	}
	
	public void addVariable(String varName, Object value) {
		if(!isUndefined){
			addVariable(varName, value, isINcontext);
		} else {
			undecidedVariables.put(varName, value);
			isUndefined = true;
		}
		setVariableNameToResolve(varName);
	}

	public boolean isResolvable(String varName) {
		return inVariables.containsKey(varName) || outVariables.containsKey(varName) || undecidedVariables.containsKey(varName);
	}
}
