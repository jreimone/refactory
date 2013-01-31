package org.emftext.refactoring.smell.ui.preferences;

import org.eclipse.jface.wizard.Wizard;

public class NewConcreteSmellWizard extends Wizard {

	public NewConcreteSmellWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
