package org.modelrefactoring.corefactoring;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptorProxy;
import org.eclipse.ltk.core.refactoring.history.IRefactoringHistoryListener;
import org.eclipse.ltk.core.refactoring.history.IRefactoringHistoryService;
import org.eclipse.ltk.core.refactoring.history.RefactoringHistoryEvent;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ltk.ModelRefactoringDescriptor;

/**
 * Listens for changes in thre refactoring history and invokes co-refactorings.
 * 
 * @author jreimann
 *
 */
public class ModelRefactoringHistoryListener implements IRefactoringHistoryListener {

	@Override
	public void historyNotification(RefactoringHistoryEvent event) {
		RefactoringDescriptorProxy descriptorProxy = event.getDescriptor();
		IRefactoringHistoryService historyService = event.getHistoryService();
		if(event.getEventType() == RefactoringHistoryEvent.PUSHED){
			historyService.connect();
			RefactoringDescriptor refactoringDescriptor = descriptorProxy.requestDescriptor(new NullProgressMonitor());
			historyService.disconnect();
			if(refactoringDescriptor != null && refactoringDescriptor instanceof ModelRefactoringDescriptor){
				ModelRefactoringDescriptor descriptor = (ModelRefactoringDescriptor) refactoringDescriptor;
				IRefactorer refactorer = descriptor.getRefactorer();
				CoRefactorerFactory factory = new CoRefactorerFactory();
				List<CoRefactorer> coRefactorers = factory.getCoRefactorers(refactorer);
				for (CoRefactorer coRefactorer : coRefactorers) {
					coRefactorer.coRefactor();
				}
			}
		}
	}

}
