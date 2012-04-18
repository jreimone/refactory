package org.emftext.refactoring.ui.handlers;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.specification.resource.IRefspecTextResource;
import org.emftext.language.refactoring.specification.resource.ui.RefspecEditor;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;

public class RegisterRefSpecHandler extends AbstractModelHandler<RefactoringSpecification, IRefspecTextResource, RefspecEditor> {

	@Override
	protected boolean isModelEditorInstance(IEditorPart editor) {
		return editor instanceof RefspecEditor;
	}

	@Override
	protected IRefspecTextResource getResource(RefspecEditor editor) {
		return editor.getResource();
	}

	@Override
	protected void registerModel(RefactoringSpecification model) {
		try {
			IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(model);
		} catch (RefSpecAlreadyRegisteredException e) {
			// do nothing
			e.printStackTrace();
		}
	}

	@Override
	protected RefactoringSpecification getModelFromSelection(ITextSelection selection, IRefspecTextResource resource) {
		return (RefactoringSpecification) resource.getContents().get(0);
	}

}
