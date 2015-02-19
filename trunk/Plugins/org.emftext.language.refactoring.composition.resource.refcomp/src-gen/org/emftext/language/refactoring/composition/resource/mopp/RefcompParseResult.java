/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class RefcompParseResult implements org.emftext.language.refactoring.composition.resource.IRefcompParseResult {
	
	private EObject root;
	
	private org.emftext.language.refactoring.composition.resource.IRefcompLocationMap locationMap;
	
	private Collection<org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>> commands = new ArrayList<org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>>();
	
	public RefcompParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.emftext.language.refactoring.composition.resource.IRefcompLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompCommand<org.emftext.language.refactoring.composition.resource.IRefcompTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
