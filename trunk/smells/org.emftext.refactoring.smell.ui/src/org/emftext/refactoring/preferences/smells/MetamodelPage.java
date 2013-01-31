package org.emftext.refactoring.preferences.smells;

import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class MetamodelPage extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public MetamodelPage() {
		super("wizardPage");
		setTitle("Select Metamodel");
		setDescription("Select a metamodel for which a smeel should be registered");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
	}

}
