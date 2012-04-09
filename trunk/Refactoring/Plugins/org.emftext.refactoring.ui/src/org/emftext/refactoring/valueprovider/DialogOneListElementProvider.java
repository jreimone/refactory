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
package org.emftext.refactoring.valueprovider;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.internal.AbstractPathCreator;

/**
 * This {@link IValueProvider value provider} provides one element of a list within a dialog.
 * 
 * @author Jan Reimann
 *
 */
public class DialogOneListElementProvider extends AbstractValueProvider<List<EObject>, EObject>{

	private RoleMapping mapping;
	private int returnCode;
	private IRefactoringFakeInterpreter fakeInterpreter;
	//	private EObject value;
	private List<EObject> fakeElements;
	private List<EObject> realElements;
	private List<EObject> elements;
	//	private String name;
	private FilteredEObjectsSelectionDialog dialog;
	private AbstractPathCreator pathCreator;

	public DialogOneListElementProvider(RoleMapping mapping){
		this.mapping = mapping;
		//		this.name = name;
	}

	public void provideValue(){
		if(fakeElements != null){
			realElements = new LinkedList<EObject>();
			for (EObject fakeElement : fakeElements) {
				realElements.add(getInverseCopier().get(fakeElement));
			}
			elements = realElements;
			initDialog();
		}
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
			setValue(null);
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
			//			fakeInterpreter.addValueProvider(this);
			this.elements = elements;
			this.fakeElements = elements;
			return elements.get(0);
		} else {
			if(getValue() != null){
				return getValue();
			} else {
				this.elements = elements;
				setValue(openDialog());
				return getValue();
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


	@Override
	public EObject getValue() {
		setValue(dialog.getSelectedObject());
		return super.getValue();
	}

	public void propagateValueToFakeObject() {
		if(getValue() != null){
			EObject fakeValue = getCopier().get(getValue());
			pathCreator.createPath(fakeValue, pathCreator.getRemainingReferences(), pathCreator.getChild(), pathCreator.getIndex());
		}
	}

	@Override
	public void setFakePropagationContext(Object... context) {
		if(context != null){
			Object firstContext = context[0];
			if(firstContext instanceof AbstractPathCreator){
				pathCreator = (AbstractPathCreator) firstContext;
			}
		}
	}

}
