package dk.itu.sdg.language.coral.resource.coral.ui.model

import org.eclipse.core.resources.IMarker
import org.eclipse.emf.ecore.EObject

class Relation {
	
	def EObject leftElement
	def EObject rightElement
	
	def int leftLineNumber
	def int rightLineNumber
	
	def IMarker leftMarker
	def IMarker rightMarker
	
	def String type
	
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Relation) {
			Relation otherRelation = (Relation) arg0
			
			//TODO: hier geht was schief!!!!
			if (this.leftElement.eClass().equals(otherRelation.leftElement.eClass()) &&
				this.rightElement.eClass().equals(otherRelation.rightElement.eClass())
			) {
			
				if (this.leftMarker.getAttribute(IMarker.LINE_NUMBER) == otherRelation.leftMarker.getAttribute(IMarker.LINE_NUMBER) &&
					this.rightMarker.getAttribute(IMarker.MESSAGE) == otherRelation.rightMarker.getAttribute(IMarker.MESSAGE)) {
					
					if (this.type.equals(otherRelation.type)) {
						return true
					}
				}
			}
		}
		return false
	}
	
}
