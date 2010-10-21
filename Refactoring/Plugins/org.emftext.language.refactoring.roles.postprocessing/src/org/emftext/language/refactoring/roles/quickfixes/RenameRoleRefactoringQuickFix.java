package org.emftext.language.refactoring.roles.quickfixes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextQuickFix;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorExtensionPoint;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ui.RefactoringAction;
import org.emftext.refactoring.util.RegistryUtil;

public class RenameRoleRefactoringQuickFix extends RolestextQuickFix {

	private IRefactorer refactorer;
	private Role secondRole;
	private String originalName;
	private RoleMapping mapping;

	public RenameRoleRefactoringQuickFix(RoleMapping mapping, Role roleToBeRefactored, Role secondRole, String originalName, IRefactorer refactorer){
		super("Refactor: Rename other role", null, roleToBeRefactored);
		this.secondRole = secondRole;
		this.refactorer = refactorer;
		this.originalName = originalName;
		this.mapping = mapping;
	}

	@Override
	public void applyChanges() {
		System.out.println("RenameRoleRefactoringQuickFix.applyChanges()");
		IEditorConnector connector = determineEditorConnector();
		RefactoringAction action = new RefactoringAction(mapping, refactorer, connector);
		action.run();
		secondRole.setName(originalName);
	}

	private IEditorConnector determineEditorConnector(){
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IEditorConnectorExtensionPoint.ID);
		List<IEditorConnector> editorConnectors = new ArrayList<IEditorConnector>();
		for (IConfigurationElement element : elements) {
			try {
				IEditorConnector connector = (IEditorConnector) element.createExecutableExtension(IEditorConnectorExtensionPoint.CONNECTOR_ATTRIBUTE);
				editorConnectors.add(connector);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		for (IEditorConnector connector : editorConnectors) {
			if(connector.canHandle(activeEditor)){
				return connector;
			}
		}
		return null;
	}
}
