package org.emftext.refactoring.ui;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorExtensionPoint;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.StringUtil;

public class RefactoringMenuContributor extends ExtensionContributionFactory {

	private static final String CONTEXT_MENU_ENTRY_TEXT = "Refactor";
	private static final String CONTEXT_MENU_ENTRY_ID = "org.emftext.refactoring.menu";

	private List<IEditorConnector> editorConnectors;
	private Map<IEditorPart, IEditorConnector> editorConnectorCache;

	public RefactoringMenuContributor() {
		editorConnectors = new LinkedList<IEditorConnector>();
		editorConnectorCache = new LinkedHashMap<IEditorPart, IEditorConnector>();
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IEditorConnectorExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			try {
				IEditorConnector connector = (IEditorConnector) element.createExecutableExtension(IEditorConnectorExtensionPoint.CONNECTOR_ATTRIBUTE);
				editorConnectors.add(connector);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (!(activePart instanceof ISaveablePart)) {
			System.out.println("Workbench Part " + activePart + " is not a saveable part");
			return;
		}
		IWorkbenchPartSite partSite = activePart.getSite();
		//		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ISelectionProvider selectionProvider = partSite.getSelectionProvider();
		if (selectionProvider == null) {
			System.out.println(activePart + " doesn't provide selections -> no context menu");
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
		TransactionalEditingDomain transactionalEditingDomain = null;
		IEditorPart activeEditor = null;
		IEditorConnector cachedConnector = null;
		if (selectedElements == null || selectedElements.size() == 0) {
			activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			cachedConnector = editorConnectorCache.get(activeEditor);
			if (cachedConnector == null) {
				for (IEditorConnector connector : editorConnectors) {
					if (connector.canHandle(activeEditor)) {
						cachedConnector = connector;
						editorConnectorCache.put(activeEditor, connector);
						break;
					}
				}
			}
			if(cachedConnector != null){
				selectedElements = cachedConnector.handleSelection(selection);
				if (selectedElements != null && selectedElements.size() >= 1) {
					transactionalEditingDomain = cachedConnector.getTransactionalEditingDomain();
				}
			}
		}
		if (selectedElements != null && selectedElements.size() >= 1) {
			EObject first = selectedElements.get(0);
			EcoreUtil.resolveAll(first);
			Resource resource = first.eResource();
			if (resource == null || (resource.getErrors() != null && resource.getErrors().size() > 0)) {
				System.out.println("resource is null or contains the following errors:");
				List<Resource.Diagnostic> errors = resource.getErrors();
				for (Resource.Diagnostic diagnostic : errors) {
					System.out.println(diagnostic.getMessage());
				}
				return;
			}
			for (EObject eObject : selectedElements) {
				System.out.println("Selected: " + eObject);
			}
			IMenuManager rootMenu = new MenuManager(CONTEXT_MENU_ENTRY_TEXT, CONTEXT_MENU_ENTRY_ID);

			IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
			System.out.println("RefactoringMenuContributor.createContributionItems() " + refactorer);
			if (refactorer != null) {
				refactorer.setInput(selectedElements);
				List<Mapping> mappings = refactorer.getPossibleMappings(1.0);
				boolean containsEntries = false;
				for (Mapping mapping : mappings) {
					Resource mappingResource = mapping.eResource();
					if (mappingResource != null && (mappingResource.getErrors() == null || mappingResource.getErrors().size() == 0)) {
						RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(mapping.getMappedRoleModel());
						if (refSpec != null) {
							String refactoringName = StringUtil.convertCamelCaseToWords(mapping.getName());
							Action refactoringAction = null;
							if (transactionalEditingDomain == null) {
								refactoringAction = new RefactoringAction(mapping, refactorer, cachedConnector);
							} else {
								refactoringAction = new RefactoringAction(mapping, refactorer, transactionalEditingDomain, activeEditor, cachedConnector);
							}
							refactoringAction.setText(refactoringName);
							refactoringAction.setImageDescriptor(IRoleMappingRegistry.INSTANCE.getImageForMapping(mapping));
							rootMenu.add(refactoringAction);
							containsEntries = true;
						}
					}
				}
				if (containsEntries) {
					additions.addContributionItem(rootMenu, null);
				}
			} else {
				System.out.println("no rolemappings registered for " + resource.getContents().get(0).eClass().getEPackage().getNsURI());
			}
		}
	}

}
