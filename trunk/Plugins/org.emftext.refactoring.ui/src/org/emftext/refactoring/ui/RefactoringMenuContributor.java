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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.IParameterValues;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.ltk.ModelRefactoringDescriptor;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.ICustomWizardPageRegistry;
import org.emftext.refactoring.registry.rolemapping.IRefactoringSubMenuRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.refactoring.util.StringUtil;

public class RefactoringMenuContributor extends ExtensionContributionFactory {

	private static final String REFACTORY_COMMAND_CATEGORY 	= "org.modelrefactoring.commands.category";
	private static final String CONTEXT_MENU_ENTRY_TEXT 		= "Refactor";

	public RefactoringMenuContributor() {
		super();
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (!(activePart instanceof ISaveablePart)) {
			return;
		}
		IWorkbenchPartSite partSite = activePart.getSite();
		//		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ISelectionProvider selectionProvider = partSite.getSelectionProvider();
		if (selectionProvider == null) {
			return;
		}
		ISelection selection = selectionProvider.getSelection();
		List<EObject> selectedElements = new LinkedList<EObject>();
		if(selection == null){
			return;
		}
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
			if(activeEditor != null && activeEditor.equals(activePart)){
				editorConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
				if(editorConnector != null){
					selectedElements = editorConnector.handleSelection(selection);
					if (selectedElements != null && selectedElements.size() >= 1) {
						transactionalEditingDomain = editorConnector.getTransactionalEditingDomain();
					}
				}
			}
		}
		if (selectedElements != null && selectedElements.size() >= 1) {
			EObject model = null;
			Resource resource = determineResource(selectedElements);
			if(resource == null){
				return;
			}
			//Resolve the entire resource set, not just the resource itself. It might be the case that there are
			//multiple models with cross references that have not been resolved up to this point. If one of the elements
			//is changed during the refactoring, resolving the proxy to this element in another model does not recognize
			//the changed element and creates a new one instead. This effectively creates an imperfect copy as the resolved
			//element represents the state before the refactoring, whereas the refactored element represents the changed state.
			//This leads to inconsistencies of the models and is to be avoided at all cost.
			ResourceSet resourceSet = resource.getResourceSet();
			EcoreUtil.resolveAll(resourceSet);
			List<EObject> elementsInResource = getElementsByUris(resource, selectedElements);
			
			contributeToUI(serviceLocator, additions,
					transactionalEditingDomain, activeEditor, editorConnector,
					resource, elementsInResource);
		}
	}

	private void contributeToUI(IServiceLocator serviceLocator,IContributionRoot additions, EditingDomain transactionalEditingDomain, IEditorPart activeEditor, IEditorConnector editorConnector, Resource resource, List<EObject> elementsInResource) {
		IMenuManager rootMenu = new MenuManager(CONTEXT_MENU_ENTRY_TEXT, IRefactoringSubMenuRegistry.CONTEXT_MENU_ENTRY_ID);
		Map<String, RoleMapping> roleMappings = getRoleMappingsForResource(resource);
		List<RoleMapping> mappings = RoleUtil.getPossibleMappingsForInputSelection(elementsInResource, roleMappings, 1.0);
		boolean containsEntries = false;
		for (RoleMapping mapping : mappings) {
			Resource mappingResource = mapping.eResource();
			if (mappingResource != null && (mappingResource.getErrors() == null || mappingResource.getErrors().size() == 0)) {
				IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, mapping);
				ICustomWizardPageRegistry.INSTANCE.init(mapping);
				if (refactorer != null) {
					refactorer.setInput(elementsInResource);
					RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(mapping.getMappedRoleModel());
					if (refSpec != null) {
						createCommand(serviceLocator, mapping, refactorer, rootMenu, editorConnector, activeEditor, transactionalEditingDomain);
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

	private Resource determineResource(List<EObject> selectedElements) {
		Resource resource;
		int i = 0;
		do {
			EObject element = selectedElements.get(i);
			EObject parent;
			do {
				parent = element.eContainer();
				resource = element.eResource();
				if(resource == null){
					resource = parent.eResource();
				}
			} while (parent != null && resource == null);
			if(resource != null){
				System.out.println(resource.getURIFragment(element));
			}
			i++;
		} while (i < selectedElements.size() && resource == null);
		return resource;
//		IEditorInput editorInput = activeEditor.getEditorInput();
//		ResourceSet rs;
//		if(editorInput instanceof IFileEditorInput){
//			IFileEditorInput fei = (IFileEditorInput) editorInput;
//			IFile file = fei.getFile();
//			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
//			rs = new ResourceSetImpl();
//			resource = rs.getResource(uri, true);
//		}
		// return resource;
	}
	
	public static Command getCommandForRefactoring(IServiceLocator serviceLocator, RoleMapping mapping, final IRefactorer refactorer, IEditorConnector editorConnector, IEditorPart activeEditor, EditingDomain transactionalEditingDomain){
//		Command.DEBUG_COMMAND_EXECUTION = true;
//		Command.DEBUG_HANDLERS = true;
		ICommandService commandService = (ICommandService) serviceLocator.getService(ICommandService.class);
		Category category = commandService.getCategory(REFACTORY_COMMAND_CATEGORY);
		String commandID = ModelRefactoringDescriptor.generateRefactoringID(mapping) + ".command";
		Command command = commandService.getCommand(commandID);
		String refactoringName = StringUtil.convertCamelCaseToWords(mapping.getName());
		
		IHandler handler = new RefactoringCommandHandler();
		if(!command.isHandled()){
			command.setHandler(handler);
		}
		IParameter refactorerParam = createParameter(refactorer, commandID, "refactorer", "instance");
		IParameter editorConnectorParam = createParameter(editorConnector, commandID, "editorConnector", "instance");
		IParameter editingDomainParam = null;
		IParameter activeEditorParam = null;
		if(transactionalEditingDomain != null){
			editingDomainParam = createParameter(transactionalEditingDomain, commandID, "editingDomain", "instance");
			activeEditorParam = createParameter(activeEditor, commandID, "activeEditor", "instance");
		}
		IParameter[] parameters = null;
		if(editingDomainParam == null && activeEditorParam == null){
			parameters = new IParameter[]{refactorerParam, editorConnectorParam};
		} else {
			parameters = new IParameter[]{refactorerParam, editorConnectorParam, editingDomainParam, activeEditorParam};
		}
		command.define(refactoringName, "Refactoring '" + refactoringName + "' is executed", category, parameters);
		return command;
	}

	private static IParameter createParameter(final Object value, final String commandID, final String name, final String valueName) {
		return new IParameter() {
			@Override
			public boolean isOptional() {
				return false;
			}
			
			@Override
			public IParameterValues getValues() throws ParameterValuesException {
				return new IParameterValues() {
					@SuppressWarnings("rawtypes")
					@Override
					public Map getParameterValues() {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put(valueName, value);
						return map;
					}
				};
			}
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public String getId() {
				return commandID + name;
			}
		};
	}

	private void createCommand(IServiceLocator serviceLocator, RoleMapping mapping, IRefactorer refactorer, IMenuManager rootMenu, IEditorConnector editorConnector, IEditorPart activeEditor, EditingDomain transactionalEditingDomain) {
		Command command = getCommandForRefactoring(serviceLocator, mapping, refactorer, editorConnector, activeEditor, transactionalEditingDomain);
		String refactoringName = null;
		try {
			refactoringName = command.getName();
		} catch (NotDefinedException e) {
			e.printStackTrace();
		}
		String commandID = command.getId();
		
		CommandContributionItemParameter commandParameter = new CommandContributionItemParameter(serviceLocator, null, commandID, SWT.PUSH);
        commandParameter.label = refactoringName;
        commandParameter.icon = IRoleMappingRegistry.INSTANCE.getImageForMapping(mapping);
        
        CommandContributionItem item = new CommandContributionItem(commandParameter);
        item.setVisible(true);
        
        List<IMenuManager> registeredSubMenus = new LinkedList<IMenuManager>();
        IRefactoringSubMenuRegistry subMenuRegistry = IRefactoringSubMenuRegistry.INSTANCE;
		IMenuManager subMenu = subMenuRegistry.getSubMenuForRoleMapping(mapping);
		if(subMenu == null){
			rootMenu.add(item);
		} else {
			subMenu.removeAll();
			List<IMenuManager> subMenuPath = subMenuRegistry.getSubMenuPathForRoleMapping(mapping);
			IMenuManager parent = rootMenu;
			for (IMenuManager singleSubMenu : subMenuPath) {
				if(!registeredSubMenus.contains(singleSubMenu)){
					parent.add(singleSubMenu);
					registeredSubMenus.add(singleSubMenu);
				}
				parent = singleSubMenu;
			}
			parent.add(item);
		}
	}

	private Map<String, RoleMapping> getRoleMappingsForResource(Resource resource){
		EObject root = resource.getContents().get(0);
		String mmUri = root.eClass().getEPackage().getNsURI();
		Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(mmUri);
		return roleMappings;
	}
	
	private List<EObject> getElementsByUris(Resource resource, List<EObject> originalElements){
		if(originalElements != null & resource != null){
			ResourceSet rs = resource.getResourceSet();
			List<EObject> elements = new ArrayList<EObject>();
			for (EObject element : originalElements) {
				URI uri = EcoreUtil.getURI(element);
				boolean platform = uri.isPlatform();
				EObject realElement = null;
				if(platform){
					realElement = rs.getEObject(uri, true);
				} else {
					String fragmentUri = uri.toString().substring(2);
					realElement = resource.getEObject(fragmentUri);
				}
				if(realElement != null){
					elements.add(realElement);
				} else if(element != null){
					String fragment = uri.fragment();
					realElement = resource.getEObject(fragment);
					elements.add(element);
				}
			}
			return elements;
		}
		return null;
	}
}
