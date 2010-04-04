/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.emftext.language.refactoring.rolemapping.Mapping;

/**
 * @author Jan Reimann
 *
 */
public class FilteredEObjectsSelectionDialog extends FilteredItemsSelectionDialog {

	private List<EObject> elements;
	private Mapping mapping;
	
	public FilteredEObjectsSelectionDialog(Shell shell, List<EObject> elements, Mapping mapping) {
		super(shell, false);
		this.elements = elements;
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	@Override
	protected ItemsFilter createFilter() {
		ItemsFilter filter = new ItemsFilter(new SearchPattern(
//				SearchPattern.RULE_BLANK_MATCH
//				| 
				SearchPattern.RULE_CAMELCASE_MATCH
				| SearchPattern.RULE_EXACT_MATCH
				| SearchPattern.RULE_PATTERN_MATCH
				| SearchPattern.RULE_PREFIX_MATCH)) {
			
			@Override
			public boolean matchItem(Object item) {
				if(!(item instanceof EObject)){
					return false;
				}
//				String search = getPattern();
//				if("**".equals(search)){
//					return true;
//				}
				return matches(((EObject) item).toString());
			}
			
			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}
		};
		return filter;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#fillContentProvider(org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.AbstractContentProvider, org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
		progressMonitor.beginTask("Looking for elements...", elements.size());
		for (EObject element : elements) {
			contentProvider.add(element, itemsFilter);
			progressMonitor.worked(1);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getDialogSettings()
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		Resource resource = elements.get(0).eResource();
		String root = resource.getURI() + "_" + mapping.getName();
		IDialogSettings settings = new DialogSettings(root);
		return settings;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getElementName(java.lang.Object)
	 */
	@Override
	public String getElementName(Object item) {
		return ((EObject) item).toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator getItemsComparator() {
		Comparator<EObject> comparator = new Comparator<EObject>() {
			
			public int compare(EObject o1, EObject o2) {	
				EcoreItemProviderAdapterFactory factory = new EcoreItemProviderAdapterFactory();
				if(factory.isFactoryForType(IItemLabelProvider.class)){
					IItemLabelProvider labelProvider1 = (IItemLabelProvider) factory.adapt(o1, IItemLabelProvider.class);
					IItemLabelProvider labelProvider2 = (IItemLabelProvider) factory.adapt(o2, IItemLabelProvider.class);
					String label1 = labelProvider1.getText(o1);
					String label2 = labelProvider2.getText(o2);
					return String.CASE_INSENSITIVE_ORDER.compare(label1, label2);
				}
				return 1;
			}
		};
		return comparator;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
//		IStatus status = new Status(IStatus.OK, "org.emftext.refactoring.specification.interpreter", "");
//		return status;
	}

}
