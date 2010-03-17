/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * The context for the RefactoringInterpreter
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterContext {

	private Map<Variable, EObject> varInstanceMap;
	private Map<IndexVariable, Integer> varIndexMap;
	private Mapping mapping;

	public RefactoringInterpreterContext(){
		varInstanceMap = new LinkedHashMap<Variable, EObject>();
		varIndexMap = new LinkedHashMap<IndexVariable, Integer>();
	}

	protected void setInitialContext(Mapping mapping){
		this.mapping = mapping;
	}

	/**
	 * Creates a new instance for the {@link EClass} for which the given variable is considered. 
	 * 
	 * @param variable
	 */
	public void addEObjectForVariable(Variable variable) {
//		CREATE create = variable.getCreateCommand();
		Role varRole = RoleUtil.getRoleFromVariable(variable);;
		EClass metaClass = mapping.getEClassForRole(varRole);
		EObject instance = ModelUtil.create(metaClass);
		varInstanceMap.put(variable, instance);
	}

	/** 
	 * Adds a concrete {@link EObject object} for the given variable. 
	 * 
	 * @param variable
	 * @param object
	 */
	public void addEObjectForVariable(Variable variable, EObject object){
		if(variable != null && object != null){
			varInstanceMap.put(variable, object);
		}
	}

	/**
	 * The given <code>index</code> will be saved for the give <code>variable</code>.
	 * 
	 * @param variable
	 * @param index
	 */
	public void setIndexForVariable(IndexVariable variable, int index){
		varIndexMap.put(variable, index);
	}

	/**
	 * Returns the index of the given <code>variable</code>.
	 * 
	 * @param variable
	 * @return
	 */
	public Integer getIndexForVariable(IndexVariable variable){
		if(variable == null){
			return null;
		}
		return varIndexMap.get(variable);
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
