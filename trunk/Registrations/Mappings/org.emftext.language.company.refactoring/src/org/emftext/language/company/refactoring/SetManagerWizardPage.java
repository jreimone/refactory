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
package org.emftext.language.company.refactoring;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.emftext.language.company.Employee;
import org.emftext.refactoring.ltk.ModelRefactoringWizardPage;
import org.emftext.refactoring.valueprovider.FilteredEObjectsSelectionDialog;

public class SetManagerWizardPage extends ModelRefactoringWizardPage {

	private List<Employee> employees;
	
	private FilteredEObjectsSelectionDialog<Employee> dialog;
	
	public SetManagerWizardPage() {
		super("Specify the employee which should become department manager");
	}

	private void initialise() {
		employees = getObjectsForRole("Extractee", Employee.class);
	}

	@Override
	protected Control doCreateControl(Composite parent) {
		initialise();
		Shell shell = getWizard().getContainer().getShell();
		if(employees != null){
			dialog = new FilteredEObjectsSelectionDialog<Employee>(parent, shell, employees, getName());
			return dialog.getComposite();
		}
		return null;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getSelectedEmployee() {
		return dialog.getSelectedObject();
	}
}
