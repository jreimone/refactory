package org.modelrefactoring.corefactoring;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptorProxy;
import org.eclipse.ltk.core.refactoring.history.IRefactoringHistoryListener;
import org.eclipse.ltk.core.refactoring.history.IRefactoringHistoryService;
import org.eclipse.ltk.core.refactoring.history.RefactoringHistoryEvent;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ltk.ModelRefactoringDescriptor;

public class ModelRefactoringHistoryListener implements
IRefactoringHistoryListener {

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
				
			}
		}
	}

}
