package dk.itu.sdg.language.coral.checker

import org.antlr.runtime3_4_0.CommonTokenStream;
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil;

import dk.itu.sdg.language.coral.checker.handlers.CommonSubStrings;

import java.util.Set
import java.util.Map

class PathFinder {

	def Resource fstResource, sndResource
	def String fstContent, sndContent
	def Set<Pair<String, String>> commonContents = new HashSet<String>() 
	def commonContentsWithOffsets
	def fixedRelation = [] as Set
	def stringTransformRelation = [] as Set
	
		
	public Set<Pair<String, String>> findCommonContents(Resource fstResource, Resource sndResource, CommonStrings commonStrings) {
				
		for (common in commonStrings) {
			def startA = common.positionInFileA.fst
			def endA = common.positionInFileA.snd

			def startB = common.positionInFileB.fst
			def endB = common.positionInFileB.snd
			//This works only for EMFText Resources
			def fstCandidateElements = fstResource.locationMap.getElementsAt(startA)			
			def sndCandidateElements = sndResource.locationMap.getElementsAt(startB)
			
			
			def fstCandidateElement = fstCandidateElements[0]
			def sndCandidateElement = sndCandidateElements[0]
						
			
			if (fstCandidateElement != null && sndCandidateElement != null) {
				
				def EList<EAttribute> fstAttributes = fstCandidateElement.eClass().getEAllAttributes();
				def EList<EAttribute> sndAttributes = sndCandidateElement.eClass().getEAllAttributes();			
				
				def commonStringLow = common.commonString.toString().toLowerCase()
				
				for(fstAttr in fstAttributes) {

					def fstCandidate = fstCandidateElement.eGet(fstAttr)
					def fstCandidateString = fstCandidate.toString()
					def fstCandidateStringLow = fstCandidateString.toLowerCase()
					
					if (fstCandidateStringLow.contains(commonStringLow)) {
						for(sndAttr in sndAttributes) {
							
							def sndCandidate = sndCandidateElement.eGet(sndAttr)
							def sndCandidateString = sndCandidate.toString()
							def sndCandidateStringLow = sndCandidateString.toLowerCase()
							
							if (sndCandidateStringLow.contains(commonStringLow)) {
								
								if (fstCandidateStringLow.contains(sndCandidateStringLow) || sndCandidateStringLow.contains(fstCandidateStringLow)) {									
									
									//TODO: THIS is a hack which will not include all elements which are stored as collection
									//CHeck how to get the string representation of it again!!!
									if (!(fstCandidate instanceof Collection) && !(sndCandidate instanceof Collection)) {
									
										def candidatePair = new Pair<String, String>(fstCandidateString, sndCandidateString)
										commonContents.add(candidatePair)
										
									}
									
//									println common
//									println (fstCandidateString + " <--> " + sndCandidateString)
//									println "------------"
								}
							}
						}
					}
				}
			}
		}
		
		return commonContents
	}
	
	public Set<Pair<Pair,Pair>> findCommonContentsOffsets(String fstFileAsString, String sndFileAsString, Set<Pair<String, String>> commonContentsPairs) {
		
		def Set<Pair<String, String>> commonContents
		
		if (commonContentsPairs == null) {
			if(this.commonContents != null) {
				commonContents = this.commonContents
			}
		} else {
			commonContents = commonContentsPairs
		}
		
		def Set commonContentsWithIndices = [] as Set
		
		for (commonContent in commonContents) {
			
			def fstIndices = findIndices(fstFileAsString, commonContent.fst)
			def sndIndices = findIndices(sndFileAsString, commonContent.snd)
			
			def fstContentWithIndices = new Pair<String, List>(commonContent.fst, fstIndices)
			def sndContentWithIndices = new Pair<String, List>(commonContent.snd, sndIndices)

			def Pair<Map, Map> contentWithIndices = new Pair<Pair, Pair>(fstContentWithIndices, sndContentWithIndices)
			commonContentsWithIndices.add(contentWithIndices)
		}
		
		commonContentsWithOffsets = commonContentsWithIndices;
		return commonContentsWithIndices
	}
	
	private List findIndices(String fileAsString, String element) {
		def lastIndex = 0
		def indexes = fileAsString.findAll(~element) { match ->
			lastIndex = fileAsString.indexOf(match, lastIndex+1)
			return lastIndex
		}
		
		return indexes
	}

	public Pair findCommonContentsElements(Resource fstResource, Resource sndResource, Set commonContentsWithOffsets) {
		
		def fstCandidateElement
		def sndCandidateElement
		def Set<Pair<String, String>> commonContentElements
		
		if (commonContentsWithOffsets == null) {
			if(this.commonContentsWithOffsets != null) {
				commonContentsWithOffsets = this.commonContentsWithOffsets
			}
		}
		
		
		fixedRelation = [] as Set
		stringTransformRelation = [] as Set
		
		for (commonContentsWithOffset in commonContentsWithOffsets) {
			def fstCommon = commonContentsWithOffset.fst
			def sndCommon = commonContentsWithOffset.snd
			
			
			for (fstIndex in fstCommon.snd) {

				fstCandidateElement = fstResource.locationMap.getElementsAt(fstIndex).get(0)				
				
			
				for (sndIndex in sndCommon.snd) {
					sndCandidateElement = sndResource.locationMap.getElementsAt(sndIndex).get(0)
				
					if(fstCommon.fst.equals(sndCommon.fst)) {
						//Fixed relation
						

						//get the name of the properties that hold the common contents
						def fstAttr = fstCandidateElement.eClass().getEAllAttributes().find {attr -> 
							fstCandidateElement.eGet(attr)?.equals(fstCommon.fst)
						}
						def sndAttr = sndCandidateElement.eClass().getEAllAttributes().find {attr ->
							sndCandidateElement.eGet(attr)?.equals(sndCommon.fst)
						}
						
						// removed commonString:fstCommon.fst, to make set smaller
						fixedRelation.add([fstTypeName:fstCandidateElement.getClass().getName(), fstAttrName:fstAttr.getName(), sndTypeName:sndCandidateElement.getClass().getName(), sndAttrName:sndAttr.getName()])
					} else {
						//String-transformation relation
						
						//get the name of the properties that hold the common contents
						def fstAttr = fstCandidateElement.eClass().getEAllAttributes().find {attr -> 
							def fstCandidate = fstCandidateElement.eGet(attr)
							if (!(fstCandidate instanceof Collection) && (fstCandidate != null)) {
								fstCandidate.toLowerCase().contains(fstCommon.fst.toLowerCase())
							}
						}
						def sndAttr = sndCandidateElement.eClass().getEAllAttributes().find {attr ->
							def sndCandidate = sndCandidateElement.eGet(attr)
							if (!(sndCandidate instanceof Collection) && (sndCandidate != null)) {
								sndCandidate.toLowerCase().contains(sndCommon.fst.toLowerCase())
							}
						}

						def CommonSubStrings commonsSub = new CommonSubStrings();
						def CommonString common = commonsSub.longestSubstring(fstCommon.fst, sndCommon.fst);
						def commonContent = common.commonString
						
						//TODO: Differenzen rein füttern und nicht was gleich ist. Sonst hat man viele checks für ähnliche generiert 
						stringTransformRelation.add([common:commonContent, fstTypeName:fstCandidateElement.getClass().getName(), fstAttrName:fstAttr?.getName(), sndTypeName:sndCandidateElement.getClass().getName(), sndAttrName:sndAttr?.getName()])
					}
				}
			}
		}
		
//		println fixedRelation
//		println "------------"
//		println stringTransformRelation
		return new Pair(fixedRelation,stringTransformRelation)
	}
	
	
}
