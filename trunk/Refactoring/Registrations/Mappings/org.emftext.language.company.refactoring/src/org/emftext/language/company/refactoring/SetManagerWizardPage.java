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
