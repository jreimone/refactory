/**
 * adapted from:
 * http://stackoverflow.com/questions/4098270/how-do-i-make-an-eclipse-plugin-extension-which-displays-different-context-menu
 */

package dk.itu.sdg.language.coral.checker.ui;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.texteditor.ITextEditor;

public class MarkerContributionFactory extends ExtensionContributionFactory {

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		ITextEditor editor = (ITextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		additions.addContributionItem(new MarkerMenuContribution(editor), null);
	}
}
