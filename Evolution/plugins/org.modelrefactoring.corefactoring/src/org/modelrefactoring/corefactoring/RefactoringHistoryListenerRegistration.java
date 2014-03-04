package org.modelrefactoring.corefactoring;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.history.IRefactoringHistoryService;

public class RefactoringHistoryListenerRegistration {

	@Execute
	public void register(IEclipseContext context){
		IRefactoringHistoryService historyService = RefactoringCore.getHistoryService();
		if(historyService != null){
			context.set(IRefactoringHistoryService.class, historyService);
			historyService.addHistoryListener(new ModelRefactoringHistoryListener());
		}
	}
}
