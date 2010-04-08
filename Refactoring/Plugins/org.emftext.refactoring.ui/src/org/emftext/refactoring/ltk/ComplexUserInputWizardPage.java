/**
 * 
 */
package org.emftext.refactoring.ltk;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
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
		propagateInputs();
		return super.performFinish();
	}

	private void propagateInputs() {
		valueProvider.getValue();
		valueProvider.propagateValueToFakeObject();
	}
	
	@Override
	public IWizardPage getNextPage() {
		propagateInputs();
		return super.getNextPage();
	}

//	@Override
//	public boolean isPageComplete() {
//		boolean allValuesValid = true;
//		for (Text text : textMap.keySet()) {
//			String input = text.getText();
//			IAttributeValueProvider valueProvider = textMap.get(text);
//			allValuesValid = allValuesValid && valueProvider.isValueValid(input) && !"".equals(input);
//		}
//		return allValuesValid;
//	}
//
//	private void setPageComplete(){
//		setPageComplete(isPageComplete());
//	}
}
