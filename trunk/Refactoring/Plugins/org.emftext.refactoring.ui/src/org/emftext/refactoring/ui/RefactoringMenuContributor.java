package org.emftext.refactoring.ui;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

public class RefactoringMenuContributor extends ExtensionContributionFactory {

	public RefactoringMenuContributor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IAction action = new RefactoringAction();
		action.setText("Jan Refactor");
		ActionContributionItem item = new ActionContributionItem(action);
		
		additions.addContributionItem(item, null);
	}

}
