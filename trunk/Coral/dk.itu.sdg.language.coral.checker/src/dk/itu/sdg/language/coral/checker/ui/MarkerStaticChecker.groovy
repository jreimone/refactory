package dk.itu.sdg.language.coral.checker.ui


import groovy.lang.GroovyObject;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IMarkerDelta
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecore.EObject;

import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.VisualCoralRelation;
import dk.itu.sdg.language.coral.checker.handlers.Check
import dk.itu.sdg.language.coral.checker.jobs.CheckDanglingReferencesJob;
import dk.itu.sdg.language.coral.checker.jobs.CheckMarkersJob

class MarkerStaticChecker extends Check implements IResourceChangeListener {

	
	def static private MarkerStaticChecker instance
	
	static public MarkerStaticChecker getInstance() {
		if (instance == null) {
			MarkerStaticChecker.instance = new MarkerStaticChecker()
		}
		return instance
	}
	
	
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		//println "changed"
		
		
		IMarkerDelta[] deltas = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_fixed_key", false);
		IMarkerDelta[] deltas2 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_fixed_ref", false);
		IMarkerDelta[] deltas3 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_free_key", false);
		IMarkerDelta[] deltas4 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_free_ref", false);
		IMarkerDelta[] deltas5 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_strtr_key", false);
		IMarkerDelta[] deltas6 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_strtr_ref", false);
		IMarkerDelta[] deltas7 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_dsr_key", false);
		IMarkerDelta[] deltas8 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.directed_dsr_ref", false);
		IMarkerDelta[] deltas9 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.undirected_strtr", false);
		IMarkerDelta[] deltas10 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.undirected_free", false);
		IMarkerDelta[] deltas11 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.undirected_fixed", false);
		IMarkerDelta[] deltas12 = event.findMarkerDeltas("dk.itu.sdg.language.coral.checker.undirected_dsr", false);

		def  allDeltas = []
		
		allDeltas.addAll(deltas)
		allDeltas.addAll(deltas2)
		allDeltas.addAll(deltas3)
		allDeltas.addAll(deltas4)
		allDeltas.addAll(deltas5)
		allDeltas.addAll(deltas6)
		allDeltas.addAll(deltas7)
		allDeltas.addAll(deltas8)
		allDeltas.addAll(deltas9)
		allDeltas.addAll(deltas10)
		allDeltas.addAll(deltas11)
		allDeltas.addAll(deltas12)
		
		for (IMarkerDelta delta : allDeltas) {
			if (delta.getKind() == IResourceDelta.ADDED) {
			} else if (delta.getKind() == IResourceDelta.REMOVED) {
				Job checkerJob = new CheckDanglingReferencesJob(delta.getMarker(), this)
				checkerJob.schedule()
			} else if (delta.getKind() == IResourceDelta.CHANGED) {			
				Job checkerJob = new CheckMarkersJob(delta.getMarker(), this)
				checkerJob.schedule()
			}
		}		
		
	}
	
	protected Set performCheck(IProgressMonitor monitor, Class constraintClass, GReader reader, VisualCoralRelation relation) {
		
		monitor.subTask("Creating Instance...")
		monitor.worked(1)

		
		
		GroovyObject constraintObject = null
		try {
			constraintObject = (GroovyObject) constraintClass.newInstance()
		} catch (Exception e) {
			e.printStackTrace()
		}


		if (constraintObject != null) {
			
			def args = new ArrayList<EObject>()
			def boolean relationCheckResult 
			
			def marker1 = relation.getLeftMarker()
			def marker2 = relation.getRightMarker()
			
			def EObject fstElement = reader.getEmfResources().fst.locationMap.getElementsAt(marker1.getAttribute(IMarker.CHAR_START))[0]
			def EObject sndElement = reader.getEmfResources().snd.locationMap.getElementsAt(marker2.getAttribute(IMarker.CHAR_START))[0]
			
			//set pointer to newly parsed model elements to allow garbage collector to free memory
			relation.setLeftHand(fstElement)
			relation.setRightHand(sndElement)
			
			monitor.subTask("Checking constraint...")
			try {
				args.add(fstElement)
				args.add(sndElement)
				
				relationCheckResult = (Boolean)constraintObject.invokeMethod(relation.getConstraintMethod(), args.toArray())
			} catch (MissingMethodException e) {
							
				args = new ArrayList<EObject>()
				args.add(sndElement)
				args.add(fstElement)
								
				relationCheckResult = (Boolean)constraintObject.invokeMethod(relation.getConstraintMethod(), args.toArray())
			}
			
			//TODO alle broken relations marker lšschen bei change			
			if (relationCheckResult) {
				relation.setUnBroken()
			} else {
				relation.setBroken()
			}
		}
		

		monitor.worked(1)
		
		
		return null
	}

}
