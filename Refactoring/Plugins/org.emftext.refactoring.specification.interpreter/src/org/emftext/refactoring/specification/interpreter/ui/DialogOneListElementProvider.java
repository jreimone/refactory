/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;

/**
 * This {@link IValueProvider value provider} provides one element of a list within a dialog.
 * 
 * @author Jan Reimann
 *
 */
public class DialogOneListElementProvider extends AbstractValueProvider<List<EObject>, EObject>{

	private Mapping mapping;
	private int returnCode;
	private IRefactoringFakeInterpreter fakeInterpreter;
	private EObject value;
	private List<EObject> fakeElements;
	private List<EObject> realElements;
	private List<EObject> elements;
	private String name;
	private FilteredEObjectsSelectionDialog dialog;

	public DialogOneListElementProvider(String name, Mapping mapping){
		this.mapping = mapping;
		this.name = name;
	}

	public void provideValue(){
		realElements = new LinkedList<EObject>();
		for (EObject fakeElement : fakeElements) {
			realElements.add(getInverseCopier().get(fakeElement));
		}
		elements = realElements;
		elements = new ArrayList<EObject>(getCopier().keySet());
		initDialog();
	}

	public Composite getProvidingComposite(){
		return dialog.getComposite();
	}
	
	private void initDialog() {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		dialog = new FilteredEObjectsSelectionDialog(shell, elements, getName());
	}
	
	private EObject openDialog() {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		dialog = new FilteredEObjectsSelectionDialog(shell, elements, getName());

		returnCode = dialog.open();
		if(returnCode == FilteredItemsSelectionDialog.CANCEL) {
			value = null;
		}
		EObject selectedElement = (EObject) dialog.getFirstResult();
		return selectedElement;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider#provideValue(java.util.List)
	 */
	public EObject provideValue(IRefactoringInterpreter interpreter, List<EObject> elements, Object... context) {
		if(interpreter instanceof IRefactoringFakeInterpreter){
			fakeInterpreter = (IRefactoringFakeInterpreter) interpreter;
			fakeInterpreter.addValueProvider(this);
			this.elements = elements;
			this.fakeElements = elements;
			return elements.get(0);
		} else {
			if(value != null){
				return value;
			} else {
				this.elements = elements;
				value = openDialog();
				return value;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IValueProvider#getReturnCode()
	 */
	public int getReturnCode() {
		return returnCode;
	}

	public Object getFakeObject() {
		return fakeElements;
	}

	public String getName() {
		return name;
	}

	@Override
	public EObject getValue() {
		value = dialog.getSelectedObject();
		return value;
	}

	public void propagateValueToFakeObject() {
		if(value != null){
			
		}
	}

}
