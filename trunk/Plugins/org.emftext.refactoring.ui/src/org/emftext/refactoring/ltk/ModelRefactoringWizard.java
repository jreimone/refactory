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
package org.emftext.refactoring.ltk;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.registry.rolemapping.ICustomWizardPageRegistry;

/**
 * @author Jan Reimann
 * 
 */
public class ModelRefactoringWizard extends RefactoringWizard {

	private ModelRefactoring refactoring;

	/**
	 * @param refactoring
	 * @param flags
	 */
	public ModelRefactoringWizard(ModelRefactoring refactoring) {
		super(refactoring, refactoring.getFlags());
		this.refactoring = refactoring;
	}

	@Override
	protected void addUserInputPages() {

		IRefactoringInterpreter interpreter = refactoring.getInterpreter();
		List<IValueProvider<?, ?>> valueProviders = interpreter.getValueProviderFactory().getValuesToProvide();
		List<IAttributeValueProvider> simpleProviders = new LinkedList<IAttributeValueProvider>();
		
		
		List<UserInputWizardPage> pages = new LinkedList<UserInputWizardPage>();
		for (IValueProvider<?, ?> valueProvider : valueProviders) {
			if (valueProvider instanceof IAttributeValueProvider) {
				simpleProviders.add((IAttributeValueProvider) valueProvider);
			} else {
				pages.add(new ComplexUserInputWizardPage(valueProvider));
			}
		}
		if (simpleProviders.size() > 0) {
			pages.add(0, new AttributeUserInputWizardPage(simpleProviders));
		}
		for (UserInputWizardPage userInputWizardPage : pages) {
			this.addPage(userInputWizardPage);
		}
		
		//TODO: cseidl Retrieve the appropriate value for the roleRuntimeInstanceMap and use it instead of null.
		Map<Role, List<EObject>> roleRuntimeInstanceMap = refactoring.getInterpreter().getFakeInterpreter().getRoleRuntimeInstances();
		addCustomWizardPages(roleRuntimeInstanceMap);
	}

	//Collect custom wizard pages assigned via extension point and add them to this wizard.
	private void addCustomWizardPages(Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		RoleMapping mapping = refactoring.getRefactorer().getRoleMapping();
		
		//Get _fresh_ wizard page here because the UI elements of old instances have been disposed.
//		List<IModelRefactoringWizardPage> customPages = ICustomWizardPageRegistry.INSTANCE.getFreshCustomWizardPages(mapping, roleRuntimeInstanceMap);
		List<IModelRefactoringWizardPage> customPages = ICustomWizardPageRegistry.INSTANCE.getCustomWizardPages(mapping, roleRuntimeInstanceMap);

		for (IModelRefactoringWizardPage page : customPages) {
			ModelRefactoringWizardPage concretePage = (ModelRefactoringWizardPage) page;
			addPage(concretePage);
		}
		
	}
}
