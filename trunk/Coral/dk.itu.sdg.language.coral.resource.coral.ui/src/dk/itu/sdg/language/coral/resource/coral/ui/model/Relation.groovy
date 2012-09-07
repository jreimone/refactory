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
	
}
