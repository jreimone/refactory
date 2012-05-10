package dk.itu.sdg.language.coral.checker

import java.util.Set;

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;

class MarkerGenerator {
	
	public static void createMarkers(IResource fstIResource, IResource sndIResource, Resource fstResource, Resource sndResource, Set<CoralRelation> relations) {
		
		for (coralRelation in relations) {
			
			def fstStart = fstResource.locationMap.getCharStart(coralRelation.leftHandSide);
			def fstEnd = (fstResource.locationMap.getCharEnd(coralRelation.leftHandSide) + 1)
			
			def sndStart = sndResource.locationMap.getCharStart(coralRelation.rightHandSide)
			def sndEnd = (sndResource.locationMap.getCharEnd(coralRelation.rightHandSide) + 1)
			
			
			if (coralRelation.type == CoralRelation.GENERATED_FIXED) {
				IMarker marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.generatedFixedRelation")
				marker.setAttribute(IMarker.MESSAGE, coralRelation.message + sndIResource.projectRelativePath.toString())
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)
				marker.setAttribute(IMarker.CHAR_START, fstStart)
				marker.setAttribute(IMarker.CHAR_END, fstEnd)
				//marker.setAttribute("message", coralRelation.message + sndIResource.projectRelativePath.toString());
			
				marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.generatedFixedRelation");
				marker.setAttribute(IMarker.MESSAGE, coralRelation.message + fstIResource.projectRelativePath.toString())
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)
				marker.setAttribute(IMarker.CHAR_START, sndStart)
				marker.setAttribute(IMarker.CHAR_END, sndEnd)
				//marker.setAttribute("message", coralRelation.message + fstIResource.projectRelativePath.toString());
			} else if (coralRelation.type == CoralRelation.GENERATED_STRINGTRANSFORM) {
			
				IMarker marker = fstIResource.createMarker("dk.itu.sdg.language.coral.checker.generatedStringTransformRelation");
				marker.setAttribute(IMarker.MESSAGE, coralRelation.message + sndIResource.projectRelativePath.toString())
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)
				marker.setAttribute(IMarker.CHAR_START, fstStart)
				marker.setAttribute(IMarker.CHAR_END, fstEnd)
//				marker.setAttribute("message", coralRelation.message + sndIResource.projectRelativePath.toString());
			
				marker = sndIResource.createMarker("dk.itu.sdg.language.coral.checker.generatedStringTransformRelation")
				marker.setAttribute(IMarker.MESSAGE, coralRelation.message + fstIResource.projectRelativePath.toString())
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)
				marker.setAttribute(IMarker.CHAR_START, sndStart)
				marker.setAttribute(IMarker.CHAR_END, sndEnd)
//				marker.setAttribute("message", coralRelation.message + fstIResource.projectRelativePath.toString());
			} 
		}
	}

}
