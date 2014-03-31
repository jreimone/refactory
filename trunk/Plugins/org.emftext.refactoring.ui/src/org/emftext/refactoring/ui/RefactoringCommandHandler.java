package org.emftext.refactoring.ui;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.IParameterValues;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.ltk.ModelRefactoring;
import org.emftext.refactoring.ltk.ModelRefactoringWizard;
import org.emftext.refactoring.util.StringUtil;
import org.emftext.refactoring.valueprovider.BasicValueProviderFactory;

public class RefactoringCommandHandler extends AbstractHandler {

	private IRefactorer refactorer;
	private IEditorConnector connector;
	private EditingDomain diagramTransactionalEditingDomain;
	private IEditorPart activeEditor;

	public RefactoringCommandHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		readCommandParameters(event);
		ltkRun();
		return null;
	}

	private void readCommandParameters(ExecutionEvent event) {
		IParameter[] parameters;
		try {
			parameters = event.getCommand().getParameters();
			for (IParameter parameter : parameters) {
				IParameterValues values = parameter.getValues();
				@SuppressWarnings("rawtypes")
				Map parameterValues = values.getParameterValues();
				Object instance = parameterValues.get("instance");
				if(instance instanceof IRefactorer){
					refactorer = (IRefactorer) instance;
					IValueProviderFactory factory = new BasicValueProviderFactory(refactorer);
					refactorer.setValueProviderFactory(factory);
				} else if(instance instanceof IEditorConnector){
					connector = (IEditorConnector) instance;
				} else if(instance instanceof IEditorPart){
					activeEditor = (IEditorPart) instance;
				} else if(instance instanceof EditingDomain){
					diagramTransactionalEditingDomain = (EditingDomain) instance;
				}
			}
		} catch (NotDefinedException e) {
			e.printStackTrace();
		} catch (ParameterValuesException e) {
			e.printStackTrace();
		}
	}

	private String getText() {
		return StringUtil.convertCamelCaseToWords(refactorer.getRoleMapping().getName());
	}

	private void ltkRun() {
		if(refactorer == null){
			System.err.println("Refactorer must not be null!");
			return;
		}
		//		EObject original = refactorer.getOriginalModel();
		ModelRefactoring refactoring = new ModelRefactoring(refactorer, diagramTransactionalEditingDomain, getText(), activeEditor);
		EObject fakeRefactoredModel = refactoring.getRefactorer().getFakeRefactoredModel();
		if(fakeRefactoredModel == null){
			return;
		}
		ModelRefactoringWizard wizard = new ModelRefactoringWizard(refactoring);
		wizard.setWindowTitle(refactoring.getName());
		RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(wizard);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		try {
			int result = op.run(shell, getText());
			if(connector != null){
				if (result == IDialogConstants.OK_ID) {
					IRefactoringInterpreter interpreter = refactorer.getInterpreter();
					interpreter = refactoring.getRefactorer().getInterpreter();
					Map<Role, List<URI>> roleRuntimeInstanceURIs = interpreter.getRoleRuntimeInstanceURIs();
					Map<Role, List<EObject>> resolvedRoleRuntimeInstances = postSaveRuntimeInstanceHandling(roleRuntimeInstanceURIs, refactorer.getResource().getResourceSet());
					RefactoringSpecification refSpec = interpreter.getRefactoringSpecification();
					List<EObject> objectsToSelect = new LinkedList<EObject>();
					for (Role role : resolvedRoleRuntimeInstances.keySet()) {
						List<Instruction> roleInstructions = refSpec.getInstructionsReferencingRole(role);
						for (Instruction instruction : roleInstructions) {
							if (instruction instanceof CREATE || instruction instanceof MOVE) {
								List<EObject> instance = resolvedRoleRuntimeInstances.get(role);
								objectsToSelect.addAll(instance);
							}
						}
					}
					if(objectsToSelect.isEmpty()){
						for (List<EObject> list : resolvedRoleRuntimeInstances.values()) {
							objectsToSelect.addAll(list);
						}
					}
					connector.selectEObjects(objectsToSelect);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	private Map<Role, List<EObject>> postSaveRuntimeInstanceHandling(Map<Role, List<URI>> roleRuntimeInstanceURIs, ResourceSet resourceSet) {
		Map<Role, List<EObject>> resolvedRoleRuntimeInstances = new LinkedHashMap<Role, List<EObject>>();
		for (Role role : roleRuntimeInstanceURIs.keySet()) {
			List<URI> uriList = roleRuntimeInstanceURIs.get(role);
			List<EObject> resolvedRuntimeInstances = new LinkedList<EObject>();
			for (URI uri : uriList) {
				try {
					EObject resolvedObject = resourceSet.getEObject(uri, false);
					resolvedRuntimeInstances.add(resolvedObject);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			resolvedRoleRuntimeInstances.put(role, resolvedRuntimeInstances);
		}
		return resolvedRoleRuntimeInstances;
	}
}
