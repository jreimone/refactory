package dk.itu.sdg.language.coral.checker

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.core.resources.IMarker
import org.eclipse.emf.ecore.EObject

import dk.itu.sdg.language.coral.checker.ui.MarkerGenerator



class VisualCoralRelation {
	
	def String message = ""
	def String severity = ""
	def VisualCoralRelationTypes type
	
	def String fileA
	def String fileB

	def String correspondingConstraint	
	
	def EObject leftHand
	def EObject rightHand
	
	def IMarker leftMarker
	def IMarker rightMarker
	
	def IMarker leftBrokenRelMarker
	def IMarker rightBrokenRelMarker
	
	def String constraintClass
	def String constraintMethod
	
	def Boolean isBroken
	def Boolean isDangling
	
			
	VisualCoralRelation(EObject leftHand, EObject rightHand,
		String message, String severity, VisualCoralRelationTypes type,
		Resource fstModel, Resource sndModel,
		String pathToConstraint, String constraintClass, String constraintMethod) {
		
		this.leftHand = leftHand
		this.rightHand = rightHand
		
		this.message = message
		this.severity = severity
		this.type = type
		
		this.fileA = fstModel.getURI()
		this.fileB = sndModel.getURI()
	
		this.correspondingConstraint = pathToConstraint
		
		this.constraintClass = constraintClass
		this.constraintMethod = constraintMethod
		
		this.isBroken = false
	}
		
		
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof VisualCoralRelation) {
			VisualCoralRelation otherRelation = (VisualCoralRelation) obj
			
			if(this.fileA.equals(otherRelation.fileA) && this.fileB.equals(otherRelation.fileB)) {
				if(this.severity.equals(otherRelation.severity) && this.type.equals(otherRelation.type)) {
					if(this.correspondingConstraint.equals(otherRelation.correspondingConstraint)) {
						if(this.leftHand.equals(otherRelation.leftHand) && this.rightHand.equals(otherRelation.rightHand)) {
							if(this.constraintClass.equals(otherRelation.constraintClass) && this.constraintMethod.equals(otherRelation.constraintMethod)) {
								return true
							}
						}
					}
				}
			}
			
			if(this.fileA.equals(otherRelation.fileB) && this.fileB.equals(otherRelation.fileA)) {
				if(this.severity.equals(otherRelation.severity) && this.type.equals(otherRelation.type)) {
					if(this.correspondingConstraint.equals(otherRelation.correspondingConstraint)) {
						if(this.leftHand.equals(otherRelation.rightHand) && this.rightHand.equals(otherRelation.leftHand)) {
							if(this.constraintClass.equals(otherRelation.constraintClass) && this.constraintMethod.equals(otherRelation.constraintMethod)) {
								return true
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public void setBroken() {
		this.isBroken = true
		MarkerGenerator.createBrokenRelationMarkers(this.leftMarker.getResource(), this.rightMarker.getResource(), this)
	}
	
	public void setUnBroken() {
		this.isBroken = false
		
		if(this.leftBrokenRelMarker != null) {
			this.leftBrokenRelMarker.delete()
			this.leftBrokenRelMarker = null
		}
		if(this.rightBrokenRelMarker != null) {
			this.rightBrokenRelMarker.delete()
			this.rightBrokenRelMarker = null
		}
	}
	
	public void setDangling(IMarker marker) {
		this.isDangling = true
		
		def marker2 = leftMarker
		if (marker.getId() == marker2.getId()) {
			marker2 = rightMarker
		} else {
		}
		MarkerGenerator.createDanglingRelationMarkers(marker, marker2, this)
	}
	
	public void setUnDangling() {
		
		if(this.leftBrokenRelMarker != null) {
			this.leftBrokenRelMarker.delete()
			this.leftBrokenRelMarker = null
		}
		if(this.rightBrokenRelMarker != null) {
			this.rightBrokenRelMarker.delete()
			this.rightBrokenRelMarker = null
		}
		
		//just delete the relation entirely. It has to be reestablished in a new check
//		this = null
	}
}
