package dk.itu.sdg.language.coral.resource.coral.mopp

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.java.members.*
import org.emftext.language.java.references.impl.StringReferenceImpl

import html.*

/*
* This class gets regenerated on every build of a coral model
*/
class GGeneratedCheck {
	
	def void checkAllRules() {
		
	}
	
	def Object checkConstraint(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
		
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
			
			if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
				org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element;
				leftHands.add(el)
			}
		}
		
		i = sndModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
			
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element;
				rightHands.add(el)
			}
		}
		
				
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next();
				
				if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
					org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element;
					leftHands.add(el)
				}
			}
			
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next();
				
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element;
					rightHands.add(el)
				}
			}
		}

		def relations = [] as Set
		
		for (left in leftHands) {
			for (right in rightHands) {
				if (sameName(left,right)) {
					println (sameName(left,right).toString() + " " + ((org.emftext.language.java.references.impl.StringReferenceImpl)left).value + " " + ((html.impl.StringValParameterImpl)right).value)
					relations.add([key:right])
				}
			}
		}
		
		return relations
	}
	
	def Boolean sameName(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {
		
		if (leftHand.value.equals(rightHand.value)) {
			return true	
		}
		return false
	}
}
