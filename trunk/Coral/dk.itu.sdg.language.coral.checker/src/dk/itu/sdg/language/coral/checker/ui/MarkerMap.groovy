package dk.itu.sdg.language.coral.checker.ui

import org.eclipse.core.resources.IMarker

import dk.itu.sdg.language.coral.checker.VisualCoralRelation;

class MarkerMap {

	def static mapLeftToRight = [:]
	def static mapRightToLeft = [:]
	def static mapMarkerToRelation = [:]
	
	public static addMapping(IMarker leftMarker, IMarker rightMarker) {
		mapLeftToRight.putAt(leftMarker, rightMarker)
		mapRightToLeft.putAt(rightMarker, leftMarker)
	}
	
	public static addRelationMapping(IMarker leftMarker, IMarker rightMarker, VisualCoralRelation relation) {
		mapMarkerToRelation.putAt(leftMarker, relation)
		mapMarkerToRelation.putAt(rightMarker, relation)
	}
	
	public static IMarker getOtherSide(IMarker marker) {
		def other = mapLeftToRight.getAt(marker);
		def other2 = mapRightToLeft.getAt(marker);
		
		if (other != null) {
			return other
		} 
		return other2
	}
	
	public static VisualCoralRelation getRelation(IMarker marker) {
		return mapMarkerToRelation.getAt(marker)
	}
}
