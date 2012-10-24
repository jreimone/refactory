package dk.itu.sdg.language.coral.resource.coral.ui.model

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TreeViewer

import dk.itu.sdg.language.coral.checker.VisualCoralRelation;




class RelationModel {
	
	def filePairs
	def TreeViewer viewer

	def private static RelationModel instance
	
	public RelationModel() {
		instance = this
		this.filePairs = [] as Set //new ArrayList<FilePair>()
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
			
			//def alreadyIn = pair.relations.find({relation -> newRel.leftHand.class.equals(relation.leftHand.class) && newRel.rightHand.eClass.equals(relation.rightHand.eClass) && newRel.type.name().equals(relation.type.name()) && newRel.leftMarker.getAttribute(IMarker.LINE_NUMBER) == relation.leftMarker.getAttribute(IMarker.LINE_NUMBER) && newRel.rightMarker.getAttribute(IMarker.LINE_NUMBER) == relation.rightMarker.getAttribute(IMarker.LINE_NUMBER) && newRel.leftMarker.getAttribute(IMarker.MESSAGE) == relation.leftMarker.getAttribute(IMarker.MESSAGE) && newRel.rightMarker.getAttribute(IMarker.MESSAGE) == relation.rightMarker.getAttribute(IMarker.MESSAGE)})
			def alreadyIn
			
			
			if (alreadyIn == null) {
			
				def relation = new Relation()
				relation.type = newRel.type.name()
				relation.leftElement = newRel.leftHand
				relation.rightElement = newRel.rightHand
				relation.leftMarker = newRel.leftMarker
				relation.rightMarker = newRel.rightMarker
				relation.leftLineNumber = relation.leftMarker.getAttribute(IMarker.LINE_NUMBER)
				relation.rightLineNumber = relation.rightMarker.getAttribute(IMarker.LINE_NUMBER)
	
				pair.relations.add(relation)
			}
			//TODO: implement check to not duplicate relations!!!
		})
	}

}
