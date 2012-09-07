package dk.itu.sdg.language.coral.resource.coral.ui.model

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TreeViewer

import dk.itu.sdg.language.coral.checker.VisualCoralRelation;




class RelationModel {
	
	def List<FilePair> filePairs
	def TreeViewer viewer

	def private static RelationModel instance
	
	public RelationModel() {
		instance = this
		this.filePairs = new ArrayList<FilePair>()
	}

	public static RelationModel getInstance() {
		if (instance == null) {
			instance = new RelationModel()
		}
		return instance
	}
	
	public void addRelations(Collection thisRelations) {
		
		thisRelations.each({newRel -> 
			def pair = filePairs.find({filePair -> filePair.fileA.equals(newRel.fileA) && filePair.fileB.equals(newRel.fileB)})
			
			if (pair == null) {
				pair = new FilePair()
				pair.fileA = newRel.fileA
				pair.fileB = newRel.fileB
				
				filePairs.add(pair)
			}
				
			def relation = new Relation()
			relation.type = newRel.type.name()
			relation.leftElement = newRel.leftHand
			relation.rightElement = newRel.rightHand
			relation.leftMarker = newRel.leftMarker
			relation.rightMarker = newRel.rightMarker
			relation.leftLineNumber = relation.leftMarker.getAttribute(IMarker.LINE_NUMBER)
			relation.rightLineNumber = relation.rightMarker.getAttribute(IMarker.LINE_NUMBER)
			//TODO: set line numbers
			pair.relations.add(relation)
			
			//TODO: implement check to not duplicate relations!!!
		})
	}

}
