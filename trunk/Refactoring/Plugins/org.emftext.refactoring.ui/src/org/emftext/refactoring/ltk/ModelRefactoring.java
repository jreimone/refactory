/**
 * 
 */
package org.emftext.refactoring.ltk;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoring extends Refactoring {

	private IRefactorer refactorer;
	private String name;
	private TransactionalEditingDomain diagramTransactionalEditingDomain;
	private IEditorPart activeEditor;
	private Mapping mapping;
	private IRefactoringFakeInterpreter fakeInterpreter;

	public ModelRefactoring(IRefactorer refactorer, Mapping mapping, TransactionalEditingDomain diagramTransactionalEditingDomain, String name, IEditorPart activeEditor) {
		super();
		this.refactorer = refactorer;
		this.mapping = mapping;
		this.name = name;
		this.diagramTransactionalEditingDomain = diagramTransactionalEditingDomain;
		this.activeEditor = activeEditor;
		doFakeRun();
	}

	private void doFakeRun(){
		try{
			ResourceSet rs = refactorer.getResource().getResourceSet();
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(rs);
			if(domain == null){
				domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
			}
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					fakeInterpreter = refactorer.fakeRefactor(mapping);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getFlags(){
		int flags = RefactoringWizard.CHECK_INITIAL_CONDITIONS_ON_OPEN;
		if(refactorer.getFakeRefactoredModel() == null){
			flags |= RefactoringWizard.NO_PREVIEW_PAGE;
		} else {
			flags |= RefactoringWizard.PREVIEW_EXPAND_FIRST_NODE;
		}
		int attributeValueProvderCount = 0;
		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValuesToProvide();
		for (IValueProvider<?, ?> valueProvider : valueProviders) {
			if(valueProvider instanceof IAttributeValueProvider){
				attributeValueProvderCount++;
			}
		}
		if(attributeValueProvderCount == valueProviders.size() || valueProviders.size() == 1){
			flags |= RefactoringWizard.DIALOG_BASED_USER_INTERFACE;
		} else {
			flags |= RefactoringWizard.WIZARD_BASED_USER_INTERFACE;
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
	public TransactionalEditingDomain getDiagramTransactionalEditingDomain() {
		return diagramTransactionalEditingDomain;
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
	public IRefactoringFakeInterpreter getFakeInterpreter() {
		return fakeInterpreter;
	}

}
