/**
 * 
 */
package org.emftext.refactoring.ltk;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.compare.ui.EMFCompareUIPlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.osgi.framework.Version;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoring extends Refactoring {

	private static final String MIN_COMPARE_VERSION = "1.2.0";
	
	private IRefactorer refactorer;
	private String name;
	private EditingDomain diagramTransactionalEditingDomain;
	private IEditorPart activeEditor;
	private RoleMapping mapping;
	private IRefactoringFakeInterpreter fakeInterpreter;

	public ModelRefactoring(IRefactorer refactorer, RoleMapping mapping, EditingDomain diagramTransactionalEditingDomain, String name, IEditorPart activeEditor) {
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
		} 
		int attributeValueProvderCount = 0;
		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValuesToProvide();
		for (IValueProvider<?, ?> valueProvider : valueProviders) {
			if(valueProvider instanceof IAttributeValueProvider){
				attributeValueProvderCount++;
			}
		}
		if(valueProviders.size() == 0){
			flags |= RefactoringWizard.NO_PREVIEW_PAGE;			
			flags |= RefactoringWizard.NONE;
		} else {
//			flags |= stateDependentFromEMFCompareVersion();
			flags |= RefactoringWizard.PREVIEW_EXPAND_FIRST_NODE;
			if(attributeValueProvderCount == valueProviders.size() || valueProviders.size() == 1){
				flags |= RefactoringWizard.DIALOG_BASED_USER_INTERFACE;
			} else {
				flags |= RefactoringWizard.WIZARD_BASED_USER_INTERFACE;
			}
		}		
		return flags;
	}
	
	private int stateDependentFromEMFCompareVersion(){
		// this is needed because of the following bug:
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=316429
		// the provided patch can't be integrated into the official Helios release,
		// but in the first service release
		// until then the version check must be done
		Version currentCompareVersion= EMFCompareUIPlugin.getDefault().getBundle().getVersion();
		Version minCompareVersion = Version.parseVersion(MIN_COMPARE_VERSION);
		if(minCompareVersion.compareTo(currentCompareVersion) > 0) {
			return RefactoringWizard.NO_PREVIEW_PAGE;
		}
		return RefactoringWizard.PREVIEW_EXPAND_FIRST_NODE;
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
