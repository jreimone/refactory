package dk.itu.sdg.language.coral.checker.ui

import java.util.Set;

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;

import dk.itu.sdg.language.coral.checker.VisualCoralRelation;
import dk.itu.sdg.language.coral.checker.VisualCoralRelationTypes;

class MarkerGenerator {
	
	public static void createMarkers(IResource fstIResource, IResource sndIResource, Resource fstResource, Resource sndResource, Set<VisualCoralRelation> relations) {
		
		for (coralRelation in relations) {
			
			def fstStart = fstResource.locationMap.getCharStart(coralRelation.leftHand) 
			def fstEnd = fstResource.locationMap.getCharEnd(coralRelation.leftHand) + 1
			def fstLineNumber = fstResource.locationMap.getLine(coralRelation.leftHand)
			
			def sndStart = sndResource.locationMap.getCharStart(coralRelation.rightHand)
			def sndEnd = sndResource.locationMap.getCharEnd(coralRelation.rightHand) + 1
			def sndLineNumber = sndResource.locationMap.getLine(coralRelation.rightHand)
			
			if(fstLineNumber == -1 && sndLineNumber == -1) {
				fstStart = fstResource.locationMap.getCharStart(coralRelation.rightHand)
				fstEnd = fstResource.locationMap.getCharEnd(coralRelation.rightHand) + 1
				fstLineNumber = fstResource.locationMap.getLine(coralRelation.rightHand)
				
				sndStart = sndResource.locationMap.getCharStart(coralRelation.leftHand)
				sndEnd = sndResource.locationMap.getCharEnd(coralRelation.leftHand) + 1
				sndLineNumber = sndResource.locationMap.getLine(coralRelation.leftHand)
			}
			
			
			
			
			def IMarker left_marker
			def	IMarker right_marker
			
			if (coralRelation.type.equals(VisualCoralRelationTypes.DIRECTED_FIXED)) {
							
				//TODO: check if the references and keys are really set correctly
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_fixed_key")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_fixed_ref")
			
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.DIRECTED_FREE)) {
			
				//TODO: check if the references and keys are really set correctly
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_free_key")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_free_ref")
				
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.DIRECTED_STRINGTRANSFORM)) {
			
				//TODO: check if the references and keys are really set correctly
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_strtr_key")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_strtr_ref")
				
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.DIRECTED_DSR)) {
			
				//TODO: check if the references and keys are really set correctly
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_dsr_key")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.directed_dsr_ref")
				
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.UNDIRECTED_STRINGTRANSFORM)) {
			
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_strtr")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_strtr")
				
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.UNDIRECTED_FREE)) {
			
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_free")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_free")
				
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.UNDIRECTED_FIXED)) {
			
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_fixed")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_fixed")
				
			} else if (coralRelation.type.equals(VisualCoralRelationTypes.UNDIRECTED_DSR)) {
			
				left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_dsr")
				right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.undirected_dsr")
			
			}
			
			
			left_marker.setAttribute(IMarker.MESSAGE, coralRelation.message + " -> " + sndIResource.projectRelativePath.toString() + " [line:" + sndLineNumber + "]")				
			
			if (coralRelation.severity.equals("info")) {
				left_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)
				right_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)
			} else if (coralRelation.severity.equals("warning")) {
				left_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING)
				right_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING)
			} else if (coralRelation.severity.equals("error")) {
				left_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)
				right_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)
			} 
			
			left_marker.setAttribute(IMarker.CHAR_START, fstStart)
			left_marker.setAttribute(IMarker.CHAR_END, fstEnd)
			left_marker.setAttribute(IMarker.LINE_NUMBER, fstLineNumber)
							
			right_marker.setAttribute(IMarker.MESSAGE, coralRelation.message + " -> " + fstIResource.projectRelativePath.toString() + " [line:" + fstLineNumber + "]")
			right_marker.setAttribute(IMarker.CHAR_START, sndStart)
			right_marker.setAttribute(IMarker.CHAR_END, sndEnd)
			right_marker.setAttribute(IMarker.LINE_NUMBER, sndLineNumber)
			
			coralRelation.leftMarker = left_marker
			coralRelation.rightMarker = right_marker
			
			MarkerMap.addMapping(left_marker, right_marker)
			MarkerMap.addRelationMapping(left_marker, right_marker, coralRelation)
		}
	}

	public static void createBrokenRelationMarkers(IResource fstIResource, IResource sndIResource, VisualCoralRelation relation) {
					
		def IMarker left_marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.broken_relation")
		def	IMarker right_marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.broken_relation")
		
//		left_marker.setAttribute(IMarker.MESSAGE, coralRelation.message + " -> " + sndIResource.projectRelativePath.toString() + " [line:" + sndLineNumber + "]")
		left_marker.setAttribute(IMarker.MESSAGE, "Broken Relation...")
		right_marker.setAttribute(IMarker.MESSAGE, "Broken Relation...")
		
		left_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)
		right_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)

			
		left_marker.setAttribute(IMarker.CHAR_START, relation.leftMarker.getAttribute(IMarker.CHAR_START))
		left_marker.setAttribute(IMarker.CHAR_END, relation.leftMarker.getAttribute(IMarker.CHAR_END))
		left_marker.setAttribute(IMarker.LINE_NUMBER, relation.leftMarker.getAttribute(IMarker.LINE_NUMBER))
							
		
		right_marker.setAttribute(IMarker.CHAR_START, relation.rightMarker.getAttribute(IMarker.CHAR_START))
		right_marker.setAttribute(IMarker.CHAR_END, relation.rightMarker.getAttribute(IMarker.CHAR_END))
		right_marker.setAttribute(IMarker.LINE_NUMBER, relation.rightMarker.getAttribute(IMarker.LINE_NUMBER))
			
		relation.leftBrokenRelMarker = left_marker
		relation.rightBrokenRelMarker = right_marker
	}
	
	public static void createDanglingRelationMarkers(IMarker marker, IMarker marker2, VisualCoralRelation relation) {
		
		def IMarker left_marker = marker.getResource().createMarker("dk.itu.sdg.language.coral.checker.broken_relation")
		def	IMarker right_marker = marker2.getResource().createMarker("dk.itu.sdg.language.coral.checker.broken_relation")
		
		//		left_marker.setAttribute(IMarker.MESSAGE, coralRelation.message + " -> " + sndIResource.projectRelativePath.toString() + " [line:" + sndLineNumber + "]")
		left_marker.setAttribute(IMarker.MESSAGE, "You created dangling references in file " + marker2.getResource().getLocation().toString())
		right_marker.setAttribute(IMarker.MESSAGE, "You deleted refered elements in file " + marker.getResource().getLocation().toString())
		
		left_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)
		right_marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)
		
		left_marker.setAttribute(IMarker.LINE_NUMBER, 1)
						
		
		right_marker.setAttribute(IMarker.CHAR_START, marker2.getAttribute(IMarker.CHAR_START))
		right_marker.setAttribute(IMarker.CHAR_END, marker2.getAttribute(IMarker.CHAR_END))
		right_marker.setAttribute(IMarker.LINE_NUMBER, marker2.getAttribute(IMarker.LINE_NUMBER))
		
	}
}
