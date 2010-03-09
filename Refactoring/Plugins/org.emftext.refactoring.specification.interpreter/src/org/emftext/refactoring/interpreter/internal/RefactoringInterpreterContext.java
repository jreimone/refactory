/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.util.RoleUtil;

/**
 * The context for the RefactoringInterpreter
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterContext {

	private EList<Variable> variables;
	private EObject model;
	private List<? extends EObject> selection;
	private Map<Variable, EObject> varInstanceMap;
	private RoleMappingModel roleMapping;
	private Mapping mapping;
	
	public RefactoringInterpreterContext(){
		varInstanceMap = new HashMap<Variable, EObject>();
	}
	
	protected void setInitialContext(EObject model, List<? extends EObject> selection, RoleMappingModel roleMapping, Mapping mapping){
		this.model = model;
		this.selection = selection;
		this.roleMapping = roleMapping;
		this.mapping = mapping;
	}
	
//	/**
//	 * Initializes the variables in the context as they are declared in the given RefactoringSpecification. 
//	 * @param refSpec
//	 */
//	public void initialize(){
//		varInstanceMap = new HashMap<Variable, EObject>();
//		variables = refSpec.getDeclaredVariables();
//		for (Variable variable : variables) {
//			addEObjectForVariable(variable);
//		}
//	}

	/**
	 * Creates a new instance for the {@link EClass} for which the given variable is considered. 
	 * 
	 * @param variable
	 */
	public void addEObjectForVariable(Variable variable) {
		CREATE create = variable.getCreateCommand();
		Role varRole = create.getSourceRoleReference().getRole();
		EClass metaClass = mapping.getEClassForRole(varRole);
		EObject instance = EcoreUtil.create(metaClass);
		handleObligatoryFeatures(instance);
		varInstanceMap.put(variable, instance);
	}
	
	private void handleObligatoryFeatures(EObject element){
		EClass metaclass = element.eClass();
		EList<EAttribute> attributes = metaclass.getEAllAttributes();
		for (EAttribute attribute : attributes) {
			int min = attribute.getLowerBound();
			int max = attribute.getUpperBound();
			if(min == max && min == 1){
				EDataType type = attribute.getEAttributeType();
				if(type.getInstanceClass().equals(String.class)){
					element.eSet(attribute, "new" + metaclass.getName());
				}
			}
		}
	}
	
	/**
	 * Returns the concrete instance for the given variable.
	 * 
	 * @param variable
	 * @return
	 */
	public EObject getEObjectForVariable(Variable variable){
		return varInstanceMap.get(variable);
	}
}
