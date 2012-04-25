package dk.itu.sdg.language.coral.checker

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

class PathFinder {

	public void findPathes(Resource fstResource, Resource sndResource, CommonStrings commonStrings) {
		
		
		for (common in commonStrings) {
			def startA = common.positionInFileA.fst
			def endA = common.positionInFileA.snd
			
			//This works only for EMFText Resources
//			def fstCandidateElements = fstResource.locationMap.getElementsBetween(startA, endA)
			def fstCandidateElements = fstResource.locationMap.getElementsAt(startA)
			
			
			
			def startB = common.positionInFileB.fst
			def endB = common.positionInFileB.snd
			
			//This works only for EMFText Resources
//			def sndCandidateElements = sndResource.locationMap.getElementsBetween(startB, endB)
			def sndCandidateElements = sndResource.locationMap.getElementsAt(startB)
			
			
			println common
			
						
			def numberFstCandidates = fstCandidateElements.size
			def numberSndCandidates = sndCandidateElements.size
			
			if (numberFstCandidates > 0 && numberSndCandidates > 0) {				
				def fstLeafElements = fstCandidateElements.find({e -> ((EObject)e).eAllContents().size() == 0})
				def sndLeafElements = sndCandidateElements.find({e -> e.eAllContents().size() == 0})
				
				if (fstLeafElements != null && sndLeafElements != null) {
					for (fstLeafElement in fstLeafElements) {
						((EObject)fstLeafElement).eContents()
						println("A --> " + EcoreUtil.getURI(fstLeafElement))	
					}
					for (sndLeafElement in sndLeafElements) {
						println("B --> " +  EcoreUtil.getURI(sndLeafElement))
					}
				}
				
				
			}
		}
		
		
	}
	
	
}
