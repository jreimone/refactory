/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class CoedParseResult implements org.modelrefactoring.evolution.coed.resource.coed.ICoedParseResult {
	
	private EObject root;
	
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap locationMap;
	
	private Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>> commands = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>>();
	
	public CoedParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.modelrefactoring.evolution.coed.resource.coed.ICoedLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedCommand<org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
