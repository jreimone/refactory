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
			def fstCandidateElementsA = fstResource.locationMap.getElementsBetween(startA, endA)
			def fstCandidateElements = fstResource.locationMap.getElementsAt(startA)
			
			
			
			def startB = common.positionInFileB.fst
			def endB = common.positionInFileB.snd
			
			//This works only for EMFText Resources
			def sndCandidateElementsA = sndResource.locationMap.getElementsBetween(startB, endB)
			def sndCandidateElements = sndResource.locationMap.getElementsAt(startB)
			
			
			
			
						
			def numberFstCandidates = fstCandidateElements.size
			def numberSndCandidates = sndCandidateElements.size
			
			if (numberFstCandidates > 0 && numberSndCandidates > 0) {
				//find only leaf elements				
				def fstLeafElements = fstCandidateElements.find({e -> ((EObject)e).eAllContents().size() == 0})
				def sndLeafElements = sndCandidateElements.find({e -> e.eAllContents().size() == 0})
				
				if (fstLeafElements != null && sndLeafElements != null) {
					
					def leafStart = 0
					def leafEnd = Integer.MAX_VALUE
					for (fstLeafElement in fstLeafElements) {
						
						def intermediteLeafStart = fstResource.locationMap.getCharStart(fstLeafElement)
						def intermediteLeafEnd = fstResource.locationMap.getCharEnd(fstLeafElement)

						(intermediteLeafStart > leafStart) ?: (leafStart = intermediteLeafStart)
						(intermediteLeafEnd < leafEnd) ?: (leafEnd = intermediteLeafEnd)
					}
					def fstKey = fstResource.locationMap.getElementsBetween(leafStart, leafEnd)
					
					leafStart = 0
					leafEnd = Integer.MAX_VALUE
					for (sndLeafElement in sndLeafElements) {
						
						def intermediteLeafStart = sndResource.locationMap.getCharStart(sndLeafElement)
						def intermediteLeafEnd = sndResource.locationMap.getCharEnd(sndLeafElement)

						(intermediteLeafStart > leafStart) ?: (leafStart = intermediteLeafStart)
						(intermediteLeafEnd < leafEnd) ?: (leafEnd = intermediteLeafEnd)
					}
					def sndKey = sndResource.locationMap.getElementsBetween(leafStart, leafEnd)
				
					println (fstKey + " " + sndKey)
//					for (fstLeafElement in fstLeafElements) {
//						((EObject)fstLeafElement).eContents()
//						println("A --> " + EcoreUtil.getURI(fstLeafElement))	
//					}
//					for (sndLeafElement in sndLeafElements) {
//						println("B --> " +  EcoreUtil.getURI(sndLeafElement))
//					}
				}
				
				
			}
		}
		
		
	}
	
	
}
