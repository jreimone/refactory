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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoring extends Refactoring {

//	private static final String MIN_COMPARE_VERSION = "1.2.0";
	
	private IRefactorer refactorer;
	private String name;
	private EditingDomain editingDomain;
	private IEditorPart activeEditor;
//	private RoleMapping mapping;
//	private IRefactoringFakeInterpreter fakeInterpreter;
	private IRefactoringInterpreter interpreter;

	public ModelRefactoring(IRefactorer refactorer, EditingDomain editingDomain, String name, IEditorPart activeEditor) {
		super();
		this.refactorer = refactorer;
//		this.mapping = mapping;
		this.name = name;
		this.editingDomain = editingDomain;
		this.activeEditor = activeEditor;
		
		interpreter = refactorer.getInterpreter();
		interpreter.collectValueProviders();
		refactorer.fakeRefactor();
//		doCollectValuesToProvide();
	}

//	//cseidl
//	//Only collects the values to provide, which are needed to create a proper wizard layout.
//	//Fake run is postponed until immediately before the preview page is displayed.
//	private void doCollectValuesToProvide() {
//		try{
//			ResourceSet rs = refactorer.getResource().getResourceSet();
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(rs);
//			if(domain == null){
//				domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
//			}
//			domain.getCommandStack().execute(new RecordingCommand(domain) {
//
//				@Override
//				protected void doExecute() {
//					fakeInterpreter = refactorer.collectValuesToProvide(mapping);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public RoleMapping getRoleMapping()	{
//		return mapping;
//	}
	
	public int getFlags(){
		int flags = RefactoringWizard.CHECK_INITIAL_CONDITIONS_ON_OPEN;
//		if(refactorer.getFakeRefactoredModel() == null){
//			flags |= RefactoringWizard.NO_PREVIEW_PAGE;
//		} 
		int attributeValueProviderCount = 0;
		List<IValueProvider<?, ?>> valueProviders = interpreter.getValueProviderFactory().getValuesToProvide();
//		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValuesToProvide();
		for (IValueProvider<?, ?> valueProvider : valueProviders) {
			if(valueProvider instanceof IAttributeValueProvider){
				attributeValueProviderCount++;
			}
		}
		if(valueProviders.size() == 0){
			flags |= RefactoringWizard.NO_PREVIEW_PAGE;			
			flags |= RefactoringWizard.NONE;
		} else {
//			flags |= stateDependentFromEMFCompareVersion();
			flags |= RefactoringWizard.PREVIEW_EXPAND_FIRST_NODE;
			if(attributeValueProviderCount == valueProviders.size() || valueProviders.size() == 1){
				flags |= RefactoringWizard.DIALOG_BASED_USER_INTERFACE;
			} else {
				flags |= RefactoringWizard.WIZARD_BASED_USER_INTERFACE;
			}
		}		
		return flags;
	}
	
	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		// TODO integrate post conditions here
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		// TODO integrate pre conditions here
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		ModelRefactoringChange change = new ModelRefactoringChange(this);
		return change;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the refactorer
	 */
	public IRefactorer getRefactorer() {
		return refactorer;
	}

	/**
	 * @return the diagramTransactionalEditingDomain
	 */
	public EditingDomain getDiagramTransactionalEditingDomain() {
		return editingDomain;
	}

	/**
	 * @return the activeEditor
	 */
	public IEditorPart getActiveEditor() {
		return activeEditor;
	}

	/**
	 * @return the fakeInterpreter
	 */
	public IRefactoringInterpreter getInterpreter() {
		return interpreter;
	}

//	public RoleMapping getMapping() {
//		return mapping;
//	}

}
