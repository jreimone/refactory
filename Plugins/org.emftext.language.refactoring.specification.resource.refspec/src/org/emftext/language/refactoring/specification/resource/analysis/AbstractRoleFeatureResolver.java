/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleFeature;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.util.RoleUtil;


/**
 * An abstract reference resolver because ASSIGNSourceAttributeResolver and ASSIGNTargetAttributeResolver need the same code.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractRoleFeatureResolver<ContainerType extends EObject, FeatureType extends RoleFeature>{

	public AbstractRoleFeatureResolver() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void resolve(java.lang.String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<FeatureType> result) {
		// TODO split method into smaller ones
		String[] roleFeature = identifier.split("\\.");
		if(roleFeature[0] == null){
			result.setErrorMessage("A role must be specified before the '.'");
		}
		if(roleFeature[1] == null){
			result.setErrorMessage("A feature must be specified with '.' notation after the role");
		}
		String roleString = roleFeature[0];
		String featureString = roleFeature[1];
		EObject parent = EcoreUtil.getRootContainer(container, true);
		if(!(parent instanceof RefactoringSpecification)){
			result.setErrorMessage("This is not a valid Refactoring Specification");
		}
		RefactoringSpecification refSpec = (RefactoringSpecification) parent;
		EList<Variable> variables = refSpec.getDeclaredVariables();
		EObject interpretationContext = null;
		Variable var = null;
		for (Variable variable : variables) {
			if(variable.getName().equals(roleString)){
				var = variable;
				interpretationContext = variable;
				break;
			}
		}
		Role matchedRole = null;
		if(var == null){
			RoleModel roleModel = refSpec.getUsedRoleModel();
			EList<Role> roles = roleModel.getRoles();
			for (Role role : roles) {
				if(role.getName().equals(roleString)){
					matchedRole = role;
					interpretationContext = role;
					break;
				}
			}
		} else {
			matchedRole = RoleUtil.getRoleFromVariable(var);
		}
		if(matchedRole == null){
			result.setErrorMessage("The name '" + roleString + "' doesn't match a role or variable");
			return;
		}
		EStructuralFeature structuralFeature = getStructuralFeature(matchedRole);
		Object featureList = matchedRole.eGet(structuralFeature, true);
		if(!(featureList instanceof EList<?>)){
			result.setErrorMessage("Invalid feature '" + structuralFeature.getName() + "'");
			return;
		}
		EList<RoleFeature> features = (EList<RoleFeature>) featureList;
		for (RoleFeature feature : features) {
			if(feature instanceof RoleAttribute){
				if(((RoleAttribute) feature).getName().equals(featureString)){
					((RoleAttribute) feature).setInterpretationContext(interpretationContext);
					result.addMapping(identifier, (FeatureType) feature);
					return;
				}
			}
			if(feature instanceof MultiplicityCollaboration){
				MultiplicityCollaboration multRelation = (MultiplicityCollaboration) feature;
				if(multRelation.getTargetName() != null && multRelation.getTargetName().equals(featureString)){
					((MultiplicityCollaboration) feature).setInterpretationContext(interpretationContext);
					result.addMapping(identifier, (FeatureType) feature);
					return;
				}
			}
		}
		String featureName = structuralFeature.getEType().getName();
		result.setErrorMessage("Role '" + roleString + "' has no " + featureName + " with name '" + featureString +"'");
	}

	//	protected abstract Class<? extends RoleFeature> getSpecificFeature();

	protected abstract EStructuralFeature getStructuralFeature(Role role);

}
