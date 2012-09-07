package dk.itu.sdg.language.coral.resource.coral.ui.providers

import org.eclipse.jface.viewers.StyledCellLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.ui.ISharedImages
import org.eclipse.ui.PlatformUI

import dk.itu.sdg.language.coral.checker.VisualCoralRelationTypes;
import dk.itu.sdg.language.coral.resource.coral.ui.CoralUIPlugin
import dk.itu.sdg.language.coral.resource.coral.ui.model.FilePair
import dk.itu.sdg.language.coral.resource.coral.ui.model.Relation

class CoralRelationLabelProvider extends StyledCellLabelProvider {

	@Override
	public void update(ViewerCell cell) {
		
		def Object element = cell.getElement()
		def StyledString text = new StyledString()

		if (element instanceof FilePair) {
			FilePair filePair = (FilePair) element
			text.append(filePair.fileA.replace("platform:/resource/", "") + "  -  " + filePair.fileB.replace("platform:/resource/", ""), StyledString.QUALIFIER_STYLER)
			text.append(" (" + filePair.relations.size() + ")", StyledString.DECORATIONS_STYLER)
			
			cell.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE));
		} else {
			Relation relation = (Relation) element;
			
			def String leftNameLong = relation.leftElement.getClass().getName()
			def String rightNameLong = relation.rightElement.getClass().getName()
			
			def String leftName = leftNameLong.substring(leftNameLong.lastIndexOf(".") + 1, leftNameLong.length())
			def String rightName = rightNameLong.substring(rightNameLong.lastIndexOf(".") + 1, rightNameLong.length())
			
			text.append(leftName + " [line: " + relation.leftLineNumber + "]" + " - " + rightName + " [line: " + relation.rightLineNumber + "]")
			text.append(" (" + relation.type + ")", StyledString.DECORATIONS_STYLER)
			
			//TODO set image according to relation type
//			CoralUIPlugin.getImage("icons/directed_key_dsr.png")
			
			if (relation.type.equals(VisualCoralRelationTypes.DIRECTED_DSR.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/directed_key_dsr.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.DIRECTED_FIXED.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/directed_key_fixed.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.DIRECTED_FREE.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/directed_key_free.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.DIRECTED_STRINGTRANSFORM.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/directed_key_strtr.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.UNDIRECTED_DSR.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/undirected_dsr.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.UNDIRECTED_FIXED.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/undirected_fixed.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.UNDIRECTED_FREE.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/undirected_free.png"))
			} else if (relation.type.equals(VisualCoralRelationTypes.UNDIRECTED_STRINGTRANSFORM.toString())) {
				cell.setImage(CoralUIPlugin.getImage("icons/undirected_strtr.png"))
			}
			
			
//			cell.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE))
		}
		cell.setText(text.toString());
		cell.setStyleRanges(text.getStyleRanges());
		super.update(cell);
	}
	
}
