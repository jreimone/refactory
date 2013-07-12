package org.emftext.refactoring.ltk;

import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.structuremergeviewer.Differencer;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.compare.structuremergeviewer.ICompareInputChangeListener;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class ModelRefactoringCompareInput implements ICompareInput {

	private Comparison comparison;
	private ModelRefactoringChange change;
	private AdapterFactoryLabelProvider labelProvider;

	public ModelRefactoringCompareInput(Comparison comparison, ModelRefactoringChange change) {
		this.comparison = comparison;
		this.change = change;
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
	}

	@Override
	public String getName() {
		if(change != null){
			return change.getName();
		}
		return null;
	}

	@Override
	public Image getImage() {
		if(change != null){
			RoleMapping roleMapping = change.getRefactorer().getRoleMapping();
			ImageDescriptor imageDescriptor = IRoleMappingRegistry.INSTANCE.getImageForMapping(roleMapping);
			return imageDescriptor.createImage();
		}
		return null;
	}

	@Override
	public int getKind() {
		return Differencer.CHANGE;
	}

	@Override
	public ITypedElement getAncestor() {
		return null;
	}

	@Override
	public ITypedElement getLeft() {
		if(change != null){
			return new ITypedElement() {

				@Override
				public String getType() {
					return change.getRefactorer().getOriginalModel().eClass().getName();
				}

				@Override
				public String getName() {
					return labelProvider.getText(change.getRefactorer().getOriginalModel());
				}

				@Override
				public Image getImage() {
					return labelProvider.getImage(change.getRefactorer().getOriginalModel());
				}
			};
		}
		return null;
	}

	@Override
	public ITypedElement getRight() {
		if(change != null){
			return new ITypedElement() {

				@Override
				public String getType() {
					return change.getRefactorer().getFakeRefactoredModel().eClass().getName();
				}

				@Override
				public String getName() {
					return labelProvider.getText(change.getRefactorer().getFakeRefactoredModel());
				}

				@Override
				public Image getImage() {
					return labelProvider.getImage(change.getRefactorer().getFakeRefactoredModel());
				}
			};
		}
		return null;
	}

	@Override
	public void addCompareInputChangeListener(ICompareInputChangeListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeCompareInputChangeListener(ICompareInputChangeListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void copy(boolean leftToRight) {
		// TODO Auto-generated method stub
	}

}
