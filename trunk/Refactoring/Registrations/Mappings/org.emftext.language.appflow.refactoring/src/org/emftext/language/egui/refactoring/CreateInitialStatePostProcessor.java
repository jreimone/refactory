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
package org.emftext.language.egui.refactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.appflow.Application;
import org.emftext.language.appflow.actions.ActionsFactory;
import org.emftext.language.appflow.actions.ShowScreenAction;
import org.emftext.language.appflow.screenmodel.Screen;
import org.emftext.language.appflow.statemodel.State;
import org.emftext.language.appflow.statemodel.StateModel;
import org.emftext.language.appflow.statemodel.StatemodelFactory;
import org.emftext.language.appflow.statemodel.Transition;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

/**
 * @author Jan Reimann
 *
 */
public class CreateInitialStatePostProcessor extends AbstractRefactoringPostProcessor {

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		StateModel stateModel = (StateModel) getEObjectsForRole(
				roleRuntimeInstanceMap, "DerivationContainer").get(0);
		Transition transition = (Transition) getEObjectsForRole(
				roleRuntimeInstanceMap, "Derivation").get(0);
		createInitialState(stateModel, transition);
		return Status.OK_STATUS;
	}

	private void createInitialState(StateModel stateModel, Transition transition) {
		State initialState = StatemodelFactory.eINSTANCE.createState();
		initialState.setName("initialState");
		stateModel.getStates().add(initialState);
		Application app = (Application) stateModel.eContainer();
		EList<Screen> screens = app.getScreens();
		if (screens != null && screens.size() > 0) {
			ShowScreenAction action = ActionsFactory.eINSTANCE.createShowScreenAction();
			action.setScreen(screens.get(0));
			initialState.setAction(action);
		}
		transition.setSource(initialState);
	}

	private List<EObject> getEObjectsForRole(Map<Role, List<EObject>> roleRuntimeInstanceMap, String roleName) {
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			if (role.getName().equals(roleName)) {
				return roleRuntimeInstanceMap.get(role);
			}
		}
		return null;
	}
	
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {
		return process(roleRuntimeInstanceMap, resourceSet, change);
	}
}
