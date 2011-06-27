package org.emftext.refactoring.ui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
		IEditorConnector editoConnector = null;
		if (selectedElements == null || selectedElements.size() == 0) {
			activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			editoConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
			if(editoConnector != null){
				selectedElements = editoConnector.handleSelection(selection);
				if (selectedElements != null && selectedElements.size() >= 1) {
					transactionalEditingDomain = editoConnector.getTransactionalEditingDomain();
				}
			}
		}
		if (selectedElements != null && selectedElements.size() >= 1) {
			EObject first = selectedElements.get(0);
			EcoreUtil.resolveAll(first);
			Resource resource = first.eResource();
			if (resource == null) {
				return;
			}
			IMenuManager rootMenu = new MenuManager(CONTEXT_MENU_ENTRY_TEXT, IRefactoringSubMenuRegistry.CONTEXT_MENU_ENTRY_ID);
			
			IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
			if (refactorer != null) {
				refactorer.setInput(selectedElements);
				List<RoleMapping> mappings = refactorer.getPossibleRoleMappings(1.0);
				boolean containsEntries = false;
				List<IMenuManager> registeredSubMenus = new LinkedList<IMenuManager>();
				for (RoleMapping mapping : mappings) {
					Resource mappingResource = mapping.eResource();
					if (mappingResource != null && (mappingResource.getErrors() == null || mappingResource.getErrors().size() == 0)) {
						RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(mapping.getMappedRoleModel());
						if (refSpec != null) {
							String refactoringName = StringUtil.convertCamelCaseToWords(mapping.getName());
							Action refactoringAction = null;
							if (transactionalEditingDomain == null) {
								refactoringAction = new RefactoringAction(mapping, refactorer, editoConnector);
							} else {
								refactoringAction = new RefactoringAction(mapping, refactorer, transactionalEditingDomain, activeEditor, editoConnector);
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
					}
				}
				if (containsEntries) {
					additions.addContributionItem(rootMenu, null);
				}
			} else {
				RegistryUtil.log("no rolemappings registered for " + resource.getContents().get(0).eClass().getEPackage().getNsURI(), IStatus.WARNING);
			}
		}
	}

}
