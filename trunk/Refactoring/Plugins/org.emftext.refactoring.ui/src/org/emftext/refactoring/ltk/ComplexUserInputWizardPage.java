/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.emftext.refactoring.ltk;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
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
}
