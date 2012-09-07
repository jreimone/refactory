package dk.itu.sdg.language.coral.checker

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil;

class CoralRelation {
	
	def EObject leftHandSide
	def EObject rightHandSide
	def String message = ""
	//def String severity
	def static final int GENERATED_FIXED = 1
	def static final int GENERATED_STRINGTRANSFORM = 2
	def int type
	
	CoralRelation(EObject leftHandSide, EObject rightHandSide) {
		this.leftHandSide = leftHandSide
		this.rightHandSide = rightHandSide
		this.message = ""
	}
	
	CoralRelation(EObject leftHandSide, EObject rightHandSide, String message) {
		this.leftHandSide = leftHandSide
		this.rightHandSide = rightHandSide
		this.message = message
	}
	
	CoralRelation(EObject leftHandSide, EObject rightHandSide, int stdMessage) {
		this.leftHandSide = leftHandSide
		this.rightHandSide = rightHandSide
		
		if (stdMessage == GENERATED_FIXED) {
			type = GENERATED_FIXED
			this.message = "This is a fixed relation between A and B"
		} else if (stdMessage == GENERATED_STRINGTRANSFORM) {
			type = GENERATED_STRINGTRANSFORM
			this.message = "This is a string-transformation relation between A and B"
		} else {
			this.message = ""
		}
	}
	
	CoralRelation(EObject leftHandSide, EObject rightHandSide, int stdMessage, String constraintName, Resource fstModel, Resource sndModel, EObject fstElement, EObject sndElement) {
		this.leftHandSide = leftHandSide
		this.rightHandSide = rightHandSide
		
		if (stdMessage == GENERATED_FIXED) {
			type = GENERATED_FIXED
			this.message = "[G-FR "+ constraintName + "] <- see: " + sndModel.getURI() + " lines: "
		} else if (stdMessage == GENERATED_STRINGTRANSFORM) {
			type = GENERATED_STRINGTRANSFORM
			this.message = "[G-STR "+ constraintName + "] <- see: " + sndModel.getURI() + " lines: "
		} else {
			this.message = ""
		}
	}
}
