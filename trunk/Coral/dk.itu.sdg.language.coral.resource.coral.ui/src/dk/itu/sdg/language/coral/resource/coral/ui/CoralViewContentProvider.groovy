package dk.itu.sdg.language.coral.resource.coral.ui

import org.eclipse.core.resources.IMarker
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import dk.itu.sdg.language.coral.checker.VisualCoralRelation


class CoralViewContentProvider implements IStructuredContentProvider {
	
	class CoralViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		
		public String getColumnText(Object obj, int index) {
			
			def VisualCoralRelation visualCoralRelation = (VisualCoralRelation) obj
			def String text 
			
			if (visualCoralRelation.leftMarker != null && visualCoralRelation.rightMarker != null) {
				text = 	visualCoralRelation.type.name() + " " + visualCoralRelation.fileA + "--" + visualCoralRelation.fileB +
				" " + visualCoralRelation.leftHand.getClass().getSimpleName() + "[line: " + visualCoralRelation.leftMarker.getAttribute(IMarker.LINE_NUMBER) + "] --" 
					+ visualCoralRelation.rightHand.getClass().getSimpleName() + "[line: " + visualCoralRelation.rightMarker.getAttribute(IMarker.LINE_NUMBER) + "]"
			} else {
				text = visualCoralRelation.type.name() + " " + visualCoralRelation.fileA + "--" + visualCoralRelation.fileB +
				" " + visualCoralRelation.leftHand.getClass().getSimpleName() + "--" + visualCoralRelation.rightHand.getClass().getSimpleName()
			}
			
			return text;
		}
		
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj)
		}
		
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT)
		}
	}
	
	def private static instance
	def relations = [] as Set
	
	public CoralViewContentProvider() {
		this.instance = this
	}

	public static CoralViewContentProvider getInstance() {
		if (instance == null) {
			instance = new CoralViewContentProvider()
		}
		return instance
	}
			
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		v.refresh()
	}
		
	public void dispose() {
	}
		
	public Object[] getElements(Object parent) {
		//TODO: set visual relations here
		return relations
	}
	
	public void addRelations(Collection thisRelations) {
		relations.addAll(thisRelations)
	}
}
