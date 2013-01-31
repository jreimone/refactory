package org.emftext.refactoring.smell.wizard;

import org.eclipse.jface.wizard.Wizard;

public class NewConcreteSmellWizard extends Wizard {

	public NewConcreteSmellWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
		addPage(new MetamodelPage());
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
