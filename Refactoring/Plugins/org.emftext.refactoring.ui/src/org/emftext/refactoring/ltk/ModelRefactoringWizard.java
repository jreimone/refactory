/**
 * 
 */
package org.emftext.refactoring.ltk;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoringWizard extends RefactoringWizard {

	private ModelRefactoring refactoring;

	/**
	 * @param refactoring
	 * @param flags
	 */
	public ModelRefactoringWizard(ModelRefactoring refactoring) {
		super(refactoring, refactoring.getFlags());
		this.refactoring =  refactoring;
	}
	
	@Override
	protected void addUserInputPages() {
		IRefactoringFakeInterpreter fakeInterpreter = refactoring.getFakeInterpreter();
		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValuesToProvide();
		List<IAttributeValueProvider> simpleProviders = new LinkedList<IAttributeValueProvider>();
		List<UserInputWizardPage> pages = new LinkedList<UserInputWizardPage>();
		for(IValueProvider<?, ?> valueProvider : valueProviders) {
			if(valueProvider instanceof IAttributeValueProvider){
				simpleProviders.add((IAttributeValueProvider) valueProvider);
			} else {
				pages.add(new ComplexUserInputWizardPage(valueProvider));
			}
		}
		if(simpleProviders.size() > 0){
			pages.add(0, new AttributeUserInputWizardPage(simpleProviders));
		}
		for (UserInputWizardPage userInputWizardPage : pages) {
			this.addPage(userInputWizardPage);
		}
	}

}
