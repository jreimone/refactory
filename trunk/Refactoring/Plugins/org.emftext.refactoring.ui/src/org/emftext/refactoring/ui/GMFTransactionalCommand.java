/**
 * 
 */
package org.emftext.refactoring.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.util.RegistryUtil;

public class GMFTransactionalCommand extends AbstractTransactionalCommand {
	
	public static final String PLUGIN_ID = "org.emftext.refactoring.ui";
	
	private IRefactorer refactorer;
	private Mapping mapping;
	private IEditorPart activeEditor;
	
	GMFTransactionalCommand(TransactionalEditingDomain domain, IRefactorer refactorer, Mapping mapping, IEditorPart activeEditor) {
		super(domain, "Refactor " + mapping.getName(), null);
		this.refactorer = refactorer;
		this.mapping = mapping;
		this.activeEditor = activeEditor;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult result = null;
		IStatus status = null;
		try {
			InternalRefactoringAction action = new InternalRefactoringAction();
			EObject refactoredModel = action.refactorInternal(refactorer, mapping, activeEditor);
			if(refactoredModel == null){
				status = new Status(IStatus.ERROR, PLUGIN_ID, "Refactoring couldn't be executed");
				result = new CommandResult(status);
			} else {
				status = new Status(IStatus.OK, PLUGIN_ID, "Refactoring was successfull");
				result = new CommandResult(status, refactoredModel);
			}
		} catch (CoreException e) {
			RegistryUtil.log("An error occurred while refactoring", IStatus.ERROR, e);
		}
		return result;
	}
}