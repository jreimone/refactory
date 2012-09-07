package dk.itu.sdg.language.coral.resource.coral.ui.providers

import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.Viewer;

import dk.itu.sdg.language.coral.resource.coral.ui.model.FilePair;
import dk.itu.sdg.language.coral.resource.coral.ui.model.RelationModel

class CoralRelationContentProvider implements ITreeContentProvider {

	def private RelationModel model = RelationModel.getInstance()
	
	@Override
	public void dispose() {		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.model = (RelationModel) newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return this.model.filePairs.toArray()
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof FilePair) {
			FilePair filePair = (FilePair) parentElement;
			return filePair.relations.toArray();
		}
		return null
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof FilePair) {
			return true
		}
		return false
	}
	
	

}
