/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.TRACE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;
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
	private Map<Variable, List<EObject>> varInstancesMap;
	private Map<IndexVariable, Integer> varIndexMap;
	private Mapping mapping;

	public RefactoringInterpreterContext(){
		varInstanceMap = new LinkedHashMap<Variable, EObject>();
		varIndexMap = new LinkedHashMap<IndexVariable, Integer>();
		varInstancesMap = new LinkedHashMap<Variable, List<EObject>>();
	}

	protected void setInitialContext(Mapping mapping){
		this.mapping = mapping;
	}

	public Role getRoleForEObject(EObject object){
		Collection<EObject> values = varInstanceMap.values();
		for (EObject value : values) {
			if(value.equals(object)){
				Set<Variable> variables = varInstanceMap.keySet();
				for (Variable variable : variables) {
					if(varInstanceMap.get(variable).equals(value)){
						VariableDeclarationCommand command = variable.getContainerCommand();
						if(command instanceof CREATE){
							return ((CREATE) command).getSourceRole();
						}
						if(command instanceof VariableAssignment){
							ObjectAssignmentCommand objectAssignment = ((VariableAssignment) command).getAssignment();
							if(objectAssignment instanceof TRACE){
								return ((TRACE) objectAssignment).getRole();
							}
							if(objectAssignment instanceof RoleReference){
								return ((RoleReference) objectAssignment).getRole();
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Stores the given <code>objects</code> for the <code>variable</code> in the context.
	 * 
	 * @param variable
	 * @param objects
	 */
	public void addEObjectsForVariable(Variable variable, List<EObject> objects){
		if(objects.size() == 1){
			addEObjectForVariable(variable, objects.get(0));
		} else {
			varInstancesMap.put(variable, objects);
		}
	}
	
	public List<EObject> getEObjectsForVariable(Variable var){
		return varInstancesMap.get(var);
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
	
	/**
	 * Returns whether an {@link EObject} which was registered with the given <code>var</code> or 
	 * a list of {@link EObject}s if several elements where registered with <code>var</code>.
	 * 
	 * @param var
	 * @return
	 */
	public Object getObjectForVariable(Variable var){
		EObject single = getEObjectForVariable(var);
		if(single != null){
			return single;
		}
		return getEObjectsForVariable(var);
	}
}
