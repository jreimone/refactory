package dk.itu.sdg.language.coral.checker.jobs


import org.eclipse.core.resources.IMarker
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job;

import dk.itu.sdg.language.coral.checker.GReader
import dk.itu.sdg.language.coral.checker.ResourceUtil
import dk.itu.sdg.language.coral.checker.VisualCoralRelation;
import dk.itu.sdg.language.coral.checker.handlers.Check;
import dk.itu.sdg.language.coral.checker.ui.MarkerMap;

class CheckMarkersJob extends Job {

	def final IMarker marker
	def Check checkHandler
	
	CheckMarkersJob(IMarker marker, Check check) {
		super("Checking Relations from Markers")
		this.marker = marker
		this.checkHandler = check
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		
		monitor.beginTask("Checking...", 100)
		
		monitor.subTask("Reading Files... ")
		
		def VisualCoralRelation relation = MarkerMap.getRelation(marker)
		def GReader reader
		
		def marker2 = relation.getLeftMarker()
		if (this.marker.getId() == marker2.getId()) {
			marker2 = relation.getRightMarker()
			reader = new GReader(ResourceUtil.getResource(marker.getResource()), ResourceUtil.getResource(marker2.getResource()))
		} else {
			reader = new GReader(ResourceUtil.getResource(marker2.getResource()), ResourceUtil.getResource(marker.getResource()))
		}
		
		def Class constraintClass = checkHandler.loadCheckerClass(relation.getConstraintClass(), monitor)
		Set relations = checkHandler.performCheck(monitor, constraintClass, reader, relation)
		
		
		monitor.worked(1)
		
		
		
		
		
		
		monitor.done()
					
		return Status.OK_STATUS
	}

}
