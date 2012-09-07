package dk.itu.sdg.language.coral.checker.jobs

import org.eclipse.core.resources.IMarker
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job

import dk.itu.sdg.language.coral.checker.VisualCoralRelation
import dk.itu.sdg.language.coral.checker.handlers.Check
import dk.itu.sdg.language.coral.checker.ui.MarkerMap


class CheckDanglingReferencesJob extends Job {
	
	def final IMarker marker
	def Check checkHandler
	
	CheckDanglingReferencesJob(IMarker marker, Check check) {
		super("Checkinging Relations from Markers")
		this.marker = marker
		this.checkHandler = check
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {

		monitor.beginTask("Checking...", 1)
		
		
		def VisualCoralRelation relation = MarkerMap.getRelation(marker)
		
		relation.setDangling(marker)
		
		

		
		
		monitor.worked(1)
		
		
		
		
		
		
		monitor.done()
		
		return Status.OK_STATUS;
	}

}
