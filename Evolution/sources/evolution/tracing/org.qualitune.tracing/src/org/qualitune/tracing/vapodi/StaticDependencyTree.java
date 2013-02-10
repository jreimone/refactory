/**
 * 
 */
package org.qualitune.tracing.vapodi;

import java.util.LinkedList;
import java.util.List;

import org.qualitune.tracing.umt.Variable;

/**
 * A tree made from nodes which each represent dependencies of the form
 * dependency: conditions -> results
 * where each condition/result is a UMT variable
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class StaticDependencyTree {
	protected List<Variable> conditions;
	protected List<Variable> results;
	
	protected List<StaticDependencyTree> children;
	
	/**
	 * 
	 */
	public StaticDependencyTree() {
		conditions = new LinkedList<Variable>();
		results = new LinkedList<Variable>();
		children = new LinkedList<StaticDependencyTree>();
	}
	
	public void addCondition(Variable newCondition) {
		conditions.add(newCondition);
	}
	
	public void addAllCondtions(List<Variable> newConditions) {
		conditions.addAll(newConditions);
	}
	
	public void addResult(Variable newResult) {
		results.add(newResult);
	}
	
	public void addAllResults(List<Variable> newResults) {
		results.addAll(newResults);
	}
	
	public void addChildren(StaticDependencyTree newChild) {
		children.add(newChild);
	}
	
	List<Variable> getConditions() {
		return conditions;
	}
	
	List <Variable> getResults() {
		return results;
	}
	
	/**
	 * @return a string representation of the dependency relations represented by this instance 
	 */
	public String toString() {
		String ret = new String();
		
		for (Variable condition : conditions)
			ret += (condition.getName() + " "); 
		
		ret += "=> ";
		
		for (Variable result : results)
			ret += (result.getName() + " ");
		
		ret += ("(" + children.size() + " unshown children)");
		return ret;
	}
}
