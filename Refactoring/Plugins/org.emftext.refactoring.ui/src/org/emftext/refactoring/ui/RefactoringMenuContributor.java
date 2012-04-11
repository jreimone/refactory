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
package org.emftext.refactoring.ui;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRefactoringSubMenuRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.refactoring.util.StringUtil;

public class RefactoringMenuContributor extends ExtensionContributionFactory {

	private static final String CONTEXT_MENU_ENTRY_TEXT = "Refactor";

	public RefactoringMenuContributor() {
		super();
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (!(activePart instanceof ISaveablePart)) {
//			System.out.println("not saveable");
			return;
		}
		IWorkbenchPartSite partSite = activePart.getSite();
		//		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ISelectionProvider selectionProvider = partSite.getSelectionProvider();
		if (selectionProvider == null) {
//			System.out.println("no selection provider");
			return;
		}
		ISelection selection = selectionProvider.getSelection();
		List<EObject> selectedElements = new LinkedList<EObject>();
		if (selection instanceof StructuredSelection) {
			List<?> temp = ((StructuredSelection) selection).toList();
			for (Object object : temp) {
				if (!(object instanceof EObject)) {
					selectedElements = null;
					break;
				}
				selectedElements.add((EObject) object);
			}
		}
		EditingDomain transactionalEditingDomain = null;
		IEditorPart activeEditor = null;
		IEditorConnector editorConnector = null;
		if (selectedElements == null || selectedElements.size() == 0) {
			activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			editorConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
			if(editorConnector != null){
				selectedElements = editorConnector.handleSelection(selection);
				if (selectedElements != null && selectedElements.size() >= 1) {
					transactionalEditingDomain = editorConnector.getTransactionalEditingDomain();
				}
			}
		}
		if (selectedElements != null && selectedElements.size() >= 1) {
			EObject model = null;
			Resource resource = null;
			int i = 0;
			do {
				EObject element = selectedElements.get(i);
				model = EcoreUtil.getRootContainer(element, true);
				resource = model.eResource();
				i++;
			} while (i < selectedElements.size() && resource == null);
			if (resource == null) {
//				System.out.println("resource null");
				return;
			}
//			System.out.println("~~~~~~~");
//			System.out.println(resource);
////			EObject model = resource.getContents().get(0);
//			System.out.println(model);
//			TreeIterator<EObject> iterator = model.eAllContents();
//			while (iterator.hasNext()) {
//				EObject object = (EObject) iterator.next();
//				System.out.println(object);
//			}
//			System.out.println("~~~~~~~");
			//Resolve the entire resource set, not just the resource itself. It might be the case that there are
			//multiple models with cross references that have not been resolved up to this point. If one of the elements
			//is changed during the refactoring, resolving the proxy to this element in another model does not recognize
			//the changed element and creates a new one instead. This effectively creates an imperfect copy as the resolved
			//element represents the state before the refactoring, whereas the refactored element represents the changed state.
			//This leads to inconsistencies of the models and is to be avoided at all cost.
			ResourceSet resourceSet = resource.getResourceSet();
			EcoreUtil.resolveAll(resourceSet);
			IMenuManager rootMenu = new MenuManager(CONTEXT_MENU_ENTRY_TEXT, IRefactoringSubMenuRegistry.CONTEXT_MENU_ENTRY_ID);

			Map<String, RoleMapping> roleMappings = getRoleMappingsForResource(resource);
			List<RoleMapping> mappings = RoleUtil.getPossibleMappingsForInputSelection(selectedElements, roleMappings, 1.0);
			boolean containsEntries = false;
			List<IMenuManager> registeredSubMenus = new LinkedList<IMenuManager>();
			for (RoleMapping mapping : mappings) {
				Resource mappingResource = mapping.eResource();
				if (mappingResource != null && (mappingResource.getErrors() == null || mappingResource.getErrors().size() == 0)) {
					IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, mapping);
					if (refactorer != null) {
						refactorer.setInput(selectedElements);
						RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(mapping.getMappedRoleModel());
						if (refSpec != null) {
							String refactoringName = StringUtil.convertCamelCaseToWords(mapping.getName());
							Action refactoringAction = null;
							if (transactionalEditingDomain == null) {
								refactoringAction = new RefactoringAction(refactorer, editorConnector);
							} else {
								refactoringAction = new RefactoringAction(refactorer, transactionalEditingDomain, activeEditor, editorConnector);
							}
							refactoringAction.setText(refactoringName);
							refactoringAction.setImageDescriptor(IRoleMappingRegistry.INSTANCE.getImageForMapping(mapping));
							IRefactoringSubMenuRegistry subMenuRegistry = IRefactoringSubMenuRegistry.INSTANCE;
							IMenuManager subMenu = subMenuRegistry.getSubMenuForRoleMapping(mapping);
							if(subMenu == null){
								rootMenu.add(refactoringAction);
							} else {
								List<IMenuManager> subMenuPath = subMenuRegistry.getSubMenuPathForRoleMapping(mapping);
								IMenuManager parent = rootMenu;
								for (IMenuManager singleSubMenu : subMenuPath) {
									if(!registeredSubMenus.contains(singleSubMenu)){
										parent.add(singleSubMenu);
										registeredSubMenus.add(singleSubMenu);
									}
									parent = singleSubMenu;
								}
								parent.add(refactoringAction);
							}
							containsEntries = true;
						}

					} else {
						RegistryUtil.log("no rolemappings registered for " + resource.getContents().get(0).eClass().getEPackage().getNsURI(), IStatus.WARNING);
					}
				}
				
			} 
			if (containsEntries) {
				additions.addContributionItem(rootMenu, null);
			}
		}
	}

	private Map<String, RoleMapping> getRoleMappingsForResource(Resource resource){
		EObject root = resource.getContents().get(0);
		String mmUri = root.eClass().getEPackage().getNsURI();
		Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(mmUri);
		return roleMappings;
	}
}
