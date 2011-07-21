/**
 * 
 */
package org.emftext.refactoring.ltk;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.IModelCompareInputProvider;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.ui.RefactoringRecordingCommand;
import org.emftext.refactoring.ui.RefactoringUndoOperation;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoringChange extends Change implements IModelCompareInputProvider {

	private IRefactorer refactorer;
	private EditingDomain editingDomain;
	private ModelRefactoring modelRefactoring;
	private IEditorPart activeEditor;
	private IProgressMonitor monitor;

	private RefactoringRecordingCommand command;
	private IRefactoringStatus status;

	public ModelRefactoringChange(ModelRefactoring modelRefactoring) {
		super();
		this.modelRefactoring = modelRefactoring;
		this.refactorer = modelRefactoring.getRefactorer();
		this.editingDomain = modelRefactoring.getDiagramTransactionalEditingDomain();
		this.activeEditor = modelRefactoring.getActiveEditor();
		
		//cseidl
		//Make sure the fake refactoring is performed, once the preview page is about to be displayed.
//		doFakeRun();
	}

//	private void doFakeRun() {
//		try{
////			ResourceSet rs = refactorer.getResource().getResourceSet();
////			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(rs);
////			if(domain == null){
////				domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
////			}
////			domain.getCommandStack().execute(new RecordingCommand(domain) {
////
////				@Override
////				protected void doExecute() {
//					RoleMapping mapping = modelRefactoring.getMapping();
//					refactorer.fakeRefactor(mapping);
////				}
////			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public Object getModifiedElement() {
		return refactorer.getOriginalModel();
	}

	@Override
	public String getName() {
		return modelRefactoring.getName();
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		statusSwitch(false);
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return RefactoringStatus.create(status);
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		this.monitor = pm;
		ResourceSet rs = refactorer.getResource().getResourceSet();
		TransactionalEditingDomain domain = null;
		try {
			domain = TransactionUtil.getEditingDomain(rs);
			if (domain == null) {
				domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
			}
			CommandStack stack = domain.getCommandStack();
			command = new RefactoringRecordingCommand(domain, refactorer, activeEditor, getName());
			stack.execute(command);
			IUndoableOperation operation = new RefactoringUndoOperation(command);
			IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
			history.add(operation);
			
			status = command.getStatus();
			statusSwitch(true);
			
//			if (status.getSeverity() == IStatus.ERROR) {
//				Display display = PlatformUI.getWorkbench().getDisplay();
//				final Shell shell = display.getActiveShell();
//				display.syncExec(new Runnable()
//				{
//					public void run()
//					{
//						String title = "Refactoring Error";
//						String message = "The refactoring could not be completed because the following error occurred:\n\n" + status.getMessage();
//				
//						MessageDialog.openInformation(shell, title, message);
//					}
//				});
//			}
			
			//			statusSwitch(command, status);
		} catch (Exception e) {
			//			if(command != null && command.canUndo()){
			//				command.undo();
			//			}
			e.printStackTrace();
			status = new org.emftext.refactoring.interpreter.RefactoringStatus(IRefactoringStatus.ERROR, "Refactoring rolled back", e);
			//			Activator.getDefault().getLog().log(status);
			//			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			//			String title = "Refactoring was rolled back";
			//			String message = "Refactoring rolled back because of an unforseen error. Check out the error log";
			statusSwitch(true);
			if (domain != null && editingDomain == null) {
				domain.dispose();
			}
			return null;
			//			MessageDialog.openInformation(shell, title, message);
		}
		if (domain != null && editingDomain == null) {
			domain.dispose();
		}
		Change undoChange = new Change() {

			@Override
			public Change perform(IProgressMonitor pm) throws CoreException {
				if (command.canUndo()) {
					command.undo();
				}
				return null;
			}

			@Override
			public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
				return RefactoringStatus.create(Status.OK_STATUS);
			}

			@Override
			public void initializeValidationData(IProgressMonitor pm) {
				// TODO Auto-generated method stub
			}

			@Override
			public String getName() {
				return "Undo " + modelRefactoring.getName();
			}

			@Override
			public Object getModifiedElement() {
				return null;
			}
		};
		return undoChange;
	}

	private void statusSwitch(boolean rollback) {
		//		Shell shell;
		//		String title;
		String message;
		if (status == null) {
			status = new org.emftext.refactoring.interpreter.RefactoringStatus(IStatus.OK);
			return;
		}
		switch (status.getSeverity()) {
		case IRefactoringStatus.OK:
			break;
		case IRefactoringStatus.INFO:
			//			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			//			title = "Information";
			message = status.getMessage();
			//			MessageDialog.openInformation(shell, title, message);
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of some infos", IStatus.INFO);
			break;
		case IRefactoringStatus.WARNING:
			//			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			//			title = "Information";
			message = status.getMessage();
			//			MessageDialog.openInformation(shell, title, message);
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of some warnings", IStatus.WARNING);
			break;
		case IRefactoringStatus.CANCEL:
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of cancelation of dialog", IStatus.CANCEL);
			break;
		case IRefactoringStatus.ERROR:
			//			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			//			title = "Refactoring will be rolled back";
			message = "The refactoring will be rolled back because of the following unforseen error: \n\n";
			message += status.getMessage();
			if (status.getException() != null) {
				status.getException().printStackTrace();
				message += "\n\nCheck out the error log for further information.";
				//				Activator.getDefault().getLog().log(status);
				ResourcesPlugin.getPlugin().getLog().log(status);
			}
			status.setMessage(message);
			//			MessageDialog.openInformation(shell, title, message);
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of an error", IStatus.ERROR);
			break;
		default:
			break;
		}
		
		if (status != null && status.getSeverity() != IStatus.OK) {
			informUserAboutRefactoringStatus();
		}
		
	}

	//cseidl: Report the refactoring status to the user via an appropriate dialog.
	private void informUserAboutRefactoringStatus() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();

		display.syncExec(new Runnable() {
			public void run() {
				Shell shell = display.getActiveShell();
				String message = status.getMessage();

				switch (status.getSeverity()) {
				case IStatus.OK:
				case IStatus.INFO:
					MessageDialog.openInformation(shell, "Information", message);
					break;
				case IStatus.WARNING:
					MessageDialog.openWarning(shell, "Warning", message);
					break;
				case IStatus.ERROR:
					MessageDialog.openWarning(shell, "Error", message);
					break;
				}
			}
		});
	}
	
	/**
	 * @return the refactorer
	 */
	public IRefactorer getRefactorer() {
		return refactorer;
	}

	/**
	 * @return the monitor
	 */
	public IProgressMonitor getMonitor() {
		return monitor;
	}

	public ModelCompareInput getModelCompareInput() {
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, true);
		options.put(MatchOptions.OPTION_IGNORE_ID, false);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, false);
		//		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		MatchModel match = null;
		DiffModel diff = null;
		try {
			EObject originalModel = refactorer.getOriginalModel();
			createTemporaryResource(originalModel);
//			refactorer.fakeRefactor();
			EObject fakeRefactoredModel = refactorer.getFakeRefactoredModel();
			createTemporaryResource(fakeRefactoredModel);
			IMatchEngine engine = new RefactoringMatchEngine();
			if (originalModel != null && fakeRefactoredModel != null) {
				//				match = engine.contentMatch(originalModel, fakeRefactoredModel, options);
				match = engine.modelMatch(originalModel, fakeRefactoredModel, options);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (match != null) {
			diff = DiffService.doDiff(match, false);
			ModelCompareInput compareInput = new ModelCompareInput(match, diff);
			return compareInput;
		}
		return null;
	}

	private Resource createTemporaryResource(EObject model) {
		if(model == null){
			return null;
		}
		Resource resource = model.eResource();
		if(resource == null){
			String id = EcoreUtil.getIdentification(model);
			URI uri = URI.createURI(id);
			resource = new ResourceImpl(uri);
			resource.getContents().add(model);
		}
		return resource;
	}

}
