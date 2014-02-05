/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class OperatorsParseResult implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsParseResult {
	
	private EObject root;
	
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap locationMap;
	
	private Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>> commands = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>>();
	
	public OperatorsParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
