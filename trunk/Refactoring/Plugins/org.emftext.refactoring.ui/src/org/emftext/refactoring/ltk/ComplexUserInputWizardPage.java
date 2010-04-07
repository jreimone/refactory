/**
 * 
 */
package org.emftext.refactoring.ltk;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.emftext.refactoring.interpreter.IValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class ComplexUserInputWizardPage extends UserInputWizardPage {

	private IValueProvider<?, ?> valueProvider;
	
	/**
	 * @param name
	 */
	public ComplexUserInputWizardPage(IValueProvider<?, ?> valueProvider) {
		super(valueProvider.getName());
		this.valueProvider = valueProvider;
	}

	public void createControl(Composite parent) {
		valueProvider.provideValue();
		Composite composite= new Composite(parent, SWT.NONE);
//		composite.setLayout(new GridLayout(2, false));
//		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(parent.getFont());
		
		valueProvider.getProvidingComposite().setParent(composite);
		setControl(composite);
	}

	@Override
	protected boolean performFinish() {
		valueProvider.getValue();
		return super.performFinish();
	}

	@Override
	public IWizardPage getNextPage() {
		IWizardPage nextPage = super.getNextPage(); 
		return nextPage;
	}

}
