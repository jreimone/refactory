/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider;

/**
 * This {@link IStructuralFeatureValueProvider value provider} provides one element of a list within a dialog.
 * 
 * @author Jan Reimann
 *
 */
public class DialogOneListElementProvider implements IStructuralFeatureValueProvider {

	private EObject owner;
	private Mapping mapping;
	
	public DialogOneListElementProvider(EObject owner, Mapping mapping){
		this.owner = owner;
		this.mapping = mapping;
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider#provideValue(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@SuppressWarnings("unchecked")
	public Object provideValue(EStructuralFeature structuralFeature) {
		Object value = owner.eGet(structuralFeature);
		if(value instanceof List<?>){
			return provideValue((List<EObject>) value);
		}
		if(value instanceof EObject){
			return Arrays.asList(new EObject[]{(EObject) value});
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider#provideValue(java.util.List)
	 */
	public EObject provideValue(List<EObject> elements) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		FilteredEObjectsSelectionDialog dialog = new FilteredEObjectsSelectionDialog(shell, elements, mapping);
		dialog.setInitialPattern("**");
		int returnCode = dialog.open();
		while (returnCode == FilteredItemsSelectionDialog.CANCEL) {
			returnCode = dialog.open();
		}
		EObject selectedElement = (EObject) dialog.getFirstResult();
		return selectedElement;
	}

}
